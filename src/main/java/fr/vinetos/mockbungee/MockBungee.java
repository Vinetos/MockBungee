/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.lang.reflect.Field;

public final class MockBungee {

    private static ServerMock mock = null;

    /**
     * Prepare and mock a Bungeecord server
     *
     * @return the {@link ServerMock} ready to be used in tests.
     */
    public static ServerMock mock() {
        return mock(new ServerMock());
    }

    /**
     * Prepare and mock a custom Bungeecord mocked server implementation
     *
     * @param <T>        The mock implementation to use.
     * @param serverMock a custom {@link ServerMock} implementation.
     * @return The provided {@link ServerMock}.
     */
    public static <T extends ServerMock> T mock(T serverMock) {
        if (mock != null)
            throw new IllegalStateException("The server is already mocked");


        mock = serverMock;
        ProxyServer.setInstance(serverMock);
        return serverMock;
    }

    /**
     * Get the mock server instance.
     *
     * @return The {@link ServerMock} instance or <code>null</code> if none is set up yet.
     */
    public static ServerMock getMock() {
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
    public static ServerMock unmock() {
        mock.stop();
        setServerInstanceToNull();
        return null;
    }

    public static Plugin load(Class<? extends Plugin> testPluginClass) {
        // TODO: 07/05/2021 Load a class
        return null;
    }
}
