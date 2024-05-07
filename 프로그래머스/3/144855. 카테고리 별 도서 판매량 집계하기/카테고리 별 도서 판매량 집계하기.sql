-- 코드를 입력하세요
with T1 as (
    select book_id, sum(sales) as total_sales
    from BOOK_SALES
    where date_format(sales_date, '%Y-%m') = '2022-01'
    group by 1
)

select B.category, sum(T.total_sales) as total_sales
from BOOK as B
join T1 as T on B.book_id = T.book_id
group by 1
order by 1;