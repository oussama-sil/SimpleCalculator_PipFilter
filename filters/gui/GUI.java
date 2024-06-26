package filters.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import filters.*;
import pipes.*;


public class GUI extends Filter {
    
    public GUI(Pipe pipe_in,Pipe pipe_out){
        super(pipe_in,pipe_out);
    }

    public void run(){

        JFrame fram1=new JFrame();
        fram1.setSize(400, 330);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize(); 
        fram1.setLocation(
            (screenDimension.width-400)/2,
            (screenDimension.height-320)/2
        );
        fram1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram1.setLayout(new BorderLayout(10,10));
        fram1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        JPanel topFrPanel=new JPanel(new BorderLayout(10, 15));
        JLabel titLabel=new JLabel("PIPE ET FILTER");
        titLabel.setBorder(new EmptyBorder(10,0,10,10));
        titLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        titLabel.setHorizontalAlignment(JLabel.CENTER);
        titLabel.setVerticalAlignment(JLabel.CENTER);
        JPanel fieldsPanel=new JPanel(new GridLayout(1, 4,10,10));
        fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel NBOJLabel=new JLabel("Nombre 1 :");
        JTextField NBOField=new JTextField(20);
        JLabel NBTJLabel=new JLabel("Nombre 2 :");
        JTextField NBTField=new JTextField(20);
        fieldsPanel.add(NBOJLabel);
        fieldsPanel.add(NBOField);
        fieldsPanel.add(NBTJLabel);
        fieldsPanel.add(NBTField);
        JPanel CalcPanel=new JPanel(new FlowLayout());
        JButton sumButton=new JButton("SOMME");
        CalcPanel.add(sumButton);
        JButton prodButton=new JButton("PRODUIT");
        CalcPanel.add(prodButton);
        JButton factButton=new JButton("FACTORIEL");
        CalcPanel.add(factButton);

        topFrPanel.add(titLabel,BorderLayout.NORTH);
        topFrPanel.add(fieldsPanel,BorderLayout.CENTER);
        topFrPanel.add(CalcPanel,BorderLayout.SOUTH);

        JPanel MidFrPanel=new JPanel(new BorderLayout(10,15));
        MidFrPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        JPanel resPanel=new JPanel(new BorderLayout(10, 0));
        JLabel ResJLabel=new JLabel("RESULTATS");
        ResJLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        ResJLabel.setHorizontalAlignment(JLabel.CENTER);
        ResJLabel.setVerticalAlignment(JLabel.CENTER);
        JTextField ResField=new JTextField(20);
        ResField.setEditable(false);
        ResField.setText("....");
        ResField.setFont(new Font("Calibri", Font.BOLD, 14));
        ResField.setHorizontalAlignment(JTextField.CENTER);
        ResField.setBorder(new EmptyBorder(5, 10, 10, 10));


        resPanel.add(ResJLabel,BorderLayout.NORTH);
        resPanel.add(ResField,BorderLayout.SOUTH);
        JPanel qTPanel=new JPanel(new FlowLayout());
        JButton traceButton=new JButton("TRACE");
        JButton QuitButton=new JButton("QUITTER");
        qTPanel.add(QuitButton);
        QuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        qTPanel.add(traceButton);

        MidFrPanel.add(resPanel,BorderLayout.NORTH);
        MidFrPanel.add(qTPanel,BorderLayout.SOUTH);

        JPanel botPanel=new JPanel(new BorderLayout(10, 15));
        botPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel LogsJLabel=new JLabel("TRACE");
        LogsJLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        LogsJLabel.setHorizontalAlignment(JLabel.CENTER);
        LogsJLabel.setVerticalAlignment(JLabel.CENTER);
        JTextArea LogsField=new JTextArea(5,20);
        LogsField.setEditable(false);
        JScrollPane logScrollPane=new JScrollPane(LogsField);
        JButton quitTrace=new JButton("QUITTER TRACE");
        botPanel.add(LogsJLabel,BorderLayout.NORTH);
        botPanel.add(logScrollPane,BorderLayout.CENTER);
        botPanel.add(quitTrace,BorderLayout.SOUTH);
        quitTrace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LogsField.setText("");
                fram1.remove(botPanel);
                fram1.revalidate();
                fram1.repaint();
            }
        });


        traceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                sendData("");
                fram1.add(botPanel,BorderLayout.SOUTH);
                fram1.revalidate();
                fram1.repaint();
                LogsField.setText(getData().replace(';', '\n'));
            }
        });
        
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(NBOField.getText().length()>0 && NBOField.getText().length()>0){
                    String exp=NBOField.getText()+" + "+NBTField.getText();
                    sendData(exp);
                    fram1.remove(botPanel);
                    fram1.revalidate();
                    fram1.repaint();
                    ResField.setText(getData());
                }
            }
        });
        
        prodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(NBOField.getText().length()>0 && NBOField.getText().length()>0){
                    String exp=NBOField.getText()+" * "+NBTField.getText();
                    sendData(exp);
                    fram1.remove(botPanel);
                    fram1.revalidate();
                    fram1.repaint();
                    ResField.setText(getData());
                }
            }
        });

        factButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(NBOField.getText().length()>0){
                    String exp=NBOField.getText()+" !";
                    sendData(exp);
                    fram1.remove(botPanel);
                    fram1.revalidate();
                    fram1.repaint();
                    ResField.setText(getData());
                }
            }
        });
        
        fram1.add(topFrPanel,BorderLayout.NORTH);
        fram1.add(MidFrPanel,BorderLayout.CENTER);
        
        fram1.setVisible(true);

    }
}
