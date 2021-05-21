/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import fr.vinetos.mockbungee.plugin.MockPlugin;
import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import java.io.IOException;
import java.util.Properties;
import net.md_5.bungee.api.ProxyServer;

import java.lang.reflect.Field;

public final class MockBungee {
    private static final Properties PROPERTIES;
    private static final String VERSION;
    private static MockServer mock = null;

    static {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(MockBungee.class.getClassLoader().getResourceAsStream("config.properties"));
            VERSION = (String) PROPERTIES.get("version");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Prepare and mock a Bungeecord server
     *
     * @return the {@link MockServer} ready to be used in tests.
     */
    public static MockServer mock() {
        return mock(new MockServer());
    }

    /**
     * Prepare and mock a custom Bungeecord mocked server implementation
     *
     * @param <T>        The mock implementation to use.
     * @param serverMock a custom {@link MockServer} implementation.
     * @return The provided {@link MockServer}.
     */
    public static <T extends MockServer> T mock(T serverMock) {
        if (mock != null)
            throw new IllegalStateException("The server is already mocked");


        mock = serverMock;
        ProxyServer.setInstance(serverMock);
        return serverMock;
    }

    /**
     * Get the mock server instance.
     *
     * @return The {@link MockServer} instance or <code>null</code> if none is set up yet.
     */
    public static MockServer getMock() {
        return mock;
    }


    /**
     * Checks if Bungeecord is being mocked.
     *
     * @return {@code true} if Bungeecord is being mocked, {@code false} if it is not.
     */
    public static boolean isMocked() {
        return mock != null;
    }

    /**
     * Set the server instance to null.
     * We can not use {@link ProxyServer#setInstance(ProxyServer)} to set the instance back to nul
     */
    protected static void setServerInstanceToNull() {
        try {
            Field server = ProxyServer.class.getDeclaredField("instance");
            server.setAccessible(true);
            server.set(null, null);
            mock = null;
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Unmock and clean the server if a mock exist
     */
    public static void unmock() {
        if (mock == null)
            return;
        mock.stop();
        setServerInstanceToNull();
    }

    /**
     * Load a {@link MockPluginDescription} in the mocked server
     *
     * @param description the description of a plugin
     * @return the loaded plugin
     */
    public static MockPlugin load(MockPluginDescription description) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        return mock.getPluginManagerMock().create(description);
    }

    /**
     * Load a {@link MockPlugin} in the mocked server
     *
     * @param mockPlugin the plugin to load
     * @return the loaded plugin
     */
    public static <E extends MockPlugin> E load(E mockPlugin) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        return mock.getPluginManagerMock().load(mockPlugin);
    }

    /**
     * Remove a plugin from the mocked server
     *
     * @param mockPlugin the plugin to unload
     */
    public static void unload(MockPlugin mockPlugin) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        mock.getPluginManagerMock().unload(mockPlugin);
    }

    public static String getVersion() {
        return VERSION;
    }
}
