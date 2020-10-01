package dbConn;
import sun.security.provider.SecureRandom;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class MD5 {
    public static String makeHash(String password, byte[] salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder saltedHash = new StringBuilder();
            for (byte b : hashedPassword)
                saltedHash.append(String.format("%02x", b));
            return saltedHash.toString();
        } catch (Exception e) {
            System.out.println("Error during hash generation");
            return null;
        }
    }
    public static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.engineNextBytes(salt);
        System.out.println("salt: "+ Arrays.toString(salt));
        return salt;
    }

    public static void main(String[] args){
        System.out.println(makeHash("unsafePassword",generateSalt()));
    }
}

