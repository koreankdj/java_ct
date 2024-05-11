-- 코드를 작성해주세요

with 
T1 as (
    select fish_type, max(length) as 'length'
    from FISH_INFO 
    group by 1
),
T2 as (
    select T.fish_type, T.length, N.fish_name
    from T1 as T
    join FISH_NAME_INFO as N on T.fish_type = N.fish_type
)

select I.id, T.fish_name, T.length
from FISH_INFO as I
join T2 as T on I.fish_type = T.fish_type and I.length = T.length
order by 1;