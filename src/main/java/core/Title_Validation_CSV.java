package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Title_Validation_CSV {

	public static void main(String[] args) throws FileNotFoundException {
		File csvFile = new File("C:/Workspace/Title_Validation_CSV/src/main/resources/Test.csv");
		String row = null;
		String delimiter = "!";
		String testId = null;
		String url = null;
		String exp_title = null;
		
		Scanner reader = new Scanner(csvFile);
		
		WebDriver dr = new HtmlUnitDriver();
		
		while (reader.hasNextLine()) {
			row = reader.nextLine();
			String[] cells = row.split(delimiter);

			testId = cells[0];
			url = cells[1];
			exp_title = cells[2];
			
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
			String act_title = dr.getTitle();
			System.out.println("");
			
			System.out.println("File name:\t\t\"Multiple_Title_Validation.java\"");
			System.out.println("Test CaseID: \t\t" + testId);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Title: \t" + exp_title);
			System.out.println("Actual Title: \t\t" + act_title);
			
			if (exp_title.equals(act_title)) {
				System.out.println("Test Case Result: \t" + "PASSED");
			}else {
				System.out.println("Test Case Result: \t" + "FAILED");
			}
		}
		dr.quit();
		reader.close();
	}	
}
