package me.codegc.apet.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ding / 2019-03-22 20:19
 * @version: V1.0
 * @TODO: 返回结果实体
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Data
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -2100472103515439247L;

    public  static final int SUCCESS = 200;
    public  static final int ERROR = 500;

    private int StatusCode;

    private Map<String,Object> data = new HashMap<>();

    public JsonResult init(int statusCode){
        this.StatusCode = statusCode;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "StatusCode=" + StatusCode +
                ", data=" + data +
                '}';
    }

    public JsonResult builder(String key, Object data){
        this.data.put(key,data);
        return this;
    }
}
