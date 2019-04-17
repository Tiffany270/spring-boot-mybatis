package yiki.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig  extends WebMvcConfigurationSupport {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

//    //druid监控
//    //1.配置管理后台的servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean bean =
//                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        Map<String, String> initParams = new HashMap<>();
//        initParams.put("loginUsername", "admin");
//        initParams.put("loginPassword", "admin");
//        bean.setInitParameters(initParams);
//        return bean;
//    }
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        System.out.println("cors mapping");
        //允许全部请求跨域
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedOrigins("*");
    }
}
