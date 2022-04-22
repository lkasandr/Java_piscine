package ex00;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        List<String> typeList = new ArrayList<>();
        SignatureMap signatureMap = new SignatureMap();

        File file = new File("src/ex00/signatures.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            String[] parse = line.split(", ");
            signatureMap.add(parse[1], parse[0]);
            line = reader.readLine();
        }

        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        while(!path.equals("42"))
        {
            ProcessingFilePath filePath = new ProcessingFilePath(path);
            if (filePath.getIsExcept() == 0)
            {
                String type = filePath.processPath(signatureMap.getSignatures());
                if (type != null) {
                    typeList.add(type);
                    System.out.println("PROCESSED");
                }
                else
                    System.out.println("UNDEFINED");
            }
            path = in.nextLine();
        }
        printList(typeList);
    }

    private static void printList(List<String> typeList) throws Exception
    {
        try {
            FileOutputStream res = new FileOutputStream("src/ex00/result.txt");
            for(int i = 0; i < typeList.size(); ++i)
            {
                res.write(typeList.get(i).getBytes());
                res.write('\n');
            }
            res.flush();
            res.close();
        }
        catch (IOException e)
        {
            System.out.println("File already exist");
        }
    }
}
