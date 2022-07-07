
import java.util.ArrayList;
/* This heap max file I used from my lab 5 that I turned in.
   The adjustments i made was i made it take in a node and 
   refer to the flightNode file by creating the array list. 
   code is still the skeleton from my professors slides
   5/24/21

   https://wwu.instructure.com/courses/1423593/files/folder/Lectures?preview=77635893
*/
public class HeapMax {
    public int size;
    public int num;
    public ArrayList<flightNode> Heap = new ArrayList<flightNode>();
    
    
    //This method returns the root of the heap
    public flightNode extractMax() {
        return Heap.get(0);
    }      

    // this method removes the max element in the heap
    // and then re-heapifys it to sort it out
    // for the return type i return the node
    public flightNode removeMax(){
        //case to check if the size is 0
        if(Heap.size()== 0){
            return null;
        }
        //this case returns the root if the size is one 
        else if(Heap.size()==1){
            return Heap.remove(0);
        }
        else{
            //return the max but inside a node
            flightNode max = Heap.get(0);
            flightNode lastElement = Heap.remove(Heap.size() - 1);
            Heap.set(0, lastElement);
            heapify(0);
            return max;
            
        }
    }   

    //This method gets the max child either from the left 
    //side or the right side
    public int maxChild(int num) {
        int left= 2*num+ 1;
        int right= 2*num + 2;  
        //checks if the left most side is the maxChild
        if (right > Heap.size() -1 || Heap.get(left).passengers > Heap.get(right).passengers){
            return left;
        }
        else{
            return right;
        }
    }

    /*
    Inserts a new element to the max heap. 
    The while loop  checks if the size is greater than 0
    */
    public void insert(flightNode number){
        Heap.add(number);

        int i = Heap.size() - 1;
        while(i > 0) {
            int parent = (i - 1) /2;
            //checks if passengers is less than the parent/root
            if (Heap.get(i).passengers <= Heap.get(parent).passengers){ 
                return; 
            }
            //swap
            flightNode temp = Heap.get(i);
            Heap.set(i, Heap.get(parent));
            Heap.set(parent, temp);
            i = parent;
        }
        
    }

    //This method heapify sorts it in order within the heap
    //checks the number inserted and the heap
    public void heapify(int num) {
        //This while loop basicly says the left child compares to the size
        while((2*num + 1) < Heap.size()) {

            int max = maxChild(num);
                //this states that the number is less than the max then trade the numbers
                if (Heap.get(num).passengers < Heap.get(max).passengers) {
                    //makes a temp to swap the heap between the num and temp
                    flightNode temp = Heap.get(max);
                    Heap.set(max, Heap.get(num));
                    Heap.set(num, temp);
                }
                num = max;
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

