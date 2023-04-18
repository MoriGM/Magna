package de.morigm.magna.loader;

import de.morigm.magna.Main;
import de.morigm.magna.api.autoedit.CustomAutoEditStruct;
import de.morigm.magna.api.autoedit.CustomPlayerAutoEditStruct;
import de.morigm.magna.config.AutoEditConfig;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AutoEditLoader {

    @Getter
    private final List<CustomAutoEditStruct> customAutoEditStructs = new ArrayList<>();
    @Getter
    private final List<CustomPlayerAutoEditStruct> customPlayerAutoEditStructs = new ArrayList<>();

    public void loadPlayerEdit() {
        for (String key : getAutoEditConfig().getConfigPlayer().getKeys(true)) {
            String[] kys = key.replace(".", "\",\"").split("\",\"");
            if (kys.length == 2) {
                String uuid = kys[0];
                String name = "[" + kys[1] + "]";
                String edit = getAutoEditConfig().getConfigPlayer().getString(key);
                CustomPlayerAutoEditStruct struct = new CustomPlayerAutoEditStruct(name, edit, uuid);
                getCustomPlayerAutoEditStructs().add(struct);
            }
        }
    }

    public void loadServerEdit() {
        for (String key : getAutoEditConfig().getConfig().getKeys(false)) {
            String name = "[" + key + "]";
            String edit = getAutoEditConfig().getConfig().getString(key);
            CustomAutoEditStruct struct = new CustomAutoEditStruct(name, edit);
            getCustomAutoEditStructs().add(struct);
        }
    }

    private AutoEditConfig getAutoEditConfig() {
        return Main.getInstance().getAutoEditConfig();
    }

}
