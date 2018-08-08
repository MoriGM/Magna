package de.morigm.magna.listener;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import de.morigm.magna.Main;
import de.morigm.magna.api.censor.BlackWord;
import de.morigm.magna.api.helper.ListenerHelper;
import de.morigm.magna.chat.Chat;

public class Listener_BlackList implements ListenerHelper 
{
	
	@EventHandler
	public void on(AsyncPlayerChatEvent e)
	{
		if(Main.getInstance().getBlackListManager().hasBlackWord(e.getMessage()))
		{
			BlackWord bword = Main.getInstance().getBlackListManager().getBlackWordFromText(e.getMessage());
			if(!e.getPlayer().hasPermission(bword.permission) || !Main.getInstance().getDefaultPluginConfig().blacklistperm)
			{
				switch(bword.type)
				{
					case NORMAL:
						normal(e);
						break;
					case KICK:
						kick(e);
						break;
					case WARN:
						warn(e);
						break;
					case MUTE:
						mute(e);
						break;
					case BAN:
						ban(e);
						break;
					case DEOP:
						deop(e);
						break;
					case SPAWN:
						spawn(e);
						break;
					case GROUPKICK:
						groupkick(e);
						break;
					case GROUPBAN:
						groupban(e);
						break;
					case KILL:
						kill(e);
						break;
					case CLEAR:
						clear(e);
						break;
					case BLIND:
						blind(e);
						break;
					default:
						break;
						
				}
			}
		}
	}
	
	private void blind(AsyncPlayerChatEvent e)
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void clear(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				e.getPlayer().getInventory().clear();
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void kill(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				e.getPlayer().setHealth(0);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void groupban(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			
			@Override
			public void run() 
			{
				if(Main.getInstance().getGroupManager().isPlayerInGroup(e.getPlayer()))
					for(Player t : Main.getInstance().getGroupManager().getPlayersByGroup(Main.getInstance().getGroupManager().getGroupFromPlayer(e.getPlayer())))
						t.getPlayer().kickPlayer("Banned Word");
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void groupkick(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			
			@Override
			public void run() 
			{
				if(Main.getInstance().getGroupManager().isPlayerInGroup(e.getPlayer()))
					for(Player t : Main.getInstance().getGroupManager().getPlayersByGroup(Main.getInstance().getGroupManager().getGroupFromPlayer(e.getPlayer())))
						{
							Bukkit.getBanList(Type.NAME).addBan(t.getName(), "You are not allowed to write this text", null, "Magna");
							t.getPlayer().kickPlayer("Banned Word");
						}
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void spawn(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				if(Main.getInstance().getDefaultPluginConfig().spawn != null)
					e.getPlayer().teleport(Main.getInstance().getDefaultPluginConfig().spawn);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void deop(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				e.getPlayer().setOp(false);
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void ban(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{
				Bukkit.getBanList(Type.NAME).addBan(e.getPlayer().getName(), "You are not allowed to write this text", null, "Magna");
				e.getPlayer().kickPlayer("Banned Word");
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void mute(AsyncPlayerChatEvent e) 
	{
		Main.getInstance().getMutedPlayerManager().addPlayer(e.getPlayer());
		e.setCancelled(true);
	}

	private void warn(AsyncPlayerChatEvent e) 
	{
		e.getPlayer().sendMessage(Chat.prefix + translate("listener.censor.warn"));
	}

	private void kick(AsyncPlayerChatEvent e) 
	{
		new BukkitRunnable() 
		{
			
			@Override
			public void run() 
			{
				e.getPlayer().kickPlayer("Banned Word");
			}
		}.runTaskLater(Main.getInstance(), 1);
		e.setCancelled(true);
	}

	private void normal(AsyncPlayerChatEvent e) 
	{
		e.setCancelled(true);
	}

}
