package me.codegc.apet.server.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.codegc.apet.server.model.JsonResult;
import me.codegc.apet.server.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ding on 2019/4/4 4:08 PM.
 *
 * @Description: readme
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@Api(tags = "文字转语音mp3文件 API v1.8")
@Controller
@RequestMapping("/mp3")
public class AudioAPI {


    @Autowired
    AudioService audioService;


    @ApiOperation(value = "文字转语音API接口",notes = "传入对应的文字即可转换成语音文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "languageCode", value = "被朗读的语言所在国的语言代码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "text",value = "被朗读的内容文本传入",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/audio")
    public void audio_tts(
            @RequestParam(value="languageCode",required = true ,defaultValue = "") String languageCode,
            @RequestParam(value = "text",required = true,defaultValue = "") String text,
            HttpServletResponse response) throws IOException {

        if (languageCode.isEmpty() || text.isEmpty()) {
            response.setStatus(500);
            response.setHeader("Content-type", "text/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(JSONObject.toJSON(new JsonResult().init(JsonResult.ERROR).builder("message", "相关参数不能为空！")));
            return;
        }

        Map<String,String> pram = new HashMap();
        //https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web
        pram.put("lan",languageCode);
        pram.put("text",text.replaceAll(" ",""));
        pram.put("spd","5");
        pram.put("source","web");
        audioService.paly(pram,response);
    }
}
