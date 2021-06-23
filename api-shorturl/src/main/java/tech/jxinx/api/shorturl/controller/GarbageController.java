package tech.jxinx.api.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jxinx.api.shorturl.service.APIService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接口
 */
@RequestMapping("/api")
@RestController
public class GarbageController {

    @Autowired
    private APIService apiService;

    /**
     * 垃圾分类查询API
     */
    @RequestMapping("/garbage/{garbage}")
    public String shortURL(@PathVariable("garbage") String garbage) {
        System.out.println("垃圾分类查询API，请求时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "，请求参数garbage = " + garbage);
        if (ObjectUtils.isEmpty(garbage)) {
            return "你是什么垃圾？";
        }
        return apiService.garbage(garbage);
    }

}
