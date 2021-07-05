## Setup Memcache 
```
docker run --name memcached -it --rm -p 11211:11211 docker.io/bitnami/memcached:1
```

## Add dependency 
```xml
<dependency>
    <groupId>net.spy</groupId>
    <artifactId>spymemcached</artifactId>
    <version>2.12.3</version>
    <scope>provided</scope>
</dependency>
```
## Config MemcachedClient
```java
@Slf4j
@EnableCaching
@Configuration
public class MemcacheConfig extends CachingConfigurerSupport {

    @Value("${memcached.port}")
    private Integer port;
    @Value("${memcached.ip}")
    private String ip;

    @Bean
    public MemcachedClient memcachedClient(){
        try{
            return new MemcachedClient(new InetSocketAddress(ip,port));
        }catch (IOException e){
            log.error(e.getMessage(),e);
            return null;
        }
    }
}
```


## Method
|Method  | Effect|
|---|---|
| set(key,value)| Add a value to the key and replace it if stored|
|add(key,value) | Add a value to the key without replacing it if it exists|
|replace(key,value)|Replace the value of the cache key with value|
|delete(key)|Delete the value of the cache key|

## Reference
- [Memcached](https://memcached.org/)  
- [Simple Spring XMemcached](https://devcenter.heroku.com/articles/memcachier#spring-boot)
- [bitnami-docker-memcached](https://github.com/bitnami/bitnami-docker-memcached)
- [Introduction to Spring Boot Cached Application Memcached](https://programmer.group/introduction-to-spring-boot-cached-application-memcached.html)
