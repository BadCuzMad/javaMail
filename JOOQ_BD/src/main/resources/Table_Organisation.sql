CREATE TABLE "Organisation" (
  "id" int NOT NULL,
  "name" varchar(255) NOT NULL,
  "tax" int DEFAULT NULL,
  "checkingAcc" int DEFAULT NULL,
  PRIMARY KEY ("id")
);