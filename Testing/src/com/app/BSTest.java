package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTest {

    @Test
    void testElementPresent() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, BinarySearch.search(arr, 5)); 
    }


    @Test
    void testElementNotFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, BinarySearch.search(arr, 6));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.search(arr, 3));
    }

    @Test
    void testSingleElementFound() {
        int[] arr = {10};
        assertEquals(0, BinarySearch.search(arr, 10));
    }

    @Test
    void testSingleElementNotFound() {
        int[] arr = {10};
        assertEquals(-1, BinarySearch.search(arr, 20));
    }

}
