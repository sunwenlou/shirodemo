package cn.ssms.service;

import cn.ssms.model.User;

public interface UserService {
	public User getUserById(int id);

	public User findUserByLoginName(String username);
}
