package de.morigm.magna.loader;

import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.Main;
import de.morigm.magna.api.autoedit.CumstomPlayerAutoEditStruct;
import de.morigm.magna.api.autoedit.CustomAutoEditStruct;
import de.morigm.magna.config.AutoEditConfig;
import lombok.Getter;

public class AutoEditLoader
{

	@Getter private List<CustomAutoEditStruct> customAutoEditStructs = new ArrayList<>();
	@Getter private List<CumstomPlayerAutoEditStruct> customPlayerAutoEditStructs = new ArrayList<>();
	
	
	public void loadPlayerEdit()
	{
		for (String key : getAutoEditConfig().getConfigPlayer().getKeys(true))
		{
			String[] kys = key.replace(".","\",\"").split("\",\"");
			if(kys.length == 2)
			{
				String uuid = kys[0];
				String name = "[" + kys[1] + "]";
				String edit = getAutoEditConfig().getConfigPlayer().getString(key);
				CumstomPlayerAutoEditStruct struct = new CumstomPlayerAutoEditStruct(name, edit, uuid);
				getCustomPlayerAutoEditStructs().add(struct);
			}
		}
	}
	
	public void loadServerEdit()
	{
		for (String key : getAutoEditConfig().getConfig().getKeys(false))
		{
			String name = "[" + key + "]";
			String edit = getAutoEditConfig().getConfig().getString(key);
			CustomAutoEditStruct struct = new CustomAutoEditStruct(name, edit);
			getCustomAutoEditStructs().add(struct);
		}
	}
	
	private AutoEditConfig getAutoEditConfig()
	{
		return Main.getInstance().getAutoEditConfig();
	}

}
