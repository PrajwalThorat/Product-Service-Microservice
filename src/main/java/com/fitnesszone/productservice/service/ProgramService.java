package com.fitnesszone.productservice.service;

import com.fitnesszone.productservice.exception.ProgramAlreadyExistException;
import com.fitnesszone.productservice.exception.ProgramNotFoundException;
import com.fitnesszone.productservice.model.Program;

import java.util.List;

public interface ProgramService {
    Program addProgram(Program program) throws ProgramAlreadyExistException;
    Program updateProgram(Program program) throws ProgramNotFoundException;
    List<Program> listAllPrograms();
    Program getProgramByCode(String programCode);
    List<Program> listProgramByDuration(int duration);
    List<Program> listAllActivePrograms();
}
