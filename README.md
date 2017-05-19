# CloudFoundry Example based on Spring

There are many ways how to build services with java on cloud foundry. This option is using spring and the spring boot starter lib to create a very lightweight service module. It only needs a ServiceStart class that runs the BootStarter and the service class that then provides the service.    

## Prepare and Deploy

Go into the manifest and replace the org name d043918trial with your org name
Then build the java war package with Maven
```
mvn clean install
```
Then push to Cloud Foundry
```
cf push
```




