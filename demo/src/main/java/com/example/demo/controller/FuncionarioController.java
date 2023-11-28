package com.example.demo.controller;


import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.entity.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> list(){
        System.out.println("Recuperando os funcionarios!");
        return repository.findAll();
    } // READ ALL


    @GetMapping(path = "/{id}")
    public Optional<Funcionario> findById(@PathVariable long id) {
        return repository.findById(id);
    } // READ BY ID

    @DeleteMapping(path = "/{id}")
    public String delete (@PathVariable long id){

        Optional<Funcionario> funcionarioOptional = repository.findById(id);

        if (funcionarioOptional.isPresent()){
            Funcionario funcionario = funcionarioOptional.get();
            repository.deleteById(id);
            return "O funcionario " + funcionario.getName() + " foi removido do banco de dados!";
        }else{
            return "Nenhum funcionário encontrado com o ID: " + id;
        } //DELETE BY ID
    }



    @PostMapping
    public ResponseEntity salvar(@RequestBody @Validated FuncionarioDTO funcionarioDTO) {
        Funcionario newFuncionario = new Funcionario(funcionarioDTO);
        repository.save(newFuncionario);
        return ResponseEntity.ok(repository.findAll());
    } // CREATE

}
