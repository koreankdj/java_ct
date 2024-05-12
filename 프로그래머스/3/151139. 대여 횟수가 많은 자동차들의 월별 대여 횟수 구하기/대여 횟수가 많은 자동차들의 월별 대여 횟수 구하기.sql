-- 코드를 입력하세요

with 
T1 as (
    select car_id, count(history_id) as cnt
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date between '2022-08-01' and '2022-10-31'
    group by 1
    having cnt >= 5
)

SELECT month(start_date) as month, car_id, count(car_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
join T1 using (car_id)
where start_date between '2022-08-01' and '2022-10-31'
group by 1, 2
order by 1, 2 desc;