

import java.io.*;
import java.util.Scanner;

public class fileComparer {
	
	public static void main(String[] args, String goldenOutputPath, String resultOutputPath, String studentOutputDirPath) {
		System.out.print("Comparing files...");
		try {
			
			File goldenOutput = new File(goldenOutputPath); //"/Users/samuelwilhite/Downloads/AutoGrader/golden-output/golden-out.txt"
			Scanner goldenFileOutput = new Scanner(goldenOutput);
			String goldenString = "";
			while(goldenFileOutput.hasNextLine()) goldenString += goldenFileOutput.nextLine();
			//System.out.println(goldenString);
			goldenFileOutput.close();
			File resultOutput = new File(resultOutputPath); //"/Users/samuelwilhite/Downloads/AutoGrader/final-results/finalresults.txt"
			File studentOutputDir = new File(studentOutputDirPath); //"/Users/samuelwilhite/Downloads/AutoGrader/student-outputs"
			resultOutput.createNewFile();
			PrintStream resultOutputWriter = new PrintStream(resultOutput);
			File[] studentOutputs = studentOutputDir.listFiles();
			
			for (File studentFile : studentOutputs) {
				if(studentFile.getName().contains(".txt") ) {
					Scanner studentOutput = new Scanner(studentFile);
					String studentString = "";
					while(studentOutput.hasNextLine()) studentString += studentOutput.nextLine();
					int outputAccuracy = studentString.compareTo(goldenString);
					String fileName = studentFile.getName();
					if(fileName.contains("_")) fileName = fileName.substring(0,fileName.indexOf('_'));
					else fileName = fileName.substring(0, studentFile.getName().indexOf("."));
					if( outputAccuracy == 0) {
						resultOutputWriter.println("\"" + fileName + "\" Result - PASS");
					} else if(studentString.length() == 0) {
						resultOutputWriter.println("\"" + fileName + "\" Result - FAILED TO COMPILE");
					}
					else {
						resultOutputWriter.println("\"" + fileName + "\" Result - FAIL by " + outputAccuracy + " points");
					}
					studentOutput.close();
				}
			}
			resultOutputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File comparison finished.");
	}
}
