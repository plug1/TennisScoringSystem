
package tenis.system;

/**
 *
 * @author Marcin
 */
public class Player {

    private int points;
    private int games;
    private int sets;
    private StringBuilder sb = new StringBuilder("");

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        if (points == 1) {
            this.points = this.points + points;
        } else {
            this.points = points;
        }
    }

    /**
     * @return the games
     */
    public int getGames() {
        return games;
    }

    /**
     * @param games the games to set
     */
    public void setGames(int games) {
        if (games == 1) {
            this.games = this.games + games;
        } else {
            this.games = games;
        }
    }

    /**
     * @return the sets
     */
    public int getSets() {
        return sets;
    }

    /**
     * @param sets the sets to set
     */
    public void setSets(int sets) {
        if (sets == 1) {
            this.sets = this.sets + sets;
        } else {
            this.sets = sets;
        }
    }

    public String toString(Player player) {
        sb.delete(0, sb.length());
        if (this.points <= 3 && player.points <= 3) {
            getStringPoint(this);
            sb.append('/');
            getStringPoint(player);

        } else if (this.points == 4 && player.points == 4) {
            sb.append("40/40");
        } else if (this.points > player.points) {
            sb.append("AD/40");
        } else if (this.points < player.points) {
            sb.append("40/AD");
        } else if (this.points == player.points) {
            sb.append("40/40");
        }

        return sb.toString();

        //return Integer.toString(points);
    }

    private void getStringPoint(Player player) {

        switch (player.points) {
            case 0:
                sb.append("0");
                break;
            case 1:
                sb.append("15");
                break;
            case 2:
                sb.append("30");
                break;
            case 3:
                sb.append("40");
                break;
        }
    }

}
