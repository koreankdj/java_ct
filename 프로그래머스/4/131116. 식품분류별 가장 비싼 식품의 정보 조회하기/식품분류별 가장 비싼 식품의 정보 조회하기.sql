-- 코드를 입력하세요

with
T1 as (
    select category, max(price) as m_price
    from FOOD_PRODUCT
    where category in ('과자', '국', '김치', '식용유')
    group by category
)


SELECT T.category, T.m_price, F.product_name
from T1 as T
join FOOD_PRODUCT as F on T.category = F.category and T.m_price = F.price
order by 2 desc;
