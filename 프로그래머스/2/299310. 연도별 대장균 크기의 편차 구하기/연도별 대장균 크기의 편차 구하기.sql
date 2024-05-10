-- 코드를 작성해주세요
with 
T1 as (
    select year(DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as SIZE_OF_COLONY
    from ECOLI_DATA
    group by 1
)

select T.year, (T.SIZE_OF_COLONY - E.SIZE_OF_COLONY) as year_dev, E.id
from T1 as T
join ECOLI_DATA as E on T.year = year(E.DIFFERENTIATION_DATE)
order by 1, 2;