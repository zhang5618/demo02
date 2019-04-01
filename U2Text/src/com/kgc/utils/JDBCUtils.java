package com.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class JDBCUtils {
	//饿汉式
	private static DataSource ds=new ComboPooledDataSource();
	//便于用类名直接调用
	public static DataSource getDs(){
		return ds;
	}
	//
	public static Connection getCon(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//将servlet中request请求中所有的请求参数一次性装到map中。然后封装到javabean中
	public static <T> T toBean(Class<T> c, Map map){
		try {
			T t = c.newInstance();
			BeanUtils.populate(t,map);
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConn(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
