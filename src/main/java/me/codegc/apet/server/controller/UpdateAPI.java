package me.codegc.apet.server.controller;

import io.swagger.annotations.ApiOperation;
import me.codegc.apet.server.model.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ding on 2019/3/31 8:26 PM.
 *
 * @Description: client检查更新
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@RestController
public class UpdateAPI {
    @ApiOperation("client通过这个接口检查服务器版本")
    @GetMapping("/checkUpdate")
    public JsonResult checkUpdate(){
        return new JsonResult().init(JsonResult.SUCCESS).builder("version","1.1.1");
    }
}
