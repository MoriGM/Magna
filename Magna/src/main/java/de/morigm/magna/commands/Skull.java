package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;

public class Skull extends CommandHelper
{

	@Override
	public void registerUtils() 
	{
		util().registerCommandName(getCommand());
		util().registerPermission("skull");
		util().registerTranslation("cmd.skull");
	}
	
	@SuppressWarnings("deprecation")
	@SneakyThrows
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) 
	{
		if(com instanceof Player)
		{
			Player p = (Player) com;
			if(p.hasPermission(getPermission("skull")))
			{
				if(args.length >= 1)
				{
					String owner = args[0];
					ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					meta.setOwningPlayer(Bukkit.getOfflinePlayer(MojangApi.getNameFromUUID(owner)));
					item.setItemMeta(meta);
					p.getInventory().addItem(item);
					p.sendMessage(Chat.prefix + translate("cmd.skull"));
				}
				else
					p.sendMessage(Chat.prefix + getCommand() + " <SkullOwner>");
			}
			else
				p.sendMessage(Chat.prefix + Chat.no_permission);
		}
		else
			Chat.writeMessage(Chat.no_console);
		return false;
	}

	

}
