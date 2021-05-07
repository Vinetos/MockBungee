package fr.vinetos.mockbungee;

import org.junit.After;
import org.junit.Before;

public class TestSample {

    private ServerMock server;
    private TestPlugin plugin;

    @Before
    public void setup() {
        server = MockBungee.mock();
        plugin = (TestPlugin) MockBungee.load(TestPlugin.class);
    }

    @After
    public void tearDown() {
        MockBungee.unmock();
    }

}
