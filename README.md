# pagination-sort-springboot
demo of pagination and sort

## Requirements

* [JDK 11+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.6.0+](https://maven.apache.org/download.cgi)
* [MySql 8.0](https://www.mysql.com/downloads/)


## Running


1. From the command line with *Maven*:

   `mvn spring-boot:run` 

1. Access the deployed web application at:

   http://localhost:8080
   
 ## API's
 1.  Get List - http://localhost:8080/products
 2.  Sort - http://localhost:8080/products/quantity
 3.  Pagination - http://localhost:8080/products/pagination/0/3
 4.  Pagination and sort - http://localhost:8080/products/paginationAndSort/0/5/id

## Useful Links
1. Spring Initializer - https://start.spring.io/




