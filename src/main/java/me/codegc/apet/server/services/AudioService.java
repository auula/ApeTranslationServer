package me.codegc.apet.server.services;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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


    private final String TTSURL = "https://fanyi.baidu.com/gettts";

    public void paly(Map<String, String> pram, HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();
        //开始遍历拼接URL
        sb.append(TTSURL).append("?");
        for (Map.Entry<String, String> stringStringEntry : pram.entrySet()) {
            sb.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue());
            sb.append("&");
        }
        //https://fanyi.baidu.com/gettts?lan=en&text=spring!&spd=3&source=web
        //System.out.println(sb);
        String file_name = System.currentTimeMillis() + ".mp3";

        response.setContentType("audio/mpeg");
        //response.addHeader("Content-Disposition", "attachment;filename=" + file_name);
        //通过Apache commons-io这个包导 读取网络文件
        FileUtils.copyURLToFile(new URL(sb.toString()), new File(file_name));

        FileInputStream fileInputStream = new FileInputStream(new File(file_name));
        ServletOutputStream outputStream = response.getOutputStream();
        // 10.流对拷
        IOUtils.copy(fileInputStream, outputStream);
        //删除文件
        FileUtils.forceDelete(new File(file_name));
        IOUtils.closeQuietly(fileInputStream, outputStream);
    }
}
