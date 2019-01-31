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

    public void menu() {

        int option;
        int subOption;
        do {
            clearScreen();
            FactParser factParser = new FactParser("src/main/resources/Facts.xml");
            RuleParser ruleParser = new RuleParser("src/main/resources/Rules.xml");
            ESProvider esp = new ESProvider(factParser, ruleParser);

            System.out.println("Main Menu\n1. List games\n2. Filter games\n0. Exit");
            Scanner menuScanner = new Scanner(System.in);
            option = menuScanner.nextInt();
            switch (option) {
                case 1:
                    clearScreen();
                    FactRepository fp = factParser.getFactRepository();
                    int i = 1;
                    for (Fact fact: fp.getFacts()) {
                        System.out.println(i + ". " + fact.getDescription());
                        i++;
                    }
                    promptEnterKey();
                    clearScreen();
                    break;

                case 2:
                    clearScreen();
                    esp.collectAnswers();
                    if(esp.evaluate().size() == 0){
                        System.out.println("No such game found");
                    } else {
                        int counter = 1;
                        for(String fact: esp.evaluate()) {
                            System.out.println(counter + ". " + fact);
                            counter++;
                        }
                        do {
                            System.out.println("\n1. Game info page\n0. Back to main menu");
                            Scanner subScanner = new Scanner(System.in);
                            subOption = subScanner.nextInt();
                            System.out.println();
                            switch (subOption) {
                                case 1:
                                    System.out.println("Not implemented yet");
                            }
                        } while (subOption != 0);
                    }
            }
        } while(option != 0);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void promptEnterKey(){
        System.out.println("\n Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}