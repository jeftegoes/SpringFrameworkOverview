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
- [6. Spring Boot Projects](#6-spring-boot-projects)
  - [6.1. Maven Standard Directory Structure with Spring Boot](#61-maven-standard-directory-structure-with-spring-boot)
  - [6.2. Maven Wrapper files](#62-maven-wrapper-files)
  - [6.3. Maven POM file with Spring Boot](#63-maven-pom-file-with-spring-boot)
- [7. Spring Boot Starters](#7-spring-boot-starters)
- [8. Spring Boot Dev Tools](#8-spring-boot-dev-tools)
  - [8.1. IntelliJ Community Edition - DevTools](#81-intellij-community-edition---devtools)
- [9. Spring Boot Actuator](#9-spring-boot-actuator)
  - [9.1. Health Endpoint](#91-health-endpoint)
  - [9.2. Exposing Endpoints](#92-exposing-endpoints)
  - [9.3. Info Endpoint](#93-info-endpoint)
  - [9.4. Spring Boot Actuator Endpoints](#94-spring-boot-actuator-endpoints)
  - [9.5. Exposing Endpoints](#95-exposing-endpoints)
  - [9.6. Get A List of Beans](#96-get-a-list-of-beans)
  - [9.7. Development Process](#97-development-process)
  - [9.8. Security](#98-security)
    - [9.8.1. Secured Endpoints](#981-secured-endpoints)
  - [9.9. Excluding Endpoints](#99-excluding-endpoints)
    - [9.9.1. Development Process](#991-development-process)
  - [9.10. Actuator Example](#910-actuator-example)
- [10. Custom Application Properties](#10-custom-application-properties)
  - [10.1. Development Process](#101-development-process)
  - [10.2. Spring Boot Properties](#102-spring-boot-properties)
    - [10.2.1. Core Properties](#1021-core-properties)
    - [10.2.2. Web Properties](#1022-web-properties)
    - [10.2.3. Actuator Properties](#1023-actuator-properties)
    - [10.2.4. Security Properties](#1024-security-properties)
    - [10.2.5. Data Properties](#1025-data-properties)
- [11. Commands - Run from Command-Line](#11-commands---run-from-command-line)
  - [11.1. Maven Commands](#111-maven-commands)
  - [11.2. Spring commands](#112-spring-commands)

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
- Provide an embedded HTTP server so we can get started quickly.
- Tomcat, Jetty, Undertow, ...

## 1.3. Spring Boot and Spring

- Spring Boot uses Spring behind the scenes
- Spring Boot simply makes it easier to use Spring

## 1.4. Spring Boot Embedded Server

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
  - If we are building a Spring app that needs: Web, Security, ...
  - Simply select the dependencies in the Spring Initializr.
  - It will add the appropriate Spring Boot starters to your `pom.xml`.

## 2.2. Spring Boot CLI

- Alternative to [start.spring.io](https://start.spring.io/).

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
- [Example](/Examples/first-rest-controller/)

# 4. Spring Projects

- Additional Spring modules built-on top of the core Spring Framework
  - Only use what we need ...
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

- Normally when we join a new project.
- Each development team dreams up their own directory structure.
- Not ideal for new comers and not standardized.
- Maven solves this problem by providing a standard directory structure.
  ![Manve Standard Directory Structure](/Images/MavenStandardDirectoryStructure.png)
- For new developers joining a project.
- They can easily find code, properties files, unit tests, web files etc...
- Most major IDEs have built-in support for Maven.
- Eclipse, IntelliJ, NetBeans etc.
- IDEs can easily read/import Maven projects.
- Maven projects are portable.
- Developers can easily share projects between IDEs.
- [Simple Maven Project](/Examples/starter-maven-project/)

## 5.6. Advantages of Maven

- Dependency Management.
  - Maven will find JAR files for us.
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

# 6. Spring Boot Projects

## 6.1. Maven Standard Directory Structure with Spring Boot

![Maven Standard Directory Structure with Spring Boot](/Images/MavenStandardDirectoryStructureWithSpringBoot.png)

## 6.2. Maven Wrapper files

- `mvnw` allows we to run a Maven project.
  - No need to have Maven installed or present on your path.
  - If correct version of Maven is **NOT** found on your computer.
    - **Automatically downloads** correct version and runs Maven.
- Two files are provided:
  - `mvnw.cmd` for MS Windows.
    - `mvnw clean compile test`
  - `mvnw.sh` for Linux/Mac.
    - `./mvnw clean compile test`
- If we already have Maven installed previously.
  - Then we can ignore/delete the `mvnw` files.
    ![Maven Wrapper Files](/Images/MavenWrapperFiles.png)
- Just use Maven as you normally would.
  - `mvn clean compile test`

## 6.3. Maven POM file with Spring Boot

- pom.xml includes info that you entered at Spring Initializr website.
  ```xml
    <groupId>com.starterspringbootproject</groupId>
    <artifactId>starter-spring-boot-project</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  ```
- Spring Boot Starters, a collection of Maven dependencies (Compatible versions).

  ```xml
    <dependencies>
      ...
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
      </dependency>

      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
      </dependency>
      ...
    </dependencies>
  ```

- To package executable `jar` or `war` archive, can also easily run the app.
  ```xml
    <build>
      <plugins>
        <plugin>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
      </plugins>
    </build>
  ```

# 7. Spring Boot Starters

- **The Problem...**
  - Building a Spring application is really HARD!!!
- **Why Is It So Hard?**
  - It would be great if there was a simple list of Maven dependencies.
  - Collected as a group of dependencies ... one-stop shop.
  - So I don't have to search for each dependency.
- **Spring Boot Starters**
  - A curated list of Maven dependencies.
  - A collection of dependencies grouped together.
  - Tested and verified by the Spring Development team.
  - Makes it much easier for the developer to get started with Spring.
  - Reduces the amount of Maven configuration.
- There are 30+ Spring Boot Starters from the Spring Development team.
  | Name | Description |
  |------------------------------|---------------------------------------------------------------------------------------|
  | spring-boot-starter-web | Building web apps, includes validation, REST. Uses Tomcat as default embedded server. |
  | spring-boot-starter-security | Adding Spring Security support. |
  | spring-boot-starter-data-jpa | Spring database support with JPA and Hibernate. |
  | ... | |
- [Full list](https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-starters)

# 8. Spring Boot Dev Tools

- **The Problem...**
  - When running Spring Boot applications.
    - If you make changes to your source code.
    - Then we have to manually restart your application.
- **Solution:** Spring Boot Dev Tools.
  - `spring-boot-devtools` to the rescue!
  - Automatically restarts your application when code is updated.
  - Simply add the dependency to your POM file.
  - No need to write additional code :-).
  - For IntelliJ, need to set additional configurations...
- Adding the dependency to your POM file:
  ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
      <optional>true</optional>
    </dependency>
  ```
- Automatically restarts your application when code is updated.

## 8.1. IntelliJ Community Edition - DevTools

1. IntelliJ Community Edition does not support DevTools by default.

- **Select:** File > Settings > Build, Execution, Deployment > Compiler.
  - **Check box:** Build project automatically.
- **Select:** File > Settings > Advanced Settings.
- Check box: Allow auto-make to ...

2. Apply IntelliJ configurations.
3. Edit `pom.xml` and add spring-boot-devtools.
4. Add new REST endpoint to our app.
5. Verify the app is automatically reloaded.

# 9. Spring Boot Actuator

- **Problem...**
  - How can we monitor and manage my application?
  - How can we check the application health?
  - How can we access application metrics?
- **Solution: Spring Boot Actuator**
  - Exposes endpoints to monitor and manage your application.
  - We easily get DevOps functionality out-of-the-box.
  - Simply add the dependency to your POM file.
  - REST endpoints are **automatically** added to your application.
  - No need to write additional code!
  - We get new REST endpoints for FREE!
  - Adding the dependency to your POM file:
    ```xml
      <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    ```
- Automatically exposes endpoints for metrics out-of-the-box.
- Endpoints are prefixed with: `/actuator`.

## 9.1. Health Endpoint

- `/health` checks the status of your application.
- Normally used by monitoring apps to see if your app is up or down.
  - Health status is customizable based on your own business logic.

## 9.2. Exposing Endpoints

- By default, only `/health` is exposed.
- The `/info` endpoint can provide information about your application.
- To expose `/info`.
- File: `src/main/resources/application.properties`.
  ```
    management.endpoints.web.exposure.include=health,info
    management.info.env.enabled=true
  ```

## 9.3. Info Endpoint

- `/info` gives information about your application.
  - Default is empty.
- Update `application.properties` with your app info.
- File: `src/main/resources/application.properties`
  ```
    info.app.name=Actuator Project
    info.app.description=An example project using Spring Boot Actuator.
    info.app.version=1.0.0
  ```

## 9.4. Spring Boot Actuator Endpoints

- There are 10+ Spring Boot Actuator endpoints:
  | Name | Description |
  |--------------|----------------------------------------------------------------|
  | /auditevents | Audit events for your application |
  | /beans | List of all beans registered in the Spring application context |
  | /mappings | List of all @RequestMapping paths |
  | ... | ... |

## 9.5. Exposing Endpoints

- By default, only `/health` is exposed.
- To expose all actuator endpoints over HTTP.
- File: `src/main/resources/application.properties`
  ```
    # Use wildcard "*" to expose all endpoints
    # Can also expose individual endpoints with a comma-delimited list
    #
    management.endpoints.web.exposure.include=*
  ```

## 9.6. Get A List of Beans

- Access http://localhost:8080/actuator/beans

## 9.7. Development Process

1. Edit `pom.xml` and add `spring-boot-starter-acuator`.
2. View actuator endpoints for: `/health`.
3. Edit `application.properties` to customize `/info`.

## 9.8. Security

- **What about Security?**
  - We may **NOT** want to expose all of this information.
- **Solution**
  - Add Spring Security to project and endpoints are secured.
  ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
  ```

### 9.8.1. Secured Endpoints

- Now when we access: `/actuator/beans`.
  - Spring Security will prompt for login.
  - Default user name: **user**.
  - Check console logs for password.
- We can override default user name and generated password.
- File: `src/main/resources/application.properties`
  ```
    spring.security.user.name=jefte
    spring.security.user.password=euamojesus
  ```
- We can customize Spring Security for Spring Boot Actuator.
- Use a database for roles, encrypted passwords etc...

## 9.9. Excluding Endpoints

- To exclude `/health`
- File: `src/main/resources/application.properties`
- `management.endpoints.web.exposure.exclude=health`

### 9.9.1. Development Process

1. Edit `pom.xml` and add `spring-boot-starter-security`.
2. Verify security on actuator endpoints for: `/beans` etc.
3. Disable endpoints for `/health` and `/info`.

## 9.10. Actuator Example

[Actuator Example](/Examples/actuator-project/)

# 10. Custom Application Properties

- **Problem**
  - You need for your app to be configurable ... no hard-coding of values.
  - You need to read app configuration from a properties file.
- **Solution:**
  - Application Properties file.
  - By default, Spring Boot reads information from a standard properties file.
    - Located at: `src/main/resources/application.properties`
      - Standard Spring Boot file name.
- You can define ANY custom properties in this file.
- Your Spring Boot app can access properties using `@Value`.
  - No additional coding or configuration required.

## 10.1. Development Process

1. Define custom properties in `application.properties`.
   1. File: `src/main/resources/application.properties`.
   2. ```
        books.name=Bible
        authors.name=God
      ```
2. Inject properties into Spring Boot application using `@Value`.

```java
  @RestController
  public class MyRestController {
      @Value("${books.name}")
      private String book;

      @Value("${authors.name}")
      private String author;

      @GetMapping("/")
      public String GetBook() {
          return "Book: " + book + " By " + author;
      }
  }
```

## 10.2. Spring Boot Properties

- Spring Boot can be configured in the `application.properties` file.
- Server port, context path, actuator, security etc ...
- Spring Boot has 1,000+ properties.
- The properties are roughly grouped into the following categories:
  - Core
  - Web
  - Security
  - Actuator
  - Integration
  - DevTools
  - Data
  - Testing

### 10.2.1. Core Properties

```
  # Log levels severity mapping
  logging.level.org.springframework=DEBUG
  logging.level.org.hibernate=TRACE
  logging.level.com.myfirstapp=INFO

  # Log file name
  logging.file.name=my-crazy-stuff.log
  logging.file.path=c:/myapps/demo
```

### 10.2.2. Web Properties

```
  # HTTP server port
  server.port=7070
  # Context path of the application
  server.servlet.context-path=/my-first-app
  # Default HTTP session time out
  server.servlet.session.timeout=15m
```

### 10.2.3. Actuator Properties

```
  # Endpoints to include by name or wildcard
  management.endpoints.web.exposure.include=*
  # Endpoints to exclude by name or wildcard
  management.endpoints.web.exposure.exclude=beans,mapping
  # Base path for actuator endpoints
  management.endpoints.web.base-path=/actuator
```

### 10.2.4. Security Properties

```
  # Default user name
  spring.security.user.name=admin

  # Password for default user
  spring.security.user.password=admin@123
```

### 10.2.5. Data Properties

```
  # JDBC URL of the database
  spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

  # Login username of the database
  spring.datasource.username=admin

  # Login password of the database
  spring.datasource.password=admin@123
```

# 11. Commands - Run from Command-Line

- During development we spend most of our time in the IDE.
- However, we may want to run our Spring Boot app outside of the IDE.
- One approach is running from the command-line.
- When running from the command-line.
- No need to have IDE open/running.
- Since we using Spring Boot, the server is embedded in our JAR file.
- No need to have separate server installed/running .
- Spring Boot apps are **self-contained**.
- Two options for running the app
- Option 1: Use `java -jar <my_jar_file.jar>`
- Option 2: Use Spring Boot Maven plugin
  - `mvnw spring-boot:run`

## 11.1. Maven Commands

- **Run from command prompt!**
- Create new Maven project
  - `mvn archetype:generate -DgroupId=com.packagename -DartifactId=ClassName -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
- Rum Spring Boot project
  - `mvn spring-boot:run`
- Test...
  - `mvn clean install -U`

## 11.2. Spring commands

- List of possibilities
  - `spring init --list`
- Create new Maven project with Spring Boot
  - `spring init --type=maven-project --javaVersion=22 --artifactId=starter-spring-boot-project --groupId=com.starterpringbootproject`
  - `spring init --type=maven-project --javaVersion=22 --artifactId=starter-rest-controller --groupId=com.starterrestcontroller --dependencies=web,devtools,actuator,security`
    - spring-boot-devtools
    - spring-boot-starter-web
    - spring-boot-starter-security
    - spring-boot-starter-actuator
