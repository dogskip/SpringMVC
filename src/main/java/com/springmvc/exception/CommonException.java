package com.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * CommonException 클래스는 애플리케이션 전역에서 발생하는 예외를 처리하는 클래스입니다.
 *
 * <p>이 클래스는 @ControllerAdvice 어노테이션을 사용하여 전역 예외 처리를 수행합니다.</p>
 * <p>RuntimeException이 발생할 경우 handleErrorCommon 메서드가 호출되어 예외 정보를 포함한 ModelAndView 객체를 반환합니다.</p>
 *
 * @version 1.0
 */
@ControllerAdvice
public class CommonException {

    /**
     * RuntimeException을 처리하는 메서드입니다.
     *
     * @param e 발생한 예외 객체
     * @return 예외 정보를 포함한 ModelAndView 객체
     */
    @ExceptionHandler(RuntimeException.class)
    private ModelAndView handleErrorCommon(Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.setViewName("errorCommon");
        return mav;
    }
}