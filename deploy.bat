@echo off
setlocal

set SRC_DIR=src\main\java
set LIB_DIR=lib
set WEB_DIR=src\main\webapp
set DIST_DIR=dist
for %%a in ("%cd%") do set "CurDir=%%~na"
set OUTPUT_DIR=C:\apache-tomcat-10.1.28\webapps
set WAR_FILE=%OUTPUT_DIR%\%CurDir%.war

if not exist %DIST_DIR% mkdir %DIST_DIR%

echo Deleting existing WEB-INF directory...
rmdir /S /Q %DIST_DIR%\WEB-INF

echo Creating WEB-INF directory...
mkdir %DIST_DIR%\WEB-INF\classes

echo Copying web.xml to WEB-INF...
robocopy "%WEB_DIR%" "%DIST_DIR%" /s /e


echo Lister tous les .java dans un fichier temporaire

for /R %SRC_DIR% %%f in (*.java) do (
    echo %%f >> sources.txt
)

echo supprimer les anciens .class
for /R %%f in (*.class) do del %%f

echo chemin de travail : %cd%
type sources.txt

echo Compiler tous les fichiers listés
javac -cp "%LIB_DIR%\servlet-api.jar;%DIST_DIR%\WEB-INF\classes" -sourcepath "%SRC_DIR%" -d "%DIST_DIR%\WEB-INF\classes" @sources.txt

del sources.txt


echo Creating WAR file...
jar -cvf %WAR_FILE% -C %DIST_DIR% .

call C:\apache-tomcat-10.1.28\bin\startup.bat

endlocal
pause
