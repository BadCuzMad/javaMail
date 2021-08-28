CREATE TABLE "WaybillContent" (
  "id" int NOT NULL,
  "price" int NOT NULL,
  "quantity" int DEFAULT NULL,
  "nomenclature" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("id")
);