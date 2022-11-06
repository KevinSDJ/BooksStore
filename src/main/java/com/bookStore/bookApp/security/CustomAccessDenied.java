package com.bookStore.bookApp.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAccessDenied implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType("application/json");
                Map<String, Object> data = new HashMap<>();
                data.put("timestamp", new Date());
                data.put("status",HttpStatus.FORBIDDEN.value());
                data.put("message", "Access Denied, login again!");
                data.put("path", request.getRequestURL().toString());
        
                OutputStream out = response.getOutputStream();
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(out, data);
                out.flush();
        
    }
    
}
