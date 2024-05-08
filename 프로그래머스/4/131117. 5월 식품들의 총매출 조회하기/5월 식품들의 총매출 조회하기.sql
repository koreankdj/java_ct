-- 코드를 입력하세요

with 
T1 as (
    select product_id, sum(amount) as amount
    from FOOD_ORDER 
    where date_format(produce_date, '%Y-%m') = '2022-05'
    group by 1
)

SELECT F.product_id, F.product_name, (F.price * T.amount) as total_sales
from FOOD_PRODUCT as F
join T1 as T on F.product_id = T.product_id
order by 3 desc, 1;