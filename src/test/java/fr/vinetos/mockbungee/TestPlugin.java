package fr.vinetos.mockbungee;

import fr.vinetos.mockbungee.plugin.MockPlugin;
import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import net.md_5.bungee.api.plugin.Listener;

public class TestPlugin extends MockPlugin implements Listener {

    private boolean isLoaded = false;
    private boolean isEnabled = false;
    private boolean isDisabled = false;

    public TestPlugin(MockPluginDescription description) {
        super(description);
    }

    @Override
    public void onLoad() {
        isLoaded = true;
        isEnabled = false;
        isDisabled = false;
    }

    @Override
    public void onEnable() {
        isLoaded = true;
        isEnabled = true;
        isDisabled = false;
    }

    @Override
    public void onDisable() {
        isLoaded = false;
        isEnabled = false;
        isDisabled = true;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    @Override
    public MockPluginDescription getDescription() {
        return super.getDescription();
    }
}
