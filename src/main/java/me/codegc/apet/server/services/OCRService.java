package me.codegc.apet.server.services;

import org.springframework.stereotype.Component;

/**
 * Created by Ding on 2019/4/4 11:42 AM.
 *
 * @Description: OCR服务类
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@Component
public class OCRService {

    private final String CONFIG = "/Users/jdode/Desktop/tesseract.properties";

    //实例一个JTesseract对象传入相关参数
//    private final JTesseract init = new JTesseract().init(new Tesseract().build(CONFIG));

    public String OCR(String file) {
        //传入被识别文字的图片
//        init.setFile(new File(file));
//        return init.OCR();
        return  "OCR服务器目前没有开放使用！！有问题联系Q2420498526";
    }
}
