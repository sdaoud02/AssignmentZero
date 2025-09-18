
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
    private static int applicantFiles(String inputFileName, String outputFileName) {
		return ;
	}

}
