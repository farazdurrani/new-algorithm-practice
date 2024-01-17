package sorting.insertion;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = {5, 4, 3, 2, 1};
    for (int j = 1; j < arr.length; j++) {
      int key = arr[j];
      int i = j - 1;
      while (i >= 0 && arr[i] > key) {
        arr[i + 1] = arr[i];
        i--;
      }
      arr[i + 1] = key;
    }
    System.out.println("sorted?");
    System.out.println(Arrays.toString(arr));
  }
}
