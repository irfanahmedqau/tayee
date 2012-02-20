package com.bleum.canton.myaccount.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.IPwdSecuritySettingDao;
import com.bleum.canton.myaccount.entity.PwdSecuritySetting;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */

@Repository("pwdSecuritySettingDao")
@Transactional
public class PwdSecuritySettingDaoImpl extends BaseDaoHibernateImpl<PwdSecuritySetting> implements IPwdSecuritySettingDao {
	public PwdSecuritySettingDaoImpl(){
		super.init();
	}
}
