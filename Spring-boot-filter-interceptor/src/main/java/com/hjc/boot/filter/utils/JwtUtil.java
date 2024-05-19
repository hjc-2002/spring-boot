package com.hjc.boot.filter.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import com.hjc.boot.filter.constant.Constant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class JwtUtil {

    /**
     * 盐值很重要，不能泄漏，且每个项目都应该不一样，可以放到配置文件中
     */
    private static final String KEY = "spring-boot-learning-ztf";

    public static String createToken(Integer userId, String nickname) {
        DateTime now = DateTime.now();
        // 超时时间
        DateTime expTime = now.offsetNew(DateField.HOUR, 48);
        Map<String, Object> payload = new HashMap<>();
        // 签发时间
        payload.put(RegisteredPayload.ISSUED_AT, now);
        // 过期时间
        payload.put(RegisteredPayload.EXPIRES_AT, expTime);
        // 生效时间
        payload.put(RegisteredPayload.NOT_BEFORE, now);
        // 自定义载荷
        payload.put(Constant.USER_ID, userId);
        payload.put(Constant.NICKNAME, nickname);
        String token = JWTUtil.createToken(payload, KEY.getBytes());
        log.info("生成 JWT token：{}", token);
        return token;
    }

    public static boolean validate(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
        // validate包含了verify
        boolean validate = jwt.validate(0);
        log.info("JWT token校验结果：{}", validate);
        return validate;
    }

    public static JSONObject getPayload(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(RegisteredPayload.ISSUED_AT);
        payloads.remove(RegisteredPayload.EXPIRES_AT);
        payloads.remove(RegisteredPayload.NOT_BEFORE);
        log.info("payloads: {}", payloads);
        return payloads;
    }

    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StringUtils.isBlank(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        return accessToken;
    }

}