package de.morigm.magna.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.chat.Chat;

public class CMDTeamChat extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("teamchat");
		util().registerPermission("teamchat-see");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (testPermission(com, "teamchat")) {
			if (args.length >= 1) {
				String s = "";
				for (String arg : args)
					s += arg + " ";
				s = s.trim();
				for (Player t : Bukkit.getOnlinePlayers())
					if (testPermission(t, "teamchat-see"))
						t.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "TeamChat" + ChatColor.GRAY + "]"
								+ ChatColor.RESET + "<" + (com instanceof Player ? ((Player) com).getName() : "SERVER")
								+ ">" + s);
			} else
				com.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <Text>");
		} else
			Chat.noPermission(com);
		return false;
	}

}
