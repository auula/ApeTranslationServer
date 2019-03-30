package me.codegc.apet.server.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class JingSanOpenServiceTest {

    @Test
    public void jingSanOpenAPI() {
        JingSanOpenService js = new JingSanOpenService();
        System.out.println(js.JingSanOpenAPI());
    }
}