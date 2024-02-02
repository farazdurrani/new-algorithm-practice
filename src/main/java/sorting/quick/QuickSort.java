package sorting.quick;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {4, -2, 5, 10, 22, 11, -11};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = randomPartition(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  private static int randomPartition(int[] arr, int low, int high) {
    int randomIndex = random(low, high);
    swap(arr, randomIndex, high);
    return partition(arr, low, high);
  }

  private static int random(int low, int high) {
    return new RandomDataGenerator().nextInt(low, high);
  }

  private static int partition(int[] arr, int low, int high) {
    int x = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] <= x) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
