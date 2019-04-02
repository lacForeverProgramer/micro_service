package com.lacForever.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午5:37
 */
@Entity
@Table(name = "permission_t")
public class SysPermission implements Serializable{

    private static final long serialVersionUID = -7711038559500607283L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToMany
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns = {
            @JoinColumn(name = "rid") })
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}