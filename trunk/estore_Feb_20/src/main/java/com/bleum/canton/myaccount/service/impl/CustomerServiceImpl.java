/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.myaccount.command.CustomerForm;
import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.PwdSecuritySettingForm;
import com.bleum.canton.myaccount.command.RegisterForm;
import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.myaccount.dao.ICustomerProfileDao;
import com.bleum.canton.myaccount.dao.IPwdSecuritySettingDao;
import com.bleum.canton.myaccount.entity.Customer;
import com.bleum.canton.myaccount.entity.CustomerProfile;
import com.bleum.canton.myaccount.enumeration.CustomerStatus;
import com.bleum.canton.myaccount.service.ICustomerService;
import com.bleum.canton.myaccount.util.MyAccDateUtil;
import com.bleum.canton.myaccount.util.MyAccMD5Util;

/**
 * @author rudy.ding
 *
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	
	@Resource(name="customerProfileDao")
	private ICustomerProfileDao customerProfileDao;
	
	@Resource(name="pwdSecuritySettingDao")
	private IPwdSecuritySettingDao pwdSecuritySettingDao;
	
	public CustomerForm login(LoginForm loginForm) {
		if (loginForm == null) {
			logger.debug("cannot login. loginForm is null.");
			return null;
		}
		String loginName = loginForm.getLoginName();
		String loginPwd  = loginForm.getPassword();
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if (customer == null) {
			logger.debug("cannot login. customer does not exist.");
			return null;
		}
		String pwdInDb = customer.getPassword();
		// compare password
		try {
			if ( loginPwd != null && pwdInDb != null && MyAccMD5Util.validPassword(loginPwd, pwdInDb)) {
				// persist last login time
				long currentTime = System.currentTimeMillis();;
				customer.setLastLoginDate(new Timestamp(currentTime));
				logger.debug("success to login. login name: " + loginForm.getLoginName());
				return customerEntity2Form(customer);
			}
		} catch (NoSuchAlgorithmException e) {
			logger.debug(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.debug(e.getMessage(), e);
		}
		logger.debug("cannot login.");
		return null;
	}

	public CustomerForm register(RegisterForm registerForm) {
		if (registerForm == null) {
			logger.debug("wrong parameter. registerForm is null.");
			return null;
		}
		
		String loginName = registerForm.getLoginName();
		// check loginName
		if (!this.isValidLoginName(loginName)) {
			logger.debug("the login name is duplicated. cannot register.");
			return null;
		}
		
		String email = registerForm.getEmail();
		// check email
		if (!this.isValidEmail(email)) {
			logger.debug("the email is duplicated. cannot register.");
			return null;
		}
		
		Customer customer = null;
		try {
			String password = MyAccMD5Util.getEncryptedPwd(registerForm.getPassword());
			// new customer
			customer = new Customer();
			customer.setLoginName(loginName);
			customer.setPassword(password);
			customer.setEmail(email);
			customer.setStatus(CustomerStatus.ACTIVATE_PENDDING);
			CustomerProfile profile = new CustomerProfile();
			profile.setCustomer(customer);
			customer.setProfile(new CustomerProfile());
			
			// persist
			customerProfileDao.create(profile);
			logger.debug("register successfully.");
			
			return customerEntity2Form(customer);
			
		} catch (NoSuchAlgorithmException e) {
			logger.debug(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.debug(e.getMessage(), e);
		}
		
		logger.debug("register failed.");
		return null;
	}

	public boolean isValidLoginName(String loginName) {
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if ( customer != null ) {
			logger.debug("the login name is duplicated. cannot register.");
			return false;
		}
		return true;
	}

	public boolean isValidEmail(String email) {
		Customer customer = customerDao.findCustomerByEmail(email);
		if ( customer != null ) {
			logger.debug("the email is duplicated. cannot register.");
			return false;
		}
		return true;
	}

	public CustomerForm updateCustomer(CustomerForm customerForm) {
		
		if (customerForm == null) {
			logger.debug("wrong parameter. customerForm is null.");
			return null;
		}
		
		String loginName = customerForm.getLoginName();
		
		//get customer from session
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if (customer == null) {
			logger.error("cannot update customer, fail to get customer.");
			throw new RuntimeException(); //TODO exception handling
		}
		//set value to customer
		//customer.setLoginName(customerForm.getLoginName());
		//customer.setEmail(customerForm.getEmail());
		customer.setDescription(customerForm.getDescription());
		//customer.setPassword(customerForm.getPassword());
		customer.getProfile().setNickName(customerForm.getNickName());
		customer.getProfile().setFirstName(customerForm.getFirstName());
		customer.getProfile().setLastName(customerForm.getLastName());
		customer.getProfile().setBirthday(MyAccDateUtil.toSqlTimestamp(customerForm.getBirthday()));
		customer.getProfile().setGender(customerForm.getGender());
		
		//persist customer
		logger.debug("customer updated successfully.");
		
		return customerEntity2Form(customer);
	}

	public Customer getCustomerByLoginName(String loginName) {
		if (loginName == null) {
			logger.debug("wrong parameter. loginName is null.");
			return null;
		}
		return customerDao.findCustomerByLoginName(loginName);
	}
	
	public CustomerForm getCustomerFormByLoginName(String loginName) {
		if (loginName == null) {
			logger.debug("wrong parameter. loginName is null.");
			return null;
		}
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if (customer == null) {
			logger.error("cannot refresh customer. fail to get customer.");
			throw new RuntimeException(); //TODO exception handling
		}

		return customerEntity2Form(customer);
	}

	public void lockCustomer(String loginName) {
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if (customer == null) {
			logger.error("cannot lock customer, fail to get customer.");
			throw new RuntimeException(); //TODO exception handling
		} else {
			customer.setStatus(CustomerStatus.LOCKED);
		}
		customerDao.update(customer);
	}

	public void activateCustomer(String loginName) {
		Customer customer = customerDao.findCustomerByLoginName(loginName);
		if (customer == null) {
			logger.error("cannot activate customer, fail to get customer.");
			throw new RuntimeException(); //TODO exception handling
		} else {
			customer.setStatus(CustomerStatus.NORMAL);
		}
		customerDao.update(customer);
	}

	public void savePwdSecuritySettings(PwdSecuritySettingForm pwdSecuritySettingForm) {
		
	}

	public void emailChangePwd(String loginName) {
		
	}

	public void snsChangePwd(String loginName) {
		
	}

	public void changePwd(String loginName, String newPwd) {
		
	}

	public void getSecurityQuestions(String loginName) {
		
	}

	public void verifySecurityAnswers(String loginName,
			Map<String, String> QuestionAnswers) {
		
	}
	
	private CustomerForm customerEntity2Form(Customer customer) {
		if ( customer == null) {
			return null;
		}
		CustomerForm form = new CustomerForm();
		form.setLoginName(customer.getLoginName());
		form.setEmail(customer.getEmail());
		form.setPassword(customer.getPassword());
		form.setStatus(customer.getStatus());
		form.setLastLoginDate(MyAccDateUtil.dateToString(customer.getLastLoginDate()));
		if (customer.getProfile() != null) {
			form.setNickName(customer.getProfile().getNickName());
			form.setFirstName(customer.getProfile().getFirstName());
			form.setLastName(customer.getProfile().getLastName());
			form.setBirthday(MyAccDateUtil.dateToString(customer.getProfile().getBirthday()));
			form.setGender(customer.getProfile().getGender());
			form.setMobilePhone(customer.getProfile().getMobilePhone());
		}
		return form;
	}

}
