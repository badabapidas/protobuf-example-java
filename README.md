# protobuf-example-java
This project is based on the protocol buffer 3. A basic understanding how proto buff 3 works.
This is created in intelliJ Idea. Gradle is used for building. 

### build project

Install the dependencies and devDependencies and start the server.
```
gradlew build
```

Genrated sources can be found
```
${buildDir}\generated\source\proto\main\java
```
Java sources to deal with the auto generated builders to serialize/deserialize messages can be found
```
src\main\java
```
Proto files can be found
```
src\main\proto
```
Data can be store in any binary file. Here you can find in simpmle_messsage.bin. Which can`t be read directly.
```
simple_messsage.bin
```

