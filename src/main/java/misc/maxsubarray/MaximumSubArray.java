package misc.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray {
  public static void main(String[] args) {
    int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
    int low = 0;
    int high = a.length - 1;
    int[] max = maxSubArray(a, low, high);
    System.out.println(Arrays.toString(max));
    max = maxSubArrayBruteForce(a);
    System.out.println(Arrays.toString(max));
  }

  private static int[] maxSubArray(int[] a, int low, int high) {
    if (low == high) {
      return new int[]{low, high, a[low]};
    }
    int mid = (low + high) / 2;
    int[] left = maxSubArray(a, low, mid);
    int[] right = maxSubArray(a, mid + 1, high);
    int[] cross = inMid(a, low, mid, high);
    if (left[2] >= right[2] && left[2] >= cross[2]) {
      return left;
    } else if (right[2] > left[2] && right[2] >= cross[2]) {
      return right;
    } else {
      return cross;
    }
  }

  private static int[] inMid(int[] a, int low, int mid, int high) {
    int leftMax = Integer.MIN_VALUE;
    int leftSum = 0;
    int leftMaxIndex = -1;
    for (int i = mid; i >= low; i--) {
      leftSum += a[i];
      if (leftSum > leftMax) {
        leftMax = leftSum;
        leftMaxIndex = i;
      }
    }
    int rightMax = Integer.MIN_VALUE;
    int rightsum = 0;
    int rightMaxIndex = -1;
    for (int j = mid + 1; j <= high; j++) {
      rightsum += a[j];
      if (rightsum > rightMax) {
        rightMax = rightsum;
        rightMaxIndex = j;
      }
    }
    return new int[]{leftMaxIndex, rightMaxIndex, leftMax + rightMax};
  }

  private static int[] maxSubArrayBruteForce(int[] a) {
    int maxSum = Integer.MIN_VALUE;
    int leftIndex = -1;
    int rightIndex = -1;
    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum += a[j];
        if (sum > maxSum) {
          maxSum = sum;
          leftIndex = i;
          rightIndex = j;
        }
      }
    }
    return new int[]{leftIndex, rightIndex, maxSum};
  }
}
