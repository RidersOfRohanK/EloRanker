import java.util.ArrayList;

public class main {
    static public  ArrayList<Player> players = new ArrayList();
    static Interface m = new Interface();
    public static void main(String[] args) {

        Player Rohan = new Player("Rohan","RohanK");
        Player Pras = new Player("Pras", "Pras");
        Player Rishabh = new Player("Rishabh","Rishabh");
        Player Kavin = new Player("Kavin","Kavin");
        Player Chad = new Player("Chad","Chad");
        Player Swolal = new Player("Swolal","Swolal");

        players.add(Rohan);
        players.add(Pras);
        players.add(Rishabh);
        players.add(Kavin);
        players.add(Chad);
        players.add(Swolal);




        getNewPlayers();
        m.init();


    }

    public static void getNewPlayers(){
        int newNum1 = (int)(Math.random()*players.size());
        int newNum2 = (int)(Math.random()*players.size());

        if(newNum1 == newNum2){
            newNum2 = (int)(Math.random()*players.size());
            if(newNum1 == newNum2){
                newNum2 = (int)(Math.random()*players.size());
                if(newNum1 == newNum2){
                    newNum2 = (int)(Math.random()*players.size());
                }
            }

        }

        Player p1 = players.get(newNum1);


        Player p2 = players.get(newNum2);


        m.setPlayers(p1,p2);

    }
}