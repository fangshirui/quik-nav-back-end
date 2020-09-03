package cn.fangshirui.navweb.controller;

import cn.fangshirui.navweb.result.ResultVOUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理程序
 * RestControllerAdvice 为 ControllerAdvice 和 ResponseBody的简写
 *
 * @author kk
 * @date 2020/09/03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }

        return ResultVOUtils.error(msg, 500);
    }
}
