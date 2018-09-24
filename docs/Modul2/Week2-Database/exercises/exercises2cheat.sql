CREATE SCHEMA IF NOT EXISTS `imagesdb` DEFAULT CHARACTER SET utf8 ;
USE `imagesdb` ;

-- -----------------------------------------------------
-- Table `imagesdb`.`Photographer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Photographer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `imagename` VARCHAR(45) NULL,
  `imageurl` VARCHAR(45) NULL,
  `added` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `caption` VARCHAR(200) NULL,
  `Imagecol` VARCHAR(45) NULL,
  `modified` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Photographer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Photographer_id`),
  INDEX `fk_Image_Photographer1_idx` (`Photographer_id` ASC),
  CONSTRAINT `fk_Image_Photographer1`
    FOREIGN KEY (`Photographer_id`)
    REFERENCES `imagesdb`.`Photographer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Author` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `gender` ENUM('F', 'M') NULL,
  `b_year` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `caption` VARCHAR(200) NULL,
  `text` TEXT NULL,
  `Articlecol` VARCHAR(45) NULL,
  `Author_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Author_id`),
  INDEX `fk_Article_Author1_idx` (`Author_id` ASC),
  CONSTRAINT `fk_Article_Author1`
    FOREIGN KEY (`Author_id`)
    REFERENCES `imagesdb`.`Author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Image_has_Article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Image_has_Article` (
  `Image_id` INT NOT NULL,
  `Article_id` INT NOT NULL,
  PRIMARY KEY (`Image_id`, `Article_id`),
  INDEX `fk_Image_has_Article_Article1_idx` (`Article_id` ASC),
  INDEX `fk_Image_has_Article_Image_idx` (`Image_id` ASC),
  CONSTRAINT `fk_Image_has_Article_Image`
    FOREIGN KEY (`Image_id`)
    REFERENCES `imagesdb`.`Image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Image_has_Article_Article1`
    FOREIGN KEY (`Article_id`)
    REFERENCES `imagesdb`.`Article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Image_has_Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Image_has_Tag` (
  `Image_id` INT NOT NULL,
  `Tag_id` INT NOT NULL,
  PRIMARY KEY (`Image_id`, `Tag_id`),
  INDEX `fk_Image_has_Tag_Tag1_idx` (`Tag_id` ASC),
  INDEX `fk_Image_has_Tag_Image1_idx` (`Image_id` ASC),
  CONSTRAINT `fk_Image_has_Tag_Image1`
    FOREIGN KEY (`Image_id`)
    REFERENCES `imagesdb`.`Image` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Image_has_Tag_Tag1`
    FOREIGN KEY (`Tag_id`)
    REFERENCES `imagesdb`.`Tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `imagesdb`.`Tag_has_Article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `imagesdb`.`Tag_has_Article` (
  `Tag_id` INT NOT NULL,
  `Article_id` INT NOT NULL,
  PRIMARY KEY (`Tag_id`, `Article_id`),
  INDEX `fk_Tag_has_Article_Article1_idx` (`Article_id` ASC),
  INDEX `fk_Tag_has_Article_Tag1_idx` (`Tag_id` ASC),
  CONSTRAINT `fk_Tag_has_Article_Tag1`
    FOREIGN KEY (`Tag_id`)
    REFERENCES `imagesdb`.`Tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tag_has_Article_Article1`
    FOREIGN KEY (`Article_id`)
    REFERENCES `imagesdb`.`Article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

