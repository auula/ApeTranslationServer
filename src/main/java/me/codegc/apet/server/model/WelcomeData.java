package me.codegc.apet.server.model;

import lombok.Data;

/**
 * @author: Ding / 2019-03-22 20:47
 * @version: V1.0
 * @TODO: 启动页数据
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Data
public class WelcomeData {

    private String content;

    private String icon;

    private String mpegUrl;
}
