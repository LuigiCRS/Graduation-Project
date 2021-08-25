package main

import (
	"VaccineCenterConfirmManager/controller"
	"github.com/gin-gonic/gin"
)

func main() {
	server := gin.Default()
	batchRoutes := server.Group("/api/confirm/")
	batchRoutes.POST("/", controller.ConfirmFunc)
	err := server.Run(":8085")
	if err != nil {
		println("Run Server error.")
	}
}