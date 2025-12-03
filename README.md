# Esercizio di Testing con JUnit

Questo repository contiene un progetto di esercitazione per l'esame di Ingegneria del Software. L'obiettivo è applicare le tecniche di testing unitario utilizzando il framework JUnit.

## PROVA DI LABORATORIO (Simulazione)

Dato il progetto Maven, si chiede di:

- Scaricare il codice sorgente nel proprio computer usando Git.
- La consegna deve avvenire caricando il codice sorgente modificato in un repository GitHub. È importante ignorare i file o le cartelle relative alla configurazione dell'IDE e di Maven (es. `.idea/`, `target/`, `.classpath`), caricando solo i file sorgente e di configurazione del progetto (es. `pom.xml`, `src/`).

- Il progetto Maven deve essere impostato con queste coordinate:
    - Versione: **1.0**
    - Artefatto: **exam-testing-practice**
    - Gruppo: **it.unical.demacs.exam** (o il package del progetto)

- Modificare le informazioni generali del progetto nel `pom.xml` come segue:
    - Nome del progetto: "Esercitazione Testing 2024"
    - URL del progetto: `https://www.unical.it`
    - Descrizione del progetto: Inserire una descrizione adeguata, ad esempio: "Progetto di esercitazione per il testing unitario della classe ShoppingCart con JUnit 5."
    - Anno di inizio del progetto: 2024

- Creare un nuovo branch con il nome **"tests"** per implementare i test.

- Testare la classe **ShoppingCart.java** utilizzando **JUNIT 5**. Si consiglia l'uso di annotazioni come `@BeforeEach`, `@BeforeAll`, `@AfterEach`, o `@AfterAll` a seconda dei casi, e di metodi di asserzione appropriati (es. `assertEquals`, `assertThrows`, `assertTrue`).

- Effettuare il merge del branch **"tests"** con il branch **"main"** una volta che i test siano stati completati. **Non utilizzare Pull Requests su GitHub per il merge**, ma eseguire il merge in locale e poi fare il push di entrambi i branch.

**PS:** Nel repository remoto devono essere presenti sia il branch **main** che il branch **tests**.

**PS.2:** Si consiglia di leggere attentamente i commenti Javadoc dei metodi nella classe `ShoppingCart.java` per comprendere la logica attesa e i possibili casi limite da testare.

**PS.3:** Si consiglia di fare almeno un commit per ogni test case significativo implementato (es. "Test adding new item", "Test removing item successfully", "Test exception for invalid quantity").
