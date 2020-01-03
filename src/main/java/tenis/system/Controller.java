
package tenis.system;

import static tenis.system.Points.*;

/**
 * @author Marcin
 */
public class Controller {

    private final Player playerA = new Player();
    private final Player playerB = new Player();
    private final ResultBuilder resultBuilder = new ResultBuilder(playerA, playerB);
    private boolean tieBreak = false;

    public void scorePoint(char player) {
        if (playerA.getSets() == 3 || playerB.getSets() == 3) {
            return;//end of match
        }

        if (player == 'A') {
            playerA.setPoints(addPoint(POINT));
        } else if (player == 'B') {
            playerB.setPoints(addPoint(POINT));
        }
        pointController();
    }

    private void pointController() {

        int pointDiffrent = Math.abs(playerA.getPoints() - playerB.getPoints());

        if (!tieBreak) {//todo FOUR and others  change to points real name like 15 , 40 etc..
            if ((playerA.getPoints() >= FOUR || playerB.getPoints() >= FOUR) && pointDiffrent >= TWO) {
                gameController();
            }
        } else {
            if ((playerA.getPoints() >= SEVEN || playerB.getPoints() >= SEVEN) && pointDiffrent >= TWO) {
                setController();
            }

        }

    }

    private void gameController() {

        if (playerA.getPoints() > playerB.getPoints()) {
            playerA.setGames(addPoint(POINT));
        } else {
            playerB.setGames(addPoint(POINT));
        }

        playerA.setPoints(ZERO);
        playerB.setPoints(ZERO);

        int gameDiffrent = Math.abs(playerA.getGames() - playerB.getGames());

        if (playerA.getGames() == 6 && playerB.getGames() == 6) {
            tieBreak = true;
            return;
        }

        if (getCurrentSet() == 5) {
            if (playerA.getGames() == 12 && playerB.getGames() == 12) {
                tieBreak = true;
                return;
            }

            if ((playerA.getGames() >= 12 || playerB.getGames() >= 12) && gameDiffrent >= TWO) {
                setController();
            }

        } else {

            if ((playerA.getGames() >= 6 || playerB.getGames() >= 6) && gameDiffrent >= TWO) {
                setController();
            }

        }

    }

    private void setController() {

        if (!tieBreak) {
            if (playerA.getGames() > playerB.getGames()) {
                playerA.setSets(addPoint(POINT));
            } else {
                playerB.setSets(addPoint(POINT));
            }

        } else if (playerA.getPoints() > playerB.getPoints()) {
            playerA.setSets(addPoint(POINT));
        } else {
            playerB.setSets(addPoint(POINT));
        }

        playerA.setPoints(ZERO);
        playerB.setPoints(ZERO);
        playerA.setGames(ZERO);
        playerB.setGames(ZERO);

        tieBreak = false;

    }

    private int getCurrentSet() {
        return (playerA.getSets() + playerB.getSets()) + 1;
    }

    String getCurrentScore() {
        return resultBuilder.buildResult();
    }

    private int addPoint(int point) {
        return +point;
    }

    private class ResultBuilder {

        public ResultBuilder(Player playerA, Player playerB) {
            this.playerA = playerA;
            this.playerB = playerB;
        }

        private final StringBuilder result = new StringBuilder("");
        private final Player playerA;
        private final Player playerB;

        public String getCurrentScore() {
            return buildResult();
        }

        private String buildResult() {
            result.delete(ZERO, result.length());

            if (!tieBreak) {
                return result.append(playerA.getSets())
                        .append('/')
                        .append(playerB.getSets())
                        .append(' ')
                        .append(playerA.getGames())
                        .append('/')
                        .append(playerB.getGames())
                        .append(' ')
                        .append(playerA.toString(playerB))
                        .toString();
            } else {
                return result.append(playerA.getSets())
                        .append('/')
                        .append(playerB.getSets())
                        .append(' ')
                        .append(playerA.getGames())
                        .append('/')
                        .append(playerB.getGames())
                        .append(' ')
                        .append(playerA.getPoints())
                        .append('/')
                        .append(playerB.getPoints())
                        .toString();
            }

        }

    }

}
