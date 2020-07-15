package com.verifone.isd.vsms2.sys.util;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class Base64Coder {
    
 	// Mapping table from 6-bit nibbles to Base64 characters.
	private static final char[] map1 = new char[64];
	static {
		int i = 0;
		for (char c = 'A'; c <= 'Z'; c++)
			map1[i++] = c;
		for (char c = 'a'; c <= 'z'; c++)
			map1[i++] = c;
		for (char c = '0'; c <= '9'; c++)
			map1[i++] = c;
		map1[i++] = '+';
		map1[i++] = '/';
	}

	// Mapping table from Base64 characters to 6-bit nibbles.
	private static final byte[] map2 = new byte[128];
	static {
		for (int i = 0; i < map2.length; i++)
			map2[i] = -1;
		for (int i = 0; i < 64; i++)
			map2[map1[i]] = (byte) i;
	}

	/**
	 * Encodes a byte array into Base64 format. No blanks or line breaks are
	 * inserted.
     * <p>
     * The padding character ('=') is added to end of sting if need be.
     * <p>
     * This this method invokes::
     * <pre><code>
     *     return Base64Coder.encode(encodeStr, true);
     * </code></pre>
	 * 
	 * @param encodeStr
	 *            array of bytes containing data bytes to be encoded.
	 * @return A String with the Base64 encoded data.
     *
     * @see #encode(byte[], boolean)
	 */
	public static String encode(byte[] encodeStr) {
        return encode(encodeStr, true);
    }
    
    /**
     * Encodes a byte array into Base64 format. No blanks or line breaks are
     * inserted.
     * @param encodeStr array of bytes containing data bytes to be encoded.
     * @param addPadding If <code>true</code>, add padding character '=' if needed.
	 * @return A String with the Base64 encoded data.
     */
	public static String encode(byte[] encodeStr, boolean addPadding) {
		int iLen = encodeStr.length;
		int oDataLen = (iLen * 4 + 2) / 3; // output length without padding
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int ip = 0;
		int op = 0;
		while (ip < iLen) {
			int i0 = encodeStr[ip++] & 0xff;
			int i1 = ip < iLen ? encodeStr[ip++] & 0xff : 0;
			int i2 = ip < iLen ? encodeStr[ip++] & 0xff : 0;
			int o0 = i0 >>> 2;
			int o1 = ((i0 & 3) << 4) | (i1 >>> 4);
			int o2 = ((i1 & 0xf) << 2) | (i2 >>> 6);
			int o3 = i2 & 0x3F;
            baos.write(map1[o0]);
            op++;
            baos.write(map1[o1]);
            op++;
            if (op < oDataLen)
            {
                baos.write(map1[o2]);
            } else if (addPadding)
            {
                baos.write('=');
            }
			op++;
            if (op < oDataLen)
            {
                baos.write(map1[o3]);
            } else if (addPadding)
            {
                baos.write('=');
            }
            op++;
		}
		return new String(baos.toByteArray(), Charset.defaultCharset());
	}

	/**
	 * No blanks or line breaks are allowed within the Base64 encoded data.
	 * 
	 * @param decodeStr
	 *            String containing the Base64 encoded data.
	 * @return An array containing the decoded data bytes.
	 * @throws IllegalArgumentException
	 *             if the input is not valid Base64 encoded data.
	 */
	public static byte[] decode(String decodeStr) {
		char[] in = decodeStr.toCharArray();
		int iLen = in.length;
        
        while (iLen > 0 && in[iLen - 1] == '=')
        {
            iLen--;
        }
        
        int lenMod4 = iLen % 4;
        if ( lenMod4 == 1 )
        {
            throw new IllegalArgumentException(
                    "Length of Base64 encoded input string is invalid!");
        }
        int oLen = (iLen * 3) / 4;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int ip = 0;
		int op = 0;
		while (ip < iLen) {
			int i0 = in[ip++];
			int i1 = in[ip++];
			int i2 = ip < iLen ? in[ip++] : 'A';
			int i3 = ip < iLen ? in[ip++] : 'A';
			if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127)
            {
				throw new IllegalArgumentException(
						"Illegal character in Base64 encoded data.");
            }
			int b0 = map2[i0];
			int b1 = map2[i1];
			int b2 = map2[i2];
			int b3 = map2[i3];
			if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0)
            {
				throw new IllegalArgumentException(
						"Illegal character in Base64 encoded data.");
            }
			int o0 = (b0 << 2) | (b1 >>> 4);
			int o1 = ((b1 & 0xf) << 4) | (b2 >>> 2);
			int o2 = ((b2 & 3) << 6) | b3;
            baos.write(o0);
            op++;
			if ((op < oLen) || (lenMod4 == 3))
            {
                baos.write(o1);
                op++;
            }
			if ((op < oLen) || (lenMod4 == 0))
            {
                baos.write(o2);
                op++;
            }
		}
		return baos.toByteArray();
	}
}
