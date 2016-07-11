/*  (README.md): 
 *  
 *  # Program designed to take user input to point to a file, which will be 
 *    encrypted using basic substitution/shift cipher.
 *
 *      - Outputs encrypted file to same folder, replacing the copy of the 
 *         unciphered file
 *
 * 
 *
 */

package encryptfiles;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James Bennett | jbenn005@odu.edu
 */
public class Encrypt2 {
    

    private static String inputFile;
    private static final int SHIFT = 5;
    
    /* TEST STUB METHOD - MAIN
    */
    public static void main(String[] args) throws IOException{
        
        getAction();
        
    }

    public static String getInputFile() {
        return inputFile;
    }

    private static void getAction() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do? Press '1' to encrypt a "
                + "file. Press '2' to decrypt a file.");
        int choice = keyboard.nextInt();
        switch(choice){
            case 1: // encrypt
                
                System.out.println("What is the name of the text file you need "
                        + "to encrypt?");
                inputFile = keyboard.next();
                File encryptInput = new File(inputFile);
                File encryptOutput = new File("encrypted" + inputFile);
                System.out.println(encryptInput.exists());
               
                encryptFile(encryptInput, encryptOutput);
                if(encryptOutput.exists()){
                System.out.println("Your file has been encrypted and can "
                        + "be located at: "
                        + encryptOutput.getCanonicalPath());
                }
                encryptInput.delete();
                break;
            
            case 2: // decrypt
                
                System.out.println("What is the name of the file you need to "
                        + "decrypt?");
                String filename = keyboard.next();
                
                File decryptOutput = new File("decrypted" + filename.substring("encrypted".length()));
                File decryptInput = new File(filename);
                
                decryptFile(decryptInput, decryptOutput);
                
                if(decryptOutput.exists()){
                    System.out.println("Your file has been decrypted and can "
                            + "be found at: "
                            + decryptOutput.getCanonicalPath());
                }
                
                break;
        }
    }

    private static void encryptFile(File input,File output) {
        
            
            int value;
        
        // TODO: Separate input and output?
        // Implement array or other to hold unique (random) shiftValues
        try {
        
            FileReader fileReader = new FileReader(input);
                try (BufferedReader reader = new BufferedReader(fileReader)) {
                    FileWriter fw = new FileWriter(output);
                try (BufferedWriter writer = new BufferedWriter(fw)) {
                    while((value = reader.read()) != -1){
                        writer.write(value + SHIFT);
                    }
                }
                }
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void decryptFile(File input, File output) {
        
        int value; 
        try {
            FileReader fr = new FileReader(input);
            try (BufferedReader reader = new BufferedReader(fr)) {
                FileWriter fw = new FileWriter(output);
                try (BufferedWriter writer = new BufferedWriter(fw)) {
                    while((value = reader.read()) != -1){
                        writer.write(value - SHIFT);
                    }
                }
            }
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
