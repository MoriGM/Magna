package de.morigm.magna.api.gui;

import org.bukkit.Material;

import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.helper.ItemHelper;

public class GuiSwitchButton extends GuiButton
{

	public GuiSwitchButton(Material m, String name, int id, boolean state) 
	{
		this(m, name, id, -1, state);
	}
	
	public GuiSwitchButton(Material m, String name, int id, int slot, boolean state) 
	{
		super(ItemHelper.getItem(m, (state ? ChatColor.DARK_GREEN : ChatColor.RED) + name), id, slot);
	}
	
}
