package de.morigm.magna.test.utility;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import de.morigm.magna.api.utility.StringManipulator;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(DataProviderRunner.class)
public class StringManipulatorTest {

    @DataProvider
    public static Object[][] dataToArrayCorrect() {
        return new Object[][]{
                {"bye", "Bye"},
                {"hi", "Hi"},
                {"four", "Four"},
                {"water", "Water"}
        };
    }

    @DataProvider
    public static Object[][] dataToArrayIncorrect() {
        return new Object[][]{
                {"bye", "bye"},
                {"hi", "hi"},
                {"four", "four"},
                {"water", "water"},
                {"Test", "water"},
        };
    }

    @Test
    public void testStringArrayToString() {
        String[] a = {"Hi", "Bye", "Toast"};
        String s = StringManipulator.stringArrayToString(a, " ");
        assertEquals("Hi Bye Toast", s);
    }

    @Test
    public void testStringArrayToStringCount() {
        String[] a = {"Hi", "Bye", "Toast"};
        String s = StringManipulator.stringArrayToString(a, " ", 1);
        assertEquals("Bye Toast", s);
    }

    @Test
    @UseDataProvider("dataToArrayCorrect")
    public void testCapitalizeFirstCorrect(String org, String capitalized) {
        assertEquals(capitalized, StringManipulator.capitalizeFirst(org));
    }

    @Test
    @UseDataProvider("dataToArrayIncorrect")
    public void testCapitalizeFirstIncorrect(String org, String capitalized) {
        assertNotEquals(capitalized, StringManipulator.capitalizeFirst(org));
    }

}
