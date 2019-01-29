public class Ui {

import java.util.Scanner;

    public void getInput() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }


    public void printList(List<> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". \t" + list.get(i).getName());
        }
    }
}