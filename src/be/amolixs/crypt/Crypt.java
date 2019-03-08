package be.amolixs.crypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe qui gère les cryptographie de mon programme
 * @version 1.0
 * @author amolixs
 */

public class Crypt {
	
	/**
	 * @author amolixs
	 * @param password
	 * 		Mot de passe à crypter
	 * @return Le mot de passe crypter
	 * @throws NoSuchAlgorithmException 
	 */
	public static String cryptMd5(String ph) throws NoSuchAlgorithmException {
        String password = ph;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}
}
