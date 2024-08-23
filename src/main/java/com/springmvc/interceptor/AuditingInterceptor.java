package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * AuditingInterceptor 클래스는 도서 등록과 같은 특정 요청이 발생할 때 
 * 해당 요청 정보를 로깅하기 위해 사용되는 인터셉터입니다.
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {

    // SLF4J 로거를 사용하여 로그 메시지를 기록합니다.
    public Logger logger = LoggerFactory.getLogger(this.getClass());  

    // 사용자 이름과 도서 ID를 저장하기 위한 변수들입니다.
    private String user;
    private String bookId;

    /**
     * preHandle 메서드는 컨트롤러 메서드가 호출되기 전에 실행됩니다.
     * 여기서는 특정 요청(도서 등록 POST 요청)을 가로채어 사용자와 도서 ID 정보를 저장합니다.
     *
     * @param request 클라이언트의 HTTP 요청 정보
     * @param arg1 HTTP 응답 정보 (사용되지 않음)
     * @param handler 실행될 핸들러 객체
     * @return true를 반환하여 요청 처리가 계속 진행되도록 합니다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse arg1,
                             Object handler) throws Exception {
        // 요청 URI가 "books/add"로 끝나고, HTTP 메서드가 POST일 때 조건을 만족합니다.
        if(request.getRequestURI().endsWith("books/add") && request.getMethod().equals("POST")) {
            // 요청한 사용자와 도서 ID를 변수에 저장합니다.
            user = request.getRemoteUser();
            bookId = request.getParameterValues("bookId")[0];
        }
        // 요청 URI가 "books/add"로 끝나고, HTTP 메서드가 GET일 때 조건을 만족합니다.
        if(request.getRequestURI().endsWith("books/add") && request.getMethod().equals("GET")) {
            // 요청한 사용자와 도서 ID를 변수에 저장합니다.
            user = request.getRemoteUser();
            bookId = "";
        }
        return true; // 요청 처리가 계속 진행됩니다.
    }

    /**
     * afterCompletion 메서드는 컨트롤러 메서드 실행이 끝난 후에 실행됩니다.
     * 여기서는 도서 등록이 완료된 후, 사용자와 도서 ID, 접근 시간을 로깅합니다.
     *
     * @param request 클라이언트의 HTTP 요청 정보
     * @param response HTTP 응답 정보
     * @param handler 실행된 핸들러 객체
     * @param arg3 예외 정보 (사용되지 않음)
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception arg3) throws Exception {
        // 요청 URI가 "books/add"로 끝날 때 로깅을 수행합니다.
        if(request.getRequestURI().endsWith("books/add")) {
            // 경고 수준으로 로그를 기록합니다. 로그에는 도서 ID, 사용자, 접근 시각이 포함됩니다.
            logger.warn(String.format("신규등록 도서 ID : %s, 접근자 : %s, 접근시각 : %s", bookId, user, getCurrentTime()));  
        }
    }

    /**
     * 현재 시간을 특정 형식(yyy/MM/dd HH:mm:ss)으로 반환하는 유틸리티 메서드입니다.
     *
     * @return 포맷된 현재 시간 문자열
     */
    private String getCurrentTime() {  
        DateFormat formatter = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }  
}
