import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    double numResDouble = 0 ;
    double a, b;
    int compteurAB, nbPlusUsed, nbMinusUsed, nbTimesUsed, nbDivUsed, methodeCalcul, compteurOp;

    private String numResStr = "" ;

    // <editor-fold defaultstate="collapsed" desc="JB et tableau">

    private final JLabel affichage = new JLabel( numResStr );

    private final JButton button0 = new JButton( "0" );
    private final JButton button1 = new JButton( "1" );
    private final JButton button2 = new JButton( "2" );
    private final JButton button3 = new JButton( "3" );
    private final JButton button4 = new JButton( "4" );
    private final JButton button5 = new JButton( "5" );
    private final JButton button6 = new JButton( "6" );
    private final JButton button7 = new JButton( "7" );
    private final JButton button8 = new JButton( "8" );
    private final JButton button9 = new JButton( "9" );
    private final JButton buttonPlus = new JButton( "+" );
    private final JButton buttonMinus = new JButton( "-" );
    private final JButton buttonTimes = new JButton( "*" );
    private final JButton buttonDiv = new JButton( "/" );
    private final JButton buttonClear = new JButton( "C" );
    private final JButton buttonDot = new JButton( "." );
    private final JButton buttonEquals = new JButton( "=" );

    JButton[] numArray = { button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot };
    JButton[] operatorArray = { buttonPlus, buttonMinus, buttonTimes, buttonDiv, buttonEquals, buttonClear };
    String[] stringArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." };
// </editor-fold>



    public Fenetre() {
        // <editor-fold defaultstate="collapsed" desc="fenetre">

        this.setTitle( "Calculatrice simple" );
        this.setSize( 400, 600 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        this.setVisible( true );
        this.setResizable( true );
        // </editor-fold>

        //    -------------------- TEST -------------------- TEST --------------------


        //    -------------------- TEST -------------------- TEST --------------------
// <editor-fold defaultstate="collapsed" desc="Placement bouton sur fenetre">

        Font police = new Font( "TimesRoman", Font.PLAIN, 18 );
        affichage.setFont( police );

        JPanel panBottom = new JPanel();
        panBottom.setLayout( new GridBagLayout() );
        GridBagConstraints gbc = new GridBagConstraints() ;


        gbc.gridx = 0 ;
        gbc.gridy = 0 ;
        gbc.gridheight = 1 ;
        gbc.gridwidth = 5 ;
        gbc.ipadx = 30 ;
        gbc.ipady = 30 ;
        gbc.insets = new Insets(5, 5, 5, 5 );
        panBottom.add( affichage, gbc );
        gbc.gridx = 4 ;
        gbc.gridy = 2 ;
        gbc.gridheight = 1 ;
        gbc.gridwidth = 1 ;
        panBottom.add( buttonClear, gbc );
        gbc.gridx = 0;
        gbc.gridy = 3;
        panBottom.add( button7, gbc );
        gbc.gridx = 1;
        panBottom.add( button8, gbc );
        gbc.gridx = 2;
        panBottom.add( button9, gbc );
        gbc.gridx = 4;
        panBottom.add( buttonDiv, gbc );
        gbc.gridx = 0;
        gbc.gridy = 4;
        panBottom.add( button4, gbc );
        gbc.gridx = 1;
        panBottom.add( button5, gbc );
        gbc.gridx = 2;
        panBottom.add( button6, gbc ) ;
        gbc.gridx = 4;
        panBottom.add( buttonTimes, gbc ) ;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panBottom.add( button1, gbc );
        gbc.gridx = 1;
        panBottom.add( button2, gbc );
        gbc.gridx = 2;
        panBottom.add( button3, gbc );
        gbc.gridx = 4;
        panBottom.add( buttonMinus, gbc );
        gbc.gridx = 0;
        gbc.gridy = 6;
        panBottom.add( button0, gbc );
        gbc.gridx = 1;
        panBottom.add( buttonDot, gbc );
        gbc.gridx = 2;
        panBottom.add( buttonEquals, gbc );
        gbc.gridx = 4;
        panBottom.add( buttonPlus, gbc );
        this.setContentPane( panBottom );
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Ajouts des ActionListener">

        button0.addActionListener( new NumListener() );
        button1.addActionListener( new NumListener() );
        button2.addActionListener( new NumListener() );
        button3.addActionListener( new NumListener() );
        button4.addActionListener( new NumListener() );
        button5.addActionListener( new NumListener() );
        button6.addActionListener( new NumListener() );
        button7.addActionListener( new NumListener() );
        button8.addActionListener( new NumListener() );
        button9.addActionListener( new NumListener() );
        buttonDot.addActionListener( new NumListener() );

        buttonPlus.addActionListener( new OperatorListener() );
        buttonMinus.addActionListener( new OperatorListener() );
        buttonTimes.addActionListener( new OperatorListener() );
        buttonDiv.addActionListener( new OperatorListener() );

        buttonEquals.addActionListener( new OperatorListener() );
        buttonClear.addActionListener( new OperatorListener() );
// </editor-fold>



    }

    class NumListener implements ActionListener{

        public void actionPerformed( ActionEvent evtNum ) {
            int i = 0;

            for ( JButton numClicked : numArray ) {
                if (evtNum.getSource() == numClicked) {
                    numResStr = numResStr + stringArray[i];
                    affichage.setText(numResStr);
                }
                i++;
            }
            if (compteurAB == 0 ) {
                a = Double.parseDouble(numResStr);
            }
            else if ( compteurAB >= 1){
                b = Double.parseDouble(numResStr);
            }


        }
    }

    class OperatorListener implements  ActionListener{

        public void actionPerformed( ActionEvent evtOperator ) {
            for ( JButton operatorClicked : operatorArray ) {


                if ( evtOperator.getSource() == operatorClicked ) {

                    compteurAB++;
                    compteurOp++;
                    affichage.setText( numResStr = "" );

                    if ( operatorClicked == buttonPlus) {
                        numResStr = "";
                        methodeCalcul = 1;
                        nbPlusUsed++;
                        System.out.println("a " + a + " b " + b);
                        if (nbPlusUsed > 1 ){
                            a = add(a,b);
                            affichage.setText(Double.toString(a));
                        }
                    }

                    else if ( operatorClicked == buttonMinus) {
                        methodeCalcul = 2;
                        numResStr = "";
                        nbMinusUsed++;
                        System.out.println("a " + a + " b " + b);
                        if (nbMinusUsed > 1 ){
                            a = sous(a,b);
                            affichage.setText(Double.toString(a));
                        }
                    }
                    else if ( operatorClicked == buttonTimes) {
                        methodeCalcul = 3;
                        numResStr = "";
                        nbTimesUsed++;
                        System.out.println("a " + a + " b " + b);
                        if (nbTimesUsed > 1 ){
                            a = mult(a,b);
                            affichage.setText(Double.toString(a));
                        }                    }
                    else if ( operatorClicked == buttonDiv) {
                        methodeCalcul = 4;
                        numResStr = "";
                        nbDivUsed++;
                        System.out.println("a " + a + " b " + b);
                        if (nbDivUsed > 1 ){
                            a = div(a,b);
                            affichage.setText(Double.toString(a));
                        }                    }
                    else if (operatorClicked == buttonClear){
                        a = 0;
                        b = 0;
                        compteurAB = 0;
                        numResDouble = 0;
                        nbPlusUsed = 0;
                        nbMinusUsed = 0;
                        nbTimesUsed = 0;
                        nbDivUsed = 0;
                        affichage.setText(numResStr = "");
                    }
                    else if ( operatorClicked == buttonEquals) {
                        switch (methodeCalcul) {

                            case 1:
                                numResDouble = add(a, b);
                                a = numResDouble ;
                                break;

                            case 2:
                                numResDouble = sous(a, b);
                                a = numResDouble ;
                                break;

                            case 3:
                                numResDouble = mult(a, b);
                                a = numResDouble ;
                                break;

                            case 4:
                                numResDouble = div(a, b);
                                a = numResDouble ;
                                break;
                        }
                        System.out.println(numResDouble);
                        affichage.setText(Double.toString(numResDouble));
                        numResStr = "";

                        nbPlusUsed = 0;
                        nbMinusUsed = 0;
                        nbTimesUsed = 0;
                        nbDivUsed = 0;
                    }
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="methode calcul">
    private double add(double a, double b) {
        double addRes = a + b ;
        System.out.println(a + " + " + b + " = " + addRes);
        return addRes;
    }

    private double sous(double a, double b) {
        double sousRes = a - b;
        System.out.println(a + " - " + b + " = " + sousRes);
        return sousRes;
    }

    private double mult(double a, double b) {
        double multRes = a * b ;
        System.out.println(a + " x " + b + " = " + multRes);
        return multRes;
    }

    private double div(double a, double b) {
        double divRes = a / b ;
        System.out.println(a + " / " + b + " = " + divRes);
        return divRes;
    }    // </editor-fold>
}

