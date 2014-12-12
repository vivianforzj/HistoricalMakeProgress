package CombineFiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author lenovo this method is best
 *
 */
public class TogetherThem {

	private static final String DIR = "/video/mergefiles/";
	private static final String FILE1 = "megerdFile.avi";

	// private static final String[] files = {"/client-1415964796.h264",
	// "/client-1415964856.h264",
	// "/client-1415964916.h264", "/client-1415964976.h264",
	// "/client-1415965036.h264", "/client-1415965096.h264"
	// , "/client-1415965156.h264","/client-1415965216.h264",
	// "/client-1415965276.h264", "/client-1415965336.h264",
	// "/client-1415965396.h264"};

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		File[] children = new File(DIR).listFiles();
		BufferedOutputStream writer = new BufferedOutputStream(
				new FileOutputStream(new File(DIR + FILE1)));
		Date date1 = new Date();
		byte[] buf = new byte[1024];
		for (File file : children) {
			BufferedInputStream reader = new BufferedInputStream(
					new FileInputStream(file));

			int length = 0;
			while ((length = reader.read(buf)) > -1) {
				writer.write(buf, 0, length);
			}
			writer.flush();
			reader.close();
			System.out.println(file);
		}
		writer.close();
		Date date2 = new Date();
		System.out.println((date2.getTime() - date1.getTime()));
	}
}
