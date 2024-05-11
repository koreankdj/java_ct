-- 코드를 작성해주세요

with 
T1 as (
    select item_id
    from ITEM_INFO 
    where rarity = 'rare'
),
T2 as (
    select item_id
    from ITEM_TREE 
    where parent_item_id in (select * from T1)
),
T3 as (
    select T.item_id, I.item_name, I.rarity
    from T2 as T
    join ITEM_INFO as I on T.item_id = I.item_id
)

select * 
from T3
order by 1 desc;