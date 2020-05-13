import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TextParser {
    private String text;


    public TextParser(String text) {
        this.text = text;
        parseText(text);

    }

    private void parseText(String text) {
        if (text.equals("Leaderboard") || text.equals("leaderboard") || text.equals("leaderboards") || text.equals("Leaderboards")) {
            int numPlayers = main.players.size();
            ArrayList<Player> playersCopy = new ArrayList<>();
            for (int i = 0; i < main.players.size(); i++) {
                 playersCopy.add(main.players.get(i));
            }

            ArrayList<Player> rankedPlayers = new ArrayList<>();
            for (int i = 0; i < numPlayers; i++) {
                Player player =  Collections.max(playersCopy, Comparator.comparing(s -> s.getRating()));

                playersCopy.remove(player);
                rankedPlayers.add(player);

            }
            for (int i = 0; i < rankedPlayers.size(); i++) {
                 Player p = rankedPlayers.get(i);
                System.out.println(i+1 + ")"+p.getName()+" - "+p.getRating());
            }



        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
