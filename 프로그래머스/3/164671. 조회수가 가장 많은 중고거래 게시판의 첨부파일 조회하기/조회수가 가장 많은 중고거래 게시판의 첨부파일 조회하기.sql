-- 코드를 입력하세요

SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS F
JOIN USED_GOODS_BOARD AS B ON F.BOARD_ID = B.BOARD_ID
WHERE F.BOARD_ID = (
    SELECT B.BOARD_ID
    FROM USED_GOODS_BOARD AS B
    ORDER BY B.VIEWS DESC
    LIMIT 1
)
ORDER BY F.FILE_ID DESC
