package testcases.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.com_data.assert_text;
import data.com_data.comdata;
import model.connectMySql;
import model.csv_reader;
import pages.account_center.account_center_navi_bar_page;
import pages.login.login_page;

public class test_case_002_login_success_with_ordinary_user {
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
    public void test_ordinary_user_login_by_csv() throws Exception{
    	login_page loginp=new login_page(dr);
    	csv_reader csvr=new csv_reader("D:\\java files\\tuqiangol_test1\\src\\data\\login\\login_with_ordinary_user.csv");
    	List<List<String>> csvList = csvr.readCSVFile();
    	List<String> user_data=new ArrayList<String>();
    	List<String> par_user_data=new ArrayList<String>();
    	assert_text assertt=new assert_text();
    	comdata comd=new comdata();
    	connectMySql conn=new connectMySql();
    	account_center_navi_bar_page acenternbp=new account_center_navi_bar_page(dr);
    	
		for(int i=0;i<csvList.size();i++){
			loginp.open_login_page();
			Thread.sleep(2000);
			loginp.user_login(csvList.get(i).get(0), csvList.get(i).get(1));
			String actual_url=dr.getCurrentUrl();
			String expect_url = comd.base_url() + "/nomalUserCenter";
			Assert.assertEquals(actual_url, expect_url, "登陆页面跳转错误");
			//断言当前登录账号的用户名
			String hello_user_account=acenternbp.hello_user_account();
			Assert.assertEquals(hello_user_account, csvList.get(i).get(0), "账户总览右上方显示的账户错误");
			String listValue="u.parentId"; 
			String sql="FROM `user_info` AS u where account='"+csvList.get(i).get(0)+"';";
			user_data=conn.connectMySqlM(sql, listValue);
			
			String par_listValue="o.account,o.nickName,o.phone";
			String par_sql="FROM user_info AS o WHERE userId ='"+user_data.get(2)+"';";
			//System.out.println("select"+"\t"+par_listValue+"\t"+par_sql);
			par_user_data=conn.connectMySqlM(par_sql, par_listValue);
			//System.out.println(acenternbp.sales_usr_service_provider());
			Assert.assertEquals(acenternbp.ordinary_usr_service_provider(), par_user_data.get(0), "服务商显示错误");
			Assert.assertEquals(acenternbp.ordinary_usr_service_provider_connect(), par_user_data.get(1), "联系人显示错误");
			Assert.assertEquals(acenternbp.ordinary_usr_service_provider_phone(),par_user_data.get(2),"电话显示错误");
			acenternbp.usr_logout_dismiss();
			Assert.assertEquals(dr.getCurrentUrl(), comd.base_url() + "/nomalUserCenter#", "取消退出系统失败");
			acenternbp.usr_logout();
			Assert.assertEquals(dr.getCurrentUrl(), comd.base_url()+"/", "退出系统失败");
		}
    }


}
