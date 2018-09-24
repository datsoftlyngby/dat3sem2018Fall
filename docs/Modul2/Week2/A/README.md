# REST (RESTful Webservices) with JAX-RS

[REST Plan](REST_LearningObjectives&Plan.pdf)  
[REST Slides](REST_Slides.pdf)  
[REST Notes](REST_Notes.pdf)  
[REST Project](rest)  

## Learning Objectives
After this week, you should:
  * Understand the principles of RESTful APIs
  * Be able to implement a REST API using Java's JAX-RX API
  * Be able to implement a JSON API in java, using google's GSON library
  * Be able to handle both success and error responses in a REST API

## Business competences
REST has become the current standard for designing web APIs, and is used for
virtually everything on the internet

These lessons will provide the student with the necessary background to build
RESTful APIs in java

## Exercises 
  * [Exercise Day1](https://docs.google.com/document/d/1IKTh5aFDzg9d3A2Kt6rRZsLAW-9PfvoXyLmyjCp0I4E/edit?usp=sharing) Basic Rest
  * [Exercise Day2](https://docs.google.com/document/d/1KkBqVkIZnG5cwAs7TtxNPA0syOXoTqC-wRk2TEyLbzg/edit#heading=h.wtven3wlkhz2) REST API with DTOs
  * [Exercise Day3](https://docs.google.com/document/d/1VD-_3QHWrP-asOArc786JGAtlVkjhu6Iaj8UHfWByyg/edit) Error handling
  * [StudyPoint Exercise](https://docs.google.com/document/d/1aqJx93Y9fROeYq6xbneWoBstVeDXIn00vimT0AWqaPk/edit?usp=sharing)
  
## Plan

### Day1 - REST Introduction + Initial JAX setup and endpoints

Restful Web Services Tutorial:
  * [RESTful Web Services](http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069?pgno=1)

Oracle Java Web Services (Chapter 27 - 29):
  * [Web Services Tutorial](https://docs.oracle.com/javaee/7/tutorial/partwebsvcs.htm#BNAYK)

Jersey 2.27 UserGuide (Section 3):
  * [Jersey User Guide - JAX-RS](https://jersey.github.io/documentation/latest/index.html)

### Day2 - JSON + GSON + Data-Transfer Objects (DTOs)

JSON (Data types & Arrays & Objects)
  * [W3Schools - JSON](https://www.w3schools.com/js/js_json_intro.asp)

GSON (Tutorial1 || Tutorial2)
  * [Google GSON](https://github.com/google/gson)
  * [Tutorial1 - StudyTrails](http://www.studytrails.com/java/json/java-google-json-introduction/)  
  * [Tutorial2 - FutureStudio](https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization)  

DTOs
  * [Wikipedia - DTOs](https://en.wikipedia.org/wiki/Data_transfer_object)

### Day3 - REST Errorhandling

Jersey 2.27 UserGuide (Section 7)
  * [Jersey User Guide - Representations and responses](https://jersey.github.io/documentation/latest/index.html)

Oracle Docs Response
  * [Class Response](http://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Response.html)  
    Skim method summary

Jersey Testing
  * [Jersey Unit Testing](https://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/jax-rs-unit-testing.html)