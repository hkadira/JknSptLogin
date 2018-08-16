package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportManager {
	private ExtentTest extentTest;
	private ExtentReports extent;
	private String extentReportFile;
	private String extentReportImage;
	
	public ReportManager(String reportName, String suiteName){
		createReportFolder();
		//extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		extentReportFile = System.getProperty("user.dir") + "\\Reports\\"+getSubFolderName()+"\\" +reportName+".html";
	    extentReportImage = System.getProperty("user.dir") + "\\extentReportImage.png";
	    
		// Create object of extent report and specify the report file path.
	    extent = new ExtentReports(extentReportFile, false);

	    // Start the test using the ExtentTest class object.
	    extentTest = extent.startTest(reportName, suiteName);
	}

	public void passStep(String log) {
		 extentTest.log(LogStatus.PASS, log);
	}

	public void writeLog(String log) {
		 extentTest.log(LogStatus.INFO, log);
	}
	
	public void writeFailure(String log) {
		extentTest.log(LogStatus.FAIL, log);
	}
	
	public void finish() {
		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}
	
	//Create Report
	public void createReportFolder() {
		File fileStructure = new File("Reports");
		if (!fileStructure.exists()) {
			if (fileStructure.mkdir()) {
				System.out.println("New Folder/Directory created .... ");
			} else {
				System.out.println("Oops!!! Something blown up file creation...");
			}
		} else {
			System.out.println("File already exists !!! ...");
		}
		File subFiles = new File("Reports/"+ getSubFolderName() );
		if (subFiles.mkdirs()) {
			System.out.println("Full directory structure created ... ");
		} else {
			System.out.println("Oops!!! Something blown up files creation...");
		}
	}

	public String getSubFolderName() {
		String format = "MM-dd-yyyy";
		Date now = new Date();
		DateFormat dateFormatter = new SimpleDateFormat(format);
		String date = dateFormatter.format(now);
		return date;
	}
}
