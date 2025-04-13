package com.example.loginapp._core.error;

import com.example.loginapp._core.error.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.loginapp._core.util.Resp;
import com.example.loginapp._core.util.Script;

@RestControllerAdvice // @ControllerAdvice
public class GlobalExceptionHandler {

    // 인증 안됨
    @ExceptionHandler(Exception400.class)
    public String ex400(Exception400 e) {
        return Script.back(e.getMessage());
    }

    // 인증 안됨
    @ExceptionHandler(Exception401.class)
    public String ex401(Exception401 e) {
        return Script.href(e.getMessage(), "/login-form");
    }

    // 자원을 찾을 수 없음
    @ExceptionHandler(Exception404.class)
    public String ex404(Exception404 e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public String exUnKnown(Exception e) {
        String html = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>
                """.replace("${msg}", "관리자에서 문의해주세요");
        System.out.println("관리자님 보세요 : " + e.getMessage()); // 로그를 파일에 기록해서 나중에 봐야함
        return html;
    }
}
