package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {

	
	static WebDriver driver;
	
	public static void captureScreenShot(WebDriver driver,String TestID) throws IOException {
		
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		// import form javatext
		Date date = new Date();
		//DATE import from java.util
		String display = dateFormat.format(date);
		
		String arr [] = display.split(" ");
		String datePrint = arr[0];
		String timePrint = arr[1];
		
		File dest = new File("G:\\softwere testing\\automation\\others in atomation\\"
				+TestID+"(Date(dd-mm-yyyy) "
				+datePrint+" Time(hrs-min-sec) "
				+timePrint+").png");
        FileHandler.copy(src, dest);
		
		
	}
	
	
	//input sheetname , 
	public static String getDatafromExcel(String sheetname,int row, int column) throws EncryptedDocumentException, IOException {
		String data;
		
		String path = "G:\\softwere testing\\automation\\xcel data\\Book 1.xlsx"; 
		FileInputStream file = new FileInputStream(path);
		data = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		
		
		try 
		{
			data = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
			
		}
		catch(IllegalStateException e)
		{
			String path2 = "G:\\softwere testing\\automation\\xcel data\\Book 1.xlsx"; 
			FileInputStream file2 = new FileInputStream(path);
			double data2 = WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			String condobtostr = String.valueOf(data2); //look at youtube
		}
		
		return data;
		

	}
	
}
