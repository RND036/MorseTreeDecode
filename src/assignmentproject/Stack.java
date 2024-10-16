package assignmentproject;

public class Stack {
    private StackNode top;

    public Stack() {
        top = null;
    }

    //pushes treenode into stack 
    public void push(TreeNode node) {
        StackNode newNode = new StackNode(node);
        newNode.next = top;
        top = newNode;
    }

    	//pop treenode from stack
    public TreeNode pop() {
        if (isEmpty()) {
            return null;
        }
        TreeNode node = top.treeNode;
        top = top.next;
        return node;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
