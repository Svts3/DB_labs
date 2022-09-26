# DB_labs

# lab2

- Write 10 selectors to your laboratory mysql table and 10 to default variant

# Variant 62
1. Database "Comp. firm". Find laptop manufacturers. Output: maker,
type. Sort the output in ascending order by the maker column.
2. DB "Airport". Display passenger names (the second word in the column
name) that do not begin with the letter 'J'.
3. Database "Comp. firm". Find laptop manufacturers with processor no
above 500 MHz. Output: maker.
4. Database "Comp. firm". Find manufacturers that release at the same time
PCs and laptops (use keyword SOME). Display maker.
5. Database "Comp. firm". Find printer manufacturers that produce
A PC with the highest processor speed. Output: maker.
6. DB "Firm priy. recycled materials". From the Income table, extract the dates in
in the following format: day.month.year, for example, 01.05.2001 (without
time format).
7. Database "Comp. firm". Find the number of PCs and the average price for each model, assuming that the average price is less than $800.
8. Database "Comp. firm". Get the summary set for the Product table
in the form of a table with columns maker, pc, laptop and printer, in which for
each manufacturer must specify the number of different products that
it is produced, that is, products with different (unique) numbers
models in the tables, respectively, PC, Laptop and Printer. (Hint:
use subqueries as calculated columns)
9. DB "Ships". Determine the names of all ships from the Ships table, which
satisfy, in the extreme case, combinations of any three
criteria from the following list: numGuns=9, bore=16,
displacement=46000, type='bb', country='Japan', launched=1916,
class='Revenge'. Output: name, numGuns, bore, displacement, type,
country, launched, class. (Hint: use to check conditions
CASE operator)
10. Database "Comp. firm". Find the model numbers and prices of all
products (of any type) produced by manufacturer 'B'. Output:
maker, model, type, price. (Hint: use the UNION operator)
