package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.mojang.MojangApi;
import de.morigm.magna.chat.Chat;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class CMDSkull extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("skull");
		util().registerTranslation("cmd.skull");
	}

	@SneakyThrows
	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (com instanceof Player p) {
			if (p.hasPermission(getPermission("skull"))) {
				if (args.length >= 1) {
					String owner = args[0];
					ItemStack item = new ItemStack(Material.PLAYER_HEAD);
					SkullMeta meta = (SkullMeta) item.getItemMeta();
					meta.setOwningPlayer(Bukkit.getOfflinePlayer(MojangApi.getPlayerUUID(owner)));
					item.setItemMeta(meta);
					p.getInventory().addItem(item);
					p.sendMessage(Chat.prefix + translate("cmd.skull"));
				} else
					p.sendMessage(Chat.prefix + Slash(com) + getCommand() + " <SkullOwner>");
			} else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
