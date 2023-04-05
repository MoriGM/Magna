package de.morigm.magna.api.language;

import de.morigm.magna.api.loader.Loader;
import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Language implements Loader {

    @Getter
    private final File languageFile;
    private Properties prop;

    public Language(File file) {
        this.languageFile = file;
    }

    public String translate(String text, TextStruct... structs) {
        if (prop.containsKey(text)) {
            String translate = prop.getProperty(text);
            if (structs.length >= 1)
                for (TextStruct struct : structs)
                    translate = translate.replace(struct.getOld(), struct.getNew());
            return translate;
        }
        return text;
    }

    @Override
    public void load() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(this.languageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
