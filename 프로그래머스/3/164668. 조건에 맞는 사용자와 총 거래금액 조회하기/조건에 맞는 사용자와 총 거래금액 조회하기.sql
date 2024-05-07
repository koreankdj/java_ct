-- 코드를 입력하세요
With T1 as (select writer_id, sum(price) as total_sales
           from USED_GOODS_BOARD
            where status = 'done'
            group by writer_id
            having total_sales >= 700000
            
           )
           
select U.user_id, U.nickname, T.total_sales
from T1 as T
join USED_GOODS_USER as U on T.writer_id = U.user_id
order by 3;