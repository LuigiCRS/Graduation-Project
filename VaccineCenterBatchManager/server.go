package main

import (
	"VaccineCenterBatchManager/controller"
	"github.com/gin-gonic/gin"
)

func main() {
	server := gin.Default()
	batchRoutes := server.Group("/api/batch")
	batchRoutes.GET("/getByDate/:date", controller.GetByDateFunc)
	batchRoutes.GET("/getByPharmaceuticalCompany/:pC", controller.GetByPharmaceuticalCompanyFunc)
	batchRoutes.PUT("/registration", controller.RegistrationFunc)
	batchRoutes.GET("/confirm", controller.ConfirmFunc)
	err := server.Run(":8084")
	if err != nil {
		println("Run Server error.")
	}

}
