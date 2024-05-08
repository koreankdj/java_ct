-- 코드를 입력하세요
/*
with 
T1 as (     -- 대여 가능한 car_id 목록
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date >= '2022-12-01' or end_date <= '2022-10-31'
    group by car_id
),
T2 as (
    select car_id, car_type
    from CAR_RENTAL_COMPANY_CAR 
    where car_type in ('SUV', '세단')
),
T3 as (
    select car_id, round((C.daily_fee * 30) * (100 - P.discount_rate)/100) as fee
    from CAR_RENTAL_COMPANY_CAR as C
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as P on C.car_type = P.car_type
    where (C.daily_fee * 30) * (100 - P.discount_rate)/100 between 500000 and 2000000
    group by 1
)

select A.car_id, B.car_type, C.fee
from T1 as A
join T2 as B on A.car_id = B.car_id
join T3 as C on A.car_id = C.car_id
order by 3 desc, 2, 1 desc;
*/
SELECT C.CAR_ID, C.CAR_TYPE, ROUND(C.DAILY_FEE*30*(100-P.DISCOUNT_RATE)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H ON C.CAR_ID=H.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P ON C.CAR_TYPE=P.CAR_TYPE
WHERE C.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE > '2022-11-01' AND START_DATE < '2022-12-01'
) AND P.DURATION_TYPE='30일 이상'
GROUP BY C.CAR_ID
HAVING C.CAR_TYPE IN ('세단', 'SUV') AND (FEE>=500000 AND FEE<2000000) 
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC