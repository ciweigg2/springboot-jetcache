package com.example.springbootjetcache.controller;

import com.example.springbootjetcache.model.User;
import com.example.springbootjetcache.service.JetCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 马秀成
 * @date 2019/4/10
 * @jdk.version 1.8
 * @desc
 */
@RestController
public class JetController {

    @Autowired
    private JetCacheService jetCacheService;

    @RequestMapping(value = "jet")
    public void jet() {
        System.out.println(jetCacheService.createCache(123L));
        System.out.println(jetCacheService.getUserById(123L));
        User user = new User();
        user.setUserId(123L);
        user.setUserName("哈哈哈");
        jetCacheService.updateUser(user);
        System.out.println(jetCacheService.getUserById(123L));
    }

    public static void main(String[] args) {
        String code2 = "GBE001\n" +
                "GBE002\n" +
                "GBE003\n" +
                "GBE004\n" +
                "GBE005\n" +
                "GBE006\n" +
                "GBE007\n" +
                "GBE008\n" +
                "GBE009\n" +
                "GBE010\n" +
                "GBE011\n" +
                "GBE012\n" +
                "GBE013\n" +
                "GBE014\n" +
                "GBE015\n" +
                "GBE016\n" +
                "GBE017";
        String[] code = code2.split("\n");
        String content2 = "业务体数据项长度错\n" +
                "业务体数据项为空\n" +
                "业务体数据项类型错\n" +
                "业务体数据项其他错\n" +
                "所有时间必须是有效时间： 1901-01-01T00:00:00—2099-12-31T23:59:59" +
                "所有日期必须是有效日期： 1901-01-01—2099-12-31" +
                "所有月份必须是有效月份： 1901-01—2099-12" +
                "所有年份必须为有效年份： 1901—2099\n" +
                "开始日期不能大于结束日期\n" +
                "结束日期不能大于当前日期\n" +
                "异议事项号不存在\n" +
                "异议事项流水号不存在\n" +
                "异议事项核查结果已反馈\n" +
                "异议事项核查结果未审核\n" +
                "异议事项核查结果审核未通过\n" +
                "数据提供机构与接口用户关系不匹配\n" +
                "核查机构与数据提供机构关系不匹配\n" +
                "发起机构与数据提供机构关系不匹配\n" +
                "数据发生机构与数据提供机构关系不匹配\n" +
                "报文发送机构代码与数据提供机构代码不一致";
        String[] content = content2.split("\n");
        String systemCodeTypeuuid = UUID.randomUUID().toString().replace("-", "");
        String systemCodeType = "SPECIAL_INFORMATION_CODE";
        String systemCodeTypeName = "专用处理信息代码";
        System.out.println("INSERT INTO \"SYSTEM_CODE_TYPE\" VALUES ('" + systemCodeTypeuuid + "', '" + systemCodeType + "', '" + systemCodeTypeName + "');");
        System.out.println("\n");
        for (int i = 0; i < content.length; i++) {
            String systemValueuuid = UUID.randomUUID().toString().replace("-", "");
            System.out.println("INSERT INTO \"SYSTEM_CODE_VALUE\" VALUES ('" + systemValueuuid + "', '" + systemCodeTypeuuid + "', '" + code[i] + "', '" + content[i] + "', '"+Integer.valueOf(i+1)+"', NULL);");
        }
    }

}
