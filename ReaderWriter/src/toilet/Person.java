package toilet;

public class Person implements Runnable {

    private String name;
    private PublicToilet toilet;

    public Person(String name, PublicToilet toilet) {
        this.name = name;
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.stepIntoCabin();
            try {
                System.out.println(name + " is in bathroom");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toilet.leaveCabin();
            try {
                System.out.println("\t\t\t\t\t\t\t"+name + " get out of bathroom");
                Thread.sleep(System.currentTimeMillis()%1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
