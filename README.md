# Java Example Projects

Some Java example projects for practice, demo, research.  

Current sub-projects:     
* SpringBootExample:　some simple Microservices application with SpringBoot framework.
* SpringCloudExample: some Spring cloud technology related examples.
* springboot-dubbo: dubbo examples with springboot framework.
* DesignPattern: design pattern implementations in Java.
* Bytecode: Java Bytecode operation examples          
  * asm: Java ASM Bytecode operation examples, 2 way to do: 1, instrument by classWriter, 2, instrument by "-javaagent".
  
       
## springboot-dubbo example
Have a completed sample with below components, this example depends on zookeeper for service registration: 
* example-api: used for exchange contract between dubbo provider & consumer.
* example-provider: dubbo example service provider.
* example-consumer: dubbo example service consumer.

### Dependency
* local zookeeper

### How to play?
* launch local zookeeper service at default port 2181.
* launch "example-provider" as spring-boot application.
* launch "example-consumer" as spring-boot application.
* call consumer api with parameters at http://localhost:8082/hello?greeting=hello, the expected output is "Default Service Provider: hello"

### What is not good?
* Consumer application will not work after provider application restart, consumer application still need to restart if provider application restarted. 