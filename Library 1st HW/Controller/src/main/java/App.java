import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        Scanner p = new Scanner(System.in);
        JsonLib y = new JsonLib();
        String f = ("LibFile.txt");
        System.out.println("Выберите опцию \n 1 - Вывести всю библиотеку " +
                "\n 2 - Ввести имя автора и получить написанные им книги " +
                "\n 3 - Вывести информацию о книгах в виде Json файла \n");
        int option = in.nextInt();
        switch (option){
            case 1:
                y.outputLib(f);
                break;
            case 2:
                System.out.println("Введите имя автора");
                String name = p.nextLine();
                y.pickABook(f,name);
                break;
            case 3:
                JsonLib.libToJson();
                break;
            default:
                System.out.println("wrong");
        }

    }
}
