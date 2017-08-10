package pages.base;

import org.openqa.selenium.WebDriver;

import automate_driver.automateDriver;
import data.com_data.comdata;

public class base_page extends automateDriver {
	comdata comd=new comdata();

	public base_page(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public void login(){
		super.operate_input_element("account", comd.base_user()[0]);
		super.operate_input_element("password", comd.base_user()[1]);
		super.click_element("x,//*[@id='checkbox']");
		super.click_element("logins");
	}

}
