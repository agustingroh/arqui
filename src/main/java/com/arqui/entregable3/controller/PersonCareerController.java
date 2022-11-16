package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.CareerDTO;
import com.arqui.entregable3.dto.CareerReportDTO;
import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.service.PersonCareerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personCareer")
public class PersonCareerController {

    private PersonCareerService personCareerService;

    @Autowired
    public PersonCareerController(PersonCareerService PersonCareerService){
        this.personCareerService = PersonCareerService;
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @Operation(
            summary = "Inscribe un estudiante a una carrera",
            description = "Devuelve un estudiante determinado a una carrera elegida dados por un objeto IncriptionDto.",
            tags = { "PersonCareer-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = InscriptionDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO addNewPerson(@RequestBody InscriptionDTO inscription){
        return personCareerService.register(inscription);
    }

    @RequestMapping(value ="/report",method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve un listado de carreras",
            description = "Devuelve un listado de carreras con sus estudiantes, especificando graduados e inscriptos.",
            tags = { "PersonCareer-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<CareerReportDTO> getReport(){
        return this.personCareerService.getReport();
    }

    @RequestMapping(value="/{career}/{city}", method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve un listado de personas",
            description = "Devuelve un listado de personas por carrera y ciudad dadas por parametro.",
            tags = { "PersonCareer-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public List<PersonDTO> getStudentsByCareerAndCity(@PathVariable int career, @PathVariable String city){
        return this.personCareerService.findAllStudentsByCareerAndCity(career,city);
    }
}
