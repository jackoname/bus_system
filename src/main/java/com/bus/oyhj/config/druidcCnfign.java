package com.bus.oyhj.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class druidcCnfign {
 @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean bean= new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //后台账号密码
        HashMap<Object,Object> initParameters =new HashMap<>();
        initParameters.put("loginUsername","oyhj");
        initParameters.put("loginPassword","oyhj");

        //允许谁可以访问
        initParameters.put("allow","");

        bean.setInitParameters(initParameters);//初始化参数
        return bean;
    }
    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean bean= new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求
        Map<String,String>stringStringMap =new HashMap<>();
        stringStringMap.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(stringStringMap);
        return bean;
    }
}
