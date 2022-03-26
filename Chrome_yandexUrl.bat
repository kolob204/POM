set projectLocation=%~dp0

F:\soft\developer\maven-3.8.5\bin\mvn clean test -Dbrowser=chrome -Dsite=yandex -DTestNGFile=%projectLocation%\suitesXml\Test001.xml