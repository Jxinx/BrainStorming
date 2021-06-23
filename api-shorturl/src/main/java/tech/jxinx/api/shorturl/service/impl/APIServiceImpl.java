package tech.jxinx.api.shorturl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.jxinx.api.shorturl.service.APIService;
import tech.jxinx.api.shorturl.util.URLUtils;

@Service
public class APIServiceImpl implements APIService {

    @Value("${alapi.token}")
    private String alapiToken;

    @Override
    public String garbage(String garbage) {
        /*
            接口文档：https://www.alapi.cn/api/view/20
        */

        //第三方api请求地址
        String apiUrl = "https://v2.alapi.cn/api/garbage";

        // 垃圾分类分析结果
        String garbageAnalyse = "";

        // 请求参数
        JSONObject param = new JSONObject();
        param.put("token", alapiToken);
        param.put("name", garbage);
        param.put("page", 1);

        System.out.println("垃圾分类查询api请求参数：" + param);

        try {
            String respStr = URLUtils.doPost(apiUrl, param);

            System.out.println("垃圾分类查询api响应数据：" + respStr);

            // 处理响应数据
            JSONObject respJO = JSON.parseObject(respStr);
            int code = respJO.getIntValue("code");
            if (code == 200) {
                JSONArray data = respJO.getJSONArray("data");

                JSONObject analyseItem = data.getJSONObject(0);
                // 垃圾类型，垃圾分类，1为可回收、2 为有害、3为厨余(湿)、4 为其他(干)
                String type = analyseItem.getString("type");

                // 垃圾类型处理
                switch (type) {
                    case "1":
                        analyseItem.put("type", "可回收垃圾");
                        break;
                    case "2":
                        analyseItem.put("type", "有害垃圾");
                        break;
                    case "3":
                        analyseItem.put("type", "厨余(湿)垃圾");
                        break;
                    case "4":
                        analyseItem.put("type", "其他(干)垃圾");
                        break;
                    default:
                        analyseItem.put("type", "未知垃圾");
                        break;
                }

                garbageAnalyse =  analyseItem.toJSONString();
            } else {
                System.out.println("垃圾分类查询失败");
            }
        } catch (Exception e) {
            System.out.println("垃圾分类查询失败");
            e.printStackTrace();
        }
        return garbageAnalyse;
    }
}
