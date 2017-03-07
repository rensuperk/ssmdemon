package com.ssmdemon.rk.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssmdemon.rk.common.RespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by renkai on 2017/3/7.
 */
@Component
public class GlobleException extends SimpleMappingExceptionResolver {

    @Autowired
    private MessageSource messageSource;
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
                                              Object handler, Exception exception) {
        exception.printStackTrace();
        /*ModelAndView error = new ModelAndView("error");
		error.addObject("exMsg", ex.getMessage());
		error.addObject("exType", ex.getClass().getSimpleName().replace("\"", "'"));*/
        RespDto respDto = null;
        response.setStatus(HttpServletResponse.SC_OK);
        if (exception instanceof RespException) {
            String message = messageSource.getMessage(exception.getMessage(), null, exception.getMessage(), Locale.CHINESE);
            respDto = new RespDto(400, message);
        }  else if (exception instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) exception;
            respDto = new RespDto(400, e.getBindingResult().getFieldError().getDefaultMessage());
        } else {
            respDto = new RespDto(400, "系统错误");
        }

        String content = JSON.toJSONString(respDto, SerializerFeature.WriteMapNullValue);

        PrintWriter out = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.write(content);
            out.flush();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return null;
        }
}
