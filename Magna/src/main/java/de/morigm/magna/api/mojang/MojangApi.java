package de.morigm.magna.api.mojang;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class MojangApi 
{
	
	static
	{
		MojangApi.gson = new GsonBuilder().create();
	}
	
	protected static Gson gson;
	
	protected static class PlayerProfile
	{
		public String name,id;
	}
	
	public static class PlayerName
	{
		String name;
		long changedToAt;
	}
	
	public static class ServerStatus
	{
		public static enum StatusColor
		{
			GREEN,
			YELLOW,
			RED;
		}
		
		public StatusColor 	minecraft_net,
							session_minecraft_net,
							account_mojang_com,
							authserver_mojang_com,
							sessionserver_mojang_com,
							api_mojang_com,
							textures_minecraft_net,
							mojang_com;
	}
	
	public static UUID MojangUUIDtoRealUUID(String s)
	{
		String suuid = "";
		suuid = s.substring(0, 8) + "-" + s.substring(8, 12) + "-"  + s.substring(12, 16) + "-" + s.substring(16, 20) + "-" + s.substring(20, s.length());
		UUID uuid = UUID.fromString(suuid);
		return uuid;
	}
	

	public static UUID getPlayerUUID(String playername) throws IOException
	{
		URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + playername);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		PlayerProfile profile = gson.fromJson(new InputStreamReader(con.getInputStream()), PlayerProfile.class);
		UUID uuid = MojangUUIDtoRealUUID(profile.id);
		con.disconnect();
		return uuid;
	}
	
	
	public static String getNameFromUUID(String uuid) throws IOException
	{
		URL url = new URL("https://api.mojang.com/user/profiles/" + uuid + "/names");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		PlayerName[] arr = gson.fromJson(new InputStreamReader(con.getInputStream()), PlayerName[].class);
		con.disconnect();
		return arr[arr.length - 1].name;
	}
	
	public static ServerStatus getServerStatus() throws IOException
	{
		URL url = new URL("https://status.mojang.com/check");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		JsonArray arr = gson.fromJson(new InputStreamReader(con.getInputStream()), JsonArray.class);
		ServerStatus status = new ServerStatus();
		for (JsonElement en : arr)
		{
			String tmp = en.toString().substring(2);
			tmp = tmp.substring(0, tmp.length() - 2);
			String[] sarr = tmp.split("\":\"");
			if (sarr[0].equals("minecraft.net"))
				status.minecraft_net = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("session.minecraft.net"))
				status.session_minecraft_net = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("account.mojang.com"))
				status.account_mojang_com = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("authserver.mojang.com"))
				status.authserver_mojang_com = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("sessionserver.mojang.com"))
				status.sessionserver_mojang_com = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("api.mojang.com"))
				status.api_mojang_com = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("textures.minecraft.net"))
				status.textures_minecraft_net = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
			if (sarr[0].equals("mojang.com"))
				status.mojang_com = ServerStatus.StatusColor.valueOf(sarr[1].toUpperCase());
		}
		con.disconnect();
		return status;
	}
	
	
	
}
