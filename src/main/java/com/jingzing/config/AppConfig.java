package com.jingzing.config;

import cn.dreampie.route.config.*;
import cn.dreampie.route.handler.cors.CORSHandler;

/**
 * Created by wangyunjing on 16/3/17.
 */
public class AppConfig extends Config {

    /**
     * Config constant
     * 配置常量，目前只能配置render，其他全局配置会自动读取根目录下的application.properties文件
     */
    public void configConstant(ConstantLoader constantLoader) {
        //通过后缀来返回不同的数据类型  你可以自定义自己的 render
        //如：public class FreemarkerRender extends Render{}
        //目前支持json，text，file三种输出
        //constantLoader.addRender("ftl", new FreemarkerRender());
    }

    /**
     * Config resource
     * 配置Resource的扫描目录
     */
    public void configResource(ResourceLoader resourceLoader) {
        //设置resource的目录 Resty启动时通过扫描配置的目录来添加Resouce
        //排除某个目录
        //resourceLoader.addExcludePackages("cn.dreampie.resource");
        //扫描某个目录
        resourceLoader.addIncludePackages("com.jingzing.resource");
    }

    /**
     * Config plugin
     * 配置插件 数据库相关配置信息和constant一样  都会自动读取application.properties文件
     */
    public void configPlugin(PluginLoader pluginLoader) {
        //第一个数据源 使用c3p0连接池，数据源名字 default
        //C3p0DataSourceProvider cdsp = new C3p0DataSourceProvider("default");
        //activerecord 初始化会从数据库获取表的元数据 并映射到class
        //ActiveRecordPlugin activeRecordCdsp = new ActiveRecordPlugin(cdsp, true);
        //排除的model目录
        //activeRecordCdsp.addExcludePackages("cn.dreampie.orm");
        //扫描的model目录
        //activeRecordCdsp.addIncludePackages("cn.dreampie.orm");
        //pluginLoader.add(activeRecordCdsp);

        //第二个数据源 使用druid连接池 数据源名字 demo
        //DruidDataSourceProvider ddsp = new DruidDataSourceProvider("demo");
        //ActiveRecordPlugin activeRecordDdsp = new ActiveRecordPlugin(ddsp, true);
        //pluginLoader.add(activeRecordDdsp);

        //jndi数据源 数据源名字jndiDs
        //JndiDataSourceProvider jdsp=new JndiDataSourceProvider("jndiDs","jndiName");
        //ActiveRecordPlugin activeRecordJdsp = new ActiveRecordPlugin(ddsp, true);
        //pluginLoader.add(activeRecordJdsp);
    }

    /**
     * Config interceptor applied to all actions.
     * 全局拦截，会在进入路由后，执行方法前执前
     */
    public void configInterceptor(InterceptorLoader interceptorLoader) {
        //权限拦截器
        //interceptorLoader.add(new SecurityInterceptor(2, new MyAuthenticateService()));
        //Resource层事务的拦截器 @Transaction
        //interceptorLoader.add(new TransactionInterceptor());
    }

    /**
     * Config handler
     * 全局的拦截，会在进入路由前执行
     */
    public void configHandler(HandlerLoader handlerLoader) {
        //跨域
        handlerLoader.add(new CORSHandler());
    }


    /**
     * Call back after Resty start
     */
    public void afterStart() {
        //Resty启动前执行的操作
    }

    /**
     * Call back before Resty stop
     */
    public void beforeStop() {
        //Resty停止前执行的操作
    }
}
