package sample.Assets;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class HashUtils {
    public static String generateCode(String email) {
        String salt = "1234";
        final int ITERATIONS = 1000;
        final int KEY_LENGTH = 16;
        char[] passwordChars = email.toCharArray();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( passwordChars, salt.getBytes(), ITERATIONS, KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            byte[] result = key.getEncoded();
            StringBuilder sb = new StringBuilder();
            for (Byte b : result) {
                sb.append(b);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String hashPassword(String password) {
        String salt = "$2a$10$KRRn8SnhAL5SR7jQs0oWaO";
        return BCrypt.hashpw(password, salt);
    }
}
