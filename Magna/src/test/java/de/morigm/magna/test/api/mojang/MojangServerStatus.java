package de.morigm.magna.test.api.mojang;

import java.io.IOException;

import org.junit.Test;

import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.api.mojang.MojangApi.ServerStatus;
import de.morigm.magna.api.mojang.MojangApi.ServerStatus.StatusColor;

public class MojangServerStatus 
{
	@Test
	public void test() throws IOException
	{
		ServerStatus status = MojangApi.getServerStatus();
		if(status.minecraft_net.equals(StatusColor.RED))
			System.out.println("Minecraft Website is Down");
	}
}
