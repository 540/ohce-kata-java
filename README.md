# Java Testing boilerplate

This is a boilerplate ready to start working on programming good practices.

## Properties

Java version: 18

Gradle version: 7.5

Build project:
- ./gradlew build

  :warning: :warning: **Build will fail because of tests, this is done in purpose, have a look at them!**  

---

- Get Java version:
  - java --version

- Update Java version:
  - Download the JDK (version 17 right now)
  - Remember to adjust Intellij settings File > Project Structure > Project

---

- Get current Gradle version:
    - ./gradlew --version
    
- Update Gradle version ([take in account project's Java version for compatibility](https://docs.gradle.org/current/userguide/compatibility.html)):
    - ./gradlew wrapper --gradle-version <gradle-version>