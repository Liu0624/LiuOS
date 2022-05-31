package com.example.liuos.controller;

import com.example.liuos.service.PermissionService;
import com.example.liuos.service.RoleService;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/permission")
@Api("权限接口")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @GetMapping("/searchAllPermission")
    @ApiOperation("查询所有权限")
    public R searchAllRole(){
        List<HashMap> list = service.searchAllPermission();
        return R.ok().put("list", list);
    }
}
