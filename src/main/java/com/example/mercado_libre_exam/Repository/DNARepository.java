package com.example.mercado_libre_exam.Repository;

import com.example.mercado_libre_exam.Model.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DNARepository extends JpaRepository<DNA,Long> {
}
