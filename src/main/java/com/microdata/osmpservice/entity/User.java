package com.microdata.osmpservice.entity;

/**
 * 用户实体
 * Created by Longder on 2016/8/3.
 */
public class User {
    /**
     * 用户id标识（相当于登录时的用户名）
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    private String deptId;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 选用标识
     */
    private String chooseFlag;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getChooseFlag() {
        return chooseFlag;
    }

    public void setChooseFlag(String chooseFlag) {
        this.chooseFlag = chooseFlag;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
