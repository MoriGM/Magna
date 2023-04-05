package de.morigm.magna.test.convert;

import de.morigm.magna.api.convert.Convert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConvertTest {

    @Test
    public void testIntInt() {
        assertTrue(Convert.isInteger("01231231"));
        assertTrue(Convert.isInteger("6584651"));
        assertTrue(Convert.isInteger("654654"));
    }

    @Test
    public void testIntString() {
        assertFalse(Convert.isInteger("Test"));
        assertFalse(Convert.isInteger("123123.1231232"));
    }

    @Test
    public void testBooleanBoolean() {
        assertTrue(Convert.isBoolean("true"));
        assertTrue(Convert.isBoolean("false"));
    }

    @Test
    public void testBooleanString() {
        assertFalse(Convert.isBoolean("asdsadsa"));
        assertFalse(Convert.isBoolean("asdfasd"));
    }

    @Test
    public void testDoubleDouble() {
        assertTrue(Convert.isDouble("123456789"));
        assertTrue(Convert.isDouble("6519598198.98489189189189189"));
    }

    @Test
    public void testDoubleString() {
        assertFalse(Convert.isDouble("sdfsdafasdfsdafsdaf"));
        assertFalse(Convert.isDouble("5.5.5"));
    }

}
