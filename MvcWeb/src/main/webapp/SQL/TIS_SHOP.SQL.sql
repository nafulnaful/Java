ALTER TABLE upCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_upCategory;

/* 상위카테고리 */
DROP TABLE upCategory 
	CASCADE CONSTRAINTS;

/* 상위카테고리 */
CREATE TABLE upCategory (
	upcg_code NUMBER(8) NOT NULL, /* 상위카테고리코드 */
	upcg_name VARCHAR2(30) NOT NULL /* 상위카테고리명 */
);

COMMENT ON TABLE upCategory IS '상위카테고리';

COMMENT ON COLUMN upCategory.upcg_code IS '상위카테고리코드';

COMMENT ON COLUMN upCategory.upcg_name IS '상위카테고리명';

CREATE UNIQUE INDEX PK_upCategory
	ON upCategory (
		upcg_code ASC
	);

ALTER TABLE upCategory
	ADD
		CONSTRAINT PK_upCategory
		PRIMARY KEY (
			upcg_code
		);
-------------------------------------------------------------
ALTER TABLE downCategory
	DROP
		CONSTRAINT FK_upCategory_TO_downCategory
		CASCADE;

ALTER TABLE downCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_downCategory;

/* 하위 카테고리 */
DROP TABLE downCategory 
	CASCADE CONSTRAINTS;

/* 하위 카테고리 */
CREATE TABLE downCategory (
	downcg_code NUMBER(8) NOT NULL, /* 하위 카테고리 코드 */
	downcg_name VARCHAR2(30) NOT NULL, /* 하위 카테고리명 */
	upcg_code NUMBER(8) NOT NULL /* 상위카테고리코드 */
);

COMMENT ON TABLE downCategory IS '하위 카테고리';

COMMENT ON COLUMN downCategory.downcg_code IS '하위 카테고리 코드';

COMMENT ON COLUMN downCategory.downcg_name IS '하위 카테고리명';

COMMENT ON COLUMN downCategory.upcg_code IS '상위카테고리코드';

CREATE UNIQUE INDEX PK_downCategory
	ON downCategory (
		downcg_code ASC
	);

ALTER TABLE downCategory
	ADD
		CONSTRAINT PK_downCategory
		PRIMARY KEY (
			downcg_code
		);

ALTER TABLE downCategory
	ADD
		CONSTRAINT FK_upCategory_TO_downCategory
		FOREIGN KEY (
			upcg_code
		)
		REFERENCES upCategory (
			upcg_code
		);
------------------------------------------------
ALTER TABLE Product
	DROP
		CONSTRAINT FK_downCategory_TO_Product
		CASCADE;

ALTER TABLE Product
	DROP
		CONSTRAINT FK_upCategory_TO_Product
		CASCADE;

ALTER TABLE Product
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_Product;

/* 상품 */
DROP TABLE Product 
	CASCADE CONSTRAINTS;

/* 상품 */
CREATE TABLE Product (
	pnum NUMBER(8) NOT NULL, /* 상품번호 */
	pname VARCHAR2(100) NOT NULL, /* 상품명 */
	pcompany VARCHAR2(50), /* 제조사 */
	pimage1 VARCHAR2(100), /* 상품이미지1 */
	pimage2 VARCHAR2(100), /* 상품이미지2 */
	pimage3 VARCHAR2(100), /* 상품이미지3 */
	pqty NUMBER(8), /* 보유수량 */
	price NUMBER(8) NOT NULL, /* 정가 */
	saleprice NUMBER(8) NOT NULL, /* 판매가 */
	pspec VARCHAR2(20), /* 상품스펙 */
	pcontents VARCHAR2(1000), /* 상세설명 */
	point NUMBER(8), /* 포인트 */
	pindate DATE NOT NULL, /* 상품입고일 */
	downcg_code NUMBER(8), /* 하위 카테고리 코드 */
	upcg_code NUMBER(8) /* 상위카테고리코드 */
);

COMMENT ON TABLE Product IS '상품';

COMMENT ON COLUMN Product.pnum IS '상품번호';

COMMENT ON COLUMN Product.pname IS '상품명';

COMMENT ON COLUMN Product.pcompany IS '제조사';

COMMENT ON COLUMN Product.pimage1 IS '상품이미지1';

COMMENT ON COLUMN Product.pimage2 IS '상품이미지2';

COMMENT ON COLUMN Product.pimage3 IS '상품이미지3';

COMMENT ON COLUMN Product.pqty IS '보유수량';

COMMENT ON COLUMN Product.price IS '정가';

COMMENT ON COLUMN Product.saleprice IS '판매가';

COMMENT ON COLUMN Product.pspec IS '상품스펙';

COMMENT ON COLUMN Product.pcontents IS '상세설명';

COMMENT ON COLUMN Product.point IS '포인트';

COMMENT ON COLUMN Product.pindate IS '상품입고일';

COMMENT ON COLUMN Product.downcg_code IS '하위 카테고리 코드';

COMMENT ON COLUMN Product.upcg_code IS '상위카테고리코드';

CREATE UNIQUE INDEX PK_Product
	ON Product (
		pnum ASC
	);

ALTER TABLE Product
	ADD
		CONSTRAINT PK_Product
		PRIMARY KEY (
			pnum
		);

ALTER TABLE Product
	ADD
		CONSTRAINT FK_downCategory_TO_Product
		FOREIGN KEY (
			downcg_code
		)
		REFERENCES downCategory (
			downcg_code
		);

ALTER TABLE Product
	ADD
		CONSTRAINT FK_upCategory_TO_Product
		FOREIGN KEY (
			upcg_code
		)
		REFERENCES upCategory (
			upcg_code
		);


grant all on memo to tis_shop;

grant all on memo_seq to tis_shop;

select * from memo order by idx desc;
--시퀀스 생성------------------------------
CREATE SEQUENCE UPCATEGORY_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE DOWNCATEGORY_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE PRODUCT_SEQ NOCACHE;
--------------------------------------------


INSERT INTO UPCATEGORY(UPCG_CODE, UPCG_NAME)
VALUES(UPCATEGORY_SEQ.NEXTVAL,'전자제품');

INSERT INTO UPCATEGORY(UPCG_CODE, UPCG_NAME)
VALUES(UPCATEGORY_SEQ.NEXTVAL,'생활용품');
COMMIT;

INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'컴퓨터/노트북', 1);
INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'냉장고', 1);

INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'주방세제', 2);
INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'휴지', 2);
COMMIT;

SELECT * FROM UPCATEGORY;
SELECT * FROM DOWNCATEGORY;








        