package com.verifone.isd.vsms2.sys.util.image.tiff;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.ImageProducer;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import com.verifone.isd.vsms2.sys.util.image.tiff.tag.CompressionType;
import com.verifone.isd.vsms2.sys.util.image.tiff.tag.PhotometricType;
import com.verifone.isd.vsms2.sys.util.image.tiff.tag.PlanarConfigType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class CodedImage {

    // This class IS inherited, so logger is initialized in constructor.
    protected Logger logger;

	public byte	imageBytes[];
	public byte imageStrips[][];
	public long compType;
	public int bitsPerSample, samplesPerPixel, extraSamples, photometric;
	public int imageWidth, imageHeight;

	protected IFD ifd;

	public CodedImage(IFD ifd) {
		this.ifd = ifd;

        logger = LoggerFactory.getLogger(this.getClass());

		imageBytes = null;
		imageStrips = null;
		compType = CompressionType.NONE;
		imageWidth =0;
		imageHeight =0;
		bitsPerSample=0;
		//samplesPerPixel=0;
		samplesPerPixel=1;
		extraSamples=-1;
		photometric=0;

//		short	redcmap[];			/* colormap pallete */
//		short	greencmap[];
//		short	bluecmap[];


//		TIFFRGBValue* Map;			/* sample mapping array */
//		uint32** BWmap;				/* black&white map */
//		uint32** PALmap;			/* palette image map */
//		TIFFYCbCrToRGB* ycbcr;			/* YCbCr conversion state */

		for (int i=0; i<ifd.count; i++) {

			if (ifd.entries[i].tag.equals(Tag.IMAGEWIDTH)) {
				imageWidth = (int)ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.IMAGELENGTH)) {
				imageHeight = (int)ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.COMPRESSION)) {
				compType = ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.BITSPERSAMPLE)) {
				if (ifd.entries[i].isOffset()) {
					if (ifd.entries[i].type.isShort())
						bitsPerSample = ((ifd.entries[i].dataArray[0]&0xff)<<8) + (ifd.entries[i].dataArray[1]&0xff);
					else
						bitsPerSample = ((ifd.entries[i].dataArray[0]&0xff)<<24) + ((ifd.entries[i].dataArray[1]&0xff)<<16) + ((ifd.entries[i].dataArray[2]&0xff)<<8) + (ifd.entries[i].dataArray[3]&0xff);
				}
				else
					bitsPerSample = (int)ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.SAMPLESPERPIXEL)) {
				samplesPerPixel = (int)ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.EXTRASAMPLES)) {
				extraSamples = (int)ifd.entries[i].value;
			}
			else if (ifd.entries[i].tag.equals(Tag.PHOTOMETRIC)) {
				photometric = (int)ifd.entries[i].value;
			}
		}
	}

	boolean isRaw () {
		return (compType == CompressionType.NONE);
	}

	boolean isJPEG () {
		return (compType == CompressionType.JPEG || compType == CompressionType.OJPEG);
	}

	boolean isCCITT()	{
    return (compType == CompressionType.CCITTFAX3 ||
				    compType == CompressionType.CCITTFAX4 ||
				    compType == CompressionType.CCITTRLE ||
				    compType == CompressionType.CCITTRLEW);
	}


	ColorModel makeColorModel() {
		byte[] rLUT, gLUT,bLUT;

		rLUT = new byte[256];
		gLUT = new byte[256];
		bLUT = new byte[256];
		for(int i=0; i<256; i++) {
			rLUT[i]=(byte)(i & 0xff);
			gLUT[i]=(byte)(i & 0xff);
			bLUT[i]=(byte)(i & 0xff);
		}
		return(new IndexColorModel(8, 256, rLUT, gLUT, bLUT));
	}


	ColorModel makeRGBColorModel() {
        Object[] logObjs;
		byte[] rLUT, gLUT,bLUT;
        IFDEntry anIFD = ifd.GetEntry( Tag.COLORMAP );
        if (anIFD == null)
        {
            return ColorModel.getRGBdefault();
        }
		byte[] map = anIFD.dataArray;
		int i, j, n, r, g, b; 
		n = map.length/6; //2bytes (1 ignored) * 3
		rLUT = new byte[256];
		gLUT = new byte[256];
		bLUT = new byte[256];

        anIFD = ifd.GetEntry( Tag.PHOTOMETRIC );
		if ((anIFD != null) &&(anIFD.value == 3)) { //planar format ie rrrrrrrrrggggggggggbbbbbbbbb
    		
    		r = 0;
    		g = n*2;
    		b = n*4;
		
            logger.debug("----------------- PALETTE ------------------");
    		for(i=0, j=0; i<n; i++, j+=2) {
    			rLUT[i]=(byte)(map[j+r] & 0xff);
    			gLUT[i]=(byte)(map[j+g] & 0xff);
    			bLUT[i]=(byte)(map[j+b] & 0xff);
                if (logger.isDebugEnabled())
                {
                    logObjs = new Object[]
                    {
                        Integer.valueOf(i),
                        Integer.valueOf((int)(rLUT[i]&0xff)),
                        Integer.valueOf((int)(gLUT[i]&0xff)),
                        Integer.valueOf((int)(bLUT[i]&0xff))
                    };
                    logger.debug( "#{} = ({},{},{}), {}", logObjs );
                }
    		}
    	}
    	else { //chunky rgb format ie rgbrgbrgb
    	    
    	    r=0; g=2; b=4; 
            logger.debug("----------------- PALETTE ------------------");
    		for(i=0, j=0; i<n; i++, j+=6) {
    			rLUT[i]=(byte)(map[j+r] & 0xff);
    			gLUT[i]=(byte)(map[j+g] & 0xff);
    			bLUT[i]=(byte)(map[j+b] & 0xff);
                if (logger.isDebugEnabled())
                {
                    logObjs = new Object[]
                    {
                        Integer.valueOf(i),
                        Integer.valueOf((int)(rLUT[i]&0xff)),
                        Integer.valueOf((int)(gLUT[i]&0xff)),
                        Integer.valueOf((int)(bLUT[i]&0xff))
                    };
                    logger.debug( "#{} = ({},{},{}), ", logObjs );
                }
    		}
    	}


		for(i=n; i<256; i++) {
			rLUT[i]=0;
			gLUT[i]=0;
			bLUT[i]=0;
		}


		return(new IndexColorModel(bitsPerSample, n, rLUT, gLUT, bLUT));
	}

 /*
 	* Macros for extracting components from the
 	* packed ABGR form returned by TIFFReadRGBAImage.
 	*/
	int GetR( int abgr) {	return ((abgr) & 0xff); }
	int GetG( int abgr)	{	return (((abgr) >> 8) & 0xff); }
	int GetB( int abgr)	{	return (((abgr) >> 16) & 0xff); }
	int GetA( int abgr)	{	return (((abgr) >> 24) & 0xff); }


	public Image getImage() {
		Image img = null;
		ImageProducer ip = (ImageProducer) getImageProducer();
		if (ip != null) {
		  img = Toolkit.getDefaultToolkit().createImage( ip );
		}
		return img;
	}


	public Object getImageProducer() {

		ColorModel cm = makeColorModel();
		int[] pixels;
 	  imageWidth =256;
 	  imageHeight=256;

    pixels = new int[imageWidth * imageHeight];
		for (int y=0; y<pixels.length; y+=imageWidth) {
			for (int x=0; x<imageWidth; x++) {
				pixels[x + y] = (x&0xff);
			}
		}

		return new MemoryImageSource(imageWidth, imageHeight, pixels, 0, imageWidth);
	}

	/*
 * Construct any mapping table used
 * by the associated put routine.
 */

	/*
	 * Check the image to see if TIFFReadRGBAImage can deal with it.
	 * 1/0 is returned according to whether or not the image can
	 * be handled.  If 0 is returned, emsg contains the reason
	 * why it is being rejected.
	 */
	boolean	CanDecodeImage()
	{
        Object[] logObjs;
	  int colorChannels;
	  int planarConfig;

	  switch (bitsPerSample) {
	    case 1: case 2: case 4: case 8: case 16: break;
	    default:
				logger.warn("Sorry, can not handle images with {}-bit samples", Integer.valueOf(bitsPerSample));
				return (false);
	  }

	  if (extraSamples==-1) //tag not set in IFD
	  	colorChannels = samplesPerPixel; //normally would default to 0
	  else
	  	colorChannels = samplesPerPixel - extraSamples;

      if (logger.isDebugEnabled())
      {
          logObjs = new Object[]
          {
              Integer.valueOf(samplesPerPixel),
              Integer.valueOf(extraSamples),
              Integer.valueOf(colorChannels),
              Integer.valueOf(photometric)
          };
          logger.debug("samplesPerPixel:{}, extraSamples:{}, colorChannels:{}, photometric:{}", logObjs);
      }

	  if (photometric==0 && extraSamples!=-1) {
			switch (colorChannels) {
				case 1:	photometric = PhotometricType.MINISBLACK;   	break;
				case 3: photometric = PhotometricType.RGB;	    			break;
				default:
                    logger.warn("Missing needed PHOTOMETRIC tag");
		    	return (false);
			}
	  }

	  switch (photometric) {
	    case PhotometricType.MINISWHITE:
	    case PhotometricType.MINISBLACK:
	    case PhotometricType.PALETTE:
			  planarConfig = ifd.GetFieldValue(Tag.PLANARCONFIG);
				if (planarConfig == PlanarConfigType.CONTIG && samplesPerPixel != 1) {
					logger.warn("Sorry, can not handle contiguous data with PHOTOMETRIC={}, and Samples per Pixel={}", Integer.valueOf(photometric), Integer.valueOf(samplesPerPixel));
		  	  return (false);
				}
				break;
	    case PhotometricType.YCBCR:
			  planarConfig = ifd.GetFieldValue(Tag.PLANARCONFIG);
				if (planarConfig != PlanarConfigType.CONTIG) {
					logger.debug("Sorry, can not handle YCbCr images with Planarconfiguration={}", Integer.valueOf(planarConfig));
			    return (false);
				}
				break;
	    case PhotometricType.RGB:
				if (colorChannels < 3) {
					logger.debug("Sorry, can not handle RGB image with Color channels={}", Integer.valueOf(colorChannels));
		    	return (false);
				}
				break;
	    default:
				logger.debug("Sorry, can not handle image with Photometric={}", Integer.valueOf(photometric));
				return (false);
	  }
	  return (true);
	}

}