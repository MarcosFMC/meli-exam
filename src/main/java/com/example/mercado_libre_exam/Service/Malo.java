package com.example.mercado_libre_exam.Service;

import com.example.mercado_libre_exam.Exception.EmptyDNASequenceException;
import com.example.mercado_libre_exam.Exception.InvalidCharactersException;
import com.example.mercado_libre_exam.Model.DNA;

public class Malo {


    /*
    public Boolean isMutant(DNA dna) throws InvalidCharactersException, EmptyDNASequenceException {

        validateDNACharacters(dna.getDna());

        validateEmptyDNASequence(dna.getDna());

        Boolean isMutant = false;

        int coincidences = 0;

        String[] dnaSequence = dna.getDna();

        for (int x = 0; x < dnaSequence.length ; x++) {

            char[] charArray = dnaSequence[x].toCharArray();

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

                if((x + 1) < dnaSequence.length){

                    char downChar = dnaSequence[x + 1].toCharArray()[z];

                    if(currentLetter == downChar){

                        System.out.println("Tenemos coincidencia en la direccion: Abajo");

                        if((x + 2) < dnaSequence.length){

                            char downCharPlus = dnaSequence[x + 2].toCharArray()[z];

                            if(downCharPlus == downChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo");

                                if((x + 3) < dnaSequence.length){

                                    char downCharPlusPlus = dnaSequence[x + 3].toCharArray()[z];

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

                if((x + 1) < dnaSequence.length && (z - 1) >= 0){

                    char downLeftChar = dnaSequence[x + 1].toCharArray()[z - 1];

                    if(currentLetter == downLeftChar){
                        System.out.println("Tenemos coincidencia en la direccion: Abajo izq");

                        if((x + 2) < dnaSequence.length && (z - 2) >= 0){

                            char downLeftCharPlus = dnaSequence[x + 2].toCharArray()[z - 2];

                            if(downLeftCharPlus == downLeftChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo izq");

                                if((x + 3) < dnaSequence.length && (z - 3) >= 0){

                                    char downLeftCharPlusPlus = dnaSequence[x + 3].toCharArray()[z - 3];

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

                if((x + 1) < dnaSequence.length && (z + 1) < charArray.length){

                    char downRightChar = dnaSequence[x + 1].toCharArray()[z + 1];

                    if(currentLetter == downRightChar){
                        System.out.println("Tenemos coincidencia en la direccion: Abajo der");

                        if((x + 2) < dnaSequence.length && (z + 2) < charArray.length){

                            char downRightCharPlus = dnaSequence[x + 2].toCharArray()[z + 2];

                            if(downRightCharPlus == downRightChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Abajo der");

                                if((x + 3) < dnaSequence.length && (z + 3) < charArray.length){

                                    char downLRightCharPlusPlus = dnaSequence[x + 3].toCharArray()[z + 3];

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

                    char upChar = dnaSequence[x - 1].toCharArray()[z];

                    if(currentLetter == upChar){
                        System.out.println("Tenemos coincidencia en la direccion: Arriba");

                        if((x - 2) >= 0){

                            char upCharPlus = dnaSequence[x - 2].toCharArray()[z];

                            if(upCharPlus == upChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba");

                                if((x - 3) >= 0){

                                    char upCharPlusPlus = dnaSequence[x - 3].toCharArray()[z];

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

                    char upRightChar = dnaSequence[x - 1].toCharArray()[z + 1];

                    if(currentLetter == upRightChar){

                        System.out.println("Tenemos coincidencia en la direccion: Arriba der");

                        if((x - 2) >= 0 && (z + 2) < charArray.length){

                            char upRightCharPlus = dnaSequence[x - 2].toCharArray()[z + 2];

                            if(upRightCharPlus == upRightChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba der");

                                if((x - 3) >= 0 && (z + 3) < charArray.length){

                                    char upRightCharPlusPlus = dnaSequence[x - 3].toCharArray()[z + 3];

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

                    char upLeftChar = dnaSequence[x - 1].toCharArray()[z - 1];

                    if(currentLetter == upLeftChar){
                        System.out.println("Tenemos coincidencia en la direccion: Arriba izq");

                        if((x - 2) >= 0 && (z - 2) >= 0){

                            char upLeftCharPlus = dnaSequence[x - 2].toCharArray()[z - 2];

                            if(upLeftCharPlus == upLeftChar){

                                System.out.println("Tenemos segunda coincidencia en la direccion: Arriba izq");

                                if((x - 3) >= 0 && (z - 3) >= 0){

                                    char upLeftCharPlusPlus = dnaSequence[x - 3].toCharArray()[z - 3];

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

     */
}
