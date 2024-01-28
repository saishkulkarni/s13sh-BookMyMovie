package com.s13sh.bookmymovie.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionMessageRemover {
    public void removeMessage() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        session.removeAttribute("successMessage");
        session.removeAttribute("failMessage");
    }
}
