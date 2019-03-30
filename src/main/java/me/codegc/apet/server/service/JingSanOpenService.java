package me.codegc.apet.server.service;

import com.alibaba.fastjson.JSONObject;
import me.codegc.apet.server.model.WelcomeData;
import me.codegc.apet.server.utils.HttpClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Ding on 2019/3/30 12:32 PM.
 *
 * @Description: 金山开发API
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@Component
public class JingSanOpenService {

    private final String open_url = "http://open.iciba.com/dsapi/";


    private final HttpClient HTTPCLIENT = new HttpClient().init(open_url);

    public WelcomeData JingSanOpenAPI() {
        Map map = JSONObject.parseObject(HTTPCLIENT.get(), Map.class);
        WelcomeData welcomeData = new WelcomeData();
        welcomeData.setIcon("./icon.png");
        welcomeData.setContent(map.get("content").toString());
        welcomeData.setMpegUrl(map.get("tts").toString());
        return welcomeData;
    }


}
