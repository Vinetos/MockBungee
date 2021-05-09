package fr.vinetos.mockbungee;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class TestPlugin extends Plugin implements Listener {

    private boolean isLoaded = false;
    private boolean isEnabled = false;
    private boolean isDisabled = false;

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
}
