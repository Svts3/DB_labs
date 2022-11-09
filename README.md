# DB_labs

# Lab 6

Based on the previous work (back-end with Spring Boot), a number of software structures (triggers, procedures, functions, cursors) should be written for the existing  database. For stored procedures, ensure that they are called using backend controllers.

- Add an additional arbitrary table to DB 1 and connect it to another existing table with a 1:M connection. However, to ensure value integrity, use triggers instead of a physical foreign key.
## Stored procedures:
- Provide parameterized insertion of new values ​​into an arbitrary table.
- To ensure the implementation of M:M connection between 2 tables, i.e. to insert into the connecting table the corresponding tape according to the real-existing values ​​(eg surname, name) in these main tables.
- Create a package that inserts 10 tapes into an arbitrary DB table in the format <Noname+No>, for example: Noname5, Noname6, Noname7, etc.
- Write a custom function that will search for Max, Min, Sum or Avg for a column of an arbitrary table in the database. Write a procedure that will call this function in SELECT.
- Write 1 procedure with a cursor to perform one of the following tasks: 
  - Using a cursor, ensure dynamic creation of databases with names taken from a column from an arbitrary table of the current database, with a random number of tables for each database (from 1 to 9). The structure of the tables is arbitrary. The names of the tables correspond to the name of the database with a serial number from 1 to 9.

- Write triggers for the tables of the current database:
  - The value of a certain column cannot end with two zeros
  - Create a log table in which to keep logs with a time stamp when data is deleted for a certain table
  - Only the following names are allowed for a given column: 'Svitlana', 'Petro', 'Olha', 'Taras'.



