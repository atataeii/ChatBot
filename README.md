# Java Console Chatbot — Design Patterns Assignment

A simple, coherent Java *console-based chatbot* built for the Design Patterns assignment.  
The chatbot reads user input from the terminal, supports basic commands, and demonstrates *active design patterns* in the program flow (not just as unused classes).

---

## How to Run

### Option A — Run in an IDE (IntelliJ / VS Code)
1. Open the project in your IDE.
2. Run the `Main` class:
    - src/chatbot/app/Main.java

### Option B — Run via Terminal (javac/java)

From the project root (PowerShell – Windows):

    mkdir out
    javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
    java -cp out chatbot.app.Main

---

## Program Features (Current)

- Console input/output loop (chat-style)
- `exit` / `quit` to stop the program
- `/help` shows available commands
- Chatbot modes using `/mode ...` commands:
    - `/mode` → show current mode
    - `/mode normal`
    - `/mode study`
    - `/mode support`
- The chatbot responds differently depending on the active mode

---

## Example Session

    === Console Chatbot ===
    Type /help for commands, or 'exit' to quit.

    You: /mode
    Bot: Current mode is NORMAL

    You: hi
    Bot: You said: hi

    You: /mode study
    Bot: Mode switched to STUDY

    You: explain photosynthesis
    Bot: 📚 Study mode: Let's break it down. You said: explain photosynthesis

    You: /mode support
    Bot: Mode switched to SUPPORT

    You: I feel stressed
    Bot: 🫶 Support mode: I hear you. You said: I feel stressed

    You: exit
    Bot: Bye! 👋

---

## Design Patterns Implemented (Up to Phase 3)

### 1) State Pattern (Behavioural)

**Problem**  
The chatbot needs to support multiple modes (NORMAL / STUDY / SUPPORT) with clean transitions, without turning the engine into a giant if-else mess.

**Solution**  
Each mode is represented as its own state class.  
The chatbot engine keeps a reference to the current state and delegates:

- transition logic (switching modes) to the state via `handle(...)`
- response creation to the state via `respond(...)`

This keeps mode-specific logic encapsulated and makes the chatbot easy to extend with new modes.

**Where in code**
- State interface and states: src/chatbot/state/*
    - ChatState
    - NormalState, StudyState, SupportState
    - (optional helper) BaseState

---

### 2) Strategy Pattern (Behavioural)

**Problem**  
Each chatbot mode should respond in a different style (normal echo, study-helper tone, supportive tone). We want to change response behavior without rewriting the engine.

**Solution**  
Each mode uses a strategy that generates responses.  
Strategies are interchangeable implementations of the same interface:

- NormalStrategy
- StudyStrategy
- SupportStrategy

The current state delegates response generation to its strategy, keeping behavior modular and swappable.

**Where in code**
- Strategy interface and implementations: src/chatbot/strategies/*
    - ResponseStrategy
    - NormalStrategy, StudyStrategy, SupportStrategy

---

## Architecture (Current)

- `Main` starts the program.
- `ChatbotEngine`:
    - reads console input
    - creates a `Message`
    - passes it to the current `ChatState`
    - prints the produced `ChatResponse`
- `Message` holds the user text (+ timestamp).
- `ChatResponse` holds the bot output text (currently simple; will be extended later).

---

## Notes

- This project is intentionally kept console-based as required by the assignment.
- The patterns listed above are **active in runtime flow**: mode transitions and response generation depend on State + Strategy logic.
- Additional design patterns from other categories (creational, structural) will be integrated in later phases.
