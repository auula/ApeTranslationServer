package me.codegc.apet.server.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.codegc.apet.server.model.JsonResult;
import me.codegc.apet.server.services.JSOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Ding / 2019-03-22 20:13
 * @version: V1.0
 * @TODO: client 启动页的API数据调用控制器
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Slf4j
@RestController
public class WelcomeAPI {

    @Autowired
    JSOpenService js;

    @ApiOperation("客户端启动页的API数据调用接口")
    @GetMapping("/welcome/api")
    public JsonResult welcome_api() {


        return new JsonResult()
                .init(JsonResult.SUCCESS)
                .builder("message", "请求成功")
                .builder("welcome", js.JinShanOpenAPI());
    }


}
