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


##### DB 복사 (dump파일을 이용한 복사 방법) #####
--참고 페이지 : http://keiis.co.kr/study/200.Database/100.Oracle/M910.Object&Utility/H100.Data_Pump_1.html

--예제) careerpass에서 export하여 receiveuser에서 import처리

--유서 생성 및 권한부여
--DB관리자 접속( sys/dainls123 )
--1) import 받을 사용자 생성
    create user receiveuser identified by receiveuserpw;
    --기본 테이블 스페이스 설정 (option)
    --default tablespace USERS
    --temporary 테이블 스페이스 설정 (option)
    --temporary tablespace temp 
--2) import 받을 사용자 권한부여
    grant connect, resource to receiveuser;
--3) import 받을 사용자 모든 테이블에 대한 select 권한 부여
    grant select any table to receiveuser;
--4) import 받을 사용자 EXP_FULL_DATABASE,IMP_FULL_DATABASE 권한 부여
    grant EXP_FULL_DATABASE, IMP_FULL_DATABASE to receiveuser;
--5) export 받을 사용자 EXP_FULL_DATABASE,IMP_FULL_DATABASE 권한 부여
    grant EXP_FULL_DATABASE, IMP_FULL_DATABASE to careerpass;

--Data Pump 디렉토리 확인
--1) 사용 중인 디렉토리 오브젝트의 조회
    SELECT * FROM dba_directories;
--2)디렉토리 오브젝트 추가 
    -- 필요할 경우 추가 보통은 TEMP_DIR	AS '/DATA/EXPORTPUMP' 사용
    CREATE DIRECTORY TEMP_DIR as '/DATA/EXPORTPUMP';  
    --오라클이 설치된 서버의 '/DATA/EXPORTPUMP' 에 대한 디렉토리 오브젝트 TEMP_DIR 을 생성하는 명령문 입니다. 
    --주의점1 : 오라클 설치 서버에 동일 경로의 디렉토리를 생성: mkdir /DATA, mkdir /EXPORTPUMP
    --주의점2 : 해당 디렉토리를 오라클 쓰기권한 부여 : chmod 777 /DATA, chmod 777 /DATA/EXPORTPUMP
--3)디렉토리 오브젝트에 대한 권한 설정
    GRANT READ,WRITE ON DIRECTORY TEMP_DIR to receiveuser;
    GRANT READ,WRITE ON DIRECTORY TEMP_DIR to careerpass;

--export dump
--1) 오라클 서버 접속 후 유저를 oracle 로변경
    # su - oracle
--2) /로 이동
    # cd /
--3) dump 파일 export
    # expdp careerpass/careerpass directory=TEMP_DIR dumpfile=careerpass.dmp schemas=careerpass
    -- careerpass계정으로 접속하여 TEMP_DIR의 디렉토리에 careerpass.dmp 파일로 careerpass 스키마의 데이터를 export
    
--import dumop
--1) 오라클 서버 접속 후 유저를 oracle 로변경
    # su - oracle
--2) /로 이동
    # cd /
--3) dump 파일 import
    # impdp receiveuser/receiveuserpw directory=TEMP_DIR dumpfile=careerpass.dmp schemas=careerpass  remap_schema=careerpass:receiveuser
    -- receiveuser계정으로 접속하여 TEMP_DIR의 디렉토리에 careerpass.dmp 파일의 careerpass 스키마의 데이터를 스키마이름을 receiveuser로 바꾸어서 import

