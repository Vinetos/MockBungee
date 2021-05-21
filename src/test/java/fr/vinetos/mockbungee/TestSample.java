package fr.vinetos.mockbungee;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.vinetos.mockbungee.plugin.MockPluginDescription;
import org.junit.jupiter.api.AfterEach;
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
        assertTrue(plugin.isLoaded());
        assertTrue(plugin.isEnabled());
        assertFalse(plugin.isDisabled());

        MockBungee.unload(plugin);
        assertFalse(plugin.isLoaded());
        assertFalse(plugin.isEnabled());
        assertTrue(plugin.isDisabled());
    }
}
