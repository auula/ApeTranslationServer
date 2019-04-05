package me.codegc.apet.server.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.codegc.apet.server.model.JsonResult;
import me.codegc.apet.server.services.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ding on 2019/4/4 12:04 PM.
 *
 * @Description: OCR调用接口
 * <p>Ø
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@RestController
public class OCRAPI {

    //文件存储路径
    private final String FILEPATH = "/Users/jdode/Pictures";

    @Autowired
    OCRService ocrService;



    @ApiOperation(value = "OCR识别API接口",notes = "OCR目前仅支持中文或者英文内容图片识别")
    @PostMapping(value = "/ocr/api",headers = "content-type=multipart/form-data")
    public JsonResult OCR(@ApiParam(value="被识别图片文件",required=true)
                                      MultipartFile file) {
        if (file.isEmpty() || file == null) {
            return new JsonResult().init(JsonResult.ERROR).builder("message", "上传失败，请选择文件~");
        }

        String fileName = file.getOriginalFilename();
        File dest = new File(FILEPATH + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            return new JsonResult().init(JsonResult.ERROR).builder("error", "文件处理异常");
        }
        return new JsonResult().init(JsonResult.SUCCESS).builder("message", "文件处理成功~")
                .builder("OCR", ocrService.OCR(dest.getPath()));
    }
}
