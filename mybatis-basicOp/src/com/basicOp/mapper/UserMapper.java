package com.basicOp.mapper;

import java.util.HashMap;
import java.util.List;

import com.basicOp.pojo.User;
import com.basicOp.pojo.UserCustom;
import com.basicOp.pojo.UserQueryVo;

public interface UserMapper {
	public User findUserById(int id);

	public List<User> findUserByName(String userName);

	public int insertUser(User user);

	public int deleteUser(int id);

	public int updateUser(User user);

	public List<UserCustom> findUserList(UserQueryVo userQueryVo);

	public List<User> findUserMap(HashMap<String, Object> hashMap);
	
	public User findUserByIdMap(int id);
}
