package com.ironz.binaryprefs.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BitsTest {

    @Test
    public void emptyStringSet() {
        Set<String> strings = new HashSet<>();

        byte[] bytes = Bits.stringSetToBytes(strings);
        Set<String> restored = Bits.stringSetFromBytes(bytes);

        assertEquals(1, bytes.length);
        assertEquals(Bits.FLAG_STRING_SET, bytes[0]);
        assertEquals(strings, restored);
    }

    @Test
    public void stringSetConvert() {
        Set<String> strings = new HashSet<>();
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.add("");
        strings.add(null);

        byte[] bytes = Bits.stringSetToBytes(strings);
        Set<String> restored = Bits.stringSetFromBytes(bytes);

        assertEquals(37, bytes.length);
        assertEquals(Bits.FLAG_STRING_SET, bytes[0]);
        assertEquals(strings, restored);
    }

    @Test(expected = ClassCastException.class)
    public void stringSetIncorrectFlag() {
        Set<String> strings = new HashSet<>();
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.add("");
        strings.add(null);

        byte[] bytes = Bits.stringSetToBytes(strings);
        bytes[0] = 0;
        Bits.stringSetFromBytes(bytes);
    }

    @Test
    public void stringConvert() {
        String someString = "Some String";

        byte[] bytes = Bits.stringToBytes(someString);
        String restored = Bits.stringFromBytes(bytes);

        assertEquals(12, bytes.length);
        assertEquals(Bits.FLAG_STRING, bytes[0]);
        assertEquals(someString, restored);
    }

    @Test(expected = ClassCastException.class)
    public void stringIncorrectFlag() {
        byte[] bytes = Bits.intToBytes(Integer.MAX_VALUE);

        bytes[0] = 0;

        Bits.intFromBytes(bytes);
    }

    @Test
    public void integerConvert() {
        byte[] bytes = Bits.intToBytes(Integer.MAX_VALUE);

        int restored = Bits.intFromBytes(bytes);

        assertEquals(5, bytes.length);
        assertEquals(Bits.FLAG_INT, bytes[0]);
        assertEquals(Integer.MAX_VALUE, restored);
    }

    @Test(expected = ClassCastException.class)
    public void integerIncorrectFlag() {
        byte[] bytes = Bits.intToBytes(Integer.MAX_VALUE);

        bytes[0] = 0;

        Bits.intFromBytes(bytes);
    }

    @Test
    public void floatConvert() {
        byte[] bytes = Bits.floatToBytes(Float.MAX_VALUE);

        float restored = Bits.floatFromBytes(bytes);

        assertEquals(5, bytes.length);
        assertEquals(Bits.FLAG_FLOAT, bytes[0]);
        assertEquals(Float.MAX_VALUE, restored, .0);
    }

    @Test(expected = ClassCastException.class)
    public void floatIncorrectFlag() {
        byte[] bytes = Bits.floatToBytes(Float.MAX_VALUE);

        bytes[0] = 0;

        Bits.floatFromBytes(bytes);
    }

    @Test
    public void longConvert() {
        byte[] bytes = Bits.longToBytes(Long.MAX_VALUE);

        long restored = Bits.longFromBytes(bytes);

        assertEquals(9, bytes.length);
        assertEquals(Bits.FLAG_LONG, bytes[0]);
        assertEquals(Long.MAX_VALUE, restored);
    }

    @Test(expected = ClassCastException.class)
    public void longIncorrectFlag() {
        byte[] bytes = Bits.longToBytes(Long.MAX_VALUE);

        bytes[0] = 0;

        Bits.longFromBytes(bytes);
    }

    @Test
    public void booleanConvert() {
        byte[] bytes = Bits.booleanToBytes(true);

        boolean restored = Bits.booleanFromBytes(bytes);

        assertEquals(2, bytes.length);
        assertEquals(Bits.FLAG_BOOLEAN, bytes[0]);
        assertEquals(true, restored);
    }

    @Test(expected = ClassCastException.class)
    public void booleanIncorrectFlag() {
        byte[] bytes = Bits.booleanToBytes(true);

        bytes[0] = 0;

        Bits.booleanFromBytes(bytes);
    }
}