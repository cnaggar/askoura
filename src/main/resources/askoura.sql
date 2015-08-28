CREATE TABLE A (I INT);
CREATE TABLE Customer (
  `fid` IDENTITY PRIMARY KEY,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL);