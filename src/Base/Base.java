package Base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import DevChatWatch.Config;

public class Base 
{
	public static void init()
	{
		tryToCreatePluginFolder();
		tryToCreateConfigFile();
	}
	
	private static void tryToCreatePluginFolder()
	{
		try {
			new File("plugins/" + Config.PLUGIN_NAME).mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void tryToCreateConfigFile()
	{
		JSONObject json = new JSONObject();
		
		String path = Config.PLUGIN_PATH + "/config.json";
		
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(path);
				fw.write(json.toJSONString());
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
