# Spring Boot with Spring Web Flow and Thymeleaf
Starter Spring Boot project with Spring Web Flow and Thymeleaf configured. I've been struggling with this one for quite some time until realized I've missed one line of code. 

Well, I don't want you guys to waste time like I've done, so here you go :)

## Thymeleaf configuration with Spring Webflow
What Thymeleaf says about integrating with Webflow is told [on this page](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#spring-webflow-integration).

## Minor Problem (needs consulting)
There is a small problem: the flow XMLs and views are separated and this is because the **classpath** they say works... well, it does not! If you guys resolve (this until I do) please don't be shy and send pull requests.
