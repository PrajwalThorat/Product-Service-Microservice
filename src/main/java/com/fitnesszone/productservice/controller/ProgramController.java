package com.fitnesszone.productservice.controller;

import com.fitnesszone.productservice.exception.ProgramAlreadyExistException;
import com.fitnesszone.productservice.exception.ProgramNotFoundException;
import com.fitnesszone.productservice.model.Program;
import com.fitnesszone.productservice.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/program")
public class ProgramController {

    private ProgramService programService;
    @Autowired
    public ProgramController(ProgramService programService){
        this.programService=programService;
    }
    @PostMapping
    public ResponseEntity<Program> addProgram(@RequestBody Program program) throws ProgramAlreadyExistException {
        return new ResponseEntity<>(programService.addProgram(program), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Program> updateProgram(@RequestBody Program program) throws ProgramAlreadyExistException, ProgramNotFoundException {
        return new ResponseEntity<>(programService.updateProgram(program), HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<Program> listAllPrograms(){
        return  new ResponseEntity(programService.listAllPrograms(), HttpStatus.FOUND);
    }

    @GetMapping("viewAll/{programCode}")
    public ResponseEntity<Program> listAllPrograms(@PathVariable String programCode){
        return  new ResponseEntity(programService.getProgramByCode(programCode), HttpStatus.FOUND);
    }
    @GetMapping("activePrograms/{active}")
    public ResponseEntity<Program> listAllProgramsByActiveTrue(@PathVariable boolean active){
        return  new ResponseEntity(programService.listAllActivePrograms(), HttpStatus.FOUND);
    }
    @GetMapping("programsByDuration/{duration}")
    public ResponseEntity<Program> listAllPrograms(@PathVariable int duration){
        return  new ResponseEntity(programService.listProgramByDuration(duration), HttpStatus.FOUND);
    }
}
