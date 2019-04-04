package me.codegc.apet.server.service;

import com.github.JDode.JTesseract.JTesseract;
import com.github.JDode.JTesseract.model.Tesseract;
import org.springframework.stereotype.Component;

import java.io.File;

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
    private final JTesseract init = new JTesseract().init(new Tesseract().build(CONFIG));

    public String OCR(String file) {
        //传入被识别文字的图片
        init.setFile(new File(file));
        return init.OCR();
    }
}
