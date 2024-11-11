package com.example.mercado_libre_exam.Service;


import com.example.mercado_libre_exam.Exception.EmptyDNASequenceException;
import com.example.mercado_libre_exam.Exception.InvalidCharactersException;
import com.example.mercado_libre_exam.Model.DNA;
import com.example.mercado_libre_exam.Model.DTOs.StatisticsDTO;
import com.example.mercado_libre_exam.Repository.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DNAService {
    @Autowired
    private DNARepository dnaRepository;
    public Boolean isMutant(DNA dna) throws InvalidCharactersException, EmptyDNASequenceException {

        validateDNACharacters(dna.getDna());
        validateEmptyDNASequence(dna.getDna());

        Boolean isMutant = false;
        int coincidences = 0;
        String[] dnaSequence = dna.getDna();
        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}, // Right, Left, Down, Up
                {1, 1}, {-1, -1}, {1, -1}, {-1, 1} // Down Right, Up Left, Down Left, Up Right
        };


        for (int x = 0; x < dnaSequence.length ; x++) {

            String currentRow = dnaSequence[x];
            char[] charArray = currentRow.toCharArray();

            for (int z = 0; z < charArray.length; z++) {
                char currentLetter = charArray[z];

                for (int[] direction : directions) {
                    int dx= direction[0];
                    int dz= direction[1];

                    if(findSequence(dnaSequence, x, z, dx, dz,currentLetter)) {
                        System.out.println("DNA sequence found at direction: (" + dx + ", " + dz + ")");
                        coincidences++;
                    }

                }

            }
        }

        if(coincidences > 2)
        {
            isMutant = true;
        }

        dna.setIsMutant(isMutant);
        dnaRepository.save(dna);

        return isMutant;
    }
    public StatisticsDTO getStatistics(){

        StatisticsDTO statisticsDTO = new StatisticsDTO();
        List<DNA> dnaList = dnaRepository.findAll();

        Integer mutantCount = 0;
        Integer humanCount = 0;

        for (DNA dna : dnaList){
            if(dna.getIsMutant()){
                mutantCount++;
            }else {
                humanCount ++;
            }
        }

        Double ratio = Double.valueOf(mutantCount) / Double.valueOf(humanCount);

        statisticsDTO.setCount_human_dna(humanCount);
        statisticsDTO.setCount_mutant_dna(mutantCount);
        statisticsDTO.setRatio(ratio);


        return statisticsDTO;
    }
    private boolean findSequence(String[] list, int startX, int startZ, int dx, int dz, char currentLetter) {
        int count = 1;
        int x = startX;
        int z = startZ;

        for (int i = 1; i < 4; i++) {
            x += dx;
            z += dz;
            if (x < 0 || x >= list.length || z < 0 || z >= list[x].length()) {
                return false;
            }

            if (list[x].charAt(z) == currentLetter) {
                count++;
            } else {
                return false;
            }
        }

        return count == 4;
    }
    private void validateDNACharacters(String[] dna) throws InvalidCharactersException {
        for (String row : dna) {
            if (!row.matches("(?i)[ATCG]+")) {
                throw new InvalidCharactersException("Invalid characters DNA sequence can only be (A, T, C, G)");
            }
        }
    }
    private void validateEmptyDNASequence(String[] dna) throws EmptyDNASequenceException {
        if (dna == null || dna.length == 0) {
            throw new EmptyDNASequenceException("DNA sequence array cannot be null or empty");
        }
    }
}
