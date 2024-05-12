-- 코드를 입력하세요

with 
T1 as (
    select user_id
    from USER_INFO 
    where year(joined) = 2021
),
T2 as (
    select *
    from ONLINE_SALE 
    join T1 using (user_id)
)

SELECT year(sales_date) as year, month(sales_date) as month, 
count(distinct user_id) as PUCHASED_USERS,
round((count(distinct user_id) / (select count(user_id) from T1)), 1) as PUCHASED_RATIO
from t2
group by 1, 2
order by 1, 2;
