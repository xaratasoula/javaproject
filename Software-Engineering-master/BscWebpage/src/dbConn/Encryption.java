package dbConn;
import sun.security.provider.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public static String makeHash(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexStr = new StringBuffer();
            for (int i = 0; i < encodedhash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedhash[i]);
                if (hex.length() == 1) hexStr.append('0');
                hexStr.append(hex);
            }
            return hexStr.toString();
        } catch (Exception e) {
            System.out.println("Error during hash generation");
            return null;
        }
    }

}
