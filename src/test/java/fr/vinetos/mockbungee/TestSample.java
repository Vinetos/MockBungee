package fr.vinetos.mockbungee;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSample {

    private MockServer server;
    private TestPlugin plugin;

    @Test
    void setup() {
        server = MockBungee.mock();
        plugin = (TestPlugin) MockBungee.load(TestPlugin.class);
        Assertions.assertTrue(plugin.isLoaded());
        Assertions.assertTrue(plugin.isEnabled());
        Assertions.assertFalse(plugin.isDisabled());

        MockBungee.unload(TestPlugin.class);
        Assertions.assertFalse(plugin.isLoaded());
        Assertions.assertFalse(plugin.isEnabled());
        Assertions.assertTrue(plugin.isDisabled());
    }

    @AfterAll
    void tearDown() {
        if (MockBungee.isMocked())
            MockBungee.unmock();
    }

}
