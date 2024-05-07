-- 코드를 입력하세요

With T1 as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where year(start_date) = 2022 and month(start_date) between 8 and 10
    group by car_id
    having count(history_id) >= 5
)

select month(C.start_date) as month, T.car_id as car_id, count(T.car_id) as 'records'
from T1 as T
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as C on T.car_id = C.car_id
group by month, car_id
order by 1, 2 desc;