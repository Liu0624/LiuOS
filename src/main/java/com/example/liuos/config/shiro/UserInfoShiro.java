package com.example.liuos.config.shiro;

import com.example.liuos.dao.pojo.TbUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoShiro implements Serializable {
    private static final long serialVersionUID = 8494048657048720145L;

    private TbUser user;	// 用户

    private String accessToken;	// 用户oauth授权accessToken


    public UserInfoShiro(TbUser user, String accessToken) {
        super();
        this.user = user;
        this.accessToken = accessToken;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return user.toString();
    }
}




