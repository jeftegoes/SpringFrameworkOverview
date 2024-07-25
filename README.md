# Docker commands and overview <!-- omit in toc -->

## Contents <!-- omit in toc -->

- [1. What is Spring?](#1-what-is-spring)
  - [1.1. The Problem](#11-the-problem)
  - [1.2. Spring Boot Solution](#12-spring-boot-solution)
  - [1.3. Spring Boot and Spring](#13-spring-boot-and-spring)
  - [1.4. Spring Boot Embedded Server](#14-spring-boot-embedded-server)
  - [1.5. Running Spring Boot Apps](#15-running-spring-boot-apps)
  - [1.6. Deploying Spring Boot Apps](#16-deploying-spring-boot-apps)
  - [1.7. General questions](#17-general-questions)
- [2. Spring Initializr](#2-spring-initializr)
  - [2.1. start.spring.io](#21-startspringio)
  - [2.2. Spring Boot CLI](#22-spring-boot-cli)
- [3. REST Controller](#3-rest-controller)
- [4. Spring Projects](#4-spring-projects)
- [5. Maven](#5-maven)
  - [5.1. Without Maven](#51-without-maven)
  - [5.2. Maven Solution](#52-maven-solution)
    - [5.2.1. How Maven Works](#521-how-maven-works)
  - [5.3. Handling JAR Dependencies](#53-handling-jar-dependencies)
  - [5.4. Building and Running](#54-building-and-running)
  - [5.5. Standard Directory Structure](#55-standard-directory-structure)
  - [5.6. Advantages of Maven](#56-advantages-of-maven)
  - [5.7. POM File - pom.xml](#57-pom-file---pomxml)
  - [5.8. Project Coordinates](#58-project-coordinates)
    - [5.8.1. Example of Project Coordinates](#581-example-of-project-coordinates)
    - [5.8.2. Adding Dependencies](#582-adding-dependencies)
  - [5.9. Dependency Coordinates](#59-dependency-coordinates)
- [6. Maven Commands](#6-maven-commands)

# 1. What is Spring?

- Very popular framework for building Java applications.
- Provides a large number of helper classes and annotations.

## 1.1. The Problem

- Building a traditional Spring application is really HARD!!!
  - Q: Which JAR dependencies do I need?
  - Q: How do I set up configuration (xml or Java)?
  - Q: How do I install the server? (Tomcat, JBoss etc...)
- And that's JUST the basics for getting started.

## 1.2. Spring Boot Solution

- Make it easier to get started with Spring development.
- Minimize the amount of manual configuration.
  - Perform auto-configuration based on props files and JAR classpath.
- Help to resolve dependency conflicts (Maven or Gradle).
- Provide an embedded HTTP server so you can get started quickly.
- Tomcat, Jetty, Undertow, ...

## 1.3. Spring Boot and Spring

- Spring Boot uses Spring behind the scenes
- Spring Boot simply makes it easier to use Spring

## 1.4. Spring Boot Embedded Server

- Provide an embedded HTTP server so you can get started quickly.
- Tomcat, Jetty, Undertow, ...
- No need to install a server separately.
- **Self-contained unit Nothing else to install!**

## 1.5. Running Spring Boot Apps

- Spring Boot apps can be run standalone (includes embedded server).
- Run the Spring Boot app from the IDE or command-line.
- `java -jar <name_jar_file>.jar`

## 1.6. Deploying Spring Boot Apps

- Spring Boot apps can also be deployed in the traditional way.
- Deploy Web Application Archive (WAR) file to an external server:
  - Tomcat, JBoss, WebSphere etc ...

## 1.7. General questions

- **Q: Does Spring Boot replace Spring MVC, Spring REST etc ...?**
  - No. Instead, Spring Boot actually uses those technologies.
    ![Spring Boot Overview](/Images/SpringBootOverview.png)
- **Q: Does Spring Boot run code faster than regular Spring code?**
  - No.
  - Behind the scenes, Spring Boot uses same code of Spring Framework.
  - Remember, Spring Boot is about making it easier to get started.
  - Minimizing configuration etc ...
- **Q: Do I need a special IDE for Spring Boot?**
  - No.
  - We can use any IDE for Spring Boot apps ... even use plain text editor.
  - The Spring team provides free Spring Tool Suite (STS) [IDE plugins].
  - Some IDEs provide fancy Spring tooling support.
  - Not a requirement.

# 2. Spring Initializr

## 2.1. start.spring.io

- Quickly create a starter Spring Boot project.
- Select your dependencies.
- Creates a Maven/Gradle project.
- Import the project into your IDE.
- Eclipse, IntelliJ, NetBeans etc ...
- [start.spring.io](https://start.spring.io/)

## 2.2. Spring Boot CLI

# 3. REST Controller

- Basic structure:
  ```java
    @RestController
    public class HelloWorldController {
        @GetMapping("/")
        public String sayHello() {
            return "Hello World!";
        }
    }
  ```

# 4. Spring Projects

- Additional Spring modules built-on top of the core Spring Framework
  - Only use what you need ...
  - Spring Cloud, Spring Data.
  - Spring Batch, Spring Security.
  - Spring Web Services, Spring LDAP.
  - others ...

# 5. Maven

- **What is Maven?**
  - Maven is a Project Management tool.
- Most popular use of Maven is for build management and dependencies.
- **What Problems Does Maven Solve?**
  - When building your Java project, you may need additional JAR files.
    - For example: Spring, Hibernate, Commons Logging, JSON etc...
- One approach is to download the JAR files from each project web site.
- Manually add the JAR files to your build path / classpath.

## 5.1. Without Maven

![Without Maven](/Images/ProjectWithoutMaven.png)

## 5.2. Maven Solution

- Tell Maven the projects we are working with (dependencies)
  - Spring, Hibernate etc...
  - Maven will go out and download the JAR files for those projects for us.
  - And Maven will make those JAR files available during compile/run.
  - Think of Maven as your friendly helper / personal shopper.

### 5.2.1. How Maven Works

![How Maven Works](/Images/HowMavenWorks.png)

## 5.3. Handling JAR Dependencies

- When Maven retrieves a project dependency.
- It will also download supporting dependencies.
- For example: Spring depends on commons-logging...
- Maven will handle this for us automagically.

## 5.4. Building and Running

- When you build and run your app...
- Maven will handle class / build path for us.
- Based on config file, Maven will add JAR files accordingly.

## 5.5. Standard Directory Structure

- Normally when you join a new project.
- Each development team dreams up their own directory structure.
- Not ideal for new comers and not standardized.
- Maven solves this problem by providing a standard directory structure.
  ![Manve Standard Directory Structure](/Images/MavenStandardDirectoryStructure.png)

| Directory          | Description                                                             |
| ------------------ | ----------------------------------------------------------------------- |
| src/main/java      | Your Java source code.                                                  |
| src/main/resources | Properties / config files used by your app.                             |
| src/main/webapp    | JSP files and web config files other web assets (images, css, js, etc). |
| src/test           | Unit testing code and properties.                                       |
| target             | Destination directory for compiled code automatically created by Maven. |

- For new developers joining a project.
- They can easily find code, properties files, unit tests, web files etc...
- Most major IDEs have built-in support for Maven.
- Eclipse, IntelliJ, NetBeans etc.
- IDEs can easily read/import Maven projects.
- Maven projects are portable.
- Developers can easily share projects between IDEs.

## 5.6. Advantages of Maven

- Dependency Management.
  - Maven will find JAR files for you.
  - No more missing JARs.
- Building and Running your Project.
  - No more build path / classpath issues.
- Standard directory structure.

## 5.7. POM File - pom.xml

- POM file = **P**roject **O**bject **M**odel file.
- Configuration file for your project.
  - Basically your "shopping list" for Maven.
- Located in the root of your Maven project `pom.xml`.
- POM File Structure:
  ![Simple POM File](/Images/SimplePOMFile.png)

## 5.8. Project Coordinates

- [Apache Maven - Naming Conventions](https://maven.apache.org/guides/mini/guide-naming-conventions.html)
- Project Coordinates uniquely identify a project:
  ```xml
    <groupId>com.myfirstapp</groupId>
    <artifactId>my-first-app</artifactId>
    <version>1.0-SNAPSHOT</version>
  ```
- Elements:
  | Name | Description |
  |-------------|-----------------------------------------------------------------------------------------------------------|
  | Group ID | Name of company, group, or organization, convention is to use reverse domain name: com.myfirstapp |
  | Artifact ID | Name for this project: my-first-app |
  | Description | A specific release version like: 1.0, 1.6, 2.0, if project is under active development then: 1.0-SNAPSHOT |

### 5.8.1. Example of Project Coordinates

```xml
  <groupId>com.myfirstapp</groupId>
  <artifactId>my-first-app</artifactId>
  <version>1.0.RELEASE</version>
```

```xml
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>6.0.0</version>
```

```xml
  <groupId>org.hibernate.orm</groupId>
  <artifactId>hibernate-core</artifactId>
  <version>6.1.4.Final</version>
```

### 5.8.2. Adding Dependencies

```xml
  <project ...>
  ...
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>6.0.0</version>
    </dependency>
    <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>6.1.4.Final</version>
    </dependency>
  ...
  </dependencies>
  </project>
```

## 5.9. Dependency Coordinates

- To add given dependency project, we need
  - **Group ID**, **Artifact ID**
  - **Version** is optional...
    - Best practice is to include the version (repeatable builds)
- May see this referred to as: **GAV** = **G**roup ID, **A**rtifact ID and **V**ersion.
- How to Find Dependency Coordinates
  - Option 1: Visit the project page (spring.io, hibernate.org etc)
  - Option 2: Visit https://central.sonatype.com (easiest approach)

# 6. Maven Commands

- **Run from command prompt!**
- `mvn archetype:generate -DgroupId=com.packagename -DartifactId=ClassName -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
