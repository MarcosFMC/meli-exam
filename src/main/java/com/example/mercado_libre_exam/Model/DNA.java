package com.example.mercado_libre_exam.Model;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class DNA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<String> dna;
    private Boolean isMutant;

    public DNA() {
    }

    public DNA(Long id, List<String> dna, Boolean isMutant) {
        this.id = id;
        this.dna = dna;
        this.isMutant = isMutant;
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

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "DNA{" +
                "sequences=" + dna +
                '}';
    }
}
