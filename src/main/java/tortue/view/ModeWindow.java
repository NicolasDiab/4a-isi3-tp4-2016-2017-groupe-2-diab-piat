package tortue.view;

import tortue.controller.LogoController;
import tortue.controller.ModeController;
import tortue.model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


public class ModeWindow extends JFrame implements Observer {

    private ModeController controller;
    private static final Dimension VGAP = new Dimension(1, 5);
    private static final Dimension HGAP = new Dimension(5, 1);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ModeWindow window = new ModeWindow();
            }
    });

    }


    public ModeWindow() {

        super("Sélection du mode");
        this.setVisible(true);
        this.setController(new ModeController(this));

        modeSelectionInit();

    }



    public void modeSelectionInit() {

        getContentPane().setLayout(new BorderLayout(10, 10));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // les boutons du bas
        JPanel jPanel = new JPanel(new GridLayout());
        JButton mode1 = new JButton("Mode 1");
        jPanel.add(mode1);
        mode1.addActionListener(this.getController());
        JButton mode2 = new JButton("Mode 2");
        jPanel.add(mode2);
        mode2.addActionListener(this.getController());
        JButton mode3 = new JButton("Mode 3");
        jPanel.add(mode3);
        mode3.addActionListener(this.getController());

        getContentPane().add(jPanel, "South");

        this.getContentPane().setPreferredSize(new Dimension(300, 50));
        this.setLocationRelativeTo(null);



        pack();
        setVisible(true);
    }


    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);
                b = (JButton) p.add(new JButton(im));
            } else
                b = (JButton) p.add(new JButton(name));
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(this.getController());
    }


    public void setController(ModeController controller) {
        this.controller = controller;
    }

    public ModeController getController() {
        return controller;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
