package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve todos los estudiantes",
            description = "Devuelve todos los estudiantes inscriptos en la universidad",
            tags = { "Person-controller" },
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
    public List<Person> findAll(){
        System.out.println(personService.findAll());
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @Operation(
            summary = "Agrega una persona a la DB.",
            description = "Agrega una persona con los datos enviados por el body.",
            tags = { "Person-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO addNewPerson(@RequestBody PersonDTO person){
        System.out.println("POST" + person);
        return personService.addNewPerson(person);
    }
    @RequestMapping(value="/order",method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve un estudiante filtrado",
            description = "Devuelve un estudiante dependiendo el parametro dado.",
            tags = { "Person-controller" },
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
    public List<PersonDTO> getAllStudentsBy(@RequestParam("find") String params){
        return personService.getAllStudentsBy(params);
    }

    @RequestMapping(value = "/collegeNotebook/{LU}", method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve un estudiante a partir de la LU",
            description = "Devuelve un estudiante a partir de la Libreta Universitaria dada por parametro.",
            tags = { "Person-controller" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO getStudentByLU(@PathVariable int LU){
        return personService.getStudentByLU(LU);
    }

    @RequestMapping(value = "/gender/{gender}", method = RequestMethod.GET, produces = "application/json")
    @Operation(
            summary = "Devuelve estudiantes por genero",
            description = "Devuelve estudiantes por genero indicado por parametro.",
            tags = { "Person-controller" },
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
    public List<PersonDTO> getStudentsByGender(@PathVariable String gender){
        return personService.getStudentsByGender(gender);
    }






}
