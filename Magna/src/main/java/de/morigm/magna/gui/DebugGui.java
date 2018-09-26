package de.morigm.magna.gui;

import org.bukkit.Material;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.gui.GuiButton;
import de.morigm.magna.api.helper.ItemHelper;
import de.morigm.magna.chat.Chat;

public class DebugGui extends Gui 
{

	@Override
	public void load() 
	{
		setName(ChatColor.GREEN + "Debug");
		setSize(9);
		setPermission(getPermission("debug"));
		addButton(new GuiButton(ItemHelper.getItem(Material.WOOL, "Version"), 1));
		addButton(new GuiButton(ItemHelper.getItem(Material.WOOL,(Magna.getSettings().getOwnCommandSpy() ? ChatColor.GREEN : ChatColor.RED) + "OwnCommandSpy"), 2));
	}

	@Override
	public void onClick(GuiButton button) 
	{
		if(button.getId() == 1 && testPermission(getPlayer(), "debug.version"))
			getPlayer().sendMessage(Chat.prefix + "Version:" + Chat.version);
		if(button.getId() == 2 && testPermission(getPlayer(), "debug.owncommandspy"))
			Magna.getSettings().setOwnCommandSpy(!Magna.getSettings().getOwnCommandSpy());
		if(button.getId() >= 2)
			Magna.getUser(getPlayer()).openGui(new DebugGui());
	}

}
