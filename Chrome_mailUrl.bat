set projectLocation=%~dp0

F:\soft\developer\maven-3.8.5\bin\mvn clean test -Dbrowser=yandex -Dsite=mail -DTestNGFile=%projectLocation%\suitesXml\Test001.xml