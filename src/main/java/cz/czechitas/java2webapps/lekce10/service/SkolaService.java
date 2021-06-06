package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkolaService {
    private final TridaRepository tridaRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SkolaService(TridaRepository tridaRepository, StudentRepository studentRepository) {
        this.tridaRepository = tridaRepository;
        this.studentRepository = studentRepository;
    }

    public List <Trida> seznamTrid(){
        return tridaRepository.findAll();
    }

    public Trida detailTridy(short id){
        return tridaRepository.getOne(id);
    }

    public Student detailStudenta (Integer id){
        return studentRepository.getOne(id);
    }



}
