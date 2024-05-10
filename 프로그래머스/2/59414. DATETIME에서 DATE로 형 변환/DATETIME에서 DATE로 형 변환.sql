SELECT animal_id, name, DATE_FORMAT(DATETIME, '%Y-%m-%d') as '날짜'
FROM ANIMAL_INS
order by 1;