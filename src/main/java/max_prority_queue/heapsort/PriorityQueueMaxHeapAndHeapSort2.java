package max_prority_queue.heapsort;

import java.util.stream.IntStream;
//Notes:
//maintainHeapProperty:
//	This function is called on an element at i that might be violating max-heap property.
//	Meaning, element at A[i] might be smaller than left or right child.

//buildMaxHeap:
//	Build max heap in a bottom up manner by calling maintainHeapProperty. But instead of starting from A.length - 1,
//	start from mid till the first element. Because children will be traversed by maintainHeapProperty.

//heapSort:
//	first, buildMaxHeap. Now, the largest value is sitting in the first position.
//	second, start the for loop from the bottom till the 2nd element in the array,
//		swap the first element with the heapSize,
//		shrink the heapSize,
//		call maintainHeapProperty on the first element (because first element might be breaching max-heap-property).

public class PriorityQueueMaxHeapAndHeapSort2 {
  static int heapSize;
  //  static int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
  static int[] a = {13, -3, -25, 20, 7, 99, 12};

  public static void main(String[] args) {

    print(a, "Before sort");
    heapSort();
    print(a, "After sort");
//LEFT SPACE ON PURPOSE
    System.out.println();

//LEFT SPACE ON PURPOSE


//LEFT SPACE ON PURPOSE


    heapSize = a.length;
    buildHeap();
    print(a, "After building max heapify");
    print(new int[]{max()}, "Max Value");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    extractMax();
    print(a, "After extracting max");
    insertKey(0);
    print(a, "After Inserting key");
    insertKey(1);
    print(a, "After Inserting key");
    insertKey(2);
    print(a, "After Inserting key");
    insertKey(3);
    print(a, "After Inserting key");
    insertKey(4);
    print(a, "After Inserting key");
    insertKey(5);
    print(a, "After Inserting key");
    insertKey(6);
    print(a, "After Inserting key");
    insertKey(7);
    increaseKey(222, 0);
    print(a, "After Increasing keys");
    increaseKey(99, 1);
    print(a, "After Increasing keys");
    increaseKey(45, 2);
    print(a, "After Increasing keys");
    increaseKey(888888, 6);
    print(a, "After Increasing keys");
    heapSort();
    print(a, "After Sort");
  }

  private static void print(int[] a, String msg) {
    System.out.println(msg);
    IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
    System.out.println();
  }

  private static void increaseKey(int key, int i) {
    if (a[i] > key) {
      System.out.println("the existing key is bigger than this new key");
      return;
    }
    a[i] = key;
    while (i >= 0 && a[parent(i)] < a[i]) {
      exchange(i, parent(i));
      i = parent(i);
    }
  }

  private static int parent(int i) {
    return i / 2;
  }

  private static void insertKey(int key) {
    if (heapSize >= a.length) {
      System.out.println("Heap overflow!");
      return;
    }
    heapSize++;
    a[heapSize - 1] = Integer.MIN_VALUE;
    increaseKey(heapSize - 1, key);
  }

  private static int max() {
    return a[0];
  }

  private static void extractMax() {
    if (heapSize < 1) {
      System.out.println("Heap underflow!");
      return;
    }
    exchange(0, heapSize - 1);
    heapSize--;
    maintainHeap(0);
  }

  private static void buildHeap() {
    heapSize = a.length;
    for (int i = a.length / 2; i >= 0; i--) {
      maintainHeap(i);
    }
  }

  private static void maintainHeap(int i) {
    int left = leftChild(i);
    int right = rightChild(i);
    int largest = i;
    if (left < heapSize && a[left] > a[largest]) {
      largest = left;
    }
    if (right < heapSize && a[right] > a[largest]) {
      largest = right;
    }
    if (largest != i) {
      exchange(i, largest);
      maintainHeap(largest);
    }
  }

  private static void exchange(int x, int y) {
    int temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }

  private static int rightChild(int i) {
    return (2 * i) + 1;
  }

  private static int leftChild(int i) {
    return 2 * i;
  }

  private static void heapSort() {
    buildHeap();
    for (int i = a.length - 1; i > 0; i--) {
      exchange(0, i);
      heapSize--;
      maintainHeap(0);
    }
  }
}
