package me.codegc.apet.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.codegc.apet.server.model.JsonResult;
import me.codegc.apet.server.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: Ding / 2019-03-23 12:34
 * @version: V1.0
 * @TODO: 提供client使用的API
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Api(tags = "翻译API v1.2")
@RestController
@RequestMapping("/transapi")
public class TranslationAPI {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;


    //http://localhost:8080/transapi/from?Country=zh&toCountry=kor&Query=您好
    @Autowired
    private TranslationService t;

    @GetMapping("/test")
    public JsonResult test() {
        return new JsonResult().init(JsonResult.SUCCESS).builder("ok", System.currentTimeMillis());
    }


    @ApiOperation(value = "提供客户端使用的翻译API接口",notes = "支持全球各类语言互相翻译,传入对应国家代码即可完成对应的翻译操作")
    @GetMapping("/from")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Country", value = "被翻译的语言所在国的语言代码", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "toCountry", value = "需要翻译成那个语言所在国的语言代码", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "Query",value = "被翻译的内容以文本形式传入",required = true,dataType = "String",paramType = "query")
    }
    )
    public JsonResult transapi(@RequestParam String Country, @RequestParam String toCountry, @RequestParam String Query) {
        if (Query != null && Country != null && toCountry != null) {
            return new JsonResult().init(JsonResult.SUCCESS).builder("t", t.trans(Query, Country, toCountry));
        }
        return new JsonResult().init(JsonResult.ERROR).builder("message", "相关参数不能为空!");
    }




}
