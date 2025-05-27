package petstore;
// Monkey.java

public class Monkey extends RescueAnimal {

    // Monkey-specific attributes
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructor
    public Monkey(String name, String gender, String age, String weight,
                  String acquisitionDate, String acquisitionCountry, String trainingStatus,
                  boolean reserved, String inServiceCountry,
                  String tailLength, String height, String bodyLength, String species) {

        // Inherited attributes from RescueAnimal
        setName(name);
        setAnimalType("Monkey"); // Important for polymorphism
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        // Monkey-specific attributes
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        this.species = species;
    }

    // Accessor and Mutator methods for each attribute

    // Gets the tail length of the monkey
    public String getTailLength() {
        return tailLength;
    }

    // Sets the tail length of the monkey
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Gets the height of the monkey
    public String getHeight() {
        return height;
    }

    // Sets the height of the monkey
    public void setHeight(String height) {
        this.height = height;
    }

    // Gets the body length of the monkey
    public String getBodyLength() {
        return bodyLength;
    }

    // Sets the body length of the monkey
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    // Gets the species of the monkey
    public String getSpecies() {
        return species;
    }

    // Sets the species of the monkey
    public void setSpecies(String species) {
        this.species = species;
    }
}
