package DevChatWatch.Events;

import org.bukkit.entity.Player;

import DevChatWatch.Helper;
import Mute.Mute;

public class MutePlayer implements MutePlayerInterface
{
	public Player player;
	public Helper helper;
	public Mute mute;

	public MutePlayer(Player player)
	{
		this.helper = new Helper();
		this.mute = new Mute();
		this.player = player;
		
		this.helper.setPlayer(player);
	}

	@Override
	public boolean mutePlayer(String username) 
	{
		if (this.player.hasPermission("DevChatWatch.mute")) {
			this.mute.mutePlayer(username);
			this.helper.sendMessage("Player Muted");
			return true;
		} else {
			this.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}

	@Override
	public boolean unmutePlayer(String username) 
	{
		if (this.player.hasPermission("DevChatWatch.unmute")) {
			this.mute.unMutePlayer(username);
			this.helper.sendMessage("Player Unmuted");
			return true;
		} else {
			this.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
}
