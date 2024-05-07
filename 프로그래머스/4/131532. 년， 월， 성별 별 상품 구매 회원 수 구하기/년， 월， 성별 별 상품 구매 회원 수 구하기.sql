-- 코드를 입력하세요

with 
T1 as (
    select sales_date, user_id
    from ONLINE_SALE 
)

SELECT year(T.sales_date) as year, month(T.sales_date) as month, I.gender as gender, count(distinct(T.user_id)) as users
from T1 as T
join USER_INFO as I on T.user_id = I.user_id
where I.gender is not null
group by 1, 2, 3
order by 1, 2, 3;

