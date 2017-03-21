create table product (
    id INT NOT NULL AUTO_INCREMENT,
    category_id INT NOT NULL,
	name VARCHAR(32) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	currency VARCHAR(3) NOT NULL,
    primary key (id),
    CONSTRAINT `category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);