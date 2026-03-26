# Soc Ops Workspace Instructions

## Mandatory Development Checklist
Run these before finalizing any change:
- [ ] Lint: `mvnw.cmd validate` (Windows) or `./mvnw validate` (Unix)
- [ ] Build: `mvnw.cmd clean package` (Windows) or `./mvnw clean package` (Unix)
- [ ] Test: `mvnw.cmd test` (Windows) or `./mvnw test` (Unix)

## Project Snapshot
- Java 21, Spring Boot 3.x, Maven Wrapper, Thymeleaf
- Entry point: socops/src/main/java/com/socops/SocOpsApplication.java
- API: socops/src/main/java/com/socops/web/BingoRestController.java
- Core logic: socops/src/main/java/com/socops/service/BoardAssembler.java
- Templates: socops/src/main/resources/templates/
- Static assets: socops/src/main/resources/static/
- Tests: socops/src/test/java/

## Run Locally
- Run app: `mvnw.cmd spring-boot:run` (Windows) or `./mvnw spring-boot:run` (Unix)
- URL: http://localhost:8080

## Windows JAVA_HOME Fix
If Maven reports missing `JAVA_HOME`, run:

$javaHome = (java -XshowSettings:properties -version 2>&1 | Select-String 'java.home' | Select-Object -First 1).ToString().Split('=')[1].Trim();
$env:JAVA_HOME = $javaHome;
$env:Path = ((Join-Path $env:JAVA_HOME 'bin') + ';' + $env:Path)

## Coding Expectations
- Keep controllers thin and move business logic to services.
- Prefer focused changes and Java 21 compatibility.
- Add/update JUnit tests for behavior changes.
- Reuse CSS utilities in socops/src/main/resources/static/css/app.css.
- Preserve current visual language unless redesign is requested.