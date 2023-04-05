package de.morigm.magna.api.logger;

import de.morigm.magna.api.config.Config;

public interface Logger extends Config {

    void addLine(String text);

}
