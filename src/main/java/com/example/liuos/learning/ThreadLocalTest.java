package com.example.liuos.learning;

import com.example.liuos.controller.form.FormTest;
import com.example.liuos.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/test")
public class ThreadLocalTest {
    private static ThreadLocal<Integer> num = new ThreadLocal<>();

    @GetMapping("/thread")
    @ApiOperation("threadlocal测试")
    public R get(String[] args) {
        if (num.get() == null) {
            num.set(0);
        }
        num.set(num.get().intValue() + 1);
        String name = Thread.currentThread().getName();
        int x = num.get();
        num.remove();

        log.info("{}->{}", name, x);

        return R.ok().put("message",name + "->" + x);
    }
}

