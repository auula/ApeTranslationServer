package me.codegc.apet.server.service;

import com.alibaba.fastjson.JSONObject;
import me.codegc.apet.server.utils.HttpClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TranslationServiceTest {

    @Test
    public void toEN() {
        Map<String,Object> param = new HashMap();
        param.put("from","zh");
        param.put("to","en");
        param.put("query","您好");
        String s = new HttpClient().init("https://fanyi.baidu.com/transapi").get(param);
        Map map = JSONObject.parseObject(s, Map.class);
        String s1 = JSONObject.toJSONString(s);

        System.out.println(s1);
    }
}