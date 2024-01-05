package de.morigm.magna.log;

import de.morigm.magna.Main;
import de.morigm.magna.api.log.Log;
import de.morigm.magna.api.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class CommandLogger implements Logger {

    private Log log;

    @Override
    public void load() {
        if (!Main.Companion.getInstance().getDefaultPluginConfig().commandlog)
            return;
        LocalDateTime local = LocalDateTime.now();
        File dir = new File("./server-log/command/");
        if (!dir.exists())
            dir.mkdirs();
        try {
            log = new Log(new File(dir, local.getDayOfMonth() + "-" + local.getMonthValue() + "-" + local.getYear()
                    + "-" + local.getHour() + "-" + local.getMinute() + ".log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        if (!Main.Companion.getInstance().getDefaultPluginConfig().commandlog)
            return;
        log.save();
    }

    @Override
    public void addLine(String text) {
        log.log(text);
    }

}
