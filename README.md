# 📋 Projeto A3 - Testes Automatizados

Suite de testes automatizados em **Java 11** que valida os elementos do formulário-exemplo hospedado em  
[https://www.selenium.dev/selenium/web/web-form.html](https://www.selenium.dev/selenium/web/web-form.html) usando **Selenium WebDriver**, **JUnit 4** e **WebDriverManager**.

---

## ✨ Principais Recursos

| Funcionalidade coberta | Tecnologias | Observações |
| ---------------------- | ----------- | ----------- |
| Campos de texto, senha, textarea | Selenium 4.9.0 | Verifica preenchimento e resposta “Received!” |
| Checkbox & Radio Buttons | JUnit 4.13.2 | Usa asserts para estado selecionado |
| Select (dropdown) | WebDriverWait | Aguarda elemento ficar clicável |
| Data picker e Range slider | Java Time API | Ajusta valor via JavaScript quando necessário |
| Upload de arquivo | Bonigarcia WebDriverManager 6.1 | Dummy file em `src/test/resources` |
| Submit de formulário | Maven Surefire | Avalia texto da página após envio |

* **BaseTest** – configura/encerra o _WebDriver_ (setup/teardown)  
* Cada classe de teste foca em uma funcionalidade específica do formulário.

---

## ⚙️ Pré-requisitos

* JDK 11 ou superior  
* Maven 3.8+  
* Google Chrome instalado

> **Obs.**: O **WebDriverManager** baixa o ChromeDriver correto automaticamente. Se precisar usar um binário específico, basta ajustar em `BaseTest`:
> ```java
> WebDriverManager.chromedriver()
>                 .driverVersion("137.0.7151.69")
>                 .setup();
> ```

---

## 🚀 Como Executar

```bash
# 1. Clone o repositório
git clone https://github.com/<sua-conta>/projeto-a3-tests.git
cd projeto-a3-tests

# 2. Rodar todos os testes
mvn test
