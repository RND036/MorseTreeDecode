package assignmentproject;

public class Tree {
    TreeNode root;
    
    public Tree() {
        root = new TreeNode('\0'); // Root node with a null character
    }
    
    // Inserts a character using its Morse code
    public void insert(String morseCode, char character) {
        root = insert(root, morseCode, character, 0);
    }
    
    private TreeNode insert(TreeNode node, String morseCode, char character, int index) {
        if (node == null) {
            node = new TreeNode('\0'); // Create a new node if necessary
        }
        if (index == morseCode.length()) {
            node.data = character; // Assign the character at the end of the Morse code
        } else {
            char signal = morseCode.charAt(index);
            if (signal == '.') {
                node.left = insert(node.left, morseCode, character, index + 1);
            } else if (signal == '-') {
                node.right = insert(node.right, morseCode, character, index + 1);
            }
        }
        return node;
    }
    
    // Method to print the Morse code tree
    public void printTree(TreeNode node, String code) {
        if (node == null) {
            return;
        }
        printTree(node.left, code + ".");  // Traverse the left subtree
        if (node.data != '\0') {
            System.out.println(node.data + " : " + code);  // Print character and Morse code
        }
        printTree(node.right, code + "-"); // Traverse the right subtree
    }
 // Decode a single Morse code sequence
    public char decode(String code) {
        TreeNode current = root;
        for (int i = 0; i < code.length(); i++) {
            char signal = code.charAt(i);
            if (signal == '.') {
                current = current.left;
            } else if (signal == '-') {
                current = current.right;
            }
            if (current == null) {
                return ' '; // Return blank if the code is invalid
            }
        }
        return current.data;
    }

    // Reverse a string
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

 // Function to decode and reverse the encoded message
    public String decodeReversedMessage(String message) {
        // First, reverse the entire message
        String reversedMessage = reverseString(message);

        // Split the reversed message into words using "/" (representing space between words)
        String[] words = reversedMessage.split("/");
        StringBuilder decodedMessage = new StringBuilder();

        // Decode each word
        for (String word : words) {
            // Split the word into individual Morse code symbols using spaces (representing space between characters)
            String[] morseCodes = word.trim().split(" ");
            for (String code : morseCodes) {
                if (!code.isEmpty()) { // Skip empty codes
                    decodedMessage.append(decode(code)); // Decode each Morse code to a character
                }
            }
            decodedMessage.append(" "); // Add a space between decoded words
        }

        // Return the final decoded message (trim any extra spaces at the end)
        return decodedMessage.toString().trim();
    }

    
    public TreeNode getRoot() {
        return root;
    }
}
