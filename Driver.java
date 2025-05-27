package petstore;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();

        String choice = "";
        while (!choice.equals("q")) {
            displayMenu();
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid entry. Try again.");
            }
        }
        scanner.close();
    }

    // Displays the menu options
    public static void displayMenu() {
        System.out.println("\n\nRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.print("Enter a menu selection: ");
    }

    // Adds sample dogs to the list
    public static void initializeDogList() {
        dogList.add(new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States"));
        dogList.add(new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States"));
        dogList.add(new Dog("Bella", "Chihuahua", "female", "4", "25.0", "12-12-2019", "Canada", "in service", true, "Canada"));
    }

    // Adds sample monkeys to the list (optional)
    public static void initializeMonkeyList() {
    	monkeyList.add(new Monkey("George", "male", "3", "10.2", "01-01-2021", "Brazil", "intake", false, "Brazil", "5.2", "2.0", "30", "Capuchin"));
    }

    // Intake new dog
    public static void intakeNewDog(Scanner scanner) {
        System.out.print("What is the dog's name? ");
        String name = scanner.nextLine();

        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("This dog is already in our system.\n");
                return;
            }
        }

        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Age: ");
        String age = scanner.nextLine();
        System.out.print("Weight: ");
        String weight = scanner.nextLine();
        System.out.print("Acquisition date: ");
        String acquisitionDate = scanner.nextLine();
        System.out.print("Acquisition country: ");
        String acquisitionCountry = scanner.nextLine();
        System.out.print("Training status: ");
        String trainingStatus = scanner.nextLine();
        System.out.print("Reserved (true/false): ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("In-service country: ");
        String inServiceCountry = scanner.nextLine();

        dogList.add(new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry));
        System.out.println("Dog added successfully!");
    }

    // Intake new monkey
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.print("What is the monkey's name? ");
        String name = scanner.nextLine();

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("This monkey is already in our system.\n");
                return;
            }
        }

        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Age: ");
        String age = scanner.nextLine();
        System.out.print("Weight: ");
        String weight = scanner.nextLine();
        System.out.print("Acquisition date: ");
        String acquisitionDate = scanner.nextLine();
        System.out.print("Acquisition country: ");
        String acquisitionCountry = scanner.nextLine();
        System.out.print("Training status: ");
        String trainingStatus = scanner.nextLine();
        System.out.print("Reserved (true/false): ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("In-service country: ");
        String inServiceCountry = scanner.nextLine();
        System.out.print("Tail length: ");
        String tailLength = scanner.nextLine();
        System.out.print("Height: ");
        String height = scanner.nextLine();
        System.out.print("Body length: ");
        String bodyLength = scanner.nextLine();
        System.out.print("Species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin): ");
        String species = scanner.nextLine();

        // Validate species
        String[] allowedSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
        boolean validSpecies = false;
        for (String s : allowedSpecies) {
            if (s.equalsIgnoreCase(species)) {
                validSpecies = true;
                break;
            }
        }
        if (!validSpecies) {
            System.out.println("Invalid species. Monkey not added.");
            return;
        }

        monkeyList.add(new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength, species));

        System.out.println("Monkey added successfully!");
    }

    // Reserve animal based on type and country
    public static void reserveAnimal(Scanner scanner) {
        System.out.print("Enter animal type (dog or monkey): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        if (type.equals("dog")) {
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getInServiceLocation().equalsIgnoreCase(country)) {
                    dog.setReserved(true);
                    System.out.println("Dog reserved.");
                    return;
                }
            }
        } else if (type.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getInServiceLocation().equalsIgnoreCase(country)) {
                    monkey.setReserved(true);
                    System.out.println("Monkey reserved.");
                    return;
                }
            }
        } else {
            System.out.println("Invalid type.");
            return;
        }
        System.out.println("No available animal of that type in that country.");
    }

    // Print animals based on type or availability
    public static void printAnimals(String listType) {
        if (listType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                System.out.println(dog.getName() + " | " + dog.getTrainingStatus() + " | " + dog.getAcquisitionLocation() + " | " + dog.getReserved());
            }
        } else if (listType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                System.out.println(monkey.getName() + " | " + monkey.getTrainingStatus() + " | " + monkey.getAcquisitionLocation() + " | " + monkey.getReserved());
            }
        } else if (listType.equalsIgnoreCase("available")) {
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println("Dog: " + dog.getName() + " | " + dog.getInServiceLocation());
                }
            }
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Monkey: " + monkey.getName() + " | " + monkey.getInServiceLocation());
                }
            }
        }
    }
}
