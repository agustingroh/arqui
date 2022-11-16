package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.CareerDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.service.CareerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

    private CareerService careerService;

    @Autowired
    public CareerController(CareerService CareerService){
        this.careerService = CareerService;
    }

    @RequestMapping(value = "/inscriptions",method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve carreras que tienen estudiantes",
            description = "Devuelve carreras que tengan estudiantes, en caso deno tener las descarta.",
            tags = { "Career-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CareerDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<CareerDTO> findAlCareersWithStudents(){
      return  careerService.getAllCareersWithStudents();
    }



}
