import java.util.ArrayList;

public class main {
    static public ArrayList<Player> players = new ArrayList();
    static Interface m = new Interface();
    static int oldNum1,oldNum2 = -1;
    static int newNum1,newNum2;




    public static void main(String[] args) {

        Player Rohan = new Player("Rohan", "RohanK");
        Player Pras = new Player("Pras", "Pras");
        Player Rishabh = new Player("Rishabh", "Rishabh");
        Player Kavin = new Player("Kavin", "Kavin");
        Player Chad = new Player("Chad", "Chad");
        Player Swolal = new Player("Swolal", "Swolal");

        players.add(Rohan);
        players.add(Pras);
        players.add(Rishabh);
        players.add(Kavin);
        players.add(Chad);
        players.add(Swolal);


        getNewPlayers();
        m.init();


    }

    public static void getNewPlayers() {
         newNum1 = (int) (Math.random() * players.size());
         newNum2 = (int) (Math.random() * players.size());

        if (newNum1 == newNum2) {
            newNum1 = (int) (Math.random() * players.size());
            newNum2 = (int) (Math.random() * players.size());

            if (newNum1 == newNum2) {
                newNum1 = (int) (Math.random() * players.size());
                newNum2 = (int) (Math.random() * players.size());

                if (newNum1 == newNum2) {
                    newNum1 = (int) (Math.random() * players.size());
                    newNum2 = (int) (Math.random() * players.size());

                    if (newNum1 == newNum2) {
                        newNum1 = (int) (Math.random() * players.size());
                        newNum2 = (int) (Math.random() * players.size());
                    }
                }
            }
        }

        checkifSimilarMatchup(newNum1,newNum2);

        oldNum1 = newNum1;
        oldNum2 = newNum2;

        Player p1 = players.get(newNum1);


        Player p2 = players.get(newNum2);


        m.setPlayers(p1, p2);

    }

    private static void checkifSimilarMatchup(int num1, int num2) {
        if(num1==oldNum1||num2==oldNum2||num1==oldNum1||oldNum2==num2||num1==oldNum2||num2==oldNum1){
                newNum1 = (int) (Math.random() * players.size());
                newNum2 = (int) (Math.random() * players.size());

                if (num1 == num2 || num1==oldNum1||num2==oldNum2||num1==oldNum1||oldNum2==num2||num1==oldNum2||num2==oldNum1) {
                    newNum1 = (int) (Math.random() * players.size());
                    newNum2 = (int) (Math.random() * players.size());


                    if (num1 == num2 || num1==oldNum1||num2==oldNum2||num1==oldNum1||oldNum2==num2||num1==oldNum2||num2==oldNum1) {
                        newNum1 = (int) (Math.random() * players.size());
                        newNum2 = (int) (Math.random() * players.size());

                        if (num1 == num2 || num1==oldNum1||num2==oldNum2||num1==oldNum1||oldNum2==num2||num1==oldNum2||num2==oldNum1) {
                            newNum1 = (int) (Math.random() * players.size());
                            newNum2 = (int) (Math.random() * players.size());


                        }
                    }
                }
            }
        }}



