package encryptdecrypt;

public class Unicode extends Encrypter {

    Unicode(String data, int key) {
        super(data, key);
    }

    @Override
    void encrypt() {
        for (int i = 0; i < data.length(); i++) {
            int unicode = (int) data.charAt(i) + key;
            encryptedData += (char) unicode;
        }
    }

    @Override
    void decrypt() {
        for (int i = 0; i < data.length(); i++) {
            int unicode = (int) data.charAt(i) - key;
            decryptedData += (char) unicode;
        }
    }
}
