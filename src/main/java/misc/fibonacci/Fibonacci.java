package misc.fibonacci;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println("fibonacci " + fibiIterative(44));
    System.out.println("fibonacci " + fibiRecursive(44));
  }

  private static int fibiIterative(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    int n0 = 0;
    int n1 = 1;
    int temp = 0;
    for (int i = 2; i <= n; i++) {
      temp = n0 + n1;
      n0 = n1;
      n1 = temp;
    }
    return n1;
  }

  private static int fibiRecursive(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fibiRecursive(n - 1) + fibiRecursive(n - 2);
  }
}
