public class MaxHeapTest {
    //what this file does is it inserts the desired number in 
    //the heap and prints it out acordingly this file also intializes 
    //the size of the heap
    public static void main(String[] args){
        HeapMax Heapmax = new HeapMax(10);

        System.out.println("Testing of HeapMax Starts.");

        System.out.println("Insert 5");
        Heapmax.insert(5);
        Heapmax.display();

        System.out.println("Insert 6");
        Heapmax.insert(6);
        Heapmax.display();

        System.out.println("Insert 3");
        Heapmax.insert(3);
        Heapmax.display();

        System.out.println("Insert 4");
        Heapmax.insert(4);
        Heapmax.display();

        System.out.println("Remove");
        Heapmax.removeMax();
        Heapmax.display();

        System.out.println("Testing of HeapMax ends." );
    }
    
}
