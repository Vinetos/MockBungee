/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee.plugin;

public class MockPlugin {

    private final MockPluginDescription description;

    public MockPlugin(MockPluginDescription description) {
        this.description = description;
    }

    public void onLoad() {
    }

    public void onEnable() {
    }

    public void onDisable() {
    }


    public MockPluginDescription getDescription() {
        return description;
    }
}
