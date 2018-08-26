package de.morigm.magna.test.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import de.morigm.magna.api.helper.ListHelper;

public class ListHelperTest 
{
	
	@Test
	public void testCreateVariable()
	{
		List<String> list = ListHelper.createList("Hi","Bye","Toast","Butter","Tea");
		assertEquals(list.get(0), "Hi");
		assertEquals(list.get(1), "Bye");
		assertEquals(list.get(2), "Toast");
		assertEquals(list.get(3), "Butter");
		assertEquals(list.get(4), "Tea");
	}
	
	@Test
	public void testSame()
	{
		List<String> list1 = ListHelper.createList("Hi","Bye","Toast","Butter","Tea");
		List<String> list2 = ListHelper.createList("Hi","Bye","Toast","Butter","Tea");
		assertTrue(ListHelper.isSame(list1, list2));
	}

}
