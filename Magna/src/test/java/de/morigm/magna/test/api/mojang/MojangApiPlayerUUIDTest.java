package de.morigm.magna.test.api.mojang;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import de.morigm.magna.api.mojang.MojangApi;

public class MojangApiPlayerUUIDTest {

	@Test
	public void PlayerUUIDTest1() throws IOException {
		String name = "MoriGM";
		String suuid = "ab047d5a7a8740c4a86941f061a9b0cd";
		System.out.println("Test Player " + name + " and UUID " + suuid);

		UUID uuid = MojangApi.getPlayerUUID(name);
		assertEquals(uuid.toString(), MojangApi.MojangUUIDtoRealUUID(suuid).toString());
	}

	@Test
	public void PlayerUUIDTest2() throws IOException {
		String name = "jeb_";
		String suuid = "853c80ef3c3749fdaa49938b674adae6";
		System.out.println("Test Player " + name + " and UUID " + suuid);

		UUID uuid = MojangApi.getPlayerUUID(name);
		assertEquals(uuid.toString(), MojangApi.MojangUUIDtoRealUUID(suuid).toString());
	}

	@Test
	public void PlayerUUIDTest3() throws IOException {
		String name = "Notch";
		String suuid = "069a79f444e94726a5befca90e38aaf5";
		System.out.println("Test Player " + name + " and UUID " + suuid);

		UUID uuid = MojangApi.getPlayerUUID(name);
		assertEquals(uuid.toString(), MojangApi.MojangUUIDtoRealUUID(suuid).toString());
	}

	@Test
	public void PlayerUUIDTest4() throws IOException {
		String name = "LonzBonz";
		String suuid = "11ae64afa03a4a83a4f6782434221bc4";
		System.out.println("Test Player " + name + " and UUID " + suuid);

		UUID uuid = MojangApi.getPlayerUUID(name);
		assertEquals(uuid.toString(), MojangApi.MojangUUIDtoRealUUID(suuid).toString());
	}

	@Test
	public void PlayerUUIDTest5() throws IOException {
		String name = "GERVobis";
		String suuid = "454434209dd744fe8ed8e7e62b7bd88e";
		System.out.println("Test Player " + name + " and UUID " + suuid);

		UUID uuid = MojangApi.getPlayerUUID(name);
		assertEquals(uuid.toString(), MojangApi.MojangUUIDtoRealUUID(suuid).toString());
	}

}
