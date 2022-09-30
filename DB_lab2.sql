use labor_sql;

-- 1
SELECT maker, type FROM product WHERE type='laptop' ORDER BY maker;

-- 2

SELECT substring_index(name, ' ', -1) AS surname FROM passenger where substring(substring_index(name, ' ', -1), 1, 1) != 'j';

-- 3

SELECT maker FROM product JOIN laptop ON product.type ='laptop' AND laptop.speed < 500;

-- 4

SELECT maker FROM product WHERE type='pc' and maker = SOME (SELECT maker FROM product where type='laptop');

-- 5

SELECT maker, product.type, pc.speed FROM product JOIN pc ON product.model=pc.model where
 pc.speed = (SELECT max(speed) FROM pc) and type='pc' and maker = SOME (SELECT maker FROM product where type='printer');

-- 6

SELECT DATE_FORMAT(date, "%d.%m.%Y") AS date FROM income;

-- 7

SELECT COUNT(*) AS quantity, ROUND(AVG(price)) AS average_price FROM pc GROUP BY pc.model HAVING AVG(price) < 800 ;
-- 8

SELECT DISTINCT maker, (SELECT COUNT(DISTINCT model) FROM pc WHERE model IN 
(SELECT model FROM product where maker=p.maker))pc,
(SELECT COUNT(DISTINCT model) FROM laptop WHERE model IN (SELECT model FROM product where maker=p.maker)) laptop,
(SELECT COUNT(DISTINCT model) FROM printer WHERE model IN (SELECT model FROM product where maker=p.maker)) printer
FROM product AS p;

-- 9


SELECT s.name, s.launched, clASses.clASs, clASses.type, clASses.country, clASses.numGuns, clASses.bore, clASses.displacement FROM ships AS s JOIN clASses ON s.clASs=clASses.clASs
where
	(CASE WHEN numGuns = 12 THEN 1 ELSE 0 END +
	CASE WHEN bore = 16 THEN 1 ELSE 0 END +
	CASE WHEN displacement = 46000 THEN 1 ELSE 0 END +
	CASE WHEN type = 'bb' THEN 1 ELSE 0 END +
	CASE WHEN launched = 1916 THEN 1 ELSE 0 END +
	CASE WHEN clASses.clASs = 'Revenge' THEN 1 ELSE 0 END +
	CASE WHEN country = 'Japan' THEN 1 ELSE 0 END ) = 3;

-- 10

SELECT product.model, price FROM product, pc
WHERE product.model = pc.model AND maker = 'B'
UNION
SELECT product.model, price FROM product, laptop
WHERE product.model = laptop.model AND maker = 'B'
UNION
SELECT product.model, price FROM product, printer
WHERE product.model = printer.model AND maker = 'B';