-- 코드를 입력하세요
SELECT F.FLAVOR
FROM FIRST_HALF as F
JOIN ICECREAM_INFO as I on F.FLAVOR = I.FLAVOR
WHERE I.INGREDIENT_TYPE = 'fruit_based' and F.TOTAL_ORDER >= 3000
ORDER BY F.TOTAL_ORDER DESC;