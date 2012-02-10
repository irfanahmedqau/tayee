/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import javax.annotation.Resource;

import com.bleum.canton.myaccount.command.CustomerForm;
import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.PwdSecuritySettingForm;
import com.bleum.canton.myaccount.command.RegisterForm;
import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.myaccount.dao.IPwdSecuritySettingDao;
import com.bleum.canton.myaccount.entity.Customer;
import com.bleum.canton.myaccount.entity.PwdSecuritySetting;
import com.bleum.canton.myaccount.service.ICustomerService;

/**
 * @author rudy.ding
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	
	@Resource(name="pwdSecuritySettingDao")
	private IPwdSecuritySettingDao pwdSecuritySettingDao;
	
	
	
	public boolean login(LoginForm loginForm) {
		
		return false;
	}

	public Customer register(RegisterForm registerForm) {
		Customer customer = new Customer();
		
//		String email = 	registerForm.getEmail();
		String loginName = registerForm.getLoginName();
		String password  = registerForm.getPassword();
		
		customer.setLoginName(loginName);
		customer.setPassword(password);
		customerDao.create(customer);
		return customer;
	}

	public void addPwdSecuritySetting(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
		PwdSecuritySetting pwdSecuritySetting = new PwdSecuritySetting();
		String answer1 = pwdSecuritySettingForm.getAnswer1();
		String answer2 = pwdSecuritySettingForm.getAnswer2();
		String email   = pwdSecuritySettingForm.getEmail();
		String mobilePhone = pwdSecuritySettingForm.getMobilePhone();
		String question1   = pwdSecuritySettingForm.getQuestion1();
		String question2   = pwdSecuritySettingForm.getQuestion2();
		
		CustomerForm customer = pwdSecuritySettingForm.getCustomer();
		
		pwdSecuritySetting.setAnswer1(answer1);
		pwdSecuritySetting.setAnswer1(answer2);
		pwdSecuritySetting.setEmail(email);
		pwdSecuritySetting.setMobilePhone(mobilePhone);
		pwdSecuritySetting.setQuestion1(question1);
		pwdSecuritySetting.setQuestion2(question2);
		
		
	}

	public void modifyPwdSecuritySetting(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
		PwdSecuritySetting pwdSecuritySetting = new PwdSecuritySetting();
		String answer1 = pwdSecuritySettingForm.getAnswer1();
		String answer2 = pwdSecuritySettingForm.getAnswer2();
		String question1   = pwdSecuritySettingForm.getQuestion1();
		String question2   = pwdSecuritySettingForm.getQuestion2();
				
		pwdSecuritySetting.setAnswer1(answer1);
		pwdSecuritySetting.setAnswer1(answer2);
		pwdSecuritySetting.setQuestion1(question1);
		pwdSecuritySetting.setQuestion2(question2);
		
		pwdSecuritySettingDao.update(pwdSecuritySetting);
		
	}

	public void deletePwdSecuritySetting(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
		PwdSecuritySetting pwdSecuritySetting = new PwdSecuritySetting();
		Long id = pwdSecuritySettingForm.getId();
		pwdSecuritySetting.setId(id);
		
		pwdSecuritySettingDao.delete(pwdSecuritySetting);
		
	}

	public boolean validateRegisteredName(RegisterForm registerForm) {
		// TODO Auto-generated method stub
		String loginName = registerForm.getLoginName();
		Customer customer = customerDao.findCustomerByName(loginName);
		return customer == null?true:false;
	}

	public void lockCustomer(LoginForm loginForm) {
		// TODO Auto-generated method stub
		
	}

	public void activateCustomer(Long customerId) {
		// TODO Auto-generated method stub
		
	}

	public void savePwdSecuritySettings(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
//		pwdSecuritySettingDao.create(entity)
	}

	public void emailChangePwdLink(Long customerId) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifySecurityAnswers(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean snsTemporaryPwd(Long customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public PwdSecuritySetting getSecurityQuestions(
			PwdSecuritySettingForm pwdSecuritySettingForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
