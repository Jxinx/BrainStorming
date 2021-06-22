package tech.jxinx.api.shorturl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * URL工具类
 */
public class URLUtils {

    public static void main(String[] args) {
        String shortUrl = getShortUrl("https://www.jxinx.tech/html/286.html?from=bsapi");
        System.out.println("shortUrl = " + shortUrl);
    }

    /**
     * 获取短链接
     *
     * @param longUrl 长链接
     * @return 短链接
     */
    public static String getShortUrl(String longUrl) {
        /*
            接口文档：https://www.alapi.cn/api/view/38
        */

        //第三方api请求地址
        String apiUrl = "https://v2.alapi.cn/api/url";

        //短网址
        String shortUrl = "";

        //请求参数
        JSONObject param = new JSONObject();
        param.put("url", longUrl);
        param.put("token", "PcVOptknjR8n8nzB");

        System.out.println("生成短网址api请求参数：" + param);

        try {
            String respStr = doPost(apiUrl, param);

            System.out.println("生成短网址api响应数据：" + respStr);

            //处理响应数据
            JSONObject respJO = JSON.parseObject(respStr);
            int code = respJO.getIntValue("code");
            if (code == 200) {
                shortUrl = respJO.getJSONObject("data").getString("short_url");

                if (shortUrl != null && shortUrl != "") {
                    System.out.println("生成短网址成功：" + shortUrl);
                    return shortUrl;
                } else {
                    System.out.println("短网址为空");
                }
            } else {
                System.out.println("生成短网址失败");
            }
        } catch (Exception e) {
            System.out.println("生成短网址失败");
            e.printStackTrace();
        }
        return shortUrl;
    }

    /**
     * post发送json数据
     *
     * @param url   请求地址
     * @param param 请求参数
     * @return 响应数据
     */
    public static String doPost(String url, JSONObject param) {
        HttpPost httpPost = null;
        String result = null;
        try {
            HttpClient client = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            if (param != null) {
                StringEntity se = new StringEntity(param.toString(), "utf-8");
                httpPost.setEntity(se); // post方法中，加入json数据
                httpPost.setHeader("Content-Type", "application/json");
            }

            HttpResponse response = client.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("http post请求失败");
        }
        return result;
    }

}
