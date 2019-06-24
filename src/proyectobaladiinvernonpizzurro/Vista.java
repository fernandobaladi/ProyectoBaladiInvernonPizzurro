/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.PlainDocument;
import javax.swing.UIManager;
import javax.swing.text.PlainDocument;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Invernon
 */
public class Vista extends javax.swing.JFrame {
    
        //Contador y Id de las ciudades existentes en la partida
        int cityCounter = 0, CityId = 0, InsertCityPos=0;
        
        //Creación de variables para guardar los inputs del usuario
        int AntsNum=0, Iterations=0, βValue, αValue;
        double ρValue, cityDistance;
        String cityName;
               
        
        JButton jButton1 = new javax.swing.JButton();
        ListaVertices listaDeCiudades = new ListaVertices("Lista de ciudades");
        Hormiga[] colonia;
        JLabel CityImage = new javax.swing.JLabel();        
        JLabel Cities[] = new JLabel [20];        
        private Image ant = new ImageIcon("ant .png").getImage();
        Cities_ Cities_[] = new Cities_ [20];        
        //distanceMatrix distanceMatrix = new distanceMatrix();
        boolean deleteCity = false;
        File archivo = new File("archivo.txt");
        Tests Test = new Tests();
        Archivo a = new Archivo();
        
        
        //jajajajajajjaa matriz de distancias para la lista
        double[][] matrizDistancias = new double[20][20];
        
        
    
    public Vista() {
             
        initComponents();
                        
        //Inicializacion de los paneles y botones 
        jPanelNewGame.setVisible(false);
        jPanelInstruction.setVisible(false);
        NewCityjPanel.setVisible(false);
        DeleteCityjPanel.setVisible(false);
        AddCityjButton.setEnabled(false);
        DeleteCityjButton.setEnabled(false);
        jPanelGame.setVisible(false);
        jPanelMain.setSize(720,720);
        jPanelMain.setVisible(true);
        SavejButton.setEnabled(false);
        jPanelGame.setSize(720, 720);
        
        //Restricciones de los inputs 
        AntsNumInput.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent event)
           {
              char character = event.getKeyChar();

              // Verifica si la tecla pulsada por el usuario no es un digito
              if(((character < '0') ||
                 (character > '9')) &&
                 (character != '\b'))  // el backspace
              {
                 event.consume();  // ignorar el teclado
              }
           }
        });
        
        IterationsInput.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent event)
           {
              char character = event.getKeyChar();

              // Verifica si la tecla pulsada por el usuario no es un digito
              if(((character < '0') ||
                 (character > '9')) &&
                 (character != '\b'))  // el backspace
              {
                 event.consume();  // ignorar el teclado
              }
           }
        });
        
        βValueInput.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent event)
           {
              char character = event.getKeyChar();

              // Verifica si la tecla pulsada por el usuario no es un digito
              if(((character < '0') ||
                 (character > '9')) &&
                 (character != '\b'))  // el backspace
              {
                 event.consume();  // ignorar el teclado
              }
           }
        });
        
        αValueInput.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent event)
           {
              char character = event.getKeyChar();

              // Verifica si la tecla pulsada por el usuario no es un digito
              if(((character < '0') ||
                 (character > '9')) &&
                 (character != '\b'))  // el backspace
              {
                 event.consume();  // ignorar el teclado
              }
           }
        });
        
        ρValueInput.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent event)
           {
              char character = event.getKeyChar();

              // Verifica si la tecla pulsada por el usuario no es un digito
              if(((character < '0') ||
                 (character > '9')) &&
                 (character != '.') &&
                 (character != '\b'))  // el backspace
              {
                 event.consume();  // ignorar el teclado
              }
           }
        });
                                 
        //Texto a mostrar en el label donde se pide el nombre de la ciudad 
        CityNamejLabel1.setText("Nombre de la ciudad nº " + (cityCounter+1));
                                          
        //Validez de los inputs de los valores predeterminados o personalizados
        if (CustomValuesButton.isSelected()) {
        
            βValueInput.setEditable(true);
            αValueInput.setEditable(true);
            ρValueInput.setEditable(true);
        } 
        else {
            βValueInput.setEditable(false);
            αValueInput.setEditable(false);
            ρValueInput.setEditable(false);
        }
        
        UIManager.put("TextField.disabledBackground", Color.RED);
                
    }
    
    public void paintImage(Graphics g){
        g.drawImage(ant,250,250,null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tests1 = new proyectobaladiinvernonpizzurro.Tests();
        jPanelGame = new javax.swing.JPanel();
        DrawCitiesButton = new javax.swing.JButton();
        ShowTravelsButton = new javax.swing.JButton();
        AntsTravelInfojLabel = new javax.swing.JLabel();
        CitiesjPanel = new javax.swing.JPanel();
        jPanelInstruction = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanelNewGame = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        NewCityjPanel = new javax.swing.JPanel();
        CityNamejLabel1 = new javax.swing.JLabel();
        CityNameInput = new javax.swing.JTextField();
        CityNameValidationButton = new javax.swing.JButton();
        ConfirmNewCityjButton = new javax.swing.JButton();
        DeleteCityjPanel = new javax.swing.JPanel();
        Cities1 = new javax.swing.JPanel();
        StartGamejButton = new javax.swing.JButton();
        NewGameOptionsjPanel = new javax.swing.JPanel();
        AntsNumInput = new javax.swing.JTextField();
        CustomValuesButton = new javax.swing.JRadioButton();
        DefaultValuesButton = new javax.swing.JRadioButton();
        AntsNumjLabel = new javax.swing.JLabel();
        VariablesValuesjLabel1 = new javax.swing.JLabel();
        βVariableValuejLabel = new javax.swing.JLabel();
        βValueInput = new javax.swing.JTextField();
        αVariableValuejLabel = new javax.swing.JLabel();
        αValueInput = new javax.swing.JTextField();
        ρVariableValuejLabel = new javax.swing.JLabel();
        ρValueInput = new javax.swing.JTextField();
        GameOptionsValidationButton = new javax.swing.JButton();
        IterationsInput = new javax.swing.JTextField();
        IterationsjLabel = new javax.swing.JLabel();
        DeleteCityjButton = new javax.swing.JButton();
        AddCityjButton = new javax.swing.JButton();
        jPanelMenu = new javax.swing.JPanel();
        InstructionsjButton = new javax.swing.JButton();
        SavejButton = new javax.swing.JButton();
        LoadGamejButton = new javax.swing.JButton();
        ExitjButton = new javax.swing.JButton();
        NewGamejButton = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelGame.setBackground(new java.awt.Color(213, 204, 206));
        jPanelGame.setPreferredSize(new java.awt.Dimension(600, 500));

        DrawCitiesButton.setBackground(new java.awt.Color(164, 225, 3));
        DrawCitiesButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DrawCitiesButton.setText("Cargar ciudades");
        DrawCitiesButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        DrawCitiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawCitiesButtonActionPerformed(evt);
            }
        });

        ShowTravelsButton.setBackground(new java.awt.Color(164, 225, 3));
        ShowTravelsButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ShowTravelsButton.setText("Todos los recorridos");
        ShowTravelsButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        ShowTravelsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowTravelsButtonActionPerformed(evt);
            }
        });

        AntsTravelInfojLabel.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        AntsTravelInfojLabel.setText("Para ver la trayectoria de solo una hormiga darle click a la hormiga");

        CitiesjPanel.setBackground(new java.awt.Color(213, 204, 206));
        CitiesjPanel.setMinimumSize(new java.awt.Dimension(500, 500));
        CitiesjPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanelGameLayout = new javax.swing.GroupLayout(jPanelGame);
        jPanelGame.setLayout(jPanelGameLayout);
        jPanelGameLayout.setHorizontalGroup(
            jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DrawCitiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGameLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGameLayout.createSequentialGroup()
                                .addComponent(AntsTravelInfojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ShowTravelsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CitiesjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelGameLayout.setVerticalGroup(
            jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(DrawCitiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CitiesjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowTravelsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AntsTravelInfojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInstruction.setBackground(new java.awt.Color(213, 204, 206));
        jPanelInstruction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instrucciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanelInstruction.setPreferredSize(new java.awt.Dimension(600, 500));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanelInstructionLayout = new javax.swing.GroupLayout(jPanelInstruction);
        jPanelInstruction.setLayout(jPanelInstructionLayout);
        jPanelInstructionLayout.setHorizontalGroup(
            jPanelInstructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstructionLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelInstructionLayout.setVerticalGroup(
            jPanelInstructionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstructionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanelNewGame.setBackground(new java.awt.Color(213, 204, 206));
        jPanelNewGame.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Partida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanelNewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelNewGame.setMaximumSize(new java.awt.Dimension(720, 720));
        jPanelNewGame.setPreferredSize(new java.awt.Dimension(600, 500));

        NewCityjPanel.setBackground(new java.awt.Color(192, 178, 181));
        NewCityjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Ciudad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        CityNamejLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        CityNameInput.setBackground(new java.awt.Color(215, 214, 213));
        CityNameInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CityNameInput.setBorder(null);
        CityNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityNameInputActionPerformed(evt);
            }
        });

        CityNameValidationButton.setBackground(new java.awt.Color(164, 225, 3));
        CityNameValidationButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CityNameValidationButton.setText("Aceptar");
        CityNameValidationButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        CityNameValidationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityNameValidationButtonActionPerformed(evt);
            }
        });

        ConfirmNewCityjButton.setBackground(new java.awt.Color(164, 225, 3));
        ConfirmNewCityjButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ConfirmNewCityjButton.setText("Guardar ciudad");
        ConfirmNewCityjButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        ConfirmNewCityjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmNewCityjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewCityjPanelLayout = new javax.swing.GroupLayout(NewCityjPanel);
        NewCityjPanel.setLayout(NewCityjPanelLayout);
        NewCityjPanelLayout.setHorizontalGroup(
            NewCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewCityjPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(NewCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewCityjPanelLayout.createSequentialGroup()
                        .addComponent(ConfirmNewCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewCityjPanelLayout.createSequentialGroup()
                        .addComponent(CityNamejLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(CityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(CityNameValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        NewCityjPanelLayout.setVerticalGroup(
            NewCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewCityjPanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(NewCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CityNamejLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NewCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CityNameValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(ConfirmNewCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        DeleteCityjPanel.setBackground(new java.awt.Color(192, 178, 181));
        DeleteCityjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Ciudad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        DeleteCityjPanel.setAutoscrolls(true);
        DeleteCityjPanel.setMaximumSize(new java.awt.Dimension(568, 369));
        DeleteCityjPanel.setPreferredSize(new java.awt.Dimension(568, 369));

        Cities1.setBackground(new java.awt.Color(192, 178, 181));

        javax.swing.GroupLayout Cities1Layout = new javax.swing.GroupLayout(Cities1);
        Cities1.setLayout(Cities1Layout);
        Cities1Layout.setHorizontalGroup(
            Cities1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        Cities1Layout.setVerticalGroup(
            Cities1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DeleteCityjPanelLayout = new javax.swing.GroupLayout(DeleteCityjPanel);
        DeleteCityjPanel.setLayout(DeleteCityjPanelLayout);
        DeleteCityjPanelLayout.setHorizontalGroup(
            DeleteCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteCityjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cities1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeleteCityjPanelLayout.setVerticalGroup(
            DeleteCityjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cities1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(NewCityjPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(DeleteCityjPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewCityjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DeleteCityjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NewCityjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(DeleteCityjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        StartGamejButton.setBackground(new java.awt.Color(164, 225, 3));
        StartGamejButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        StartGamejButton.setText("Comenzar");
        StartGamejButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        StartGamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartGamejButtonActionPerformed(evt);
            }
        });

        NewGameOptionsjPanel.setBackground(new java.awt.Color(213, 204, 206));

        AntsNumInput.setBackground(new java.awt.Color(192, 178, 181));
        AntsNumInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AntsNumInput.setBorder(null);
        AntsNumInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntsNumInputActionPerformed(evt);
            }
        });

        CustomValuesButton.setBackground(new java.awt.Color(213, 204, 206));
        CustomValuesButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CustomValuesButton.setText("Personalizados");
        CustomValuesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomValuesButtonActionPerformed(evt);
            }
        });

        DefaultValuesButton.setBackground(new java.awt.Color(213, 204, 206));
        DefaultValuesButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DefaultValuesButton.setText("Por defecto");
        DefaultValuesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultValuesButtonActionPerformed(evt);
            }
        });

        AntsNumjLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AntsNumjLabel.setText("Cantidad de hormigas");

        VariablesValuesjLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VariablesValuesjLabel1.setText("Valores de β, α y ρ");

        βVariableValuejLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        βVariableValuejLabel.setText("β");

        βValueInput.setBackground(new java.awt.Color(192, 178, 181));
        βValueInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        βValueInput.setBorder(null);

        αVariableValuejLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        αVariableValuejLabel.setText("α");

        αValueInput.setBackground(new java.awt.Color(192, 178, 181));
        αValueInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        αValueInput.setBorder(null);

        ρVariableValuejLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ρVariableValuejLabel.setText("ρ");

        ρValueInput.setBackground(new java.awt.Color(192, 178, 181));
        ρValueInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ρValueInput.setBorder(null);

        GameOptionsValidationButton.setBackground(new java.awt.Color(164, 225, 3));
        GameOptionsValidationButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GameOptionsValidationButton.setText("Aceptar");
        GameOptionsValidationButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        GameOptionsValidationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameOptionsValidationButtonActionPerformed(evt);
            }
        });

        IterationsInput.setBackground(new java.awt.Color(192, 178, 181));
        IterationsInput.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        IterationsInput.setBorder(null);

        IterationsjLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IterationsjLabel.setText("Número de iteraciones ");

        DeleteCityjButton.setBackground(new java.awt.Color(249, 173, 107));
        DeleteCityjButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DeleteCityjButton.setText("Eliminar ciudad");
        DeleteCityjButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 139, 45), 2, true));
        DeleteCityjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCityjButtonActionPerformed(evt);
            }
        });

        AddCityjButton.setBackground(new java.awt.Color(164, 225, 3));
        AddCityjButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        AddCityjButton.setText("Agregar ciudad");
        AddCityjButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        AddCityjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCityjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewGameOptionsjPanelLayout = new javax.swing.GroupLayout(NewGameOptionsjPanel);
        NewGameOptionsjPanel.setLayout(NewGameOptionsjPanelLayout);
        NewGameOptionsjPanelLayout.setHorizontalGroup(
            NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewGameOptionsjPanelLayout.createSequentialGroup()
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                        .addContainerGap(170, Short.MAX_VALUE)
                        .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                                .addComponent(AddCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                                .addComponent(VariablesValuesjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(DefaultValuesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CustomValuesButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                                .addComponent(IterationsjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IterationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(GameOptionsValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                                .addComponent(AntsNumjLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AntsNumInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(βVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(βValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(αVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(αValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ρVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ρValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        NewGameOptionsjPanelLayout.setVerticalGroup(
            NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewGameOptionsjPanelLayout.createSequentialGroup()
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AntsNumjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AntsNumInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomValuesButton)
                    .addComponent(VariablesValuesjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DefaultValuesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ρValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(αValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(βValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(βVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(αVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ρVariableValuejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IterationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GameOptionsValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IterationsjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NewGameOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteCityjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(421, 421, 421))
        );

        javax.swing.GroupLayout jPanelNewGameLayout = new javax.swing.GroupLayout(jPanelNewGame);
        jPanelNewGame.setLayout(jPanelNewGameLayout);
        jPanelNewGameLayout.setHorizontalGroup(
            jPanelNewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewGameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelNewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewGameOptionsjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewGameLayout.createSequentialGroup()
                        .addComponent(StartGamejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanelNewGameLayout.setVerticalGroup(
            jPanelNewGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewGameLayout.createSequentialGroup()
                .addComponent(NewGameOptionsjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StartGamejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelMenu.setBackground(new java.awt.Color(213, 204, 206));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanelMenu.setPreferredSize(new java.awt.Dimension(180, 408));

        InstructionsjButton.setBackground(new java.awt.Color(164, 225, 3));
        InstructionsjButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        InstructionsjButton.setText("Instrucciones");
        InstructionsjButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        InstructionsjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InstructionsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsjButtonActionPerformed(evt);
            }
        });

        SavejButton.setBackground(new java.awt.Color(164, 225, 3));
        SavejButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SavejButton.setText("Guardar");
        SavejButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        SavejButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SavejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavejButtonActionPerformed(evt);
            }
        });

        LoadGamejButton.setBackground(new java.awt.Color(164, 225, 3));
        LoadGamejButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        LoadGamejButton.setText("Cargar Partida");
        LoadGamejButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        LoadGamejButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoadGamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadGamejButtonActionPerformed(evt);
            }
        });

        ExitjButton.setBackground(new java.awt.Color(249, 173, 107));
        ExitjButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ExitjButton.setText("Salir");
        ExitjButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 139, 45), 2, true));
        ExitjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitjButtonActionPerformed(evt);
            }
        });

        NewGamejButton.setBackground(new java.awt.Color(164, 225, 3));
        NewGamejButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        NewGamejButton.setText("Nueva Partida");
        NewGamejButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
        NewGamejButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NewGamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGamejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewGamejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoadGamejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(InstructionsjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SavejButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(NewGamejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadGamejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InstructionsjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SavejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelMain.setBackground(new java.awt.Color(213, 204, 206));
        jPanelMain.setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectobaladiinvernonpizzurro/ant3 .png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectobaladiinvernonpizzurro/title.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanelNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jPanelNewGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jPanelGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jPanelInstruction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGamejButtonActionPerformed

        InstructionsjButton.setEnabled(true);
        
        if (jPanelNewGame.isVisible() == false) {
        
            initializeComponents();
        }
        if (!AntsNumInput.getText().equals("")){
        
            if (JOptionPane.showConfirmDialog(null, "Deseas empezar desde 0?" , "Nueva Configuración de partida", YES_NO_OPTION) == 0){
               
               DeleteData();
               initializeComponents();
            }
        }
        
        
    }//GEN-LAST:event_NewGamejButtonActionPerformed

    public void initializeComponents (){
    
        //Coloca los estados de los paneles y botones como estaban en un principio
                NewCityjPanel.setVisible(false);
                jPanelMain.setVisible(false);
                DeleteCityjPanel.setVisible(false);
                jPanelInstruction.setVisible(false);
                jPanelNewGame.setVisible(true);
                CustomValuesButton.setSelected(false);
                DefaultValuesButton.setSelected(true);
                AddCityjButton.setEnabled(false);
                DeleteCityjButton.setEnabled(false);
                AntsNumInput.setEditable(true);
                IterationsInput.setEditable(true);
                CustomValuesButton.setEnabled(true);
                DefaultValuesButton.setEnabled(true);
                βValueInput.setEditable(false);
                αValueInput.setEditable(false);
                ρValueInput.setEditable(false);  
                AntsTravelInfojLabel.setVisible(false);
                ShowTravelsButton.setVisible(false);
                cityCounter=0;
                CityId=0;
    }
    
    public void DeleteData (){
                    
                 //Vaciar los campos de inputs
                AntsNumInput.setText("");
                βValueInput.setText("");
                αValueInput.setText("");
                ρValueInput.setText("");
                IterationsInput.setText("");

                //Vaciar el array de ciudades 
               
                for(int i=0; i<Cities_.length; i++){
                   Cities_[i] = null;
               }
                     
    }
    private void ExitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitjButtonActionPerformed
       
        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir? " , "Salir", YES_NO_OPTION) == 0){
        
            System.exit(0);
        }
        
    }//GEN-LAST:event_ExitjButtonActionPerformed

    private void InstructionsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionsjButtonActionPerformed
        
        jPanelInstruction.setVisible(true); 
        jPanelNewGame.setVisible(false);
        jPanelMain.setVisible(false);
        
                
    }//GEN-LAST:event_InstructionsjButtonActionPerformed
    
    //Se pintan las hormigas en la pantalla de juego
    public void drawAnts () {
            
        Ants_ ants[] = new Ants_[AntsNum];
        int path[] = {3,4,1,0,12,5,6,7,9,10,8,11};
        
        for (int i=0; i < AntsNum; i++) {
            
            int pos = findCity (1, Cities_);
            ants[i] = new Ants_(i ,(i*100) , (i+1)); // debe recibir las posiciones iniciales de cada hormiga 
            final int index =  i;
            
            //función para que al darle click a una hormiga se muestre su trayectoria
            ants[i].label.addMouseListener(new MouseAdapter()
            {  
                public void mouseClicked(MouseEvent e)  
                {  
                    moveAnt (ants, index, path);
//                  drawCities();
                    drawCitiesFullPanel (index+1);
                }  
            }); 
        }        

       // AntsjPanel.removeAll();
                
        for (int i=0; i < AntsNum; i++) {    
            if( ants[i] != null ){   
                CitiesjPanel.add(ants[i].label);
            }
        } 
        
        repaintPanel();
    }
    
    public void moveAnt (Ants_[] ants, int index, int [] path) {

        int aux = 0, cont=0;
        
        for (int i = 0; i < path.length; i++){
        do {
           int pos = findCity (path[i], Cities_);
           ants[index].label.setLocation(Cities_[i].posX, Cities_[i].posY);
           
           
               
               cont ++;
           }while (cont< 10000);
        }
        
        
    }
    
    public int findCity (int id, Cities_[] cities){
    
        int aux = 0;
        
        for (int i=0; i< cities.length; i++){
        
            if (cities[i].ID == id) {
            
                aux = i;
                break;
            }
        }
        return aux;
    }
    
    //Se pintan las ciudades en la pantalla de juego
    public void drawCities (){
               
      
        //CitiesjPanel.removeAll();
        for (int i=0; i < Cities_.length; i++) {
            if( Cities_[i] != null ){
                JLabel name = new JLabel();
                
                Cities_[i].CityPosition(AsignPositionX(i,cityCounter), AsignPositionY(i,cityCounter));
                name.setBounds(Cities_[i].posX , Cities_[i].posY + 40, 100 , 20 );
                name.setText(Cities_[i].name);
                name.setBackground(new java.awt.Color(213,204,206));
                name.setVisible(true);
                name.setOpaque(true);
                CitiesjPanel.add(Cities_[i].label);
                CitiesjPanel.add(name);
            }
        }        
        
        repaintPanel();
        
//        drawCitiesFullPanel ();
    }
    
    public void drawCitiesPanel(){
            CitiesjPanel.setLayout(null);
            CitiesjPanel.setBounds(50,60,510,500);
            CitiesjPanel.setOpaque(true);
    }
    
    public void repaintPanel(){
        CitiesjPanel.validate();
        CitiesjPanel.repaint();
    }
    
    //Se pintan las ciudades en la pantalla de recorrido de las hormigas
    public void drawCitiesFullPanel (int antNum){
                
        int path[] = {3,4,1,0,12,5,6,7,9,10,8,11,3}; // tiene que colocarse que reciba la trayectoria de la hormiga y debe colocarse que recibe un array path
        drawFullPanel(Cities_, path, antNum);
    }
    
    //Se crea la pantalla donde se mostrará el recorrido de las hormigas
    public void drawFullPanel (Cities_[] cities, int[] path, int antNum) {
    
        CreateLabelDynamically c = new CreateLabelDynamically(cities, path);
        c.setTitle("Trayectoria de la hormiga número " + antNum);
        c.setSize(700,700);
        c.setVisible(true);
        
//        for (int i=0; i < Cities_.length; i++) {
//            if( Cities_[i] != null ){
//                Cities_[i].CityPosition(AsignPositionX(i,cityCounter), AsignPositionY(i,cityCounter));
////                c.PaintCity( Cities_[i].label, Cities_[i].posX , Cities_[i].posY ); //Esta es para que se pinte en el cuadro extra. Se tiene que desactivar el otro.
//            }
//        }        
    }
    
    //Se asigna la posición X de las ciudades en el panel 
    public int AsignPositionX (int i, int cityCounter){
        int var;
        double posX;   
        var = 100;               
            if (cityCounter > 11) {       
                if (i < 10 && i % 2 == 0) {           
                    posX = 62.5;               
                }
                else if (i < 10 && i % 2 != 0) {           
                    posX = 500 - 62.5;               
                }
                else if (i >= 10 && i % 2 == 0 ) {           
                    posX = 62.5*3;               
                }
                else {           
                    posX = 62.5*5;               
                }
            }
            else {       
                if (i % 2 == 0) {           
                    if (i == (cityCounter-1)) {               
                        posX = 500/2;                   
                    }
                    else{
                        posX = var;
                    }               
                }
                else{               
                    posX = 500 - var;               
                }
            }       
            return (int)posX;                   
    }
    
    //Se asigna la posición Y de las ciudades en el panel 
    public int AsignPositionY (int i, int cityCounter){
    
        int even, odd; //Even para el calculo para los numeros pares , Odd para los impares
        double gamma; // Constante para que se vayan desplazando hacia abajo
        double posY,rowPos;
        
        even = (cityCounter/2) + 1; 
        odd = (cityCounter + 1) / 2;
        rowPos = Math.floor( (i/2) + 1);
        
            if (cityCounter > 11) {
                if (i < 10 && i % 2 == 0) { 
                    gamma = ( 500 / even );
                    posY = gamma * rowPos;
//                    posY = 500 / (even * rowPos); 
                }
                else if (i < 10 && i % 2 != 0) {
                    gamma = ( 500 / odd );
                    posY = (gamma * rowPos) + 25;
//                    posY = (500 / (odd * rowPos)) + 25;
                }
                else if (i >= 10 && i % 2 == 0 ) {
                    gamma = ( 500 / even );
                    rowPos = Math.floor( ( (i-10) /2) + 1);
                    posY = (gamma * rowPos) + 25;
//                    posY = (500 / (even * rowPos)) + 25; 
                }
                else {
                    gamma = ( 500 / odd );
                    rowPos = Math.floor( ( (i-10) /2) + 1);
                    posY = (gamma * rowPos);
//                    posY = 500 / (odd * rowPos);
                }
            }
            else {
                if (i % 2 == 0) {
                    if (i == (cityCounter - 1) ) {
                        posY = 500/2;
                    }
                    else {
//                        gamma = ( 500 / even );
//                        posY = gamma * rowPos;
                          posY = 500/(even*rowPos);
//                         posY = 500 / (even * rowPos); 
                    }
                }
                else{       
                    //gamma = ( 500 / odd );
                    //posY = (gamma * rowPos);
                    posY = 500/(odd * rowPos);
//                  posY = 500 / (odd * rowPos);
                }
            }
            
            return (int) posY;
                        
    }
    
    private void LoadGamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadGamejButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtroTXT = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtroTXT);
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION ) {


            archivo = fc.getSelectedFile();

            String contenido = a.loadGame(archivo);
            String auxEtiquetaCiudadVertice, auxIdCiudadVertice, auxDistancia, auxFeromonas, auxIdCiudadArista, auxEtiquetaCiudadArista;
            try {

                BufferedReader bf = new BufferedReader(new FileReader(fc.getSelectedFile().toString()));
                String aux;
                String bfRead = bf.readLine();
                aux = bfRead;

                // arreglo = aux.split(",", 3);
                while (aux != null) {

                    if (aux.equals("ciudades")) {
                        int count=0;
                        do {
                            aux = bf.readLine();
                            if (!aux.equals("fin_ciudades")) {
                                
                                String[] arreglo = aux.split(",", 2);
                                auxEtiquetaCiudadVertice = arreglo[0];
                                Cities_[count].name = arreglo[0];
                                auxIdCiudadVertice = arreglo[1];
                                int idCiudad = Integer.parseInt(auxIdCiudadVertice);
                                Cities_[count].ID = idCiudad;
                              listaDeCiudades.agregarAlFinal(auxEtiquetaCiudadVertice, idCiudad);
                            }

                        } while (!aux.equals("fin_ciudades"));

                    }
                    if (aux.equalsIgnoreCase("fin_ciudades")) {
                        do {

                            aux = bf.readLine();
                            if (!aux.equals("fin_caminos")) {

                                String[] arreglo2 = aux.split(",", 4);
                                auxDistancia = arreglo2[0];
                                auxFeromonas = arreglo2[1];
                                auxIdCiudadArista = arreglo2[2];
                                auxEtiquetaCiudadArista = arreglo2[3];
                                int distancia = Integer.parseInt(auxDistancia), feromonas = Integer.parseInt(auxFeromonas), idCiudad = Integer.parseInt(auxIdCiudadArista);


                                /*for (int i = 1; i < listaDeCiudades.nNodos; i++) {

                                }*/
                            }

                        } while (!aux.equals("fin_caminos"));

                    }
                    if (aux.equalsIgnoreCase("fin_caminos")) {
                        do {
                            aux = bf.readLine();
                            αValue = Integer.parseInt(aux);
                        } while (!aux.equals("fin_alpha"));
                    }
                    if (aux.equalsIgnoreCase("fin_alpha")) {
                        do {
                            aux = bf.readLine();
                            βValue = Integer.parseInt(aux);
                        } while (!aux.equals("fin_beta"));
                    }
                    if (aux.equalsIgnoreCase("fin_beta")) {
                        do {
                            aux = bf.readLine();
                            ρValue = Double.parseDouble(aux);
                        } while (!aux.equals("fin_ro"));
                    }
                    if (aux.equalsIgnoreCase("fin_ro")) {
                        do {
                            aux = bf.readLine();
                            AntsNum = Integer.parseInt(aux);
                        } while (!aux.equals("fin_nHormigas"));
                    }
                    if (aux.equalsIgnoreCase("fin_nHormigas")) {
                        do {
                            aux = bf.readLine();
                            Iterations = Integer.parseInt(aux);
                        } while (aux != null);
                    }
                    aux = bf.readLine();
                }

            } catch (Exception e) {
                System.out.println("No se pudo leer el archivo.");
            }
            jPanelInstruction.setVisible(true);
            

        }
    }//GEN-LAST:event_LoadGamejButtonActionPerformed

    private void StartGamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartGamejButtonActionPerformed

        drawTest();
        if (cityCounter<4) {
            
            JOptionPane.showMessageDialog(null, "No puedes empezar tu partida con menos de 4 ciudades");
        }
        else {

            if (!AntsNumInput.getText().equals("") && (CustomValuesButton.isSelected() || DefaultValuesButton.isSelected()) &&
                    !IterationsInput.getText().equals("")) {
                
                if(CustomValuesButton.isSelected()){

                    if (βValueInput.getText().equals("") || αValueInput.getText().equals("") || ρValueInput.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de continuar");
                    }
                }
                else {

                    if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas empezar tu partida con " + cityCounter + " ciudades? ",
                            "Iniciar partida", YES_NO_OPTION) == 0) {
                    
                        SavejButton.setEnabled(true);
                        jPanelNewGame.setVisible(false);
                        jPanelGame.setVisible(true);
                        jPanelMain.setVisible(false);
                        InstructionsjButton.setEnabled(false);
                                                
                        for (int i = 0; i < colonia.length; i++) {
                            //Hormiga h = new Hormiga(escogerCiudadDeHormiga(),cityCounter, listaDeCiudades);
                            //colonia[i]=h;
                        }
                                              
                    }
                }
            }
            else {

                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de continuar");
            }

        }
        
    }//GEN-LAST:event_StartGamejButtonActionPerformed

    private void GameOptionsValidationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameOptionsValidationButtonActionPerformed
       
        
        if (!AntsNumInput.getText().equals("") && (CustomValuesButton.isSelected() || DefaultValuesButton.isSelected()) &&
                    !IterationsInput.getText().equals("")) {
            
            if(CustomValuesButton.isSelected()){

                if (βValueInput.getText().equals("") || αValueInput.getText().equals("") || ρValueInput.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de continuar");
                }
                else{
                
                    if (!AntsNumInput.getText().equals("0") && !IterationsInput.getText().equals("0")) {
                        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas estos valores en tu partida?", 
                                "Valores de la partida", YES_NO_OPTION) == 0) {

                            AntsNumInput.setEditable(false);
                            IterationsInput.setEditable(false);
                            CustomValuesButton.setEnabled(false);
                            DefaultValuesButton.setEnabled(false);
                            AddCityjButton.setEnabled(true);
                            DeleteCityjButton.setEnabled(true);
                            colonia = new Hormiga[AntsNum];
                                                     
                            //Se asiganan los valores de los inputs en variables
                            AntsNum = Integer.parseInt(AntsNumInput.getText());
                            Iterations = Integer.parseInt(IterationsInput.getText());
                            βValue = Integer.parseInt(βValueInput.getText());
                            αValue = Integer.parseInt(αValueInput.getText());
                            ρValue = Double.parseDouble(ρValueInput.getText());
                        }
                    }
                    else{
                    
                        JOptionPane.showMessageDialog(null, "Valores inválidos! No puedes tener ni 0 hormigas ni 0 iteraciones");
                    }
                }
            }
            else {

                if (!AntsNumInput.getText().equals("0") && !IterationsInput.getText().equals("0")) {
                    
                        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas estos valores en tu partida?", 
                                "Valores de la partida", YES_NO_OPTION) == 0) {

                            AntsNumInput.setEditable(false);
                            IterationsInput.setEditable(false);
                            CustomValuesButton.setEnabled(false);
                            DefaultValuesButton.setEnabled(false);
                            AddCityjButton.setEnabled(true);
                            DeleteCityjButton.setEnabled(true);
                            colonia = new Hormiga[AntsNum];
                            
                            //Se asiganan los valores de los inputs en variables
                            AntsNum = Integer.parseInt(AntsNumInput.getText());
                            Iterations = Integer.parseInt(IterationsInput.getText());
                            //Valores predeterminados de estas variables 
                            βValue = 2;
                            αValue = 1;
                            ρValue = 0.5;
                        }
                    }
                    else{
                    
                        JOptionPane.showMessageDialog(null, "Valores inválidos! No puedes tener ni 0 hormigas ni 0 iteraciones");
                    }
            }
        }
        else {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de continuar");
        }
    }//GEN-LAST:event_GameOptionsValidationButtonActionPerformed

    
    private void AddCityjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCityjButtonActionPerformed
        
        CityNameValidationButton.setEnabled(true);
        
        if (cityCounter == 0){
        
            //volver a inicializar los botones y mostrar la pantalla de nuevo juego
            DeleteCityjPanel.setVisible(false);
            NewCityjPanel.setVisible(true);            
            CityNameInput.setEditable(true);            
            ConfirmNewCityjButton.setEnabled(true);
            CityNamejLabel1.setText("Nombre de la ciudad nº " + (cityCounter+1));

            //Vaciar el campo de NameInput
            CityNameInput.setText("");
            AddCityjButton.setEnabled(false); //colocar el boton deshabilitado hasta no completar el proceso de agregar la nueva ciudad
        }
        else {
        
            //volver a inicializar los botones y mostrar la pantalla de nuevo juego
            DeleteCityjPanel.setVisible(false);
            NewCityjPanel.setVisible(true);            
            CityNameInput.setEditable(true);            
            ConfirmNewCityjButton.setEnabled(true);
            CityNamejLabel1.setText("Nombre de la ciudad nº " + (cityCounter+1));

            //Vaciar los campos de inputs
            CityNameInput.setText("");  
            AddCityjButton.setEnabled(false);
        }
    }//GEN-LAST:event_AddCityjButtonActionPerformed

    private void DeleteCityjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCityjButtonActionPerformed

        AddCityjButton.setEnabled(true);
        NewCityjPanel.setVisible(false);
        DeleteCityjPanel.setVisible(true);
        Cities1.removeAll();        
        Cities1.setLayout(new GridLayout(4,5,8,8));
        drawButtonCities (Cities_);

        

    }//GEN-LAST:event_DeleteCityjButtonActionPerformed

    private void DefaultValuesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultValuesButtonActionPerformed

        CustomValuesButton.setSelected(false);
        βValueInput.setEditable(false);
        αValueInput.setEditable(false);
        ρValueInput.setEditable(false);
        βValueInput.setText("");
        αValueInput.setText("");
        ρValueInput.setText("");
    }//GEN-LAST:event_DefaultValuesButtonActionPerformed

    private void CustomValuesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomValuesButtonActionPerformed

        βValueInput.setEditable(true);
        αValueInput.setEditable(true);
        ρValueInput.setEditable(true);
        DefaultValuesButton.setSelected(false);
    }//GEN-LAST:event_CustomValuesButtonActionPerformed

    private void AntsNumInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntsNumInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AntsNumInputActionPerformed

    double[] arrayDistances = new double[20];
    
    private void ConfirmNewCityjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmNewCityjButtonActionPerformed
                
        if (CityNameInput.isEditable()) {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de continuar");
        }
        else{
            
            cityCounter++;
            CityId++;
            listaDeCiudades.agregarAlFinal(CityNameInput.getText(), cityCounter);
            ConfirmNewCityjButton.setEnabled(false);

             // Aca se debe añadir la nueva ciudad al Arreglo ( Array ) 
             for (int i = 0; i < arrayDistances.length; i++) {
                arrayDistances[i] = 0;
            }
            Cities_[PosAvailable(Cities_)] = new Cities_( cityName , CityId);
            
            //Se llena la diagonal de 0s
            //this.distanceMatrix.setDistance(cityCounter - 1, cityCounter - 1, 0);
            
            //Se habilita de nuev el botón de agregar ciudad
            AddCityjButton.setEnabled(true);
        }
        
        if (cityCounter == 20){

            AddCityjButton.setEnabled(false);
        }
             
    }//GEN-LAST:event_ConfirmNewCityjButtonActionPerformed

    public int PosAvailable (Cities_[] cities) {
    
        int aux = 0;
        
        for (int i = 0; i < cities.length; i++){
        
            if (cities[i]==null){
                aux = i;  
                break;
            }
        }
        return aux; 
    }
    private void CityNameValidationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityNameValidationButtonActionPerformed
             
                
        if (!CityNameInput.getText().equals("")) {

            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas confirmar ese nombre para tu ciudad? ",
                    "Nombre de la ciudad", YES_NO_OPTION) == 0) {

                CityNameInput.setEditable(false);  
                CityNameValidationButton.setEnabled(false);
                cityName = CityNameInput.getText();
                
                // Se asignan las distancias de la ciudad respecto a cada una de las ciudades existentes
                if (cityCounter != 0){
                    int cityLeft = CityId;
                                        
                    do {
                        
                        if (Cities_[CityId-cityLeft] != null) {
                        
                            String cityDistanceString = JOptionPane.showInputDialog("Distancia de " + cityName + " respecto a " 
                                + Cities_[CityId-cityLeft].name + "\n SOLO VALORES NUMERICOS");
                            
                            if (cityDistanceString.isEmpty()){

                                JOptionPane.showMessageDialog(null, "Campo vacío. Introduzca un valor antes de continuar");
                            }
                            else if (cityDistanceString == null) {

                            }
                            else if (cityDistanceString != null || !cityDistanceString.equals("0")) {
                                //int col = cityCounter;
                                //int row = cityCounter - cityLeft;                            
                                cityDistance = Double.parseDouble(cityDistanceString); //se asigna la distancia (Double) a la variable
                                //this.distanceMatrix.setDistance( row , col , cityDistance);
                                arrayDistances[cityCounter-cityLeft] = cityDistance;
                            
                                cityLeft--;
                            }
                            else if (Double.parseDouble(cityDistanceString) <= 0) {

                                JOptionPane.showMessageDialog(null, "Distancia inválida. Ingresa un número mayor que 0");
                            }
                        }
                        else {
                            cityLeft--;
                        }
                    }while (cityLeft>0);
                }else{
                    
                    //this.distanceMatrix.setDistance(0, 0, 0);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vacío. Introduzca un valor antes de continuar");
            
        }
        
        
    }//GEN-LAST:event_CityNameValidationButtonActionPerformed

    private void CityNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityNameInputActionPerformed

    }//GEN-LAST:event_CityNameInputActionPerformed

    private void DrawCitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawCitiesButtonActionPerformed
        
        AntsTravelInfojLabel.setVisible(true);
        ShowTravelsButton.setVisible(true);
        
        drawCitiesPanel();
        drawAnts();
        drawCities();
               
//        drawTest();
    }//GEN-LAST:event_DrawCitiesButtonActionPerformed

    private void ShowTravelsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowTravelsButtonActionPerformed
        
        printResults (AntsNum, Iterations);
        
    }//GEN-LAST:event_ShowTravelsButtonActionPerformed

    private void printResults (int ants, int iterations){
        
        CreateLabelDynamically2 c2 = new CreateLabelDynamically2(ants, iterations);
        c2.setTitle("Resultados finales de la partida ");
        c2.setSize(700,700);
        c2.setVisible(true);
    }
    
    private void SavejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavejButtonActionPerformed
    
        if (!archivo.exists()) {
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            
        }
        }

       
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("ciudades");
                    bw.newLine();
                    NodoVertice nodoVerticeAuxiliar = listaDeCiudades.pFirst;
                    for (int i = 0; i < listaDeCiudades.nNodos; i++) {
                        bw.write( nodoVerticeAuxiliar.etiqueta+ "," + nodoVerticeAuxiliar.id);
                        bw.newLine();
                        nodoVerticeAuxiliar = nodoVerticeAuxiliar.pNext;
                    }
                    bw.write("fin_ciudades");
                    bw.newLine();
                    nodoVerticeAuxiliar = listaDeCiudades.pFirst;
                    for (int i = 0; i < listaDeCiudades.nNodos; i++) {
                        NodoArista nodoAristaAuxiliar = nodoVerticeAuxiliar.nodosAristasAdyacentes.pFirst;
                        for (int j = 0; j < 10; j++) {
                            bw.write( nodoAristaAuxiliar.distancia+ "," + nodoAristaAuxiliar.feromonas + "," + nodoAristaAuxiliar.id + "," + nodoAristaAuxiliar.etiqueta);
                            bw.newLine(); 
                        }
                            
                    }
                    bw.write("fin_caminos");
                    bw.newLine();
                    bw.write(αValue);
                    bw.newLine();
                    bw.write("fin_alpha");
                    bw.newLine();
                    bw.write(βValue);
                    bw.newLine();
                    bw.write("fin_beta");
                    bw.newLine();
                    bw.write(String.valueOf(ρValue));
                    bw.newLine();
                    bw.write(AntsNum);
                    bw.newLine();
                    bw.write(Iterations);

                    bw.close();
                } catch (IOException ex) {
                }
        
        
    }//GEN-LAST:event_SavejButtonActionPerformed

    private void drawButtonCities (Cities_[] cities) {
         
        //Creación de los botones de ciudades
        for (int i=0; i < cities.length; i++) {
            if ( cities[i] != null ) {
                
                final int index =  i;
                final String cityName = cities[i].name;
               // deleteCity = false;
                JButton button = new JButton(cityName);
                
                //Características de los botones 
                button.setBackground(new java.awt.Color(164, 225, 3));
                button.setMinimumSize(new Dimension(100, 50));
                button.setPreferredSize(new Dimension(100, 50));
                button.setFont(new java.awt.Font("Arial", 0, 14)); 
                button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 168, 2), 2, true));
                
                //Funciones de los botones creados
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        deleteCity(button, cities, index);
                    }
                });
                               
                Cities1.add(button);
            }
            
        }
    }
    
//    //Prueba 
    public void drawTest(){
        this.cityCounter = 13;
        Tests test = new Tests();
        for( int i = 0 ; i < test.getCiudades().length ; i++ ){
            
            Cities_[i] = new Cities_( test.getCiudades()[i] , i );
        }
        
//        drawFullPanel(Cities_, test.getCaminos(), 1);
    }
    
    //Eliminaar ciudad de la partida
    public void deleteCity (JButton button, Cities_[] cities, int pos){
    
        // método para eliminar la ciudad deben eliminarla de la lista 
        int aux = cityCounter;
        
        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta ciudad? ",
                "Eliminar ciudad", YES_NO_OPTION) == 0) {
            
            cityCounter -- ;
            button.setVisible(false);
            if (cityCounter < 20){
                AddCityjButton.setEnabled(true);
            }
            if( this.cityCounter < aux){                   
                cities[pos].delete = true; 
                cities[pos] = null;
             
                //distanceMatrix.delete(pos);
            }
        }
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
                
            }
        });
        
    }
    
    public NodoVertice escogerCiudadDeHormiga(){
        int n = cityCounter;
        int m =(int) (Math.random()*n)+1;
        NodoVertice nodo = null;
        for (int i = 0; i < m; i++) {
            if(i==0){
                nodo = listaDeCiudades.pFirst;
            }else{
            nodo = nodo.pNext;
            }
        }
        return nodo;
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCityjButton;
    private javax.swing.JTextField AntsNumInput;
    private javax.swing.JLabel AntsNumjLabel;
    private javax.swing.JLabel AntsTravelInfojLabel;
    private javax.swing.JPanel Cities1;
    private javax.swing.JPanel CitiesjPanel;
    private javax.swing.JTextField CityNameInput;
    private javax.swing.JButton CityNameValidationButton;
    private javax.swing.JLabel CityNamejLabel1;
    private javax.swing.JButton ConfirmNewCityjButton;
    private javax.swing.JRadioButton CustomValuesButton;
    private javax.swing.JRadioButton DefaultValuesButton;
    private javax.swing.JButton DeleteCityjButton;
    private javax.swing.JPanel DeleteCityjPanel;
    private javax.swing.JButton DrawCitiesButton;
    private javax.swing.JButton ExitjButton;
    private javax.swing.JButton GameOptionsValidationButton;
    private javax.swing.JButton InstructionsjButton;
    private javax.swing.JTextField IterationsInput;
    private javax.swing.JLabel IterationsjLabel;
    private javax.swing.JButton LoadGamejButton;
    private javax.swing.JPanel NewCityjPanel;
    private javax.swing.JPanel NewGameOptionsjPanel;
    private javax.swing.JButton NewGamejButton;
    private javax.swing.JButton SavejButton;
    private javax.swing.JButton ShowTravelsButton;
    private javax.swing.JButton StartGamejButton;
    private javax.swing.JLabel VariablesValuesjLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JPanel jPanelInstruction;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNewGame;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private proyectobaladiinvernonpizzurro.Tests tests1;
    private javax.swing.JTextField αValueInput;
    private javax.swing.JLabel αVariableValuejLabel;
    private javax.swing.JTextField βValueInput;
    private javax.swing.JLabel βVariableValuejLabel;
    private javax.swing.JTextField ρValueInput;
    private javax.swing.JLabel ρVariableValuejLabel;
    // End of variables declaration//GEN-END:variables
}
