//NOTE: Java code is not my own. All rights to code go to https://www.baeldung.com/run-shell-command-in-java.
import java.io.*;
import java.util.concurrent.Executors;

public class ShellCommand {

	public static void shellCommand(String command) throws IOException, InterruptedException {
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		ProcessBuilder builder = new ProcessBuilder();
		if (isWindows) {
		    builder.command("cmd.exe", "/c", command);
		} else {
		    builder.command("sh", "-c", command);
		}
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		StreamGobbler streamGobbler = 
		  new StreamGobbler(process.getInputStream(), System.out::println);
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}

}
