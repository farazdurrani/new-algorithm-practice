package factorial;

public class Factorial {
  public static void main(String[] args) {
    int n = 6;
    System.out.println("Factorial of " + n + " is " + factorialRecursive(n));
    System.out.println("Factorial of " + n + " is " + factorialIterative(n));
  }

  private static int factorialIterative(int n) {
    if (n <= 2) {
      return n;
    }
    int fact = 2;
    for (int i = 3; i <= n; i++) {
      fact *= i;
    }
    return fact;
  }

  private static int factorialRecursive(int n) {
    if (n <= 2) {
      return n;
    }
    return n * factorialRecursive(n - 1);
  }
}
