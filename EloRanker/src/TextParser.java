import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TextParser {
    private static final int IMAGE_WIDTH = 300;
    private static final int IMAGE_HEIGHT = 550;
    boolean hasImage;

    private String text;


    public TextParser(String text) {
        this.text = text;
        parseText(text);

    }

    private void parseText(String text) {
        if (text.equals("Leaderboard") || text.equals("leaderboard") || text.equals("leaderboards") || text.equals("Leaderboards")) {
            createLeaderboard();
        } else if (text.equals("add player") || text.equals("Add player") || text.equals("add Player") || text.equals("Add Player")
                || text.equals("add") || text.equals("Add") || text.equals("new player") || text.equals("New player")
                || text.equals("new Player") || text.equals("New Player") || text.equals("new") || text.equals("New")) {
            addPlayer();
        } else if (text.equals("remove") || text.equals("Remove") || text.equals("remove player")
                || text.equals("Remove player") || text.equals("remove Player") || text.equals("Remove Player")) {
            removePlayer();
        } else if (text.equals("save") || text.equals("Save") || text.equals("save rankings") || text.equals("Save rankings") || text.equals("save Rankings") || text.equals("Save Rankings")) {
            saveRankings();
        }

    }

    private void saveRankings() {
        Writer w = new Writer();
        w.write();
    }

    private void removePlayer() {
        String nameOfPlayer = JOptionPane.showInputDialog("What is the name of the player you want to remove?");
        boolean isValidName = checkNames(nameOfPlayer);
        if (isValidName) {
            removePlayerFromList(nameOfPlayer);
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Removed");
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Sorry there is no player with that name");
        }

    }

    private void removePlayerFromList(String nameOfPlayer) {
        for (int i = 0; i < main.players.size(); i++) {
            Player p = main.players.get(i);
            String playerName = p.getName();
            if (nameOfPlayer.equals(playerName)) {
                main.players.remove(i);
                return;
            }
        }
    }

    private boolean checkNames(String nameOfPlayer) {
        for (int i = 0; i < main.players.size(); i++) {
            Player p = main.players.get(i);
            String playerName = p.getName();
            if (nameOfPlayer.equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    private void addPlayer() {
        String filename = getImage();

        if (hasImage) {
            Player p = makePlayer(filename);
            main.players.add(p);
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Added");
        }
    }

    private Player makePlayer(String filename) {
        String name = JOptionPane.showInputDialog("What is the Player's name?");
        int index = filename.indexOf(".");
        filename = filename.substring(0, index);
        Player newPlayer = new Player(name, filename);
        return newPlayer;
    }

    private String getImage() {

        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);

        String directory = dialog.getDirectory();
        String filename = dialog.getFile();

        moveImagetoImagesFolder(directory, filename);

        return filename;
    }

    private void moveImagetoImagesFolder(String directory, String filename) {
        BufferedImage image = null;
        image = readImage(image, directory, filename);
        doValidWrite(image, filename);
    }

    private void writeImage(BufferedImage image, String filename) {

        try {
            // Output file path
            File output_file = new File("Images/" + filename + ".jpg");//new name of file

            // Writing to file taking type and path as
            ImageIO.write(image, "jpg", output_file);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private void doValidWrite(BufferedImage image, String filename) {

        boolean isValid = fileNameisValid(filename);
        if (isValid) {
            writeImage(image, filename);
            hasImage = true;
        } else {
            filename = JOptionPane.showInputDialog("Choose a new filename");
            isValid = fileNameisValid(filename);
            if (isValid) {
                writeImage(image, filename);
                hasImage = true;
            } else {
                filename = JOptionPane.showInputDialog("Choose a new filename");
                if (isValid) {
                    writeImage(image, filename);
                    hasImage = true;
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "That filename is unavailable");
                    hasImage = false;
                }
            }
        }
    }

    private boolean fileNameisValid(String filename) {
        if (filename.contains(".")) {
            filename = filename.substring(0, filename.indexOf("."));
        }
        for (int i = 0; i < main.players.size(); i++) {
            Player p = main.players.get(i);
            String playerFilename = p.getFileName();

            if (playerFilename.equals(filename)) {
                return false;
            }
        }

        return true;
    }

    private BufferedImage readImage(BufferedImage image, String directory, String filename) {
        // READ IMAGE
        try {
            File input_file = new File(directory + filename); //image file path


            // Reading input file
            image = ImageIO.read(input_file);

            return image;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public void createLeaderboard() {
        int numPlayers = main.players.size();
        ArrayList<Player> playersCopy = new ArrayList<>();
        ArrayList<Player> rankedPlayers = new ArrayList<>();

        copyPlayersList(playersCopy);
        rankPlayers(numPlayers, playersCopy, rankedPlayers);
        printLeaderboard(rankedPlayers);

    }

    private void copyPlayersList(ArrayList<Player> playersCopy) {

        for (int i = 0; i < main.players.size(); i++) {
            playersCopy.add(main.players.get(i));
        }
    }

    private void rankPlayers(int numPlayers, ArrayList<Player> playersCopy, ArrayList<Player> rankedPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            Player player = Collections.max(playersCopy, Comparator.comparing(s -> s.getRating()));

            playersCopy.remove(player);
            rankedPlayers.add(player);
        }
    }

    private void printLeaderboard(ArrayList<Player> rankedPlayers) {

        for (int i = 0; i < rankedPlayers.size(); i++) {
            Player p = rankedPlayers.get(i);
            System.out.println(i + 1 + ")" + p.getName() + " - " + p.getRating());
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
