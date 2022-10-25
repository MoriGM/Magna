package de.morigm.magna.api.gui;

import org.bukkit.inventory.ItemStack;

import lombok.Getter;

public class GuiButton {

	@Getter
	private final ItemStack item;
	@Getter
	private final int id, slot;

	public GuiButton(ItemStack item, int id) {
		this(item, id, -1);
	}

	public GuiButton(ItemStack item, int id, int slot) {
		this.item = item;
		this.id = id;
		this.slot = slot;
	}

}
