-- 코드를 입력하세요

with 
T1 as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where year(START_DATE) = 2022 and month(START_DATE) between 8 and 10
    group by car_id
    having count(history_id) >= 5
)

select month(START_DATE) as month, car_id, count(history_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where car_id in (
    select *
    from T1
) and year(start_date) = 2022 and month(start_date) between 8 and 10
group by month, car_id
order by 1, 2 desc;


