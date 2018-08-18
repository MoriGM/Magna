package de.morigm.magna.test.convert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.morigm.magna.api.convert.Convert;

public class ConvertTester 
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

}
