package cn.edu.saif.shared.utils;
import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESDecryption {

	private static final Charset UTF8 = Charset.forName("UTF-8");
	private static final Charset ASCII = Charset.forName("US-ASCII");
	//private static final String CIPHER="AES/CBC/NOPADDING"; 
	private static final String CIPHER="AES/CBC/NoPadding"; 
	private static final String IV="21215981-a113-4e";
	private static final String KEY="21215981-a113-4e";
	
	public static String decrypt(String base64Cipher) throws Exception {
	    byte [] cipherBytes = Base64.decodeBase64(base64Cipher.getBytes(UTF8));
        String tempStr = new String(cipherBytes);
        System.out.println(tempStr);
	    return decrypt(cipherBytes);
	}
	
	public static String decrypt(byte [] cipherBytes) throws Exception {
	    byte [] iv = IV.getBytes(UTF8);
	    byte [] keyBytes = KEY.getBytes(UTF8);
	
	    SecretKey aesKey = new SecretKeySpec(keyBytes, "AES");
	
	    Cipher cipher = Cipher.getInstance(CIPHER);
	    cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
	
	    byte[] result = cipher.doFinal(cipherBytes);
	    
	    return new String(result);
	}

	public static String encrypt(String source) throws Exception {
	    byte [] iv = IV.getBytes(UTF8);
	    byte [] keyBytes = KEY.getBytes(UTF8);
        Cipher cipher = Cipher.getInstance(CIPHER);
        int blockSize = cipher.getBlockSize();
        System.out.println("Block size is: " + blockSize);
        byte[] dataBytes = source.getBytes(UTF8);        
        int plaintextLength = dataBytes.length;
        System.out.println("Input size is: " + plaintextLength);
        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }
        System.out.println("Padded input size is: " + plaintextLength);
        
        // In java, primitive arrays of integer types have all elements
        // initialized to zero, so no need to explicitly zero any part of
        // the array.
        byte[] plaintext = new byte[plaintextLength];

        // Copy our actual data into the beginning of the array.  The
        // rest of the array is implicitly zero-filled, as desired.
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

        SecretKeySpec keyspec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encrypted = cipher.doFinal(plaintext);
        String tempStr = new String(encrypted);
        System.out.println(tempStr);
        
	    return new String(Base64.encodeBase64(encrypted));
	}
}