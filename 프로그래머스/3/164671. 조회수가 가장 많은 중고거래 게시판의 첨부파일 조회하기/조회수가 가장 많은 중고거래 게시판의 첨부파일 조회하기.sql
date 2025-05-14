-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬해주세요.
SELECT '/home/grep/src/' || A.BOARD_ID || '/' || B.FILE_ID || B.FILE_NAME || B.FILE_EXT AS FILE_PATH
FROM USED_GOODS_BOARD A
JOIN USED_GOODS_FILE B ON A.BOARD_ID = B.BOARD_ID
WHERE A.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY B.FILE_ID DESC