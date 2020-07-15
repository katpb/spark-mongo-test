package com.verifone.isd.vsms2.sys.util.image.tiff;
import com.verifone.isd.vsms2.sys.util.image.tiff.util.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class T4Node {
	public static final int NOMASK = 0xffff; 
	
	private int mask;
	private T4Node zero;
	private T4Node one;
	private T4Code code;

    private Logger logger = LoggerFactory.getLogger(T4Node.class);
	
	public T4Node() {
		mask = 0xffff;
		zero = null;
		one = null;
		code = null;
	}

	public String toString() {
		StringBuffer sz = new StringBuffer();
		String szMask = Converter.intToBinaryString(mask,16);
		int i = (mask!=NOMASK ? szMask.indexOf("1") : code.bitLength);
		sz.append("\n");
		for (;i>0; i--) sz.append(" ");
		sz.append( "{" );
		sz.append( szMask ); 
		sz.append( "," );
//		if (zero==null) sz.append("null");
//		else sz.append( zero.toString() );
		sz.append( zero ); 
		sz.append( "," );
//		if (one==null) sz.append("null");
//		else sz.append( one.toString() );
		sz.append( one ); 
		sz.append( "," );
		sz.append( code );
		sz.append( "}" );
		return sz.toString();
	}
	
	public void Add( int d, T4Code c ) {

        boolean traceEnabled = logger.isTraceEnabled();
        StringBuilder sb = new StringBuilder();

		if (d == c.bitLength) { //end of the line
			code = c;
            logger.trace("Added T4Node for {}", c);
		}
		else {
			d++;
			if (mask == NOMASK) {
				mask = 1<<( 16-d );
                if (traceEnabled)
                {
                    sb.append("Added ");
                }
			}

			int bits = c.codeWord << (16-c.bitLength); 

            if (traceEnabled)
            {
                sb.append("mask (");
                sb.append(Converter.intToBinaryString(mask,16));
                sb.append(") T4Node for ");
                sb.append(Converter.intToBinaryString(bits,16));
            }
			if ((bits & mask) == 0) {
                logger.trace("{} --> add to zero side", sb);
				if (zero == null)
					zero = new T4Node(); 
				zero.Add( d, c );
			}
			else {
                logger.trace("{} --> add to ones side", sb);
				if (one == null)
					one = new T4Node(); 
				one.Add( d, c );
			}
		}
	}


	public void ReversedAdd( int d, T4Code c ) {
        boolean traceEnabled = logger.isTraceEnabled();
        StringBuilder sb = new StringBuilder();
		if (d == c.bitLength) { //end of the line
			code = c;
            logger.trace("Added T4Node for {}", c);
		}
		else {
			if (mask == NOMASK) {
				mask = 1<<( d ); 
				sb.append("MASK ");
			}
			else
            {
                sb.append("mask ");
            }
			d++;

			int bits = c.codeWord;

            if (traceEnabled)
            {
                sb.append("(");
                sb.append(Converter.intToBinaryString(mask,16));
                sb.append(") T4Node for ");
                sb.append(Converter.intToBinaryString(bits,16));
            }
				
			if ((bits & mask) == 0) {
                logger.trace("{} --> add to zero side", sb);
				if (zero == null)
					zero = new T4Node(); 
				zero.ReversedAdd( d, c );
			}
			else {
				logger.trace("{} --> add to ones side", sb);
				if (one == null)
					one = new T4Node(); 
				one.ReversedAdd( d, c );
			}
		}
	}
	
	
	public T4Node Find( int i ) {
		if (code != null) {
			logger.trace( "found it: {}", code );
			return this;
		}
		else if (mask != NOMASK) {
			if ((mask & i)==0) {
				logger.trace( "look on zero side");
				return (zero!=null ? zero.Find( i ) : null);
			}
			else {
				logger.trace( "look on ones side");
				return (one!=null ? one.Find( i ) : null);
			}
		}
		else return null;
	}

    /**
     * @return the code
     */
    public T4Code getCode()
    {
        return code;
    }
	
}