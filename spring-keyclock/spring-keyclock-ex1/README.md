# Keycloak on Docker
```
docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:15.0.2
```

## Set up account
```
http://localhost:8080/auth/realms/personrealm/account/#/security/signingin

http://localhost:8080/auth/realms/personrealm/protocol/openid-connect/auth?client_id=person-client&response_type=code&scope=openid&redirect_uri=http://localhost:8080/test&state=asd

http://localhost:8080/test?state=asd&session_state=612c7794-a6d4-4e20-a6e0-2b300a0c1664&code=ce3abcb2-b382-4a99-9c30-2dcf69eab665.612c7794-a6d4-4e20-a6e0-2b300a0c1664.10fa7c30-17b9-47e8-8dfe-ef6fcac66162
```

## 1. Get Request for access code
```
http://localhost:8080/auth/realms/personrealm/protocol/openid-connect/auth?client_id=person-client&response_type=code&scope=openid&redirect_uri=http://localhost:8080/test&state=asd
```
## 2. Post Request to get barrier token
```
http://localhost:8080/auth/realms/personrealm/protocol/openid-connect/token

client_id=person-client
client_secret=93457ac3-8f53-488a-b92b-f81da9512e02
code=14fddfb7-bbd7-49d0-b996-aa3964febe45.612c7794-a6d4-4e20-a6e0-2b300a0c1664.10fa7c30-17b9-47e8-8dfe-ef6fcac66162
scope=openid
redirect_uri=http://localhost:8080/test
grant_type=authorization_code
```