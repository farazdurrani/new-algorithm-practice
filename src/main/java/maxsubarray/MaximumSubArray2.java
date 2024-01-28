package maxsubarray;

import java.util.Arrays;

public class MaximumSubArray2 {
  public static void main(String[] args) {
//    [7, 10, 43]
    int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    int low = 0;
    int high = a.length - 1;
    int[] max = maxSubArray(a, low, high); // divide and conquer
    System.out.println(Arrays.toString(max));
    max = maxSubArrayBruteForce(a);
    System.out.println(Arrays.toString(max));
    visualize();
  }

  private static void visualize() {
    int[] a = {13, -3, -25, 20};
    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        System.out.printf("i->j=[%10s] == [%d]%n", all(i, j), sum);
      }
    }
    System.out.println(Arrays.toString(maxSubArrayBruteForce(a)));
  }

  private static String all(int i, int j) {
    String s = "";
    for (int a = i; a <= j; a++) {
      s = s + a + ",";
    }
    return s.substring(0, s.length() - 1);
  }

  private static int[] maxSubArray(int[] a, int low, int high) {
    if (low == high) {
      return new int[]{low, high, a[low]};
    }
    int mid = (low + high) / 2;
    int[] left = maxSubArray(a, low, mid);
    int[] right = maxSubArray(a, mid + 1, high);
    int[] center = maxSubArrayCrossingMid(a, low, mid, high);
    if (left[2] >= right[2] && left[2] >= center[2]) {
      return left;
    } else if (right[2] >= left[2] && right[2] >= center[2]) {
      return right;
    } else {
      return center;
    }
  }

  private static int[] maxSubArrayCrossingMid(int[] a, int low, int mid, int high) {
    int leftSum = Integer.MIN_VALUE;
    int leftIndex = -1;
    int sum = 0;
    for (int i = mid; i >= low; i--) {
      sum += a[i];
      if (sum > leftSum) {
        leftSum = sum;
        leftIndex = i;
      }
    }
    int rightSum = Integer.MIN_VALUE;
    int rightIndex = -1;
    sum = 0;
    for (int j = mid + 1; j <= high; j++) {
      sum += a[j];
      if (sum > rightSum) {
        rightSum = sum;
        rightIndex = j;
      }
    }
    return new int[]{leftIndex, rightIndex, leftSum + rightSum};
  }

  private static int[] maxSubArrayBruteForce(int[] a) {
    int maxSum = Integer.MIN_VALUE;
    int li = -1;
    int ri = -1;
    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        if (sum > maxSum) {
          maxSum = sum;
          li = i;
          ri = j;
        }
      }
    }
    return new int[]{li, ri, maxSum};
  }
}
