package org.geektimes.projects.user.web.filter;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.management.Counter;
import org.geektimes.projects.user.management.CounterManager;

import javax.management.*;
import javax.servlet.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.LogRecord;

public class ReqCounterFilter implements Filter {

    private final Counter counter = new Counter();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            // 获取平台 MBean Server
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            // 为 UserMXBean 定义 ObjectName
            ObjectName objectName = new ObjectName("org.geektimes.projects.req.counter:type=Counter");

            // 创建 UserMBean 实例
            mBeanServer.registerMBean(new CounterManager(counter), objectName);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        counter.inc();

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
