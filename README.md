# 🤖 Java Console Chatbot — Design Patterns Assignment

✨ A coherent **Java console-based chatbot** built for the Design Patterns assignment.

The chatbot reads user input from the terminal, supports multiple commands and modes, and demonstrates **active usage of multiple design patterns** from different categories (**behavioural**, **creational**, **structural**).

✅ All patterns are integrated into the **runtime flow** of the application and are **not** merely present as unused example classes.

---

## ▶️ How to Run

### 🧠 Option A — Run in an IDE (IntelliJ / VS Code)

1. Open the project in your IDE.
2. Run the `Main` class:
    - `src/chatbot/app/Main.java`

### 💻 Option B — Run via Terminal (javac / java)

From the project root (PowerShell – Windows):

```powershell
mkdir out
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out chatbot.app.Main
```

---

## ✨ Program Features

- 🔁 Console-based chat loop
- ⛔ `exit` / `quit` to stop the program
- 📖 `/help` command listing available commands
- 🎭 Chatbot modes:
    - `/mode` → show current mode
    - `/mode normal`
    - `/mode study`
    - `/mode support`
- 🎨 Different response styles depending on the active mode
- 🧩 Additional commands:
    - `/calc 2+3`
    - `/joke` (via adapted external service)

---

## 💬 Example Session

```
Console Chatbot started. Type /help.

You: /mode
Bot: Current mode is NORMAL

You: hi
🤖 [12:30:10] Bot: You said: hi

You: /mode study
🤖 [12:30:15] Bot: Mode switched to STUDY

You: explain photosynthesis
🤖 [12:30:20] Bot: 📚 Study mode: Let's break it down. You said: explain photosynthesis

You: /mode support
🤖 [12:30:25] Bot: Mode switched to SUPPORT

You: I feel stressed
🤖 [12:30:30] Bot: 🫶 Support mode: I hear you. You said: I feel stressed
Suggestions: [/mode normal]

You: /joke
🤖 [12:30:35] Bot: Why did the programmer quit his job? Because he didn't get arrays

You: exit
Bot: Bye!
```

---

## 🧠 Design Patterns Implemented

### 🧩 Behavioural Patterns

#### 1️⃣ State Pattern

**Problem**  
The chatbot must support multiple modes (**NORMAL / STUDY / SUPPORT**) with different behavior and clean transitions, without turning the engine into a large conditional structure.

**Solution**  
Each mode is represented as a separate state class.  
The chatbot engine keeps a reference to the current state and delegates:
- state transitions via `handle(Message)`
- response creation via `respond(Message)`

**Where in code**
- `src/chatbot/state/`
    - `ChatState`
    - `NormalState`, `StudyState`, `SupportState`
    - `BaseState`

**Why it fits**  
A chatbot naturally operates in different conversational modes, making the State pattern a clean and maintainable solution.

---

#### 2️⃣ Strategy Pattern

**Problem**  
Each chatbot mode should respond in a different style (neutral, study-focused, supportive), and these behaviors should be interchangeable.

**Solution**  
Response generation is delegated to strategy implementations:
- `NormalStrategy`
- `StudyStrategy`
- `SupportStrategy`

Each state uses a specific strategy to generate its responses.

**Where in code**
- `src/chatbot/strategies/`
    - `ResponseStrategy`
    - `NormalStrategy`, `StudyStrategy`, `SupportStrategy`

**Why it fits**  
Strategies allow response behavior to vary independently from the chatbot engine and state logic.

---

### 🏗️ Creational Patterns

#### 3️⃣ Factory Method (Command Factory)

**Problem**  
The chatbot must handle multiple commands (`/help`, `/mode`, `/calc`, `/joke`) without hardcoding command logic in the engine.

**Solution**  
A `CommandFactory` determines which command should handle a given message.  
Each command implements a common interface and encapsulates its own behavior.

**Where in code**
- `src/chatbot/commands/`
- `src/chatbot/factory/CommandFactory.java`

**Why it fits**  
Commands are created and selected dynamically based on user input, which is a classic use case for the Factory Method pattern.

---

#### 4️⃣ Builder Pattern (ChatResponseBuilder)

**Problem**  
Chatbot responses may consist of more than just text (e.g. suggestions, metadata).

**Solution**  
The `ChatResponseBuilder` constructs immutable `ChatResponse` objects using a fluent API.

**Where in code**
- `src/chatbot/core/ChatResponse`
- `src/chatbot/core/ChatResponseBuilder`

**Why it fits**  
The Builder pattern makes response construction flexible, readable, and extensible.

---

### 🧱 Structural Patterns

#### 5️⃣ Adapter Pattern

**Problem**  
An external joke service returns data in an incompatible format.

**Solution**  
A `JokeServiceAdapter` adapts the external API to a clean internal interface used by the chatbot.

**Where in code**
- `src/chatbot/integrations/`
    - `ExternalJokeApi`
    - `JokeService`
    - `JokeServiceAdapter`

**Why it fits**  
Adapters allow external systems to be integrated without modifying the chatbot core.

---

#### 6️⃣ Decorator Pattern

**Problem**  
Additional response behavior (timestamps, emojis) should be added without modifying core rendering logic.

**Solution**  
Response rendering is wrapped in decorators that dynamically add behavior before output.

**Where in code**
- `src/chatbot/decorators/`
    - `ResponseRenderer`
    - `BaseRenderer`
    - `TimestampDecorator`
    - `EmojiDecorator`

**Why it fits**  
Decorators allow dynamic extension of behavior without changing existing classes.

---

## 🏛️ Architecture Overview

- `Main` starts the application.
- `ChatbotEngine`:
    - reads console input
    - delegates commands to `CommandFactory`
    - delegates conversation handling to State + Strategy
    - renders responses using Decorators
- `Context` maintains the current chatbot state.
- All patterns are part of the active execution flow.

---

## 🤝 Cooperation

This project was developed **in pairs**:

### 👨‍💻 Matin
- Core architecture
- Chatbot engine
- Behavioural patterns (State, Strategy)
- Integration of Factory, Builder, Adapter, and Decorator patterns

### 👨‍💻 Mohammad
- Command system
- Creational patterns (Factory Method, Builder)
- Structural patterns (Adapter, Decorator components)

Development was managed via **GitHub** using a shared repository.  
Both team members contributed regularly with separate commits, ensuring a **balanced workload**.

---

## 📝 Notes

- The application is intentionally console-based as required by the assignment.
- All design patterns are **actively used during runtime**.
- The chatbot has a single coherent purpose and avoids artificial pattern bundling.
