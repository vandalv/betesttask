
## Application Build

Open code filder in CMD(Windows) or Terminal(Linux). And run:
```sh
mvn install
```
to build applcation.
Navigate to /target directory:
```sh
cd target
```
Run Application with:
```sh
java -jar betesttask-0.0.1-SNAPSHOT.jar
```
## Important
By default server.port = 8092 is used.
Port settings can be changed in - "src/main/resources/application.properties"

## Controllers
Shows all matches results:
```sh
http://localhost:8092/results
```
Shows desireble matches results:
```sh
http://localhost:8092/results?limit=10
```
On invalid user input shows all matches results(this behaviour set up as default, but can be changed):
```sh
http://localhost:8092/results?limit=-1
http://localhost:8092/results?limit=0
http://localhost:8092/results?limit=1000
```
Shows all unique competitor names:
```sh
http://localhost:8092/unique-competitors-names
```
Shows all unique competitor names for given competition:
```sh
http://localhost:8092/uefa%20champions%20league/unique-competitors-names
```
Displays "No results were found" when there is no matching competition:
```sh
http://localhost:8092/world%20cup/unique-competitors-names
```
