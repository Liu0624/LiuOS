package com.example.liuos.controller;

import com.example.liuos.controller.form.FormTest;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Api("测试Web接口")
public class TestController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/sayHello")
    @ApiOperation("最简单的测试方法")
    public R sayHello(@Valid @RequestBody FormTest form) {
        redisTemplate.opsForValue().set("name", "Liu");
        return R.ok().put("message","hello," + form.getName());
    }
}
