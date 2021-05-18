package top.iqqcode.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户实体对象
 *
 * @author dingliqiang
 */
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String token;
}
