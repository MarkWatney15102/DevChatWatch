package DevChatWatch.Commands.Events;

import DevChatWatch.Commands.Commands;

public interface MutePlayerInterface 
{
	public void setCommands(Commands cmds);
	
	public boolean mutePlayer(String username);
	
	public boolean unmutePlayer(String username);
}
