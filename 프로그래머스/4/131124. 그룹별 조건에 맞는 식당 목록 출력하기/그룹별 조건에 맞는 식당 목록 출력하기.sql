
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM MEMBER_PROFILE as M
JOIN REST_REVIEW as R on M.MEMBER_ID = R.MEMBER_ID 
WHERE R.MEMBER_ID IN (SELECT MEMBER_ID
                    FROM (
                        SELECT MEMBER_ID, DENSE_RANK() OVER(ORDER BY COUNT(*) DESC) as RNK
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                    ) as SUB
                    WHERE RNK = 1
                   )
ORDER BY 3, 2;