**TESTES UNITÁRIOS:**

Quando utilizamos os testes unitários, estamos testando uma única unidade do código. A ideia é tentar ver se toda aquele módulo funciona quando ele depende de vários outros módulos para o funcionamento.
Para isso, criamos algo chamaro **mock**(uma simulação) de algum código que o CÓDIGO PRINCIPAL dependa para que o teste únitário funcione.
Por exemplo:

Sabemos que o **ServiceLivros** depende do **JpaLivros**, para que tudo funcione certinho, criamos um **mock** para o **JpaLivros** para que para que o nosso teste seja o mais previsível possível.

Quando utilizamos a dependência:
`<dependency>`  
`<groupId>org.springframework.boot</groupId>`  
`<artifactId>spring-boot-starter-test</artifactId>`  
`<scope>test</scope>`  
`</dependency>`
Ele nos disponibiliza o **JUnint** para rodar os testes e o **Mockito** para criar os **mocks**.

**@Mock**
Cria um objeto falso para testes.

**@InjectMocks**
Cria uma instância real de uma classe para podermos injetar o Mock dentro dela.

O teste segue a regra de ouro de qualquer teste unitário, o **AAA (Arrange, Act, Assert)**:
- *Arrange* -> Preparar o código;
- *Act* -> Executar;
- *Assert* -> Verificar;
