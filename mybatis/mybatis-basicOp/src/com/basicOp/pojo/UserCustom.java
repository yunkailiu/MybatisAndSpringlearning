package com.basicOp.pojo;

/**
 * 
 * @author 刘云锴 
 * 该文档的作用是继承与实体类对应的pojo类，因为实体类可以通过逆向工程创建，比如User.java，创建后的原始类建议不要改动
 * 通过这样继承的方式去添加一些属性更加科学。
 */
public class UserCustom extends User {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
