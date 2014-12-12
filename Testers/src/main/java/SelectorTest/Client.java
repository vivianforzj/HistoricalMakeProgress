package SelectorTest;

import java.io.IOException;  
import java.net.InetSocketAddress;  
import java.nio.ByteBuffer;  
import java.nio.channels.SelectionKey;  
import java.nio.channels.Selector;  
import java.nio.channels.SocketChannel;  
import java.util.Iterator;  
import java.util.Scanner;
import java.util.Set;  
 
public class Client { 
	
	ByteBuffer receiveBuf;
	
    public void start() throws IOException { 
        SocketChannel sc = SocketChannel.open(); 
        sc.configureBlocking(false); 
        sc.connect(new InetSocketAddress("localhost", 8001)); 
        Selector selector = Selector.open(); 
        sc.register(selector, SelectionKey.OP_CONNECT); 
        Scanner scanner = new Scanner(System.in); 
        receiveBuf = ByteBuffer.allocate(50);
        while (true) { 
            selector.select(); 
            Set<SelectionKey> keys = selector.selectedKeys(); 
            System.out.println("keys=" + keys.size()); 
            Iterator<SelectionKey> keyIterator = keys.iterator(); 
            while (keyIterator.hasNext()) { 
                SelectionKey key = keyIterator.next(); 
                keyIterator.remove(); 
                System.out.println("=========="+key.readyOps());
                if (key.isConnectable()) { 
                    sc.finishConnect(); 
                    sc.register(selector, SelectionKey.OP_WRITE); 
                    System.out.println("server connected..."); 
                } else if (key.isWritable()) { 
 
                    System.out.println("please input message"); 
                    String message = scanner.nextLine(); 
                    ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes()); 
                    sc.write(writeBuffer); 
                    sc.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                	receiveBuf.clear();
                	while (sc.read(receiveBuf) > 0);
                	receiveBuf.flip();
                	System.out.println(new String(receiveBuf.array()));
                	 sc.register(selector, SelectionKey.OP_WRITE);
                }
            } 
        } 
    } 
 
    public static void main(String[] args) throws IOException { 
        new Client().start(); 
    } 
} 