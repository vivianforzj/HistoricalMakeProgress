package filestatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileStatusTester {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, InterruptedException {
		String file = "watchedDir/1.txt";
		FileStatusTester tester = new FileStatusTester();
		File f = new File(file);
		// tester.testCanWrite(f);
		// tester.testRename(f);
		// tester.testFileLock(f);
		// tester.testLastModified(f);
	}

	public void testLastModified(File f) throws InterruptedException {
		Date date = new Date(f.lastModified());
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss SSS");
		int i = 0;
		while (true) {
			System.out.println(formatter.format(date));
			Thread.sleep(5 * 1000);
		}
	}

	public void testCanWrite(File f) throws InterruptedException {
		// 没有任何用
		while (true) {
			System.out.println(f.canWrite());
			Thread.sleep(5 * 1000);
		}
	}

	public void testRename(File f) throws InterruptedException {
		// 只要文件在被写或者被读，就不能rename
		File file = new File("watchedDir/2.txt");
		while (true) {
			System.out.println(f.renameTo(file));
			Thread.sleep(5 * 1000);
		}
	}

	public void testFileLock(File f) throws FileNotFoundException, IOException,
			InterruptedException {
		// 只要该文件加了文件锁，此种方法才能有效；如果该文件正在被写且没有加文件锁，或者正在被读，此处仍能获得
		// 该文件的文件锁，此时通过此种方法判断文件是否在使用中是无效的
		while (true) {
			// get the file lock
			try (RandomAccessFile randFile = new RandomAccessFile(f, "rw")) {
				FileChannel channel = randFile.getChannel();
				FileLock lock = channel.tryLock();

				if (lock != null) {
					lock.release();
					System.out.println("true");
				} else
					System.out.println("false");

				Thread.sleep(5 * 1000);
			}
		}
	}

}
