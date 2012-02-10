package com.bleum.canton.myaccount.service;

import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.PwdSecuritySettingForm;
import com.bleum.canton.myaccount.command.RegisterForm;
import com.bleum.canton.myaccount.entity.Customer;
import com.bleum.canton.myaccount.entity.PwdSecuritySetting;

public interface ICustomerService {

	/**
	 * login
	 * @param loginForm
	 * @return
	 */
	public boolean login(LoginForm loginForm);
	
	/**
	 * register a customer
	 * @param registerForm
	 * @return CustomerForm
	 */
	public Customer register(RegisterForm registerForm);
	
	/**
	 * validateRegisteredName
	 * @param registerForm
	 * @return
	 */
	public boolean validateRegisteredName(RegisterForm registerForm);
	
	
	/**
	 * lockCustomer
	 * @param customerId
	 */
	public 	void		lockCustomer(LoginForm loginForm);
	
	/**
	 * activateCustomer
	 * @param customerId
	 */
	public void     activateCustomer(Long customerId);
	
	/**
	 * savePwdSecuritySettings
	 * @param pwdSecuritySettingForm
	 */
	public void 	savePwdSecuritySettings(PwdSecuritySettingForm pwdSecuritySettingForm);
	
	
	/**
	 * emailChangePwdLink
	 * @param customerId
	 */
	public void     emailChangePwdLink(Long customerId);
	
	
	/**
	 * verifySecurityAnswers
	 * @param pwdSecuritySettingForm
	 */
	public boolean     verifySecurityAnswers(PwdSecuritySettingForm pwdSecuritySettingForm);
	
	
	/**
	 * snsTemporaryPwd
	 * @param customerId
	 * @return boolean
	 */
	public boolean     snsTemporaryPwd(Long customerId);
	
	
	/**
	 * getSecurityQuestions
	 * @param pwdSecuritySettingForm
	 * @return PwdSecuritySetting
	 */
	public PwdSecuritySetting     getSecurityQuestions(PwdSecuritySettingForm pwdSecuritySettingForm);
	
	
	
}
