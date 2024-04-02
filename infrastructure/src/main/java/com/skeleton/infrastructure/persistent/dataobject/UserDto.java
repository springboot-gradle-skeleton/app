package com.skeleton.infrastructure.persistent.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// for jdbc
@Table("users")
// for mybatis plus
@TableName("users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Id
    private Long id;

    // for jdbc
    @Column("user_name")
    // for mybatis plus
    @TableField("user_name")
    private String username;
    private String email;
}
