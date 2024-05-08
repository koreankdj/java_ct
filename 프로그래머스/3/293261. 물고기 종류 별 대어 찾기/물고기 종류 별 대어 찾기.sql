-- 코드를 작성해주세요
with 
T1 as (
    select fish_type, max(length) as length
    from fish_info
    group by fish_type
)




select I.id, N.fish_name, T.length
from FISH_NAME_INFO as N
join T1 as T on N.fish_type = T.fish_type
join FISH_INFO as I on I.fish_type = T.fish_type and I.length = T.length
order by 1;