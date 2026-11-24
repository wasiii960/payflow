package com.practise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    // A key whose hashCode is always the same, to force every key into ONE bucket (collisions)
    private record SameHashKey(String name) {
        @Override
        public int hashCode() { return 42; }
    }

    @Test
    void putThenGet() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("ali", 500);
        assertEquals(500, map.get("ali"));
        assertEquals(1, map.size());
    }

    @Test
    void getMissingKeyReturnsNull() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertNull(map.get("nobody"));
    }

    @Test
    void putNewKeyReturnsNull() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertNull(map.put("ali", 500));
    }

    @Test
    void putExistingKeyReplacesAndReturnsOldValue() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("ali", 500);
        assertEquals(500, map.put("ali", 700));
        assertEquals(700, map.get("ali"));
        assertEquals(1, map.size());          // replacing does not add an entry
    }

    @Test
    void equalKeysThatAreDifferentObjectsAreTheSameKey() {
        // fails if keys are compared with == instead of equals
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("ali", 500);
        String sameText = new String("ali");
        assertEquals(500, map.get(sameText));
        map.put(sameText, 700);
        assertEquals(1, map.size());
    }

    @Test
    void nullKeyIsSupported() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put(null, 5);
        assertEquals(5, map.get(null));
        assertTrue(map.containsKey(null));
        assertEquals(5, map.remove(null));
        assertFalse(map.containsKey(null));
    }

    @Test
    void containsKeyIsTrueForNullValue() {
        // fails if containsKey is written as get(key) != null
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("ali", null);
        assertTrue(map.containsKey("ali"));
        assertNull(map.get("ali"));
    }

    @Test
    void collisionsAllStoredInOneBucket() {
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        map.put(new SameHashKey("b"), 2);
        map.put(new SameHashKey("c"), 3);
        assertEquals(1, map.get(new SameHashKey("a")));
        assertEquals(2, map.get(new SameHashKey("b")));
        assertEquals(3, map.get(new SameHashKey("c")));
        assertEquals(3, map.size());
    }

    @Test
    void collisionReplaceLastNodeInChain() {
        // fails if the loop never checks the last node in the chain
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        map.put(new SameHashKey("b"), 2);
        map.put(new SameHashKey("b"), 20);
        assertEquals(20, map.get(new SameHashKey("b")));
        assertEquals(2, map.size());
    }

    @Test
    void removeFirstNodeInChain() {
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        map.put(new SameHashKey("b"), 2);
        map.put(new SameHashKey("c"), 3);
        assertEquals(1, map.remove(new SameHashKey("a")));
        assertNull(map.get(new SameHashKey("a")));
        assertEquals(2, map.get(new SameHashKey("b")));
        assertEquals(3, map.get(new SameHashKey("c")));
        assertEquals(2, map.size());
    }

    @Test
    void removeMiddleNodeInChain() {
        // fails if prev is not moved along the chain
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        map.put(new SameHashKey("b"), 2);
        map.put(new SameHashKey("c"), 3);
        assertEquals(2, map.remove(new SameHashKey("b")));
        assertEquals(1, map.get(new SameHashKey("a")));
        assertNull(map.get(new SameHashKey("b")));
        assertEquals(3, map.get(new SameHashKey("c")));
        assertEquals(2, map.size());
    }

    @Test
    void removeLastNodeInChain() {
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        map.put(new SameHashKey("b"), 2);
        assertEquals(2, map.remove(new SameHashKey("b")));
        assertEquals(1, map.get(new SameHashKey("a")));
        assertEquals(1, map.size());
    }

    @Test
    void removeMissingKeyReturnsNullAndKeepsSize() {
        // fails if size-- runs when nothing was removed
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("ali", 1);
        assertNull(map.remove("sara"));
        assertEquals(1, map.size());
    }

    @Test
    void removeMissingKeyFromCollisionChain() {
        // fails with a NullPointerException if return p.value runs after the loop
        MyHashMap<SameHashKey, Integer> map = new MyHashMap<>();
        map.put(new SameHashKey("a"), 1);
        assertNull(map.remove(new SameHashKey("z")));
        assertEquals(1, map.size());
    }

    @Test
    void resizeKeepsEveryEntry() {
        // 1,000 entries forces several resizes: 16 -> 32 -> ... -> 2048
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, i * 10);
        }
        assertEquals(1000, map.size());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i * 10, map.get(i));
        }
    }

    @Test
    void negativeHashCodesWork() {
        // fails if indexFor uses % instead of & (a negative index)
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(-1, "minus one");
        map.put(-1000, "minus thousand");
        map.put(Integer.MIN_VALUE, "min");
        assertEquals("minus one", map.get(-1));
        assertEquals("minus thousand", map.get(-1000));
        assertEquals("min", map.get(Integer.MIN_VALUE));
    }
}