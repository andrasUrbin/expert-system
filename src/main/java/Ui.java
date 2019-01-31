import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
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
                        int gameChoice;
                        int counter = 1;
                        for(Fact fact: esp.evaluate()) {
                            System.out.println(counter + ". " + fact.getDescription());
                            counter++;
                        }
                        do {
                            System.out.print("\n1. Game info page (please specify the number or hit 0 to go back): ");
                            gameChoice = menuScanner.nextInt();
                            String id = "";
                                if (gameChoice != 0) {
                                    for (int j = 0; j < esp.evaluate().size() + 1; j++) {
                                        if (gameChoice == j) {
                                            id = esp.evaluate().get(j - 1).getId();
                                        }
                                    }
                                    openLink(getLink(id));
                                }

                        } while (gameChoice != 0);
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

    public void openLink(String link) {
        Desktop desktop = Desktop.getDesktop();
        URI uri = URI.create(link);
        try {
            desktop.browse(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLink(String id) {
        String link = "";
        String[][] data = read("src/main/resources/links.csv");
        for (int i = 0; i < data.length; i++) {
            if (id.equals(data[i][0])) {
                link = data[i][1];
            }
        }
        return link;
    }

    public String[][] read(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[][] data = new String[0][0];
            while (br.ready()) {
                int numOfLines = countLines(file);
                int numOfFields = countCols(file);

                data = new String[numOfLines][numOfFields];
                for (int i = 0; i < numOfLines; i++) {
                    data[i] = br.readLine().split(",");
                }
            }
            return data;

        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return null;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return null;
        }
    }

    public int countLines(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                i++;
            }
            return i;

        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return 0;
        }
    }

    public int countCols(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String countFieldString = br.readLine();
            i = countFieldString.length() - countFieldString.replace(",", "").length() + 1;
            return i;

        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return 0;
        }
    }
}