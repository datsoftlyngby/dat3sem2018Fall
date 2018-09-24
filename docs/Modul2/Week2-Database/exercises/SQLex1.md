# SQL EXERCISES

**Based on the [ClassicModels database](DatabaseClassicModels.sql).**

- 1 (G) - Get the script file: DatabaseClassicModels.sql from the github repo
- 2 (G) - Run the script on you local Mysql server
- 3 (G) - Check that there were no errors and that 9 tables were created and filled with data.

###  SELECT (ONE TABLE only)

- 4 (G) - Find all the French customers
- 5 (G) - Find first name and last name on employees with the title ”sales rep”
- 6 (G) - Find name and description of the motorcycle models that cost between 50$ and 100$
- 7 (G) - Find the customer numbers for the orders that have been cancelled
- 8 (G) - Find product lines and vendor for products with size 1:18

### ORDER BY
- 9 (G) - List all the motorcycles sorted by product name
- 10 (G) - List models with less than 1000 in stock sorted by quantity in stock with highest quantity at the top of the list
- 11 (G) - List the Norwegian customers’ customer name and contact person sorted by the contact person’s first name

### FUNCTIONS
- 12 (G) - How many German customers are there?
- 13 (G) - What is the average price for classic car models?
- 14 (Y) - What is the price of the most expensive model from 'Autoart Studio Design’?
- 15 (R) - How many different countries do the customers come from?
- 16 (R) - What is the quantity in stock for 1:12 models?
- 17 (R) - What is the highest profit amongst the products?

### GROUP BY
- 18 (G) - What is the average price for each product line?
- 19 (Y) - How many different products does each vendor have?
- 20 (R) - What is the profit percentage wise based on product scale?
- 21 (R) - How many orders exist for each order status type?
- 22 (R) - How many orders do each customer have?

### SELECT (MANY TABLES)
- 23 (G) - Find all customer names and the name of the employee responsible for the customer
- 24 (Y) - Find all customer names and the name of the employee responsible for the customer for italian customers
- 25 (R) - Find all customer countries and the names of the employees responsible for customers in the countries

### UPDATE
- 26 (G) - Update Leslie Jenning’s last name to “Smith”
- 27 (G) - Update Roland Keitel’s first name to “Dr. Roland”
- 28 (G) - Update all spanish customers to be associated with employee Martin Gerard
- 29 (Y) - Update all motorcycles’ MSRP with extra 10%
- 30 (R) - Update all customers with null in address Line2 to an empty string

### INSERT
- 31 (G) - Insert a new product called bike and with some description
- 32 (G) - Insert a new office for Copenhagen
- 33 (G) - Insert two new products called mountainbike and triathlonbike at the same time

### DELETE
- 34 (G) - Delete all payments older than '2003‐06‐18'
- 35 (Y) - Delete all customers with customer numbers lower than 150

### JOIN
- 36 (G) - List all orders with order number, customer name and order date
- 37 (R) - List all customers with customer name who have no orders