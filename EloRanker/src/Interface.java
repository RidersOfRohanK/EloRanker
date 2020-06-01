import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    private static final int RATING_CHANGE = 30;
    private JPanel jp1 = new JPanel();
    private JButton jb1 = new JButton();
    private JPanel jp2 = new JPanel();
    private JButton jb2 = new JButton();
    Player p1, p2;
    JTextField textField;


    public Interface() {

        setTitle("Ranker");
        setVisible(true);

        setSize(850, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void init() {
        EloCalc eloCalc = new EloCalc(RATING_CHANGE);


        textField = new JTextField(30);
        textField.setSize(400, 20);


        jp1.add(textField);
        jp2.add(textField);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textField.setText("");
                TextParser parser = new TextParser(text);
            }
        });

        jp1.add(jb1);

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eloCalc.run(p1, p2, true);

                main.getNewPlayers();
            }
        });

        jp1.add(jb2);

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eloCalc.run(p1, p2, false);

                main.getNewPlayers();

            }
        });

        add(jp1, BorderLayout.SOUTH);
        add(jp2);

        validate();

    }

    public void setPlayers(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        jb1.setIcon(new ImageIcon("Images/" + p1.getFileName() + ".jpg"));//going to need to load individual photo
        jb2.setIcon(new ImageIcon("Images/" + p2.getFileName() + ".jpg"));//going to need to load each individual photo


    }


}