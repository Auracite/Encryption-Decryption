package FINALassignment10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TransitionCipher
 * 
 * @author KazukoAura 
 * @since 31/03/2017
 * @Version 1.0
 */
public class TransitionCipher {

    public TransitionCipher() {
        
    }
    
    
    /**
     * Encrypting: Calculates the alphabetic number positioning
     * @param ch the char to be encrypted
     * @return the integer that has been the result from the calculation
     */
    public char encrypt(char ch) {

        int encrypto = ' ';

        int temp = (int) ch;

        // For lower case
        int temp_integer = 96;
        if (temp <= 122 & temp >= 97) {
            encrypto = temp - temp_integer;
        }

        // For upper case  
        int temp_integer2 = 38;
        if (temp <= 90 & temp >= 65) {
            encrypto = temp - temp_integer2;
        }

        return (char) (encrypto);
    }
    
    /**
     * Process the integer to its alphabet form of its name
     * @param ch the char (or rather, integer) to be encrypted to the first letter of name
     * @param out the text-output stream
     * @throws IOException 
     */
    public void toLetters(char ch, PrintWriter out) throws IOException {
        if (ch == '1') {
            out.print('O');
        } else if (ch == '2') {
            out.print('T');
        } else if (ch == '3') {
            out.print("Th");
        } else if (ch == '4') {
            out.print('F');
        } else if (ch == '5') {
            out.print("Fi");
        } else if (ch == '6') {
            out.print('S');
        } else if (ch == '7') {
            out.print("Se");
        } else if (ch == '8') {
            out.print('E');
        } else if (ch == '9') {
            out.print('N');
        } else if (ch == '0') {
            out.print('Z');
        }

    }
    
    
    /**
     * Processes the final encryption accordingly
     * @param in the file to be read
     * @param out the file to be outputted
     * @throws IOException 
     */
    public void encrypt2(Scanner in, PrintWriter out) throws IOException {

        while (in.hasNextLine()) {
            boolean isNum = false;
            boolean isLetter = false;
            boolean space = false;
            String line = in.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char ch1 = line.charAt(i);

                for (int j = 0; j < integer.length && !isNum; j++) {
                    if (integer[j] == (ch1)) {
                        isNum = true;
                    }

                    if (ch1 == ' ') {
                        space = true;
                    }
                }

                for (int k = 0; k < letter.length && !isLetter; k++) {
                    if (letter[k] == (ch1)) {
                        isLetter = true;
                    }
                }

                // Encrypting the individual character in accordance to their classification
                if ((!isNum && isLetter)) {
                    int ch2 = encrypt(ch1);
                    out.print(ch2 + "#");
                    isLetter = false;
                }

                if (isNum) {
                    toLetters(ch1, out);
                    out.print("#");            // '#' is a delimiter for StringTokenizer in the upcoming decryption
                    isNum = false;
                }
                if (space) {
                    out.print(' ' + "#");
                    space = false;
                }

            }

            if (in.hasNextLine()) {
                out.println();
            }
        }
    }
    
    /**
     * Implements the final encryption
     * @param in the file to be read
     * @param out the file to be outputted
     * @throws IOException 
     */
    public void encryptFile(Scanner in, PrintWriter out) throws IOException {
        encrypt2(in, out);
        out.println(" ");
    }

    
    
    /**
     * Decrypting an integer to its corresponding letter in the alphabet
     * @param a the integer to be decrypted
     * @return the casted char 
     */
    public char decrypt(int a) {
        int decrypto = ' ';
        int temp = (int) a;

        // For lower case
        int temp_integer = 96;
        if (temp <= 26 & temp >= 1) {
            decrypto = temp + temp_integer;
        }

        // For upper case
        int temp_integer2 = 38;
        if (temp <= 52 & temp >= 27) {
            decrypto = temp + temp_integer2;
        }
        return (char) (decrypto);
    }
    
    /**
     * Processes the decryption from the string representation to its integer form
     * @param str the string to be decrypted
     * @param out the text-output stream
     * @throws IOException 
     */
    public void toNum(String str, PrintWriter out) throws IOException {
        if ("O".equals(str)) {
            out.print('1');
        } else if ("T".equals(str)) {
            out.print('2');
        } else if ("Th".equals(str)) {
            out.print('3');
        } else if ("F".equals(str)) {
            out.print('4');
        } else if ("Fi".equals(str)) {
            out.print('5');
        } else if ("S".equals(str)) {
            out.print('6');
        } else if ("Se".equals(str)) {
            out.print('7');
        } else if ("E".equals(str)) {
            out.print('8');
        } else if ("N".equals(str)) {
            out.print('9');
        } else if ("Z".equals(str)) {
            out.print('0');
        }

    }
    /**
     * Processes and implements the final decryption
     * @param in the text-input stream
     * @param out the text-output stream
     * @throws IOException 
     */
    public void decryptFile(Scanner in, PrintWriter out) throws IOException {

        while (in.hasNextLine()) {
            String delimiter = "#";
            String str1 = in.nextLine();
            StringTokenizer st = new StringTokenizer(str1, delimiter);
            boolean space = false;

            while (st.hasMoreElements()) {

                String split = (String) st.nextElement();

                if (" ".equals(split)) {
                    space = true;
                }

                int intChecker = ' ';
                if (space == false) {
                    
                    try {
                        intChecker = Integer.parseInt(split);
                        char toAlpha = decrypt(intChecker);
                        System.out.print(toAlpha);
                    } catch (NumberFormatException e) {
                        String letterToNum = split;
                        toNum(letterToNum, out);
                    }
                    
                }

                if (space == true) {
                    out.print(" ");
                    space = false;
                }

            }

            if (in.hasNextLine()) {
                out.println();

            }

        }

    }

    // Array only for pre-defined classification differentiation between integer and alphabet during encryption only
    char[] integer = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

}
