package testcases.login;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.com_data.assert_text;
import model.csv_reader;
import pages.login.login_page;
public class test_case_006_login_change_language {
	WebDriver dr;
	@BeforeMethod
	public void setUp() throws Exception{
		dr=new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
	}
    @AfterMethod
	public void tearDown() throws Exception{
		dr.quit();
	}
    @Test
    public void test_change_language() throws Exception{
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\login\\login_change_language.csv");
    	login_page loginp=new login_page(dr);
    	assert_text assertt=new assert_text();
    	List<List<String>> csvList = csvr.readCSVFile();
    	loginp.open_login_page();
		Thread.sleep(2000);
    	for(int i=0;i<csvList.get(0).size();i++){
    		String actual_login_text=loginp.change_language(csvList.get(0).get(i));
    		String expect_login_text=assertt.log_in_page_log_in_text()[i];
    		Assert.assertEquals(actual_login_text, expect_login_text, "ÓïÑÔÓëËùÇÐ»»ÓïÑÔ²»Ò»ÖÂ");
    		
    	}
    }

}
