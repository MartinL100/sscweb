package com.lovo.sscweb.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "MqTest", tags = "mq测试接口")

@RestController
public class MqTest {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @ApiOperation(value = "mq连接测试",notes = "测试mq连接是否通畅")
    @ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType ="String",paramType = "path")
    @RequestMapping(value = "MqTest/{userName}",method = RequestMethod.GET)
    public String mqTest(@PathVariable("userName") String userName){
        ActiveMQQueue queue = new ActiveMQQueue("MqTest");
        jmsMessagingTemplate.convertAndSend(queue,"Hello Mq");
        System.out.println(userName);
        return "hello page";
    }


}
