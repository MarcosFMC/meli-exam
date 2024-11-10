package com.example.mercado_libre_exam.Controller;


import com.example.mercado_libre_exam.Model.DNA;
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
    @GetMapping
    public List<DNA> getAll(){

        List<DNA> dnaList = dnaService.getAll();
        return dnaList;
    }

    @GetMapping("/stats")
    public ResponseEntity<StatisticsDTO> getStatistics(){

        StatisticsDTO statisticsDTO = dnaService.getStatistics();

        return ResponseEntity.ok(statisticsDTO);
    }
    @PostMapping
    public ResponseEntity<String> checkIsMutant(@RequestBody DNA dna){

        Boolean isMutant = dnaService.checkIsMutant(dna);

        return isMutant ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


}
