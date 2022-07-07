//Code from lab 3 building a BST class a node values 
// 5/2/21
//used pusdocode from Dr.Ahmeed lecture in my fill tree method
// 5/2/21
import java.util.ArrayList;

public class BST {
    //create a new node called root which will hold the tree
    public Node root;
    //a counter to count where values occur in file
    int count = 0;
    //BST constuctor
    BST(){
        root = null;
    }
    //node class and consrtctors     
    class Node{
        public int data;
        public Node left;
        public Node right;
        ArrayList<Integer> arrayList = new ArrayList<>();
        //assigns values to the nodes
        public Node(int value){
            data = value;
            left = null;
            right = null;
            arrayList.add(count);
        }
    }

    //set value at root and is used in fillTree
    public void fillTree(int value){
        root = fillTree(root, value);
    }

    //This method takes in the value presetned
    //in the data and fills in the tree
    public Node fillTree(Node node, int value){
        //covers the first case and adds a new node
        if(node == null){
            count++;
            node = new Node(value);
            return node;
        }
        //fills in the tree and adds the count
        else if(node.data == value){
            count ++;
            node.arrayList.add(count);
            return node;
        }
        //follows the left side of the tree
        if(node.data > value){
            node.left = fillTree(node.left, value);
        }
        //follows the right side of the tree
        else if(node.data < value){
            node.right = fillTree(node.right, value);
        }
        return node;
    }
    //this is a boolean that checks if the number is within
    //the tree 
    public Boolean search(Node node, int value){
        //base case if node is null then...
        if(node == null){
            return false;
        }
        //checks if the value is in the data
        else if(node.data == value){
            return true;
        }
        //checks the right node if the value is in there
        //also checks the left node if data is >
        else if(node.data < value){
            return search(node.right, value);
        }
        else{
            return search(node.left, value);
        }
    }
    //this counts how many times the value appears within the tree
    public int Count(Node node, int value){
        if(node == null){
            return -1;
        }
        //checks if the value is the data 
        //if so returns the size of the array 
        if(node.data == value){
            return node.arrayList.size();
        }
        //Does the same thing but it goes to the left
        else if(node.data > value){
            return Count(node.left, value);
        }
        //checks the right
        else{
            return Count(node.right, value);
        }
    }
    //
    //This gets the array that i have been filling
    //up and gets where it where it has been  
    //duplicated when filling the tree.
    public String returnArray(Node node, int value){
        //checks if the value is in the data
        //if so returns the array as a string
        if(value == node.data){
            return node.arrayList.toString();
        }
        //checks the left side of the tree
        if(node.data > value){
            return returnArray(node.left, value);
        }
        //checks the right side of the tree
        if(node.data < value){
            return returnArray(node.right, value);
         }
        return "";
    }   
}

