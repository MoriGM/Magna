package de.morigm.magna.api.helper;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Properties;

public class LanguageFileHelper {
    @SneakyThrows
    public static void addNewText(InputStream in, File out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Properties outProp = new Properties();
        outProp.load(new FileReader(out));
        while (reader.ready()) {
            String[] sarr = reader.readLine().split("=");
            if (sarr.length >= 2) {
                if (!outProp.containsKey(sarr[0]))
                    outProp.setProperty(sarr[0], StringHelper.StringArrayToString(sarr, " ", 1).trim());
            }
        }
        FileOutputStream outs = new FileOutputStream(out);
        outProp.store(outs, null);
        outs.close();
    }

}
