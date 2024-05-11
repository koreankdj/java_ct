-- 코드를 입력하세요
/*
with 
T1 as (
    select car_id, count(history_id) as cnt
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where year(start_date) = '2022' and month(start_date) between 8 and 10
    group by 1
    having cnt >= 5
    order by 1
),
T2 as (
    select month(start_date) as month, car_id, count(history_id) as records
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where car_id in (select car_id from T1)
    group by 1, 2
)

SELECT * 
from t2
order by 1, 2 desc;
*/

SELECT month(start_date) as month, car_id, count(history_id) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date>="2022-08-01" and start_date<"2022-11-01" and car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date>="2022-08-01" and start_date<"2022-11-01" group by car_id having count(history_id)>4) 
group by month, car_id
having records >0
order by month, car_id desc