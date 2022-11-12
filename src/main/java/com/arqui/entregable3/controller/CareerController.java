package com.arqui.entregable3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

 //   private CareerService careerService;

/*    @Autowired
    public CareerController(CareerService CareerService){
        this.careerService = CareerService;
    }*/

    @RequestMapping(value = "/inscriptions",method = RequestMethod.GET, produces = "application/json")
    public Integer findAlCareersWithStudents(){
     return  3;
    }



}
