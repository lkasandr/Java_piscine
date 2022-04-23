Exercise 02 : JCommander & JCDP

Instruction is written for the state where the console is opened in the project’s root folder (ex02/ImagesToChar).

For compiling:
javac -d target -sourcepath src/java -cp lib/JCDP-4.0.2.jar:lib/jcommander-1.72.jar:. src/java/edu.school21.printer/*/*.java

For making jar-class:
jar -xf lib/jcommander-1.78.jar
jar -xf lib/JCDP-2.0.3.1.jar

For copy *.bmp and jar-class to target:
cp -R src/resources target
mv com target

For creating JAR archive:
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

For starting:
java -jar target/images-to-chars-printer.jar --white=[COLOR1] --black=[COLOR2]

For example:
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
