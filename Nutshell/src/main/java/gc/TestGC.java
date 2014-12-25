package gc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestGC {
	/**
	 * 等待按键盘，然后执行。
	 * 
	 * @param msg
	 */
	static void waitAnddo(String msg) {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("H:mm:ss");
		System.out.println(df.format(new Date()) + "\t" + msg);
	}

	public static void main(String[] args) {
		System.out.println("配合jvisualvm测试谁能触发vm的gc。\n可以加参数，java TestGC null／或者java TestGC gc");
		waitAnddo("开始建立数组");
		int Len = 1000000;
		String[] arr = new String[Len];
		waitAnddo("开始赋值");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf(System.nanoTime());
		}

		if (args.length > 0 && args[0].equals("null")) {
			waitAnddo("赋值为null");
			arr = null;
		} else if (args.length > 0 && args[0].equals("gc")) {
			waitAnddo("System.gc");
			System.gc();
		}

		waitAnddo("开始循环");
		while (true) {
			System.out.println("循环已进入");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
