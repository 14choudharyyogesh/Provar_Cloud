package api.listners;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static String repnmae;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance

	public static ExtentReports createInstance() {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date());
		repnmae = "Test Reports-" + timestamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repnmae);
		sparkReporter.config().setReportName("Provar cloud API");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setEncoding("utf-8");

	    extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
        return extent;
	}

}