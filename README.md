# API de Secuencias de ADN Mutante

Esta API REST permite analizar secuencias de ADN para identificar si un individuo es mutante o humano. Proporciona un endpoint para verificar una secuencia de ADN y otro para obtener estadísticas sobre las secuencias analizadas.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
    - [POST /mutant](#post-mutant)
    - [GET /mutant/stats](#get-mutantstats)
- [Pruebas](#pruebas)
    - [Pruebas Unitarias](#pruebas-unitarias)
    - [Pruebas de Integración](#pruebas-de-integración)
- [Probar en la Nube](#probar-en-la-nube)
- [Autor](#autor)

## Descripción

Esta API recibe una secuencia de ADN representada como un array de strings, en la que cada string representa una fila de una matriz cuadrada NxN. La API verifica si la secuencia cumple con ciertos patrones de mutantes. En caso de ser mutante, la secuencia se registra y se actualizan las estadísticas de secuencias mutantes y humanas.

## Tecnologías

- **Java 17**
- **Spring Boot**
- **Maven** como herramienta de construcción
- **Render** para despliegue

## Instalación

1. Clona el repositorio en tu máquina local:
    ```bash
    git clone https://github.com/MarcosFMC/meli-exam
    cd meli-exam
    ```

2. Asegúrate de tener Maven instalado.
4. Ejecuta la aplicación localmente:
    ```bash
    mvn spring-boot:run
    ```

La API debería estar disponible en `http://localhost:8080` o en el puerto configurado.

## Uso

### Endpoints

#### POST /mutant

- **Descripción**: Verifica si una secuencia de ADN corresponde a un mutante.
- **URL**: `/mutant`
- **Método**: `POST`
- **Body (JSON)**:
    ```json
    {
      "dna": ["AAAAGA", "CCGTAC", "ATATGG", "GAAAGA", "CCCCTA", "TCAATT"]
    }
    ```

- **Respuestas**:
    - `200 OK`: Si la secuencia corresponde a un mutante.
    - `403 Forbidden`: Si la secuencia corresponde a un humano.

#### Ejemplo de Petición (Postman o `curl`):

1. **Desde localhost (si lo estás ejecutando localmente):**
    ```bash
    curl -X POST http://localhost:8080/mutant -H "Content-Type: application/json" -d '{"dna":["AAAAGA","CCGTAC","ATATGG","GAAAGA","CCCCTA","TCAATT"]}'
    ```

2. **Desde el host desplegado en Render (https://meli-exam.onrender.com):**
    ```bash
    curl -X POST https://meli-exam.onrender.com/mutant -H "Content-Type: application/json" -d '{"dna":["AAAAGA","CCGTAC","ATATGG","GAAAGA","CCCCTA","TCAATT"]}'
    ```

#### Respuesta Esperada:

- **Si la secuencia es mutante (200 OK)**:
    ```json
    {
      "message": "Mutant DNA detected"
    }
    ```

- **Si la secuencia es humana (403 Forbidden)**:
    ```json
    {
      "message": "Human DNA detected"
    }
    ```

#### GET /mutant/stats

- **Descripción**: Obtiene estadísticas de la cantidad de secuencias mutantes y humanas analizadas, y el ratio entre ellas.
- **URL**: `/mutant/stats`
- **Método**: `GET`

#### Ejemplo de Petición (Postman o `curl`):

1. **Desde localhost (si lo estás ejecutando localmente):**
    ```bash
    curl -X GET http://localhost:8080/mutant/stats
    ```

2. **Desde el host desplegado en Render (https://meli-exam.onrender.com):**
    ```bash
    curl -X GET https://meli-exam.onrender.com/mutant/stats
    ```

#### Respuesta Esperada:
```json
{
  "count_mutant_dna": 1,
  "count_human_dna": 1,
  "ratio": 1.0
}
```


## Pruebas

### Pruebas Unitarias

Las pruebas unitarias verifican la funcionalidad de los métodos del servicio `DNAService`. Estas pruebas cubren la detección de secuencias mutantes horizontales, verticales, diagonales y no mutantes, así como la validación de secuencias vacías e inválidas.

#### Casos de Prueba:

1. **Secuencia Horizontal**:
    - Verifica una secuencia horizontal mutante.
    ```java
    @Test
    void testHorizontalSequence() throws InvalidCharactersException, EmptyDNASequenceException {
        String[] dnaSequence = {"AAAAGA","CCGTAC","ATATGG","GAAAGA","CCCCTA","TCAATT"};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertTrue(dnaService.isMutant(dna));
    }
    ```

2. **Secuencia Vertical**:
    - Verifica una secuencia vertical mutante.
    ```java
    @Test
    void testVerticalSequence() throws InvalidCharactersException, EmptyDNASequenceException {
        String[] dnaSequence = {"ACATGA","CCGTAC","ATATGG","GCATGA","CAACTA","TCAATT"};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertTrue(dnaService.isMutant(dna));
    }
    ```

3. **Secuencia Diagonal**:
    - Verifica una secuencia diagonal mutante.
    ```java
    @Test
    void testDiagonalSequence() throws InvalidCharactersException, EmptyDNASequenceException {
        String[] dnaSequence = {"ACACGA","CAGTAC","CTACGG","GCCAGA","CACCTA","TCACTT"};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertTrue(dnaService.isMutant(dna));
    }
    ```

4. **Secuencia No Mutante**:
    - Verifica una secuencia que no corresponde a un mutante.
    ```java
    @Test
    void testIsNonMutant() throws InvalidCharactersException, EmptyDNASequenceException {
        String[] dnaSequence = {"ACACGA","CCGTAC","TTACGG","GCCAGA","CACTTA","TCACTT"};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertFalse(dnaService.isMutant(dna));
    }
    ```

5. **Caracteres Inválidos en la Secuencia de ADN**:
    - Verifica que se lance una excepción si la secuencia contiene caracteres inválidos.
    ```java
    @Test
    public void testInvalidCharactersInDNA() {
        String[] dnaSequence = {"ABZXGA","CCGTAC","TTCFGG","GCZXCA","CACTTA","TQACTT"};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertThrows(InvalidCharactersException.class, () -> dnaService.isMutant(dna));
    }
    ```

6. **Secuencia Vacía**:
    - Verifica que se lance una excepción si la secuencia de ADN está vacía.
    ```java
    @Test
    void testEmptySequence() {
        String[] dnaSequence = {};
        DNA dna = new DNA(dnaSequence);
        Assertions.assertThrows(EmptyDNASequenceException.class, () -> dnaService.isMutant(dna));
    }
    ```

### Pruebas de Integración

Las pruebas de integración verifican la funcionalidad de los endpoints de la API. A continuación se describen los casos de prueba de los endpoints:

1. **Endpoint /mutant - Retorna 200 para ADN Mutante**:
    - Verifica que el endpoint retorne `200 OK` cuando el ADN es mutante.
    ```java
    @Test
    public void testMutantEndpointReturn200ForMutantDNA() throws Exception {
        String dnaSequenceJson = "{\"dna\":[\"AAAAGA\",\"CCGTAC\",\"ATATGG\",\"GAAAGA\",\"CCCCTA\",\"TCAATT\"]}";
        String responseExpected = "{\"message\":\"Mutant DNA detected\"}";
        
        mockMvc.perform(post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dnaSequenceJson)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andExpect(content().string(responseExpected));
    }
    ```

2. **Endpoint /mutant - Retorna 403 para ADN Humano**:
    - Verifica que el endpoint retorne `403 Forbidden` cuando el ADN es humano.
    ```java
    @Test
    public void testMutantEndpointReturn403ForNonMutantDNA() throws Exception {
        String dnaSequenceJson = "{\"dna\":[\"ACACGA\",\"CCGTAC\",\"TTACGG\",\"GCCAGA\",\"CACTTA\",\"TCACTT\"]}";
        String responseExpected = "{\"message\":\"Human DNA detected\"}";
        
        mockMvc.perform(post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dnaSequenceJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden()).andExpect(content().string(responseExpected));
    }
    ```

3. **Endpoint /mutant/stats - Retorna las Estadísticas Correctas**:
    - Verifica que el endpoint retorne las estadísticas correctas de ADN mutante y humano, así como su ratio.
    ```java
    @Test
    public void testStatsEndpointReturnsCorrectStats() throws Exception {
        String responseExpected = "{\"count_mutant_dna\":1,\"count_human_dna\":1,\"ratio


## Autor

Desarrollado por MarcosFMC (https://github.com/MarcosFMC).