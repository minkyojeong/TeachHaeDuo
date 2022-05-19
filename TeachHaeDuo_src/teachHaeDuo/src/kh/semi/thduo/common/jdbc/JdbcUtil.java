package kh.semi.thduo.common.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JdbcUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			InputStream config = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
	
}
