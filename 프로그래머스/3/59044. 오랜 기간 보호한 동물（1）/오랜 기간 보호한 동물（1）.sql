-- 코드를 입력하세요
SELECT I.name, I.datetime
from ANIMAL_INS as I
left join ANIMAL_OUTS as O on I.animal_id = O.animal_id
where O.datetime is null
order by 2
limit 3;