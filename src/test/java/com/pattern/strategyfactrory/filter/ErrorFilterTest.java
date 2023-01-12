package com.pattern.strategyfactrory.filter;

import com.pattern.strategyfactrory.filter.impl.DefaultErrorFilter;
import com.pattern.strategyfactrory.service.ErrorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ErrorFilterTest {

    @Autowired
    ErrorService errorService;

    @Autowired
    ApplicationContext context;

    @Test
    public void testFilterList() {
        //filter
        List<ErrorFilter> filterList = new ArrayList<>();
        Map<String, ErrorFilter> filterMap = context.getBeansOfType(ErrorFilter.class);
        for (Map.Entry<String, ErrorFilter> entry : filterMap.entrySet()) {
            filterList.add(entry.getValue());
        }
        AnnotationAwareOrderComparator.sort(filterList);

        for (ErrorFilter filter : filterList) {
            Boolean ret = filter.doFilter();
            System.out.println(ret);
        }
    }

    @Test
    public void testFilter() {
        //filter
        ErrorFilter filter = new DefaultErrorFilter();
        Boolean ret = filter.doFilter();
        System.out.println(ret);
    }



}
