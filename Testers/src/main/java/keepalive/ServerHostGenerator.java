package keepalive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理配置文件中节点失效
 *
 */
public class ServerHostGenerator {
	
	private final static Logger LOG = LoggerFactory.getLogger(ServerHostGenerator.class);
	
	private final static int PORT = 8888;
	
	private final static String filepath = "conf/video_download_sever.conf";
	private static HashMap<Integer, String> indexIpMap;
	
	private final static String DEFAULT_HOST = "127.0.0.1:8080";
	
	private static Thread thread;
	
	private static void init() {
		indexIpMap = new HashMap<>();
		synchronized (indexIpMap) {
			Properties pro = new Properties();
			File file = new File(filepath);
			try {
				pro.load(new FileReader(file));
			} catch (FileNotFoundException e) {
				LOG.error("can not find file {}", filepath);
				return;
			} catch (IOException e) {
				LOG.error("load configuration file failed : {}", e.getMessage());
				return;
			}
			
			Iterator iterator = pro.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				String index = (String) entry.getKey(),
						ip = (String) entry.getValue();
				if (!index.trim().equals("") && !ip.trim().equals("")) {
					try {
						InetAddress address = InetAddress.getByName(ip);
						if (address.isReachable(10 * 1000)) 
							indexIpMap.put(Integer.parseInt(index), ip);
					} catch (Exception e) {
						LOG.error("ip {} is unavailable :", ip, e);
						continue;
					}
				}
			}
		}
		
		if (thread == null) {
			thread = new Thread() {
				
				public void run() {
					while (true) {
						if (indexIpMap != null)
							synchronized (indexIpMap) {
								Set<Integer> set = new HashSet<>();
								for (int i : indexIpMap.keySet()) {
									try {
										InetAddress address = InetAddress.getByName(indexIpMap.get(i));
										if (!address.isReachable(10 * 1000))
											set.add(i);
									} catch (Exception e) {
										set.add(i);
									}
								}
								for (int i : set)
									indexIpMap.remove(i);
							}

						try {
							Thread.sleep(5 * 60 * 1000);
						} catch (InterruptedException e) {
							LOG.error("thread is interrupted when sleeping");
						}
					}
				}
			};
			thread.start();
		}
		
	}
	
	public static String getServerHost() {
		if (indexIpMap == null || indexIpMap.size() == 0)
			init();
		
		synchronized (indexIpMap) {
			if (indexIpMap.size() == 0)
				return DEFAULT_HOST;
			
			int index = ThreadLocalRandom.current().nextInt(0, indexIpMap.size());
			return indexIpMap.get(index) + ":" + PORT;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			System.out.println("====" + ServerHostGenerator.getServerHost() + "========");
//			Thread.sleep(5 * 1000);
		}
	}
}
