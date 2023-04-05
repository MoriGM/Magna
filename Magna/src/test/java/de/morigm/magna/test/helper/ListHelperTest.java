package de.morigm.magna.test.helper;

import de.morigm.magna.api.helper.ListHelper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListHelperTest {

    @Test
    public void testSplit() {
        String[] arr1 = {"Hi", "Bye", "Toast", "Butter", "Tea"};
        List<String> list = ListHelper.split(arr1, 2);
        assertEquals(list.get(0), "Toast");
        assertEquals(list.get(1), "Butter");
        assertEquals(list.get(2), "Tea");
    }

}
