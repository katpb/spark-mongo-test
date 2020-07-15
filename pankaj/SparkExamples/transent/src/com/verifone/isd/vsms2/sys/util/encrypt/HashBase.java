/*
 * Created on Jan 14, 2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sys.util.encrypt;

/**
 * Base class for implementation of all the hash algorithms.
 */
public abstract class HashBase implements ISecureHash {
	protected String name;

	protected int hashSize;

	protected int blockSize;

	protected long count;

	protected byte buffer[];

	/**
	 * Constructs a hash object using the algorithm passed as the parameter.
	 * 
	 * @param name
	 *            algorithm to be used for creating the hash.
	 * @param hashSize
	 *            size of the hash.
	 * @param blockSize
	 *            block size.
	 */
	protected HashBase(String name, int hashSize, int blockSize) {
		this.name = name;
		this.hashSize = hashSize;
		this.blockSize = blockSize;
		buffer = new byte[blockSize];
		resetContext();
	}

	/**
	 * Returns the name of the algorithm.
	 * 
	 * @return algorithm used to create the checksum
	 */
	public String name() {
		return name;
	}

	/**
	 * Returns the hash size.
	 * 
	 * @return hash size
	 */
	public int hashSize() {
		return hashSize;
	}

	/**
	 * Returns block size
	 * 
	 * @return block size
	 */
	public int blockSize() {
		return blockSize;
	}

	/**
	 * Adds bytes for creating checksum.
	 * 
	 * @param b
	 *            a byte
	 */
	public void update(byte b) {
		int i = (int) (count % (long) blockSize);
		count++;
		buffer[i] = b;
		if (i == blockSize - 1) {
			transform(buffer, 0);
		}
	}

	/**
	 * Creates and returns hash for the palin text message.
	 * 
	 * @param plainText
	 *            text for which hash code is to be created.
	 */
	public String secureHash(String plainText) {
		byte[] b = plainText.getBytes();
		return secureHash(b, 0, b.length);
	}

	/**
	 * Creates the hash code for the message passed as byte array.
	 * 
	 * @param b
	 *            byte array of message.
	 * @param offset
	 *            starting byte to be considered for hashing.
	 * @param len
	 *            number of bytes to be taken from the array.
	 */
	public String secureHash(byte b[], int offset, int len) {
		update(b, offset, len);

		byte[] result = digest();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < result.length; i++) {
			int bi = result[i];
			int hexDigit1 = (bi & 0xf0) >> 4;
			int hexDigit2 = bi & 0xf;
			sb.append(Character.forDigit(hexDigit1, 16));
			sb.append(Character.forDigit(hexDigit2, 16));
		}
		return sb.toString();
	}

	public void update(byte b[], int offset, int len) {
		int n = (int) (count % (long) blockSize);
		count += len;
		int partLen = blockSize - n;
		int i = 0;
		if (len >= partLen) {
			System.arraycopy(b, offset, buffer, n, partLen);
			transform(buffer, 0);
			for (i = partLen; (i + blockSize) - 1 < len; i += blockSize) {
				transform(b, offset + i);
			}

			n = 0;
		}
		if (i < len) {
			System.arraycopy(b, offset + i, buffer, n, len - i);
		}
	}

	public byte[] digest() {
		byte tail[] = padBuffer();
		update(tail, 0, tail.length);
		byte result[] = getResult();
		reset();
		return result;
	}

	public void reset() {
		count = 0L;
		for (int i = 0; i < blockSize;) {
			buffer[i++] = 0;
		}

		resetContext();
	}

	protected abstract byte[] padBuffer();

	protected abstract byte[] getResult();

	protected abstract void resetContext();

	protected abstract void transform(byte abyte0[], int i);

	protected byte[] engineDigest() {
		return digest();
	}

	protected void engineReset() {
		reset();
	}

	protected void engineUpdate(byte param) {
		update(param);
	}

	protected void engineUpdate(byte values[], int param, int param2) {
		update(values, param, param2);
	}
}