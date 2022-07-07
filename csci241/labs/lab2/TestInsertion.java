
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class TestInsertion{
    //
    //isSorted boolean method, this returns 
    //true if the list is returned in ascending order
    //if false will return false
    private static boolean isSorted(int A[]){
        int key = A.length;
        for(int i = 1; i < key; i++){
            if( A[i] >= A[i - 1] ){
                return true;
            }
        }
        return false;
    }
    //
    //sameElements method, this returns if the list has
    //the same count as elements otherwise will return false
    private static boolean sameElements(int A1[], int A2[]){
        //made two hashmaps tables so i can put them in arrays
        HashMap < Integer, Integer > Array1 = hashHelp(A1);
        HashMap < Integer, Integer > Array2 = hashHelp(A2);

        //pulls both hashmaps and compares them to
        //check if the list has the same elements
        //if not then it will return false
        if(Array1.equals(Array2)){
            return true;
        }
        else{
            return false;
        }
    }
    //
    //hashHelp made this helper method to count and find the elements
    private static HashMap < Integer, Integer > hashHelp (int A[]){
        HashMap < Integer, Integer > elementFinder = new HashMap < Integer, Integer >();
        int key = A.length;
        int count = 0;
        //created a for loop to travel through the list
        for(int j = 0; j < key; j++){
            //this looks for the specfic element
            //and if not it raises the count
            if(elementFinder.containsKey(A[j])){
                continue;
            }
            else{
                count = 0;
                for(int i = 0; i < key; i++){
                    count ++;
                }
                elementFinder.put(A[j], count);
            }
        } 
        //returns usorted list and returns it in the hashmap 
        return elementFinder;
    }

    //
    //testFromConsole allows manual testing
    //for array lists
    private static void testFromConsole(){
        Scanner inputs = new Scanner(System.in);
        //made this a while statement so it can run
        //until the user does ctr-c
        while(true){
            System.out.println("How long is the Array?");
            int arraylength = inputs.nextInt();
            int inputlist[] = new int [arraylength];
            System.out.println("What are the digits in the Array?");
            //makes a list considering the users input
            for(int i = 0; i < arraylength; i++){
                int userlist = inputs.nextInt();
                inputlist[i] = userlist;
            }
            //calls sort from insertionsort and sorts list
            InsertionSort list = new InsertionSort();
            int sorted[] = list.sort(inputlist);

            //boolean statment to make it true or false
            //if list is sorted or not
            boolean same = sameElements(inputlist, sorted);
            boolean is = isSorted(sorted);            
            //statemnet compare if lists equals true
            if (same == true && is == true ){
                System.out.println("PASSED TEST");
            }
            else{
                System.out.println("FAILED TEST");
            }
        }     
    }
    //
    //shuffle test method taking in N length
    private static void shuffleTest(int N){
        //making a new list that will be in memory
        ArrayList<Integer> A = new ArrayList<Integer>();

        //moves through the list
        for(int i = 0; i < N; i++){
            A.add(i);
        }
        //makes a new list of a copy 
        ArrayList<Integer> copy = new ArrayList<>(A);
        int[] copylist = copy.stream().mapToInt(i -> i).toArray();
        //moves through the list
        for(int i = 0; i < N; i++){
            copy.add(i);
        }
        // shuffles the list
        Collections.shuffle(A);
        int[] sortedlist = A.stream().mapToInt(i -> i).toArray();
        //calls insertionsort and sorts list
        InsertionSort.sort(sortedlist);
        //boolean checks if list is the same
        if(Arrays.equals(sortedlist,copylist) == true){
            System.out.println("PASSED TEST");
        }
        else{
            System.out.println("FAILED TEST");
        }
    }

    //main method where everything is being called
    //runs testfromconsole or runs shuffle test.
    public static void main(String[] args) {
        if(args.length == 0){  
            testFromConsole();
        }
        else{
            int length = args.length;
            for(int N = 0; N < length; N++){
                //changes args into int
                Integer.parseInt(args[N]);
                shuffleTest(N);

            }
        }

    }
}
