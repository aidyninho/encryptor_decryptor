package encryptdecrypt;

public class Shift extends Encrypter {

    Shift(String data, int key) {
        super(data, key);
    }

    String alphabet;

    @Override
    void encrypt() {

        for (int i = 0; i < data.length(); i++) {

            if (Character.isUpperCase(data.charAt(i))) {
                alphabet = ALPHABET_UPPER;
            } else {
                alphabet = ALPHABET;
            }

            if (!alphabet.contains("" + data.charAt(i))) {
                encryptedData += data.charAt(i);
                continue;
            }

            if (key + alphabet.indexOf(data.charAt(i)) >= alphabet.length()) {
                encryptedData += alphabet.charAt(key - (alphabet.length() - alphabet.indexOf(data.charAt(i))));
            } else {
                encryptedData += alphabet.charAt(alphabet.indexOf(data.charAt(i)) + key);
            }
        }
    }

    @Override
    void decrypt() {

        for (int i = 0; i < data.length(); i++) {

            if (Character.isUpperCase(data.charAt(i))) {
                alphabet = ALPHABET_UPPER;
            } else {
                alphabet = ALPHABET;
            }

            if (!alphabet.contains("" + data.charAt(i))) {
                decryptedData += data.charAt(i);
                continue;
            }

            if (alphabet.indexOf(data.charAt(i)) - key < 0) {
                decryptedData += alphabet.charAt(alphabet.length() - (key - alphabet.indexOf(data.charAt(i))));
            } else {
                decryptedData += alphabet.charAt(alphabet.indexOf(data.charAt(i)) - key);
            }
        }
    }
}
