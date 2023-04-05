package de.morigm.magna.commands;

import de.morigm.magna.api.helper.CommandHelper;
import de.morigm.magna.api.helper.ItemHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class CMDRepair extends CommandHelper {

	@Override
	public void registerUtils() {
		util().registerCommandName(getCommand());
		util().registerPermission("repair");
		util().registerTranslation("cmd.repair");
		util().registerTranslation("cmd.repair.error");
	}

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String label, String[] args) {
		if (isPlayer(com)) {
			Player p = (Player) com;
			if (testPermission(p, "repair")) {
				if (p.getInventory().getItemInMainHand() != null
						&& !p.getInventory().getItemInMainHand().getType().equals(Material.AIR)
						&& ItemHelper.isRepairable(p.getInventory().getItemInMainHand())) {
					ItemStack item = p.getInventory().getItemInMainHand();
					ItemMeta meta = item.getItemMeta();
					if (meta instanceof Damageable)
						((Damageable) meta).setDamage(0);
					item.setItemMeta(meta);
					p.sendMessage(Chat.prefix + translate("cmd.repair"));
				} else
					p.sendMessage(Chat.prefix + translate("cmd.repair.error"));
			} else
				Chat.noPermission(p);
		} else
			Chat.noConsole(com);
		return false;
	}

}
