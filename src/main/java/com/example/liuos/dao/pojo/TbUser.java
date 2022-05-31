package com.example.liuos.dao.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName tb_user
 */
@Data
public class TbUser implements Serializable {
    private String password;

    private String username;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 长期授权字符串
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像网址
     */
    private String photo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Object sex;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 入职日期
     */
    private Date hiredate;

    /**
     * 角色
     */
    private Object role;

    /**
     * 是否是超级管理员
     */
    private Integer root;

    /**
     * 部门编号
     */
    private Integer deptId;

    /**
     * 状态
     */
        private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 长期授权字符串
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 长期授权字符串
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 头像网址
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 头像网址
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别
     */
    public Object getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(Object sex) {
        this.sex = sex;
    }

    /**
     * 手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 手机号码
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 入职日期
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * 入职日期
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 角色
     */
    public Object getRole() {
        return role;
    }

    /**
     * 角色
     */
    public void setRole(Object role) {
        this.role = role;
    }

    /**
     * 是否是超级管理员
     */
    public Integer getRoot() {
        return root;
    }

    /**
     * 是否是超级管理员
     */
    public void setRoot(Integer root) {
        this.root = root;
    }

    /**
     * 部门编号
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 部门编号
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbUser other = (TbUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getHiredate() == null ? other.getHiredate() == null : this.getHiredate().equals(other.getHiredate()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getRoot() == null ? other.getRoot() == null : this.getRoot().equals(other.getRoot()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getHiredate() == null) ? 0 : getHiredate().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getRoot() == null) ? 0 : getRoot().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", nickname=").append(nickname);
        sb.append(", photo=").append(photo);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", hiredate=").append(hiredate);
        sb.append(", role=").append(role);
        sb.append(", root=").append(root);
        sb.append(", deptId=").append(deptId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}