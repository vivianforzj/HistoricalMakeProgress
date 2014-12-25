package us.gfzj.hadooprelated.hbase.util;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTableInterface;

public class BasicConnection {

	
	private static HConnection connection = null;
	private static Configuration conf = null;
	
	static{
		connectHBase();
	}
	
	private static synchronized void connectHBase(){
		try {
			connection = HConnectionManager.createConnection(getConfiguration());
		} catch (IOException e) {
			System.exit(1);
		}
	}
	
	private static void reconnect(){
		try {
			if(connection != null){
				connection.close();
			}	
		} catch (IOException e) {
		}
		connectHBase();
	}
	
	private static synchronized Configuration getConfiguration(){
		if(conf == null){
			conf = HBaseConfiguration.create();
			conf.set("hbase.zookeeper.quorum", "127.0.0.1");
			conf.set("hbase.zookeeper.property.clientPort", "2181");
			conf.set("hbase.client.retries.number", "3");
			conf.set("zookeeper.recovery.retry", "2");
		}
		return conf;
	}
	
	public synchronized static HTableInterface getTable(String tableName) throws IOException{
		if(connection == null || connection.isClosed()){
			reconnect();
		}
		return connection.getTable(tableName);
	}
	
	
	public static void main(String[] args){
		try {
			HTableInterface tableInterface = BasicConnection.getTable("bay_t");
			System.out.println("end get table");
			//HTableInterface tableInterface2 = BasicConnection.getTable("bay2_t");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("has exception");
		}
	}
	
}
