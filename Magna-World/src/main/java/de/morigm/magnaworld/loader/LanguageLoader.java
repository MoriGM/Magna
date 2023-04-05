package de.morigm.magnaworld.loader;

import java.io.File;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.LanguageFileHelper;
import de.morigm.magna.api.helper.LoadHelper;
import de.morigm.magna.api.language.Language;
import de.morigm.magnaworld.Main;
import lombok.SneakyThrows;

public class LanguageLoader implements LoadHelper {

	private String[] languageFiles = { "de-de.yml", "en-en.yml" };

	@SneakyThrows
	@Override
	public void load() {
		for (String l : languageFiles) {
			File f = new File(Main.getInstance().getLanguageFolder(), l);
			if (!f.exists())
				f.createNewFile();
			LanguageFileHelper.addNewText(Main.getInstance().getResource(l), f);
		}

		Main.getInstance().setLanguage(
				new Language(new File(Main.getInstance().getLanguageFolder(), Magna.getSettings().getLanguage())));
		Main.getInstance().getLanguage().load();
	}

}
