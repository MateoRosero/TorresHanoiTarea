import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

public class Interfaz extends JFrame {

    private JPanel panelT;
    private JPanel panelD;
    private JPanel panelU;
    private JPanel TorreI;
    private JPanel TorreF;
    private JPanel TorreP;
    private JButton BInicial;
    private JButton CInicio;
    private JButton AP;
    private JButton CP;
    private JButton AD;
    private JButton BD;
    private JComboBox CDiscos;
    private JButton BotonComenzar;
    private JButton BotonReinicio;
    private JButton BotonResoult;
    private JLabel MovMin;
    private JLabel MovN;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    HanoiT t = new HanoiT();
    private boolean FC = true;
    private int pasos = 0;

    public Interfaz() {
        setContentPane(panelT);


        TorreI.setLayout(new BorderLayout());
        Panel1 = new JPanel();
        Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.PAGE_AXIS));
        TorreI.add(Panel1, BorderLayout.SOUTH);


        TorreP.setLayout(new BorderLayout());
        Panel2 = new JPanel();
        Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.PAGE_AXIS));
        TorreP.add(Panel2, BorderLayout.SOUTH);


        TorreF.setLayout(new BorderLayout());
        Panel3 = new JPanel();
        Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.PAGE_AXIS));
        TorreF.add(Panel3, BorderLayout.SOUTH);

        BotonComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IniciarD();
            }
        });
        BInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Iniciar();
            }
        });
        CInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iniciard();
            }
        });
        AP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pivoteInicial();
            }
        });
        CP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pivoteD();
            }
        });
        AD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinoInicial();
            }
        });
        BD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinoPivote();
            }
        });
        BotonResoult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolver();
            }
        });
        BotonReinicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });
    }

    private void IniciarD(){
        pasos = 0;
        t.setIntentos(0);
        MovN.setText(String.valueOf(t.getIntentos()));

        Panel1.removeAll();
        Panel2.removeAll();
        Panel3.removeAll();

        t.getTorreI().clear();
        t.getTorreP().clear();
        t.getTorreD().clear();

        int DiscosTomados = Integer.parseInt(CDiscos.getSelectedItem().toString());

        t.setnDiscos(DiscosTomados);
        t.setIntentosM();

        for (int i = 0; i < DiscosTomados; i++) {
            String hashtags = "";
            JTextField field = new JTextField(10);
            for (int d = 0; d < DiscosTomados-i; d++) {
                hashtags += "#";
            }
            t.getTorreI().add(hashtags);
            field.setText(hashtags);
            field.setHorizontalAlignment(SwingConstants.CENTER);
            field.setMaximumSize(field.getPreferredSize());
            Panel1.add(field,0);
        }
        Panel1.revalidate();
        Panel1.repaint();

        MovMin.setText(String.valueOf(t.getIntentosM()));
    }

    private void reiniciar(){
        t.setIntentos(0);
        MovN.setText(String.valueOf(t.getIntentos()));

        Panel1.removeAll();
        Panel2.removeAll();
        Panel3.removeAll();

        t.getTorreI().clear();
        t.getTorreP().clear();
        t.getTorreD().clear();

        Panel1.revalidate();
        Panel1.repaint();
    }
    private void Iniciar(){
        if (Panel1.getComponentCount() > 0) {
            try {

                if (!t.getTorreP().empty() && t.getTorreP().peek().compareTo(t.getTorreI().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel1.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreP().add(t.getTorreI().pop());

                JTextField field = (JTextField) component;

                JPanel pivotePanel = (JPanel) TorreP.getComponent(0);


                Panel1.remove(field);
                pivotePanel.add(field, 0);

                Panel1.revalidate();
                Panel1.repaint();

                pivotePanel.revalidate();
                pivotePanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {

                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }
    private void Iniciard(){
        if (Panel1.getComponentCount() > 0) {
            try {
                if (!t.getTorreD().empty() && t.getTorreD().peek().compareTo(t.getTorreI().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel1.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreD().add(t.getTorreI().pop());

                JTextField field = (JTextField) component;

                JPanel pivotePanel = (JPanel) TorreF.getComponent(0);

                Panel1.remove(field);
                pivotePanel.add(field, 0);

                Panel1.revalidate();
                Panel1.repaint();

                pivotePanel.revalidate();
                pivotePanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {
                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }
    private void pivoteInicial(){
        if (Panel2.getComponentCount() > 0) {
            try {

                if (!t.getTorreI().empty() && t.getTorreI().peek().compareTo(t.getTorreP().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel2.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreI().add(t.getTorreP().pop());

                JTextField field = (JTextField) component;

                JPanel initialFieldPanel = (JPanel) TorreI.getComponent(0);


                Panel2.remove(field);
                initialFieldPanel.add(field, 0);

                Panel2.revalidate();
                Panel2.repaint();

                initialFieldPanel.revalidate();
                initialFieldPanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {

                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }
    private void pivoteD(){
        if (Panel2.getComponentCount() > 0) {
            try {

                if (!t.getTorreD().empty() && t.getTorreD().peek().compareTo(t.getTorreP().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel2.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreD().add(t.getTorreP().pop());

                JTextField Tfield = (JTextField) component;

                JPanel inicialPanel = (JPanel) TorreF.getComponent(0);

                Panel2.remove(Tfield);
                inicialPanel.add(Tfield, 0);

                Panel2.revalidate();
                Panel2.repaint();

                inicialPanel.revalidate();
                inicialPanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {
                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }
    private void destinoInicial(){
        if (Panel3.getComponentCount() > 0) {
            try {

                if (!t.getTorreI().empty() && t.getTorreI().peek().compareTo(t.getTorreD().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel3.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreI().add(t.getTorreD().pop());

                JTextField field = (JTextField) component;

                JPanel inicialPanel = (JPanel) TorreI.getComponent(0);

                Panel3.remove(field);
                inicialPanel.add(field, 0);

                Panel3.revalidate();
                Panel3.repaint();

                inicialPanel.revalidate();
                inicialPanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {
                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }

    private void destinoPivote(){
        if (Panel3.getComponentCount() > 0) {
            try {

                if (!t.getTorreP().empty() && t.getTorreP().peek().compareTo(t.getTorreD().peek()) <= 0) {
                    return;
                }
            } catch (EmptyStackException e) {

            }
            Component component = Panel3.getComponent(0);
            if (component instanceof JTextField) {
                t.getTorreP().add(t.getTorreD().pop());

                JTextField field = (JTextField) component;

                JPanel inicialPanel = (JPanel) TorreP.getComponent(0);


                Panel3.remove(field);
                inicialPanel.add(field, 0);

                Panel3.revalidate();
                Panel3.repaint();

                inicialPanel.revalidate();
                inicialPanel.repaint();

                t.setIntentos(t.getIntentos()+1);
                MovN.setText(String.valueOf(t.getIntentos()));

                if (juegoTerminado()) {
                    JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has finalizado exitosamente el juego.");
                }
            }
        }
    }
    private void resolver(){
        pasos = 0;
        sHanoi(t.getnDiscos(), "o", "a", "d");
    }

    public void MovimientosD(String  origin, String  destination) {
        if(origin.equals("o") && destination.equals("a")){
            Iniciar();
        }else if(origin.equals("o") && destination.equals("d")){
            Iniciard();
        }else if(origin.equals("a") && destination.equals("o")){
            pivoteInicial();
        }else if(origin.equals("a") && destination.equals("d")){
            pivoteD();
        }else if(origin.equals("d") && destination.equals("o")){
            destinoInicial();
        }else{
            destinoPivote();
        }
    }

    public boolean Continuar() {
        if(!juegoTerminado()){
            pasos +=1;
            int opcion = JOptionPane.showConfirmDialog(null, "PASO #" + pasos + "\n¿continuar?", "Pregunta", JOptionPane.YES_NO_OPTION);
            return opcion == JOptionPane.YES_OPTION;
        }
        return false;
    }

    public void sHanoi(int n, String origen, String auxiliar, String destino) {
        if(!juegoTerminado()){
            if (n == 1) {
                MovimientosD(origen, destino);
                FC = Continuar();
            } else {
                sHanoi(n - 1, origen, destino, auxiliar);
                if (FC) {
                    MovimientosD(origen, destino);
                    FC = Continuar();
                }
                if (FC) {
                    sHanoi(n - 1, auxiliar, origen, destino);
                }
            }
        }
    }

    private boolean juegoTerminado() {
        return t.getTorreD().size() == t.getnDiscos() && t.getTorreI().isEmpty() && t.getTorreP().isEmpty();
    }

}
