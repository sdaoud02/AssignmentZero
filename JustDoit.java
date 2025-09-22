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
		
		ArrayList<String> lines = new ArrayList<String>(); 
		
		File filePath = new File("res/dataset-10.txt");
		Scanner inputFile = new Scanner(filePath);
		
		while(inputFile.hasNextLine()) {
			lines.add(inputFile.nextLine());
		}
		inputFile.close();
		
			
		prompt();
		String inFi = input.nextLine();
		String ouFi = input.nextLine();
		
		
		PrintWriter outputFile = new PrintWriter("res/" + ouFi);
		int qualified = 0;
		for (String line : lines) {
			ArrayList<String> update = new ArrayList<>();
			String check = "";
			boolean quotation = false;
			for (int i = 0; i < line.length(); i++) {
				char a = line.charAt(i);
				if (a == '"' && a == ',') {
		            quotation = !quotation;  
		        } else if (a == ',' && !quotation) {
		            update.add(check);
		            check = "";
		        } else {
		            check = check + a;
		        }
			}
			update.add(check);
			
			String firstName = lines.get(0);
			String lastName = lines.get(1);
			String age = lines.get(2);
			String education = lines.get(10);
			String work = lines.get(11);
			
			int points = pointsEducation(education) + pointsWork(work);
			
			outputFile.println("First name       | Last name       |  Age | Score \n");
			outputFile.println("-----------------+-----------------+------+------- \n");
			if (points >= 67) {
				qualified ++;
				outputFile.println(firstName + "       | " + lastName + "       |  " + age + " | " + points);
			}

		}
			outputFile.close();
			System.out.println("\n\n There were " + qualified + "qualified applicants");
			input.close();
		
		}
		
		public static void prompt() {
			System.out.println("Please provide the name of the input file (to be located in data/input): ");
			System.out.println("Please provide the name of the output file (to be placed in data/output/): ");
			
		}
		public static int pointsEducation(String education) {
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
		public static int pointsWork(String work) {
			switch (work) {
				case "0":
					return 0;
				case "1":
					return 9;
				case "2":
					return 11;
				case "3":
					return 11;
				case "4":
					return 13;
				case "5":
					return 13;
				default:
					return 15;
			}
			
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
