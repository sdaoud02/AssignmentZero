package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JustDoit {

    // all private constants which will be used later on in the code
    private static final int INDEX_FIRST_NAME = 0;
    private static final int INDEX_LAST_NAME = 1;
    private static final int INDEX_AGE = 2;
    private static final int INDEX_READING = 4;
    private static final int INDEX_WRITING = 5;
    private static final int INDEX_SPEAKING = 6;
    private static final int INDEX_LISTENING = 7;
    private static final int INDEX_SPOUSE_LANGUAGE = 8;
    private static final int INDEX_EDUCATION = 9;
    private static final int INDEX_EXPERIENCE = 10;
    private static final int INDEX_ARRANGED_EMPLOYMENT = 11;
    private static final int INDEX_ADAPTABILITY_1 = 12;
    private static final int INDEX_ADAPTABILITY_2 = 13;
    private static final int INDEX_ADAPTABILITY_3 = 14;
    private static final int INDEX_ADAPTABILITY_4 = 15;
    private static final int INDEX_ADAPTABILITY_5 = 16;
    private static final int INDEX_ADAPTABILITY_6 = 17;
    private static final int INDEX_ADAPTABILITY_7 = 18;
    private static final int MIN_REQUIRED_FIELDS = 19;
    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
		// create a switch case that reads the dataset and if the case is "secondary school(high school diploma)" or other education return the appropriate score
			// find a way to read the item right after the education and based on what it says return a score based on the scoring criteria again with a switch case
		//System.out.println("Enter your name: ");
		//String name = input.next();
		//System.out.println("Hello " + name);

        System.out.print("Please provide the name of the input file (located in data or input): ");
        String inputFileName = input.nextLine();

        System.out.print("Please provide the name of the output file (to be placed in data or output): ");
        String outputFileName = input.nextLine();

        // will read the the lines and will skip the first line which is the header
        File inputFile = new File("data/input/" + inputFileName);
        Scanner fileScanner = new Scanner(inputFile);
        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
        }

        // will count the applicants who are qualified and will collect their data 
        ArrayList<String> qualifiedRows = new ArrayList<>();
        int qualifiedCount = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] applicantData = line.split("\t");

            if (applicantData.length >= 19) {
                String firstName = applicantData[0];
                String lastName = applicantData[1];
                int age = Integer.parseInt(applicantData[2]);

                int points = calculateTotalScore(applicantData);

                if (points >= 67) {
                    qualifiedCount++;
                    String row = firstName + " ".repeat(16 - firstName.length()) + " | "
                           + lastName + " ".repeat(15 - lastName.length()) + " | "
                           + String.format("%3d | %3d", age, points);
                    qualifiedRows.add(row); // Store for later output
                }
            }
        }
        fileScanner.close();

        // will write the output file
        PrintWriter outputFile = new PrintWriter("data/output/" + outputFileName);
        
        // Output qualified count first
        String countMessage = "There were " + qualifiedCount + " qualified applicants";
        System.out.println(countMessage);
        outputFile.println(countMessage);
        outputFile.println();    
        
        // Output table headers
        outputFile.println("First name       | Last name       | Age | Score");
        outputFile.println("-----------------+-----------------+-----+------");
        System.out.println("\nFirst name       | Last name       | Age | Score");
        System.out.println("-----------------+-----------------+-----+------");
        
        // will write an output of all the applicants who are qualified
        for (String row : qualifiedRows) {
            outputFile.println(row);
            System.out.println(row);
        }

        outputFile.close();
        input.close();
    }

    public static int calculateTotalScore(String[] applicantData) {
        int totalScore = 0;
        totalScore += calculateLanguagePoints(applicantData);
        totalScore += calculateEducationPoints(applicantData[INDEX_EDUCATION]);
        totalScore += calculateWorkExperiencePoints(applicantData[INDEX_EXPERIENCE]);
        totalScore += calculateAgePoints(Integer.parseInt(applicantData[INDEX_AGE]));
        totalScore += calculateArrangedEmploymentPoints(applicantData[INDEX_ARRANGED_EMPLOYMENT]);
        totalScore += calculateAdaptabilityPoints(applicantData);
        return totalScore;
    }

    public static int calculateLanguagePoints(String[] applicantData) {
        int points = 0;
        points += calculateSinglePoint(applicantData[INDEX_READING]);
        points += calculateSinglePoint(applicantData[INDEX_WRITING]);
        points += calculateSinglePoint(applicantData[INDEX_SPEAKING]);
        points += calculateSinglePoint(applicantData[INDEX_LISTENING]);
        if ("yes".equalsIgnoreCase(applicantData[INDEX_SPOUSE_LANGUAGE])) {
            points += 4;
        }
        return points;
    }

    public static int calculateSinglePoint(String clb) {
        int clbLevel = Integer.parseInt(clb);
        int points = 0;
        
        if (clbLevel >= 9) {
            points = 6;
        } else if (clbLevel == 8) {
            points = 5;
        } else if (clbLevel == 7) {
            points = 4;
        }
        
        return points;
    }

    public static int calculateEducationPoints(String education) {
        switch (education) {
            case "Secondary school (high school diploma)":
                return 5;
            case "One-year degree, diploma or certificate":
                return 15;
            case "Two-year degree, diploma or certificate":
                return 19;
            case "Bachelor's degree or other programs (three or more years)":
                return 21;
            case "Two or more certificates, diplomas, or degrees":
                return 22;
            case "Professional degree needed to practice in a licensed profession":
                return 23;
            case "University degree at the Master's level":
                return 23;
            case "University degree at the Doctoral (PhD) level":
                return 25;
            default:
                return 0;
        }   
    }

	// will calc to get the points for work expereince and return the points for it

    public static int calculateWorkExperiencePoints(String experience) {
        int years = Integer.parseInt(experience);
        if (years < 1) return 0;
        if (years == 1) return 9;
        if (years <= 3) return 11;
        if (years <= 5) return 13;
        return 15;
    }
	//This calculates an applicant's score based on their age.

	public static int calculateAgePoints(int age) {
		int score = 0;
	
		if (age < 18) {
			score = 0;
		} else if (age >= 18 && age <= 35) {
			score = 12;
		} else if (age == 36) {
			score = 11;
		} else if (age == 37) {
			score = 10;
		} else if (age == 38) {
			score = 9;
		} else if (age == 39) {
			score = 8;
		} else if (age == 40) {
			score = 7;
		} else if (age == 41) {
			score = 6;
		} else if (age == 42) {
			score = 5;
		} else if (age == 43) {
			score = 4;
		} else if (age == 44) {
			score = 3; 
		} else if (age == 45) {
			score = 2;
		} else if (age == 46) {
			score = 1;
		} else {
			score = 0;
		}
	
		return score;
	}

     /*	will check if applicant has suitable employment 
	 * 	If yes then 10 points will be earned
	 *  If no then 0 points will be earned
	 */
    public static int calculateArrangedEmploymentPoints(String arrangedEmployment) {
        return "yes".equalsIgnoreCase(arrangedEmployment) ? 10 : 0;
    }
	/* Calculates and awards points based on Adaptability requirements
	 * Max score is 10
	 */
    public static int calculateAdaptabilityPoints(String[] applicantData) {
        int score = 0;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_1])) score += 5;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_2])) score += 5;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_3])) score += 5;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_4])) score += 5;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_5])) score += 10;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_6])) score += 5;
        if ("yes".equalsIgnoreCase(applicantData[INDEX_ADAPTABILITY_7])) score += 5;
        
        return Math.min(score, 10);
    }
}
