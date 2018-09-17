package com.company.design_pattern.FilterChain;

import java.util.LinkedList;
import java.util.List;

public class FilterChain implements Filter{

    private List<Filter> filters = new LinkedList<>();
    private Integer index = 0;

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(String input, String output, FilterChain chain) {
        if(index == filters.size()){
            index = 0;
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(input,output,chain);
    }
}
