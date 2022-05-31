package com.example.liuos.service.impl;

import com.example.liuos.dao.mapper.TbPermissionMapper;
import com.example.liuos.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<HashMap> searchAllPermission() {
        List<HashMap> map = tbPermissionMapper.searchAllPermission();
        return map;
    }
}
