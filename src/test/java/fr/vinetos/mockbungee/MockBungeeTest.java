/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import net.md_5.bungee.api.ProxyServer;
import org.junit.jupiter.api.*;

class MockBungeeTest {
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
        Assertions.assertNotNull(ProxyServer.getInstance());
        Assertions.assertEquals(mockServer, ProxyServer.getInstance());
        MockBungee.unmock();
        Assertions.assertNull(ProxyServer.getInstance());
    }

    @Test
    void loadPlugin() {
        MockBungee.load(new MockPluginDescription.Builder().build());
        Assertions.assertEquals(1, MockBungee.getMock().getPluginManagerMock().getPlugins().size());
    }

}
