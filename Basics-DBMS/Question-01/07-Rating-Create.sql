
CREATE TABLE IF NOT EXISTS `rating` (
 `RAT_ID` INT NOT NULL PRIMARY KEY,
 `ORD_ID` INT NOT NULL,
 `RAT_RATSTARS` INT NOT NULL,
 FOREIGN KEY (`ORD_ID`) REFERENCES `ORDER` (`ORD_ID`)
 );
