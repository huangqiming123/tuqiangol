package data.com_data;

public class assert_text {
	
	public String log_in_page_account_type(String types){
		if(types.equals(null)){
			return null;
		}else{
			if(types.equals("8")){
				String type="������";
				return type;
			}else if(types.equals("9")){
				String type="�û�";
				return type;
			}else if(types.equals("11")){
				String type="����";
				return type;
			}
			
		}
		return null;
	}
	public String log_in_page_find_password_text(){
		String []find_password_text={"�һ�����",""};
		return find_password_text[0];
	}
	public String[] log_in_page_log_in_text(){
		String []log_in_text={"��¼","Log in","Ingresar","Iniciar","Zaloguj","Einloggen"};
		return log_in_text;
	}
	public String[] log_in_page_third_party_website(){
		String [] third_party_website={"http://szcert.ebs.org.cn/2a950f00-00fb-495c-8e30-5a04100f9b17",
				                       "http://www.cyberpolice.cn/wfjb/",
				                       "http://www.500wan.com/pages/info/about/wangan/index.htm",
				                       "http://www.12377.cn/"
				};
		return third_party_website;
	}
	public String[] account_center_page_operation_done(){
		String[] operation_done={"�����ɹ�",""};
		return operation_done;
				
				
	}
	public String[] account_center_page_modify_passwd_title(){
		String[] modify_passwd_title={"�޸�����",""};
		return modify_passwd_title;
	}
	public String[] account_center_page_modify_passwd_content(){
		String[] modify_passwd_content={"�����޸ĳɹ�",""};
		return modify_passwd_content;
	}

	public static void main(String[] args){
		String types="11";
		assert_text at=new assert_text();
		System.out.println(at.log_in_page_log_in_text()[0]);
	}
}
