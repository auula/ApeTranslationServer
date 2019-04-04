package me.codegc.apet.server.controller;

import me.codegc.apet.server.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ding on 2019/4/4 12:04 PM.
 *
 * @Description: OCR调用接口
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@RestController
public class OCRAPI {

    @Autowired
    OCRService ocrService;

    public String OCR() {
        return ocrService.OCR("");
    }
}
