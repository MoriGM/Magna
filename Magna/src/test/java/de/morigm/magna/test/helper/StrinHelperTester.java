package de.morigm.magna.test.helper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.morigm.magna.api.helper.StringHelper;

public class StrinHelperTester
{
	
	@Test
	public void test()
	{
		String[] a = {"Hi","Bye","Toast"};
		String s = StringHelper.StringArrayToString(a, " ");
		assertTrue(s.equals("Hi Bye Toast"));
	}

}
