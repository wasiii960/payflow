package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void newListIsEmpty() {
        MyArrayList list = new MyArrayList();
        assertEquals(0, list.size());
    }

    @Test
    void addIncreasesSize() {
        MyArrayList list = new MyArrayList();
        list.add(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    void addPastStartingCapacityKeepsAllElements() {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i * 10);
        }
        assertEquals(10, list.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i * 10, list.get(i));
        }
    }

    @Test
    void removeFromMiddleShiftsElements() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(2, list.remove(1));
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    void removeLastElement() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.remove(2));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void removeFirstElement() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.remove(0));
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void removeOnlyElementLeavesEmptyList() {
        MyArrayList list = new MyArrayList();
        list.add(7);
        assertEquals(7, list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    void addAfterRemoveUsesFreedSlot() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.add(4);
        assertEquals(3, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }

    @Test
    void removeAfterGrowKeepsOrder() {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(2, list.remove(2));
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    void getNegativeIndexThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void getIndexEqualToSizeThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void removeNegativeIndexThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void removeIndexEqualToSizeThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    void getOnEmptyListThrows() {
        MyArrayList list = new MyArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void removeOnEmptyListThrows() {
        MyArrayList list = new MyArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }
    @Test
    void getIndexEqualToSizeWithSpareCapacityThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void removeIndexEqualToSizeAfterGrowThrowsAndKeepsList() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void getAfterGrowAtSizeThrows() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void exceptionMessageIncludesIndexAndSize() {
        MyArrayList list = new MyArrayList();
        list.add(1);
        IndexOutOfBoundsException e =
                assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        assertTrue(e.getMessage().contains("5"));
        assertTrue(e.getMessage().contains("1"));
    }
}