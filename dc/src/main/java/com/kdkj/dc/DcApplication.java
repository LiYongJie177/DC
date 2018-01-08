package com.kdkj.dc;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
//@MapperScan(basePackages = "com.kdkj.dc.mapper")
//@EnableCaching
public class DcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcApplication.class, args);
        System.out.println(errorCodeMap());
    }

    private static ImmutableMap<String, String> errorCodeMap = null;

    static {
        try {
            Properties prop = PropertiesLoaderUtils.loadAllProperties("error_code.properties");
            errorCodeMap = Maps.fromProperties(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**

     * {50010=与第三方通讯失败, 40011=上传失败, 40008=用户身份已过期, 40010=请选择上传文件,
     * 40007=频率超限, 40006=接口未授权, 40005=Http Method不匹配, 40003=接口被禁止调用,
     * 40002=接口不存在, 40001=不合法的appId, 50021=用户敏感数据解密失败,
     * 50020=获取微信session_key失败, 0=}
     *
     * @return
     */
    @Bean
    public static ImmutableMap<String, String> errorCodeMap() {
        return errorCodeMap;
    }

}
