package com.example.liuos.dao.pojo;

import java.io.Serializable;

/**
 * 行为表
 * @TableName tb_action
 */
public class TbAction implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 行为编号
     */
    private String actionCode;

    /**
     * 行为名称
     */
    private String actionName;

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
     * 行为编号
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * 行为编号
     */
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    /**
     * 行为名称
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * 行为名称
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
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
        TbAction other = (TbAction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActionCode() == null ? other.getActionCode() == null : this.getActionCode().equals(other.getActionCode()))
            && (this.getActionName() == null ? other.getActionName() == null : this.getActionName().equals(other.getActionName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActionCode() == null) ? 0 : getActionCode().hashCode());
        result = prime * result + ((getActionName() == null) ? 0 : getActionName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actionCode=").append(actionCode);
        sb.append(", actionName=").append(actionName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}