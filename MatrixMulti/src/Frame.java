/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kushal
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame
        extends JFrame
        implements ActionListener {

    int n = 16;
    private final JPanel pa7;
    private final JPanel pa8;
    private JLabel lu;
    private JLabel lu1;
    private JLabel lu2;
    private JButton bu;
    private JButton bu1;
    private JButton bu2;
    private JButton bu3;
    private JPanel pa1;
    private JPanel pa4;
    private JPanel pa2;
    private JPanel pa3;
    private JPanel pa5;
    private JPanel pa6;

    Frame(int a) {
        this.n = a;
        setTitle("Matrix MultiPlication");
        this.icon = new ImageIcon("D:\\Downloads\\1396126686_Matrix.png");
        this.i = this.icon.getImage();
        setIconImage(this.i);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int Jwidth = getSize().width;
        int Jhight = getSize().height;
        int locx = (dim.width - Jwidth) / 2;
        int locy = 100;
        setLocation(locx, locy);
        setVisible(this.rootPaneCheckingEnabled);
        if (a == 3) {
            setSize(200, 410);
            setResizable(false);
        } else if (a == 4) {
            setSize(300, 470);
            setResizable(false);
        } else if (a == 5) {
            setSize(350, 530);
            setResizable(false);
        } else if (a == 6) {
            setSize(400, 560);
            setResizable(false);
        } else if (a == 7) {
            setSize(450, 610);
            setResizable(false);
        } else if (a == 8) {
            setSize(500, 704);
            setResizable(false);
        } else if (a == 2) {
            setSize(180, 320);
            setResizable(false);
        } else if (a == 1) {
            setSize(150, 250);
            setResizable(true);
        } else {
            setSize(locx, locy);
            setResizable(true);
        }
        setDefaultCloseOperation(3);
        this.pa1 = new JPanel();
        this.bu = new JButton("Ans");
        this.bu1 = new JButton("Clear All");
        this.bu2 = new JButton("Exit");
        this.bu3 = new JButton("Change order of matrix");
        this.pa2 = new JPanel();
        this.pa3 = new JPanel();
        this.lu = new JLabel("First Matrix");
        this.lu1 = new JLabel("Secound Matrix");
        this.lu2 = new JLabel("Resulted Matrix");
        this.pa5 = new JPanel();
        this.pa6 = new JPanel();
        this.pa4 = new JPanel();
        this.pa7 = new JPanel();
        this.pa8 = new JPanel();
        this.con = new GridBagConstraints();
    }

    public void arrange() {
        for (int b = 0; b < this.n * this.n; b++) {
            this.f1[b] = new JTextField(5);
            this.f2[b] = new JTextField(5);
            this.f3[b] = new JTextField(5);
        }
        this.pa1.setLayout(new GridLayout(this.n, this.n));
        this.pa2.setLayout(new GridLayout(this.n, this.n));
        this.pa3.setLayout(new GridLayout(this.n, this.n));
        this.pa4.setLayout(new GridBagLayout());
        this.pa5.setLayout(new FlowLayout());
        this.pa5.add(this.bu1);
        this.bu1.addActionListener(new Actionbu1());
        this.pa5.add(this.bu2);
        this.bu2.addActionListener(new Actionbu2());
        this.pa6.add(this.bu3);
        this.bu3.addActionListener(new Actionbu3());
        this.pa7.add(this.lu);
        this.pa8.add(this.lu1);
        int p = 0;
        int q = 0;
        for (int a = 0; a < this.n * this.n; a++) {
            this.pa1.add(this.f1[a]);
        }
        for (int a = 0; a < this.n * this.n; a++) {
            this.pa2.add(this.f2[a]);
        }
        for (int a = 0; a < this.n * this.n; a++) {
            this.pa3.add(this.f3[a]);
        }
        this.con.gridx = 0;
        this.con.gridy = 0;
        this.pa4.add(this.bu, this.con);
        this.bu.addActionListener(this);
        setLayout(new FlowLayout());
        add(this.pa7);
        add(this.pa1);
        add(this.pa8);
        add(this.pa2);
        add(this.pa4);
        add(this.pa3);
        add(this.pa5);
        add(this.pa6);
    }

    private GridBagConstraints con = new GridBagConstraints();
    private JTextField[] f1 = new JTextField[this.n * this.n];
    private JTextField[] f2 = new JTextField[this.n * this.n];
    private JTextField[] f3 = new JTextField[this.n * this.n];
    private Image i;
    private ImageIcon icon;

    public void actionPerformed(ActionEvent ae) {
        int[][] af1 = new int[this.n][this.n];
        int[][] af2 = new int[this.n][this.n];
        int[][] af3 = new int[this.n][this.n];
        int count = -1;
        try {
            for (int x = 0; x < this.n; x++) {
                for (int y = 0; y < this.n; y++) {
                    count++;
                    af1[x][y] = Integer.parseInt(this.f1[count].getText());
                }
            }
            int coun = -1;
            for (int x = 0; x < this.n; x++) {
                for (int y = 0; y < this.n; y++) {
                    coun++;
                    af2[x][y] = Integer.parseInt(this.f2[coun].getText());
                }
            }
            int push = 0;
            for (int x = 0; x < this.n; x++) {
                for (int z = 0; z < this.n; z++) {
                    push = 0;
                    for (int y = 0; y < this.n; y++) {
                        int kush = af1[x][y] * af2[y][z];
                        push += kush;
                    }
                    af3[x][z] = push;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "May Be Any Of The Filed Is Empty \nor Filled with char values");
        }
        int co = -1;
        for (int x = 0; x < this.n; x++) {
            for (int y = 0; y < this.n; y++) {
                co++;
                this.f3[co].setText("" + af3[x][y]);
            }
        }
    }

    class Actionbu1
            implements ActionListener {

        int a = 0;

        Actionbu1() {
        }

        public void actionPerformed(ActionEvent ae) {
            for (this.a = 0; this.a < Frame.this.n * Frame.this.n; this.a += 1) {
                Frame.this.f1[this.a].setText(null);
                Frame.this.f2[this.a].setText(null);
                Frame.this.f3[this.a].setText(null);
            }
        }
    }

    class Actionbu2
            implements ActionListener {

        Actionbu2() {
        }

        public void actionPerformed(ActionEvent ae) {
            System.exit(1);
        }
    }

    class Actionbu3
            implements ActionListener {

        Actionbu3() {
        }

        public void actionPerformed(ActionEvent ae) {
            Frame.this.setVisible(false);
            InFrame x = new InFrame();
            x.arrange();
        }
    }
}
