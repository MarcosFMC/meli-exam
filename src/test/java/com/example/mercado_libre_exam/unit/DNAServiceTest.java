package com.example.mercado_libre_exam.unit;

import com.example.mercado_libre_exam.Exception.EmptyDNASequenceException;
import com.example.mercado_libre_exam.Exception.InvalidCharactersException;
import com.example.mercado_libre_exam.Model.DNA;
import com.example.mercado_libre_exam.Service.DNAService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DNAServiceTest {
	@Autowired
	private DNAService dnaService;
	@Test
	void testHorizontalSequence() throws InvalidCharactersException, EmptyDNASequenceException {

		String[] dnaSequence = {"AAAAGA","CCGTAC","ATATGG","GAAAGA","CCCCTA","TCAATT"};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertTrue(dnaService.isMutant(dna));
	}
	@Test
	void testVerticalSequence() throws InvalidCharactersException, EmptyDNASequenceException {

		String[] dnaSequence = {"ACATGA","CCGTAC","ATATGG","GCATGA","CAACTA","TCAATT"};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertTrue(dnaService.isMutant(dna));

	}
	@Test
	void testDiagonalSequence() throws InvalidCharactersException, EmptyDNASequenceException {

		String[] dnaSequence = {"ACACGA","CAGTAC","CTACGG","GCCAGA","CACCTA","TCACTT"};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertTrue(dnaService.isMutant(dna));

	}
	@Test
	void testIsNonMutant() throws InvalidCharactersException, EmptyDNASequenceException {

		String[] dnaSequence = {"ACACGA","CCGTAC","TTACGG","GCCAGA","CACTTA","TCACTT"};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertFalse(dnaService.isMutant(dna));
	}
	@Test
	public void testInvalidCharactersInDNA() {

		String[] dnaSequence = {"ABZXGA","CCGTAC","TTCFGG","GCZXCA","CACTTA","TQACTT"};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertThrows(InvalidCharactersException.class, () -> dnaService.isMutant(dna));
	}
	@Test
	void testEmptySequence(){

		String[] dnaSequence = {};

		DNA dna = new DNA(dnaSequence);

		Assertions.assertThrows(EmptyDNASequenceException.class,() -> dnaService.isMutant(dna));
	}
}
