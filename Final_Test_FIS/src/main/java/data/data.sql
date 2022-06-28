INSERT INTO `final_test`.`tbl_product` (`id`, `available`, `name`, `price`) VALUES ('1', '1000', 'Apple', '10000');
INSERT INTO `final_test`.`tbl_product` (`id`, `available`, `name`, `price`) VALUES ('2', '200', 'Mango', '8000');
INSERT INTO `final_test`.`tbl_product` (`id`, `available`, `name`, `price`) VALUES ('3', '100', 'Grape', '40000');
INSERT INTO `final_test`.`tbl_product` (`id`, `available`, `name`, `price`) VALUES ('4', '500', 'Durian', '80000');
INSERT INTO `final_test`.`tbl_product` (`id`, `available`, `name`, `price`) VALUES ('5', '1000', 'Cherry', '50000');

INSERT INTO `final_test`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('1', 'Hoang Mai', '0973819381', 'An');
INSERT INTO `final_test`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('2', 'Cau Giay', '0361782999', 'Binh');

INSERT INTO `final_test`.`tbl_order` (`id`, `order_datetime`, `order_status`, `total_amount`, `customer_id`) VALUES ('1', '2022-06-13 01:39:55', 'CREATED', '18000', '1');
INSERT INTO `final_test`.`tbl_order` (`id`, `order_datetime`, `order_status`, `total_amount`, `customer_id`) VALUES ('2', '2022-06-13 01:39:55', 'CREATED', '200000', '2');

INSERT INTO `final_test`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('1', '10000', '1', '1', '1');
INSERT INTO `final_test`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('2', '8000', '1', '1', '2');
INSERT INTO `final_test`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('3', '120000', '3', '2', '3');
INSERT INTO `final_test`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('4', '80000', '1', '2', '4');

