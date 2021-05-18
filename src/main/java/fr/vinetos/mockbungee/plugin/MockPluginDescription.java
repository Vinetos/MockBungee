/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee.plugin;

import net.md_5.bungee.api.plugin.PluginDescription;

import java.util.HashSet;


public class MockPluginDescription extends PluginDescription {

    public MockPluginDescription(String name, String main, String version, String author, String description) {
        super(name, main, version, author, new HashSet<>(), new HashSet<>(), null, description);
    }

    public static class Builder {

        private String name;
        private String main;
        private String version;
        private String author;
        private String description = null;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder main(String main) {
            this.main = main;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public MockPluginDescription build() {
            return new MockPluginDescription(name, main, version, author, description);
        }

    }

}
