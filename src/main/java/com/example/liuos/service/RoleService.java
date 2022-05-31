package com.example.liuos.service;

import com.example.liuos.dao.pojo.TbRole;
import com.example.liuos.utils.PageUtils;

import java.util.HashMap;
import java.util.List;

public interface RoleService {
    public List<HashMap> searchAllRole();

    public PageUtils searchRoleByPage(HashMap params);

    public int insert(TbRole role);
}
