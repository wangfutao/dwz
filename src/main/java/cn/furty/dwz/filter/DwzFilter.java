package cn.furty.dwz.filter;

import cn.furty.dwz.mapper.DwzLogMapper;
import cn.furty.dwz.mapper.DwzMapper;
import cn.furty.dwz.pojo.Dwz;
import cn.furty.dwz.pojo.DwzLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Component
@ServletComponentScan
public class DwzFilter implements Filter {

    @Autowired
    DwzMapper dwzMapper;

    @Autowired
    DwzLogMapper dwzLogMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String url = request.getRequestURI().substring(1);

        Dwz dwz = dwzMapper.getDwz(url);

        if (dwz == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //添加访问记录
            DwzLog log = new DwzLog();
            log.setDwzId(dwz.getId());
            dwzLogMapper.addLog(log);

            //跳转
            HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
            wrapper.sendRedirect(dwz.getYwz());
        }

    }

    @Override
    public void destroy() {

    }
}
