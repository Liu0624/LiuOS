package com.example.liuos.service;

import cn.hutool.core.util.PageUtil;
import com.alibaba.druid.sql.PagerUtils;
import com.example.liuos.dao.pojo.TbUser;
import com.example.liuos.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


public interface UserService {
    public Integer login(HashMap param);

    public Set<String> searchUserPermissionsByUserId(int userId);

    public TbUser searchUserById(int userId);

    public int updatePassword(HashMap param);

    public HashMap getNickNameAndPhoto(int userId);

    public PageUtils getUserByPage(HashMap param);

    public long getUserCount(HashMap param);

    public int insert(TbUser user);

    public int update(HashMap param);

    public HashMap searchById(int userId);

    //前端传入数组
    public int deleteUserByIds(Integer[] ids);
}
