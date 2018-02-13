package com.findeng.conf;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * tomcat配置类
 * 解决post数据体大于2048kb无法接收问题
 * 解决tomcat连接最大数问题
 *
 * @author Alien
 */
@Configuration
public class TomcatConfig {
    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                //设置最大连接数
                protocol.setMaxConnections(2000);
                //设置最大线程数
                protocol.setMaxThreads(2000);
                //设置最大post长度(字节单位)
                connector.setMaxPostSize(100 * 1024 * 1024);
            }
        });
        return tomcatFactory;
    }
} 
