**Practice Mircoservice Sptring cloud**



## Department Service
- POST http://localhost:9191/departments/
  ```json
  {
    "departmentName":"IT",
    "departmentAddress":"3rd cross,First",
    "departmentCode":"IT-006"
  }
  ```
- GET http://localhost:9191/departments/1

## User Service
- POST http://localhost:9191/users/
  ```json
  {
    "firstName":"thongchai",
    "lastName":"example",
    "email":"thongchai.s@gmail.com",
    "departmentId":"1"
  }
  ```
- GET http://localhost:9191/users/1

## Registry server
- http://localhost:8761/
```
API-GATEWAY	        - tasss-mbp:API-GATEWAY:9191
CONFIG-SERVER	    - tasss-mbp:CONFIG-SERVER:9296
DEPARTMENT-SERVICE	- tasss-mbp:DEPARTMENT-SERVICE:9001
HYSTRIX-DASHBOARD	- tasss-mbp:HYSTRIX-DASHBOARD:9295
USER-SERVICE	    - tasss-mbp:USER-SERVICE:9002
```

## Zipkins server
```
docker run -it -d -p 9411:9411 openzipkin/zipkin
```
- http://localhost:9411/zipkin/

## Hystrix dashboard
- http://localhost:9295/hystrix

### Sptring boot version (2.4.5,2.3.11)