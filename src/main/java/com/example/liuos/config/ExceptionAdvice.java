package com.example.liuos.config;


import com.example.liuos.exception.LiuException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * 用于精简发回给客户端的异常信息
 */

@Slf4j
@RestControllerAdvice //用于捕获SpringMVC的各种异常
public class ExceptionAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//规定一下响应的状态码,是服务器内部错误
    @ExceptionHandler(Exception.class)
    public String validExceptionHandler(Exception e){
        log.error("执行异常",e);

        //方法参数异常
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            //某个字段不通过验证，它的原因是什么
            return exception.getBindingResult().getFieldError().getDefaultMessage();
        }
        //自定义异常
        else if(e instanceof LiuException){
            LiuException exception = (LiuException) e;
            return exception.getMsg();
        }
        //权限异常
        else if(e instanceof UnauthorizedException){
            return "你不具有相关权限";
        }
        //普通异常
        else{
            return "后端1执行异常";
        }
    }
}

