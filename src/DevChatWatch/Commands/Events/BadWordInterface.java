package DevChatWatch.Commands.Events;

import DevChatWatch.Commands.Commands;

public interface BadWordInterface
{
	public void setCommands(Commands cmds);
	
	public boolean addBadWord(String badWord);
	
	public boolean removeBadWord(String badWord);
}
