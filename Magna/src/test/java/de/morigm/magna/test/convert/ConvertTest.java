package de.morigm.magna.test.convert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.morigm.magna.api.convert.Convert;

public class ConvertTest 
{
	
	@Test
	public void testIntInt()
	{
		assertTrue(Convert.isInteger("01231231"));
		assertTrue(Convert.isInteger("6584651"));
		assertTrue(Convert.isInteger("654654"));
	}
	
	@Test
	public void testIntString()
	{
		assertTrue(!Convert.isInteger("Test"));
		assertTrue(!Convert.isInteger("123123.1231232"));
	}
	
	@Test
	public void testBooleanBoolean()
	{
		assertTrue(Convert.isBoolean("true"));
		assertTrue(Convert.isBoolean("false"));
	}
	
	@Test
	public void testBooleanString()
	{
		assertTrue(!Convert.isBoolean("asdsadsa"));
		assertTrue(!Convert.isBoolean("asdfasd"));
	}
	
	@Test
	public void testDoubleDouble()
	{
		assertTrue(Convert.isDouble("123456789"));
		assertTrue(Convert.isDouble("6519598198.98489189189189189"));
	}
	
	@Test
	public void testDoubleString()
	{
		assertTrue(!Convert.isDouble("sdfsdafasdfsdafsdaf"));
		assertTrue(!Convert.isDouble("5.5.5"));
	}

}
