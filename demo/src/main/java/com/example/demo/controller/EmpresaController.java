package com.example.demo.controller;

import com.example.demo.entity.Empresa;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository repository;


    @GetMapping
    public List<Empresa> list(){
        System.out.println("Recuperando os empresa!");
        return repository.findAll();
    } // READ ALL


    @GetMapping(path = "/{id}")
    public Optional<Empresa> findById(@PathVariable long id) {
        return repository.findById(id);
    } // READ BY ID

    @DeleteMapping(path = "/{id}")
    public String delete (@PathVariable long id){

        Optional<Empresa> empresaOptional = repository.findById(id);

        if (empresaOptional.isPresent()){
            Empresa empresa = empresaOptional.get();
            repository.deleteById(id);
            return "O empresa " + empresa.getName() + " foi removido do banco de dados!";
        }else{
            return "Nenhum funcionário encontrado com o ID: " + id;
        } //DELETE BY ID
    }



    @PostMapping
    public ResponseEntity salvar(@RequestBody @Validated EmpresaDTO empresaDTO) {
        Empresa newEmpresa = new Empresa(empresaDTO);
        repository.save(newEmpresa);
        return ResponseEntity.ok(repository.findAll());
    } // CREATE

}
