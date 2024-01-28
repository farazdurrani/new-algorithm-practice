package maxsubarray;

import java.util.Arrays;

public class MaximumSubArrayRename {
  public static void main(String[] args) {
    int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    int[] max = maxSubArray(); // divide and conquer
    System.out.println(Arrays.toString(max));
    max = maxSubArrayBruteForce(a);
    System.out.println(Arrays.toString(max));
  }

  private static int[] maxSubArrayBruteForce(int[] a) {
    return new int[0];
  }

  private static int[] maxSubArray() {
    return null;
  }
}
