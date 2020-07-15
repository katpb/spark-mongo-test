/*
 * POSPrinterExt.java
 *
 * Copyright (C) 2000-2009 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * History:
 *   Date             Action                                   User
 *   Jul 17, 2009     Creation                                 Joe_H5
 */

package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.vsms2.sys.util.image.ImageUtility;
import com.verifone.isd.vsms2.sys.util.image.bmp.BMPImageIO;
import com.verifone.isd.vsms2.sys.util.image.tiff.Tiff;
import java.awt.Image;
import java.io.*;
import jpos.JposConst;
import jpos.JposException;
import jpos.POSPrinter;
import jpos.POSPrinterConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class extends the <code>jpos.POSPrinter</code> to support printing
 * of TIFF encoded images.  The two bitmap printing methods,
 * {@link #printBitmap(int, java.lang.String, int, int)}
 * and
 * {@link #printMemoryBitmap(int, byte[], int, int, int)}
 * will convert TIFF images to BMP format image data sets and then call the
 * super class' coresponding methods.  This is done because the JPOS specification
 * does not implicitly support TIFF image formats.
 * <p>
 * Promotion to use the new UPOS v1.10 standard and the
 * {@link #printMemoryBitmap(int, byte[], int, int, int)} method gives better
 * runtime performance because no files have to be created as is required when
 * using the older {@link #printBitmap(int, java.lang.String, int, int)} method.
 * <p>
 * A special note on Epson JPOS Version prior to JPOS Ver 1.10<br>
 * Current Topaz systems use Epson JPOS Service implementations based on the UPOS
 * v1.5 standard.  The {@link #printMemoryBitmap(int, byte[], int, int, int)}
 * method was introduced with UPOS v1.10 standard so the current Epson JPOS
 * v1.5 implementation does not support this method.  I have created a new
 * Epson TMT88 JPOS Printer Service that added support for memory bitmap printing.
 * The source to this new service can be found in the component at
 * <code>isdDist/topaz/jpos/jpos/extensions/Common</code>.
 * 
 */
public class POSPrinterExt extends POSPrinter
{

	private static final int IMAGE_SCALE_WIDTH = 200;
	private static final int IMAGE_SCALE_HEIGHT = 120;
    private Logger logger = LoggerFactory.getLogger(POSPrinterExt.class);
    /**
     * Reference to temporary file deletion manager.
     */
    protected TempFileManager tmpFileManager = null;

    /**
     * Condition flag to determine if &quot;memory bitmap&quot; needs to be
     * written to a file before printing.
     * <p>
     * This variable is set to true if it is determined that the JPOS service
     * version is less than 1.10 (1010000).
     */
    protected boolean createFile = false;

    /**
     *
     */
    public POSPrinterExt()
    {
        super();

        tmpFileManager = TempFileManager.getInstance();
    }

    public void open( String logicalDeviceName ) throws JposException
    {
        super.open( logicalDeviceName );

        // If JPOS Service versino is less than 1.10, then force creation
        // of bitmap file and call printBimap() to print bitmaps.
        createFile = super.serviceVersion < POSPrinter.deviceVersion110;

        StringBuffer sb = new StringBuffer();
        sb.append("POSPrintereExt.open(\"");
        sb.append(logicalDeviceName);
        sb.append("\"): Service version is ");
        sb.append(String.valueOf( super.serviceVersion ) );
        sb.append(".  'createFile=");
        sb.append(String.valueOf(createFile));
        sb.append("'.");
        logger.info(sb.toString());
    }

    /**
     * Overloaded to support TIFF formatted image files.
     * {@inheritDoc}
     */
    @Override
    public void printBitmap( int station, String fileName, int width,
                             int alignment ) throws JposException
    {
        String bitmapFileName = fileName;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try
        {
            if ( ImageUtility.getFileMediaType( fileName ) == ImageUtility.TIFF )
            {
                Image theImage = null;
                Tiff tiff = new Tiff();
                try
                {
                    fis = new FileInputStream( fileName );
                    bis = new BufferedInputStream( fis );
                    tiff.readInputStream( bis );
                    logger.info( "POSprinterExt.printBitmap(): TIFF image page count = " + tiff.getPageCount() );
                    theImage = tiff.getImage( 0 );
                } catch ( IOException ioe )
                {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File I/O read errors encountered.",
                                             ioe );
                }
                if ( theImage == null )
                {
                    throw new JposException( POSPrinterConst.JPOS_EPTR_BADFORMAT,
                                             "File is in an unsupported or unknown format." );
                }
                File tmpFile = null;
                try
                {
                    tmpFile = File.createTempFile( "tmp", ".bmp" );
                    BMPImageIO.saveImage( theImage, tmpFile.getPath() );
                    bitmapFileName = tmpFile.getPath();
                } catch ( IOException ioe )
                {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File I/O write errors encountered.",
                                             ioe );
                } finally
                {
                    if (tmpFile != null)
                    {
                        tmpFileManager.addFileName( tmpFile.getPath() );
                    }
                }
            }
        } finally
        {
            if (bis != null)
            {
                try {
                    bis.close();
                } catch (IOException ioe) { }
            }
            if (fis != null)
            {
                try {
                    fis.close();
                } catch (IOException ioe) { }
            }
        }
        super.printBitmap( station, bitmapFileName, width, alignment );
        logger.info( "POSprinterExt.printBitmap(): Sent to printer for printing: " + bitmapFileName );
    }

    /**
     * Overloaded to support TIFF formatted image byte data.
     * {@inheritDoc}
     */
    public void printMemoryBitmap(int station, byte[] data, int type, int width, int alignment) throws JposException
    {
        String fileExtension = "";
        byte[] imageData = data;
        switch(type)
        {
            case POSPrinterConst.PTR_BMT_JPEG :
            case POSPrinterConst.PTR_BMT_BMP :
            case POSPrinterConst.PTR_BMT_GIF :
                break;
            default :
                Image theImage = null;
                Tiff tiff = new Tiff();
                try
                {
                    tiff.readInputStream( new ByteArrayInputStream(data) );
                    logger.info( "POSprinterExt.printBitmap(): TIFF image page count = " + tiff.getPageCount() );
                    theImage = tiff.getImage( 0 );
                    /*
                     * This condition is used to avoid the issue like the bitmap 
                     * is too big to print without transformation.Now the signature 
                     * will be scaled if the bitmap is too wide only .So,any size of
                     *  signature will be able to print by PRINTER now.  
                     */
                    if (theImage != null && (theImage.getWidth(null) > IMAGE_SCALE_WIDTH
                    		|| theImage.getHeight(null) > IMAGE_SCALE_HEIGHT)) {
                    	int tempWidth = theImage.getWidth(null) > IMAGE_SCALE_WIDTH ? IMAGE_SCALE_WIDTH : theImage.getWidth(null);
                    	int tempHeight = theImage.getHeight(null) > IMAGE_SCALE_HEIGHT ? IMAGE_SCALE_HEIGHT : theImage.getHeight(null);
                    	theImage = theImage.getScaledInstance(tempWidth, tempHeight, Image.SCALE_SMOOTH);
                    }
                } catch ( IOException ioe ) {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File I/O read errors encountered.",
                                             ioe );
                }
                if ( theImage == null )
                {
                    throw new JposException( POSPrinterConst.JPOS_EPTR_BADFORMAT,
                                             "File is in an unsupported or unknown format." );
                }

                ByteArrayOutputStream baos = new ByteArrayOutputStream();;
                BMPImageIO.saveImage( theImage, baos );
                imageData = baos.toByteArray();
                fileExtension = ".bmp";

                if (imageData.length == 0)
                {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File is in an unsupported or unknown format." );
                }
                type = POSPrinterConst.PTR_BMT_BMP;
                break;
        }
        if (!createFile)
        {
            super.printMemoryBitmap(station, imageData, type, width, alignment);
        } else
        {
            File tmpFile = null;
            java.io.FileOutputStream fos = null;
            java.io.OutputStream fileOS = null;
            try
            {
                tmpFile = File.createTempFile( "tmp", fileExtension );
                fos = new FileOutputStream( tmpFile );
                fileOS = new BufferedOutputStream(fos);
                fileOS.write( imageData );
                fileOS.close();
                fileOS = null;
                fos.close();
                fos = null;

                super.printBitmap( station, tmpFile.getPath(), width, alignment );

            } catch ( IOException ioe )
            {
                throw new JposException( JposConst.JPOS_E_FAILURE,
                                         "File I/O write errors encountered.",
                                         ioe );
            } finally
            {
                if (fileOS != null)
                {
                    try
                    {
                        fileOS.close();
                    } catch (IOException ioe) { }
                }
                if (fos != null)
                {
                    try
                    {
                        fos.close();
                    } catch (IOException ioe) { }
                }
                if ((tmpFile != null) && (tmpFile.exists()))
                {
                    tmpFileManager.addFileName( tmpFile.getPath() );
                }
            }
        }
    }

    /**
     * Overloaded to support TIFF formatted image files.
     * {@inheritDoc}
     */
    public void setBitmap(int bitmapNumber, int station, String fileName, int width, int alignment) throws JposException
    {
        String bitmapFileName = fileName;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try
        {
            if ( ImageUtility.getFileMediaType( fileName ) == ImageUtility.TIFF )
            {
                Image theImage = null;
                Tiff tiff = new Tiff();
                try
                {
                    fis = new FileInputStream( fileName );
                    bis = new BufferedInputStream( fis );
                    tiff.readInputStream( bis );
                    logger.info( "POSprinterExt.printBitmap(): TIFF image page count = " + tiff.getPageCount() );
                    theImage = tiff.getImage( 0 );
                } catch ( IOException ioe )
                {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File I/O read errors encountered.",
                                             ioe );
                }
                if ( theImage == null )
                {
                    throw new JposException( POSPrinterConst.JPOS_EPTR_BADFORMAT,
                                             "File is in an unsupported or unknown format." );
                }
                File tmpFile = null;
                try
                {
                    tmpFile = File.createTempFile( "tmp", ".bmp" );
                    BMPImageIO.saveImage( theImage, tmpFile.getPath() );
                    bitmapFileName = tmpFile.getPath();
                } catch ( IOException ioe )
                {
                    throw new JposException( JposConst.JPOS_E_FAILURE,
                                             "File I/O write errors encountered.",
                                             ioe );
                } finally
                {
                    if (tmpFile != null)
                    {
                        tmpFileManager.addFileName( tmpFile.getPath() );
                    }
                }
            }

            super.setBitmap(bitmapNumber, station, bitmapFileName, width, alignment);

        } finally
        {
            if (bis != null)
            {
                try {
                    bis.close();
                } catch (IOException ioe) { }
            }
            if (fis != null)
            {
                try {
                    fis.close();
                } catch (IOException ioe) { }
            }
        }
    }

}

