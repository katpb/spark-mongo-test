/*
 * ImageUtility.java
 *
 * Copyright (C) 2000-2009 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * History:
 *   Date             Action                                   User
 *   Apr 28, 2009     Creation                                 Joe_H5
 */
package com.verifone.isd.vsms2.sys.util.image;

import com.verifone.isd.vsms2.sys.util.image.bmp.BmpUtils;
import com.verifone.isd.vsms2.sys.util.image.tiff.Tiff;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.net.URLConnection;

/**
 * Image file support utility and tools class supported under the J2ME profile.
 * <p>
 * Only four types of image encodings are supported - JPEG, GIF, BMP and TIFF.
 * <p>
 * JPEG and GIF encodings will be decoded by the {@link java.awt.Toolkit} image
 * creation methods.  This means that all image creation methods in this class
 * may return a <code>null</code> for a return value for any unsupported
 * image formats.
 * <p>
 * For BMP or TIFF type images, invalid encodings will not throw an exception
 * and a <code>null</code> is returned.
 * <p>
 * PLEASE CHECK RETURN VALUES FOR <code>null</code>!!!
 */
public class ImageUtility
{

    /**
     * Specifies the image creation assumes JPEG encoding.
     */
    public static final ImageUtility.ImageMediaType JPEG =
            new ImageUtility.ImageMediaType( "jpeg",
                                             "image/jpeg",
                                             new String[]
                                                    { ".jpe", ".jpg", ".jpeg" } );

    /**
     * Specifies the image creation assumes GIF encoding.
     */
    public static final ImageUtility.ImageMediaType GIF =
            new ImageUtility.ImageMediaType( "gif",
                                             "image/gif",
                                             new String[]
                                                    {  ".gif" } );

    /**
     * Specifies the image creation assumes BMP encoding.
     */
    public static final ImageUtility.ImageMediaType BMP =
            new ImageUtility.ImageMediaType( "bmp",
                                             "image/bmp",
                                             new String[]
                                                    { ".bmp" } );

    /**
     * Specifies the image creation assumes TIFF encoding.
     */
    public static final ImageUtility.ImageMediaType TIFF =
            new ImageUtility.ImageMediaType( "tiff",
                                             "image/tiff",
                                             new String[]
                                                    { ".tif", ".tiff" } );

    /**
     * Create a java.awt.Image from file of given name.
     * @param fileName The name of the file.
     * @return An AWT image instance created from a file. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException Thrown on any errors reading the file.
     */
    public static java.awt.Image createImage( String fileName ) throws java.io.IOException
    {
        return createImage( fileName, false );
    }
    /**
     * Create a java.awt.Image from file of given name. Thicken, make lines
     * thicker, if <code>thicken</code> parameter is true.
     * @param fileName The name of the file.
     * @param thicken If <code>true</code>, then make darker lines thicker.  This
     *                is subjective and may not be suitable for all images.
     * @return An AWT image instance created from a file. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException Thrown on any errors reading the file.
     */
    public static java.awt.Image createImage( String fileName, boolean thicken ) throws java.io.IOException
    {
        java.awt.Image theImage = null;

        FileInputStream fis = null;
        java.io.InputStream is = null;
        String fqn = SysPropertyFactory.makeAbsoluteDataPath(fileName);
        try {

            ImageUtility.ImageMediaType type = getFileMediaType( fileName );

            fis = new FileInputStream( fqn );
            is = new BufferedInputStream( fis );

            theImage = createImage( is, type, thicken );

        } finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                } catch (java.io.IOException ioe) { }
            }
            if (fis != null)
            {
                try
                {
                    fis.close();
                } catch (java.io.IOException ioe) { }
            }
        }

        return theImage;
    }

    /**
     * Create a java.awt.Image from given URL.
     * @param url The URL to open a connection to.
     * @return An AWT image instance created from the URL connection. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException Thrown on any errors opening or reading from
     *                             the URL connection.
     */
    public static java.awt.Image createImage( java.net.URL url ) throws java.io.IOException
    {
        return createImage( url, false );
    }
    /**
     * Create a java.awt.Image from given URL. Thicken, make lines
     * thicker, if <code>thicken</code> parameter is true.
     * @param url The URL to open a connection to.
     * @param thicken If <code>true</code>, then make darker lines thicker.  This
     *                is subjective and may not be suitable for all images.
     * @return An AWT image instance created from the URL connection. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException Thrown on any errors opening or reading from
     *                             the URL connection.
     */
    public static java.awt.Image createImage( java.net.URL url, boolean thicken ) throws java.io.IOException
    {
        java.awt.Image theImage = null;


        URLConnection connection = url.openConnection();
        connection.connect();

        String contentType = connection.getContentType();

        if (contentType.equals( BMP.mimeType ))
        {
            theImage = createImage( connection.getInputStream(), BMP, thicken);
        } else if (contentType.equals( TIFF.mimeType ))
        {
            theImage = createImage( connection.getInputStream(), TIFF, thicken);
        } else
        {
            // Assume JPEG or GIF - This ImageUtility will default to Java's AWT image creation
            theImage = createImage( connection.getInputStream(), null, thicken);
        }

        return theImage;
    }

    /**
     * Create a java.awt.Image from given InputStream.
     * @param is The input stream to read image data from.
     * @param mediaType The media type to assume input stream data is encoded to.
     *                  Use <code>null</code> to use {@link java.awt.Toolkit#createImage( byte[] )}.
     * @return An AWT image instance created from the InputStream. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException Thrown on any errors reading the input stream.
     *
     * @see java.awt.Toolkit#createImage( byte[] )
     */
    public static java.awt.Image createImage( java.io.InputStream is,
                                              ImageUtility.ImageMediaType mediaType,
                                              boolean thicken)
             throws java.io.IOException
    {
        java.awt.Image theImage = null;
        if ( mediaType == BMP )
        {
            theImage = BmpUtils.loadbitmap( is );
        } else if ( mediaType == TIFF )
        {
            Tiff tiff = new Tiff();

            tiff.readInputStream( is );

            theImage = tiff.getImage( 0 );

        } else
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while(is.available() > 0)
            {
                int len = (is.available() > 32) ? 32 : is.available();
                byte[] data = new byte[len];
                int bytesRead = is.read( data );
                baos.write( data, 0, bytesRead);
            }

            theImage = java.awt.Toolkit.getDefaultToolkit().createImage(
                    baos.toByteArray() );
        }

        if (theImage != null && thicken)
        {
            theImage = thickenImage( theImage );
        }

        return theImage;
    }

    /**
     * Create a java.awt.Image from byte data array.
     * @param imageData The raw data to construct an image with
     * @param mediaType The image encoding of given raw data.
     *                  Use <code>null</code> to use {@link java.awt.Toolkit#createImage( byte[] )}.
     * @return An AWT image instance created from the raw data. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException
     */
    public static java.awt.Image createImage( byte[] imageData,
                                              ImageUtility.ImageMediaType mediaType )
            throws java.io.IOException
    {
        return createImage( imageData, mediaType, false );
    }

    /**
     * Create a java.awt.Image from byte data array.
     * @param imageData The raw data to construct an image with
     * @param mediaType The image encoding of given raw data.
     *                  Use <code>null</code> to use {@link java.awt.Toolkit#createImage( byte[] )}.
     * @return An AWT image instance created from the raw data. Will be
     *         <code>null</code> if unable to create the image.
     * @throws java.io.IOException
     */
    public static java.awt.Image createImage( byte[] imageData,
                                              ImageUtility.ImageMediaType mediaType,
                                              boolean thicken)
            throws java.io.IOException
    {
        java.awt.Image theImage = null;

        if ( mediaType == BMP )
        {
            theImage = createImage( new ByteArrayInputStream( imageData ), mediaType, thicken );

            // Since image may have already been "thickened", no need to do it again..
            thicken = false;

        } else if ( mediaType == TIFF )
        {
            Tiff tiff = new Tiff();

            tiff.read( imageData );

            theImage = tiff.getImage( 0 );

        } else
        {
            theImage = java.awt.Toolkit.getDefaultToolkit().createImage(
                    imageData );
        }

        if (theImage != null && thicken)
        {
            theImage = thickenImage( theImage );
        }

        return theImage;
    }

    /**
     * Predict the image type of the given named file.
     * @param file The image file name.
     * @return The predicted type. Returns <code>null</code> if unable to
     *         depict image type.
     */
    public static ImageUtility.ImageMediaType getFileMediaType(String file)
    {
        ImageUtility.ImageMediaType type = null;
        String fileName = SysPropertyFactory.makeAbsoluteDataPath(file);
        if (BMP.fileIsOfType( fileName ))
        {
            type = BMP;
        } else if (TIFF.fileIsOfType( fileName ))
        {
            type = TIFF;
        } else if (GIF.fileIsOfType( fileName ))
        {
            type = GIF;
        } else if (JPEG.fileIsOfType( fileName ))
        {
            type = JPEG;
        }
        return type;
    }

    /**
     * This method attempts to &quot;thicken&quot; the black parts of an image.
     * <p>
     * Consider a 3 by 3 [0-2,0-2] section of an image.  If the center pixel
     * [1,1] is <i>somewhat</i> black, then the neighboring pixels will be set
     * to the center pixels value.
     * @param theImage The image reference to thicken.
     * @return A new image with thickened black parts.
     */
    public static java.awt.Image thickenImage(java.awt.Image theImage)
    {
        PixelGrabber pg = new PixelGrabber(theImage, 0, 0, -1, -1, true);

        boolean pixelsWereGrabbed = false;
        try {
            pixelsWereGrabbed = pg.grabPixels();
        } catch (InterruptedException iex) { }

        if (pixelsWereGrabbed)
        {
            int width = pg.getWidth();
            int height = pg.getHeight();

//            BufferedImage anImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            int[] pixelData = (int[]) pg.getPixels();
            int[] newData = new int[pixelData.length];

            int pgIdx = 0;

            for (int i = 0; i < height - 1; i++)
            {
                for (int j = 0; j < width  - 1; j++)
                {
                    widenAffineFunction( newData, pgIdx, width, pixelData[pgIdx] );

                    pgIdx++;
                }

                newData[pgIdx] = pixelData[pgIdx];
            }

            int rowIdx = (height - 1) * width;
            for (int i = 0; i < width; i++)
            {
                if ((newData[rowIdx + i] & 0xff000000) == 0)
                {
                    newData[rowIdx + i] = pixelData[rowIdx + i];
                }
            }

//            pg.setPixels( 0, 0, width, height, pg.getColorModel(), newData, 0, width);

            MemoryImageSource mis = new MemoryImageSource( width, height,
                                                           newData, 0,
                                                           width);

            theImage = Toolkit.getDefaultToolkit().createImage( mis );
        }

        return theImage;
    }

    /**
     * Thickening transform function.
     * @param bi The buffered image to set values to
     * @param x
     * @param y
     * @param rgb
     */
    protected static void widenAffineFunction( BufferedImage bi, int x, int y, int rgb)
    {
        int pixelValue =  bi.getRGB(x, y);

        if ((pixelValue & 0xff000000) == 0)
        {
            bi.setRGB(x, y, rgb);
        }
        if (testForBlack(rgb))
        {

            bi.setRGB(x, y+1,  rgb);
            bi.setRGB(x+1, y,  rgb);
            bi.setRGB(x, y+1,  rgb);
        }
    }

    /*
     * Thickening transform function.
     * @param bi The buffered image to set values to
     * @param x
     * @param y
     * @param rgb
     */
    /**
     * Thickening transform function.
     * @param imageBuffer Pixel buffer to modify. Must be in same format as what
     *                    is returned from {@link PixelGrabber#getPixels()}.
     * @param pgIdx       The index of 2x2 array into <code>imageBuffer</code>.
     * @param scanSize    The scan size/width of an image row that generated
     *                    the <code>imageBuffer</code> array.
     * @param pixelValue  The value of the source pixel to use.
     */
    protected static void widenAffineFunction( int[] imageBuffer, int pgIdx, int scanSize, int pixelValue)
    {
        if ((imageBuffer[pgIdx] & 0xff000000) == 0)
        {
            imageBuffer[pgIdx] = pixelValue;
        }
        if (testForBlack(pixelValue))
        {

            imageBuffer[pgIdx + 1] = pixelValue;
            imageBuffer[pgIdx + scanSize] = pixelValue;
            imageBuffer[pgIdx + scanSize + 1] = pixelValue;
        }
    }

    /**
     * Method to determina if an RGB pixel value should be black or white.
     * @param pixelValue The RGB 24bit pixel value to test.
     * @return <code>true</code> if black, else <code>false</code> if white.
     */
    protected static boolean testForBlack(int pixelValue)
    {
        int red = pixelValue & 0xff;
        int green = (pixelValue & 0xff00) >> 8;
        int blue = (pixelValue & 0xff0000) >> 16;

        boolean retVal = false;
        if (red + green * 6 + blue * 3 < 1280)
//        if ((red < 8) && (green < 8) && (blue < 8))
        {
            retVal = true;
        }

        return retVal;
    }

    /**
     * Inner class for value object of image encoding types.
     */
    public static class ImageMediaType
    {

        private int type;
        private String name;
        private String[] extensions;
        private String mimeType;
        private static int instanceCount = 0;

        private ImageMediaType( String name,
                                String mimeType,
                                String[] extensions )
        {
            this.name = name;
            this.mimeType = mimeType;
            this.extensions = extensions;

            synchronized (this)
            {
                this.type = instanceCount++;
            }
        }

        @Override
        public boolean equals( Object obj )
        {
            return ((obj instanceof ImageUtility.ImageMediaType) &&
                    ((ImageUtility.ImageMediaType) obj).type == this.type);
        }

        @Override
        public int hashCode()
        {
            return new Integer( type ).hashCode();
        }

        @Override
        public String toString()
        {
            return name;
        }

        private boolean fileIsOfType(String fileName)
        {
            for ( int i = 0; i < extensions.length; i++ )
            {
                String string = extensions[i];
                if (fileName.lastIndexOf( string ) >= 0)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
