package com.beangou.year2022.month01.day18;

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class TestNio {

    @Test
    public void see() throws IOException {
        SocketChannel channel = ServerSocketChannel.open().accept();
//        channel.register();
        Selector selector = Selector.open();
        selector.selectedKeys();
    }

}
