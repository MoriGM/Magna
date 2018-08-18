package de.morigm.magna.api.user;

import java.util.UUID;

import org.bukkit.entity.Player;

import de.morigm.magna.api.Magna;
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
			return Magna.getAFKManager().isAfk(player);
		}
		
		public boolean isMuted()
		{
			return Magna.getMutedPlayerManager().containsPlayer(player);
		}
		
		public boolean isCommandSpying()
		{
			return Magna.getCommandSpyManager().containsPlayer(player);
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
				Magna.getAFKManager().addPlayerToAFKMode(player);
			else
				Magna.getAFKManager().removePlayerFromAFKMode(player);
		}
		
		public void setMuted(boolean state)
		{
			if(state)
				Magna.getMutedPlayerManager().addPlayer(player);
			else
				Magna.getMutedPlayerManager().removePlayer(player);
		}
		
		public void setCMDSPY(boolean state)
		{
			if(state)
				Magna.getCommandSpyManager().addPlayer(player);
			else
				Magna.getCommandSpyManager().removePlayer(player);
		}
		
}
