package DevChatWatch.Commands.Events;

import DevChatWatch.Commands.Commands;

public class MutePlayer implements MutePlayerInterface
{
	private Commands cmds;

	@Override
	public void setCommands(Commands cmds) 
	{
		this.cmds = cmds;
	}

	@Override
	public boolean mutePlayer(String username) 
	{
		if (cmds.player.hasPermission("DevChatWatch.mute")) {
			cmds.mute.mutePlayer(username);
			cmds.helper.sendMessage("Player Muted");
			return true;
		} else {
			cmds.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}

	@Override
	public boolean unmutePlayer(String username) 
	{
		if (cmds.player.hasPermission("DevChatWatch.unmute")) {
			cmds.mute.unMutePlayer(username);
			cmds.helper.sendMessage("Player Unmuted");
			return true;
		} else {
			cmds.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
}
