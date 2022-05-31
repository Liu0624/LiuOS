package com.example.liuos.config.shiro;

import com.example.liuos.dao.pojo.TbUser;
import com.example.liuos.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        TbUser user = (TbUser) principals.getPrimaryPrincipal();
        int userId = user.getId();

        Set<String> permsSet = userService.searchUserPermissionsByUserId(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询用户的权限列表
        //把权限列表添加到info对象中
        info.setStringPermissions(permsSet);

        return info;
    }

    /**
     * 认证(登录时调用)
     * 该用户是否是合法状态
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();
        //TODO 从令牌中获取userId，然后检测该账户是否被冻结。
        int userId = jwtUtil.getUserId(accessToken);
        //查询用户信息
        TbUser user = userService.searchUserById(userId);

        if(user == null){
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }

        //标记着用户成功登录，返回给shiro框架
        //TODO 往info对象中添加用户信息、Token字符串
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,accessToken,getName());

        return info;
    }
}