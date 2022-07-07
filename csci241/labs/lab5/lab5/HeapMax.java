import java.util.ArrayList;

//Xavier Rodriguez 5/19/2021
/*
For this Lab 5 Assignment, I used resources from my professors lecture slides and 
 *  the TA's help to have a better understanding on how to start this lab. 
 *  along with that i used online resources of Pseudocode and explaninations on MaxHeap and other Java keywords to 
 *  understand and start the process of making my methods.
 * 
 * i used this to understand the funcions that i can use in arrayList
 * https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
 * 
 * 
*/

public class HeapMax{
    public int num;
    public ArrayList<Integer> Heap;
    public int left = 2* num + 1;
    public int right = 2* num + 2;
    public int size;

    //this makes the size of the array and is taken in
    //from the test file
    public HeapMax(int size) {
        Heap = new ArrayList<Integer>(size);
    }

    /*
    Inserts a new element to the max heap. 
    The while loop  checks if the size is greater than 0
    */
    public void insert(int number){
        Heap.add(number);

        int i = Heap.size() - 1;
        while(i > 0) {
            int parent= (i - 1) /2;

            if (Heap.get(i) <= Heap.get(parent)){ 
                return; 
            }

            int temp = Heap.get(i);
            Heap.set(i, Heap.get(parent));
            Heap.set(parent, temp);
            i = parent;
        }
        
    }
    
    //This method returns the root of the heap
    public int extractMax() {
        return Heap.get(0);
    }      

    // this method removes the max element in the heap
    // and then re-heapifys it to sort it out 
    public int removeMax(){

        int maximum = Heap.get(0);
        int lastElement= Heap.remove(Heap.size() - 1);
        Heap.set(0, lastElement);
        heapify(0);
        return maximum;
    }   

    //This method heapify sorts it in order within the heap
    //checks the number inserted and the heap
    public void heapify(int num) {
        //This while loop basicly says the left child compares to the size
        while((2*num + 1) < Heap.size()) {

            int max = maxChild(num);
                //this states that the number is less than the max then trade the numbers
                if (Heap.get(num) < Heap.get(max)) {
                    //makes a temp to set the heap between the num and temp
                    int temp = Heap.get(max);
                    Heap.set(max, Heap.get(num));
                    Heap.set(num, temp);
                }

                num = max;
        }
    }
    
    //This method gets the max child either from the left 
    //side or the right side
    public int maxChild(int num) {        

            if (Heap.size()-1 < left ) {
                return left;
            }
            else if(Heap.get(right) < Heap.get(left)){
                return left;
            }
            else{
                return right;
            }
    }
    /*
     *  The method prints all the elements in the max heap in the order of levels
     *  and was not able to seperate the different level elements using comma's.
     *  was close to how it was supposed to print but i think 
     */
    public void display(){
        
        System.out.print("Current Heap is:");
        for(int index = 0; index <= Heap.size() -1 ; index++){
                System.out.print(Heap.get(index) + ", ");
        }
        System.out.println();
    }
}