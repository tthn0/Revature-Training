# Prerecorded Question Prompts

<details>
  <summary><b>1. Describe Java and its core components.</b></summary>

- Java is a high-level Object-Oriented Programming language
  - Meaning that it is designed for humans to read and write code easily
  - Without having to worry about memory management, CPU registers, or RAM addresses
- Java has a "write once, run anywhere" philosophy
  - Meaning that Java code is highly cross-compatible
  - This allows developers to write code on one OS
  - And ship it to other operating systems
  - Without needing to rewrite or recompile anything
- Java has a Virtual Machine called the JVM
  - To execute the compiled bytecode.
  - The JVM consists of a line-by-line interpreter,
  - as well as a Just-In-Time compiler
- On top of the JVM,
  - There's also the JRE, which stands for Java Runtime Environment.
  - This includes the JVM as well as other standard Java libraries.
  - The JRE is what runs Java code on a machine.
- On top of the JRE, there is also the JDK.
  - This stands for the Java Development Kit.
  - And is needed by developers because it contains the JRE
  - As well as other necessary tools for developing Java programs
  - Like the Java compiler.

</details>

<details>
  <summary><b>2. Describe OOP and how it's implemented in Java.</b></summary>

- Object-oriented programming is a paradigm that describes writing code in a specific manner
  - Using classes, objects, and methods
  - Instead of traditional functional programming or procedural programming.
- There are four pillars of OOP that can be remembered using the acronym `APIE`:
  - The A stands for Abstraction:
    - This means hiding complex implementation details away from the user,
    - So they can focus more on what the code does
    - Instead of how it works under-the-hood.
    - In Java, abstraction can be achieved using abstract classes and interfaces.
  - The P stands for Polymorphism:
    - Which means "many forms".
    - This allows us to write code that can behave differently based on the context.
    - In Java, polymorphism can be achieved through method overloading and overriding.
  - The I stands for Inheritance:
    - Which allows for one child class to inherit fields and methods from another parent class.
    - This is helpful to prevent rewriting duplicate code.
    - In Java, this can be done by using the `extends` keyword as well as method overriding.
    - Java supports single level, multilevel, and hierarchical inheritance but NOT multiple class inheritance.
  - The E stands for Encapsulation:
    - Which is the process of restricting direct access to an object’s fields
    - And instead using getters and setters to read or update them.
    - This allows more control over object fields
    - And also prevents dependent code from breaking in if internal implementation needs to change.
    - In Java, encapsulation can be achieved by marking all fields as private
    - And writing public getter and setter methods.

</details>
