package FINALassignment10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TransitionDecryptor
 * 
 * @author KazukoAura
 * @since 3/04/2017
 * @Version 1.0
 */
public class TransitionDecryptor {

    public static void main(String[] args) {

        try {
            File sample = new File("sampleEncrypted.txt");
            Scanner in = new Scanner(sample);

            PrintWriter out = new PrintWriter("sampleDecrypted.txt");

            TransitionCipher decryptor = new TransitionCipher();
            decryptor.decryptFile(in, out);

            in.close();
            out.close();

        } catch (IOException e) {
            System.out.print(e);
        }

    }

}
