package service

import (
	"VaccineCenterBatchManager/repository"
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"time"
)

var dsn = "root:pipporoot@tcp(localhost:3306)/vaccinecenter?charset=utf8mb4&parseTime=True&loc=Local"
/*db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
err := db.AutoMigrate() //It WON’T delete unused columns to protect your data.
if err != nil {
print("Database migration error: ")
println(err)
}*/
//db.Where(&repository.Batch{PharmaceuticalCompany: "Enigne"}).Find(&batchQ)

func StoreBatch(batch repository.Batch)  {
	db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	err := db.AutoMigrate(&repository.Batch{})
	if err != nil {
		print("Database migration error: ")
		println(err)
	}
	db.Create(&batch)
}

func SelectByPharmaceuticalCompany(pC string) []repository.Batch  {
	var batchesQ []repository.Batch
	db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	err := db.AutoMigrate(&repository.Batch{})
	if err != nil {
		print("Database migration error: ")
		println(err)
	}
	db.Where(repository.Batch{PharmaceuticalCompany: pC}).Find(&batchesQ)
	return batchesQ
}

func SelectByDate(date string) []repository.Batch {
	var batchesQ []repository.Batch
	db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	err := db.AutoMigrate(&repository.Batch{})
	if err != nil {
		print("Database migration error: ")
		println(err)
	}
	db.Where(repository.Batch{DoU: date}).Find(&batchesQ)
	return batchesQ
}

func SelectAndUpdateBatch() repository.Batch{
	var batch repository.Batch
	db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	err := db.AutoMigrate(&repository.Batch{})
	if err != nil {
		print("Database migration error: ")
		println(err)
	}
	currentTime := time.Now()
	db.Where(&repository.Batch{DoU: string(currentTime.Format("02-01-2006"))}).Not(&repository.Batch{NumberOfDoses: 1}).First(&batch)
	db.Model(&batch).Updates(&repository.Batch{NumberOfDoses: batch.NumberOfDoses - 1})
	return batch
}