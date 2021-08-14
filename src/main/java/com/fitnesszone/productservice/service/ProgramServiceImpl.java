package com.fitnesszone.productservice.service;

import com.fitnesszone.productservice.exception.ProgramAlreadyExistException;
import com.fitnesszone.productservice.exception.ProgramNotFoundException;
import com.fitnesszone.productservice.model.Program;
import com.fitnesszone.productservice.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{
    private ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository){
        this.programRepository=programRepository;
    }
    @Override
    public Program addProgram(Program program) throws ProgramAlreadyExistException {
        if(programRepository.findById(program.getProgramCode()).isPresent()){
            throw new ProgramAlreadyExistException();
        }
        return programRepository.save(program);
    }

    @Override
    public Program updateProgram(Program program) throws ProgramNotFoundException {
        if(!programRepository.findById(program.getProgramCode()).isPresent()){
            throw new ProgramNotFoundException();
        }
        return programRepository.save(program);
    }

    @Override
    public List<Program> listAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program getProgramByCode(String programCode) {
        return programRepository.findById(programCode).get();
    }

    @Override
    public List<Program> listProgramByDuration(int duration) {
        return programRepository.findByDurationInMonths(duration);
    }

    @Override
    public List<Program> listAllActivePrograms() {
        List<Program> outList=programRepository.findByActiveTrue();
        return outList;
    }
}
