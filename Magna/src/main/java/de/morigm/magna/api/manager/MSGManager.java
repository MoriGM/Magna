package de.morigm.magna.api.manager;

import java.util.Map.Entry;

import org.bukkit.entity.Player;

import de.morigm.magna.stuff.MagnaStuff;

public class MSGManager {

	public void updateMSG(Player first, Player second) {
		Entry<String, String> en = null;
		for (Entry<String, String> e : MagnaStuff.getMsg().entrySet())
			if (e.getKey().equals(first.getName()) || e.getKey().equals(second.getName())
					|| e.getValue().equals(first.getName()) || e.getValue().equals(second.getName()))
				en = e;

		if (en != null)
			MagnaStuff.getMsg().remove(en.getKey());

		MagnaStuff.getMsg().put(first.getName(), second.getName());
	}

	public String getLastMessagedPlayer(Player p) {
		for (Entry<String, String> e : MagnaStuff.getMsg().entrySet()) {
			if (e.getValue().equals(p.getName()))
				return e.getKey();
			if (e.getKey().equals(p.getName()))
				return e.getValue();
		}
		return null;
	}

}
