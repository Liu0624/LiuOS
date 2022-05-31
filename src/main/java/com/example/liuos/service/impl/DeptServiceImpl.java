package com.example.liuos.service.impl;

import com.example.liuos.dao.mapper.TbDeptMapper;
import com.example.liuos.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {
    @Autowired
    private TbDeptMapper deptMapper;

    @Override
    public List<HashMap> searchAllDept() {
        List<HashMap> list = deptMapper.searchAllDept();
        return list;
    }
}
