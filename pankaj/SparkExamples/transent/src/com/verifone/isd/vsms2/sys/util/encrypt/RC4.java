/*
 * Created on Oct 29, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sys.util.encrypt;

/**
 * This class is used for the following operations
 *  <br>
 * 1) Hashing the text using <code>SHA256</code>. 
 * 2) Encrypts a text message using RC4 algorithm. 
 */
public class RC4 {

	private byte[] key;

	private short state[];

	private static byte[] keyStr = { 109, 48, 51, 85, 112, 84, 105, 109, 101 };

	/**
	 * Constructor which uses an internal key for encryption. 
	 *
	 */
	public RC4() {
		this(new String(keyStr));
	}

	/**
	 * Constructs the object with a key string.
	 * 
	 * @param keyStr key to be used for encryption. 
	 */
	public RC4(String keyStr) {
		this.key = keyStr.getBytes();
		setup(key);
	}

	/**
	 * Returns the checksum for the content. It uses <code>SHA256</code> algorithm
	 * to generate hash code.
	 * 
	 * @param cont bytes to be hashed.
	 * @return hash code created for the content.
	 */
	public byte[] getChecksum(byte[] cont) {
		byte[] text = new byte[cont.length + keyStr.length];

		System.arraycopy(cont, 0, text, 0, cont.length);
		System.arraycopy(keyStr, 0, text, cont.length, keyStr.length);

		ISecureHash sha = new Sha256();
		return sha.secureHash(text, 0, text.length).getBytes();
	}

	/**
	 * Encrypts the plain text and returns encrypted data.
	 * 
	 * @param plainText plain text data to be encrypted.
	 * @return encrypted data.
	 */
	public byte[] encrypt(byte[] plainText) {
		return cipher(plainText);
	}

	/**
	 * Decrypts the encrypted data. This enforces the requirement that 
	 * key used for both encryption and decryption should be same.
	 * 
	 * @param plainText text to be decrypted
	 * @return decrypted content.
	 */
	public byte[] decrypt(byte[] data) {
		return cipher(data);
	}

	private void setup(byte[] key) {
		state = new short[256];
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < state.length; i++)
			state[i] = (short) i;
		for (int i = 0; i < state.length; i++) {
			index2 = (((int) key[index1] & 0xff) + state[i] + index2) % 256;
			short tmp = state[i];
			state[i] = state[index2];
			state[index2] = tmp;
			index1 = (index1 + 1) % key.length;
		}
	}

	private byte[] cipher(byte[] IPData) {
		byte[] OPData = new byte[IPData.length];
		int x = 0;
		int y = 0;
		for (int index = 0; index < IPData.length; index++) {
			x = (x + 1) & 0xff;
			y = (state[x] + y) & 0xff;
			short temp = state[x];
			state[x] = state[y];
			state[y] = temp;
			int b = (state[x] + state[y]) & 0xff;
			OPData[index] = (byte) ((IPData[index] ^ state[b]) & 0xff);
		}
		return OPData;
	}
}