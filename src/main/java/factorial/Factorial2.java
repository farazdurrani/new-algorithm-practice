package factorial;

public class Factorial2 {
  public static void main(String[] args) {
    int n = 6;
    System.out.println("Factorial of " + n + " is " + factorialRecursive(n));
    System.out.println("Factorial of " + n + " is " + factorialIterative(n));
  }

  private static long factorialIterative(long n) {
    if(n <= 1) {
      return 1;
    }
    long fact = 1;
    for(long i = n; i >= 2l; i--){
      fact *= i;
    }
    return fact;
  }

  private static int factorialRecursive(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * factorialRecursive(n - 1);
  }
}
