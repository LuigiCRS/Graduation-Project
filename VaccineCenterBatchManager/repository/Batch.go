package repository

// Batch gorm.Batch definition
type Batch struct {
	Id int `json:"id" gorm:"primary_key;autoIncrement:true"`
	PharmaceuticalCompany string `json:"pharmaceuticalCompany"`
	NumberOfDoses int `json:"numberOfDoses"`
	DoU string `json:"doU"` //date od use
}

func NewBatch(id int, pharmaceuticalCompany string, numberOfDoses int, doU string) *Batch {
	return &Batch{Id: id, PharmaceuticalCompany: pharmaceuticalCompany, NumberOfDoses: numberOfDoses, DoU: doU}
}

