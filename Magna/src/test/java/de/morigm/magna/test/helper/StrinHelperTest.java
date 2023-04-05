package de.morigm.magna.test.helper;

import de.morigm.magna.api.helper.StringHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrinHelperTest {

    @Test
    public void test() {
        String[] a = {"Hi", "Bye", "Toast"};
        String s = StringHelper.StringArrayToString(a, " ");
        assertEquals("Hi Bye Toast", s);
    }

}
