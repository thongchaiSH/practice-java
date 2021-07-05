package com.memcache.app;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class ExampleController {

    @Autowired
    MemcachedClient memcachedClient;

    @PostMapping("/generatePolicyNumber")
    public String generatePolicyNumber(@RequestBody GeneratePolicyNumberRequestBo request ){
        String key="GEN-POLICY-"+request.getApplicationRefNum();
        if(memcachedClient.get(key)==null){
            //5 seconds
            memcachedClient.set(key,5,request.getApplicationRefNum());
            //no contain
            String result=UUID.randomUUID().toString();
            log.debug("Result : {}",result);
            return result;
        }else{
            //duplicate
            log.debug("FOUND {}", memcachedClient.get(key));
            return "FAIL";
        }
    }

}
