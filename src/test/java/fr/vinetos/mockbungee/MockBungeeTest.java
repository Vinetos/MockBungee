/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import net.md_5.bungee.api.ProxyServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class MockBungeeTest {

    @After
    public void tearDown() {
        if (MockBungee.isMocked())
            MockBungee.unmock();
    }

    @Test
    public void testServerMock() {
        MockBungee.mock();
        Assert.assertNotNull(ProxyServer.getInstance());
        MockBungee.unmock();
        Assert.assertNull(ProxyServer.getInstance());
    }

}
