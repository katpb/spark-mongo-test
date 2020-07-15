package com.verifone.isd.vsms2.sys.util.image.bmp;

// BMPImageIO.java
import java.awt.Button;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class provides routines for BMP image input and output.
 * @author Joe_H5
 */
public class BMPImageIO
{

    /**
     * The loadImage reads the contents of the given file, returning the
     * data as a three dimensional array (row, column, colour).  Colour
     * is 0 for red, 1 for green, 2 for blue, 3 for offset.
     * The file name may be for a local file (such as "Camel.jpg") or it may
     * be a path (such as "/home/turing/alan.bmp").
     * @param openName Name of file to create image from.
     * @return a 3D array containing the image data.
     * @throws java.io.IOException
     */
    public static int[][][] loadImage(String openName) throws IOException
    {
        Image img = (Image) null;  // create a null Image


        try
        {
            // Check that the file name has a legal extension
            if ( openName.endsWith( ".gif" ) || openName.endsWith( ".jpg" ) ||
                 openName.endsWith( ".jpeg" ) )
            {
                img = Toolkit.getDefaultToolkit().getImage( openName );
            } else if ( openName.endsWith( ".bmp" ) )
            {
                img = BmpUtils.loadbitmap(  openName );
            } else
            {
                img = (Image) null;  // we can't read the file
            }


            if ( img != null )
            {
                // Make sure the entire image is loaded before continuing
                Button b = new Button();  // Create a button to use as a paraemter
                // to the constructor for MediaTracker.
                MediaTracker tracker = new MediaTracker( b );
                tracker.addImage( img, 0 );
                tracker.waitForID( 0 );

                // Create "observer", an object that allows us to
                // use getWidth and getHeight.
                BmpIObserver observer = new BmpIObserver();
                int width = img.getWidth( observer );
                int height = img.getHeight( observer );

                if ( width == -1 || height == -1 )
                {
                    // the image has not loaded.
                    img = (Image) null;
                }
            }  // if img != null

        }
        catch ( InterruptedException e )
        {
        }

        // Translate from Image img to a 3D array "imagePixels".
        // Using this 3D array, imagePixels[r][c][w] gives the value
        // of row r, column c, colour w.
        int[][][] imagePixels = new int [0][0][0];
        if (img != null)
        {
            imagePixels = getImagePixels( img );
        }
        return imagePixels;
    } // end of method loadImage  

    /**
     * The getImagePixels method converts an image object into a 3D array
     * representing pixels (rows, columns, pixel value (red, green, blue, offset)).
     * @param img the image which is to be converted.
     * @return a 3D array representing the pixels of image is returned.
     */
    public static int[][][] getImagePixels( Image img )
    {

        // Get the raw pixel data 
        ImageObserver observer = new ImageObserver()
        {

            public boolean imageUpdate( Image img, int infoflags, int x, int y,
                                        int width, int height )
            {
                return true;
            }
        };

        int width1 = img.getWidth( observer );
        int height1 = img.getHeight( observer );
        int[] rawPixels = BmpUtils.getPixels( img, width1, height1 );

        // Each pixel is represented by 32 bits.  Separate the tH32 bits into
        // four 8-bit values (red, green, blue, offset).
        int[][] rgbPixels = new int[rawPixels.length][4];
        for ( int j = 0; j < rawPixels.length; j++ )
        {
            rgbPixels[j][0] = ((rawPixels[j] >> 16) & 0xff);
            rgbPixels[j][1] = ((rawPixels[j] >> 8) & 0xff);
            rgbPixels[j][2] = (rawPixels[j] & 0xff);
            rgbPixels[j][3] = ((rawPixels[j] >> 24) & 0xff);
        }  // for j

        // Arrange the data by rows and columns
        int[][][] imagePixels = new int[height1][width1][4];
        int index = 0;
        for ( int row = 0; row < imagePixels.length; row++ )
        {
            for ( int col = 0; col < imagePixels[0].length; col++ )
            {
                for ( int rgbo = 0; rgbo < 4; rgbo++ )
                {
                    imagePixels[row][col][rgbo] = rgbPixels[index][rgbo];
                } // for rgbo
                index++;
            } // for col
        }  // for row
        return imagePixels;
    } // end of method getImagePixels

    /**
     * Saves theImage as a windows bitmap (bmp).
     * @param theImage A fully loaded AWT image object.
     * @param saveName The file name to save the data to.
     */
    public static void saveImage( Image theImage, String saveName )
    {
        int[][][] imagePixels = getImagePixels( theImage );
        saveImage( imagePixels, saveName );
    }

    /**
     * Saves theImage as a windows bitmap (bmp).
     * @param theImage A fully loaded AWT image object.
     * @param os The output stream to save the data to.
     */
    public static void saveImage( Image theImage, OutputStream os )
    {
        int[][][] imagePixels = getImagePixels( theImage );
        saveImage( imagePixels, os );
    }

    /**
     * Saves imagePiexls as a windows bitmap (bmp).
     * @param imagePixels a 3D array of pixel data.
     * @param saveName The name of the file to save the data to.
     */
    public static void saveImage( int[][][] imagePixels, String saveName )
    {

        int height = imagePixels.length;
        int width = imagePixels[0].length;
        int[][] flat = new int[width * height][4];

        // Flatten the image into a 2D array.
        int index = 0;
        for ( int row = 0; row < height; row++ )
        {
            for ( int col = 0; col < width; col++ )
            {
                for ( int rgbo = 0; rgbo < 4; rgbo++ )
                {
                    flat[index][rgbo] = imagePixels[row][col][rgbo];
                }
                index++;
            }  // for col
        }  // for row

        // Combine the 8-bit red, green, blue, offset values into 32-bit words.
        int[] outPixels = new int[flat.length];
        for ( int j = 0; j < flat.length; j++ )
        {
            outPixels[j] = ((flat[j][0] & 0xff) << 16) | ((flat[j][1] & 0xff) <<
                                                          8) | (flat[j][2] &
                                                                0xff) |
                           ((flat[j][3] & 0xff) << 24);
        } // for j

        // Write the data out to file with the name given by string saveName.
        BMPFile bmpf = new BMPFile();
        bmpf.saveBitmap( saveName, outPixels, width, height );

    }  // end of method saveImage

    /**
     * Saves imagePiexls as a windows bitmap (bmp).
     * @param imagePixels a 3D array of pixel data.
     * @param os The OutputStream to save the data to.
     */
    public static void saveImage( int[][][] imagePixels, OutputStream os )
    {

        int height = imagePixels.length;
        int width = imagePixels[0].length;
        int[][] flat = new int[width * height][4];

        // Flatten the image into a 2D array.
        int index = 0;
        for ( int row = 0; row < height; row++ )
        {
            for ( int col = 0; col < width; col++ )
            {
                for ( int rgbo = 0; rgbo < 4; rgbo++ )
                {
                    flat[index][rgbo] = imagePixels[row][col][rgbo];
                }
                index++;
            }  // for col
        }  // for row

        // Combine the 8-bit red, green, blue, offset values into 32-bit words.
        int[] outPixels = new int[flat.length];
        for ( int j = 0; j < flat.length; j++ )
        {
            outPixels[j] = ((flat[j][0] & 0xff) << 16) | ((flat[j][1] & 0xff) <<
                                                          8) | (flat[j][2] &
                                                                0xff) |
                           ((flat[j][3] & 0xff) << 24);
        } // for j

        // Write the data out to file with the name given by string saveName.
        BMPFile bmpf = new BMPFile();
        bmpf.saveBitmap( os, outPixels, width, height );

    }  // end of method saveImage

    private static String bmpTack( String name )
    {
        if ( name.endsWith( ".bmp" ) )
        {
            return name;
        } else
        {
            return name + ".bmp";
        }
    }  // end of method bmpTack
} // end of class imageIOm











