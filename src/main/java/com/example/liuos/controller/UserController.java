package com.example.liuos.controller;

import cn.hutool.json.JSONUtil;
import com.example.liuos.config.shiro.JwtUtil;
import com.example.liuos.config.shiro.UserInfoShiro;
import com.example.liuos.controller.form.*;
import com.example.liuos.dao.pojo.TbUser;
import com.example.liuos.service.UserService;
import com.example.liuos.service.impl.UpdateUserForm;
import com.example.liuos.utils.PageUtils;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/user")
@Api("用户模块web接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${liuOS.jwt.cache-expire}")
    private int cacheExpire;


    @PostMapping("/login")
    @ApiOperation("用户登录")
    public R login(@Valid @RequestBody LoginForm form){
        HashMap param = new HashMap();
        param.put("username", form.getUsername());
        param.put("password", form.getPassword());
        //执行登录操作
        Integer userId = userService.login(param);
        R r = R.ok().put("result", userId == null? false : true);

        if(userId != null){
            //创建token令牌
            String token = jwtUtil.createToken(userId);
            //保存token到redis
            saveTokenRedis(token, userId);
            //将权限返回给客户端
            Set<String> permsSet = userService.searchUserPermissionsByUserId(userId);
            return r.put("token", token).put("permissions",permsSet);
        }

        return r;
    }

    @GetMapping("/logout")
    @ApiOperation("用户退出")
    public R logout(){
        R r = R.ok();
        return r;
    }

    @PostMapping("/updatePassword")
    @ApiOperation("用户修改密码")
    public R updatePassword(@Valid @RequestBody PasswordForm form){
        int userId = getCurrentUser().getId();

        HashMap param = new HashMap();
        param.put("password", form.getPassword());
        param.put("newPassword", form.getNewPassword());
        param.put("userId", userId);

        int rows = userService.updatePassword(param);
        return R.ok().put("rows", rows);
    }

    @GetMapping("/loadUserInfo")
    @ApiOperation("加载用户信息")
    public R loadUserInfo(){
        int userId = getCurrentUser().getId();
        HashMap param = userService.getNickNameAndPhoto(userId);
        return R.ok(param);
    }

    @PostMapping("/searchUserByPage")
    @ApiOperation("分页查找")
    public R searchUserByPage(@Valid @RequestBody SearchUserByPageForm form){
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        Integer page = form.getPage();
        Integer length = form.getLength();
        Integer start = (page - 1) * length;
        param.put("start", start);

        PageUtils pageUtils = userService.getUserByPage(param);
        return R.ok().put("page", pageUtils);
    }

    @PostMapping("/insert")
    @ApiOperation("添加用户")
    @RequiresPermissions(value = {"ROOT", "USER:ADD"}, logical = Logical.OR)
    public R addUser(@Valid @RequestBody InsertUserForm form) {
        TbUser user = JSONUtil.parse(form).toBean(TbUser.class);
        user.setStatus(1);
        user.setCreateTime(new Date());
        //将json数组转化为String
        user.setRole(JSONUtil.parseArray(form.getRole()).toString());
        int rows = userService.insert(user);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/update")
    @ApiOperation("更新用户信息")
    @RequiresPermissions(value = {"ROOT", "USER:UPDATE"}, logical = Logical.OR)
    public R updateUser(@Valid @RequestBody UpdateUserForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.replace("role", JSONUtil.parseArray(form.getRole()).toString());

        int rows = userService.update(param);
        if(rows == 1) {
            //TODO 踢人下线
        }
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchById")
    @ApiOperation("根据ID查找用户信息")
    @RequiresPermissions(value = {"ROOT", "USER:SELECT"}, logical = Logical.OR)
    public R searchById(@Valid @RequestBody SearchUserByIdForm form) {
        HashMap map = userService.searchById(form.getUserId());
        return R.ok(map);
    }

    @PostMapping("/deleteUserByIds")
    @ApiOperation("根据ID查找用户信息")
    @RequiresPermissions(value = {"ROOT", "USER:DELETE"}, logical = Logical.OR)
    public R deleteUsersByIds(@Valid @RequestBody DeleteUserByIdsForm form) {
        int rows = userService.deleteUserByIds(form.getIds());
        if(rows > 0){
            //TODO 用户强制下线
        }
        return R.ok().put("rows", rows);
    }

    /**
     * 存储token到redis
     * @param token
     * @param userId
     */
    private void saveTokenRedis(String token,int userId){
        redisTemplate.opsForValue().set(token, userId + "", cacheExpire, TimeUnit.DAYS);
    }

    /**
     * 获得当前登录的Tbuser
     * @return
     */
    private TbUser getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        TbUser userInfoShiro = (TbUser) currentUser.getPrincipal();
        return userInfoShiro;
    }

}
