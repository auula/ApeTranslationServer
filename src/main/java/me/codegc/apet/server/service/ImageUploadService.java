package me.codegc.apet.server.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ding on 2019/4/4 12:10 PM.
 *
 * @Description: 文件上传service
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@Slf4j
@Component
public class ImageUploadService {
    /**
     * 功能：上传图片
     *
     * @param file               文件
     * @param uploadPath         服务器上上传文件的路径
     * @param physicalUploadPath 服务器上上传文件的物理路径
     * @return 上传文件的 URL相对地址
     */
    public String uploadImage(MultipartFile file, String uploadPath, String physicalUploadPath) {

        String filePath = physicalUploadPath + file.getOriginalFilename();

        try {
            File targetFile = new File(filePath);
            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage() + "文件上传出现异常~");
            e.printStackTrace();
        }
        return uploadPath + "/" + file.getOriginalFilename();
    }
}
