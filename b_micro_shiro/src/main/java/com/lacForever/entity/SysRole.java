package com.lacForever.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午5:35
 */

@Entity
@Table(name = "role_t")
public class SysRole implements Serializable{
    private static final long serialVersionUID = -1294490153543131811L;

    @Id
    @GeneratedValue
    private Integer id;
    private String role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "pid") })
    private List<SysPermission> permissions;
    @ManyToMany
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "uid") })
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
