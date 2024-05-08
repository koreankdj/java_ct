-- 코드를 입력하세요

with
T1 as (
    select member_id, rank() over(order by count(review_id) desc) as rnk
    from REST_REVIEW
    group by 1
),
T2 as (
    select member_id
    from T1
    where rnk = 1
)


SELECT P.member_name, R.review_text, date_format(R.review_date, '%Y-%m-%d') as review_date
from MEMBER_PROFILE as P
join T2 as T on P.member_id = T.member_id
join REST_REVIEW as R on T.member_id = R.member_id
order by 3, 2;