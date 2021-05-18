/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import fr.vinetos.mockbungee.plugin.MockPlugin;
import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.lang.reflect.Field;

public final class MockBungee {

    private static MockServer mock = null;

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
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Unmock and clean the server
     *
     * @return a mocked server ready to be used in tests.
     */
    public static MockServer unmock() {
        mock.stop();
        setServerInstanceToNull();
        return mock;
    }

    /**
     * Internal method to reset MockBungee
     */
    static void reset() {
        if (mock == null)
            throw new IllegalStateException("MockBungee is already reset");
        if (MockBungee.isMocked())
            unmock();
        mock = null;
    }

    public static MockPlugin load(MockPluginDescription description) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        return mock.getPluginManagerMock().create(description);
    }

    public static MockPlugin load(MockPlugin mockPlugin) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        return mock.getPluginManagerMock().load(mockPlugin);
    }

    public static void unload(MockPlugin mockPlugin) {
        if (mock == null)
            throw new IllegalStateException("Server isn't mocked");
        mock.getPluginManagerMock().unload(mockPlugin);
    }
}
