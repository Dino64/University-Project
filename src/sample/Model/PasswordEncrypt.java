package sample.Model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

//Im on my way to make this shit work!
public abstract class PasswordEncrypt {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int ITERATIONS = 4000;
    private static final int KEY_LENGTH = 128;
    private static final String Algorithm ="PBKDF2WithHmacSHA512";


    public static String generateSalt (final int length) {

        if (length < 1) {
            System.err.println("ERROR in generateSalt: Must Be > 0");
        }

        byte[] salt = new byte[length];
        RANDOM.nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }
    public static String hashPassWord (String passWord, String salt) {

        char[] cha = passWord.toCharArray();
        byte[] byt = salt.getBytes();
        String back = "";

        PBEKeySpec speca = new PBEKeySpec(cha, byt, ITERATIONS, KEY_LENGTH);

        Arrays.fill(cha, Character.MIN_VALUE);

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(Algorithm);
            byte[] securePassWord = skf.generateSecret(speca).getEncoded();
            back =  Base64.getEncoder().encodeToString(securePassWord);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Error in hashing procedure");
        } finally {
            speca.clearPassword();
        }
        return back;
    }

    public static boolean verifyPass (String passWord, String key, String salt) {
        String encrypt = hashPassWord(passWord, salt);
        return encrypt.equals(key);
    }

}
