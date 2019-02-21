import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BasicSwing extends JFrame {


    private int liczbaElementow;

    protected Vector<Integer> punkty = new Vector<Integer>( liczbaElementow );
    protected Vector<JPanel> panel = new Vector<JPanel>( liczbaElementow );
    protected Vector<JButton> buttonPlus = new Vector<JButton>( liczbaElementow );
    protected Vector<JButton> buttonMinus = new Vector<JButton>( liczbaElementow );
    protected Vector<JTextField> text = new Vector<JTextField>( liczbaElementow );
    protected Vector<JTextArea> nazwa = new Vector<JTextArea>( liczbaElementow);

    private JPanel mainPanel = new JPanel( new FlowLayout(FlowLayout.CENTER, 20, 20));


    public class Odejmowanie implements ActionListener{

        private int index;

        public Odejmowanie(int index){

            this.index = index;
        }


        public void actionPerformed(ActionEvent e){

            Integer temp = punkty.get( index ); temp -= 1;
            punkty.set(index, temp);

            text.get(index).setText( temp.toString() );
        }
    }

    public class Dodawanie implements ActionListener {

        private int index;

        public Dodawanie(int index){

            this.index = index;
        }


        public void actionPerformed(ActionEvent e){

            Integer temp = punkty.get( index ); temp += 1;
            punkty.set(index, temp);

            text.get(index).setText( temp.toString() );
        }
    }

    public void setWartosci(){

        for( int i = 0; i < liczbaElementow; i++){

            punkty.add(0);

            nazwa.add(new JTextArea( "  " ));

            panel.add( new JPanel() );
            panel.get(i).setPreferredSize( new Dimension(200, 100) );

            buttonPlus.add( new JButton( " + ") );
            buttonPlus.get(i).addActionListener( new Dodawanie(i) );

            buttonMinus.add( new JButton( " - ") );
            buttonMinus.get(i).addActionListener( new Odejmowanie(i) );

            text.add( new JTextField("0") );

        }
    }

    public BasicSwing(int liczbaElementow){

        super("Munchkin Counter");
        this.liczbaElementow = liczbaElementow;

        setSize(500,500);
        setResizable(true);


        setWartosci();

        for( int i = 0; i < liczbaElementow; i++){

            panel.get(i).add( nazwa.get(i) );
            panel.get(i).add( buttonMinus.get(i) );
            panel.get(i).add( buttonPlus.get(i) );
            panel.get(i).add( text.get(i) );
            mainPanel.add(panel.get(i));

        }

        add( mainPanel );
        setVisible(true);

    }


}
