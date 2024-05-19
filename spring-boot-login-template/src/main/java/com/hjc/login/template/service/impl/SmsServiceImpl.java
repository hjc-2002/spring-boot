package com.ztf.login.template.service.impl;


import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.ztf.login.template.config.CloopenConfig;
import com.ztf.login.template.config.RedisCache;
import com.ztf.login.template.config.RedisKeys;
import com.ztf.login.template.exception.ErrorCode;
import com.ztf.login.template.exception.ServerException;
import com.ztf.login.template.service.SmsService;
import com.ztf.login.template.utils.CommonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private CloopenConfig cloopenConfig;

    @Resource
    private RedisCache redisCache;

    @Override
    public void sendSms(String phone) {
        // 校验手机号合法性
        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }

        // 调用工具类生成随机验证码
        int code = CommonUtils.generateCode();
        // 把 code 存入redis
        redisCache.set(RedisKeys.getSmsKey(phone), code, 60);
        // 把 code 发送 phone 这个手机
        boolean result = cloopenSendSms(phone, code);
        if (result) {
            log.info("=================短信发送成功，===============");
        }

    }


    /**
     * 封装的内部私有方法，调用SDK发短信
     *
     * @param phone 手机号
     * @param code  验证码
     * @return boolean
     */
    private boolean cloopenSendSms(String phone, int code) {
        try {
            log.info(" ============= 创建短信发送通道中 ============= \nphone is {},code is {}", phone, code);
            String serverIp = cloopenConfig.getServerIp();
            // 请求端口
            String serverPort = cloopenConfig.getPort();
            // 主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
            String accountSId = cloopenConfig.getAccountSId();
            String accountToken = cloopenConfig.getAccountToken();
            // 请使用管理控制台中已创建应用的APPID
            String appId = cloopenConfig.getAppId();
            CCPRestSmsSDK sdk = new CCPRestSmsSDK();
            sdk.init(serverIp, serverPort);
            sdk.setAccount(accountSId, accountToken);
            sdk.setAppId(appId);
            sdk.setBodyType(BodyType.Type_JSON);
            String templateId = cloopenConfig.getTemplateId();
            String[] datas = {String.valueOf(code), "1"};
            HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas, "1234", UUID.randomUUID().toString());
            if ("000000".equals(result.get("statusCode"))) {
                // 正常返回输出data包体信息（map）
                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for (String key : keySet) {
                    Object object = data.get(key);
                    log.info("{} = {}", key, object);
                }
            } else {
                // 异常返回输出错误码和错误信息
                log.error("错误码={} 错误信息= {}", result.get("statusCode"), result.get("statusMsg"));
                throw new ServerException(String.valueOf(ErrorCode.CODE_SEND_FAIL));
            }
        } catch (Exception e) {
            throw new ServerException(String.valueOf(ErrorCode.CODE_SEND_FAIL));
        }
        return true;
    }
}
