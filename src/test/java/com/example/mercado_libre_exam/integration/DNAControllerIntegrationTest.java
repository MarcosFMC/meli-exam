package com.example.mercado_libre_exam.integration;

import com.example.mercado_libre_exam.Model.DNA;
import com.example.mercado_libre_exam.Service.DNAService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DNAControllerIntegrationTest {
	@Autowired
	private DNAService dnaService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMutantEndpointReturn200ForMutantDNA() throws Exception{

		String dnaSequenceJson = "{\"dna\":[\"AAAAGA\",\"CCGTAC\",\"ATATGG\",\"GAAAGA\",\"CCCCTA\",\"TCAATT\"]}";

		mockMvc.perform(post("/mutant")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dnaSequenceJson)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());

	}

	@Test
	public void testMutantEndpointReturn403ForNonMutantDNA() throws Exception{

		String dnaSequenceJson = "{\"dna\":[\"ACACGA\",\"CCGTAC\",\"TTACGG\",\"GCCAGA\",\"CACTTA\",\"TCACTT\"]}";

		mockMvc.perform(post("/mutant")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dnaSequenceJson)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}

	@Test
	public void testStatsEndpointReturnsCorrectStats() throws Exception {

		String responseExpected = "{\"count_mutant_dna\":1,\"count_human_dna\":1,\"ratio\":1.0}";


		String[] dnaMutantSequence = {"AAAAGA","CCGTAC","ATATGG","GAAAGA","CCCCTA","TCAATT"};

		String[] dnaHumanSequence = {"ACACGA","CCGTAC","TTACGG","GCCAGA","CACTTA","TCACTT"};


		DNA dnaMutant = new DNA(dnaMutantSequence);

		DNA dnaHuman = new DNA(dnaHumanSequence);

		dnaService.isMutant(dnaMutant);

		dnaService.isMutant(dnaHuman);

		mockMvc.perform(get("/mutant/stats")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(responseExpected));
	}
}


