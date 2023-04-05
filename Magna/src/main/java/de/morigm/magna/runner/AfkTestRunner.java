package de.morigm.magna.runner;

import static de.morigm.magna.api.Magna.getAFKManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.runner.Runner;

public class AfkTestRunner extends Runner {

	@Override
	public void run() {
		for (Player t : Bukkit.getOnlinePlayers()) {
			if (!getAFKManager().containsLocation(t))
				getAFKManager().setLocation(t, t.getLocation());
			if (!getAFKManager().containsTime(t))
				getAFKManager().setTime(t, System.currentTimeMillis());
			if (getAFKManager().containsTime(t)) {
				if ((System.currentTimeMillis() - getAFKManager().getTime(t)) >= (Magna.getSettings().getAFKTimer() * 60
						* 1000))
					getAFKManager().addPlayer(t);
			}
		}
	}

}
