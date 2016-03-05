package org.belchan.pass.security;

import java.util.Formatter;

public class KeccakUtil {
	
	/**
	 * get SHA# hash to param string
	 * @param arg any String
	 * @return hash
	 */
	public String getHash(String arg) {
		byte[] b = getByteArray(arg);
		String s = getHexStringByByteArray(b);
		Keccak keccak = new Keccak(1600);
		return keccak.getHash(s, 1088, 32);
	}

	private static byte[] getByteArray(String s) {
		return (s != null) ? s.getBytes() : null;
	}

	/**
	 * Convert the byte array to a hex-string.
	 *
	 * @param array
	 *            byte array
	 * @return hex string
	 */
	private static String getHexStringByByteArray(byte[] array) {
		if (array == null)
			return null;
		StringBuilder stringBuilder = new StringBuilder(array.length * 2);
		@SuppressWarnings("resource")
		Formatter formatter = new Formatter(stringBuilder);
		for (byte tempByte : array)
			formatter.format("%02x", tempByte);
		return stringBuilder.toString();
	}
}
