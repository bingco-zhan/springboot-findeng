package com.findeng.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 用户角色表
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "login_backstage")
    private Byte loginBackstage;

    @Column(name = "permissions")
    private String permissions;

    @Column(name = "role_name")
    private String roleName;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getLoginBackstage() {
        return this.loginBackstage;
    }

    public void setLoginBackstage(Byte loginBackstage) {
        this.loginBackstage = loginBackstage;
    }

    public String getPermissions() {
        return this.permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}