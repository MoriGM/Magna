package de.morigm.magna.test.utility;

import de.morigm.magna.api.utility.ArrayManipulator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayManipulatorTest {

    @Test
    public void testSplit() {
        String[] arr = {"Hi", "Bye", "Toast", "Butter", "Tea"};
        List<String> list = ArrayManipulator.split(arr, 2);
        assertEquals(list.get(0), "Toast");
        assertEquals(list.get(1), "Butter");
        assertEquals(list.get(2), "Tea");
    }

    @Test
    public void testInArray() {
        String[] arr = {"Hi", "Bye", "Toast", "Butter", "Tea"};
        assertTrue(ArrayManipulator.isInArray("Hi", arr));
    }

}
