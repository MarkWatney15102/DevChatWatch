package DevChatWatch.Events;

import DevChatWatch.Commands.Commands;

public class Help 
{
	private Commands cmds;
	
	public Help(Commands cmds) 
	{
		this.cmds = cmds;
	}
	
	public boolean printHelp()
	{
		if (this.cmds.player.hasPermission("DevChatWatch.information")) {
			this.cmds.helper.sendMessage("--- Command List ---");
			this.cmds.helper.sendMessage("Use '/chatwatch addbadword <Bad Word>' to add not allowed Words");
			this.cmds.helper.sendMessage("Use '/chatwatch removebadword <Bad Word>' to remove bad Word");
			this.cmds.helper.sendMessage("Use '/chatwatch mute <Player Name>' to mute Player");
			this.cmds.helper.sendMessage("Use '/chatwarch unmute <Player Name>' to unmute Player");
		}
		
		return true;
	}
}
