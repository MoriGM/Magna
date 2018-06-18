package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.LoadHelper;

public class GroupLoader implements LoadHelper
{

	private Group[] groups;
	
	@Override
	public void load() 
	{
		Group[] groups = new Group[Main.getInstance().getDefaultPluginConfig().groups.size()];
		int i = 0;
		for(String group : Main.getInstance().getDefaultPluginConfig().groups)
		{
			String name = Main.getInstance().getGroupConfig().getConfig().getString(group + "." + "name");
			String permission = Main.getInstance().getGroupConfig().getConfig().getString(group + "." + "permission");
			int id = Main.getInstance().getGroupConfig().getConfig().getInt(group + "." + "id");
			groups[i] = new Group(name, permission, id);
			i++;
		}
		this.groups = groups;
	}
	
	public Group[] getGroups() 
	{
		return groups;
	}

}
