DROP TABLE IF EXISTS `class_member`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
	`permission_name` VARCHAR(25) NOT NULL,
    `permission_value` BIGINT(20) NOT NULL,
    PRIMARY KEY (`permission_name`)
);  

CREATE TABLE `user` (
	`username` VARCHAR(25) NOT NULL,
	`name` VARCHAR(45) NOT NULL,
	`permission_name` VARCHAR(25) NOT NULL DEFAULT 'student',
	PRIMARY KEY (`username`),
	CONSTRAINT `user_permission_fk` 
	FOREIGN KEY (`permission_name`)
	REFERENCES `permission` (`permission_name`)
);

CREATE TABLE `class_member` (
	`username` VARCHAR(25) NOT NULL,
    `classname` VARCHAR(225) NOT NULL,
    PRIMARY KEY (`username`, `classname`),
    CONSTRAINT `class_member_user_fk` 
	FOREIGN KEY (`username`)
	REFERENCES `user`(`username`)
);