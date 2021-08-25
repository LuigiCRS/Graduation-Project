package repository

type Confirm struct {
	Cf string `json:"cf" gorm:"primaryKey;autoIncrement:false"`
	Id int `json:"id" gorm:"primaryKey;autoIncrement:false"`
	Date string `json:"date"`
	Hour string `json:"hour"`
	Name string `json:"name"` //Doctor's Name
	Surname string `json:"surname"` //Doctor's Name
}