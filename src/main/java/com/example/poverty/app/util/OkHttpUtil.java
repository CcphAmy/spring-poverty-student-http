package com.example.poverty.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author ccphamy
 */
public class OkHttpUtil {
    private static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 最近fastjson爆出太多严重隐患bug，选用jackjson
     */
    private static final ObjectMapper JACKJSON = new ObjectMapper();

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final MediaType FORM = MediaType.get("application/x-www-form-urlencoded; charset=utf-8");

    private static final String UA = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";

    public static String get(String url) throws IOException, NullPointerException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", UA)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }


    public static String postJson(String url, Object obj) throws IOException, NullPointerException {
        RequestBody body = RequestBody.create(JACKJSON.writeValueAsString(obj), JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("User-Agent", UA)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static String postFrom(String url, Map<String,String> paramsMap) throws IOException, NullPointerException {
        FormBody.Builder formBody = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            //追加表单信息
            formBody.add(key, paramsMap.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .addHeader("User-Agent", UA)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }
}
