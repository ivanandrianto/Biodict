BEGIN TRANSACTION;
CREATE TABLE `table1` (
	`_id`	INTEGER,
	`name`	TEXT,
	`desc`	TEXT,
	PRIMARY KEY(_id)
);
CREATE TABLE "android_metadata" ("locale" TEXT DEFAULT 'en_US');
INSERT INTO `android_metadata` VALUES ('en_US');
COMMIT;
