# Database Exercise 4



### part 1 (G)

 

1. Underline all primary keys and use **bold** to indicate foreign keys, for these tables:


```
employees (eno, ename, zip, hdate) 

parts (pno, pname, qoh, price, olevel) 

customers (cno, cname, street, zip, phone) 

orders (ono, cno, eno, received, shipped) 

odetails (ono, pno, qty) 

zipcodes (zip, city) 
```



Forklaring af attributterne i tabellerne

| Attribute                   | Forklaring                               |
| --------------------------- | ---------------------------------------- |
| *hdate* in employees table: | hire date                                |
| *qoh* in parts table:       | quantity on hand (dk: antal på lager)    |
| *olevel* in table parts:    | orderlevel (e.g. min. amount in stock before reordering) |

​              

2. Write an SQL-script with all necessary statements to create tables in exercise 1.a

·  Define appropriate data types

·  Define primary keys and foreign keys

·  Assign necessary integrity constraints (not null,default)

·  Run the script to create the database 

 

3. Run the script: [insert_mail.sql](insert_mail.sql), which populates the database.

Hint: If the script fails, there might be a mismatch in the data types or constraints between the database that you just created and the insert statements in the SQL script. Adjust the script or the database tables.

 

### part 2 (G)

 

The following SQL statements will generate errors. Identify the cause and fix the error. Write down what you did and why.

 

a) insert into employees values (1002, 'Olsen', 67226, '2006-09-13');

b) insert into odetails values (1020, 10900);

c) insert into employees values (1004, 'Jensen', 66666, '2006-09-15');

d) insert into parts values (11000, Harry Potter, 12, 23.25, 12);

e) insert into parts values (11001, 'Marx Brothers', 10, -22.99, 20);

f) update zipcodes set values (city='Los Angeles') where zip=67226;

### part 3 (Y)

1. Insert 1 additional row in each table in a way that these entities will be related.
2. Run the 6 statements in a sequence, so that the integrity of the database is maintained at all time.



### part 4

**Write queries to retrieve the results requested below from the database:**

1. (G) The names of all customers
2. (G) The names of products of which there are at least 150 pieces in stock
3. (G) Names and zip codes of all customers with a phone number which ends with ’55’.

4. (G) Names of products which cost less than 18.00

5. (G) The name and city of all customers

6. (G) Order numbers for orders made by an employee named’Jones’

7. (Y) Customer name and order number for all orders, wherethe customers address begins with ‘1’.

8. (Y) All information about employees and the cities theylive in. Include information about cities without employees (Hint: outer join).

9. (Y) Customer names and order numbers for all orders withcustomer that live in ”Los Angeles”

10. (Y) A list with name, quantity, price and total price forall products on the order with order number 1020.

11. (Y) The price of all orders combined.

12. (R) Order numbers for orders which have not yet beendelivered.

13. (R) The order number, number of line items, the customer’sname, street, zip code and city

14. (R) The names of customers who have made an order with anemployee who lives in ’Los Angeles’ 

15. (R) Order number and total price of the entire order – forall orders



### part 5 (R)

 Views are virtual tables defined as queries and operate on data from one or more tables. You can read about it at: [http://www.mysqltutorial.org/mysql-views-tutorial.aspx](http://www.mysqltutorial.org/mysql-views-tutorial.aspx), in particular thefirst three sections (Intro, Views in MySQL, Creating Views in MySQL)

 

a)  Create a view from the employee table, butonly with rows that have a zip code greater than 60000. Test the view with a“SELECT * FROM … “ 

 

b)  Create another view also from the employee table,but only with the columns employee number and employee name. Test the view witha “SELECT * FROM … “

 

c)  Create a view which includes employee numbers and names and the number of orders each employee has created. Test the view with a “SELECT * FROM … “

**Example of View creation:**

```sql
CREATE VIEW StaffBranch001
AS  
SELECT staffNo, name, position
FROM Staff
WHERE branchNo = ’B001’;
```

### part 6 (R)

a)     Consider the use of the unique constraint on non-primarykey columns to prevent duplicate values in one or more columns.

b)  use ON DELETE CASCADE referential action for a foreign key to delete data from a child table automatically when you delete data from a parent table.

 

 