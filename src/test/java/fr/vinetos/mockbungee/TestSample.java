package fr.vinetos.mockbungee;


import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSample {

    private TestPlugin plugin;

    @Test
    void setup() {
        MockBungee.mock();
        var pl = new TestPlugin(new MockPluginDescription.Builder().build());
        plugin = (TestPlugin) MockBungee.load(pl);
        Assertions.assertTrue(plugin.isLoaded());
        Assertions.assertTrue(plugin.isEnabled());
        Assertions.assertFalse(plugin.isDisabled());

        MockBungee.unload(plugin);
        Assertions.assertFalse(plugin.isLoaded());
        Assertions.assertFalse(plugin.isEnabled());
        Assertions.assertTrue(plugin.isDisabled());
        MockBungee.reset();
    }

    @AfterAll
    static void tearDown() {
        if (MockBungee.isMocked())
            MockBungee.unmock();
    }
}
