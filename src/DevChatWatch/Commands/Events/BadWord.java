package DevChatWatch.Commands.Events;

import DevChatWatch.Commands.Commands;

public class BadWord implements BadWordInterface
{
	private Commands cmds;
	
	@Override
	public void setCommands(Commands cmds) 
	{
		this.cmds = cmds;
	}
	
	@Override
	public boolean addBadWord(String badWord)
	{
		if (cmds.player.hasPermission("DevChatWatch.addBadWord")) {
			cmds.badwords.addBadWord(badWord);
			cmds.helper.sendMessage("Word added to Bad words");
			return true;
		} else {
			cmds.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
	
	@Override
	public boolean removeBadWord(String badWord)
	{
		if (cmds.player.hasPermission("DevChatWatch.removeBadWord")) {
			cmds.badwords.removeBadWord(badWord);
			cmds.helper.sendMessage("Word removed");
			return true;
		} else {
			cmds.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
}
