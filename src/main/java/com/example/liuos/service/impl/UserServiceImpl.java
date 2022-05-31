package com.example.liuos.service.impl;

import cn.hutool.core.util.PageUtil;
import com.alibaba.druid.sql.PagerUtils;
import com.example.liuos.dao.mapper.TbUserMapper;
import com.example.liuos.dao.pojo.TbUser;
import com.example.liuos.service.UserService;
import com.example.liuos.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
//@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public Integer login(HashMap param) {
        Integer userId = tbUserMapper.login(param);
        return userId;
    }

    @Override
    public Set<String> searchUserPermissionsByUserId(int userId) {
        Set<String> set = tbUserMapper.searchUserPermissions(userId);
        return set;
    }

    @Override
    public TbUser searchUserById(int userId) {
        TbUser user = tbUserMapper.searchUserById(userId);
        return user;
    }

    @Override
    public int updatePassword(HashMap param) {
        int rows = tbUserMapper.updatePassword(param);
        return rows;
    }

    @Override
    public HashMap getNickNameAndPhoto(int userId) {
        HashMap param = tbUserMapper.searchNameAndPhotoById(userId);
        return param;
    }

    @Override
    public PageUtils getUserByPage(HashMap param) {
        List<HashMap> list = tbUserMapper.searchUserByPage(param);
        long count = tbUserMapper.searchUserCount(param);
        int start = (Integer)param.get("start");
        int length = (Integer) param.get("length");
        PageUtils pagerUtils = new PageUtils(list, count, start, length);
        return pagerUtils;
    }

    @Override
    public long getUserCount(HashMap param) {
        return 0;
    }

    @Override
    public int insert(TbUser user) {
        int rows = tbUserMapper.insert(user);
        return rows;
    }

    @Override
    public int update(HashMap param) {
        int rows = tbUserMapper.update(param);
        return rows;
    }

    @Override
    public HashMap searchById(int userId) {
        HashMap res = tbUserMapper.searchById(userId);
        return res;
    }

    @Override
    public int deleteUserByIds(Integer[] ids) {
        int rows = tbUserMapper.deleteUserByIds(ids);
        return rows;
    }
}
