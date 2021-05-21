/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import net.md_5.bungee.api.ProxyServer;
import org.junit.jupiter.api.*;

class MockBungeeTest {

    @AfterEach
    void tearDown() {
        MockBungee.reset();
    }

    @Test
    void testServerMock() {
        var mocked = MockBungee.mock();
        Assertions.assertNotNull(ProxyServer.getInstance());
        Assertions.assertEquals(mocked, ProxyServer.getInstance());
        MockBungee.unmock();
        Assertions.assertNull(ProxyServer.getInstance());
        MockBungee.reset();
    }

    @Test
    void loadPlugin() {
        MockBungee.mock();
        MockBungee.load(new MockPluginDescription.Builder().build());
        Assertions.assertEquals(1, MockBungee.getMock().getPluginManagerMock().getPlugins().size());
        MockBungee.reset();
    }

}
