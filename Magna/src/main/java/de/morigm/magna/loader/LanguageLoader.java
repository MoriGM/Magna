package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.Magna;
import de.morigm.magna.api.loader.Loader;
import de.morigm.magna.api.utility.FileGenerator;
import de.morigm.magna.api.utility.LanguageFileManipulator;
import lombok.Getter;

import java.io.File;

public class LanguageLoader implements Loader {

    private final String[] languageFiles = {"de-de.yml", "en-en.yml"};
    @Getter
    private File language;

    public void check() {
        for (String languageFile : languageFiles) {
            File file = new File(Magna.INSTANCE.getFolders().getLanguageFolder(), languageFile);
            if (!file.exists())
                FileGenerator.copy(Main.Companion.getInstance().getResource(languageFile), file);

            if (file.lastModified() < Main.Companion.getInstance().getJar().lastModified())
                LanguageFileManipulator.addNewText(Main.Companion.getInstance().getResource(languageFile), file);
        }

        File language = Magna.INSTANCE.getFolders().getLanguageFile();
        if (language.exists())
            this.language = language;
        else
            this.language = new File(Magna.INSTANCE.getFolders().getLanguageFolder(), "en-en.yml");
    }

    @Override
    public void load() {
        if (!Magna.INSTANCE.getFolders().getLanguageFolder().exists())
            Magna.INSTANCE.getFolders().getLanguageFolder().mkdirs();
        check();
    }
}
