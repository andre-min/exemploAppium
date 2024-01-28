### Projeto de teste
Estrutura do projeto packages(**pages**/**Tests**/**utils**)
- pages aqui está as classes separando os fluxos Login/Cadastro
- tests a classe Tests - Instancia as pages
- utils  
  **DriverFactory** - Classe para criação do driver  
  **DSL** - Classe onde crio funções para facilitar os testes das pages.  
  **Locators** localização do elementos, ids, xPaths, classes, etc.


#### Dependências (pom.xml)

- Appium [versão](https://mvnrepository.com/artifact/io.appium/java-client/7.3.0)
- Junit [versão](https://mvnrepository.com/artifact/junit/junit/4.12)

#### Login   
* deveTestarLogin
|![](src/gifs/login.gif)
  
#### Cadastro
* deveTestarCadastro
|![](src/gifs/cadastro.gif)
  
