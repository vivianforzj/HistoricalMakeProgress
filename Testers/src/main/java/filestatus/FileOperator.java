package filestatus;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileOperator {

	public static void main(String[] args) throws IOException, InterruptedException {
		String file = "watchedDir/1.txt";
		File f = new File(file);
		FileOperator w = new FileOperator();
//		w.invokeWrite(f);
//		w.invokeWriteWithLock(f);
		w.invokeRead(f);
	}
	
	public void invokeRead(File f) throws InterruptedException, FileNotFoundException, IOException {
		try (FileReader reader = new FileReader(f)) {
			int i = 0;
			while (i++ < 5) {
				Thread.sleep(5 * 1000);
			}
			
		} 
		
	}

	public void invokeWrite(File file) throws FileNotFoundException, IOException, InterruptedException {
		try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file))){
			int i = 0;
			while (i++ < 5) {
				byte[] data = ("i = " + i + "\r\n").getBytes();
				writer.write(data);
				Thread.sleep(5 * 1000);
			}
			writer.flush();
		} 
		
	}
	
	public void invokeWriteWithLock(File file) throws IOException, InterruptedException {
		try (FileOutputStream writer = new FileOutputStream(file)){
			FileChannel channel = writer.getChannel();
			FileLock lock = channel.tryLock();
			if (lock == null)
				return;
			
			int i = 0;
			while (i++ < 5) {
				byte[] data = ("i = " + i + "\r\n").getBytes();
				writer.write(data);
				writer.flush();
				Thread.sleep(5 * 1000);
			}
			lock.release();
		} 
	}
	
}
