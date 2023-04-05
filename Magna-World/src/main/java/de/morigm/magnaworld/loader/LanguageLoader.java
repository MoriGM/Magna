package de.morigm.magnaworld.loader;

import de.morigm.magna.api.Magna;
import de.morigm.magna.api.helper.LanguageFileHelper;
import de.morigm.magna.api.language.Language;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magnaworld.Main;
import lombok.SneakyThrows;

import java.io.File;

public class LanguageLoader implements Loader {

	private final String[] languageFiles = {"de-de.yml", "en-en.yml"};

	@SneakyThrows
	@Override
	public void load() {
		for (String l : languageFiles) {
			File f = new File(Main.getInstance().getLanguageFolder(), l);
			if (!f.exists()) {
				f.createNewFile();
			}
			LanguageFileHelper.addNewText(Main.getInstance().getResource(l), f);
		}

		Main.getInstance().setLanguage(
				new Language(new File(Main.getInstance().getLanguageFolder(), Magna.getSettings().getLanguage())));
		Main.getInstance().getLanguage().load();
	}

}
