package annotation;

import java.io.Serializable;

/**
 * @author XuDabin
 * @description
 * @create 2020-07-10 9:55
 */
@Table(tableName = "user")
public class User implements Serializable {
    @Column(value = "id", type = "int", COMMENT = "主键")
    private Long id;
    @Column(value = "username", type = "varchar", length = 20, COMMENT = "用户名")
    private String name;
    @Column(value = "password", type = "varchar", length = 30, COMMENT = "密码")
    private String password;

}
