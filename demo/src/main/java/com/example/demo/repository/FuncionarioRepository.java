package com.example.demo.repository;


import com.example.demo.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
