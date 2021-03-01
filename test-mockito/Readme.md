# Mockito Tutorial

## การเริ่มใช้ Mockito (@Mock กับ @InjectMocks) ใน Spring Boot
[การเริ่มใช้ Mockito (@Mock กับ @InjectMocks) ใน Spring Boot](https://dev.to/zkan/mockito-mock-injectmocks-spring-boot-5284)

## Behavior Driven Development
[BDD (Behavior Driven Development) คืออะไร ? + ต่างจาก TDD อย่างไร](https://medium.com/siamhtml/bdd-behavior-driven-development-%E0%B8%84%E0%B8%B7%E0%B8%AD%E0%B8%AD%E0%B8%B0%E0%B9%84%E0%B8%A3-%E0%B8%95%E0%B9%88%E0%B8%B2%E0%B8%87%E0%B8%88%E0%B8%B2%E0%B8%81-tdd-%E0%B8%AD%E0%B8%A2%E0%B9%88%E0%B8%B2%E0%B8%87%E0%B9%84%E0%B8%A3-f5ca90e09dfe)
### Add dependency
```
<dependency>    
   <groupId>org.mockito</groupId>    
   <artifactId>mockito-core</artifactId>    
   <version>2.21.0</version>
</dependency>
```
### Import
```
import static org.mockito.BDDMockito.*;
```
- given() = จะทำการ mock method ว่าจะ return อะไรออกมา  
- when() = จะเป็นการ perform method ที่เราต้องการ test  
- then() = จะเป็นการ Assert ว่าสิ่งที่เราต้องการนั้นได้ผลลัพธ์ทีต้องการไหม  



