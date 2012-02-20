package com.bleum.canton.myaccount.service;

import java.util.Map;

import com.bleum.canton.myaccount.command.CustomerForm;
import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.PwdSecuritySettingForm;
import com.bleum.canton.myaccount.command.RegisterForm;
import com.bleum.canton.myaccount.entity.Customer;

public interface ICustomerService {

	public CustomerForm register(RegisterForm registerForm);
	
	public CustomerForm login(LoginForm loginForm);
	
	public boolean isValidLoginName(String loginName);
	
	public boolean isValidEmail(String email);
	
	public CustomerForm updateCustomer(CustomerForm customerForm);
	
	public Customer getCustomerByLoginName(String loginName);
	
	public CustomerForm getCustomerFormByLoginName(String loginName);

	public void lockCustomer(String loginName);
	
	public void activateCustomer(String loginName);
	
	public void savePwdSecuritySettings(PwdSecuritySettingForm pwdSecuritySettingForm);
	
	public void emailChangePwd(String loginName);
	
	public void snsChangePwd(String loginName);
	
	public void changePwd(String loginName, String newPwd);
	
	public void getSecurityQuestions(String loginName);
	
	public void verifySecurityAnswers(String loginName, Map<String, String> QuestionAnswers);
	
}
