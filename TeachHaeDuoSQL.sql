﻿DROP TABLE "CS_NOTICE";
DROP TABLE "CS_FAQ";
DROP TABLE "ADMIN";
DROP TABLE "ACTI_AREA";
DROP TABLE "AREA";
DROP TABLE "TEACH_OBJECT";
DROP TABLE "OBJECT";
DROP TABLE "LIKE";
DROP TABLE "Member_Student";
DROP TABLE "T_RECOMMENT";
DROP TABLE "T_PROFILE";
DROP TABLE "Q_BOARD_FILE";
DROP TABLE "Q_RECOMMENT";
DROP TABLE "BOARD_REPORT";
DROP TABLE "Q_BOARD";
DROP TABLE "MEMBER_REPORT";
DROP TABLE "ALARM";
DROP TABLE "CHECK_MONEY";
DROP TABLE "MEMBER";





CREATE TABLE "MEMBER" (
	"M_ID"	VARCHAR2(15)		NOT NULL,
	"M_PW"	VARCHAR2(20)		NOT NULL,
	"M_NAME"	VARCHAR2(60)		NOT NULL,
	"M_NICKNAME"	VARCHAR2(60)		NOT NULL,
	"M_SSAN"	VARCHAR2(6)		NOT NULL,
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
	"M_ID"	VARCHAR2(15)		NOT NULL
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

CREATE TABLE "Member_Student" (
	"S_NO"	VARCHAR2(10)		NOT NULL,
	"M_ID"	VARCHAR2(15)		NOT NULL
);

COMMENT ON COLUMN "Member_Student"."S_NO" IS 'S1, S2,...';


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

ALTER TABLE "Member_Student" ADD CONSTRAINT "PK_MEMBER_STUDENT" PRIMARY KEY (
	"S_NO"
);

ALTER TABLE "Q_BOARD" ADD CONSTRAINT "FK_MEMBER_TO_Q_BOARD_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

ALTER TABLE "Q_RECOMMENT" ADD CONSTRAINT "FK_Q_BOARD_TO_Q_RECOMMENT_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
);

ALTER TABLE "T_PROFILE" ADD CONSTRAINT "FK_MEMBER_TO_T_PROFILE_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

ALTER TABLE "CS_NOTICE" ADD CONSTRAINT "FK_ADMIN_TO_CS_NOTICE_1" FOREIGN KEY (
	"ADMIN_ID"
)
REFERENCES "ADMIN" (
	"ADMIN_ID"
);

ALTER TABLE "CS_FAQ" ADD CONSTRAINT "FK_ADMIN_TO_CS_FAQ_1" FOREIGN KEY (
	"ADMIN_ID"
)
REFERENCES "ADMIN" (
	"ADMIN_ID"
);

ALTER TABLE "BOARD_REPORT" ADD CONSTRAINT "FK_Q_BOARD_TO_BOARD_REPORT_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
);

ALTER TABLE "LIKE" ADD CONSTRAINT "FK_T_PROFILE_TO_LIKE_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
);

ALTER TABLE "LIKE" ADD CONSTRAINT "FK_Member_Student_TO_LIKE_1" FOREIGN KEY (
	"S_NO"
)
REFERENCES "Member_Student" (
	"S_NO"
);

ALTER TABLE "T_RECOMMENT" ADD CONSTRAINT "FK_T_PROFILE_TO_T_RECOMMENT_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
);

ALTER TABLE "CHECK_MONEY" ADD CONSTRAINT "FK_MEMBER_TO_CHECK_MONEY_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

ALTER TABLE "ALARM" ADD CONSTRAINT "FK_MEMBER_TO_ALARM_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

ALTER TABLE "Q_BOARD_FILE" ADD CONSTRAINT "FK_Q_BOARD_TO_Q_BOARD_FILE_1" FOREIGN KEY (
	"B_NO"
)
REFERENCES "Q_BOARD" (
	"B_NO"
);

ALTER TABLE "MEMBER_REPORT" ADD CONSTRAINT "FK_MEMBER_TO_MEMBER_REPORT_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

ALTER TABLE "TEACH_OBJECT" ADD CONSTRAINT "FK_OBJECT_TO_TEACH_OBJECT_1" FOREIGN KEY (
	"OB_CODE"
)
REFERENCES "OBJECT" (
	"OB_CODE"
);

ALTER TABLE "TEACH_OBJECT" ADD CONSTRAINT "FK_T_PROFILE_TO_TEACH_OBJECT_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
);

ALTER TABLE "ACTI_AREA" ADD CONSTRAINT "FK_T_PROFILE_TO_ACTI_AREA_1" FOREIGN KEY (
	"T_NO"
)
REFERENCES "T_PROFILE" (
	"T_NO"
);

ALTER TABLE "ACTI_AREA" ADD CONSTRAINT "FK_AREA_TO_ACTI_AREA_1" FOREIGN KEY (
	"AREA_CODE"
)
REFERENCES "AREA" (
	"AREA_CODE"
);

ALTER TABLE "Member_Student" ADD CONSTRAINT "FK_MEMBER_TO_Member_Student_1" FOREIGN KEY (
	"M_ID"
)
REFERENCES "MEMBER" (
	"M_ID"
);

