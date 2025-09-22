package app;
import java.io.File;
//import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class JustDoit {

	static ArrayList<String> filePath = new ArrayList<String>(); 
	final int ARRAY_SIZE = 19;
	//final String filePath = "res//dataset-10.txt";
	static Scanner input = new Scanner(System.in);



	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
			// create a switch case that reads the dataset and if the case is "secondary school(high school diploma)" or other education return the appropriate score
			// find a way to read the item right after the education and based on what it says return a score based on the scoring criteria again with a switch case
		//System.out.println("Enter your name: ");
		//String name = input.next();
		//System.out.println("Hello " + name);
		
		File filePath = new File("res/dataset-10.txt");
		Scanner inputFile = new Scanner(filePath);
			// Read a line from the file
			
			//Put file into array list and read everything on each line as 0-10
		File file = new File("res/dataset-10.txt");
		String word = inputFile.nextLine();
		//System.out.println(word);
		

			
		boolean test = true;
			//reads first line from text file, put these items into an arraylist and then 
		//String word = inputFile.nextLine();
			//System.out.println(word);
		/*switch (word) {
			case "Two or more certificates, diplomas, or degrees":
				System.out.println("You have 22 points");
				break;
		}*/
			//prompt();
			
			do{
				prompt();
				String str = inputFile.nextLine();

				switch (str) {
					case "Secondary school (high school diploma)":
						//int points = 5;
						System.out.println("You have 5 points");
						break;
					case "One-year degree, diploma or certificate":
						//int pointss = 15;
						System.out.println("You have 15 points");
						break;
					case "Two-year degree, diploma or certificate":
						int pointsss = 19;
						break;
					case "Bachelor's degree or other programs (three or more years)":
						int pointssss = 21;
						break;
					case "Two or more certificates, diplomas, or degrees":
						System.out.println("You have 22 points");
						//int pointsssss = 22;
						break;
					case "Professional degree needed to practice in a licensed profession":
						int pointssssss = 23;
						break;
					case "University degree at the Master's level":
						int pointsssssss = 23;
						break;
					case "University degree at the Doctoral (PhD) level":
						int pointssssssss = 25;
						break;
					default:
						System.out.println("Enter a valid option");
						break;
				}
			} while (test == true);
			
			/*input.close();
			inputFile.close();*/
		}
	
		

		public static void prompt() {
			System.out.println("Please provide the name of the input file (to be located in data/input): ");
			String inFil = input.nextLine();
			System.out.println("Please provide the name of the output file (to be placed in data/input/): ");
			String outFil = input.nextLine();
		}

		// will calc language points for first offical language 
		public static int getFirstOfficialLanguagePoints(String speak, String listen, String read, String write){
			int points = 0;
			points += calculateSinglePoint(speak);
			points += calculateSinglePoint(listen);
			points += calculateSinglePoint(read);
			points += calculateSinglePoint(write);
			return points;
		}
		
		public static int calculateSinglePoint(String clb) {
			int clbLevel = Integer.parseInt(clb);
			if (clbLevel >= 9) return 6;
			if (clbLevel == 8) return 5;
			if (clbLevel == 7) return 4;
			return 0;
		}
		// will calc to get the points for work expereince and return the points for it
		public static int pointsWork( String experience){
			int years = Integer.parseInt(experience);
			if (years < 1) return 0;
			if (years == 1) return 9;
			if (years <= 3) return 11;
			if (years <= 5) return 13;
			return 15;
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
				} else {
					score += 0;
				}
			}
		}

		public static void qualified() {
			
		}

		public static void scoreAdaptability(ArrayList<String> applicantList) {
			for (int i = 0; i <applicantList.size(); i++) {
				int score = 0;

				if (applicantList.get(12) == true) {
					score += 5;
				}
				if (applicantList.get(13) == true) {
					score += 5;
				}
				if (applicantList.get(14) == true) {
					score += 5;
				}
				if (applicantList.get(15) == true) {
					score += 5;
				}
				if (applicantList.get(16) == true) {
					score += 10;
				}
				if (applicantList.get(17) == true) {
					score += 5;
				}
				if (applicantList.get(18) == true) {
					score += 5;
				}
				if (score >= 10) {
					score += 10;
				} else {
					score += score;
				}
			}
		}
		
			
	

}
