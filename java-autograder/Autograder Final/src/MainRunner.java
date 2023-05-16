import java.io.*;

public class MainRunner {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//This is the file that will act as the input for all files
		final String INPUT_FILE = "/Users/samuelwilhite/Downloads/AutoGrader/file-input/inputTest.txt";
		
		//Directory that holds all student java files
		final String STUDENT_DIR = "/Users/samuelwilhite/Downloads/AutoGrader/student-files";
		
		//Input the golden java file here. GOLDEN_TXT will act as the placeholder for the completed text file. If text file is already created, skip GOLDEN_FILE and set TXT_IS_CREATED to true.
		final String GOLDEN_FILE = "/Users/samuelwilhite/Downloads/AutoGrader/golden-file/HW2.java";
		final String GOLDEN_TXT = "/Users/samuelwilhite/Downloads/AutoGrader/golden-output/golden-txt.txt";
		final boolean TXT_IS_CREATED = false;
		
		final String TEMP_FILE_NAME = "/Users/samuelwilhite/Downloads/AutoGrader/temp-file/HW2.java";
		
		//Directory for the text files to be created
		final String STUDENT_OUTPUT_DIRECTORY = "/Users/samuelwilhite/Downloads/AutoGrader/student-outputs";
		
		//Directory for the final result
		final String FINAL_RESULT_DIRECTORY = "/Users/samuelwilhite/Downloads/AutoGrader/final-results/finalresults.txt";
		
		//ShellCommand.shellCommand("javac " + "/Users/samuelwilhite/Downloads/AutoGrader/CommandLineTest/testCommandLineCopy.java" + " < " + "/Users/samuelwilhite/Downloads/AutoGrader/CommandLineTest/input.txt" + " > " + "/Users/samuelwilhite/Downloads/AutoGrader/student-outputs/output2.txt");
		//ShellCommand.shellCommand("java /Users/samuelwilhite/Downloads/AutoGrader/CommandLineTest/testCommandLineCopy.java < /Users/samuelwilhite/Downloads/AutoGrader/CommandLineTest/input.txt > /Users/samuelwilhite/Downloads/AutoGrader/student-outputs/output2.txt");
		
		System.out.print("Running files...");
		File studentDir = new File(STUDENT_DIR);
		File[] studentFiles = studentDir.listFiles();
		for(File student : studentFiles) {
			if(student.getName().contains(".java")) {
				ShellCommand.shellCommand("cp " + student.getPath() + " " + TEMP_FILE_NAME);
				ShellCommand.shellCommand("javac " + TEMP_FILE_NAME + " < " + INPUT_FILE + " > " + STUDENT_OUTPUT_DIRECTORY + "/" + student.getName().substring(0, student.getName().indexOf(".")) + ".txt");
				ShellCommand.shellCommand("java " + TEMP_FILE_NAME + " < " + INPUT_FILE + " > " + STUDENT_OUTPUT_DIRECTORY + "/" + student.getName().substring(0, student.getName().indexOf(".")) + ".txt");
				ShellCommand.shellCommand("rm " + TEMP_FILE_NAME);
			}
		}
		
		if(!TXT_IS_CREATED) {
			ShellCommand.shellCommand("javac " + GOLDEN_FILE + " < " + INPUT_FILE + " > " + GOLDEN_TXT);
			ShellCommand.shellCommand("java " + GOLDEN_FILE + " < " + INPUT_FILE + " > " + GOLDEN_TXT);
		}
		System.out.println("File runs complete.");
		
		fileComparer.main(args, GOLDEN_TXT, FINAL_RESULT_DIRECTORY, STUDENT_OUTPUT_DIRECTORY);
	}

}
