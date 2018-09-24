![Alt text](../img/lotussm.png)
#Studypoint exercise 1: Deploy your web project
This exercise is meant to be individual, that is, each student should hand in their own solution.
Hand-in instructions at the end of this document.

The point of this exercise is to repeat the steps we took during the week and setup a digital ocean linux server with MySql and Tomcat. Then to deploy your own web project on to the server.

To that end, you need three things:

* A web site to be deployed 
* A database for that web site
* A webserver to deploy it on

###Task 1 - ensure you have a web application
While any web application can be used, it is suggested to use the one from the first semester assignment you did in january. If you did not manage to get it to work, use this simple web application instead: [Deployment demo project](../demo/webdeploydemo)  

To make the application run on your machine, you need to change the program in such a manner that it uses your own database. This can either be done by setting up the right tables on MySQL on your laptop, and then using localhost as your database, or you can move to task 2 below.

###Task 2 - deploy the database on the linux server
As part of your web site, you should have an SQL script which can be used to set up the tables and insert relevant data into those. Use that sql script to set up the right tables on your MySQL server on your linux machine. You can either do this by connecting to your MySQL server using MySQLWorkbench, or by logging onto your linux server and running the script from the command prompt. Using MySQLWorkbench might be easier, but you will learn more by doing it from the command prompt.

Change the web application to use the database on your linux server. Run the web application from netbeans to see that it works.

###Task 3
Add a database user named "reader" with the password "bookworm#17laesehest" which has select rights to the database you are using.

###Task 4
Change your program so that only when you read data from your tables to show on the website you are using your 'reader' user. In a real world app you could imagine some actions done by an administrator and others done by a normal user.


#Handin instructions
You need to hand in by writing an email to **aflevering2b@gmail.com** no later than Sunday 12th of february 2017 at 23:59.

The email should contain the following information

* The top of the email should have your name in full.
* There must be a link to your deployed web application
* The database user "reader" with the above mentioned password should be available in the database

If you are not able to finish your exercise you should send an email explaining in detail what caused you to fail to do so. **If you are not able to finish the exercise and you were not present on friday to get help, you will not be granted studypoints.**

