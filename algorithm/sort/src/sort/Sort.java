package sort;

import java.lang.Integer;
import java.lang.System;
import static java.lang.System.arraycopy;

public class Sort {

  private Sort() {
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void insertion(int[] arr) {
    for (int currpos = 1; currpos < arr.length; currpos++) {
      int i = currpos;
      while (i > 0 && arr[i] < arr[i-1]) {
        swap(arr, i, i-1);
        i--;
      }
    }
  }

  public static void selection(int[] arr) {
    for (int currpos = 0; currpos < arr.length-1; currpos++) {
      int minpos = currpos+1;
      for (int i = minpos+1; i < arr.length; i++) {
        if (arr[i] < arr[minpos]) minpos = i;
      }
      swap(arr, currpos, minpos);
    }
  }

  public static void bubble(int[] arr) {
    for (int i = arr.length-1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j+1])  swap(arr, j, j+1);
      }
    }
  }

  private static void quickSub(int[] arr, int from, int to) {
    if (from >= to) return;
    int i = from, j = to;
    while (i < j) {

      while (i < j && arr[i] <= arr[j]) j--;
      swap(arr, i, j);
      while (i < j && arr[i] <= arr[j]) i++;
      swap(arr, i, j);
    }
    quickSub(arr, from, i-1);
    quickSub(arr, i+1, to);
  }

  public static void quick(int[] arr) {
    quickSub(arr, 0, arr.length-1);
  }
}
