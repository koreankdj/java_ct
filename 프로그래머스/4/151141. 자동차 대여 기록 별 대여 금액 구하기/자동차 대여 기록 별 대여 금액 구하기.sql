with
T1 as (
    select *
    from CAR_RENTAL_COMPANY_CAR
    where car_type = '트럭'
),
T2 as (
    select C.history_id, C.car_id, datediff(C.end_date, C.start_date)+1 as period,
    (case 
     when datediff(end_date, start_date)+1 >= 90 then '90일 이상'
     when datediff(end_date, start_date)+1 >= 30 then '30일 이상'
     when datediff(end_date, start_date)+1 >= 7 then '7일 이상'
     else 'NONE'
    end) as duration_type
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as C
    join T1 as T on C.car_id = T.car_id
),
T3 as (
    select duration_type, discount_rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where car_type = '트럭'
),
T4 as (
    select A.history_id, 
    round((A.period * C.daily_fee) * (100 - B.discount_rate) / 100) as FEE
    from T2 as A
    join T3 as B on A.duration_type = B.duration_type
    join T1 as C on A.car_id = C.car_id
)
/*
select * 
from t4
order by 2 desc, 1 desc;*/


SELECT HISTORY_ID, 
    round(DAILY_FEE * (DATEDIFF(h.END_DATE,h.START_DATE)+1)
    * (case 
    when DATEDIFF(END_DATE,START_DATE)+1 < 7 then 1
    when DATEDIFF(END_DATE,START_DATE)+1 < 30 then 0.95
    when DATEDIFF(END_DATE,START_DATE)+1 < 90 then 0.92
    else 0.85 end)) as "FEE"

from CAR_RENTAL_COMPANY_CAR as c 
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.CAR_ID = h.CAR_ID
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
    on c.CAR_TYPE = p.CAR_TYPE

where c.car_type = "트럭"
group by HISTORY_ID
order by FEE desc , HISTORY_ID desc