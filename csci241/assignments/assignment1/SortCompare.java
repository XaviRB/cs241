//Dr. Shameem Ahmed slides from class (used pusdocode)

//
//just could not finish because i got stuck 
//with arrays not working properly
//if i had one more day would have definitely 
//finished it.
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortCompare{
    private static int compareCounter = 0;
    //INSERTION SORT ALGORITHIM 
    public static int[] InsertionSort(int[] Array){
        int compareCounter = 0;
        int fullLength = Array.length;
		//my insertsort algorithm
		for (int i = 1; i < Array.length; i++) {
			int j = i - 1;
			int key = Array[i];
            compareCounter = 0;
			while (j >= 0 && Array[j] > key) {
				Array[j + 1] = Array[j];
				j--;
                compareCounter += 1;
			}
			Array[j + 1] = key;
		}
		//returns counter
		return Array;
    }

    //MERGE SORT ALGORITHIM
    public static int[] mergeSort(int[] Array){
        //finding the midpoint
        int midpoint = Array.length / 2;
        //left side is up to the midpoint
        int[] leftSide = new int[midpoint];
        int[] rightSide;
        int[] sorted = new int[Array.length];

        if (Array.length <= 1){
            return Array;
        }
        //Checks if the list will be even or odd and cuts the list appropriately 
        if (Array.length % 2 == 0){
            rightSide = new int[midpoint];
            
        }
        //if list is normal even size then rewrite rightside 1
        //more than the midpoint
        else{
            rightSide = new int[midpoint + 1];

        }
        //goes through the left side of the list
        for(int i = 0; i < leftSide.length; i++){
            leftSide[i] = Array[i];

        }
        //goes through the right side of the list
        for(int j = 0; j < rightSide.length; j++){
            rightSide[j] = Array[midpoint + j];

        }
        //Recursively calls the left and right side
        mergeSort(leftSide);
        mergeSort(rightSide);
        //combines the left and right side 
        sorted = combined(leftSide, rightSide);
        //return the sorted array 
        return sorted;

    }
    //helper function that takes the left sided and right side and 
    //actually merges the list in ascending order.
    public static int[] combined(int[] leftSide, int[] rightSide){
        int[] merged = new int[leftSide.length + rightSide.length];
        int sortedPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while(leftPointer < leftSide.length || rightPointer < rightSide.length){

            if(leftPointer < leftSide.length && rightPointer < rightSide.length){
                if(leftSide[leftPointer] < rightSide[rightPointer]){
                    merged[sortedPointer++] = leftSide[leftPointer++];
                }
                else{
                    merged[sortedPointer++] = rightSide[rightPointer++];
                }
            }
            else if(leftPointer < leftSide.length){
                merged[sortedPointer++] = leftSide[leftPointer++];

            }
            else if(rightPointer< rightSide.length){
                merged[sortedPointer++] = rightSide[rightPointer++];
            }
        }
        return merged;
    }
    

    //QUICK SO ALGORITHIM
    // 
    public static int[] quickSort(int[] Array){
        int comparisons = 0;
        int lengthArray = Array.length;
        //runs recursivequicksort
        recursiveQuicksort(Array, Array[0], lengthArray - 1);
        return Array;
    }
    //helper method that makes quicksort run recursivly
    private static int[] recursiveQuicksort(int[] array, int startIndex, int endIndex){
        int splitIndex = partition(array, startIndex, endIndex);
        //does the left side 
        if(startIndex < splitIndex - 1){
            recursiveQuicksort(array, startIndex, endIndex - 1);
        }
        //does the right side
        if(endIndex > splitIndex){
            recursiveQuicksort(array, startIndex, endIndex);
        }
        return array;
    }
    //partition helper method
    public static int partition(int[] array, int lowElement, int highElement){
        int midpoint = lowElement + (highElement - lowElement) /2;
        int pivot = array[midpoint];

        boolean complete = false;
        while(!complete){

            // Increment lowElement array[lowElement] < pivot
            while(array[lowElement] < pivot){
                lowElement +=1;
            }
            //Decrement highElementwhile pivot <numbers[highElement]
            while(pivot < array[highElement]){
                highElement -= 1;

            }
            // If zero or one elements remain, then all numbers 
            // are partitioned. Return highIndex.
            if(lowElement >= highElement){
                complete = true;
            }
            else{
                // Swap numbers[lowElement] and numbers[highElement]
                int temp = array[lowElement];
                array[lowElement] = array[highElement];
                array[highElement] = temp;

                lowElement += 1;
                highElement -=1;
            }
        }
        return highElement;
    }

    //RADIX SORT ALGORITHIM
    public static int[] radixSort(int[] array){
       /*
        int arraySize = array.length;
        int[] buckets = new ArrayList<>(10);
        //max length helper
        int maxDigits = maxLength(array, arraySize);

        int power10 = 1;
        for(int digitIndex = 0; digitIndex < maxDigits; digitIndex++){
            for(int i = 0 ; i < arraySize; i++){
                buckets[Arrays.get(i)/power10 % 10].add(Arrays.get(i));
            }
            int arrayIndex = 0;
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < buckets[k].length(); k++){
                    array[arrayIndex++] = buckets[j][k];
                }
            }
        
        }*/
        return array;
    }

    public static void main(String[] args){
        Scanner list = new Scanner(System.in);
        
        System.out.println("==============");
        System.out.println("Input params");
        System.out.println("==============");
        System.out.println("How many entries?");

        int listLength = list.nextInt();
        int[] saveInputs = new int[listLength];

        Random r = new Random();
        for(int i = 0; i < saveInputs.length; i++){
            saveInputs[i] = r.nextInt(listLength*2) - listLength;
        }

        Scanner userChoice = new Scanner(System.in);

        System.out.println("Which sort [m, i, q, r, all]?");

        String choice = userChoice.nextLine();
        //choice for merge sort
        if(choice.equalsIgnoreCase("m")){
            if(listLength < 20){
                int[] sort = mergeSort(saveInputs);
                System.out.println("Merge Sort");
                System.out.println("==============");
                System.out.println("unsorted array:" + Arrays.toString(saveInputs));
                System.out.println("Num comparisons:");
                System.out.println("sorted array:" + Arrays.toString(sort));
            }
            else{
                System.out.println("Merge Sort");
                System.out.println("==============");
                System.out.println("Num comparisons:");
            } 
        }
        //insertion sort
        else if(choice.equalsIgnoreCase("i")){
            if(listLength < 20){
                int[] sort = InsertionSort(saveInputs);
                System.out.println("Insertion Sort");
                System.out.println("==============");
                System.out.println("unsorted array:" + Arrays.toString(saveInputs));
                System.out.println("Num comparisons:" + compareCounter);
                System.out.println("sorted array:" + Arrays.toString(sort));
            }
            else{
                System.out.println("Insertion Sort");
                System.out.println("==============");
                System.out.println("Num comparisons:");
            } 
        }
        //Quick sort
        else if(choice.equalsIgnoreCase("q")){
            if(listLength < 20){
                int[] sort = quickSort(saveInputs);
                System.out.println("Quick Sort");
                System.out.println("==============");
                System.out.println("unsorted array:" + Arrays.toString(saveInputs));
                System.out.println("Num comparisons:");
                System.out.println("sorted array:" + Arrays.toString(sort));
            }
            else{
                System.out.println("Quick Sort");
                System.out.println("==============");
                System.out.println("Num comparisons:");
            }
        }
        //radix sort
        else if(choice.equalsIgnoreCase("r")){
            if(listLength < 20){
                int[] sort = radixSort(saveInputs);
                System.out.println("Radix Sort");
                System.out.println("==============");
                System.out.println("unsorted array:" + Arrays.toString(saveInputs));
                System.out.println("Num comparisons: 0");
                System.out.println("sorted array:" + Arrays.toString(sort));
            }
            else{
                System.out.println("Quick Sort");
                System.out.println("==============");
                System.out.println("Num comparisons:");
            }
        }
        //all case
        if(choice.equalsIgnoreCase("all")){
            int[] sort1 = radixSort(saveInputs);
            int[] sort2 = quickSort(saveInputs);
            int[] sort3 = mergeSort(saveInputs);
            int[] sort4 = InsertionSort(saveInputs);

            System.out.println("Merge Sort");
            System.out.println("==============");
            System.out.println("unsorted array:" + Arrays.toString(saveInputs));
            System.out.println("Num comparisons:");
            System.out.println("sorted array:" + Arrays.toString(sort3));
            
            System.out.println("Radix Sort");
            System.out.println("==============");
            System.out.println("unsorted array:" + Arrays.toString(saveInputs));
            System.out.println("Num comparisons: 0");
            System.out.println("sorted array:" + Arrays.toString(sort1));  
            
            System.out.println("Insertion Sort");
            System.out.println("==============");
            System.out.println("unsorted array:" + Arrays.toString(saveInputs));
            System.out.println("Num comparisons:" + compareCounter);
            System.out.println("sorted array:" + Arrays.toString(sort4));

            System.out.println("Quick Sort");
            System.out.println("==============");
            System.out.println("unsorted array:" + Arrays.toString(saveInputs));
            System.out.println("Num comparisons:");
            System.out.println("sorted array:" + Arrays.toString(sort2));
        }
    }

}
