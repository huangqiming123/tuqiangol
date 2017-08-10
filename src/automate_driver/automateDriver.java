package automate_driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class automateDriver {
	WebDriver dr;
	public automateDriver(WebDriver dr){
		this.dr=dr;
	}
	public String get_current_url(){
		return dr.getCurrentUrl();
	}
	public void navigate(String base_url,String url){
		dr.get(base_url+url);
	}
	public void navigate_to_page(String url){
		dr.get(url);
	}
	public void clear_cookies(){
		dr.manage().deleteAllCookies();
	}
	public void operate_input_element(String selector,String value){
		this.get_element(selector).clear();
		this.get_element(selector).sendKeys(value);
	}
	public WebElement get_element(String selector){
		if(selector.equals(null)){
			WebElement element=null;
			return element;
		}else{
			if(!selector.contains(",")){
				WebElement element=dr.findElement(By.id(selector));
				return element;
			}else{
				String select_by=selector.split(",")[0];
				String select_value=selector.split(",")[1];
				if(select_by.equals("s")){
					WebElement element=dr.findElement(By.cssSelector(select_value));
					return element;
				}else if(select_by.equals("x")){
					WebElement element=dr.findElement(By.xpath(select_value));
					return element;
				}else if(select_by.equals("l")){
					WebElement element=dr.findElement(By.linkText(select_value));
					return element;
				}else if(select_by.equals("c")){
					WebElement element=dr.findElement(By.className(select_value));
					return element;
				}else if(select_by.equals("p")){
					WebElement element=dr.findElement(By.partialLinkText(select_value));
					return element;
				}
			}
		}
		return null;
		
	}
	public List<WebElement> get_elements(String selector){
		List<WebElement> elements=new ArrayList<WebElement>();
		if(selector.equals(null)){
			//WebElement elements=null;
			return null;
		}else{
			if(!selector.contains(",")){
				elements=dr.findElements(By.id(selector));
				return elements;
			}else{
				String select_by=selector.split(",")[0];
				String select_value=selector.split(",")[1];
				if(select_by.equals("s")){
					elements=dr.findElements(By.cssSelector(select_value));
					return elements;
				}else if(select_by.equals("x")){
					elements=dr.findElements(By.xpath(select_value));
					return elements;
				}else if(select_by.equals("l")){
					elements=dr.findElements(By.linkText(select_value));
					return elements;
				}else if(select_by.equals("c")){
					elements=dr.findElements(By.className(select_value));
					return elements;
				}else if(select_by.equals("p")){
					elements=dr.findElements(By.partialLinkText(select_value));
					return elements;
				}
			}
		}
		return null;
		
	}
	public void click_element(String selector){
		WebElement element=this.get_element(selector);
		element.click();
	}
	public String get_text(String selector){
		WebElement element=this.get_element(selector);
		String text=element.getText();
		return text;
	}
	// Û±Í–¸Õ£
	public void float_element(String selector){
		Actions ac=new Actions(dr);
		ac.moveToElement(this.get_element(selector)).perform();
		
	}
	public String get_current_window_handle(){
		String handle=dr.getWindowHandle();
		return handle;
	}
	public Set<String> get_all_window_handles(){
		Set<String> handles=new HashSet<String>();
		handles=dr.getWindowHandles();
		return handles;
	}
	public void switch_to_window(String handle){
		dr.switchTo().window(handle);
	}
	public boolean is_element_exist(String selector){
		if(this.get_element(selector).isDisplayed()){
			return true;
		}else{
			return false;
		}
		
	}
}
