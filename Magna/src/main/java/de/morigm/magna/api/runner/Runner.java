package de.morigm.magna.api.runner;

import org.bukkit.scheduler.BukkitRunnable;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.TranslationHelper;
import lombok.Getter;

public abstract class Runner implements TranslationHelper
{
	
	@Getter private String name;
	private BukkitRunnable bukkitRunnable;
	
	public abstract void run();
	
	
	public void register(String name)
	{
		this.name = name;
		Magna.getRunnerManager().registerRunner(this);
	}

	public void cancel()
	{
		this.bukkitRunnable.cancel();
		this.removeBukkitRunnable();
	}

	public void setBukkitRunnable(BukkitRunnable bukkitRunnable) 
	{
		this.bukkitRunnable = bukkitRunnable;
	}
	
	public void removeBukkitRunnable()
	{
		this.bukkitRunnable = null;
	}

}
