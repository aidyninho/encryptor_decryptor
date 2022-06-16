package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String action = "enc";
        int key = 0;
        String data = "";
        boolean hasOut = false;
        boolean hasIn = false;
        String inPath = "";
        String outPath = "";
        String algorithm = "shift";

        try {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-mode")) {
                    action = args[i + 1];
                } else if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                } else if (args[i].equals("-data")) {
                    data = args[i + 1];
                    hasIn = false;
                } else if (args[i].equals("-out")) {
                    hasOut = true;
                    outPath = args[i + 1];
                } else if (args[i].equals("-in") && data.equals("")) {
                    hasIn = true;
                    inPath = args[i + 1];
                } else if (args[i].equals("-alg") && args[i + 1].equals("unicode")) {
                    algorithm = args[i + 1];
                }
            }
        } catch (Exception e) {
            System.out.println("Error with arguments: " + e.getMessage());
        }

        if (hasIn) {
            try {
                File file = new File(inPath);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    data += scanner.nextLine();
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("Error with input file: " + e.getMessage());
            }
        }

        Encrypter encrypter = new Shift(data, key);

        try {
            if (algorithm.equals("unicode")) {
                encrypter = new Unicode(data, key);
            }
        } catch (Exception e) {
            System.out.println("Error with algorithm: " + e.getMessage());
        }

        if (action.equals("enc")) {
            encrypter.encrypt();
            if (hasOut) {
                try {
                    File file = new File(outPath);
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(encrypter.encryptedData);
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error with output file: " + e.getMessage());
                }
            } else {
                System.out.println(encrypter.encryptedData);
            }
        } else if (action.equals("dec")) {
            encrypter.decrypt();
            if (hasOut) {
                try {
                    File file = new File(outPath);
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(encrypter.decryptedData);
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error with output file: " + e.getMessage());
                }
            } else {
                System.out.println(encrypter.decryptedData);
            }
        }
    }
}
