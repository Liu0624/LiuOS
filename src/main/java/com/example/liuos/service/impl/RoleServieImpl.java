package com.example.liuos.service.impl;

import com.example.liuos.dao.mapper.TbRoleMapper;
import com.example.liuos.dao.pojo.TbRole;
import com.example.liuos.service.RoleService;
import com.example.liuos.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoleServieImpl implements RoleService {
    @Autowired
    private TbRoleMapper roleMapper;

    @Override
    public List<HashMap> searchAllRole() {
        List<HashMap> res = roleMapper.searchAllRole();
        return res;
    }

    @Override
    public PageUtils searchRoleByPage(HashMap params) {
        List<HashMap> list = roleMapper.searchRoleByPage(params);
        //总记录条数
        long count = roleMapper.searchRoleCount(params);
        //查询的页的第一条记录的序号
        int start = (Integer) params.get("start");
        //每页记录数
        int length = (Integer)params.get("length");
        PageUtils pageUtils = new PageUtils(list, count, start, length);
        return pageUtils;
    }

    @Override
    public int insert(TbRole role) {
        int rows = roleMapper.insert(role);
        return rows;
    }
}
