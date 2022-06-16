package encryptdecrypt;

public abstract class Encrypter {
    String data;
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int key;
    String encryptedData = "";
    String decryptedData = "";

    Encrypter(String data, int key) {
        this.data = data;
        this.key = key;
    }

    abstract void encrypt();

    abstract void decrypt();
}
