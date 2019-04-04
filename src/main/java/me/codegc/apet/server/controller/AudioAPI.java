package me.codegc.apet.server.controller;

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

    private final String TTSURL = "https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web";

    @Autowired
    AudioService audioService;


    @ApiOperation(value = "文字转语音API接口",notes = "传入对应的文字即可转换成语音文件")
    @GetMapping("/audio")
    public void audio_tts(String lan, String text , HttpServletResponse response) throws IOException {
        Map<String,String> pram = new HashMap();
        //https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web
        pram.put("lan","en");
        pram.put("text","hello");
        pram.put("spd","5");
        pram.put("source","web");
        audioService.paly(pram);
    }
}
