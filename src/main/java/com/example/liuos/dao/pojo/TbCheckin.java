package com.example.liuos.dao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 签到表
 * @TableName tb_checkin
 */
public class TbCheckin implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 签到地址
     */
    private String address;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区划
     */
    private String district;

    /**
     * 考勤结果
     */
    private Integer status;

    /**
     * 风险等级
     */
    private Integer risk;

    /**
     * 签到日期
     */
    private Date date;

    /**
     * 签到时间
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
     * 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 签到地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 签到地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区划
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 区划
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 考勤结果
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 考勤结果
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 风险等级
     */
    public Integer getRisk() {
        return risk;
    }

    /**
     * 风险等级
     */
    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    /**
     * 签到日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 签到日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 签到时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 签到时间
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
        TbCheckin other = (TbCheckin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRisk() == null ? other.getRisk() == null : this.getRisk().equals(other.getRisk()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRisk() == null) ? 0 : getRisk().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", address=").append(address);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", status=").append(status);
        sb.append(", risk=").append(risk);
        sb.append(", date=").append(date);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}