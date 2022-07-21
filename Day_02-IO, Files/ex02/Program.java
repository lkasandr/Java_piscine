package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
    private static File file;

    public static void main(String[] args)
    {
        if ((args.length != 1) || !args[0].startsWith("--current-folder="))
        {
            System.out.println("Invalid arguments!");
            System.exit(1);
        }
        file = new File(args[0].substring(17));
        checkDirectory();
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        while(!command.equals("exit"))
        {
            runCommand(command);
            command = in.nextLine();
        }
        in.close();
    }

    private static void runCommand(String command)
    {
        if (command.equals("ls"))
            runLS();
        else if (command.startsWith("cd"))
            runCD(command);
        else if (command.startsWith("mv"))
            runMv(command);
        else
            System.out.println("Unknown command. Try again");
    }

    private static void runMv(String command)
    {
        String[] commandMV = command.split(" ");
        if (commandMV.length != 3 || !commandMV[0].equals("mv"))
        {
            System.out.println("Invalid MV command!");
            return ;
        }
        Path pathWhat = Paths.get(file.toPath().toString() + "/" + commandMV[1]).normalize();
        Path pathWhere = Paths.get(file.toPath().toString() + "/" + commandMV[2]).normalize();
        File what = new File(pathWhat.toString());
        if (!what.isFile())
        {
            System.out.println("Invalid file name (MV)");
            return ;
        }
        File where = new File(pathWhere.toString());
        if (!where.isDirectory())
        {
            what.renameTo(where);
        }
        else
        {
            where = new File(pathWhere.toString() + "/" + what.getName());
            moveFile(what.toPath(), where.toPath());
        }
    }

    private static void moveFile(Path src, Path dest)
    {
        try {
            Files.move(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runCD(String command)
    {
        String[] commandCd = command.split(" ");
        if (commandCd.length != 2 || !commandCd[0].equals("cd"))
        {
            System.out.println("Invalid CD command!");
            return ;
        }
        String folder_name = commandCd[1];
        if (folder_name.equals("."))
            folder_name = file.toPath().toString();
        else if (folder_name.equals(".."))
        {
            String path = file.toPath().toString();
            int lastOccurrenceSlash = path.lastIndexOf('/');
            folder_name = path.substring(0, lastOccurrenceSlash);
        }
        else if (folder_name.startsWith("./"))
            folder_name = file.toPath().toString() + folder_name.substring(1);
        else if (folder_name.startsWith("../"))
        {
            String path = file.toPath().toString();
            int lastOccurrenceSlash = path.lastIndexOf('/');
            folder_name = path.substring(0, lastOccurrenceSlash) + folder_name.substring(2);
        }
        else
        {
            folder_name = file.toPath().toString() + "/" + folder_name;
        }
        file = new File(folder_name);
        checkDirectory();
    }

    private static void runLS()
    {
        try {
            for (File item : file.listFiles())
            {
                System.out.print(item.getName() + " ");
                if (item.isFile())
                    System.out.print(item.length() /1024 + " ");
                else
                    System.out.print(Files.walk(item.toPath()).mapToLong(p -> p.toFile().length()).sum() / 1024 + " ");
                System.out.println("KB");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void checkDirectory()
    {
        if (!file.isDirectory())
        {
            System.out.println("Invalid path to directory!");
            System.exit(1);
        }
        else if (!Files.isReadable(file.toPath()))
        {
            System.out.println("Access is denied!");
            System.exit(1);
        }
        System.out.println(file.toPath());
    }
}
