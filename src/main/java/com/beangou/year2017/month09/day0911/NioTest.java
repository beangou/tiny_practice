package com.beangou.year2017.month09.day0911;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by liutongbin on 2017/9/11.
 */
public class NioTest {

    @Test
    public void socketNio() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
//        socketChannel.register()
//        SelectionKey;
    }

    @Test
    public void nio() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/main/resources/config.properties", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);
            System.out.println(bytesRead);

            while (bytesRead != -1) {
                System.out.println("before buffer=" + buffer);
                buffer.flip();
                System.out.println("after buffer=" + buffer);
                while (buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.compact();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                int a = 0;
                a++;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("888");
        }
    }

    @Test
    public void io() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);

            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buf[i]);
                }
                bytesRead = in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
