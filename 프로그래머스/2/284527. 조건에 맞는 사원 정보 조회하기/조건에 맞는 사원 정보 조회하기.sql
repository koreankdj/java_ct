-- 코드를 작성해주세요

with
T1 as ( -- 2022년의 총점 
    select emp_no, sum(score) as 'score'
    from HR_GRADE 
    where year = 2022
    group by 1
    order by 2 desc
)

select T.score, T.emp_no, E.emp_name, E.position, E.email
from T1 as T
join HR_EMPLOYEES as E on T.emp_no = E.emp_no
limit 1;
