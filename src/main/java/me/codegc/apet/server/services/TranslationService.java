package me.codegc.apet.server.services;

import com.alibaba.fastjson.JSONObject;
import me.codegc.apet.server.utils.HttpClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ding / 2019-03-23 13:08
 * @version: V1.0
 * @TODO: 翻译service
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Component
public class TranslationService {

    private final  String URL = "https://fanyi.baidu.com/transapi";

    private final HttpClient HTTPCLIENT = new HttpClient().init(URL);

    public Map trans(String query,String Country,String toCountry){
        Map<String,Object> param = new HashMap();
        param.put("from",Country);
        param.put("to",toCountry);
        param.put("query",query);
        return JSONObject.parseObject(HTTPCLIENT.get(param),Map.class);
    }



}
