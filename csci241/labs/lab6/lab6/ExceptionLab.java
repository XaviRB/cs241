//for this lab i really belived that it was due at midnight and not 10pm only making this note because after i submitted it i noticed because i checked canvas and saw that it was due at 10. Sorry about that didnt mean to turn it in late.

/* ExceptionLab.java
 * 
 * A simple class that triggers various exceptions.
 *
 * In the CSCI 241 Exception Handling Lab, you will modify this code to
 * catch these exceptions.
 *
 * Usage:
 *
 * java ExceptionLab x1 x2 .. xN
 *
 * where each xi are integers
 *
 */

import java.util.Arrays;
import java.io.FileNotFoundException;

class ExceptionLab {
    // define constants to avoid "magic numbers" later in the code
    private static final int sliceLower = 3; // lower bound on array slice
    private static final int sliceUpper = 8; // upper bound on array slice
    private static final String out_fn = ".tmp.lab5.txt"; // output filename

    // Perform a series of (contrived) operations on the args array 
    public static void main(String[] args) {
        // convert string array to int array
        int[] x = null;
        try{
            // convert string array to int array
            x = makeArray(args);
            System.out.println(Arrays.toString(x));

            // convert int array to itself in an artificial/strange way
            x = identity(x);
            System.out.println(Arrays.toString(x));
        }
         catch(NumberFormatException error){
            System.out.print("makeArray threw exception ");
            error.printStackTrace();
            System.exit(1);
        }
        catch(ArithmeticException error){
            System.out.print("identity threw exception ");
            error.printStackTrace();
            System.exit(1);

        }

        // Assigned the int array(the varible s) as null before the try statement.
        int[] s = null;
        // Try Block Created for slice call in main method.
        try{
             
            s = slice(x,sliceLower,sliceUpper);
            System.out.println(Arrays.toString(s));
        }
        
        catch(ArrayIndexOutOfBoundsException  error){
            System.out.print("slice threw exception ");
            error.printStackTrace();
        }

        // Assigned the int array(the varible s2) as null before the try statement.
        int[] s2 = null;
        // Try Block Created for buggierSlice call in main method.
        try{
            // like slice but flat out broken
            s2 = buggierSlice(x,sliceLower,sliceUpper);
            System.out.println(Arrays.toString(s2));
        }
        catch(NullPointerException error){
            System.out.print("buggierSlice threw exception ");
            error.printStackTrace();
        }

        // Try Block Created for writeArraytoFile Call in main method.
        try{
            // write array x to out_fn
             writeArrayToFile(x,out_fn);
         }
         catch(NumberFormatException error){
             System.out.print("writeArrayToFile threw exception ");
             error.printStackTrace();
         }
         
        return;
    }

    private static int[] makeArray(String[] args) {
        int[] result = new int[args.length];
        for( int i=0; i<args.length; i++ ) {
            result[i] = Integer.parseInt(args[i]);
        }
        return result;
    }

    private static int[] identity(int[] x) {
        int[] result = new int[x.length];
        for( int i=0; i<x.length; i++ ) {
            result[i] = (x[i]*x[i])/x[i];
        }
        return result;
    }

    private static int[] slice(int[] x, int startIdx, int endIdx ) {
        int[] result = new int[endIdx-startIdx];

        for( int i=startIdx; i<endIdx; i++ ) {
            result[i-startIdx] = x[i];
        }

        return result;
    }

    private static int[] buggierSlice(int[] x, int startIdx, int endIdx ) {
        int[] result = null;

        for( int i=startIdx; i<endIdx; i++ ) {
            result[i-startIdx] = x[i];
        }

        return result;
    }

    private static void writeArrayToFile(int[] x, String fn) {
        try{
            java.io.File        outFile = new java.io.File(fn);
            java.io.PrintStream out     = new java.io.PrintStream(outFile);
            for( int i=0; i<x.length; i++ ) {
                out.println(Arrays.toString(x));
            }
        out.close();
        }
        catch(FileNotFoundException error){
            System.out.print("writeArrayToFile threw exception ");
            error.printStackTrace();
        }
    }
    

}
