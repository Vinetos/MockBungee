/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import net.md_5.bungee.api.ProxyServer;
import org.junit.jupiter.api.*;

class MockBungeeTest {

    @AfterEach
    public void tearDown() {
        MockBungee.reset();
    }

    @Test
    void testServerMock() {
        MockBungee.mock();
        Assertions.assertNotNull(ProxyServer.getInstance());
        MockBungee.unmock();
        Assertions.assertNull(ProxyServer.getInstance());
    }

    @Test
    void loadPlugin() {
        MockBungee.mock();
        MockBungee.load(TestPlugin.class);
    }

}
