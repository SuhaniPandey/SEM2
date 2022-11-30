package toilet;

public class CleaningPerson implements Runnable {

    private PublicToilet toilet;

    public CleaningPerson(PublicToilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.startCleaning();
            try {
                System.out.println("Cleaning...cleaning the toilet");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toilet.endCleaning();
            System.out.println("Cleaningperson taking a break");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
