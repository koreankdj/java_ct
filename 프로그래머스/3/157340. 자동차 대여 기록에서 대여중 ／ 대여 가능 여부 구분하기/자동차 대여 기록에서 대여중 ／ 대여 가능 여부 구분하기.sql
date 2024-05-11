-- 코드를 입력하세요

with 
T1 as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where '2022-10-16' between start_date and end_date
)

select car_id, 
    (case
        when car_id in (select * from T1) then '대여중'
        else '대여 가능'
    end) as 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by 1
order by 1 desc;