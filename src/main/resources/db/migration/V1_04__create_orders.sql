create table orders (
    id INT NOT NULL AUTO_INCREMENT,
    product_id INT NOT NULL,
	quantity INT NOT NULL,
	user_id INT NOT NULL,
    primary key (id),
    CONSTRAINT `product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
 );