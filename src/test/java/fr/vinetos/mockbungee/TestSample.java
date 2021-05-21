package fr.vinetos.mockbungee;


import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSample {

    private TestPlugin plugin;

    @BeforeEach
    void beforeEach() {
        MockBungee.mock();
    }
    
    @AfterEach
    void afterEach() {
        MockBungee.unmock();
    }

    @Test
    void setup() {
        TestPlugin testPlugin = new TestPlugin(new MockPluginDescription.Builder().build());
        plugin = MockBungee.load(testPlugin);
        Assertions.assertTrue(plugin.isLoaded());
        Assertions.assertTrue(plugin.isEnabled());
        Assertions.assertFalse(plugin.isDisabled());

        MockBungee.unload(plugin);
        Assertions.assertFalse(plugin.isLoaded());
        Assertions.assertFalse(plugin.isEnabled());
        Assertions.assertTrue(plugin.isDisabled());
    }
}
