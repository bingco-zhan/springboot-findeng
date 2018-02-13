package com.findeng.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 * 发送https请求的通用工具类
 *
 * @author Alien
 * @version 1.0
 */
public class HttpRequest {
    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方法类型
     * @param outputStr     传输内容(没有时为null)
     * @return String 返回字符串
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = {new MyX509TrustManager()};
        StringBuffer buffer = null;
        // 安全套接字的上下文
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL", "SunJSSE");

            sslContext.init(null, tm, new java.security.SecureRandom());

            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            // 建立连接
            URL url = new URL(requestUrl);

            // 打开连接
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            // 设置请求方式
            conn.setRequestMethod(requestMethod);
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流中获取返回的内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferReader = new BufferedReader(reader);
            String str = null;
            buffer = new StringBuffer();

            while ((str = bufferReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferReader.close();
            reader.close();
            inputStream.close();
            inputStream = null;

            conn.disconnect();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (buffer != null)
            return buffer.toString();
        else
            return "";
    }

    /**
     * url编码
     */
    public static String urlEncodeUTF8(String source) {
        String str = null;
        try {
            str = URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
