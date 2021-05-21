/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee.plugin;

import java.util.*;

public class PluginManagerMock {

    private final Map<String, MockPlugin> plugins = new LinkedHashMap<>();


    public MockPlugin create(MockPluginDescription plDesc) {
        if (plugins.containsKey(plDesc.getName()))
            throw new IllegalStateException("Plugin with that name already initialized");
        return load(new MockPlugin(plDesc));
    }

    public <E extends MockPlugin> E load(E plugin) {
        if (plugins.containsKey(plugin.getDescription().getName()))
            throw new IllegalStateException("Plugin with that name already initialized");
        plugins.put(plugin.getDescription().getName(), plugin);
        plugin.onLoad();
        plugin.onEnable();
        return plugin;
    }

    public void unload(MockPlugin mockPlugin) {
        if (!plugins.containsKey(mockPlugin.getDescription().getName()))
            throw new IllegalStateException("No Plugin with that name initialized");
        plugins.remove(mockPlugin.getDescription().getName());
        mockPlugin.onDisable();
    }

    /**
     * Returns the {@link MockPlugin} objects corresponding to all loaded plugins.
     *
     * @return the set of loaded plugins
     */
    public Collection<MockPlugin> getPlugins() {
        return plugins.values();
    }

    /**
     * Returns a loaded plugin identified by the specified name.
     *
     * @param name of the plugin to retrieve
     * @return the retrieved plugin or null if not loaded
     */
    public MockPlugin getPlugin(String name) {
        return plugins.get(name);
    }

}

