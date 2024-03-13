-- 코드를 입력하세요
select MONTH(START_DATE) as month, CAR_ID, count(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' and '2022-10'
and CAR_ID IN (SELECT CAR_ID
              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
              WHERE DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' and '2022-10'
              GROUP BY CAR_ID
              HAVING COUNT(*) >= 5)
group by 1, 2
having RECORDS > 0
order by 1, 2 desc;