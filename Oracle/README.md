About Oracle

2018-08-22 ORACLE 데이터 복구 <br>
[1.실수로 삭제한 TABLE 복구 방법](https://github.com/jyshine/TIL/blob/master/Oracle/ETC/recovery_data.txt)


이전글 다음글 가져오는 쿼리문 추후 

	<select id="selectPrevNext" parameterType="commonBoardVO" resultType="map">
	SELECT 
		TT.*
	FROM
		(
		SELECT 
			ROW_NUMBER() OVER(ORDER BY B.REG_DATE DESC) RNUM,
			B.BOARD_ID,
			LAG(B.BOARD_ID) OVER(ORDER BY B.REG_DATE DESC) AS PREV_BOARD_ID
			,LEAD(B.BOARD_ID) OVER(ORDER BY B.REG_DATE DESC) AS NEXT_BOARD_ID
			,LAG(B.BOARD_TITLE) OVER(ORDER BY B.REG_DATE DESC) AS PREV_BOARD_TITLE
			,LEAD(B.BOARD_TITLE) OVER(ORDER BY B.REG_DATE DESC) AS NEXT_BOARD_TITLE
		FROM
			CPS_BOARD B
			LEFT JOIN CPS_BOARD_MASTER BM 
				ON B.REFERENCE_ID  = BM.MASTER_ID
		WHERE 1=1
			AND B.DEL_YN = 'N'
			<if test="referenceId != null and referenceId != ''">
			AND B.REFERENCE_ID = #{referenceId}
			</if>
		ORDER BY B.REG_DATE DESC
		) TT
	WHERE
		<if test="boardId != null and boardId != ''"> 
			TT.BOARD_ID = #{boardId}
		</if>
	</select>
