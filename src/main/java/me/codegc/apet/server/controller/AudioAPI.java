package me.codegc.apet.server.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.codegc.apet.server.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
@Controller
public class AudioAPI {


    @Autowired
    AudioService audioService;


    @ApiOperation(value = "文字转语音API接口",notes = "传入对应的文字即可转换成语音文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "languageCode", value = "被朗读的语言所在国的语言代码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "text",value = "被朗读的内容文本传入",required = true,dataType = "String",paramType = "query")
    })
    @GetMapping("/audio")
    public void audio_tts(String languageCode, String text , HttpServletResponse response) throws IOException {
        Map<String,String> pram = new HashMap();
        //https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web
        pram.put("lan",languageCode);
        pram.put("text",text.replaceAll(" ",""));
        pram.put("spd","3");
        pram.put("source","web");
        audioService.paly(pram,response);
    }
}
