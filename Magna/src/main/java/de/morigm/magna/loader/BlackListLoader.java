package de.morigm.magna.loader;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import de.morigm.magna.Main;
import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.censor.CensorType;
import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magna.api.helper.PermissionHelper;
import de.morigm.magna.api.helper.SaveHelper;
import de.morigm.magna.config.BlackListConfig;
import lombok.Getter;

public class BlackListLoader implements LoadHelper,SaveHelper,PermissionHelper
{

	@Getter private List<BlackWord> blackWords = new ArrayList<>();
	
	@Override
	public void load() 
	{
		for(String word : getBlackListConfig().getBlackwords())
		{
			String permission = getConfig().contains(word + ".permission") ? getConfig().getString(word + ".permission") : getPermission("blacklistword");
			CensorType type = getConfig().contains(word + ".type") ? CensorType.getType(getConfig().getString(word + ".type")) : CensorType.NORMAL;
			BlackWord bword = new BlackWord(word,permission,type);
			getBlackWords().add(bword);
		}
	}

	@Override
	public void save() 
	{
		delete();
		
		for(BlackWord word : getBlackWords())
		{
			getConfig().set(word.word + ".permission", word.permission);
			getConfig().set(word.word + ".type", word.type.name());
		}
	}
	
	private void delete() 
	{
		for(String key : getConfig().getKeys(true))
			getConfig().set(key, null);
	}
	
	private FileConfiguration getConfig()
	{
		return Main.getInstance().getBlackListConfig().getConfig();
	}
	
	private BlackListConfig getBlackListConfig()
	{
		return Main.getInstance().getBlackListConfig();
	}

}
