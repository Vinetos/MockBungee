/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ConfigurationAdapter;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.api.scheduler.TaskScheduler;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class ServerMock extends ProxyServer {

    @Override
    public String getName() {
        throw new UnimplementedOperationException();
    }

    @Override
    public String getVersion() {
        throw new UnimplementedOperationException();
    }

    @Override
    public String getTranslation(String name, Object... args) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Logger getLogger() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<ProxiedPlayer> getPlayers() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ProxiedPlayer getPlayer(String name) {
        throw new UnimplementedOperationException();
    }

    @Override
    public ProxiedPlayer getPlayer(UUID uuid) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Map<String, ServerInfo> getServers() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ServerInfo getServerInfo(String name) {
        throw new UnimplementedOperationException();
    }

    @Override
    public PluginManager getPluginManager() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ConfigurationAdapter getConfigurationAdapter() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setConfigurationAdapter(ConfigurationAdapter adapter) {
        throw new UnimplementedOperationException();
    }

    @Override
    public ReconnectHandler getReconnectHandler() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setReconnectHandler(ReconnectHandler handler) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void stop() {
        stop("Stopping the server");
    }

    @Override
    public void stop(String reason) {
    }

    @Override
    public void registerChannel(String channel) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void unregisterChannel(String channel) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<String> getChannels() {
        throw new UnimplementedOperationException();
    }

    @Override
    public String getGameVersion() {
        throw new UnimplementedOperationException();
    }

    @Override
    public int getProtocolVersion() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ServerInfo constructServerInfo(String name, InetSocketAddress address, String motd, boolean restricted) {
        throw new UnimplementedOperationException();
    }

    @Override
    public ServerInfo constructServerInfo(String name, SocketAddress address, String motd, boolean restricted) {
        throw new UnimplementedOperationException();
    }

    @Override
    public CommandSender getConsole() {
        throw new UnimplementedOperationException();
    }

    @Override
    public File getPluginsFolder() {
        throw new UnimplementedOperationException();
    }

    @Override
    public TaskScheduler getScheduler() {
        throw new UnimplementedOperationException();
    }

    @Override
    public int getOnlineCount() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void broadcast(String message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void broadcast(BaseComponent... message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void broadcast(BaseComponent message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<String> getDisabledCommands() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ProxyConfig getConfig() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<ProxiedPlayer> matchPlayer(String match) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Title createTitle() {
        throw new UnimplementedOperationException();
    }
}
