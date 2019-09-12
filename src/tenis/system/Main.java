/*
 *
 */
package tenis.system;

/**
 *
 * @author Marcin
 */
public class Main {

    private Controller controller = new Controller();

    public void playerAWonPoint() {
        controller.scorePonint('A');
    }

    public void playerBWonPoint() {
        controller.scorePonint('B');
    }

    public String currentScore() {
        return controller.getCurrentScore();
    }

    public static void main(String[] args) {

    }

}
