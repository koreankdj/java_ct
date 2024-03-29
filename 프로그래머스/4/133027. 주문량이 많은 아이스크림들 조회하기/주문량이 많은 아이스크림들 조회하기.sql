
SELECT FLAVOR
from (
    select *
    from FIRST_HALF
    UNION ALL
    select *
    from JULY
) as SUB
group by FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;