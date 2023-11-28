package com.example.demo.entity;

import com.example.demo.dto.EmpresaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float salario;

    public Empresa() {
    }

    public Empresa(EmpresaDTO  empresaDTO) {
        this.name = empresaDTO.name();
        this.salario = empresaDTO.salario();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }



}


