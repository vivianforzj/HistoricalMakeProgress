package grandland.glits;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Constants
{
	public static final boolean TNET = tnet();
	public static final String ZK_ADDRS = TNET ? "172.17.1.12,172.17.1.23,172.17.1.45" : "10.101.0.3";
	public static final String ZK_PORT = "2181";
	public static final String IMG_SERVER_IP = TNET ? "172.17.1.57" : "211.87.224.213";
	public static final String IMG_SERVER_PORT = "8888";
	public static final String IMG_SERVER_IP_PORT = "http://" + IMG_SERVER_IP + ":" + IMG_SERVER_PORT;

	public static final String DB_PATH = isWindows() ? "d:\\system\\desktop\\db\\" : "/root/jnits/data/ftp";
	public static final String TXZ_IMG_MARKER_PATH = isWindows() ? "d:\\system\\desktop\\imgs\\" : "/root/jnits/";

	public static void main(String[] args)
	{
	}

	private static boolean tnet()
	{
		boolean tnet = false;
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			tnet = address.getHostAddress().contains("172.1");
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		System.out.println("TNET = " + tnet);
		return tnet;
	}

	private static boolean isWindows()
	{
		Properties props = System.getProperties();
		String osName = props.getProperty("os.name");
		boolean isWindows = osName.contains("indows");
		System.out.println("os.name = " + osName + ", isWindows = " + isWindows);
		return isWindows;
	}
}