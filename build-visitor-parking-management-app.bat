@echo off
Rem constants
set zeitslotVerwaltungBackend=zeitslot-verwaltung-backend
set zeitslotVerwaltungJarName=%zeitslotVerwaltungBackend%-1.0-SNAPSHOT.jar
set zeitslotVerwaltungBaseDir="F:\Dominic\Documents\Eigene Dateien\Programmierung\Java only\zeitslot-verwaltung\zeitslot-verwaltung\"
set zeitslotVerwaltungBuildOutputDir="%zeitslotVerwaltungBaseDir%%zeitslotVerwaltungBackend%\build\libs\%zeitslotVerwaltungJarName%"
set GRADLE_OPTS=-Dfile.encoding=utf-8
set buildStartedAtPath=%cd%


Rem build web resources
echo "<==========================================>"
echo "<===    zeitslot-verwaltung-web-ui   ====>"
echo "<==========================================>"
call build-zeitslot-verwaltung-management-web-ui.bat

Rem build aquabasilea-kurs-bucher-rest-app
echo "<============================================>"
echo "<===  zeitslot-verwaltung-backend  ===>"
echo "<============================================>"

cd %zeitslotVerwaltungBaseDir%
cd %zeitslotVerwaltungBackend%
call gradlew clean build -x test publishToMavenLocal
cd ..

Rem copy file back
cd %buildStartedAtPath%
cd..
xcopy "%zeitslotVerwaltungBuildOutputDir%" /y /s
RMDIR %webTargetPath% /S /Q
pause