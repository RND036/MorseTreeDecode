package assignmentproject;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
    	// codes and related characters
        String[] codes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",".----","..---","...--","....-",".....","-....","--...","---..","----.","-----" };
        char[] characters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1','2','3','4','5','6','7','8','9','0' };
        
        Tree morseTree = new Tree();
        for (int i = 0; i < codes.length; i++) {
            morseTree.insert(codes[i], characters[i]);
        }
        //print morsecode dictionary

        System.out.println("Morse Code Dictionary (in-order traversal):");
        morseTree.printTree(morseTree.getRoot(), "");
        
        //user input 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message want to decode:");
        String inputmessage = scanner.nextLine();
        
        
     // Decode and reverse the input message
        String decodedMessage = morseTree.decodeReversedMessage(inputmessage);
        
        // Print the decoded message
        System.out.println("Decoded and reversed message: " + decodedMessage);
        
        // Close the scanner
        scanner.close();
    }
}
