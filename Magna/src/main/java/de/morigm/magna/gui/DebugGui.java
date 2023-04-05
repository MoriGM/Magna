package de.morigm.magna.gui;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.gui.GuiButton;
import de.morigm.magna.api.gui.GuiSwitchButton;
import de.morigm.magna.api.helper.ItemHelper;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;

import java.util.Arrays;

public class DebugGui extends Gui {

    @Override
    public void load() {
        setName(ChatColor.GREEN + "Debug");
        setSize(9);
        setPermission(getPermission("debug"));
        addButton(new GuiButton(ItemHelper.getItem(Material.WHITE_WOOL, "Version"), 1));
        addButton(new GuiSwitchButton(Material.WHITE_WOOL, "OwnCommandSpy", 2, Magna.getSettings().getOwnCommandSpy()));
        addButton(new GuiButton(ItemHelper.getItem(Material.WHITE_WOOL, "AfkTimer"), 3));
        addButton(new GuiButton(ItemHelper.getItem(Material.WHITE_WOOL, "Language"), 4));
        addButton(new GuiSwitchButton(Material.WHITE_WOOL, "ShowChatClear", 5, Magna.getSettings().getShowChatClear()));
    }

    @Override
    public void onClick(GuiButton button) {
        if (button.getId() == 1 && testPermission(getPlayer(), "debug.version")) {
            getPlayer().sendMessage(Chat.prefix + "Version:" + Chat.version);
        }
        if (button.getId() == 2 && testPermission(getPlayer(), "debug.owncommandspy")) {
            Magna.getSettings().setOwnCommandSpy(!Magna.getSettings().getOwnCommandSpy());
        }
        if (button.getId() == 3 && testPermission(getPlayer(), "debug.afktimer")) {
            getPlayer().sendMessage(Chat.prefix + "AfkTimer:" + Magna.getSettings().getAFKTimer());
        }
        if (button.getId() == 4 && testPermission(getPlayer(), "debug.language")) {
            getPlayer().sendMessage(Chat.prefix + "Language:" + Magna.getSettings().getLanguage());
        }
        if (button.getId() == 5 && testPermission(getPlayer(), "debug.chatclear")) {
            Magna.getSettings().setShowChatClear(!Magna.getSettings().getShowChatClear());
        }
        if (Arrays.binarySearch(new int[]{2, 5}, button.getId()) >= 0) {
            Magna.getUser(getPlayer()).openGui(new DebugGui());
        }
    }

}
