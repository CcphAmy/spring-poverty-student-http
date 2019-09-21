package com.example.poverty.app.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccphamy
 */
public class WebHttpUtil {

    private final static String CREATE_CARD_URL = "http://210.76.68.130:8080/fpy/antiPoverty/userInfo/getPopInfoByIdCardAndName";
    private final static String SOOCIAL_ASSISTANCE_URL = "http://jiuzhu.guangdong.minzheng.net/saas/urbansub/queryMemberForPublicityAction.do?act=queryMemberForPublicity";


    /**
     * 检查建档立卡的贫困信息
     *
     * @param name      姓名
     * @param idCardNum 身份证
     * @return String
     */
    public static String getCreateCardiPoverty(String name, String idCardNum) {
        Map<String, String> map = new HashMap<>(2);
        map.put("inputName", name);
        map.put("inputId", idCardNum);
        try {
            return OkHttpUtil.postFrom(CREATE_CARD_URL, map);
        } catch (IOException e) {
            return "请求异常, " + e.getMessage();
        }
    }

    /**
     * 检查社会救助的贫困信息
     *
     * @param name      姓名
     * @param idCardNum 身份证
     * @return String
     */
    public static String getSoocialAssistance(String name, String idCardNum) {
        LocalDateTime now = LocalDateTime.now();

        Map<String, String> map = new HashMap<>(8);
        map.put("start", "0");
        map.put("limit", "20");
        map.put("securityDate", String.format("%d%02d", now.getYear(), now.getMonthValue()));
        map.put("businessType", "");
        map.put("submitType", "ajax");
        // 440000000000 代表广东省
        map.put("aad011", "440000000000");
        map.put("aac002", name);
        map.put("aac004", idCardNum);
        try {
            return OkHttpUtil.postFrom(SOOCIAL_ASSISTANCE_URL, map);
        } catch (IOException e) {
            return "请求异常, " + e.getMessage();
        }
    }

}
