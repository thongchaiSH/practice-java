package com.memcache.app;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private MemcachedClient memcachedClient;

    @GetMapping("/test")
    public String test(){
        
        log.debug("======set/get Mode demonstration===============================");
        memcachedClient.set("FPCACHE",3,"THIS IS TEST This is the test.");
        log.debug("Setting and Reading FPCACHE value:"+memcachedClient.get("FPCACHE"));

        memcachedClient.set("FPCACHE",3,"Use SET Cache added to an existing value");
        log.debug("Read again FPCACHE value:"+memcachedClient.get("FPCACHE"));

        log.debug("======add Mode demonstration===============================");
        memcachedClient.add("FPCACHE",3,"Use ADD Cache added to an existing value");
        log.debug("Read again FPCACHE value:"+memcachedClient.get("FPCACHE"));

        memcachedClient.add("FPCACHE2",3,"Use ADD Add to new cache key FPCACHE2 in");
        log.debug("Read again FPCACHE2 value:"+memcachedClient.get("FPCACHE2"));

        log.debug("======replace Mode demonstration===============================");
        memcachedClient.replace("FPCACHE",3,"Use Replace replace FPCACHE Key corresponding cache value");
        log.debug("replace Mode reading FPCACHE value:"+memcachedClient.get("FPCACHE"));

        try {
            Thread.sleep(3001);
        }catch (Exception ex){
            log.error("Error {}",ex.getMessage(),ex);
        }
        log.debug("3 Get the cache again after seconds FPCACHE: "+memcachedClient.get("FPCACHE"));

        log.debug("======delete Mode demonstration===============================");
        memcachedClient.delete("FPCACHE");
        log.debug("replace Mode reading FPCACHE value:"+memcachedClient.get("FPCACHE"));
        return "";
    }

}
