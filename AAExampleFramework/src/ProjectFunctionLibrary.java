import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class ProjectFunctionLibrary {

	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;
	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;
	static String fireFoxBrowser;
	static String chromeBrowser;
	static String result;
	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
		
	/* Name Of the Method: click Object
	* Description: Click on the Object
	* Arguments: objXpath --> Xpath of an Object, objName --> Nam eof the Object
	* */
	public static void clickObject(String objXpath, String objName) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	mainDriver.driver.findElement(By.xpath(objXpath)).click();
	Update_Report("Pass ", "Click Object ", objName + " object is clicked.");
	}else{
	Update_Report("Fail ", "Click Object ", objName + " object is not displayed.");
	}
	}
		
	public static void validateMessageDisplayed(String objXpath, String objName, String expected) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	String actualErrMsg = mainDriver.driver.findElement(By.xpath(objXpath)).getText();
	if(actualErrMsg.equals(expected)){
	Update_Report("Pass", "Validate Message Displayed"," Actual message is equal to expected messgae" );
	}
	else{
	Update_Report("Fail", "Validate Message Displayed"," Actual message : '" + actualErrMsg + "' is NOT equal to expected " + expected );
	}
	}
	else{
	Update_Report("Fail", "Validate Message Displayed", objName + " field does not exist, please check the application" );
	}
	}

	// Method Name: Select Check Box
	public static void selectCheckBox(String objXpath, String objName) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	if(!(mainDriver.driver.findElement(By.xpath(objXpath)).isSelected())){
	mainDriver.driver.findElement(By.xpath(objXpath)).click();
	Update_Report("Pass ", "select CheckBox ", " Check box " + objName + " is selected.");
	}else{
	Update_Report("Pass ", "select CheckBox ", " Check box " + objName + " is already selected.");
	}
	}else{
	Update_Report("Fail ", "select CheckBox ", " Check box " + objName + " is not displayed, please check the application.");
	}
	}

	/* Name Of the Method: enterText
	* Description: Enter the text in to text field
	* Arguments : objXpath --> xpath of an object, enterValue --> Text value to be entered, objName --> Name of the Object
	*/
	public static void enterText(String objXpath, String enterValue, String objName) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	mainDriver.driver.findElement(By.xpath(objXpath)).sendKeys(enterValue);
	Update_Report( "Pass", "Enter Text", enterValue + " is entered in " + objName + " field");
	}else{
	Update_Report( "Fail", "Enter Text", objName + " field does not exist, please check the application.");
	}
	}
	

	/**
	* Function to enter Text and tab on selected field using xPath using Selenium Functions
	* @param objXpath
	* @param enterValue
	* @param objName
	* @throws IOException
	*/
	public static void enterTextnTab(String objXpath, String enterValue, String objName) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	mainDriver.driver.findElement(By.xpath(objXpath)).sendKeys(enterValue);
	mainDriver.driver.findElement(By.xpath(objXpath)).sendKeys(Keys.TAB);
	Update_Report( "Pass", "Enter Text", enterValue + " is entered in " + objName + " field");
	}else{
	Update_Report( "Fail", "Enter Text", objName + " field does not exist, please check the application.");
	}
	}
	
	
	/**
	* Function to find Text in a web page using Selenium Functions
	* @param objXpath
	* @param enterValue
	* @param objName
	* @throws IOException
	*/
	public static void findText(String objXpath, String enterValue, String objName) throws IOException{
	if(mainDriver.driver.findElement(By.xpath(objXpath)).isDisplayed()){
	if ((boolean)mainDriver.driver.findElement(By.xpath(objXpath)).getText().equals(enterValue)){
	Update_Report( "Pass", "Displayed Value", enterValue + " is displayed in " + objName + " field");
	}
	else{
	Update_Report( "Fail", "Displayed Value", enterValue + " not displayed in " + objName + " field");
	}
	}
	}
	
	
	/**
	* Function to start the HTML Report
	* @param scriptName
	* @param ReportsPath
	* @throws IOException
	*/
	public static void startReport(String scriptName, String ReportsPath) throws IOException{
	String strResultPath = null;
	String testScriptName =scriptName;
	cur_dt = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	String strTimeStamp = dateFormat.format(cur_dt);
	if (ReportsPath == "") {
	ReportsPath = "/Users/herambh/Google Drive/Projects/SeleniumFramework/";
	}
	if (ReportsPath.endsWith("//")) {
	ReportsPath = ReportsPath + "//";
	}
	strResultPath = ReportsPath + "Log" + "/" +testScriptName + "/" + "FireFox/";
	File f = new File(strResultPath);
	f.mkdirs();
	htmlname = strResultPath + testScriptName + "_" + strTimeStamp
	+ ".html";
	bw = new BufferedWriter(new FileWriter(htmlname));
	bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
	+ "FireFox " + "</B></FONT></TD></TR>");
	bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	bw.write("<TR COLS=7><TD BGCOLOR=#A4A4A4 WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
	+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
	+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
	+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
	+ "<TD BGCOLOR=#A4A4A4 WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detailed Report</B></FONT></TD></TR>");
	}
	/**
	* Function to Update the HTML Report
	* @param Res_type
	* @param Action
	* @param result
	* @throws IOException
	*/
	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
	String str_time;
	Date exec_time = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	str_time = dateFormat.format(exec_time);
	if (Res_type.startsWith("Pass")) {
	bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
	+ (j++)
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	+Action
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	+ str_time
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
	+ "Passed"
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
	+ result + "</FONT></TD></TR>");
	} else if (Res_type.startsWith("Fail")) {
	exeStatus = "Failed";
	report = 1;
	bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
	+ (j++)
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	+Action
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	+ str_time
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
	+ "<a href= "
	+ htmlname
	+ " style=\"color: #FF0000\"> Failed </a>"
	+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
	+ result + "</FONT></TD></TR>");
	}
	}

	}
