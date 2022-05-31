package com.example.liuos.controller;

import com.example.liuos.service.DeptService;
import com.example.liuos.service.RoleService;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dept")
@Api("角色模块web接口")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/searchAllDept")
    @ApiOperation("查询所有部门")
    public R searchAllRole(){
        List<HashMap> map = deptService.searchAllDept();
        return R.ok().put("list", map);
    }
}
