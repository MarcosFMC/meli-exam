package com.example.mercado_libre_exam.Model;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class DNA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String[] dna;
    private Boolean isMutant;

    public DNA() {
    }

    public DNA( String[] dna) {
        this.dna = dna;
        this.isMutant = false;
    }
    public DNA(Long id, String[] dna) {
        this.id = id;
        this.dna = dna;
        this.isMutant = false;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(Boolean mutant) {
        isMutant = mutant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
