-- 코드를 입력하세요
With T1 as (
    select food_type, max(favorites) as m_fav
    from REST_INFO
    group by food_type
)

select T.food_type, I.rest_id, I.rest_name, T.m_fav
from T1 as T
join REST_INFO as I on T.food_type = I.food_type and T.m_fav = I.favorites 
order by 1 desc;
