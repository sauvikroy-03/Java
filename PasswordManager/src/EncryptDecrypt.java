import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptDecrypt {

    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128; // Authentication tag length
    private static final int IV_LENGTH_BYTE = 12;  // Recommended GCM IV length

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }


    public static String encrypt(String plainText, SecretKey key) throws Exception {
        // 1. Generate a random IV for this specific encryption run
        byte[] iv = new byte[IV_LENGTH_BYTE];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        // 2. Initialize the Cipher for Encryption
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        // 3. Encrypt the data
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        // 4. Combine IV and CipherText into a single byte array for easy storage
        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + cipherText.length);
        byteBuffer.put(iv);
        byteBuffer.put(cipherText);
        byte[] encryptedMessage = byteBuffer.array();
        // 5. Convert to Base64 String for safe terminal printing or DB storage
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }


    public static String decrypt(String encryptedBase64Text, SecretKey key) throws Exception {
        // 1. Decode the Base64 text back into bytes
        byte[] encryptedMessage = Base64.getDecoder().decode(encryptedBase64Text);

        // 2. Extract the IV from the beginning of the byte array
        ByteBuffer byteBuffer = ByteBuffer.wrap(encryptedMessage);
        byte[] iv = new byte[IV_LENGTH_BYTE];
        byteBuffer.get(iv);

        // 3. Extract the remaining bytes (the actual ciphertext)
        byte[] cipherText = new byte[byteBuffer.remaining()];
        byteBuffer.get(cipherText);

        // 4. Initialize the Cipher for Decryption using the extracted IV
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

        // 5. Decrypt and return the original plain text string
        byte[] plainText = cipher.doFinal(cipherText);
        return new String(plainText);
    }
}
