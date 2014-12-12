package CombineFiles;

public class WrapperExe {
	
	public static void main(String[] args) {
		new WrapperExe().doSomething();
	}
	public boolean doSomething() {

		String[] exeCmd = new String[] { "ffmpeg", "-i", "/video/mergefiles/test-00000-00060.avi",
				"-i", "/video/mergefiles/test-00060-00120.avi", "-acodec", "copy", "-vcodec", "copy",
				"/video/mergefiles/outputFile.avi" };

		ProcessBuilder pb = new ProcessBuilder(exeCmd);
		boolean exeCmdStatus = executeCMD(pb);

		return exeCmdStatus;
	} // End doSomething Function

	private boolean executeCMD(ProcessBuilder pb) {
		pb.redirectErrorStream(true);
		Process p = null;

		try {
			p = pb.start();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("oops");
			p.destroy();
			return false;
		}
		// wait until the process is done
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("woopsy");
			p.destroy();
			return false;
		}
		return true;
	}// End function executeCMD
}
