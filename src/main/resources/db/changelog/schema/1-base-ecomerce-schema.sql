-- liquibase formatted sql

-- changeset andygm:1-base-ecomerce-schema

CREATE TABLE `BRAND`
(
    `ID`   bigint       NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `NAME` varchar(100) NOT NULL COMMENT 'Brand''s name',
    PRIMARY KEY (`ID`)
);

CREATE TABLE `PRODUCT`
(
    `ID`   bigint       NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `NAME` varchar(100) NOT NULL COMMENT 'Product''s name',
    PRIMARY KEY (`ID`)
);

CREATE TABLE `PRICE`
(
    `PRICE_LIST` bigint     NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `START_DATE` datetime   NOT NULL COMMENT 'Start date for price record',
    `END_DATE`   datetime   NOT NULL COMMENT 'End date for price record',
    `BRAND_ID`   bigint     NOT NULL COMMENT 'Brand ID',
    `PRODUCT_ID` bigint     NOT NULL COMMENT 'Product ID',
    `PRIORITY`   int        NOT NULL COMMENT 'Price priority',
    `PRICE`      double     NOT NULL COMMENT 'Price to apply',
    `CURRENCY`   varchar(3) NOT NULL COMMENT 'Currency´s ISO',
    PRIMARY KEY (`PRICE_LIST`)
);

ALTER TABLE `PRICE` ADD CONSTRAINT `FK_BRAND_ID__BRAND` FOREIGN KEY (`BRAND_ID`) REFERENCES `BRAND` (`ID`);
ALTER TABLE `PRICE` ADD CONSTRAINT `FK_PRODUCT_ID__PRODUCT` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCT` (`ID`);
