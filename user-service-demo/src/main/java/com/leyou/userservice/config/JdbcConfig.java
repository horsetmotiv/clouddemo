package com.leyou.userservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description
 * @auther chenwei
 * @create 2019-06-22 9:43
 */

@Configuration
public class JdbcConfig {

    /**
     * 通过Value注解注入数据库配置属性
     * 不需要额外的配置文件或配置类
     */
//    @Value("${spring.datasource.url}")
//    String url;
//    @Value("${spring.datasource.driver-class-name}")
//    String driverClassNamle;
//    @Value("${spring.datasource.username}")
//    String username;
//    @Value("${spring.datasource.password}")
//    String password;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(url);
//        druidDataSource.setDriverClassName(driverClassName);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//        return druidDataSource;
//    }

    /**
     * 通过@Bean的方法参数注入
     * 需要额外的JdbcProperties配置类文件，并在注解为：
     * @Component
     * @ConfigurationProperties(prefix = "spring.datasource")
     */
//    @Bean
//    public DataSource dataSource(JdbcProperties jdbc){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(jdbc.getUrl());
//        druidDataSource.setDriverClassName(jdbc.getDriverClassName());
//        druidDataSource.setUsername(jdbc.getUsername());
//        druidDataSource.setPassword(jdbc.getPassword());
//        return druidDataSource;
//    }
//

    /**
     * 通过@Autowired注入
     * 需要额外的JdbcProperties配置类文件，并在注解为：
     * @Component
     * @ConfigurationProperties(prefix = "spring.datasource")
     */
//    @Autowired
//    private JdbcProperties prop;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(prop.getUrl());
//        druidDataSource.setDriverClassName(prop.getDriverClassName());
//        druidDataSource.setUsername(prop.getUsername());
//        druidDataSource.setPassword(prop.getPassword());
//        return druidDataSource;
//    }

    /**
     * 通过构造函数注入
     * 需要额外的JdbcProperties配置类文件，并在注解为：
     * @Component
     * @ConfigurationProperties(prefix = "spring.datasource")
     */
//    private JdbcProperties prop;
//
//    public JdbcConfig(JdbcProperties prop) {
//        this.prop = prop;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(prop.getUrl());
//        druidDataSource.setDriverClassName(prop.getDriverClassName());
//        druidDataSource.setUsername(prop.getUsername());
//        druidDataSource.setPassword(prop.getPassword());
//        return druidDataSource;
//    }

    /**
     * 更优雅的注入方式
     * 声明要注入的属性前缀，SpringBoot会自动把相关属性通过set方法注入到DataSource中
     * 这里需要注意的是不能同时存在带注解的配置类文件JdbcProperties.java
     * @return
     */
    @Bean
//    @ConfigurationProperties(prefix = "spring")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
