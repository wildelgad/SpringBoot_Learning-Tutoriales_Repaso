USE `movies` ;

CREATE TABLE IF NOT EXISTS `movies`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `year` INT NULL,
  `votes` INT NULL,
  `rating` DOUBLE NULL,
  `image_url` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));