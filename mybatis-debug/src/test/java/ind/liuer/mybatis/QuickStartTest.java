package ind.liuer.mybatis;

import ind.liuer.mybatis.dao.UserMapper;
import ind.liuer.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mingの
 * @date 2022/6/7 17:44
 * @since 1.0
 */
public class QuickStartTest {

    public static final Logger log = LoggerFactory.getLogger(QuickStartTest.class);

    @Test
    public void test00() throws IOException {
        // 获取配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 打开 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行 SQL 方式一
//        String statement = "ind.liuer.mybatis.dao.UserMapper.selectUserByPrimaryKey";
        long parameter = 1L;
//        User selectedUser = sqlSession.selectOne(statement, parameter);
//        log.info("Selected user: {}", selectedUser);

        // 执行 SQL 方式二
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User selectedUser = userMapper.selectUserByPrimaryKey(parameter);
        log.info("Selected user: {}", selectedUser);

//        User user = new User();
//        user.setUsername("Tom")
//            .setPassword("123456")
//            .setAge(20)
//            .setSex('男')
//            .setEmail("1111@ming.com");
//        int affectedRows = userMapper.insertUser(user);
//        log.info("Affected rows: {}", affectedRows);
//        log.info("User: {}", user);

        // 提交事务
        sqlSession.commit();

        // 关闭资源
        sqlSession.close();
        inputStream.close();
    }
}
