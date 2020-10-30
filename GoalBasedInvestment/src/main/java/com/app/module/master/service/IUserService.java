package com.app.module.master.service;

import com.app.beans.UserBean;
import com.app.beans.ResponseBean;
import com.app.exception.GoalBasedInvestmentException;

public interface IUserService {

	ResponseBean insertOrUpdateUser(UserBean userBean) throws GoalBasedInvestmentException;

	ResponseBean getActiveUsers() throws GoalBasedInvestmentException;

	ResponseBean getUsers() throws GoalBasedInvestmentException;
}
