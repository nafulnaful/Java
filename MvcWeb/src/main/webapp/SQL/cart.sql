ALTER TABLE CART
   DROP
      CONSTRAINT FK_Product_TO_CART
      CASCADE;

ALTER TABLE CART
   DROP
      CONSTRAINT FK_member_TO_CART
      CASCADE;

ALTER TABLE CART
   DROP
      PRIMARY KEY
      CASCADE
      KEEP INDEX;

DROP INDEX PK_CART;

/* 장바구니 */
DROP TABLE CART 
   CASCADE CONSTRAINTS;

/* 장바구니 */
CREATE TABLE CART (
   cartNum NUMBER(8) NOT NULL, /* 장바구니번호 */
   oqty NUMBER(8), /* 수량 */
   indate DATE, /* 등록일 */
   pnum NUMBER(8), /* 상품번호 */
   idx NUMBER(8) /* 회원번호 */
);

COMMENT ON TABLE CART IS '장바구니';

COMMENT ON COLUMN CART.cartNum IS '장바구니번호';

COMMENT ON COLUMN CART.oqty IS '수량';

COMMENT ON COLUMN CART.indate IS '등록일';

COMMENT ON COLUMN CART.pnum IS '상품번호';

COMMENT ON COLUMN CART.idx IS '회원번호';

CREATE UNIQUE INDEX PK_CART
   ON CART (
      cartNum ASC
   );

ALTER TABLE CART
   ADD
      CONSTRAINT PK_CART
      PRIMARY KEY (
         cartNum
      );

ALTER TABLE CART
   ADD
      CONSTRAINT FK_Product_TO_CART
      FOREIGN KEY (
         pnum
      )
      REFERENCES Product (
         pnum
      );

ALTER TABLE CART
   ADD
      CONSTRAINT FK_member_TO_CART
      FOREIGN KEY (
         idx
      )
      REFERENCES member (
         idx
      );