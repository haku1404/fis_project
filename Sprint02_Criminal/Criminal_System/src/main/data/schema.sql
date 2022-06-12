CREATE TABLE `evidencedb`.`evidence` (
  `id` INT NOT NULL,
  `version` INT NULL,
  `createdAt` DATETIME NULL,
  `modifiedAt` DATETIME NULL,
  `number` VARCHAR(20) NULL,
  `itemName` VARCHAR(45) NULL,
  `notes` VARCHAR(200) NULL,
  `archived` TINYINT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `evidencedb`.`criminal_case` (
    `id` INT NOT NULL,
    `version` INT NULL,
    `createdAt` DATETIME NULL,
    `modifiedAt` DATETIME NULL,
    `number` VARCHAR(20) NULL,
    `shortDescription` VARCHAR(50) NULL,
    `detailedDescription` VARCHAR(200) NULL,
    `notes` VARCHAR(50) NULL,
    PRIMARY KEY (`id`));
