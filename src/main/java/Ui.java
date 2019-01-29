import java.util.Scanner;
import java.util.List;


public class Ui {

    public String getInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }


    public void printList(List<Question> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". \t" + list.get(i).getQuestion());
        }
    }
}