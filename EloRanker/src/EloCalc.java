public class EloCalc {
    private Player p1;
    private Player p2;
    private int scoreChange;
    private boolean FirstPlayerWins;


    public EloCalc(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public void setFirstPlayerWins(boolean firstPlayerWins) {
        FirstPlayerWins = firstPlayerWins;
    }

    public void setScoreChange(int scoreChange) {
        this.scoreChange = scoreChange;
    }

    private float probability(float rating1, float rating2) {
        return 1.0f * 1.0f / (1 + 1.0f * (float) (Math.pow(10, 1.0f * (rating1 - rating2) / 400)));
    }

    private void calculateNewRatings() {
        float[] newRatings = new float[2];
        if (p1 != null && p2 != null) {
            float p1Rating = p1.getRating();
            float p2Rating = p2.getRating();

            // To calculate the Winning probability of Player A
            float probP1 = probability(p2Rating, p1Rating);

            // To calculate the Winning probability of Player B
            float probP2 = probability(p1Rating, p2Rating);

            if (FirstPlayerWins) {
                p1Rating = p1Rating + scoreChange * (1 - probP1);
                p2Rating = p2Rating + scoreChange * (0 - probP2);
            } else {
                p1Rating = p1Rating + scoreChange * (0 - probP1);
                p2Rating = p2Rating + scoreChange * (1 - probP2);

            }
            setNewRatings(p1Rating, p2Rating);
        }
    }

    private void setNewRatings(float p1NewRating, float p2NewRating) {
        p1.setRating(p1NewRating);
        p2.setRating(p2NewRating);
    }

    public void run(Player p1, Player p2, boolean FirstPlayerWins) {
        this.p1 = p1;
        this.p2 = p2;
        this.FirstPlayerWins = FirstPlayerWins;

        calculateNewRatings();
    }

    public int getScoreChange() {
        return scoreChange;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
}
