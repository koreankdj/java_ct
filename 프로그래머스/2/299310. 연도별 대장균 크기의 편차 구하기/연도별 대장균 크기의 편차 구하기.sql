-- 코드를 작성해주세요

/*
    편차 : 
*/

With T1 as (
    select max(size_of_colony) as best, year(DIFFERENTIATION_DATE) as year
    from ECOLI_DATA 
    group by 2
)

select year(DIFFERENTIATION_DATE) as year, (T.best - E.SIZE_OF_COLONY) as YEAR_DEV, E.ID
from ECOLI_DATA as E
join T1 as T on T.year = year(E.DIFFERENTIATION_DATE)
order by 1, 2;