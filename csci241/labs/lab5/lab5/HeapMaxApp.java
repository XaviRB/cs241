public class HeapMaxApp {
    //this file is suposed to take in the problem but was not sure how to get it working
    HeapMax Heapmax = new HeapMax(10);

    public static int kthBiggest(int[ ][ ] matr, int k){
         matr =  1 5 9 10 11 13 12 15; 
        return k;
    }

    public void main(){
        System.out.println("Testing of kthBiggest starts.");

        System.out.println("the given matrix is.");
        HeapMax.insert(kthBiggest(5, 5));

        System.out.println("The 2nd biggest element is" );
        HeapMax.display();
        System.out.println("Testing of kthBiggest ends.");

    }
}
