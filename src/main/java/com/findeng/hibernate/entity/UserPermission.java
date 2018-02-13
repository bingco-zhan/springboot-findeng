package com.findeng.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 用户权限表
 */
@Entity
@Table(name = "user_permission")
public class UserPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "permission_des")
    private String permissionDes;

    public UserPermission() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionDes() {
        return this.permissionDes;
    }

    public void setPermissionDes(String permissionDes) {
        this.permissionDes = permissionDes;
    }

}