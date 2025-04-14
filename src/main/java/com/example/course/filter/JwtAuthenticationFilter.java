package com.example.course.filter;

import com.example.course.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("🛡 JwtAuthenticationFilter 执行了");

        String authHeader = request.getHeader("Authorization");
        System.out.println("获取到的 Authorization 头: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = JwtUtil.parseToken(token);
            System.out.println("解析得到的用户名: " + username);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                System.out.println("设置认证用户：" + username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                Collections.emptyList() // 暂不使用角色权限
                        );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } else {
            System.out.println("未携带有效的 Authorization 头");
        }

        filterChain.doFilter(request, response);
    }

}
