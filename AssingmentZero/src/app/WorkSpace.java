
import java.util.ArrayList;
import java.util.Scanner;

public class WorkSpace {
// will create a input file and output file prompt
    public static void main (String [] args) {
    	
    	Scanner keyboard = new Scanner(System.in);
        System.out.print("Please provide the name of the input file (to be located in data/input/): ");
        String inputFileName = keyboard.nextLine();
        
        System.out.print("Please provide the name of the output file (to be located in data/input/): ");
        String outputFileName = keyboard.nextLine();
// will display the number of qualified apllicants by using data from the inputfile
        int qualifiedCount = applicantFiles(inputFileName, outputFileName);
    
        System.out.println("There were qualified applicants: " + qualifiedCount);
        
        keyboard.close();

    }

    	//This calculates an applicant's score based on their age.
	public static void calculateScoreAge(ArrayList<String> applicantList) {
		for (int i = 0; i < applicantList.size(); i++) {
			int age = Integer.parseInt(applicantList.get(i));
			int score = 0;
			
			if (age < 18) {
				score += 0;
			} else if (age >= 18 && age <= 35) {
				score += 12;
			} else if (age == 36) {
				score += 11;
			} else if (age == 37) {
				score += 10;
			} else if (age == 38) {
				score += 9;
			} else if (age == 39) {
				score += 8;
			} else if (age == 40) {
				score += 7;
			} else if (age == 41) {
				score += 6;
			} else if (age == 42) {
				score += 5;
			} else if (age == 43) {
				score += 4;
			} else if (age == 44) {
				score += 3; 
			} else if (age == 45) {
				score += 2;
			} else if (age == 46) {
				score += 1;
			} else if (age >= 47) {
				score += 0;
			}


    private static int applicantFiles(String inputFileName, String outputFileName) {
		return ;
	}

}
