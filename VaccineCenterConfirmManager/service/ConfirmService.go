package service

import (
	"VaccineCenterConfirmManager/repository"
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)


var dsn = "root:pipporoot@tcp(localhost:3306)/vaccinecenter?charset=utf8mb4&parseTime=True&loc=Local"

func StoreConfirm(confirm repository.Confirm)  {
	db, _ := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	err := db.AutoMigrate(&repository.Confirm{})
	if err != nil {
		print("Database migration error: ")
		println(err)
	}
	db.Create(&confirm)
}