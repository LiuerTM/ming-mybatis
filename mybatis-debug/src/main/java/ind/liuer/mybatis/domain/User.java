package ind.liuer.mybatis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author Mingの
 * @date 2022/6/7 17:07
 * @since 1.0
 */
@ToString
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    /**
     * 主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Character sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 删除标志[0 已删除，1 未删除]
     */
    private Boolean delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
