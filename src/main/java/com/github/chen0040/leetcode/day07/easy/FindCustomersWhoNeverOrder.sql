-- link: https://leetcode.com/problems/customers-who-never-order/description/
-- Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.
SELECT Customers.Name as Customers from Customers left join Orders on Customers.Id = Orders.CustomerId WHERE Orders.CustomerId is NULL;
