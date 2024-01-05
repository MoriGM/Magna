package de.morigm.magna.gui;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.chat.ChatColor;
import de.morigm.magna.api.gui.Gui;
import de.morigm.magna.api.gui.GuiButton;
import de.morigm.magna.api.gui.GuiSwitchButton;
import de.morigm.magna.api.utility.ItemMetaManipulator;
import de.morigm.magna.chat.Chat;
import org.bukkit.Material;

import java.util.Arrays;

public class DebugGui extends Gui {

    @Override
    public void load() {
        setName(ChatColor.GREEN + "Debug");
        setSize(9);
        setPermission(getPermission("debug"));
        addButton(new GuiButton(ItemMetaManipulator.changeName(Material.WHITE_WOOL, "Version"), 1));
        addButton(new GuiSwitchButton(Material.WHITE_WOOL, "OwnCommandSpy", 2, Magna.INSTANCE.getSettings().getOwnCommandSpy()));
        addButton(new GuiButton(ItemMetaManipulator.changeName(Material.WHITE_WOOL, "AfkTimer"), 3));
        addButton(new GuiButton(ItemMetaManipulator.changeName(Material.WHITE_WOOL, "Language"), 4));
        addButton(new GuiSwitchButton(Material.WHITE_WOOL, "ShowChatClear", 5, Magna.INSTANCE.getSettings().getShowChatClear()));
    }

    @Override
    public void onClick(GuiButton button) {
        if (button.getId() == 1 && checkPermission(getPlayer(), "debug.version")) {
            getPlayer().sendMessage(Chat.prefix + "Version:" + Chat.version);
        }
        if (button.getId() == 2 && checkPermission(getPlayer(), "debug.owncommandspy")) {
            Magna.INSTANCE.getSettings().setOwnCommandSpy(!Magna.INSTANCE.getSettings().getOwnCommandSpy());
        }
        if (button.getId() == 3 && checkPermission(getPlayer(), "debug.afktimer")) {
            getPlayer().sendMessage(Chat.prefix + "AfkTimer:" + Magna.INSTANCE.getSettings().getAFKTimer());
        }
        if (button.getId() == 4 && checkPermission(getPlayer(), "debug.language")) {
            getPlayer().sendMessage(Chat.prefix + "Language:" + Magna.INSTANCE.getSettings().getLanguage());
        }
        if (button.getId() == 5 && checkPermission(getPlayer(), "debug.chatclear")) {
            Magna.INSTANCE.getSettings().setShowChatClear(!Magna.INSTANCE.getSettings().getShowChatClear());
        }
        if (Arrays.binarySearch(new int[]{2, 5}, button.getId()) >= 0) {
            Magna.getUser(getPlayer()).openGui(new DebugGui());
        }
    }

}
