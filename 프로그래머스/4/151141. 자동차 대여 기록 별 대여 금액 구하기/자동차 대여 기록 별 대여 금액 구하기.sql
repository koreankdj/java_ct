with
T1 as ( -- 트럭인 데이터 뽑기
    select *
    from CAR_RENTAL_COMPANY_CAR
    where car_type = '트럭'
),
T2 as ( -- 트럭의 기간 
    select C.history_id, T.car_id, T.daily_fee, datediff(C.end_date, C.start_date)+1 as period, 
    (case 
     when datediff(end_date, start_date)+1 >= 90 then '90일 이상'
     when datediff(end_date, start_date)+1 >= 30 then '30일 이상'
     when datediff(end_date, start_date)+1 >= 7 then '7일 이상'
     else 'NONE'
    end) as duration_type
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as C
    join T1 as T on C.car_id = T.car_id
),
T3 as ( -- 트럭의 할인율 뽑기
    select duration_type, discount_rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where car_type = '트럭'
),
T4 as (
    select A.history_id, 
    round((A.period * A.daily_fee) * (100 - ifnull(B.discount_rate, 0)) / 100) as FEE
    from T2 as A
    left join T3 as B on A.duration_type = B.duration_type
)

select * 
from T4
order by 2 desc, 1 desc;