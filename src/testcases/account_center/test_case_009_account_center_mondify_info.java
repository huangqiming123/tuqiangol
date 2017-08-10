package testcases.account_center;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.account_center.account_center_navi_bar_page;
import pages.login.login_page;
import data.com_data.comdata;
import model.connectMySql;
import model.csv_reader;
import data.com_data.assert_text;

public class test_case_009_account_center_mondify_info {
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
	public void test_account_center_modify_info() throws Exception{
    	login_page loginp=new login_page(dr);
    	account_center_navi_bar_page acenternbp=new account_center_navi_bar_page(dr);
    	comdata comd=new comdata();
    	assert_text assertt=new assert_text();
    	connectMySql conn=new connectMySql();
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\account_center\\user_to_modify_info.csv");
    	List<List<String>> csvList = csvr.readCSVFile();
    	List<String> user_info=new ArrayList<String>();
    	loginp.open_login_page();
		Thread.sleep(2000);
    	loginp.user_login(comd.base_user()[0], comd.base_user()[1]);
    	for(int i=0;i<csvList.size();i++){
    	String save_status=acenternbp.modify_usr_info(csvList.get(i).get(0), csvList.get(i).get(1), csvList.get(i).get(2));
    	
    	Assert.assertEquals(save_status, assertt.account_center_page_operation_done()[0],"²Ù×÷Ê§°Ü");
    	String listValue="o.nickName,o.phone,o.email";
		String sql="FROM user_info AS o WHERE account ='"+comd.base_user()[0]+"';";
		user_info=conn.connectMySqlM(sql, listValue);
			for(int j=0;j<csvList.get(i).size();j++){
				Assert.assertEquals(csvList.get(i).get(j), user_info.get(j),"Êý¾Ý´íÎó");
		}
    	}
	}

}
