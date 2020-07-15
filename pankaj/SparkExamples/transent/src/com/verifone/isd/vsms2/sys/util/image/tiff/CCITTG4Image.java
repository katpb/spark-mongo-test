package com.verifone.isd.vsms2.sys.util.image.tiff;

import java.awt.image.ColorModel;
import java.awt.image.MemoryImageSource;
import com.verifone.isd.vsms2.sys.util.image.tiff.util.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/* CCITT Group 4 fax encoding */
class CCITTG4Image extends RawImage {

	private byte WhiteRun[];
	private byte BlackRun[];
	private byte bytesArray[];
	private byte rawImage [];
	private boolean whiteRun=true;
	private int lines=0, nPixels=0;
	private int longHoriztonalRun =0;

	private boolean hiloBitOrder=false;
	
	private int i, j, shift, count, a0, b1, ref[], cur[], refIndex, curIndex, runLength;
	private byte b, tmp[];
	private long start,stop;
	
	private T4Node WhiteTree;
	private T4Node BlackTree;
	private T4Node ModeTree;
	private T4Node node;
	private T4Code code;


	public static final int	P  = 0;
	public static final int	H	 = 1;
	public static final int	V0 = 2;
	public static final int	VR1= 3;
	public static final int	VR2= 4; 
	public static final int	VR3= 5;
	public static final int	VL1= 6;
	public static final int	VL2= 7;
	public static final int	VL3= 8;
	public static final int EXT2D=9; 
	public static final int EXT1D=10; 
	
	


	public static final int ModeCodes[][] = {
    { 4, 0x1, P },		/* 0001 		pass			*/
    { 3, 0x1, H },		/* 001 			horizontal*/
    { 1, 0x1, V0 },		/* 1 				vert 0		*/
    { 3, 0x3, VR1 },	/* 011 			vert r 1	*/
    { 6, 0x3, VR2 },	/* 000011 	vert r 2	*/
    { 7, 0x3, VR3 },	/* 0000011 	vert r 3	*/
    { 3, 0x2, VL1 },	/* 010 			vert l 1	*/
    { 6, 0x2, VL2 },	/* 000010 	vert l 2	*/
    { 7, 0x2, VL3 },	/* 0000010 	vert l 3	*/
    {10, 0xf, EXT2D}, /* 0000001111 */
    {12, 0xf, EXT1D}, /* 000000001111 */
    {12, 0x1, T4Code.EOL }, /* 000000000001 */
	};


	public CCITTG4Image(IFD ifd) {
		super(ifd); 

		hiloBitOrder = (ifd.GetFieldValue( Tag.FILLORDER ) == 2);
		init(); 
	}

	public CCITTG4Image(int imageWidth, int imageHeight, byte [] bytesArray, boolean hiloBitOrder ) {
		super(new IFD()); 
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.imageBytes = bytesArray;
		this.hiloBitOrder = hiloBitOrder;
		init(); 
	}


	private void init() {
		//setup trees
		WhiteTree = new T4Node(); 
		BlackTree = new T4Node(); 
		ModeTree = new T4Node(); 

		if (hiloBitOrder) {
			for (i=0; i<ModeCodes.length; i++) {
				code = new T4Code( ModeCodes[i] );
				if (code.bitLength <= 8) {
					int lo = Converter.reverseByte(Converter.getLoByte(code.codeWord)); // & 0xff);
					code.codeWord = (lo >>> (8-code.bitLength));
				}
				else {
					code.codeWord = (Converter.reverseInt(code.codeWord) >>> (16-code.bitLength));
				}
				ModeTree.ReversedAdd( 0, code );
			}
	
			for (i=0; i<T4Tables.WhiteCodes.length; i++) {
				code = new T4Code( T4Tables.WhiteCodes[i] );
				if (code.bitLength <= 8) {
					int lo = Converter.reverseByte(Converter.getLoByte(code.codeWord)); // & 0xff);
					code.codeWord = (lo >>> (8-code.bitLength));
				}
				else {
					code.codeWord = (Converter.reverseInt(code.codeWord) >>> (16-code.bitLength));
				}
				WhiteTree.ReversedAdd( 0, code );
			}
	
			for (i=0; i<T4Tables.BlackCodes.length; i++) {
				code = new T4Code( T4Tables.BlackCodes[i] );
				if (code.bitLength <= 8) {
					int lo = Converter.reverseByte(Converter.getLoByte(code.codeWord)); // & 0xff);
					code.codeWord = (lo >>> (8-code.bitLength));
				}
				else {
					code.codeWord = (Converter.reverseInt(code.codeWord) >>> (16-code.bitLength));
				}
				BlackTree.ReversedAdd( 0, code );
			}
		}
		else {
			for (i=0; i<ModeCodes.length; i++) {
				code = new T4Code( ModeCodes[i] );
				ModeTree.Add( 0, code );
			}
			
			for (i=0; i<T4Tables.WhiteCodes.length; i++) {
				code = new T4Code( T4Tables.WhiteCodes[i] );
				WhiteTree.Add( 0, code );
			}
	
			for (i=0; i<T4Tables.BlackCodes.length; i++) {
				code = new T4Code( T4Tables.BlackCodes[i] );
				BlackTree.Add( 0, code );
			}
		}
		//setup runs
		WhiteRun = new byte[imageWidth+2];
		BlackRun = new byte[imageWidth+2];
		
		for (i=0; i<imageWidth+1; i++) {
			WhiteRun[i]=(byte)0xff;
			BlackRun[i]=0;
		}
	}

		

	public Object getImageProducer() {

        logger.trace("CCITTG4Image::getImage()");

		byte rawImage[] = getRawImage();
		if (bitsPerSample==8 && rawImage!=null) {
			ColorModel cm = makeColorModel();
		  return new MemoryImageSource(imageWidth, imageHeight, cm, imageBytes, 0, imageWidth);
		}	
		
		return null;
	}

	public byte[] getRawImage() {

        logger.trace("CCITTG4Image::getImage()");

		if (imageBytes == null && imageStrips != null) {
			int i, n, len, rows, lastRow;
			
			int rowsPerStrip = ifd.GetFieldValue( Tag.ROWSPERSTRIP );
			
			imageBytes = new byte [imageWidth*imageHeight];
			
			for (i=0,n=0,rows=0,lastRow=imageStrips.length-1 ; i<imageStrips.length; i++, rows+=rowsPerStrip) {
				
				byte rawStrip[] = DecodeImageStrip( imageStrips[i], (i==lastRow ? (imageHeight-rows) : rowsPerStrip));
				
				System.arraycopy(rawStrip, 0, imageBytes, n, nPixels); //rawStrip.length);
				n += nPixels; //rawStrip.length;
				nPixels=0;
			}
			imageStrips = null;
		}
		else if (imageBytes != null) imageBytes = DecodeImage(); 
		else return null;
		
		return imageBytes; 
	}

	private byte [] DecodeImage() {
        logger.trace("CCITTG4Image::DecodeImage()");
		return DecodeImageStrip( imageBytes, imageHeight );
	}
	
	private byte [] DecodeImageStrip(byte[] imageStrip, int maxLines)
	{
        logger.trace("CCITTG4Image::DecodeImageStrip( strip, {} )", Integer.valueOf(maxLines));

        Object[] logObjs;
        StringBuilder sb = new StringBuilder();

		bytesArray = imageStrip;

		int expectedCount = imageWidth*maxLines; 
		rawImage = new byte [expectedCount+1];
		tmp = new byte [2];
		ref = new int [imageWidth+1];
		cur = new int [imageWidth+1];

		ref[0]=imageWidth; //set initial reference line to all white
		ref[1]=0;
		

		runLength=0; 
		a0=0;
		b1=ref[0];
		refIndex=1;
		curIndex=0;
		
		nPixels = 0; 
		lines = 0; 
		longHoriztonalRun =0;
		whiteRun=true;

		code = new T4Code(); 

		//go through the whole thing
	decodeLoop:
		for (i=0,lines=1,count=bytesArray.length*8; lines<=maxLines && i<count; ) {
			
			i = readMode(i);
			
			switch (code.runLength) { 
				case P: {
                    if (logger.isTraceEnabled()) sb.append("mode: Pass,\t");
					decodePass();
					continue decodeLoop; 				
					}
					
				case H:  { 
                    if (logger.isTraceEnabled()) sb.append("mode: Horizontal,  ");
					i = decodeHorizontal(tmp, i);
					i = decodeHorizontal(tmp, i);
					detectB1(); 
					break; 
					}
				
				case V0: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital 0,\t");
					detectB1();
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0),
                        };
                        logger.trace("{}\tb1-a0 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0); 
					whiteRun = !whiteRun;
					
					b1 += ref[refIndex++];
                    logger.trace("{}b1 += ref[refIndex++] ==>{}", sb, Integer.valueOf(b1));
                    sb.delete(0, sb.length());
					
					break; 

				case VR1: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital R 1,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0+1),
                        };
                        logger.trace("{}\tb1-a0+1 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0+1); 
					whiteRun = !whiteRun;
					b1 += ref[refIndex++];
					break; 

				case VR2: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital R 2,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0+2),
                        };
                        logger.trace("{}\tb1-a0+2 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0+2); 
					whiteRun = !whiteRun;
					b1 += ref[refIndex++];
					break; 
				
				case VR3: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital R 3,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0+3),
                        };
                        logger.trace("{}\tb1-a0+3 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0+3); 
					whiteRun = !whiteRun;
					b1 += ref[refIndex++];
					break; 

				case VL1: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital L 1,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0-1),
                        };
                        logger.trace("{}\tb1-a0-1 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0-1); 
					whiteRun = !whiteRun;
					if (refIndex>0) b1 -= ref[--refIndex];
					break; 

				case VL2: 
                    if (logger.isTraceEnabled()) sb.append("mode: Vertital L 2,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0-2),
                        };
                        logger.trace("{}\tb1-a0-2 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0-2); 
					whiteRun = !whiteRun;
					if (refIndex>0) b1 -= ref[--refIndex];
					break; 

				case VL3: 
                   if (logger.isTraceEnabled()) sb.append("mode: Vertital L 3,\t");
					detectB1(); 
                    if (logger.isTraceEnabled())
                    {
                        logObjs = new Object[]
                        {
                            sb,
                            Integer.valueOf(b1),
                            Integer.valueOf(a0),
                            Integer.valueOf(b1-a0-3),
                        };
                        logger.trace("{}\tb1-a0-3 ==> {}-{}={}", logObjs );
                        sb.delete(0, sb.length());
                    }
					addRun(b1-a0-3); 
					whiteRun = !whiteRun;
					if (refIndex>0) b1 -= ref[--refIndex];
					break; 

				case EXT2D:
				case EXT1D:
					logger.warn("UNCOMPRESSED format no supported!");
					return null; 
					
				case T4Code.EOL: 
					logger.debug( "End of the line" );
					lines++;
					whiteRun=true;
					resetRuns(); 
					break;
			}
			

			if (runLength<0) {
				logger.debug( "negative runLength={}", Integer.valueOf(runLength));
				return null; 
			}
						
            logger.trace("a0 = {}", Integer.valueOf(a0));

			if (a0 >= imageWidth) {
				lines++;
                logger.trace( "End of the line due to a0={}, lines={}", Integer.valueOf(a0), Integer.valueOf(lines ));
				whiteRun=true;
				resetRuns(); 
			}
			
		}

				
		
		bitsPerSample=8;

        if (logger.isTraceEnabled())
        {
            logObjs = new Object[]
            {
                Integer.valueOf(nPixels),
                Integer.valueOf(rawImage.length),
                Integer.valueOf(lines),
                Integer.valueOf(maxLines),
                Integer.valueOf(imageWidth)
            };
            logger.trace("nPixels = {}, rawImage.length={}, lines={}, maxLines={} imageWidth={}", logObjs);
        }

		return (rawImage);
	}
	

	public int readMode(int i) {
			int j = i/8;
			int shift = (i%8);

            logger.trace("Loop start i=", Integer.valueOf(i));
			
			copyBits( bytesArray, tmp, j, shift ); 
		
			node=ModeTree.Find(Converter.bytesToInt(tmp));
			if (node != null)	code = node.getCode();

			i+=code.bitLength; 
			return i; 
	}
	
	public void detectB1() {
        Object[] logObjs;
        if (logger.isTraceEnabled())
        {
            logObjs = new Object[]
            {
                Integer.valueOf(curIndex),
                Integer.valueOf(refIndex),
                Integer.valueOf(a0),
                Integer.valueOf(b1),
                Integer.valueOf(imageWidth),
            };
            logger.trace("\n\tdetectB1\tcurIndex={}, refIndex={}, a0={}, b1={}, imageWidth={}", logObjs);
        }
		if (curIndex!=0) { //not at beginning of row
			while (b1 <= a0 && b1 < imageWidth) {
                logger.trace("\t\trefIndex={}, b1={}", refIndex, b1);
				int r = ref[refIndex] + ref[refIndex+1];
				if (r==0) b1=imageWidth;
				b1 += r;
				if (refIndex+2<ref.length) refIndex += 2; 
				else
                {
                    logger.error("ERROR in detectB1, refIndex={}, ref.length={}", Integer.valueOf(refIndex), Integer.valueOf(ref.length));
                }
			}
 		}
	}
	
	public void copyBits( byte[] bytesArray, byte[] tmp, int j, int shift ) {
			
			byte b1=bytesArray[j];
			byte b2=(j+1<bytesArray.length ? bytesArray[j+1] : 0);
			byte b3=(j+2<bytesArray.length ? bytesArray[j+2] : 0);

			if (shift>0) {

				if (hiloBitOrder) {
					tmp[1] = (byte) ( (((int)b1 & 0xff) >>> shift)  
												+   (((int)b2 & (0xff >>> 8-shift)) << 8-shift ) );
					tmp[0] = (byte) ( (((int)b2 & 0xff) >>> shift ) 
												+   (((int)b3 & (0xff >>> 8-shift)) << 8-shift ) );
				}
				else {
					tmp[0] = (byte) (( ((int)b1 & 0xff) << shift ) + ( ((int)b2 & 0xff) >> 8-shift ));
					tmp[1] = (byte) (( ((int)b2 & 0xff) << shift ) + ( ((int)b3 & 0xff) >> 8-shift ));
				}

			}
			else {

				if (hiloBitOrder) {
					tmp[1] = b1;
					tmp[0] = b2;
				}
				else {
					tmp[0] = b1;
					tmp[1] = b2;
				}
			}			
	}

	public void decodePass() {
        Object[] logObjs= new Object[6];
        boolean traceEnabled = logger.isTraceEnabled();
        if (traceEnabled)
        {
            logObjs[0] = Integer.valueOf(a0);
            logObjs[1] = Integer.valueOf(b1);
            logObjs[2] = Integer.valueOf(refIndex);
        }
		detectB1();
		b1+=ref[refIndex++];
		runLength += b1 - a0;
		a0 = b1; 
		b1+=ref[refIndex++]; 
        if (traceEnabled)
        {
            logObjs[3] = Integer.valueOf(a0);
            logObjs[4] = Integer.valueOf(b1);
            logObjs[5] = Integer.valueOf(refIndex);
            logger.trace("\ndecodePass()\ta0={}, b1={}, refIndex={} ==> a0={}, b1={}, refIndex={}", logObjs);
        }
	}
	
	public int decodeHorizontal (byte[] tmp, int i) {

        StringBuilder sb = new StringBuilder();
        boolean traceEnabled = logger.isTraceEnabled();

		do {
			int j = i/8;
			int shift = (i%8);
			
			copyBits( bytesArray, tmp, j, shift ); 
	
			if (whiteRun) node=WhiteTree.Find(Converter.bytesToInt(tmp));
			else 					node=BlackTree.Find(Converter.bytesToInt(tmp));
			if (node != null)	code = node.getCode();
	
			if (code.runLength>=0) {

                if (traceEnabled)
                {
                    sb.append( (whiteRun?"W":"B") );
                    sb.append( Integer.valueOf(code.runLength) );
                }
	
				if (code.runLength<64) {
					addRun(code.runLength+longHoriztonalRun); 
					whiteRun = !whiteRun;
					longHoriztonalRun=0;
				}
				else longHoriztonalRun += code.runLength;
					
			}
			else if (code.runLength==T4Code.EOF) {
				lines --;
                if (traceEnabled)
                {
    				sb.append("---");
    				sb.append(code);
                }
				return T4Code.EOF; //reached the end of the image!
			}
			else {
				addRun(code.runLength); 
                if (traceEnabled)
                {
                    sb.append(code);
                    sb.append("~~");
                    sb.append( (whiteRun?"W":"B"));
                    sb.append( code.runLength );
                    sb.append("~~");
                }
			}
	
			i += code.bitLength;					
			
			if (nPixels > 0 && code.runLength==T4Code.EOL ) //end of the line
				{
				whiteRun = true; //always start with white
				lines++;
				resetRuns(); 
				}

		} while (code.runLength>=64);

        if (traceEnabled)
        {
            logger.trace("{}", sb);
        }
		return i; 
	}	
	
	public void addRun( int x ) {
        Object[] logObjs;
		runLength += x; 

        boolean traceEnabled = logger.isTraceEnabled();
        if (traceEnabled)
        {
            logObjs = new Object[]
            {
                Integer.valueOf(x),
                Integer.valueOf(runLength),
                Integer.valueOf(a0),
                Integer.valueOf(b1),
                Integer.valueOf(curIndex),
                Integer.valueOf(refIndex)
            };
            logger.trace("\naddRun({}), runLength={}, a0={}, b1={}, curIndex={}, refIndex={}", logObjs );
        }
		
		if (runLength<0 || curIndex+1>=cur.length || nPixels+runLength>=rawImage.length || runLength>=WhiteRun.length) {
            if (logger.isDebugEnabled())
            {
                logObjs = new Object[]
                {
                    Integer.valueOf(x),
                    Integer.valueOf(runLength),
                    Integer.valueOf(curIndex),
                    Integer.valueOf(nPixels),
                    Integer.valueOf(cur.length),
                    Integer.valueOf(rawImage.length),
                    Integer.valueOf(WhiteRun.length),
                };
                logger.debug( "x={}, runLength={}, curIndex={}, nPixels={}\ncur.length={}, rawImage.length={}, WhiteRun.length={}");
            }
			return;
		}
		
		cur[curIndex++] = runLength; 
		a0 += x; 

		if (runLength > 0) {
            logger.trace("runLength > 0 so create the pixels to match");
			System.arraycopy( (whiteRun ? WhiteRun : BlackRun), 0, rawImage, nPixels, runLength );
			nPixels += runLength;
		}
		
		runLength = 0; 

        if (traceEnabled)
        {
            logObjs = new Object[]
            {
                Integer.valueOf(runLength),
                Integer.valueOf(a0),
                Integer.valueOf(b1),
                Integer.valueOf(curIndex),
                Integer.valueOf(refIndex),
            };
            logger.trace("---->runLength={}, a0={}, b1={}, curIndex={}, refIndex={}", logObjs);
        }

	}
	
	public void resetRuns() {

        StringBuilder sb = new StringBuilder();

        boolean traceEnabled = logger.isTraceEnabled();

        if (traceEnabled)
        {
            logger.trace("\nresetRuns");
            logger.trace("--------------------------- Current Line #{}--------------------------", Integer.valueOf(lines-1));
            for (int i=0; i<curIndex; i++)
            {
                sb.append(cur[i]);
                sb.append((i!=0 && i%8==0 ? "\n" : ", "));
            }
            logger.trace("{}*", sb);
            sb = new StringBuilder();
        }

		addRun(0);
        logger.trace("after addRun(0), a0={}", Integer.valueOf(a0));
		
		/* reset a0 *****************************************/
		if (a0 != imageWidth) {
			logger.warn( "{}", (a0 < imageWidth ? "Premature EOL" : "Line length mismatch") );
			while (a0 > imageWidth) 
				a0 -= cur[--curIndex];
			if (a0 < imageWidth) {
				if (a0 < 0) a0 =0;
				if ((curIndex & 0x1) != 0) addRun(0);
				addRun(imageWidth-a0);// +(a0==0||curIndex==1?1:-a0));
			}
			else if (a0 > imageWidth) {
				addRun(imageWidth);
				addRun(0);
			}
		}
		/****************************************************/
		
        if (traceEnabled)
        {
		
            logger.trace("--------- Reference Line # {} ---------", Integer.valueOf(lines));
            for (int i=0; i<curIndex; i++)
            {
                sb.append(cur[i]);
                sb.append((i!=0 && i%8==0 ? "\n" : ", "));
            }
            logger.trace("{}*", sb);
        }

		
		int tmp[] = ref;
		ref = cur;
		cur = tmp;
		//now zero out extra spots for runs
		for (int i=curIndex; i<imageWidth; i++) ref[i]=0;
		for (int i=0; i<imageWidth; i++) cur[i]=0;
		runLength=0; 
		a0=0;
		b1=ref[0];
		refIndex=1;
		curIndex=0;

	}



}