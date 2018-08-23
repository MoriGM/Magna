package de.morigm.magna.api.manager;

import org.bukkit.scheduler.BukkitRunnable;

import de.morigm.magna.Main;
import de.morigm.magna.api.runner.Runner;
import de.morigm.magna.api.runner.RunnerType;
import de.morigm.magna.stuff.RunnerStuff;

public class RunnerManager
{

	public void registerRunner(Runner runner)
	{
		if(!this.containsRunner(runner.getName()))
			RunnerStuff.runners.add(runner);
	}
	
	public void startRunner(String name)
	{
		final Runner r = getRunner(name);
		
		if(r != null)
		{
			new BukkitRunnable()
			{
				@Override
				public void run() 
				{
					r.load(RunnerType.NOW, this);
					r.run();
					r.close();
				}
			}.runTask(Main.getInstance());
		}
	}
	
	public void startRunnerLater(String name,Long ticklater)
	{
		final Runner r = getRunner(name);
		
		if(r != null)
		{
			new BukkitRunnable()
			{
				@Override
				public void run() 
				{
					r.load(RunnerType.LATER, this);
					r.run();
					r.close();
				}
			}.runTaskLater(Main.getInstance(), ticklater);
		}
	}
	
	public void startRunnerTimmer(String name,Long ticktimer)
	{
		final Runner r = getRunner(name);
		
		if(r != null)
		{
			new BukkitRunnable()
			{
				@Override
				public void run() 
				{
					r.load(RunnerType.TIMER, this);
					r.run();
				}
			}.runTaskTimer(Main.getInstance(), 0, ticktimer);
		}
	}
	
	
	public Runner getRunner(String runner)
	{
		for(Runner r : RunnerStuff.runners)
			if(r.getName().equals(runner))
				return r;
		return null;
	}
	
	public boolean containsRunner(String runner)
	{
		return getRunner(runner) != null;
	}
	
	public void deleteRunner(String name)
	{
		Runner r = getRunner(name);
		if(r != null)
			RunnerStuff.runners.remove(r);
	}
	
	public void stopRunner(String name)
	{
		if(containsRunner(name) && getRunner(name).isRunning())
			getRunner(name).cancel();
	}
	
}
