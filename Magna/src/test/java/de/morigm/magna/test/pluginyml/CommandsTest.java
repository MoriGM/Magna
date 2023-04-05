package de.morigm.magna.test.pluginyml;

import de.morigm.magna.api.Magna;
import de.morigm.magna.loader.PluginLoader;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class CommandsTest {

    @Test
    public void isCommandInYML() throws InvalidDescriptionException {
        System.out.println("Test if Command is in YML");
        CommandLoader loader = new CommandLoader();
        loader.registerCommands();
        PluginDescriptionFile file = new PluginDescriptionFile(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("plugin.yml")));
        List<String> commands = Magna.getCommandUtil().getCommandsName();
        for (String c : commands) {
            System.out.println("Test Comamnd : " + c);
            assertTrue(file.getCommands().containsKey(c));
        }
    }

    @Test
    public void isYMLCommandInCommandUtil() throws InvalidDescriptionException {
        System.out.println("Test if YMLCommand is in CommandUtils");
        CommandLoader loader = new CommandLoader();
        loader.registerCommands();
        PluginDescriptionFile file = new PluginDescriptionFile(ClassLoader.getSystemResourceAsStream("plugin.yml"));
        List<String> commands = Magna.getCommandUtil().getCommandsName();
        for (String c : file.getCommands().keySet()) {
            System.out.println("Test Comamnd : " + c);
            assertTrue(commands.contains(c));
        }
    }

    public static class CommandLoader extends PluginLoader {
        private boolean isActive = false;

        @Override
        public void registerCommands() {
            if (!isActive)
                super.registerCommands();
            isActive = true;
        }
    }

}
