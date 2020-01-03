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

    public void playerBWonPoint() {
        controller.scorePoint('B');
    }

    public void playerAWonPoint() {
        controller.scorePoint('A');
    }

    public String currentScore() {
        return controller.getCurrentScore();
    }

    public static void main(String[] args) {

    }

}
