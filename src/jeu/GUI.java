package jeu;
        import javax.swing.*;
        import javax.swing.border.EmptyBorder;
        import java.awt.*;
        import java.awt.event.*;
        import java.net.URL;

public class GUI implements ActionListener
{
    private static int heure=0,minute=0,seconde=0; // pour le chrono
    private Jeu jeu;
    private JFrame fenetre;
    private JTextField entree;
    private JTextArea texte;
    private JLabel image;
    private boolean finJeu;

    public GUI(Jeu j) {
        jeu = j;
        finJeu = false;
        fenetre = new JFrame("Jeu");
        //JPanel panel = new JPanel();
        creerGUI();

        // Le Chrono
        /* Le timer */
        int delais=1000;

        /* création des composants */
        final JLabel Label1 = new JLabel(heure+":"+minute+":"+seconde); /* déclarer final car une classe interne va acceder à ce composant */
        final JButton debut = new JButton("Start");
        JButton fin = new JButton("Remise à zéro");
        // JFrame fenetre = new JFrame("Chronomètre");
        JPanel Panel1 = new JPanel();

        /* Action réalisé par le timer */
        ActionListener tache_timer = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                seconde++;
                if (seconde == 60) {
                    seconde = 0;
                    minute++;
                }
                if (minute == 60) {
                    minute = 0;
                    heure++;
                }
                if (minute > 5) {
                    Label1.setText("fin du jeu, temps dépassé");/* rafraichir le label */

                    fenetre.dispose();

                } else Label1.setText(heure + ":" + minute + ":" + seconde);/* rafraichir le label */
            }
        };
        /* instanciation du timer */
        final Timer timer1= new Timer(delais,tache_timer);

        /* Ajout des composants aux conteneurs avec formatage */
        Panel1.add(debut);
        Panel1.add(fin);
        Label1.setBorder(new EmptyBorder(10,135,10,10));
        fenetre.getContentPane().add(Label1,"North");
        fenetre.getContentPane().add(Panel1,"South");

        /* Action provoqué par l'utilisateur */
        /* Lors du clic sur le bouton debut */
        debut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String texte;
                texte=debut.getText();
                if(texte.compareTo("Start")==0)
                {
                    debut.setText("Stop ");
                    timer1.start();
                }
                else if(texte.compareTo("Stop ")==0)
                {
                    debut.setText("Start");
                    timer1.stop();
                }
            }
        });
        /* Lors du clic sur le bouton fin */
        fin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String texte;
                texte=debut.getText();
                if(texte.compareTo("Start")==0)
                {
                    heure=0;
                    minute=0;
                    seconde=0;
                    debut.setText("Start");
                    Label1.setText(heure+":"+minute+":"+seconde);
                }
            }
        });

        /* Afficher l'ihm */
        fenetre.pack();
        //fenetre.setLocation(350,200);  /* Déplacer la fenetre à ce nouvel emplacement */
        //fenetre.setSize(300,100);   /* dimension de la fenetre */
        //fenetre.show();
    }



    public void afficher(String s) {
        texte.append(s);
        texte.setCaretPosition(texte.getDocument().getLength());
    }

    public void afficher() {
        afficher("\n");
    }

    public void afficheImage( String nomImage) {
        URL imageURL = this.getClass().getClassLoader().getResource("jeu/images/" + nomImage);
        if( imageURL != null ) {
            image.setIcon( new ImageIcon( imageURL ));
            fenetre.pack();
        }
    }

    public void enable(boolean ok) {
        entree.setEditable(ok);
        if ( ! ok )
            entree.getCaret().setBlinkRate(0);
    }

    private void creerGUI() {
        //    fenetre = new JFrame("Jeu");

        entree = new JTextField(34);

        texte = new JTextArea();
        texte.setEditable(false);
        JScrollPane listScroller = new JScrollPane(texte);
        listScroller.setPreferredSize(new Dimension(200, 200));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        image = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entree, BorderLayout.SOUTH);

        fenetre.getContentPane().add(panel, BorderLayout.CENTER);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entree.addActionListener(this);

        fenetre.pack();
        fenetre.setVisible(true);
        entree.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        executerCommande();
    }

    private void executerCommande() {
        String commandeLue = entree.getText();
        entree.setText("");
        jeu.traiterCommande( commandeLue);
    }
    private void executeCommande()
    {
        afficher("Quel est le tueur ? ");
        afficher();
        String tueur = entree.getText();
        entree.setText("");
        afficher("Quel est l'arme ? ");
        afficher();
        String arme = entree.getText();
        entree.setText("");
        jeu.resoudreEnquete(tueur, arme);
    }
}
