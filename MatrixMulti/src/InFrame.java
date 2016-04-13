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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InFrame
        extends JFrame
        implements ActionListener, KeyListener {

    private final ImageIcon icon;
    private JButton bu;
    private JTextField tf;
    private JPanel pa;
    private GridBagLayout b;
    private GridBagConstraints con;
    private Image i;
    private JLabel la;

    InFrame() {
        this.icon = new ImageIcon("D:\\Downloads\\1396129118_input-keyboard.png");
        this.i = this.icon.getImage();
        setIconImage(this.i);
        setVisible(this.rootPaneCheckingEnabled);
        setTitle("Input");
        setSize(450, 100);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int Jwidth = getSize().width;
        int Jhight = getSize().height;
        int locx = (dim.width - Jwidth) / 2;
        int locy = (dim.height - Jhight) / 2;
        setLocation(locy, locy);
        setSize(350, 100);
        setDefaultCloseOperation(3);
        this.la = new JLabel("Order Of the Matrix = ");
        this.bu = new JButton("Next");
        this.tf = new JTextField(10);
        this.b = new GridBagLayout();
        this.con = new GridBagConstraints();
        this.pa = new JPanel();
    }

    public void arrange() {
        this.con.gridx = 0;
        this.con.gridy = 0;
        this.pa.add(this.la, this.con);
        this.con.gridx = 0;
        this.con.gridy = 20;
        this.pa.add(this.tf, this.con);
        this.tf.addKeyListener(this);
        this.con.gridx = 0;
        this.con.gridy = 40;
        this.pa.add(this.bu, this.con);
        this.bu.addActionListener(this);
        setLayout(new FlowLayout());
        add(this.pa);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            int a = Integer.parseInt(this.tf.getText());
            setVisible(false);
            Frame x = new Frame(a);
            x.arrange();
            JOptionPane.showMessageDialog(null, "Size of the Matrix is set To " + a + "*" + a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You can not Enter any Char value \nYou can only enter any numeric value");

            this.tf.setText(null);
        }
    }

    public void keyTyped(KeyEvent ke) {
        char ch = ke.getKeyChar();
        try {
            if (ch == '\n') {
                int a = Integer.parseInt(this.tf.getText());
                setVisible(false);
                Frame x = new Frame(a);
                x.arrange();
                JOptionPane.showMessageDialog(null, "Size of the Matrix is set To " + a + "*" + a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You can not Enter any Char value \nYou can only enter any numeric value");

            this.tf.setText(null);
        }
    }

    public void keyPressed(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }
}
