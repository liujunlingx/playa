package com.company.design_pattern.FilterChain;

public interface Filter {

    void doFilter(String input,String output,FilterChain chain);
}
