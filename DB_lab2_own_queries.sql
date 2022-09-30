use tsar;

-- 1 select first name, last name AND average hearbeat rate for each person, AND ORDER BY first name
SELECT first_name, last_name, avg(heartbeat_rate)AS average_hearthbeat_rate FROM user JOIN health_info ON user.id=health_info.id GROUP BY first_name
ORDER BY first_name;

-- 2 select user AND owner of each watch AND select watch serial number that belongs to them  
SELECT user.first_name, user.last_name, owner.first_name, owner.last_name, property_info.watch_serial_number FROM user
 JOIN owner ON user.property_info_id=owner.id JOIN property_info ON owner.id=property_info.id GROUP BY property_info.watch_serial_number; 
 
 -- 3 select first name AND last name of user AND select its emergency phone numbers
SELECT first_name, last_name, emergency_phone_number.phone_number AS emergency_phone_number FROM user JOIN property_info ON user.id=property_info.id
	JOIN watch ON property_info.watch_serial_number = watch.serial_number
	JOIN emergency_phone_number ON emergency_phone_number.watch_serial_number=watch.serial_number
	GROUP BY emergency_phone_number.phone_number;
    
-- 4 select first name AND last name of user AND COUNT quantity of emergency phone numbers
SELECT first_name, last_name, COUNT(emergency_phone_number.phone_number) AS number_of_emergency_phone_numbers FROM user JOIN property_info ON user.id=property_info.id
	JOIN watch ON property_info.watch_serial_number = watch.serial_number
	JOIN emergency_phone_number ON emergency_phone_number.watch_serial_number=watch.serial_number
	GROUP BY first_name;

-- 5

SELECT DISTINCT first_name, last_name, country.name AS country, region.name AS region, city.name AS city, street.name AS street FROM user
JOIN property_info ON property_info.id=user.id 
JOIN watch ON watch.serial_number=property_info.watch_serial_number 
JOIN street ON watch.street_name = street.name 
JOIN city ON street.city_name=city.name
JOIN region ON city.region_name = region.name
JOIN country ON region.country_name = country.name
GROUP BY first_name
ORDER BY first_name;

-- 6 COUNT the number of male AND female users

Select (SELECT COUNT(gender) FROM user WHERE gender='male')AS male,(SELECT COUNT(gender) FROM user WHERE gender='female')AS female FROM user GROUP BY male, female;

-- 7 
SELECT first_name, last_name, avg(heartbeat_rate)AS average_hearthbeat_rate FROM user JOIN health_info ON user.id=health_info.id  WHERE user.date_of_birth <= "1977-01-01"GROUP BY first_name
ORDER BY average_hearthbeat_rate DESC;

-- 8

SELECT first_name, last_name, (CASE
						WHEN health_info.heartBeat_rate >= 60 AND health_info.heartBeat_rate <= 80 THEN 'ok'
                        WHEN health_info.heartBeat_rate > 80  THEN 'high'
                        WHEN health_info.heartBeat_rate < 60  THEN 'low'END)AS heartbeat_status
                        FROM user JOIN health_info ON user.id=health_info.id GROUP BY first_name
ORDER BY first_name;

-- 9
SELECT first_name, last_name, date_format(date_of_birth, "%D-%M-%Y") FROM user ORDER BY date_of_birth DESC;

-- 10

select COUNT(user.first_name)AS owner_and_user_duplicates FROM user JOIN property_info AS p ON p.id=user.id JOIN owner ON owner.id=p.id
WHERE
	CASE WHEN user.first_name = owner.first_name 
		AND user.last_name = owner.last_name 
		AND user.gender = owner.gender
		AND user.date_of_birth=owner.date_of_birth THEN 1 ELSE 0 END
    
	


