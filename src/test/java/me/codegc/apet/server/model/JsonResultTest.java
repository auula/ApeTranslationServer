package me.codegc.apet.server.model;

import org.junit.Test;




public class JsonResultTest {


    @Test
    public  void test(){
        System.out.println(new JsonResult().init(JsonResult.SUCCESS).builder("mess", "ok").toString());
    }
}