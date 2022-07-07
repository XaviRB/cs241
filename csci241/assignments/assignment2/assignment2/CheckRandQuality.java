import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class CheckRandQuality {
    //my main method that is calling my tree 
    //as well as pulling the txt. file, on top
    //of that prints out the desiered output
    public static void main(String [] args) {
        //creates the BST
        BST BTS = new BST();
        //gets the file and reads it
        //ands stores it in the BST
        try{
            //pulles the file anc puts it in scanner
            File readFile = new File(args[0]);
            Scanner scanner = new Scanner(readFile);
            //while loop that reades everyline in the txt file.
            while(scanner.hasNextInt()){
                //intialize the file as an int and fills it
                //in the tree
                int fileValue = scanner.nextInt();
                BTS.fillTree(fileValue);
            }
                scanner.close();
            }
            //catch
            catch(FileNotFoundException ex){
                System.out.println("Error on file");
            }
        //user arguments and the BTS
        userNums(args, BTS);
    }
    
    //takes in the args that the user put in and searches for those numbers in the tree
    public static void userNums(String[] args, BST BTS){
        //takes the argument and puts it in length
        int length = args.length;

        // goes over args array and searches the BST for the number inputed
        //by the user.
        for(int i = 1; i < length; i++){
            //rerwites the argument into an interger
            int intArgs = Integer.parseInt(args[i]);

            //if the search returns true, then the number is held inside the tree
            if(BTS.search(BTS.root, intArgs)){
                //the size of the ArrayList associated with the node in tree
                int size = BTS.Count(BTS.root, intArgs);

                //Whenever the number showes up more than once it is stored in insertOrder 
                String OrderInsert = BTS.returnArray(BTS.root, intArgs);

                //prints out the string   
                System.out.println(args[i] + " appears, " + size +" times, order of insertion: "+ OrderInsert); 
            }
            else{
                //covers the case if the argument int is not in BST
                System.out.println(args[i] + " NOT FOUND IN BST");
            }
        }
    }
}    
