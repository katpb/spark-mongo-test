package com.verifone.isd.vsms2.sys.util.image.bmp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BmpUtils
{
    private static final Logger logger = LoggerFactory.getLogger(BmpUtils.class);

    /**
     * Create an AWT Image object from the BMP encoded data specified by sfile.
     * @param sfile The file name to read the data from.
     * @return The created image object. Maybe null of encoding is really not a
     *         BMP file.
     * @throws java.io.IOException Thrown on any read errors.
     */
    public static Image loadbitmap( String sfile ) throws java.io.IOException
    {
        FileInputStream fs = null;
        BufferedInputStream bs = null;

        try {
            fs = new FileInputStream( sfile );
            bs = new BufferedInputStream(fs);
            return loadbitmap( fs );
        } finally
        {
            if (fs != null)
            {
                try
                {
                    fs.close();
                } catch (java.io.IOException ioe) { }
            }
            if (bs != null)
            {
                try
                {
                    bs.close();
                } catch (java.io.IOException ioe) { }
            }
        }
    }

    /**
     * Create an AWT Image object from the BMP encoded data specified by sfile.
     * @param fs The InputStream to read the data from.
     * @return The created image object. Maybe null of encoding is really not a
     *         BMP file.
     * @throws java.io.IOException Thrown on any read errors.
     */
    public static Image loadbitmap( InputStream fs ) throws java.io.IOException
    {
        Image image = null;

        try
        {
            int bflen = 14; // 14 byte BITMAPFILEHEADER
            byte bf[] = new byte[bflen];
            int bytesRead = fs.read( bf, 0, bf.length );
            if (bytesRead != bf.length)
            {
                throw new java.io.IOException("Malformed BMP file");
            }
            int bilen = 40; // 40-byte BITMAPINFOHEADER
            byte bi[] = new byte[bilen];
            bytesRead = fs.read( bi, 0, bi.length );
            if (bytesRead != bi.length)
            {
                throw new java.io.IOException("Malformed BMP file");
            }

            // Interperet data.
            int nsize = (((int) bf[5] & 0xff) << 24) | (((int) bf[4] & 0xff) <<
                                                        16) | (((int) bf[3] &
                                                                0xff) << 8) |
                        (int) bf[2] & 0xff;
            logger.trace("File type is :{}{}", Character.valueOf((char)bf[0]), Character.valueOf((char)bf[1]));
            logger.trace("Size of file is :{}", Integer.valueOf(nsize));

            int nbisize = (((int) bi[3] & 0xff) << 24) |
                          (((int) bi[2] & 0xff) << 16) |
                          (((int) bi[1] & 0xff) << 8) | (int) bi[0] & 0xff;
            logger.trace("Size of bitmapinfoheader is :", Integer.valueOf(nbisize));

            int nwidth = (((int) bi[7] & 0xff) << 24) | (((int) bi[6] & 0xff) <<
                                                         16) | (((int) bi[5] &
                                                                 0xff) << 8) |
                         (int) bi[4] & 0xff;
            logger.trace("Width is :", Integer.valueOf(nwidth));

            int nheight = (((int) bi[11] & 0xff) << 24) |
                          (((int) bi[10] & 0xff) << 16) |
                          (((int) bi[9] & 0xff) << 8) | (int) bi[8] & 0xff;
            logger.trace("Height is :", Integer.valueOf(nheight));


            int nplanes = (((int) bi[13] & 0xff) << 8) | (int) bi[12] & 0xff;
            logger.trace("Planes is :"+nplanes);

            int nbitcount = (((int) bi[15] & 0xff) << 8) | (int) bi[14] & 0xff;
            logger.trace("BitCount is :", Integer.valueOf(nbitcount));

            // Look for non-zero values to indicate compression
            int ncompression = (((int) bi[19]) << 24) | (((int) bi[18]) << 16) |
                               (((int) bi[17]) << 8) | (int) bi[16];
            logger.trace("Compression is :", Integer.valueOf(ncompression));

            int nsizeimage = (((int) bi[23] & 0xff) << 24) | (((int) bi[22] &
                                                               0xff) << 16) |
                             (((int) bi[21] & 0xff) << 8) | (int) bi[20] & 0xff;
            logger.trace("SizeImage is :", Integer.valueOf(nsizeimage));

            int nxpm = (((int) bi[27] & 0xff) << 24) | (((int) bi[26] & 0xff) <<
                                                        16) | (((int) bi[25] &
                                                                0xff) << 8) |
                       (int) bi[24] & 0xff;
            logger.trace("X-Pixels per meter is :", Integer.valueOf(nxpm));

            int nypm = (((int) bi[31] & 0xff) << 24) | (((int) bi[30] & 0xff) <<
                                                        16) | (((int) bi[29] &
                                                                0xff) << 8) |
                       (int) bi[28] & 0xff;
            logger.trace("Y-Pixels per meter is :", Integer.valueOf(nypm));

            int nclrused = (((int) bi[35] & 0xff) << 24) |
                           (((int) bi[34] & 0xff) << 16) |
                           (((int) bi[33] & 0xff) << 8) | (int) bi[32] & 0xff;
            logger.trace("Colors used are :", Integer.valueOf(nclrused));

            int nclrimp = (((int) bi[39] & 0xff) << 24) |
                          (((int) bi[38] & 0xff) << 16) |
                          (((int) bi[37] & 0xff) << 8) | (int) bi[36] & 0xff;
            logger.trace("Colors important are :", Integer.valueOf(nclrimp));

            if ( nbitcount == 24 )
            {
                // No Palatte data for 24-bit format but scan lines are
                // padded out to even 4-byte boundaries.
                int npad = (nsizeimage / nheight) - nwidth * 3;
                //added for Bug correction
                if ( npad == 4 )
                {
                    npad = 0;
                }
                int ndata[] = new int[nheight * nwidth];
                byte brgb[] = new byte[(nwidth + npad) * 3 * nheight];

                bytesRead = fs.read( brgb, 0,  brgb.length);
                if (bytesRead != brgb.length)
                {
                    throw new java.io.IOException("Malformed BMP file");
                }

                int nindex = 0;
                for ( int j = 0; j < nheight; j++ )
                {
                    for ( int i = 0; i < nwidth; i++ )
                    {
                        ndata[nwidth * (nheight - j - 1) + i] =
                        (255 & 0xff) << 24 | (((int) brgb[nindex + 2] & 0xff) <<
                                              16) | (((int) brgb[nindex + 1] &
                                                      0xff) << 8) |
                        (int) brgb[nindex] & 0xff;
                        nindex += 3;
                    }
                    nindex += npad;
                }

                image =
                Toolkit.getDefaultToolkit().createImage( new MemoryImageSource(
                        nwidth, nheight, ndata, 0, nwidth ) );
            } else if ( nbitcount == 8 )
            {
                // Have to determine the number of colors, the clrsused
                // parameter is dominant if it is greater than zero. If
                // zero, calculate colors based on bitsperpixel.
                int nNumColors = 0;
                if ( nclrused > 0 )
                {
                    nNumColors = nclrused;
                } else
                {
                    nNumColors = (1 & 0xff) << nbitcount;
                }
                logger.trace("The number of Colors is", Integer.valueOf(nNumColors));

                // Some bitmaps do not have the sizeimage field calculated
                // Ferret out these cases and fix 'em.
                if ( nsizeimage == 0 )
                {
                    nsizeimage = ((((nwidth * nbitcount) + 31) & ~31) >> 3);
                    nsizeimage *= nheight;
                logger.trace("nsizeimage (backup) is", Integer.valueOf(nsizeimage));
                }

                // Read the palatte colors.
                int npalette[] = new int[nNumColors];
                byte bpalette[] = new byte[nNumColors * 4];
                bytesRead = fs.read( bpalette, 0, bpalette.length );
                if (bytesRead != bpalette.length)
                {
                    throw new java.io.IOException("Malformed BMP file");
                }

                int nindex8 = 0;
                for ( int n = 0; n < nNumColors; n++ )
                {
                    npalette[n] = (255 & 0xff) << 24 |
                                  (((int) bpalette[nindex8 + 2] & 0xff) << 16) |
                                  (((int) bpalette[nindex8 + 1] & 0xff) << 8) |
                                  (int) bpalette[nindex8] & 0xff;
                    nindex8 += 4;
                }
                // Read the image data (actually indices into the palette)
                // Scan lines are still padded out to even 4-byte
                // boundaries.
                int npad8 = (nsizeimage / nheight) - nwidth;
                logger.trace("nPad is:", Integer.valueOf(npad8));

                int ndata8[] = new int[nwidth * nheight];
                byte bdata[] = new byte[(nwidth + npad8) * nheight];
                bytesRead = fs.read( bdata, 0, bdata.length );
                if (bytesRead != bdata.length)
                {
                    throw new java.io.IOException("Malformed BMP file");
                }
                nindex8 = 0;
                for ( int j8 = 0; j8 < nheight; j8++ )
                {
                    for ( int i8 = 0; i8 < nwidth; i8++ )
                    {
                        ndata8[nwidth * (nheight - j8 - 1) + i8] =
                        npalette[((int) bdata[nindex8] & 0xff)];
                        nindex8++;
                    }
                    nindex8 += npad8;
                }

                image = Toolkit.getDefaultToolkit().createImage(
                        new MemoryImageSource( nwidth, nheight, ndata8, 0,
                                               nwidth ) );
            } else if ( nbitcount == 1 )
            {

                int npad1 = (nsizeimage / nheight) - nwidth / 8;
                byte bdata[] = new byte[(nwidth + npad1) * nheight];
                bytesRead = fs.read( bdata, 0, 8 );
                if (bytesRead != 8)
                {
                    throw new java.io.IOException("Malformed BMP file");
                }
                bytesRead = fs.read( bdata, 0, bdata.length );
                if (bytesRead != bdata.length)
                {
                    throw new java.io.IOException("Malformed BMP file");
                }
                int ndata1[] = new int[nwidth * nheight];
                int nindex1 = 0;

                int max = 0;
                logger.trace (" npad1 = ", Integer.valueOf(npad1));

                for ( int j1 = 0; j1 < nheight; j1++ )
                {
                    int iindex;
                    iindex = nindex1;
                    for ( int i1 = 0; i1 <= nwidth / 8; i1++ )
                    {
                        int ib1 = 0;
                        if ( i1 * 8 < nwidth )
                        {
                            for ( int b1 = 128; b1 > 0; b1 = b1 / 2 )
                            {
                                ndata1[nwidth * (nheight - j1 - 1) + i1 * 8 +
                                       ib1] = ((b1 & bdata[iindex]) > 0) ? 255 +
                                                                           (255 + 255 * 256) * 256
                                              : 0;
                                ib1++;
                                if ( i1 * 8 + ib1 >= nwidth )
                                {
                                    b1 = 0;
                                }
                            }
                        }
                        max = i1 * 8 + ib1;
                        iindex++;
                    }
                    nindex1 += (nsizeimage / nheight);
                }
                logger.trace ("max = ", Integer.valueOf(max));

                image = Toolkit.getDefaultToolkit().createImage(
                        new MemoryImageSource( nwidth, nheight, ndata1, 0,
                                               nwidth ) );
            } else
            {
                logger.warn(
                        "Not a 24-bit or 8-bit or 1-bit Windows Bitmap, aborting..." );
                image = (Image) null;
            }

        } finally
        {
            fs.close();
        }

        return image;
    }

    /**
     * Get the array of int piixels from an AWT Image object.
     * @param parImage The fully loaded AWT image to get pixel data from.
     * @param parWidth The width of the parImage.
     * @param parHeight The height of the parImage.
     * @return Raw pixel data from the AWT image.
     */
    public static int[] getPixels( Image parImage, int parWidth, int parHeight )
    {
        int[] bitmap = new int[parWidth * parHeight];
        PixelGrabber pg = new PixelGrabber( parImage, 0, 0, parWidth, parHeight,
                                            bitmap, 0, parWidth );
        try
        {
            pg.grabPixels();
        } catch ( InterruptedException e )
        {
            logger.error("Errors with PixelGrabber!", e);
        }

        return bitmap;
    }
}
