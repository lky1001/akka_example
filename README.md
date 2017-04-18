# akka_example

### akka ping pong test

- java 1.8
- gradle 1.4
- akka 2.5.0

### build

```aidl
$ ./gradlew build
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:jar
:assemble
:compileTestJava UP-TO-DATE
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test UP-TO-DATE
:check UP-TO-DATE
:build

BUILD SUCCESSFUL

Total time: 2.572 secs
```

### run

```aidl
$ java -jar build/libs/akkaexample-1.0-SNAPSHOT.jar 
started
[INFO] [04/18/2017 11:36:18.071] [TestSystem-akka.actor.default-dispatcher-2] [akka://TestSystem/user/pingActor] Ping received : start
[INFO] [04/18/2017 11:36:18.071] [TestSystem-akka.actor.default-dispatcher-2] [akka://TestSystem/user/pingActor/pongActor] Pong received : ping
[INFO] [04/18/2017 11:36:19.073] [TestSystem-akka.actor.default-dispatcher-2] [akka://TestSystem/user/pingActor] Ping received : pong
[INFO] [04/18/2017 11:36:19.073] [TestSystem-akka.actor.default-dispatcher-4] [akka://TestSystem/user/pingActor/pongActor] Pong received : ping
^C[INFO] [04/18/2017 11:36:19.354] [Thread-0] [CoordinatedShutdown(akka://TestSystem)] Starting coordinated shutdown from JVM shutdown hook
```