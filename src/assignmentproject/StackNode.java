package assignmentproject;
// store tree node instances inside stack node

public class StackNode {
	    TreeNode treeNode;
	    StackNode next; // Reference to the next node in the stack

	    // Constructor
	    public StackNode(TreeNode treenode) {
	        this.treeNode = treenode;
	        this.next = null;
	    }

}
