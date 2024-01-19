package sorting.merge;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {7, 6, 5, 4, 3, 2, 1, 0};
    int low = 0;
    int high = arr.length - 1;
    mergeSort(arr, low, high);
    System.out.println("merge sort: " + Arrays.toString(arr));
  }

  private static void mergeSort(int[] a, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(a, low, mid);
      mergeSort(a, mid + 1, high);
      merge(a, low, mid, high);
    }
  }

  private static void merge(int[] a, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int[] left = new int[n1];
    System.arraycopy(a, low + 0, left, 0, n1);
    int[] right = new int[n2];
    for (int j = 0; j < n2; j++) {
      right[j] = a[mid + 1 + j];
    }
    int i = 0, j = 0, k = low;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        a[k] = left[i];
        i++;
      } else {
        a[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      a[k] = left[i];
      i++;
      k++;
    }
    while (j < n2) {
      a[k] = right[j];
      j++;
      k++;
    }
  }
}
