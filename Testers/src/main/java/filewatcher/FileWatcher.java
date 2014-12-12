package filewatcher;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class FileWatcher {
	
	Map<WatchKey, Path> watcherMap = new  HashMap<WatchKey, Path>();
	private static WatchService watcher = null;
	static {
		try {
			watcher = FileSystems.getDefault().newWatchService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String dirName = "watchedDir";
	private static final int FILE_NUM = 2; 

	private void watch(String dir) throws InterruptedException {
		Path dirPath = Paths.get(dir);
		getPathRegistered(dirPath);
		getSubdirsRegistered(dirPath.toFile());
		
		while (true) {
			WatchKey key = watcher.take(); 
			
			Path path = watcherMap.get(key);
			if (path == null) return;
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent<Path> evt = cast(event);
				Path name = evt.context();
				Path child = path.resolve(name);
				if (event.kind().name().equals("ENTRY_CREATE")) {
					if (child.toFile().isDirectory()){
						getPathRegistered(child);
					} else if (path.toFile().isDirectory()){
						int fileCount = path.toFile().listFiles().length;
						if (fileCount == FILE_NUM) {
							//TODO we can invoke har file creation
							for (File f : path.toFile().listFiles()) 
								f.delete();
							path.toFile().delete();
						}
					}
				}
			}
			//reset key
			boolean valid = key.reset();
			if(!valid) {
				watcherMap.remove(key);
				if (watcherMap.isEmpty())
					return;
			}
		}
	}

	private <T> WatchEvent<Path> cast(WatchEvent<?> event) {
		return (WatchEvent<Path>)event;
	}

	private void getSubdirsRegistered(File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				getPathRegistered(Paths.get(file.getPath()));
				getSubdirsRegistered(file);
			}
		}
	}

	private void getPathRegistered(Path dirPath) {
		try {
			WatchKey key = dirPath.register(watcher, ENTRY_CREATE, ENTRY_DELETE);
			watcherMap.put(key, dirPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new FileWatcher().watch(dirName);
	}

}
