//Dr. Shameem Ahmed slides from class (used pusdocode in methods isLeaf, inOrder, preOrder, and height)
//05/2/2021
/** a binary search tree class for Lab 4, part 2: Recursion on Trees*/
public class BST {
    public Node root;
    public String traversal;
    /** constructor: create an empty BST */
    public BST() {
        root = null;
    }

    /* return true iff Node n is a leaf node. a null node is not considered
     * a leaf. */
    public boolean isLeaf(Node n) {
        if(n == null){
            return false; //TODO
        }
        //checks if it is a leaf by seeing if both are null
        if(n.right == null && n.left == null){
            return true;
        }
        else{
           return false;
        }
    }

    /** return the number of nodes in the tree */
    public int size() {
        return size(root);
    }

    /* number of nodes in the tree rooted at n
     * = 0 if n is null
     * = 1 + number of nodes in left + number of nodes in right */
    private int size(Node n) {
        //returns with size of nodes and sum of right and left
        if(n != null){
            return (1 + size(n.left) + size(n.right));
        }
        else{
            return 0;
        }
    }


    /** appends the values in the tree to String traversal using an in-order traversal */
    public void inOrder() {
        traversal = "";
        inOrder(root);
    }
    //
    private void inOrder(Node n) {
        // TODO
        // this goes through the left side of the tree first
        // then goes travels through the tree and appends
        if(n != null){
            inOrder(n.left);
            traversal = traversal + n.value;
            inOrder(n.right);
        }
        
        else if(n == null){
            return;
        }
    }


    /**  appends the values in the tree to String traversal using a pre-order traversal */
    public void preOrder() {
        traversal = "";
        preOrder(root);
    }
    private void preOrder(Node n) {
        //very similar to in order but 
        //does it in preorder
        if(n != null){
            traversal += n.value;
            preOrder(n.left);
            preOrder(n.right);
        }

        else if(n == null){
            return;
        }
    }

    /** appends the values in the tree to String traversal using a post-order traversal */
    public void postOrder() {
        traversal = "";
        postOrder(root);
    }
    private void postOrder(Node n) {
        //post the order just appends it last
        if(n != null){
            postOrder(n.left);
            postOrder(n.right);
            traversal = traversal + n.value;
        }
        else if(n == null){
            return;
        }
    }

    /** return the height of the tree.
     *  recall that the height is the path length from the deepest leaf to the
     *  root. special case: an empty tree (root == null) is defined to have
     *  height = -1 */
    public int height() {
        return height(root);
    }

    /* return the height of the tree rooted at n */
    private int height(Node n) {
        //return -1 case covered 
        if (n == null){
            return -1;
        }
        //Made a right most and left most to check the count
        //of where we are on the pointer is going to be
        int rightcount = height(n.right);
        int leftcount = height(n.left);
        //adds count deppending where you are in the tree on leftMost
        if(rightcount < leftcount){
            return leftcount +1;
        }
        //adds count deppending where you are in the tree on rightMost
        else if(rightcount > leftcount){
            return rightcount +1;
        }
    return 0;
    }

    /** inner class representing a node in the tree. */
    public class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;

        /** constructor: gives default values to all fields */
        public Node() { }

        /** constructor: sets only value */
        public Node(int v) {
            value = v;
        }

        /** constructor: sets value and parent fields */
        public Node(int v, Node p) {
            value = v;
            parent = p;
        }

        /** constructor: sets all fields */
        public Node(int v, Node p, Node l, Node r) {
            value = v;
            parent = p;
            left = l;
            right = r;
        }
    }


    /* methods for testing */

    /** constructor: constructs various BST instances for testing */
    public BST(int testCase) {
        switch(testCase) {
            case 0:
                root = null;
                break;
            case 1:
                root = new Node(4);
                break;
            case 2:
                root = new Node(4);
                root.left = new Node(2);
                root.right = new Node(6);
                break;
            case 3:
                root = new Node(4);
                root.left = new Node(2);
                root.right = new Node(6);
                root.right.right = new Node(7);
                root.right.right.right = new Node(8);
                root.right.right.right.right = new Node(9);
                break;
        }
    }

    /** print a sideways representation of the tree - root at left,
     * right is up, left is down. */
    public void printTree() {
        printSubtree(root, 0);
    }
    private void printSubtree(Node n, int level) {
        if (n == null) {
            return;
        }
        printSubtree(n.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("        ");
        }
        System.out.println(n.value);
        printSubtree(n.left, level + 1);
    }
}

