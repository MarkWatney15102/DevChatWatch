package DevChatWatch.Events;

import org.bukkit.entity.Player;

import BadWord.BadWords;
import DevChatWatch.Helper;

public class BadWord implements BadWordInterface
{
	public Player player;
	public Helper helper;
	public BadWords badwords;

	public BadWord(Player player)
	{
		this.helper = new Helper();
		this.badwords = new BadWords();
		this.player = player;
		
		this.helper.setPlayer(player);
	}
	
	@Override
	public boolean addBadWord(String badWord)
	{
		if (this.player.hasPermission("DevChatWatch.addBadWord")) {
			this.badwords.addBadWord(badWord);
			this.helper.sendMessage("Word added to Bad words (" + badWord + ")");
			return true;
		} else {
			this.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
	
	@Override
	public boolean removeBadWord(String badWord)
	{
		if (this.player.hasPermission("DevChatWatch.removeBadWord")) {
			this.badwords.removeBadWord(badWord);
			this.helper.sendMessage("Word removed (" + badWord + ")");
			return true;
		} else {
			this.helper.sendMessage("No Permissions for the command");
			return false;
		}
	}
}
