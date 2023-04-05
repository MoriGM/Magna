package de.morigm.magna.test.api.mojang;

import de.morigm.magna.api.mojang.MojangApi;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MojangApiFromUUIDTest {

	@Test
	public void test1() throws IOException {
		String name = "MoriGM";
		String suuid = "ab047d5a7a8740c4a86941f061a9b0cd";
		System.out.println("Test UUID " + suuid + " with name " + name);

		assertEquals(MojangApi.getNameFromUUID(suuid), name);
	}

	@Test
	public void test2() throws IOException {
		String name = "jeb_";
		String suuid = "853c80ef3c3749fdaa49938b674adae6";
		System.out.println("Test UUID " + suuid + " with name " + name);

		assertEquals(MojangApi.getNameFromUUID(suuid), name);
	}

	@Test
	public void test3() throws IOException {
		String name = "Notch";
		String suuid = "069a79f444e94726a5befca90e38aaf5";
		System.out.println("Test UUID " + suuid + " with name " + name);

		assertEquals(MojangApi.getNameFromUUID(suuid), name);
	}

	@Test
	public void test4() throws IOException {
		String name = "lonzbonz";
		String suuid = "11ae64afa03a4a83a4f6782434221bc4";
		System.out.println("Test UUID " + suuid + " with name " + name);

		assertEquals(MojangApi.getNameFromUUID(suuid), name);
	}

	@Test
	public void test5() throws IOException {
		String name = "GERVobis";
		String suuid = "454434209dd744fe8ed8e7e62b7bd88e";
		System.out.println("Test UUID " + suuid + " with name " + name);

		assertEquals(MojangApi.getNameFromUUID(suuid), name);
	}

}
