-- 코드를 입력하세요

with T1 as (
    select book_id, sum(sales) as total_sales
    from BOOK_SALES 
    where date_format(sales_date, '%Y-%m') = '2022-01'
    group by book_id
)

SELECT B.author_id, A.author_name, B.category, sum(B.price * T.total_sales) as total_sales
from BOOK as B
join AUTHOR as A on B.author_id = A.author_id
join T1 as T on B.book_id = T.book_id
group by author_name, category
order by 1, 3 desc;