# MySQL exercises
The program for today is to get MySQL installed on your ubuntu machine. Setting up users, and doing SQL from the MySQL commandprompt.

Some of the tasks are about getting the server up and running, others are a refresher on SQL.

## Task 1 - install server
Install MySQL om your ubuntu server.
This tutorial from digital ocean shows how to get MySQL up and running on your ubuntu instance.
<https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial>

When installing, **REMEMBER** the root password for the database - **write it down!!!**
(I normally pick passwords on the form longdanishword-number-symbol-longenglishword - e.g. hundehoved77&granting)

## Task 2 - starting and stopping the server
Check to see if the server is running. Linux has a command called _service_, which can be called as _service mysql_. There are arguments for stopping, status, starting, restarting and a few other options. Play around.

Start and stop the database server a few times, each time checking if it is running. 

## Task 3 - setting up the classicmodels database
Load the sql script which defines the classicmodels database(in the study folder as [classicmodels.sql](classicmodels.sql) ) we used in the first week. 
One way to do this is to let the mysql prompt read from a file instead of from 'standard in'. This can be done using the "<"-character in the linux command:
mysql -u root -p < file.sql

You will need to copy the file from your local machine to the ubuntu before you can run this (Hint: use scp)

## Task 4 - the sql prompt
From the mysql prompt, write sql expressions which solve the following three exercises from first week:

* How many German customers exist?
* What it the average price within each productline?
* Show the combination of name of employee name and customer country for customers handled by the employee.
* Change the contents of the appropriate table(s) such that all Spanish customers will be handled by employee 1702 (named Martin Gehard)

## Task 5 - database users
Just like there are _users_ of the linux machine, there are users of _MySQL database server_. These are two different sets of users.
You should now add two users beside root. One user named "reader" which should only be allowed to de select on the classic models database, and one user named "transformer" which should be allowed to modify the classicmodels database.

You need to read the note below on how to create users on MySQL to do this.

## Task 6 - making the database accessible from outside
Open the MySQL database to access from outside. See note below.

## Task 7 - Connect to the database from MySQLWorkbench. 
Connect as the user reader and verify that you can do selects on the classic models tables.
Try to update one of the tables - what happens?
Connect as the user transformer - can you as this user make changes to the classic models tables?

## Task 8 - accessing your database from Java code.
Write a simple Java program which prints out first and last name of all employees using system.out.println. The program should connect as the user 'reader' from the task above to make the database connection.


# Creating users on MySQL
The short tutorial <https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql> tells most things one need to get started.

However, besides restricting what the specific user is allowed to do on each table and database, one can also restrict from which machines one is allowed to do this. For example

* Stating that the root must log in from the same linux as is running the MySQL server (i.e. as localhost)
* Some users can only access data from the webserver
* Some users have different a desktop program which should allow them to do more than what can be done from the webinterface
* Different user groups can have different access rights to the data

In the tutorial, anywhere it says user@'localhost', one can either use an other host or IP address - **or one can omit 'localhost' or write '%'**. This mean that user can access the data from anywhere (**which will be necessary to access it from MySQL workbench on your laptop**).

# Opening the database to access from outside 
By default MySQL does not allow remote connections. To change this you will need to modify the  the **bind-address** line to allow access from any machine:

bind-address = 0.0.0.0

This is specified in the configuration file for MySQL mysqld.cnf - which is in the directory /etc/mysql/mysql.conf.d/

After this change MySQL should be restarted - see task above (command: 'service mysql restart')
