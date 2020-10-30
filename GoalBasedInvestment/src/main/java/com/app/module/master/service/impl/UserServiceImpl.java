package com.app.module.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.beans.ResponseBean;
import com.app.beans.UserBean;
import com.app.constant.MessageConstant;
import com.app.entities.User;
import com.app.exception.GoalBasedInvestmentException;
import com.app.module.master.repository.IUserDao;
import com.app.module.master.service.IUserService;

/**
 * @author shruti
 * @since 30 oct 2020
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public ResponseBean insertOrUpdateUser(UserBean userBean) throws GoalBasedInvestmentException {
		User user = new User();
		BeanUtils.copyProperties(userBean, user);
		userDao.save(user);
		return ResponseBean.builder().message(MessageConstant.DATA_SAVE_SUCCESS)
				.messageDescription(MessageConstant.SUCCESS_MESSAGE).status(true)
				.satusCode(HttpStatus.CREATED.value()).hasError(false).build();
	}

	@Override
	public ResponseBean getActiveUsers() throws GoalBasedInvestmentException {
		try {
			return ResponseBean.builder().data(prepareUsersBeanFromUsers(userDao.getAllActiveUsers())).status(true)
					.hasError(false).message(MessageConstant.SUCCESS_MESSAGE).build();
		} catch (Exception e) {
			throw new GoalBasedInvestmentException(GoalBasedInvestmentException.SERVER_ERROR, MessageConstant.SERVER_ERROR_MESSAGE,
					MessageConstant.QUERY_FETCH_EXCPTION);
		}
	}

	@Override
	public ResponseBean getUsers() throws GoalBasedInvestmentException {
		try {
			return ResponseBean.builder().data(prepareUsersBeanFromUsers(userDao.findAll())).status(true)
					.hasError(false).message(MessageConstant.SUCCESS_MESSAGE).build();
		} catch (Exception e) {
			throw new GoalBasedInvestmentException(GoalBasedInvestmentException.SERVER_ERROR, MessageConstant.SERVER_ERROR_MESSAGE,
					MessageConstant.QUERY_FETCH_EXCPTION);
		}
	}

	private List<UserBean> prepareUsersBeanFromUsers(List<User> allUsers) {
		List<UserBean> userBeans = new ArrayList<UserBean>();
		allUsers.forEach(user -> {
			UserBean userBean = new UserBean();
			BeanUtils.copyProperties(user, userBean);
			userBeans.add(userBean);
		});
		return userBeans;
	}
}
