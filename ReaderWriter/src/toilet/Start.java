package toilet;

public class Start {
    public static void main(String[] args) {
        PublicToilet toilet = new ToiletBuilding(5);
        for (int i = 0; i < 15; i++) {
            new Thread(new Person("XYZ " + i,toilet)).start();
        }
        new Thread(new CleaningPerson(toilet)).start();
    }
}
