-- 코드를 입력하세요
with
T1 as (
    select flavor, sum(total_order) as t_order
    from FIRST_HALF 
    group by 1
),
T2 as(
    select flavor, sum(total_order) as t_order
    from july
    group by 1
),
T3 as (
    select A.flavor as flavor, (A.t_order + B.t_order) as t_order
    from T1 as A
    join T2 as B on A.flavor = B.flavor
    order by 2 desc
    limit 3
)

select flavor
from T3;