package com.findeng.conf;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 配置错误页面
 *
 * @author Alien
 */
@SuppressWarnings("deprecation")
@Configuration
public class ErrorPageConfig implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(
                new ErrorPage(HttpStatus.BAD_REQUEST, "/ErrorPage/400.html"),
                new ErrorPage(HttpStatus.UNAUTHORIZED, "/ErrorPage/401.html"),
                new ErrorPage(HttpStatus.NOT_FOUND, "/ErrorPage/404.html/"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/ErrorPage/500.html"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/ErrorPage/550.html")
        );
    }
}
