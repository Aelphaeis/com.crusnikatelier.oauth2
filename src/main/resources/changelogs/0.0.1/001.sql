CREATE TABLE `users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'unique identifer',
  `email` VARCHAR(254) NOT NULL,
  `joined` DATETIME NOT NULL COMMENT 'user register date',
  `guid` VARCHAR(36) NOT NULL COMMENT 'unique user identifer',
  `salt` VARCHAR(32) NOT NULL,
  `hash` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `guid_UNIQUE` (`guid` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
