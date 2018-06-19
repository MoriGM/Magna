package de.morigm.magna.loader;

import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.Main;
import de.morigm.magna.api.group.Group;
import de.morigm.magna.api.helper.LoadHelper;

public class GroupLoader implements LoadHelper
{

	private Group[] groups;
	
	@Override
	public void load() 
	{
		List<Group> list = new ArrayList<>();
		Group[] groups = new Group[Main.getInstance().getDefaultPluginConfig().groups.size()];
		for(String group : Main.getInstance().getDefaultPluginConfig().groups)
		{
			String name = Main.getInstance().getGroupConfig().getConfig().getString(group + "." + "name");
			String permission = Main.getInstance().getGroupConfig().getConfig().getString(group + "." + "permission");
			int id = Main.getInstance().getGroupConfig().getConfig().getInt(group + "." + "id");
			list.add(new Group(name, permission, id));
		}
		if(list.size() >= 1)
		{
			List<Group> end = new ArrayList<>();
			for(int i = 0;i < list.size();i++)
			{
				Group g = new Group("Buddy", "Buddy", Integer.MAX_VALUE);
				for(Group group : list)
					if(g.id > group.id && !end.contains(group))
						g = group;
				end.add(g);
			}
			groups = end.toArray(new Group[end.size()]);
		}
		this.groups = groups;
	}
	
	public Group[] getGroups() 
	{
		return groups;
	}

}
