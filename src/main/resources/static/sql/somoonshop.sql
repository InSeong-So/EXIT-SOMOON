-- --------------------------------------------------------
-- 호스트:                          192.168.0.5
-- 서버 버전:                        10.3.11-MariaDB-1:10.3.11+maria~bionic - mariadb.org binary distribution
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- somoon 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `somoon` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `somoon`;

-- 테이블 somoon.brand 구조 내보내기
CREATE TABLE IF NOT EXISTS `brand` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_number` varchar(15) NOT NULL COMMENT '제조사 사업자번호',
  `brand_name` varchar(20) NOT NULL COMMENT '제조사명',
  `brand_contact` varchar(13) NOT NULL COMMENT '제조사 연락처',
  `brand_address` varchar(30) NOT NULL COMMENT '제조사 주소',
  `brand_postal_code` varchar(25) NOT NULL COMMENT '제조사 우편번호',
  `bank_code` int(5) NOT NULL COMMENT '거래은행 코드',
  `account_number` varchar(20) NOT NULL COMMENT '계좌번호',
  `depositor` varchar(10) NOT NULL COMMENT '예금주',
  PRIMARY KEY (`brand_number`),
  KEY `인덱스 1` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.delivery 구조 내보내기
CREATE TABLE IF NOT EXISTS `delivery` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `delivery_number` varchar(20) NOT NULL COMMENT '배송번호',
  `parcel_service_number` varchar(20) NOT NULL COMMENT '택배업체 사업자번호',
  `payment` int(11) NOT NULL COMMENT '배송금액',
  `delivery_date` varchar(20) NOT NULL COMMENT '배송일자',
  PRIMARY KEY (`delivery_number`),
  KEY `인덱스 1` (`no`),
  KEY `FK_delivery_parcel_service` (`parcel_service_number`),
  CONSTRAINT `FK_delivery_parcel_service` FOREIGN KEY (`parcel_service_number`) REFERENCES `parcel_service` (`parcel_service_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.fit_product 구조 내보내기
CREATE TABLE IF NOT EXISTS `fit_product` (
  `product_name` varchar(20) NOT NULL,
  `total_length` varchar(10) DEFAULT NULL,
  `shoulder_width` varchar(10) DEFAULT NULL,
  `chest_width` varchar(10) DEFAULT NULL,
  `sleeve_length` varchar(10) DEFAULT NULL,
  `necking` varchar(10) DEFAULT NULL,
  `kidney` varchar(10) DEFAULT NULL,
  `neck_circumference` varchar(10) DEFAULT NULL,
  `overall_arm_length` varchar(10) DEFAULT NULL,
  `bust` varchar(10) DEFAULT NULL,
  `waist_circumference` varchar(10) DEFAULT NULL,
  `hip_circumference` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL COMMENT '아이디',
  `password` varchar(20) NOT NULL COMMENT '비밀번호',
  `name` varchar(10) NOT NULL COMMENT '이름',
  `birthday` varchar(16) NOT NULL COMMENT '생년월일',
  `sex` varchar(1) NOT NULL COMMENT '성별',
  `contact` varchar(20) NOT NULL COMMENT '연락처',
  `address` varchar(30) NOT NULL COMMENT '주소',
  `postal_code` varchar(25) NOT NULL COMMENT '우편번호',
  `email` varchar(30) NOT NULL COMMENT '이메일',
  `agreement` varchar(1) NOT NULL DEFAULT 'y' COMMENT '개인정보동의현황',
  `add_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '가입날짜',
  `point` int(11) NOT NULL COMMENT '포인트',
  `total_length` varchar(10) DEFAULT NULL,
  `shoulder_width` varchar(10) DEFAULT NULL,
  `chest_width` varchar(10) DEFAULT NULL,
  `sleeve_width` varchar(10) DEFAULT NULL,
  `necking` varchar(10) DEFAULT NULL,
  `kidney` varchar(10) DEFAULT NULL,
  `neck_circumference` varchar(10) DEFAULT NULL,
  `overall_arm_length` varchar(10) DEFAULT NULL,
  `bust` varchar(10) DEFAULT NULL,
  `waist_circumference` varchar(10) DEFAULT NULL,
  `hip_circumdference` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `인덱스 2` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.member_temporarily 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_temporarily` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL COMMENT '임시 아이디',
  `password` varchar(20) NOT NULL COMMENT '임시 비밀번호',
  `contact` varchar(13) NOT NULL COMMENT '연락처',
  `address` varchar(30) NOT NULL COMMENT '주소',
  `postal_code` varchar(25) NOT NULL COMMENT '우편번호',
  `delyn` varchar(1) NOT NULL COMMENT '삭제여부',
  PRIMARY KEY (`id`),
  KEY `인덱스 1` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.order 구조 내보내기
CREATE TABLE IF NOT EXISTS `order` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL COMMENT '사용자 아이디',
  `delivery_number` varchar(45) NOT NULL COMMENT '배송번호',
  `order_number` varchar(30) NOT NULL COMMENT '주문번호',
  `order_date` varchar(20) NOT NULL COMMENT '주문일자',
  `delivery_contact` varchar(30) NOT NULL COMMENT '배송지 연락처',
  `delivery_address` varchar(30) NOT NULL COMMENT '배송지 주소',
  `delivery_postal_code` varchar(25) NOT NULL COMMENT '배송지 우편번호',
  `delivery_code` varchar(30) NOT NULL COMMENT '배송방법 코드',
  `delivery_payment` int(1) NOT NULL COMMENT '결제방법',
  `memo` varchar(100) NOT NULL COMMENT '기타사항',
  PRIMARY KEY (`order_number`),
  KEY `인덱스 1` (`no`),
  KEY `FK_order_member` (`id`),
  KEY `FK_order_delivery` (`delivery_number`),
  CONSTRAINT `FK_order_delivery` FOREIGN KEY (`delivery_number`) REFERENCES `delivery` (`delivery_number`),
  CONSTRAINT `FK_order_member` FOREIGN KEY (`id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.parcel_service 구조 내보내기
CREATE TABLE IF NOT EXISTS `parcel_service` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `parcel_service_number` varchar(30) NOT NULL COMMENT '택배업체/사업자번호',
  `parcel_service_name` varchar(20) NOT NULL COMMENT '택배업체명',
  `parcel_service_contact` varchar(13) NOT NULL COMMENT '택배업체 연락처',
  `parcel_service_address` varchar(30) NOT NULL COMMENT '택배업체 주소',
  `parcel_service_postal_code` varchar(25) NOT NULL COMMENT '택배업체 우편번호',
  `bank_code` varchar(20) NOT NULL COMMENT '거래은행 코드',
  `account_number` varchar(20) NOT NULL COMMENT '계좌번호',
  `depositor` varchar(15) NOT NULL COMMENT '예금주',
  PRIMARY KEY (`parcel_service_number`),
  KEY `인덱스 1` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.password_test 구조 내보내기
CREATE TABLE IF NOT EXISTS `password_test` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) NOT NULL,
  `birth_day` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_numb` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `인덱스 2` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(30) NOT NULL COMMENT '상품코드',
  `brand_number` varchar(20) NOT NULL COMMENT '제조사 사업자번호',
  `warehouse_code` varchar(20) NOT NULL COMMENT '창고코드',
  `order_number` varchar(20) NOT NULL COMMENT '주문번호',
  `product_category` int(2) NOT NULL COMMENT '상품구분',
  `product_price` int(11) NOT NULL COMMENT '상품단가',
  `product_count` int(11) NOT NULL COMMENT '상품수량',
  `product_date` varchar(20) NOT NULL COMMENT '발행일자',
  `discount_rate` float NOT NULL COMMENT '적용할인율',
  PRIMARY KEY (`product_code`),
  KEY `인덱스 1` (`no`),
  KEY `FK_product_brand` (`brand_number`),
  KEY `FK_product_warehouse` (`warehouse_code`),
  KEY `FK_product_order` (`order_number`),
  CONSTRAINT `FK_product_brand` FOREIGN KEY (`brand_number`) REFERENCES `brand` (`brand_number`),
  CONSTRAINT `FK_product_order` FOREIGN KEY (`order_number`) REFERENCES `order` (`order_number`),
  CONSTRAINT `FK_product_warehouse` FOREIGN KEY (`warehouse_code`) REFERENCES `warehouse` (`warehouse_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.shopping_basket 구조 내보내기
CREATE TABLE IF NOT EXISTS `shopping_basket` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL COMMENT '사용자 아이디',
  `product_code` varchar(20) NOT NULL COMMENT '상품코드',
  `product_count` int(11) NOT NULL COMMENT '상품수량',
  `put_date` varchar(20) NOT NULL COMMENT '담은 날짜',
  PRIMARY KEY (`id`),
  KEY `인덱스 1` (`no`),
  KEY `FK_shopping_basket_product` (`product_code`),
  CONSTRAINT `FK_shopping_basket_product` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.supply 구조 내보내기
CREATE TABLE IF NOT EXISTS `supply` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_number` varchar(15) NOT NULL COMMENT '제조사 사업자번호',
  `supply_number` varchar(20) NOT NULL COMMENT '공급번호',
  `supply_date` varchar(20) NOT NULL COMMENT '공급일자',
  `supply_price` int(11) NOT NULL COMMENT '공급금액',
  PRIMARY KEY (`supply_number`),
  KEY `인덱스 1` (`no`),
  KEY `FK_supply_brand` (`brand_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.warehouse 구조 내보내기
CREATE TABLE IF NOT EXISTS `warehouse` (
  `no` bigint(20) NOT NULL AUTO_INCREMENT,
  `warehouse_code` varchar(20) NOT NULL COMMENT '창고코드',
  `warehouse_address` varchar(30) NOT NULL COMMENT '창고 위치',
  `warehouse_contact` varchar(13) NOT NULL COMMENT '창고 연락처',
  `warehouse_share` float NOT NULL DEFAULT 0 COMMENT '창고 점유율',
  PRIMARY KEY (`warehouse_code`),
  KEY `인덱스 1` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
