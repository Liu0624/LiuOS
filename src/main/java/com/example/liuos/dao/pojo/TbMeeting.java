package com.example.liuos.dao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议表
 * @TableName tb_meeting
 */
public class TbMeeting implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 会议题目
     */
    private String title;

    /**
     * 创建人ID
     */
    private Long creatorId;

    /**
     * 日期
     */
    private Date date;

    /**
     * 开会地点
     */
    private String place;

    /**
     * 开始时间
     */
    private Date start;

    /**
     * 结束时间
     */
    private Date end;

    /**
     * 会议类型（1在线会议，2线下会议）
     */
    private Integer type;

    /**
     * 参与者
     */
    private Object members;

    /**
     * 会议内容
     */
    private String desc;

    /**
     * 工作流实例ID
     */
    private String instanceId;

    /**
     * 状态（1未开始，2进行中，3已结束）
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
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 会议题目
     */
    public String getTitle() {
        return title;
    }

    /**
     * 会议题目
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 创建人ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 创建人ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 开会地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 开会地点
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 开始时间
     */
    public Date getStart() {
        return start;
    }

    /**
     * 开始时间
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * 结束时间
     */
    public Date getEnd() {
        return end;
    }

    /**
     * 结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 会议类型（1在线会议，2线下会议）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 会议类型（1在线会议，2线下会议）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 参与者
     */
    public Object getMembers() {
        return members;
    }

    /**
     * 参与者
     */
    public void setMembers(Object members) {
        this.members = members;
    }

    /**
     * 会议内容
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 会议内容
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 工作流实例ID
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * 工作流实例ID
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 状态（1未开始，2进行中，3已结束）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1未开始，2进行中，3已结束）
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
        TbMeeting other = (TbMeeting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getStart() == null ? other.getStart() == null : this.getStart().equals(other.getStart()))
            && (this.getEnd() == null ? other.getEnd() == null : this.getEnd().equals(other.getEnd()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMembers() == null ? other.getMembers() == null : this.getMembers().equals(other.getMembers()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getStart() == null) ? 0 : getStart().hashCode());
        result = prime * result + ((getEnd() == null) ? 0 : getEnd().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMembers() == null) ? 0 : getMembers().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
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
        sb.append(", uuid=").append(uuid);
        sb.append(", title=").append(title);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", date=").append(date);
        sb.append(", place=").append(place);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", type=").append(type);
        sb.append(", members=").append(members);
        sb.append(", desc=").append(desc);
        sb.append(", instanceId=").append(instanceId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}