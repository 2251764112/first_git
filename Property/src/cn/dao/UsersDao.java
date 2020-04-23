package cn.dao;

import org.apache.ibatis.annotations.Param;

import cn.pojo.Users;

public interface UsersDao {
       //登录验证的方法
	   int isValidation(@Param("id") String cardid,@Param("psw") String password);
	   //注册的方法
	   int addUsers(Users user);
	   //通过身份证查询信息
	   Users getByCarId(@Param("id") String cardid);
}
