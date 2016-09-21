package tests;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertArrayEquals;

import java.lang.System;
import sort.Sort;

public class SortTest {

  private final int[] arrayToSort = new int[]{49, 38, 65, 97, 76, 13, 27, 49};

  private final int[] arraySorted = new int[]{13, 27, 38, 49, 49, 65, 76, 97};

  private int[] createArray() {
    int[] result = new int[arrayToSort.length];
    System.arraycopy(arrayToSort, 0, result, 0, arrayToSort.length);
    return result;
  }

  @Test
  public void insertionTest() {
    int[] arrayToSort = createArray();
    Sort.insertion(arrayToSort);
    assertArrayEquals(arraySorted, arrayToSort);
  }

  @Test
  public void selectionTest() {
    int[] arrayToSort = createArray();
    Sort.selection(arrayToSort);
    assertArrayEquals(arraySorted, arrayToSort);
  }

  @Test
  public void bubbleTest() {
    int[] arrayToSort = createArray();
    Sort.bubble(arrayToSort);
    assertArrayEquals(arraySorted, arrayToSort);
  }

  @Test
  public void quickTest() {
    int[] arrayToSort = createArray();
    Sort.quick(arrayToSort);
    assertArrayEquals(arraySorted, arrayToSort);
  }
}
