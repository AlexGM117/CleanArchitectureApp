<h1 align="center">Clean Architecture Android App (MVVM + MVI)</h1>

A modular and scalable Android app architecture using MVVM, MVI, and Clean Architecture principles. The project is built with multi-module support and clearly separated layers: domain, data, and presentation. Each feature is encapsulated in its own module for better maintainability and scalability.

🧱 **Architecture Overview**

![Architecture](https://github.com/prahaladsharma/CleanArchitectureApp/blob/master/ca01.png)

## 🧩 Module Overview

| Module         | Purpose |
|----------------|---------|
| 🟢 `app`         | Main entry point. Initializes DI, navigation, and app-wide config |
| 🔵 `feature-*`   | Modularized features like login, profile, dashboard |
| 🟡 `presentation`| Jetpack Compose UI, ViewModels, and MVI state contracts |
| 🟠 `domain`      | Business logic: Use cases, entities, and interfaces |
| 🔴 `data`        | Implements repositories, handles network/local data |

---

**## ⚙️ Tech Stack**

- 🧠 **Architecture**: Clean Architecture, MVVM + MVI  
- 🎨 **UI**: Jetpack Compose  
- 🗂 **Modularity**: Multi-module support (feature-based)  
- 🔌 **DI**: Hilt  
- 🌐 **Networking**: Retrofit + OkHttp  
- 💾 **Storage**: Room Database  
- 🧪 **Testing**: JUnit, Mockito

---

**## 🚀 Why Clean Architecture?**

✅ Clear separation of concerns  
✅ Easy to scale and maintain  
✅ Feature isolation = faster build time  
✅ Easier testing and debugging  
✅ Better onboarding for new team members  
✅ Works well with CI/CD

---

**## ⚡ Getting Started**

🧩 **Modules**
**app**
  * Entry point of the app
  * Sets up DI, navigation, and theme

**feature-***
  * Each feature (e.g., login, profile) is in its own module
  * Depends on presentation, domain, and optionally data

**presentation**
  * UI Layer: Jetpack Compose, MVI states, and ViewModels
  * Follows MVVM and MVI patterns

**domain**
  * Pure Kotlin
  * Contains business logic, use cases, and interfaces
  * No Android dependencies

**data**
  * Implements repositories defined in domain
  * Contains network (Retrofit), local DB (Room), and mappers

**📦 Tech Stack**

* Kotlin

* Jetpack Compose for UI

* MVVM + MVI

* Hilt for Dependency Injection

* Retrofit + OkHttp for network

* Room for local storage

* Modularization for scalability

* Clean Architecture principles

## Tech stack & Open-source libraries

- Minimum SDK level 21.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.
- Jetpack Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - Navigation: Facilitates screen navigation, complemented by [Hilt Navigation Compose](https://developer.android.com/jetpack/compose/libraries#hilt) for dependency injection.
  - [Hilt](https://dagger.dev/hilt/): Facilitates dependency injection.
- Architecture:
  - Clean Architecture (Domain - Data - Presentation): Facilitates separation of concerns and promotes maintainability.
  - Domain laye
  - Repository Pattern: Acts as a mediator between different data sources and the application's business logic.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Constructs REST APIs and facilitates paging network data retrieval.


**🔐 Benefits**
* Separation of concerns

* Testable business logic

* Feature scalability

* Better CI/CD & team collaboration
./gradlew build

**🤝 Contributions**
Feel free to fork and create a pull request. Contributions are welcome!

**📄 License**
MIT License - see the LICENSE file for details.
