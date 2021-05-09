/*
 * Copyright 2021 Vinetos
 */
package fr.vinetos.mockbungee;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.score.Scoreboard;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class MockPlayer implements ProxiedPlayer {

    private final MockServer server;
    private final UUID uuid;
    private String displayName;

    public MockPlayer(MockServer server, String name) {
        this(server, name, UUID.randomUUID());
    }

    public MockPlayer(MockServer server, String name, UUID uuid) {
        this.uuid = uuid;
        this.server = server;
        setDisplayName(name);
    }


    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public void setDisplayName(String name) {
        this.displayName = name;
    }

    @Override
    public void sendMessage(ChatMessageType position, BaseComponent... message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendMessage(ChatMessageType position, BaseComponent message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void connect(ServerInfo target) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void connect(ServerInfo target, ServerConnectEvent.Reason reason) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void connect(ServerInfo target, Callback<Boolean> callback) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void connect(ServerInfo target, Callback<Boolean> callback, ServerConnectEvent.Reason reason) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void connect(ServerConnectRequest request) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Server getServer() {
        throw new UnimplementedOperationException();
    }

    @Override
    public int getPing() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendData(String channel, byte[] data) {
        throw new UnimplementedOperationException();
    }

    @Override
    public PendingConnection getPendingConnection() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void chat(String message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public ServerInfo getReconnectServer() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setReconnectServer(ServerInfo server) {
        throw new UnimplementedOperationException();
    }

    @Override
    public String getUUID() {
        throw new UnimplementedOperationException();
    }

    @Override
    public UUID getUniqueId() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Locale getLocale() {
        throw new UnimplementedOperationException();
    }

    @Override
    public byte getViewDistance() {
        throw new UnimplementedOperationException();
    }

    @Override
    public ChatMode getChatMode() {
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasChatColors() {
        throw new UnimplementedOperationException();
    }

    @Override
    public SkinConfiguration getSkinParts() {
        throw new UnimplementedOperationException();
    }

    @Override
    public MainHand getMainHand() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setTabHeader(BaseComponent header, BaseComponent footer) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setTabHeader(BaseComponent[] header, BaseComponent[] footer) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void resetTabHeader() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendTitle(Title title) {
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean isForgeUser() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Map<String, String> getModList() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new UnimplementedOperationException();
    }

    @Override
    public String getName() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendMessage(String message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendMessages(String... messages) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendMessage(BaseComponent... message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void sendMessage(BaseComponent message) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<String> getGroups() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void addGroups(String... groups) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void removeGroups(String... groups) {
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean hasPermission(String permission) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void setPermission(String permission, boolean value) {
        throw new UnimplementedOperationException();
    }

    @Override
    public Collection<String> getPermissions() {
        throw new UnimplementedOperationException();
    }

    @Override
    public InetSocketAddress getAddress() {
        throw new UnimplementedOperationException();
    }

    @Override
    public SocketAddress getSocketAddress() {
        throw new UnimplementedOperationException();
    }

    @Override
    public void disconnect(String reason) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void disconnect(BaseComponent... reason) {
        throw new UnimplementedOperationException();
    }

    @Override
    public void disconnect(BaseComponent reason) {
        throw new UnimplementedOperationException();
    }

    @Override
    public boolean isConnected() {
        throw new UnimplementedOperationException();
    }

    @Override
    public Unsafe unsafe() {
        throw new UnimplementedOperationException();
    }
}
