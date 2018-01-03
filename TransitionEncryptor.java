package FINALassignment10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TransitionEncryptor
 *
 * @author KazukoAura
 * @since 31/03/2017
 * @Version 1.0
 */
public class TransitionEncryptor {

    public static void main(String[] args) {

        try {

            File sample = new File("sample.txt");
            Scanner in = new Scanner(sample);

            PrintWriter out = new PrintWriter("sampleEncrypted.txt");

            TransitionCipher encryptor = new TransitionCipher();
            encryptor.encryptFile(in, out);

            in.close();
            out.close();

        } catch (IOException e) {
            System.out.print(e);
        }

    }

}
