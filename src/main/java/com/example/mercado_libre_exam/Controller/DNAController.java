package com.example.mercado_libre_exam.Controller;


import com.example.mercado_libre_exam.Exception.EmptyDNASequenceException;
import com.example.mercado_libre_exam.Exception.InvalidCharactersException;
import com.example.mercado_libre_exam.Model.DNA;
import com.example.mercado_libre_exam.Model.DTOs.MessageDTO;
import com.example.mercado_libre_exam.Model.DTOs.StatisticsDTO;
import com.example.mercado_libre_exam.Service.DNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutant")
public class DNAController {

    @Autowired
    private DNAService dnaService;
    @PostMapping
    public ResponseEntity<MessageDTO> checkIsMutant(@RequestBody DNA dna) throws InvalidCharactersException, EmptyDNASequenceException {

        Boolean isMutant = dnaService.isMutant(dna);

        if(isMutant){
            MessageDTO messageDTO = new MessageDTO("Mutant DNA detected");
            return ResponseEntity.status(HttpStatus.OK).body(messageDTO);
        }
        else{
            MessageDTO messageDTO = new MessageDTO("Human DNA detected");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(messageDTO);
        }
    }
    @GetMapping("/stats")
    public ResponseEntity<StatisticsDTO> getStatistics(){

        StatisticsDTO statisticsDTO = dnaService.getStatistics();

        return ResponseEntity.ok(statisticsDTO);
    }





}
