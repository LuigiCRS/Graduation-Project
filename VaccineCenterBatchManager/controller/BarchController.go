package controller

import (
	"VaccineCenterBatchManager/repository"
	"VaccineCenterBatchManager/service"
	"github.com/gin-gonic/gin"
)


func GetByDateFunc(c *gin.Context)  {
	date := c.Param("date")
	batches := service.SelectByDate(date)
	c.JSON(200, batches)
}

func RegistrationFunc(c *gin.Context) {
	var batch repository.Batch
	err := c.ShouldBindJSON(&batch)
	if err != nil {
		println("Binding error")
		return
	}
	service.StoreBatch(batch)
	c.JSON(200, batch)
}

func GetByPharmaceuticalCompanyFunc(c *gin.Context)  {
	pC := c.Param("pC")
	batches := service.SelectByPharmaceuticalCompany(pC)
	c.JSON(200, batches)
}

func ConfirmFunc(c *gin.Context)  {
	batch := service.SelectAndUpdateBatch()
	c.JSON(200, batch)
}
