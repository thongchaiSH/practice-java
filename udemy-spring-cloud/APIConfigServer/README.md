## Generate keytools
```aidl
keytool -genkeypair -alias apiEncryptionKey -keyalg RSA\
-dname "CN=Thongchai Sh,OU=API Development,O=app.com,L=BKK,S=ON,C=CA"\
-keypass 123456 -keystore apiEncryptionKey.jks -storepass 123456
```
## Test
```aidl
Post method
http://localhost:8012/encrypt
```