package de.morigm.magna.test.api.mojang;

import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.api.mojang.MojangApi.ServerStatus;
import de.morigm.magna.api.mojang.MojangApi.ServerStatus.StatusColor;
import org.junit.Test;

import java.io.IOException;

public class MojangServerStatus {
	@Test
	public void test() throws IOException {
		ServerStatus status = MojangApi.getServerStatus();
		if (status.minecraft_net.equals(StatusColor.RED))
			System.out.println("Minecraft Website is Down");
	}
}
