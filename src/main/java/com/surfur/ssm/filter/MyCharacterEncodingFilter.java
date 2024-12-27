package com.surfur.ssm.filter;

import jakarta.servlet.annotation.WebFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@WebFilter("/*")
public class MyCharacterEncodingFilter extends CharacterEncodingFilter {

    public MyCharacterEncodingFilter() {
        super("UTF-8", true, true);
    }
}
