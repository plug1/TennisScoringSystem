
package tenis.system;

/**
 *
 * @author Marcin
 */
public class Controller {

    final private Player playerA = new Player();
    final private Player playerB = new Player();
    final private ResultBuilder resultBuilder = new ResultBuilder(playerA, playerB);
    private boolean tieBreak = false;

    public void scorePonint(char player) {
        
        
        if (playerA.getSets()==3 || playerB.getSets() ==3){
            return;//end of match
        }

        if (player == 'A') {
            playerA.setPoints(+1);
        } else {
            playerB.setPoints(+1);
        }
        pointController();
    }

    private void pointController() {

        int pointDiffrent = Math.abs(playerA.getPoints() - playerB.getPoints());

        if (!tieBreak) {
            if (playerA.getPoints() >= 4 || playerB.getPoints() >= 4) {
                if (pointDiffrent >= 2) {
                    gameController();
                }
            }
        } else {
            if (playerA.getPoints() >= 7 || playerB.getPoints() >= 7) {
                if (pointDiffrent >= 2) {
                    setController();
                }
            }

        }

    }

    private void gameController() {

        if (playerA.getPoints() > playerB.getPoints()) {
            playerA.setGames(+1);
        } else {
            playerB.setGames(+1);
        }

        playerA.setPoints(0);
        playerB.setPoints(0);

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

            if (playerA.getGames() >= 12 || playerB.getGames() >= 12) {
                if (gameDiffrent >= 2) {
                    setController();
                }
            }

        } else {

            if (playerA.getGames() >= 6 || playerB.getGames() >= 6) {
                if (gameDiffrent >= 2) {
                    setController();
                }
            }

        }

    }

    private void setController() {

        if (!tieBreak) {
            if (playerA.getGames() > playerB.getGames()) {
                playerA.setSets(+1);
            } else {
                playerB.setSets(+1);
            }

        } else if (playerA.getPoints() > playerB.getPoints()) {
            playerA.setSets(+1);
        } else {
            playerB.setSets(+1);
        }

        playerA.setPoints(0);
        playerB.setPoints(0);
        playerA.setGames(0);
        playerB.setGames(0);

        tieBreak = false;       
        
    }

    private int getCurrentSet() {
        return (playerA.getSets() + playerB.getSets()) + 1;
    }

    String getCurrentScore() {
        return resultBuilder.buildResult();
    }

    private class ResultBuilder {

        public ResultBuilder(Player playerA, Player playerB) {
            this.playerA = playerA;
            this.playerB = playerB;
        }

        final private StringBuilder result = new StringBuilder("");
        final private Player playerA;
        final private Player playerB;

        public String getCurrentScore() {
            return buildResult();
        }

        private String buildResult() {
            result.delete(0, result.length());

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
