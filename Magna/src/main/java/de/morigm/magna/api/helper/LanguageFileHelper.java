package de.morigm.magna.api.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import lombok.SneakyThrows;

public class LanguageFileHelper 
{
	@SneakyThrows
	public static void addNewText(InputStream in, File out)
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Properties outProp = new Properties();
		outProp.load(new FileReader(out));
		while (reader.ready())
		{
			String[] sarr = reader.readLine().split("=");
			if (sarr.length >= 2)
			{
				if (!outProp.containsKey(sarr[0]))
					outProp.setProperty(sarr[0], StringHelper.StringArrayToString(sarr, " ", 1).trim());
			}
		}
		FileOutputStream outs = new FileOutputStream(out);
		outProp.store(outs, null);
		outs.close();
	}

}
