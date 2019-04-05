package me.codegc.apet.server.services;

import org.junit.Test;

public class JingSanOpenServiceTest {

    @Test
    public void jingSanOpenAPI() {
        JSOpenService js = new JSOpenService();
        System.out.println(js.JinShanOpenAPI());
    }
}