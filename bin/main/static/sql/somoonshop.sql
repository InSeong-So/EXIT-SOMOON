-- --------------------------------------------------------
-- 호스트:                          192.168.0.3
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
CREATE DATABASE IF NOT EXISTS `somoon` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `somoon`;

-- 테이블 somoon.account 구조 내보내기
CREATE TABLE IF NOT EXISTS `account` (
  `account_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '계정 인덱스',
  `account_id` varchar(20) NOT NULL COMMENT '아이디',
  `account_password` varchar(20) NOT NULL COMMENT '비밀번호-변경가능',
  `account_name` varchar(10) DEFAULT NULL COMMENT '이름-변경가능',
  `account_birthday` varchar(16) DEFAULT NULL COMMENT '생년월일-변경가능',
  `account_contact` varchar(20) DEFAULT NULL COMMENT '연락처-변경가능',
  `account_address` varchar(30) DEFAULT NULL COMMENT '주소-변경가능',
  `account_postal_code` varchar(25) DEFAULT NULL COMMENT '우편번호-변경가능',
  `account_email` varchar(30) NOT NULL COMMENT '이메일-변경가능',
  `account_agreement` varchar(1) DEFAULT 'n' COMMENT '개인정보동의현황-변경가능',
  `account_body_size` varchar(100) DEFAULT NULL COMMENT '회원 사이즈-변경가능',
  `account_add_date` timestamp NULL DEFAULT NULL COMMENT '회원 가입일자',
  `account_last_login` timestamp NULL DEFAULT NULL COMMENT '마지막 로그인 일자',
  `account_count_login_failed` int(11) DEFAULT NULL COMMENT '계정 로그인 실패 횟수',
  `account_point` int(11) DEFAULT NULL COMMENT '계정 구매 포인트',
  PRIMARY KEY (`account_id`),
  KEY `인덱스 2` (`account_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.account_temporarily 구조 내보내기
CREATE TABLE IF NOT EXISTS `account_temporarily` (
  `account_temp_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '비회원 계정 인덱스',
  `account_temp_id` varchar(20) NOT NULL COMMENT '임시 아이디',
  `account_temp_password` varchar(20) NOT NULL COMMENT '임시 비밀번호',
  `account_temp_contact` varchar(13) NOT NULL COMMENT '연락처',
  `account_temp_address` varchar(30) NOT NULL COMMENT '주소',
  `account_temp_postal_code` varchar(25) NOT NULL COMMENT '우편번호',
  `account_temp_add_date` timestamp NULL DEFAULT NULL COMMENT '비회원 가입일자',
  `account_temp_delyn` varchar(1) NOT NULL COMMENT '삭제여부',
  PRIMARY KEY (`account_temp_id`),
  KEY `인덱스 1` (`account_temp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.basket 구조 내보내기
CREATE TABLE IF NOT EXISTS `basket` (
  `basket_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '장바구니 인덱스',
  `account_id` varchar(20) NOT NULL COMMENT '사용자 계정',
  `product_code` varchar(20) NOT NULL COMMENT '상품 코드',
  `product_count` int(11) NOT NULL COMMENT '상품 수량',
  `basket_add_date` varchar(20) NOT NULL COMMENT '장바구니 담은 날짜',
  PRIMARY KEY (`account_id`),
  KEY `인덱스 1` (`basket_no`),
  KEY `FK_shopping_basket_product` (`product_code`),
  CONSTRAINT `FK_shopping_basket_product` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.body_size 구조 내보내기
CREATE TABLE IF NOT EXISTS `body_size` (
  `body_size_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사이즈 인덱스',
  `account_id` varchar(20) NOT NULL COMMENT '사용자 계정',
  `product_code` varchar(20) NOT NULL COMMENT '상품 코드',
  `body_sex` varchar(10) DEFAULT NULL COMMENT '성별',
  `body_size_height` varchar(10) DEFAULT NULL COMMENT '키',
  `body_size_bust` varchar(10) DEFAULT NULL COMMENT '가슴둘레',
  `body_size_waist` varchar(10) DEFAULT NULL COMMENT '허리 둘레',
  `body_size_hips` varchar(10) DEFAULT NULL COMMENT '엉덩이 둘레',
  `body_size_girth` varchar(10) DEFAULT NULL COMMENT '어깨~엉덩이 길이(상체)',
  `body_size_inseam` varchar(10) DEFAULT NULL COMMENT '엉덩이~다리 길이(하체)',
  KEY `인덱스 2` (`body_size_no`),
  KEY `FK_fit_product_product` (`product_code`),
  KEY `FK_body_size_account` (`account_id`),
  CONSTRAINT `FK_body_size_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fit_product_product` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.brand 구조 내보내기
CREATE TABLE IF NOT EXISTS `brand` (
  `brand_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '제조사 인덱스',
  `brand_code` varchar(15) NOT NULL COMMENT '제조사 사업자번호',
  `brand_name` varchar(20) NOT NULL COMMENT '제조사명',
  `brand_contact` varchar(13) NOT NULL COMMENT '제조사 연락처',
  `brand_address` varchar(30) NOT NULL COMMENT '제조사 주소',
  `brand_postal_code` varchar(25) NOT NULL COMMENT '제조사 우편번호',
  `brand_bank_code` int(5) NOT NULL COMMENT '제조사 거래은행 코드',
  `brand_account_number` varchar(20) NOT NULL COMMENT '제조사 계좌번호',
  `brand_depositor` varchar(10) NOT NULL COMMENT '제조사 예금주',
  PRIMARY KEY (`brand_code`),
  KEY `인덱스 1` (`brand_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.delivery 구조 내보내기
CREATE TABLE IF NOT EXISTS `delivery` (
  `delivery_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '배송 인덱스',
  `delivery_code` varchar(20) NOT NULL COMMENT '배송 코드',
  `post_service_code` varchar(20) NOT NULL COMMENT '택배업체/사업자번호',
  `delivery_payment` int(11) NOT NULL COMMENT '배송 금액',
  `delivery_date` varchar(20) NOT NULL COMMENT '배송 일자',
  PRIMARY KEY (`delivery_code`),
  KEY `인덱스 1` (`delivery_no`),
  KEY `FK_delivery_parcel_service` (`post_service_code`),
  CONSTRAINT `FK_delivery_parcel_service` FOREIGN KEY (`post_service_code`) REFERENCES `post_service` (`post_service_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.order 구조 내보내기
CREATE TABLE IF NOT EXISTS `order` (
  `order_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 인덱스',
  `account_id` varchar(20) NOT NULL COMMENT '사용자 계정',
  `delivery_code` varchar(45) NOT NULL COMMENT '배송 코드',
  `order_code` varchar(30) NOT NULL COMMENT '주문 번호',
  `order_date` varchar(20) NOT NULL COMMENT '주문 일자',
  `delivery_contact` varchar(30) NOT NULL COMMENT '배송지 연락처',
  `delivery_address` varchar(30) NOT NULL COMMENT '배송지 주소',
  `delivery_postal_code` varchar(25) NOT NULL COMMENT '배송지 우편번호',
  `delivery_way_code` varchar(30) NOT NULL COMMENT '배송방법 코드',
  `delivery_payment` int(1) NOT NULL COMMENT '결제 방법',
  `order_memo` varchar(100) NOT NULL COMMENT '주문 기타사항',
  PRIMARY KEY (`order_code`),
  KEY `인덱스 1` (`order_no`),
  KEY `FK_order_delivery` (`delivery_code`),
  KEY `FK_order_member` (`account_id`),
  CONSTRAINT `FK_order_delivery` FOREIGN KEY (`delivery_code`) REFERENCES `delivery` (`delivery_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_order_member` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.post_service 구조 내보내기
CREATE TABLE IF NOT EXISTS `post_service` (
  `post_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '택배업체 인덱스',
  `post_service_code` varchar(30) NOT NULL COMMENT '택배업체/사업자번호',
  `post_service_name` varchar(20) NOT NULL COMMENT '택배업체명',
  `post_service_contact` varchar(13) NOT NULL COMMENT '택배업체 연락처',
  `post_service_address` varchar(30) NOT NULL COMMENT '택배업체 주소',
  `post_service_postal_code` varchar(25) NOT NULL COMMENT '택배업체 우편번호',
  PRIMARY KEY (`post_service_code`),
  KEY `인덱스 1` (`post_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `product_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '상품 인덱스',
  `product_code` varchar(30) NOT NULL COMMENT '상품 코드',
  `brand_code` varchar(20) NOT NULL COMMENT '제조사 사업자번호',
  `warehouse_code` varchar(20) NOT NULL COMMENT '창고 코드',
  `order_code` varchar(20) NOT NULL COMMENT '주문 코드',
  `product_category` int(2) NOT NULL COMMENT '상품 구분',
  `product_price` int(11) NOT NULL COMMENT '상품 단가',
  `product_count` int(11) NOT NULL COMMENT '상품 수량',
  `product_date` varchar(20) NOT NULL COMMENT '상품 발행 일자',
  `product_discount` float NOT NULL COMMENT '상품 적용 할인율',
  PRIMARY KEY (`product_code`),
  KEY `인덱스 1` (`product_no`),
  KEY `FK_product_brand` (`brand_code`),
  KEY `FK_product_order` (`order_code`),
  KEY `FK_product_warehouse` (`warehouse_code`),
  CONSTRAINT `FK_product_brand` FOREIGN KEY (`brand_code`) REFERENCES `brand` (`brand_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_order` FOREIGN KEY (`order_code`) REFERENCES `order` (`order_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_warehouse` FOREIGN KEY (`warehouse_code`) REFERENCES `warehouse` (`warehouse_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 somoon.warehouse 구조 내보내기
CREATE TABLE IF NOT EXISTS `warehouse` (
  `warehouse_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '창고 인덱스',
  `warehouse_code` varchar(20) NOT NULL COMMENT '창고 코드',
  `warehouse_address` varchar(30) NOT NULL COMMENT '창고 위치',
  `warehouse_contact` varchar(13) NOT NULL COMMENT '창고 연락처',
  `warehouse_share` float NOT NULL COMMENT '창고 사용률',
  PRIMARY KEY (`warehouse_code`),
  KEY `인덱스 1` (`warehouse_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
