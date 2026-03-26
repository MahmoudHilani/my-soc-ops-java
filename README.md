<div align="center">

# 🎲 Soc Ops

### Social Bingo for In-Person Mixers

**Find people who match the prompts. Get 5 in a row. Win the room.**

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

[🎮 Live Demo](https://copilot-dev-days.github.io/agent-lab-java/) · [📚 Lab Guide](workshop/GUIDE.md) · [🐛 Report a Bug](../../issues)

</div>

---

## ✨ What is Soc Ops?

Soc Ops is a **real-time Social Bingo web app** designed to break the ice at in-person events, meetups, and workshops. Each player gets a unique 5×5 board filled with fun prompts — *"Has visited 3+ countries"*, *"Drinks their coffee black"*, *"Can name 5 programming languages"* — and races to complete a line by finding real people who match.

```
Sample 5×5 Bingo Board
┌─────────┬─────────┬─────────┬─────────┬─────────┐
│ Visited │  Plays  │  Owns   │  Codes  │  Loves  │
│  3+     │ a sport │  a pet  │  on     │ spicy   │
│countries│         │         │weekends │  food   │
├─────────┼─────────┼─────────┼─────────┼─────────┤
│  Early  │  Can    │ ░░░░░░░ │  Has    │  Night  │
│  bird   │ whistle │ ░FREE░  │ a side  │   owl   │
│         │         │ ░░░░░░░ │ project │         │
├─────────┼─────────┼─────────┼─────────┼─────────┤
│  ...    │  ...    │  ...    │  ...    │  ...    │
└─────────┴─────────┴─────────┴─────────┴─────────┘
             Find matches → Tap square → BINGO! 🎉
```

---

## 🚀 Features

- 🃏 **Randomised boards** — every player gets a unique shuffle
- ✅ **One-tap marking** — tap a square when you find a match
- 🏆 **Auto-win detection** — rows, columns, and diagonals
- 💾 **Session persistence** — your board survives a page refresh
- 📱 **Mobile-first** — plays great on any screen size
- 🎨 **Themeable UI** — built to be redesigned in the lab

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 21 · Spring Boot 3.x |
| Templating | Thymeleaf |
| Frontend | Vanilla JS · Custom CSS utilities |
| Build | Apache Maven + Maven Wrapper |
| Deploy | GitHub Actions → GitHub Pages |

---

## ⚡ Quick Start

**Prerequisites:** [Java 21 JDK](https://adoptium.net/) · [Maven 3.9+](https://maven.apache.org/) (or use the included wrapper)

```bash
# Clone and run
git clone <your-repo-url>
cd socops
./mvnw spring-boot:run
```

Then open [http://localhost:8080](http://localhost:8080) in your browser.

```bash
# Build a JAR
./mvnw clean package

# Run all tests
./mvnw test
```

> 💡 **Tip:** The included Maven Wrapper (`./mvnw`) means you don't need Maven installed globally.

---

## 🎓 Workshop Lab Guide

This project is the foundation of a hands-on **VS Code + GitHub Copilot** lab. Use it to learn agentic development patterns in a real Spring Boot codebase.

| Part | Title | Duration |
|------|-------|----------|
| [**00**](workshop/00-overview.md) | Overview & Checklist | — |
| [**01**](workshop/01-setup.md) | Setup & Context Engineering | 15 min |
| [**02**](workshop/02-design.md) | Design-First Frontend | 15 min |
| [**03**](workshop/03-quiz-master.md) | Custom Quiz Master | 10 min |
| [**04**](workshop/04-multi-agent.md) | Multi-Agent Development | 20 min |

📖 **[Open the full Lab Guide →](workshop/GUIDE.md)**

> Lab guides are also available in the [`workshop/`](workshop/) folder for offline reading.

---

## 🤝 Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines, and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for community standards.

---

<div align="center">

Deploys automatically to GitHub Pages on push to `main` · Built with ☕ and GitHub Copilot

</div>
