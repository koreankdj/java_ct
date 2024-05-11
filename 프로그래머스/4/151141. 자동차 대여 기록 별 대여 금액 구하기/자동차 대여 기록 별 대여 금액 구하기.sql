-- 코드를 입력하세요

with 
T1 as ( -- 트럭
    select car_id, daily_fee
    from CAR_RENTAL_COMPANY_CAR
    where car_type = '트럭'
),
T2 as (
    select T.daily_fee, H.history_id, H.car_id, datediff(H.end_date, H.start_date) + 1 as period,
    (case
        when datediff(H.end_date, H.start_date) + 1 >= 90 then '90일 이상'
        when datediff(H.end_date, H.start_date) + 1 >= 30 then '30일 이상'
        when datediff(H.end_date, H.start_date) + 1 >= 7 then '7일 이상'
        else 'NONE'
    end) as duration_type 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
    join T1 as T on H.car_id = T.car_id
    order by 1
),
T3 as (
    select car_type, duration_type, discount_rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where car_type = '트럭'
)

select A.history_id, round((A.daily_fee * A.period) * (100 - ifnull(B.discount_rate, 0)) / 100) as fee
from T2 as A
left join T3 as B on A.duration_type = B.duration_type
order by 2 desc, 1 desc;
