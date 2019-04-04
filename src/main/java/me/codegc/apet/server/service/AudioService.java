package me.codegc.apet.server.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created by Ding on 2019/4/4 6:32 PM.
 *
 * @Description: 语音朗读API
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
@Component
public class AudioService {

    @Autowired
    HttpServletResponse response;


    private final String TTSURL = "https://fanyi.baidu.com/gettts";

    public void paly(Map<String,String> pram) throws IOException {
        //lan=en&text=spring!&spd=3&source=web
        StringBuilder sb = new StringBuilder();
        //开始遍历拼接URL
        sb.append(TTSURL).append("?");
        for (Map.Entry<String, String> stringStringEntry : pram.entrySet()) {
            sb.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue());
            sb.append("&");
        }
        //https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web
        System.out.println(sb);
        String file_name = System.currentTimeMillis()+ ".mp3";

        response.setContentType("audio/mpeg");
        //response.addHeader("Content-Disposition", "attachment;filename=" + file_name);

        FileUtils.copyURLToFile(new URL(TTSURL), new File(".", file_name));
        // 8.创建一个文件输入流
        InputStream is = new FileInputStream(new File(file_name));

        // 9.获得输出流
        ServletOutputStream os = response.getOutputStream();

        byte[] b = new byte[1024];  //创建数据缓冲区
        int length;

        while ((length = is.read(b)) > 0) {
            os.write(b, 0, length);
        }

        // 10.流对拷
        //IOUtils.copy(is, os);
        IOUtils.closeQuietly(is, os);
    }
}
