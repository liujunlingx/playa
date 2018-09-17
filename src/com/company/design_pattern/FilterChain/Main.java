package com.company.design_pattern.FilterChain;

public class Main {

    public static void main(String[] args) {
        String in = "abc";
        String out = "xyz";

        Filter f1 = (input, output, chain) -> {
            System.out.println("f1 pre handle");
            chain.doFilter(input,output,chain);
            System.out.println("f1 post handle");
        };

        Filter f2 = (input, output, chain) -> {
            System.out.println("f2 pre handle");
            chain.doFilter(input,output,chain);
            System.out.println("f2 post handle");
        };

        FilterChain chain = new FilterChain();
        chain.addFilter(f1).addFilter(f2);

        chain.doFilter(in,out,chain);

        chain.doFilter(in,out,chain);
    }
}
