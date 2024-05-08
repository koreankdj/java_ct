-- 코드를 작성해주세요
with 
T1 as (
    select MAX(SIZE_OF_COLONY) as size, year(DIFFERENTIATION_DATE) as year
    from ECOLI_DATA
    group by 2
)


select year(E.DIFFERENTIATION_DATE) as 'year', (T.size-E.SIZE_OF_COLONY) as year_dev, E.ID
from ECOLI_DATA as E
join T1 as T on T.year = year(E.DIFFERENTIATION_DATE)
order by 1, 2;