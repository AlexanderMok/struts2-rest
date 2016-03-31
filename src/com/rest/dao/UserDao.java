package com.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rest.bean.User;

public class UserDao {
	
	private static Map<Integer,User> list =  new HashMap<Integer,User>();
	private Integer id = 6;
	// 以内存中的数据，模拟数据库的持久存储
	static {
		
		list.put(1,new User(1,"Tom",22));
		list.put(2,new User(2,"Josh",23));
		list.put(3,new User(3,"Luisa",18));
		list.put(4,new User(4,"John",26));
		list.put(5,new User(5,"Kate",21));
	}
	
	//增加或更新
	public void insert(User user) {
		
		if(user.getId()==null) {
			user.setId(id++);
		}
		
		list.put(user.getId(),user);
	}
	//删除
	public void deleteById(Integer id) {
		list.remove(id);
	}
	//查单个
	public User selectById(Integer id) {
		return list.get(id);
	}
	//查全部
	public List<User> selectUsers() {
		return new ArrayList<User>(list.values());
	}
}
