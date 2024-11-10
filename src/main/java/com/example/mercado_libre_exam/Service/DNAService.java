package com.example.mercado_libre_exam.Service;


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
    public Boolean checkIsMutant(DNA dna){

        Boolean isMutant = false;

        int coincidences = 0;

        List<String> list = dna.getDna();

        for (int x = 0; x < list.size() ; x++) {

            char[] charArray = list.get(x).toCharArray();

            for (int z = 0; z < charArray.length; z++) {

                char currentLetter= charArray[z];

                System.out.println("------Soy la letra principal------- / " + charArray[z]);

                if((z + 1) < charArray.length){

                    char rightChar = charArray[z + 1];

                    if(currentLetter == rightChar){

                        System.out.println("Tenemos coincidencia en la direccion: Derecha");

                        if( (z + 2) < charArray.length){

                            char rightCharPlus = charArray[z + 2];

                            if(rightCharPlus == rightChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Derecha");

                                if( (z + 3) < charArray.length){

                                    char rightCharPlusPlus = charArray[z + 3];

                                    if(rightCharPlusPlus == rightCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Derecha");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((z - 1) >= 0){

                    char leftChar = charArray[z - 1];

                    if(currentLetter == leftChar){
                        System.out.println("Tenemos coincidencia en la direccion: Izquierda");

                        if((z - 2) >= 0){

                            char leftCharPlus = charArray[z - 2];

                            if(leftCharPlus == leftChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Izquierda");

                                if((z - 3) >= 0){

                                    char leftCharPlusPlus = charArray[z - 3];

                                    if(leftCharPlusPlus == leftCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Izquierda");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x + 1) < list.size()){

                    char downChar = list.get(x + 1).toCharArray()[z];

                    if(currentLetter == downChar){

                        System.out.println("Tenemos coincidencia en la direccion: Abajo");

                        if((x + 2) < list.size()){

                            char downCharPlus = list.get(x + 2).toCharArray()[z];

                            if(downCharPlus == downChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo");

                                if((x + 3) < list.size()){

                                    char downCharPlusPlus = list.get(x + 3).toCharArray()[z];

                                    if(downCharPlusPlus == downCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Abajo");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x + 1) < list.size() && (z - 1) >= 0){

                    char downLeftChar = list.get(x + 1).toCharArray()[z - 1];

                    if(currentLetter == downLeftChar){
                        System.out.println("Tenemos coincidencia en la direccion: Abajo izq");

                        if((x + 2) < list.size() && (z - 2) >= 0){

                            char downLeftCharPlus = list.get(x + 2).toCharArray()[z - 2];

                            if(downLeftCharPlus == downLeftChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo izq");

                                if((x + 3) < list.size() && (z - 3) >= 0){

                                    char downLeftCharPlusPlus = list.get(x + 3).toCharArray()[z - 3];

                                    if(downLeftCharPlusPlus == downLeftCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Abajo izq");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x + 1) < list.size() && (z + 1) < charArray.length){

                    char downRightChar = list.get(x + 1).toCharArray()[z + 1];

                    if(currentLetter == downRightChar){
                        System.out.println("Tenemos coincidencia en la direccion: Abajo der");

                        if((x + 2) < list.size() && (z + 2) < charArray.length){

                            char downRightCharPlus = list.get(x + 2).toCharArray()[z + 2];

                            if(downRightCharPlus == downRightChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo der");

                                if((x + 3) < list.size() && (z + 3) < charArray.length){

                                    char downLRightCharPlusPlus = list.get(x + 3).toCharArray()[z + 3];

                                    if(downLRightCharPlusPlus == downRightCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Abajo Der");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x - 1) >= 0){

                    char upChar = list.get(x - 1).toCharArray()[z];

                    if(currentLetter == upChar){
                        System.out.println("Tenemos coincidencia en la direccion: Arriba");

                        if((x - 2) >= 0){

                            char upCharPlus = list.get(x - 2).toCharArray()[z];

                            if(upCharPlus == upChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba");

                                if((x - 3) >= 0){

                                    char upCharPlusPlus = list.get(x - 3).toCharArray()[z];

                                    if(upCharPlusPlus == upCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Arriba");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x - 1) >= 0 && (z + 1) < charArray.length){

                    char upRightChar = list.get(x - 1).toCharArray()[z + 1];

                    if(currentLetter == upRightChar){

                        System.out.println("Tenemos coincidencia en la direccion: Arriba der");

                        if((x - 2) >= 0 && (z + 2) < charArray.length){

                            char upRightCharPlus = list.get(x - 2).toCharArray()[z + 2];

                            if(upRightCharPlus == upRightChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba der");

                                if((x - 3) >= 0 && (z + 3) < charArray.length){

                                    char upRightCharPlusPlus = list.get(x - 3).toCharArray()[z + 3];

                                    if(upRightCharPlusPlus == upRightCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Arriba der");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }

                if((x - 1) >= 0 && (z - 1) >= 0){

                    char upLeftChar = list.get(x - 1).toCharArray()[z - 1];

                    if(currentLetter == upLeftChar){
                        System.out.println("Tenemos coincidencia en la direccion: Arriba izq");

                        if((x - 2) >= 0 && (z - 2) >= 0){

                            char upLeftCharPlus = list.get(x - 2).toCharArray()[z - 2];

                            if(upLeftCharPlus == upLeftChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba izq");

                                if((x - 3) >= 0 && (z - 3) >= 0){

                                    char upLeftCharPlusPlus = list.get(x - 3).toCharArray()[z - 3];

                                    if(upLeftCharPlusPlus == upLeftCharPlus){
                                        System.out.println("Tenemos una tercera coincidencia en la direccion: Arriba izq");
                                        System.out.println("Secuencia ADN encontrada");
                                        coincidences++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }


        if(coincidences > 2)
        {
            isMutant = true;
        }

        System.out.println(coincidences);
        System.out.println(coincidences / 2);
        System.out.println(isMutant);

        dna.setIsMutant(isMutant);

        dnaRepository.save(dna);

        return isMutant;
    }
    public List<DNA> getAll(){
        return dnaRepository.findAll();
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


}
