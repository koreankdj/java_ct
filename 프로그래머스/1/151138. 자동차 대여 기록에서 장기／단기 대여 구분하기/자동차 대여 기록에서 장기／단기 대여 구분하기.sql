-- 코드를 입력하세요
with
T1 as (
    select *,
    (case
        when datediff(end_date, start_date) + 1 >= 30 then '장기 대여'
        else '단기 대여'
     end ) as rent_type
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where date_format(start_date, '%Y-%m') = '2022-09'
)

select history_id, car_id, date_format(start_date, '%Y-%m-%d') as start_date, date_format(end_date, '%Y-%m-%d') as end_date, rent_type
from t1
order by 1 desc;