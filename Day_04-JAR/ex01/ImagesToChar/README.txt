Exercise 01 : First JAR

Instruction is written for the state where the console is opened in the project’s root folder (ex01/ImagesToChar).

For compiling:
javac  src/java/edu.school21.printer/*/*.java  -d ./target

For copy *.bmp to target:
cp -R src/resources target

For creating JAR archive:
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

For starting:
java -jar target/images-to-chars-printer.jar [symbol_1] [symbol_2]
[symbol_1] is character that should be displayed in place of white pixels
[symbol_2] is character that should be displayed in place of black pixels.

For example:
java -jar target/images-to-chars-printer.jar . 0
