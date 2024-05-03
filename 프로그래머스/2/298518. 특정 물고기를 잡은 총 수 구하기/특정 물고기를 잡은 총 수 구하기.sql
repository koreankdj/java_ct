-- 코드를 작성해주세요
SELECT COUNT(*) as FISH_COUNT
FROM FISH_INFO as I
JOIN FISH_NAME_INFO as N on I.FISH_TYPE = N.FISH_TYPE
WHERE N.FISH_NAME in ('BASS', 'SNAPPER');