package controller

import (
	"VaccineCenterConfirmManager/repository"
	"VaccineCenterConfirmManager/service"
	"github.com/gin-gonic/gin"
)


func ConfirmFunc(c *gin.Context)  {
	var confirm repository.Confirm
	err := c.ShouldBindJSON(&confirm)
	if err != nil {
		println("Binding error.")
	}
	service.StoreConfirm(confirm)
	c.JSON(200, confirm)
}
