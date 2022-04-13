DROP TABLE "CS_NOTICE" CASCADE CONSTRAINTS;
DROP TABLE "CS_FAQ" CASCADE CONSTRAINTS;
DROP TABLE "ADMIN" CASCADE CONSTRAINTS;
DROP TABLE "ACTI_AREA" CASCADE CONSTRAINTS;
DROP TABLE "AREA" CASCADE CONSTRAINTS;
DROP TABLE "TEACH_OBJECT" CASCADE CONSTRAINTS;
DROP TABLE "OBJECT" CASCADE CONSTRAINTS;
DROP TABLE "LIKE" CASCADE CONSTRAINTS;
DROP TABLE "MEMBER_STUDENT" CASCADE CONSTRAINTS;
DROP TABLE "T_RECOMMENT" CASCADE CONSTRAINTS;
DROP TABLE "T_PROFILE" CASCADE CONSTRAINTS;
DROP TABLE "Q_BOARD_FILE" CASCADE CONSTRAINTS;
DROP TABLE "Q_RECOMMENT" CASCADE CONSTRAINTS;
DROP TABLE "BOARD_REPORT" CASCADE CONSTRAINTS;
DROP TABLE "Q_BOARD" CASCADE CONSTRAINTS;
DROP TABLE "MEMBER_REPORT" CASCADE CONSTRAINTS;
DROP TABLE "ALARM" CASCADE CONSTRAINTS;
DROP TABLE "CHECK_MONEY" CASCADE CONSTRAINTS;
DROP TABLE "MEMBER" CASCADE CONSTRAINTS;

CREATE TABLE "MEMBER" (
	"M_ID"	VARCHAR2(15)		NOT NULL,
	"M_PW"	VARCHAR2(20)		NOT NULL,
	"M_NAME"	VARCHAR2(60)		NOT NULL,
	"M_NICKNAME"	VARCHAR2(60)		NOT NULL,
	"M_BIRTH"	VARCHAR2(6)		NOT NULL,
	"M_ADDRESS"	VARCHAR2(200)		NULL,
	"M_PHONE"	VARCHAR2(13)		NOT NULL,
	"M_EMAIL"	VARCHAR2(100)		NOT NULL,
	"GENDER_FM"	CHAR(1)		NOT NULL,
	"ROLE_ST"	CHAR(1)		NOT NULL,
	"M_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"M_CERTIFICATE"	BLOB		NULL
);

COMMENT ON COLUMN "MEMBER"."M_NICKNAME" IS 'UNIQUE';

COMMENT ON COLUMN "MEMBER"."M_PHONE" IS 'UNIQUE';

COMMENT ON COLUMN "MEMBER"."M_EMAIL" IS 'UNIQUE';

COMMENT ON COLUMN "MEMBER"."GENDER_FM" IS '여자 :F 남자 : M';

COMMENT ON COLUMN "MEMBER"."ROLE_ST" IS '학생:S 선생:T';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"M_ID"
);



CREATE TABLE "CHECK_MONEY" (
	"CM_NO"	NUMBER		NOT NULL,
	"CM_CONTENT"	VARCHAR2(30)		NOT NULL,
	"CM_CASH"	NUMBER	DEFAULT 0	NOT NULL,
	"CM_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

ALTER TABLE "CHECK_MONEY" ADD CONSTRAINT "PK_CHECK_MONEY" PRIMARY KEY (
	"CM_NO"
);

CREATE TABLE "ALARM" (
	"ALARM_NO"	NUMBER		NOT NULL,
	"ALARM_CONTENT"	VARCHAR2(600)		NOT NULL,
	"ALARM_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ALARM_SENDID"	VARCHAR2(15)		NOT NULL,
	"ALARM_RECIVEID"	VARCHAR2(15)		NOT NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "ALARM"."ALARM_SENDID" IS 'MEMBER(M_NICKNAME)';

ALTER TABLE "ALARM" ADD CONSTRAINT "PK_ALARM" PRIMARY KEY (
	"ALARM_NO"
);

CREATE TABLE "MEMBER_REPORT" (
	"M_R_NO"	NUMBER		NOT NULL,
	"M_R_SENDID"	VARCHAR2(15)		NOT NULL,
	"M_R_RECIVEID"	VARCHAR2(15)		NOT NULL,
	"M_R_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"M_R_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "MEMBER_REPORT"."M_R_SENDID" IS 'MEMBER(M_NICKNAME)';

CREATE TABLE "Q_BOARD" (
	"B_NO"	NUMBER		NOT NULL,
	"B_CATEGORY"	VARCHAR2(30)		NOT NULL,
	"B_TITLE"	VARCHAR2(300)		NOT NULL,
	"B_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"B_WRITER"	VARCHAR2(60)		NOT NULL,
	"B_WRITE_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"B_CNT"	NUMBER	DEFAULT 0	NOT NULL,
	"B_REPORT_CNT"	NUMBER	DEFAULT 0	NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "Q_BOARD"."B_WRITER" IS 'MEMBER(M_NICKNAME)';

ALTER TABLE "Q_BOARD" ADD CONSTRAINT "PK_Q_BOARD" PRIMARY KEY (
	"B_NO"
);

CREATE TABLE "BOARD_REPORT" (
	"B_R_NO"	NUMBER		NOT NULL,
	"B_NO"	NUMBER		NOT NULL,
	"B_R_CATEGORY"	VARCHAR2(100)		NOT NULL,
	"B_R_WRITER"	VARCHAR2(60)		NOT NULL,
	"B_R_WRITE_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

ALTER TABLE "BOARD_REPORT" ADD CONSTRAINT "PK_BOARD_REPORT" PRIMARY KEY (
	"B_R_NO",
	"B_NO"
);

CREATE TABLE "Q_RECOMMENT" (
	"R_NO"	NUMBER		NOT NULL,
	"R_CONTENT"	VARCHAR2(300)		NOT NULL,
	"R_WRITER"	VARCHAR2(60)		NOT NULL,
	"R_WRITE_DATE"	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP	NOT NULL,
	"R_REPORT_CNT"	NUMBER	DEFAULT 0	NULL,
	"B_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "Q_RECOMMENT"."R_WRITER" IS 'MEMBER(M_NICKNAME)';

ALTER TABLE "Q_RECOMMENT" ADD CONSTRAINT "PK_Q_RECOMMENT" PRIMARY KEY (
	"R_NO"
);

CREATE TABLE "Q_BOARD_FILE" (
	"F_NO"	NUMBER		NOT NULL,
	"B_NO"	NUMBER		NOT NULL,
	"F_NAME"	VARCHAR2(100)		NOT NULL,
	"F_PATH"	VARCHAR2(500)		NOT NULL,
	"F_SIZE"	NUMBER		NOT NULL
);

ALTER TABLE "Q_BOARD_FILE" ADD CONSTRAINT "PK_Q_BOARD_FILE" PRIMARY KEY (
	"F_NO",
	"B_NO"
);

CREATE TABLE "T_PROFILE" (
	"T_NO"	VARCHAR2(5)		NOT NULL,
	"T_MAJOR"	VARCHAR2(100)		NOT NULL,
	"ONLINE_YNA"	CHAR(1)		NOT NULL,
	"T_TCNT"	VARCHAR2(20)	DEFAULT '협의'	NULL,
	"T_TPRICE"	VARCHAR2(20)	DEFAULT '협의'	NULL,
	"T_WANTSTUD"	VARCHAR2(10)	DEFAULT '무관'	NULL,
	"T_CAREER"	VARCHAR2(20)	DEFAULT '없음'	NULL,
	"T_LANGUAGE"	VARCHAR2(20)	DEFAULT '없음'	NULL,
	"T_SPECIAL"	VARCHAR2(300)	DEFAULT '없음'	NULL,
	"T_APPROVAL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"T_PERMIT_YN"	CHAR(1)		NOT NULL,
	"T_PICTURE"	BLOB		NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL,
	"T_INTRO"	VARCHAR2(300)	DEFAULT '없음'	NULL,
	"T_RECRUIT_YN"	CHAR(1)	NOT NULL
);

COMMENT ON COLUMN "T_PROFILE"."T_NO" IS 'T1, T2 ....';

COMMENT ON COLUMN "T_PROFILE"."ONLINE_YNA" IS '온라인Y, 오프라인N,모두A';

COMMENT ON COLUMN "T_PROFILE"."T_APPROVAL" IS '승인Y, 승인아니면N';

COMMENT ON COLUMN "T_PROFILE"."T_PERMIT_YN" IS '허용Y, 아니면N';

COMMENT ON COLUMN "T_PROFILE"."T_PICTURE" IS '용량: 미정';

ALTER TABLE "T_PROFILE" ADD CONSTRAINT "PK_T_PROFILE" PRIMARY KEY (
	"T_NO"
);


CREATE TABLE "T_RECOMMENT" (
	"T_R_NO"	NUMBER		NOT NULL,
	"T_NO"	VARCHAR2(5)		NOT NULL,
	"T_R_CONTENT"	VARCHAR2(300)		NOT NULL,
	"T_R_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"T_R_SCORE"	NUMBER	DEFAULT 0	NOT NULL
);

COMMENT ON COLUMN "T_RECOMMENT"."T_NO" IS 'T1, T2 ....';

ALTER TABLE "T_RECOMMENT" ADD CONSTRAINT "PK_T_RECOMMENT" PRIMARY KEY (
	"T_R_NO",
	"T_NO"
);

CREATE TABLE "MEMBER_STUDENT" (
	"S_NO"	VARCHAR2(5)		NOT NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "MEMBER_STUDENT"."S_NO" IS 'S1, S2,...';


CREATE TABLE "LIKE" (
	"T_NO"	VARCHAR2(5)		NOT NULL,
	"S_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "LIKE"."T_NO" IS 'T1,T2,...';

COMMENT ON COLUMN "LIKE"."S_NO" IS 'S1, S2,...';


CREATE TABLE "OBJECT" (
	"OB_CODE"	VARCHAR2(5)		NOT NULL,
	"OB_NAME"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "OBJECT"."OB_CODE" IS 'OB1,OB2,..';


CREATE TABLE "TEACH_OBJECT" (
	"OB_CODE"	VARCHAR2(5)		NOT NULL,
	"T_NO"	VARCHAR2(5)		NOT NULL
);

COMMENT ON COLUMN "TEACH_OBJECT"."OB_CODE" IS 'OBJECT(OB_CODE)';

COMMENT ON COLUMN "TEACH_OBJECT"."T_NO" IS 'T1, T2 ....';


CREATE TABLE "AREA" (
	"AREA_CODE"	VARCHAR2(5)		NOT NULL,
	"AREA_NAME"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "AREA"."AREA_CODE" IS 'A1,A2,..';


CREATE TABLE "ACTI_AREA" (
	"T_NO"	VARCHAR2(5)		NOT NULL,
	"AREA_CODE"	VARCHAR2(5)		NOT NULL
);

COMMENT ON COLUMN "ACTI_AREA"."T_NO" IS 'T_PROFILE(T_NO)';

COMMENT ON COLUMN "ACTI_AREA"."AREA_CODE" IS 'AREA(AREA_CODE)';


CREATE TABLE "ADMIN" (
	"ADMIN_ID"	VARCHAR2(15)		NOT NULL,
	"ADMIN_PW"	VARCHAR2(20)		NOT NULL
);

ALTER TABLE "ADMIN" ADD CONSTRAINT "PK_ADMIN" PRIMARY KEY (
	"ADMIN_ID"
);

CREATE TABLE "CS_FAQ" (
	"FAQ_NO"	NUMBER		NOT NULL,
	"FAQ_QUESTION"	VARCHAR2(300)		NOT NULL,
	"FAQ_ANSWER"	VARCHAR2(3000)		NOT NULL,
	"ADMIN_ID"	VARCHAR2(15)		NOT NULL,
	"FAQ_CNT"	NUMBER	DEFAULT 0	NOT NULL
);
ALTER TABLE "CS_FAQ" ADD CONSTRAINT "PK_CS_FAQ" PRIMARY KEY (
	"FAQ_NO"
);


CREATE TABLE "CS_NOTICE" (
	"NOTICE_NO"	NUMBER		NOT NULL,
	"NOTICE_TITLE"	VARCHAR2(300)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"NOTICE_CNT"	NUMBER	DEFAULT 0	NOT NULL,
	"NOTICE_WRITE_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ADMIN_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "CS_NOTICE"."ADMIN_ID" IS 'ADMIN(ADMIN_ID)';

ALTER TABLE "CS_NOTICE" ADD CONSTRAINT "PK_CS_NOTICE" PRIMARY KEY (
	"NOTICE_NO"
);


ALTER TABLE "MEMBER_REPORT" ADD CONSTRAINT "PK_MEMBER_REPORT" PRIMARY KEY (
	"M_R_NO"
);

ALTER TABLE "OBJECT" ADD CONSTRAINT "PK_OBJECT" PRIMARY KEY (
	"OB_CODE"
);

ALTER TABLE "AREA" ADD CONSTRAINT "PK_AREA" PRIMARY KEY (
	"AREA_CODE"
);

ALTER TABLE "MEMBER_STUDENT" ADD CONSTRAINT "PK_MEMBER_STUDENT" PRIMARY KEY (
	"S_NO"
);

ALTER TABLE "Q_BOARD" ADD CONSTRAINT "FK_MEMBER_TO_Q_BOARD_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;

ALTER TABLE "Q_RECOMMENT" ADD CONSTRAINT "FK_Q_BOARD_TO_Q_RECOMMENT_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
) ON DELETE CASCADE;

ALTER TABLE "T_PROFILE" ADD CONSTRAINT "FK_MEMBER_TO_T_PROFILE_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;

ALTER TABLE "CS_NOTICE" ADD CONSTRAINT "FK_ADMIN_TO_CS_NOTICE_1" FOREIGN KEY (
	"ADMIN_ID"
)
REFERENCES "ADMIN" (
	"ADMIN_ID"
) ON DELETE CASCADE;

ALTER TABLE "CS_FAQ" ADD CONSTRAINT "FK_ADMIN_TO_CS_FAQ_1" FOREIGN KEY (
	"ADMIN_ID"
)
REFERENCES "ADMIN" (
	"ADMIN_ID"
) ON DELETE CASCADE;

ALTER TABLE "BOARD_REPORT" ADD CONSTRAINT "FK_Q_BOARD_TO_BOARD_REPORT_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
) ON DELETE CASCADE;

ALTER TABLE "LIKE" ADD CONSTRAINT "PK_LIKE" PRIMARY KEY (
	"S_NO",
	"T_NO"
);
ALTER TABLE "LIKE" ADD CONSTRAINT "FK_MEMBER_STUDENT_TO_LIKE_1" FOREIGN KEY (
	"S_NO"
)
REFERENCES "MEMBER_STUDENT" (
	"S_NO"
) ON DELETE CASCADE;
ALTER TABLE "LIKE" ADD CONSTRAINT "FK_T_PROFILE_TO_LIKE_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
) ON DELETE CASCADE;
ALTER TABLE "T_RECOMMENT" ADD CONSTRAINT "FK_T_PROFILE_TO_T_RECOMMENT_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
) ON DELETE CASCADE;

ALTER TABLE "CHECK_MONEY" ADD CONSTRAINT "FK_MEMBER_TO_CHECK_MONEY_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;

ALTER TABLE "ALARM" ADD CONSTRAINT "FK_MEMBER_TO_ALARM_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;

ALTER TABLE "Q_BOARD_FILE" ADD CONSTRAINT "FK_Q_BOARD_TO_Q_BOARD_FILE_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
) ON DELETE CASCADE;

ALTER TABLE "MEMBER_REPORT" ADD CONSTRAINT "FK_MEMBER_TO_MEMBER_REPORT_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;

ALTER TABLE "TEACH_OBJECT" ADD CONSTRAINT "FK_OBJECT_TO_TEACH_OBJECT_1" FOREIGN KEY (
	"OB_CODE"
)
REFERENCES "OBJECT" (
	"OB_CODE"
) ON DELETE CASCADE;

ALTER TABLE "TEACH_OBJECT" ADD CONSTRAINT "FK_T_PROFILE_TO_TEACH_OBJECT_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
) ON DELETE CASCADE;

ALTER TABLE "ACTI_AREA" ADD CONSTRAINT "FK_T_PROFILE_TO_ACTI_AREA_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
) ON DELETE CASCADE;

ALTER TABLE "ACTI_AREA" ADD CONSTRAINT "FK_AREA_TO_ACTI_AREA_1" FOREIGN KEY (
	"AREA_CODE"
)
REFERENCES "AREA" (
	"AREA_CODE"
) ON DELETE CASCADE;

ALTER TABLE "MEMBER_STUDENT" ADD CONSTRAINT "FK_MEMBER_TO_MEMBER_STUDENT_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
) ON DELETE CASCADE;


-- 학생 삽입
insert into MEMBER(M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE,M_EMAIL,GENDER_FM,ROLE_ST,M_DATE) VALUES('a12345','a12345678','홍길동','홍기','111111','서울시관악구신림동50','010-1111-1111','aaa@gmail.com','F','S',default); 
insert into MEMBER(M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE,M_EMAIL,GENDER_FM,ROLE_ST,M_DATE) VALUES('b12345','b12345678','이민호','민호','222222','경기도 부천시 심곡본동 340','010-2211-1111','bbb@gmail.com','F','S',default);

-- 선생님 삽입
insert into MEMBER(M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE,M_EMAIL,GENDER_FM,ROLE_ST,M_DATE) VALUES('c12345','c12345678','이영희','영희쌤','333333','서울시 강남구 논현동 224','010-3311-1111','ccc@gmail.com','M','T',default); 
insert into MEMBER(M_ID, M_PW, M_NAME, M_NICKNAME, M_BIRTH, M_ADDRESS, M_PHONE,M_EMAIL,GENDER_FM,ROLE_ST,M_DATE) VALUES('d12345','d12345678','김보미','보미쌤','444444','서울시 용산구 한남동 24','010-4411-1111','ddd@gmail.com','M','T',default); 

-- 학생 정보 삽입
insert into MEMBER_STUDENT VALUES('S1', 'a12345');
insert into MEMBER_STUDENT VALUES('S2', 'b12345');

-- 지역코드 삽입
insert into AREA values('A1', '강남구');
insert into AREA values('A2', '강동구');
insert into AREA values('A3', '강북구');
insert into AREA values('A4', '강서구');
insert into AREA values('A5', '관악구');
insert into AREA values('A6', '광진구');
insert into AREA values('A7', '구로구');
insert into AREA values('A8', '금천구');
insert into AREA values('A9', '노원구');
insert into AREA values('A10', '도봉구');
insert into AREA values('A11', '동대문구');
insert into AREA values('A12', '동작구');
insert into AREA values('A13', '마포구');
insert into AREA values('A14', '서대문구');
insert into AREA values('A15', '서초구');
insert into AREA values('A16', '성동구');
insert into AREA values('A17', '성북구');
insert into AREA values('A18', '송파구');
insert into AREA values('A19', '양천구');
insert into AREA values('A20', '영등포구');
insert into AREA values('A21', '용산구');
insert into AREA values('A22', '은평구');
insert into AREA values('A23', '종로구');
insert into AREA values('A24', '중구');
insert into AREA values('A25', '중랑구');

--과목코드 삽입
insert into object(ob_code, ob_name) VALUES('OB1', '국어');
insert into object(ob_code, ob_name) VALUES('OB2', '수학');
insert into object(ob_code, ob_name) VALUES('OB3', '영어');
insert into object(ob_code, ob_name) VALUES('OB4', '사회');
insert into object(ob_code, ob_name) VALUES('OB5', '과학');
insert into object(ob_code, ob_name) VALUES('OB6', '기타');

--ADMIN TABLE
INSERT INTO ADMIN(ADMIN_ID, ADMIN_PW) VALUES('IGLOVE','IGIG');

--고객센터 자주묻는질문 삽입
insert into CS_FAQ(FAQ_NO, FAQ_QUESTION, FAQ_ANSWER, ADMIN_ID, FAQ_CNT) VALUES(1,'QUESTION_ONE', 'ANSWER_TWO', 'IGLOVE', DEFAULT); 
insert into CS_FAQ(FAQ_NO, FAQ_QUESTION, FAQ_ANSWER, ADMIN_ID, FAQ_CNT) VALUES(2,'QUESTION_ONE', 'ANSWER_TWO', 'IGLOVE', DEFAULT); 

--고객센터 공지사항 삽입
insert into CS_NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_CNT, NOTICE_WRITE_DATE, ADMIN_ID) VALUES(1,'연필 가격 인상', '제목과 같습니다',DEFAULT,DEFAULT, 'IGLOVE'); 
insert into CS_NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_CNT, NOTICE_WRITE_DATE, ADMIN_ID) VALUES(2,'연필 가격 인하', '제목과 같습니다',DEFAULT,DEFAULT, 'IGLOVE'); 

--게시글 삽입
INSERT INTO Q_BOARD(B_NO, B_CATEGORY,B_TITLE,B_CONTENT,B_WRITER,B_WRITE_DATE,B_CNT,B_REPORT_CNT,M_ID) VALUES(1,'질문하기','궁금해요','제목이 곧 내용','김인곤',default,default,default,'a12345');
INSERT INTO Q_BOARD(B_NO, B_CATEGORY,B_TITLE,B_CONTENT,B_WRITER,B_WRITE_DATE,B_CNT,B_REPORT_CNT,M_ID) VALUES(2,'질문하기','궁금해요ㅜ','제목이 곧 내용','김인곤',default,default,default,'a12345');

--게시글 신고
INSERT INTO BOARD_REPORT(B_R_NO,B_NO,B_R_CATEGORY,B_R_WRITER,B_R_WRITE_DATE) VALUES(1,1,'광고','김인곤',default);

--질문하기 게시판 댓글
INSERT INTO Q_RECOMMENT(R_NO,R_CONTENT,R_WRITER,R_WRITE_DATE,R_REPORT_CNT,B_NO) VALUES(1,'신고할게요','김인곤',default,default,1);

-- 선생님정보 삽입
insert into t_profile VALUES('T1', '서울대학교 기계공학과 졸업', 'A', '주 2회', '월 30만원', default, default, '토익 850', default, default, 'N', null, 'c12345', '열심히 하겠습니다!', 'Y');
insert into t_profile VALUES('T2', '이화여자대학교 경영학과 휴학중', 'Y', '주 2회', '월 20만원', default, default, default, default, default, 'Y', null, 'd12345', '눈높이 교육', 'N');

-- 선생님 담당 과목 삽입
insert into teach_object VALUES('OB2', 'T1');
insert into teach_object VALUES('OB5', 'T1');
insert into teach_object VALUES('OB1', 'T2');
insert into teach_object VALUES('OB4', 'T2');

-- 선생님 활동 지역 삽입
insert into acti_area VALUES('T1', 'A1');
insert into acti_area VALUES('T1', 'A2');
insert into acti_area VALUES('T2', 'A3');
insert into acti_area VALUES('T2', 'A4');

-- 선생님 리뷰 삽입
insert into t_recomment VALUES(1, 'T1', '친절하고 자세하게 알려주세요!', default, 5);
insert into t_recomment VALUES(2, 'T2', '좋습니다.', default, 3);