-- 코드를 입력하세요

with 
T1 as (
    select user_id
    from USER_INFO 
    where year(joined) = 2021
),
T2 as(
    select count(*) as total
    from T1
),
T3 as (
    select year(sales_date) as year, 
    month(sales_date) as month, 
    count(online_sale_id) as PUCHASED_USERS, 
    round((count(online_sale_id) / (select * from T2)), 1) as PUCHASED_RATIO
    from ONLINE_SALE 
    where user_id not in (select user_id from T1)
    group by 1, 2
)

-- select * from T3 order by 1, 2;

SELECT DATE_FORMAT(O.SALES_DATE, '%Y') AS YEAR,
        DATE_FORMAT(O.SALES_DATE, '%m') AS MONTH,
        COUNT(DISTINCT U.USER_ID) AS PUCHASED_USERS,
        ROUND(COUNT(DISTINCT U.USER_ID)/(SELECT COUNT(*) FROM USER_INFO WHERE joined LIKE '2021%'), 1) AS PUCHASED_RATIO
FROM USER_INFO U
JOIN ONLINE_SALE O
ON U.USER_ID = O.USER_ID
WHERE U.JOINED LIKE '2021%'
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH