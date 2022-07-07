//Dr. Shameem Ahmed slides from class (used pusdocode in methods sumDigs, reverse)
//05/2/2021
import java.util.ArrayList;

/** Lab 4, Part 1: Practice problems for developing recursive methods */
public class Recursion {
  /** Implicit precondition of all String parameters: they are not null. */

  /** = the length of s WITHOUT using function s.length.
   * hint: you can use the equals and substring methods
   * Recursive definition:
   *   len(s) = 0 if the string is empty
   *   len(s) = 1 + len (s[1..] otherwise) */
  public static int len(String s) {
    // TODO: replace true with the correct base case condition
    if (s.isEmpty()) {
      return 0;
    }
    else{
      return 1 + len(s.substring(1));
    }
  }

  /** = number of 'e's in s
   * recursive definition:
   *   countE("") = 0
   *   countE(s) =
   *        1 + countE(s[1:]) if s[0] is e
   *        countE(s[1:])     otherwise
   */
  public static int countE(String s)  {
    //checks if string is empty
    if(s.isEmpty()){
      return 0; 
    }
    //checks if the first char is e then
    //counts the rest of the e
    if(s.charAt(0) == 'e'){
      return 1 + countE(s.substring(1));
    }
    //counts the e
    else{
      return countE(s.substring(1));
    }
  }


  /** = sum of  digits in the decimal representation of n.
    e.g. sum(0) = 0, sum(3) = 3
    sum(34) = 7.
    sum(1356) = 15.     6  + sum of the digits in 135
    Precondition: n >= 0. */
  public static int sumDigs(int n) {
      //checks if n is 0
      if (n== 0) {
          return 0;
      }
        
      int i = n % 10;
      // TODO: replace 0 with the correct recursive call:
      return i + sumDigs(n / 10);
  }

  /** = the reverse of s
   * e.g. reverse("alp") => "pla"
   *      reverse("order") => "redro" */
  public static String reverse(String s) {
    //checks if string is empty
    if(s.isEmpty()){
      return "";
    }
    //if string length is 1 then
    //it will return s
    if(s.length() == 1){
      return s;
    }
    //returns string in reverse
    else{
      return reverse(s.substring(1)) + s.charAt(0);
    }

  }
  
  /* print result of a test case - overloaded for int methods */
  private static void testCase(String call, int was, int shouldBe) {
    System.out.println(call + " should be " + shouldBe + ", was " + was);
  }

  /* print result of a test case - overloaded for String methods */
  private static void testCase(String call, String was, String shouldBe) {
    System.out.println(call + " should be " + shouldBe + ", was " + was);
  }

  private static void testLen() {
    System.out.println("Test len");
    testCase("len(\"abc\")", len("abc"), 3);
    testCase("len(\"abcdefg\")", len("abcdefg"), 7);
    testCase("len(\"\")", len(""), 0);
    System.out.println();
  }

  private static void testCountE() {
    System.out.println("test countE");
    testCase("countE(\"\")", countE(""), 0);
    testCase("countE(\"abc\")", countE("abc"), 0);
    testCase("countE(\"abcde\")", countE("abcde"), 1);
    testCase("countE(\"eaebcde\")", countE("eaebcde"), 3);
    testCase("countE(\"eaebcdeeeee e\")", countE("eaebcdeeeee e"), 8);
    System.out.println();
  }
  //Test sumDigs(); by calling it and shows was n
  //and shows what n is puts out.
  private static void testSumDigs() {
    System.out.println("Test SumDigs");
    testCase("Test 1", sumDigs(0), 0);
    testCase("Test 2", sumDigs(3), 3);
    testCase("Test 3", sumDigs(34), 7);
    testCase("Test 4", sumDigs(1356), 15);
    testCase("Test 5", sumDigs(-5), -5);
    System.out.println();
  }
  //Tests reverse(); the string that is 
  //called orginaly and then tests it.  
  private static void testReverse() {
    System.out.println("Test Reverse");
    testCase("Test 1", reverse("\"\""), "\"\"");
    testCase("Test 2", reverse("love"), "evol");
    testCase("Test 3", reverse("tacocat"), "tacocat");
    testCase("Test 4", reverse("replace"), "ecalper");
    testCase("Test 5", reverse("xavier"), "reivax");
    System.out.println();
  }
  //main method that calls all the test cases
  public static void main(String[] args) {
      testLen();
      testCountE();
      testSumDigs();
      testReverse();
  }
}