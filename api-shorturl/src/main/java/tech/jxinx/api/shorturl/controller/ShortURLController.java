package tech.jxinx.api.shorturl.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jxinx.api.shorturl.util.URLUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接口
 */
@RequestMapping("/api")
@RestController
public class ShortURLController {

    /**
     * 生成短网址API
     * @param longURL
     * @return
     */
    @RequestMapping({"/shorturl/{longurl}", "/{longurl}"})
    public String shortURL(@PathVariable("longurl") String longURL) {
        System.out.println("生成短网址API，请求时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "，请求参数longURL = " + longURL);

        // 短网址
        String shortURL = "";

        if (ObjectUtils.isEmpty(longURL)) {
            return shortURL;
        }

        // 参数判空，且需屏蔽浏览器请求时，会同时请求网站图标信息
        if (!longURL.equalsIgnoreCase("favicon.ico")) {
            longURL = longURL.contains("http") ? longURL : "http://" + longURL;
            shortURL = URLUtils.getShortUrl(longURL);
        }
        return shortURL;
    }

}
