package me.lokka.jz.config;

import me.lokka.jz.utils.CustomerException;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler(Exception exception){
        // 输出异常信息
        exception.printStackTrace();
        // 如果是自定义异常，抛出错误信息
        if(exception instanceof CustomerException){
            return MessageUtil.error(exception.getMessage());
        } else if (exception instanceof DataIntegrityViolationException) {
            return MessageUtil.error("数据库错误！");
        }
        return MessageUtil.error("后台接口异常！");
    }
}