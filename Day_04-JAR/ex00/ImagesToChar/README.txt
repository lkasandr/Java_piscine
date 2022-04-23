Exercise 00 : Packages

Instruction is written for the state where the console is opened in the project’s root folder (ex00).

For compiling:
javac  src/java/edu.school21.printer/*/*.java  -d ./target

For starting:
java -cp target edu.school21.printer.app.Program [symbol_1] [symbol_2] [path_to_file]
[symbol_1] is character that should be displayed in place of white pixels
[symbol_2] is character that should be displayed in place of black pixels
[path_to_file] is the full path to the image on your disk.


For example:
java -cp target edu.school21.printer.app.Program . 0 /Users/lkasandr/Desktop/Java_Piscine_04.22_21School/Day_04-JAR/it.bmp
