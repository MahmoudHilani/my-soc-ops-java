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

## Design Guide

### Visual Direction
- Current game UI direction is retro 90s Flash-inspired: neon accents, beveled panels, glossy controls, and layered atmospheric backgrounds.
- Keep interfaces expressive and intentional rather than generic or minimal-by-default.
- Avoid introducing unrelated visual styles unless a redesign request explicitly changes direction.

### Typography
- Use distinctive display typography for headings and controls.
- Use a readable companion font for body and gameplay copy.
- Preserve strong hierarchy across title, section labels, hints, and tile content.

### Color and Theme
- Prefer CSS variables in socops/src/main/resources/static/css/app.css for palette and component token values.
- Keep high contrast between interactive states: default, hover, active, selected, winning, and disabled/free.
- Reuse existing theme tokens before adding new color values.

### Motion and Effects
- Use motion intentionally for high-impact moments only (scene entrance, tile mark feedback, victory reveal).
- Avoid excessive constant animation that harms readability or game responsiveness.
- Keep effects CSS-based when possible and performance-safe on low-power devices.

### Layout and Responsiveness
- Ensure the game remains playable on desktop and mobile widths.
- Maintain clear tap targets for bingo tiles and buttons.
- Preserve board legibility and spacing at small breakpoints.

### Frontend Implementation Rules
- Keep game behavior stable while styling: do not break existing IDs, onclick hooks, ARIA attributes, or localStorage snapshot structure.
- Coordinate HTML class updates in templates with matching CSS class definitions.
- For UI changes, validate with mvnw.cmd validate, mvnw.cmd clean package, and mvnw.cmd test on Windows.