https://springhow.com/spring-boot-hello-world-application/
https://dzone.com/articles/how-to-enable-the-https-into-spring-boot-applicati

#--self signed cert
cd D:\tools\Java\jdk1.8.0_111\bin
keytool -genkeypair -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ebininfosoft-ssl-key.p12 -validity 3650

Enter keystore password: changeit
Re-enter new password:
What is your first and last name?
  [Unknown]:  Kevin Sanders
What is the name of your organizational unit?
  [Unknown]:  sandkev
What is the name of your organization?
  [Unknown]:  sandkev
What is the name of your City or Locality?
  [Unknown]:  London
What is the name of your State or Province?
  [Unknown]:  London
What is the two-letter country code for this unit?
  [Unknown]:  uk
Is CN=Kevin Sanders, OU=sandkev, O=sandkev, L=London, ST=London, C=uk correct?
  [no]:  yes
  
#it would be nice to add support for vue.js frontend
https://blog.codecentric.de/en/2018/04/spring-boot-vuejs/
https://github.com/jonashackt/spring-boot-vuejs  
https://github.com/bezkoder/vue-upload-files/blob/master/src/components/UploadFiles.vue


# added simple crud example from https://dev.to/brunodrugowick/spring-boot-vue-js-axios-and-thymeleaf-with-bootstrap-in-4-commits-2b0l
# https://github.com/brunodrugowick/spring-thymeleaf-vue-crud-example 

TODO: secure the user/role admin functions
TODO: add unit tests

# test rest endpoints with curl
curl http://localhost:8085/api/v1/roles
curl -u foo:pass -X POST http://localhost:8085/api/v1/roles -d '{\"id\":4,\"name\":\"READ\"}' -H "Content-Type: application/json"
curl -u foo:pass -X DELETE http://localhost:8085/api/v1/roles?id=2

curl -u foo:pass -X DELETE http://localhost:8085/api/v1/roles?id=2 -H "Cookie:JSESSIONID=node012mr2zohn89qq1klqunqqjgbs21.node0"