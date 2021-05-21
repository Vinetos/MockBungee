/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import net.md_5.bungee.api.ProxyServer;
import org.junit.jupiter.api.*;

class TestMockBungee {
    private MockServer mockServer;
    
    @BeforeEach
    void beforeEach() {
        mockServer = MockBungee.mock();
    }

    @AfterEach
    void tearDown() {
        MockBungee.unmock();
        mockServer = null;
    }

    @Test
    void testServerMock() {
        assertNotNull(ProxyServer.getInstance());
        Assertions.assertEquals(mockServer, ProxyServer.getInstance());
        MockBungee.unmock();
        Assertions.assertNull(ProxyServer.getInstance());
    }

    @Test
    void testLoadPlugin() {
        MockBungee.load(new MockPluginDescription.Builder().build());
        Assertions.assertEquals(1, MockBungee.getMock().getPluginManagerMock().getPlugins().size());
    }

    @Test
    void testGetVersion() {
        assertNotNull(MockBungee.getVersion());
    }
}
