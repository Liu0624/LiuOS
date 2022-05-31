package com.example.liuos.controller;

import cn.hutool.json.JSONUtil;
import com.example.liuos.controller.form.InsertRoleForm;
import com.example.liuos.controller.form.InsertUserForm;
import com.example.liuos.controller.form.SearchRoleByPageForm;
import com.example.liuos.dao.pojo.TbRole;
import com.example.liuos.service.RoleService;
import com.example.liuos.utils.PageUtils;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
@Api("角色模块web接口")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/searchAllRole")
    @ApiOperation("查询所有角色")
    public R searchAllRole(){
        List<HashMap> map = roleService.searchAllRole();
        return R.ok().put("list", map);
    }

    @PostMapping("/searchRoleByPage")
    @ApiOperation("查询分页角色")
    public R searchRoleByPage(@Valid @RequestBody SearchRoleByPageForm form){
        int length = form.getLength();
        int page = form.getPage();
        //起始序号
        int start = (page - 1) * length;

        HashMap params = JSONUtil.parse(form).toBean(HashMap.class);
        params.put("start", start);
        PageUtils pageUtils = roleService.searchRoleByPage(params);

        return R.ok().put("page", pageUtils);
    }

    @PostMapping("/insert")
    @ApiOperation("插入新角色")
    @RequiresPermissions(value = {"ROOT", "ROLE:ADD"}, logical = Logical.OR)
    public R insert(@Valid @RequestBody InsertRoleForm form){
        TbRole role = JSONUtil.parse(form).toBean(TbRole.class);
        role.setPermissions(JSONUtil.parseArray(form.getPermissions()).toString());
        int rows = roleService.insert(role);
        return R.ok().put("rows", rows);
    }
}
