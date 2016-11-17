package Programming;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class FlatFileDatabase {

    static FlatFileDatabase ffd = new FlatFileDatabase();

    public boolean writeColumns(String columnMeta, String fileName) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(fileName);
        writer.write(columnMeta);
        writer.close();
        return true;

    }

    //Creating a table here along with its name with no entries
    public boolean createTable(String name) throws IOException {
        File file = new File("tables\\"+name);
        return file.createNewFile();
    }
    //finding and destorying table
    public boolean destroyTable(String deleteFile) {
        File file = new File("tables\\"+deleteFile);
        return file.delete();
    }

    //finding some string specific thing
    public String findOne(String folder,String value) throws IOException {
        String line = null;
        int lineNumber = 0;
        BufferedReader in = new BufferedReader(new FileReader("tables\\" + folder));

        while (!(line = in.readLine()).equals(value)) {
            lineNumber++;
        }

        return "Your string is on: " + lineNumber;
    }
    public String[] find(String key, String value,String folder) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(folder));
        String[] temp = null;
        for(int i = 0;sc.hasNext();i++){
            try {
                temp[i] = sc.nextLine();
            } catch (NullPointerException e ){
                e.printStackTrace();
            }
            if (temp.equals(value)) {
                System.out.println(temp[i]);
            } else {
                System.out.println("havent found yet");
            }
        }

        return null;
    }
    public boolean stringUpdate(String oldValue, String newValue,String fileName) throws IOException {


        //declaring the type of text I want to use as the base language
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get("tables\\" + fileName);

        //getting the value of all string in a file within the utf 8 language
        String content = new String(Files.readAllBytes(path), charset);
        content = content.replace(oldValue, newValue);
        Files.write(path, content.getBytes(charset));

        return true;

    }
    public boolean destroy(String oldValue,String fileName) throws IOException{
        return ffd.stringUpdate(oldValue,"",fileName);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("What file name do you want to create? \n");
        String table = sc.nextLine();
        try {
            ffd.createTable(table);
        } catch (IOException e) {
            System.out.println();
        }

        System.out.print("Which file do you want to delete?\n");
        String deleteFile = sc.nextLine();
        ffd.destroyTable(deleteFile);

        System.out.print("Which file do you want to write the lines to?\n");
        String replacedFile = sc.nextLine();
        System.out.print("What words to write?\n");
        String replaceWords = sc.nextLine();
        try {
            ffd.writeColumns(replaceWords,"tables\\"+replacedFile);
        } catch (FileNotFoundException e){
            System.out.println("Error\n");
        }

        System.out.print("What folder do you want to search in to find a string?\n");

        String folder = sc.nextLine();
        System.out.println("What string do you want to find?\n");
        String stringToFind = sc.nextLine();

        try {
            String foundOnLine = ffd.findOne(folder,stringToFind);
            System.out.println(foundOnLine);
        } catch(IOException e) {
            System.out.println("Error\n");
        }



        System.out.print("What value whould you like to update?\n");
        String replaceOldValue = sc.nextLine();
        if (!replaceOldValue.equals("")) {
            System.out.print("What would you like to replace it with?\n");
            String replaceNewValue = sc.nextLine();
            System.out.print("What folder is this in? \n");
            String inAFolder = sc.nextLine();
            try {
                ffd.stringUpdate(replaceOldValue, replaceNewValue, inAFolder);
            } catch (IOException e) {
                System.out.println("Cant find what your looking for");
                e.printStackTrace();
            }
        }
        System.out.print("What words do you wish to delete?\n");
        String deleteWords = sc.nextLine();
        if (!deleteWords.equals("")) {
            System.out.print("What folder is this in? \n");
            String deleteInFolder = sc.nextLine();
            try {
                ffd.destroy(deleteWords, deleteInFolder);
            } catch (IOException e) {
                System.out.println("Cant find what your asking");
                e.printStackTrace();
            }
        }


    }
}