package ind.liuer.mybatis.dao;

import ind.liuer.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息 Mapper 接口
 *
 * @author Mingの
 * @date 2022/6/7 15:39
 * @since 1.0
 */
public interface UserMapper {

    /**
     * 根据主键查询用户信息
     *
     * @param userId 主键
     * @return 用户信息
     */
    User selectUserByPrimaryKey(Long userId);

    /**
     * 根据条件（用户名、年龄、性别、邮箱、删除标识）查询用户信息列表（分页）
     *
     * @param user     用户信息
     * @param pageNum  页码
     * @param pageSize 页数
     * @return 用户信息列表
     */
    List<User> selectListUserByCondition(@Param("user") User user, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 根据主键修改用户信息（年龄、性别、邮箱）
     *
     * @param user 用户信息
     * @return 影响行数
     */
    int updateUserByPrimaryKey(User user);

    /**
     * 根据主键修改密码
     *
     * @param password 密码
     * @param userId   主键
     * @return 影响行数
     */
    int updateUserPasswordByPrimaryKey(@Param("password") String password, @Param("userId") Long userId);

    /**
     * 根据主键修改用户名
     *
     * @param username 用户名
     * @param userId   主键
     * @return 影响行数
     */
    int updateUserUsernameByPrimaryKey(@Param("username") String username, @Param("userId") Long userId);

    /**
     * 根据主键删除用户信息（设置删除标识）
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteUserByPrimaryKey(Long userId);

    /**
     * 新增一条用户信息（用户名、密码、年龄、性别、邮箱）
     *
     * @param user 用户信息
     * @return 影响行数
     */
    int insertUser(User user);

    /**
     * 批量新增用户信息列表（用户名、密码、年龄、性别、邮箱）
     *
     * @param userList 用户信息列表
     * @return 影响行数
     */
    int batchInsertUsers(@Param("userLost") List<User> userList);
}
