package tech.jxinx.api.shorturl.controller;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jxinx.api.shorturl.util.URLUtils;

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
        // 短网址
        String shortURL = "";

        // 参数判空，且需屏蔽浏览器请求时，会同时请求网站图标信息
        if (!ObjectUtils.isEmpty(longURL) && !longURL.equalsIgnoreCase("favicon.ico")) {
            longURL = longURL.contains("http") ? longURL : "http://" + longURL;
            shortURL = URLUtils.getShortUrl(longURL);
        }
        return shortURL;
    }

}
