-- 코드를 입력하세요
SELECT user_id, product_id
FROM ONLINE_SALE 
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(product_id) > 1
order by 1, 2 DESC;