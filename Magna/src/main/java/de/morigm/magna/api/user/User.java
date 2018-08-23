package de.morigm.magna.api.user;

import static de.morigm.magna.api.Magna.getAFKManager;
import static de.morigm.magna.api.Magna.getCommandSpyManager;
import static de.morigm.magna.api.Magna.getGodModeManager;
import static de.morigm.magna.api.Magna.getMutedPlayerManager;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import de.morigm.magna.api.manager.PermissionManager;
import lombok.Getter;

public class User 
{
		@Getter private Player player;
		private PermissionManager permission;

		public User(Player p,PermissionManager permission) 
		{
			this.player = p;
			this.permission = permission;
		}
		
		public boolean samePlayer(Player t)
		{
			return player.equals(t);
		}
		
		public boolean isAfk()
		{
			return getAFKManager().isAfk(this.player);
		}
		
		public boolean isMuted()
		{
			return getMutedPlayerManager().containsPlayer(this.player);
		}
		
		public boolean isCommandSpying()
		{
			return getCommandSpyManager().containsPlayer(this.player);
		}
		
		public boolean isGodMode()
		{
			return getGodModeManager().containsPlayer(this.player);
		}
		
		public boolean hasPermission(String Permission)
		{
			return player.hasPermission(permission.getPermission(Permission));
		}
		
		public UUID getUUID()
		{
			return player.getUniqueId();
		}
		
		public String getName()
		{
			return player.getName();
		}
		
		public void setAfk(boolean state)
		{
			if(state)
				getAFKManager().addPlayerToAFKMode(player);
			else
				getAFKManager().removePlayerFromAFKMode(player);
		}
		
		public void setMuted(boolean state)
		{
			if(state)
				getMutedPlayerManager().addPlayer(player);
			else
				getMutedPlayerManager().removePlayer(player);
		}
		
		public void setCMDSPY(boolean state)
		{
			if(state)
				getCommandSpyManager().addPlayer(player);
			else
				getCommandSpyManager().removePlayer(player);
		}
		
		public void setGodMode(boolean state)
		{
			if(state)
				getGodModeManager().addPlayer(player);
			else
				getGodModeManager().removePlayer(player);
		}
		
		public void tp(Entity e)
		{
			this.tp(e.getLocation());
		}
		
		public void tp(Location loc)
		{
			this.player.teleport(loc);
		}
		
}
