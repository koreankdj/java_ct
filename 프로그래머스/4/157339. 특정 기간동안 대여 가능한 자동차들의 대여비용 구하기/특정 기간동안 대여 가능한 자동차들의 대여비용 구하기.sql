-- 코드를 입력하세요
with 
T1 as ( -- SUV or 세단
    select car_id, car_type, (daily_fee * 30) as fee
    from CAR_RENTAL_COMPANY_CAR 
    where car_type in ('SUV', '세단')
), 
T2 as (
    select *
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where '2022-11-01' between start_date and end_date or '2022-11-30' between start_date and end_date
),
T3 as (
    select car_id, car_type, fee
    from T1
    where car_id not in (select car_id from T2)
),
T4 as (
    select car_type, discount_rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where car_type in ('세단', 'SUV') and duration_type = ('30일 이상')
),
T5 as (
    select car_id, car_type, round(fee * (100 - discount_rate) / 100) as fee
    from T3 
    join T4 using (car_type)
    where fee between 500000 and 2000000
)

select * 
from T5
order by 3 desc, 2, 1 desc;