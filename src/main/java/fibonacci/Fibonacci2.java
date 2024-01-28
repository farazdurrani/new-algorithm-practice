package fibonacci;

public class Fibonacci2 {
  public static void main(String[] args) {
    System.out.println("fibonacci " + fibiIterative(11));
    System.out.println("fibonacci " + fibiRecursive(11));
  }

  private static int fibiIterative(int n) {
    if(n <= 1) {
      return 1;
    }
    int n0 = 0;
    int n1 = 1;
    int temp;
    for(int i = 2; i <=n; i++){
      temp = n0 + n1;
      n0 = n1;
      n1 = temp;
    }
    return n1;
  }

  private static int fibiRecursive(int n) {
    if (n <= 2) {
      return 1;
    }
    return fibiRecursive(n - 1) + fibiRecursive(n - 2);
  }
}
