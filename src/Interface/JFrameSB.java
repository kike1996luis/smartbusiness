package Interface;

import Animaciones.moveLeft;
import Animaciones.moveRight;
import Code.Cell;
import Code.CopyFileStream;
import Graphics.KamabokoBorder;
import ComandosSQL.sql.Usuario;
import Code.ModificacionBD;
import Code.TableCellListener;
import ComandosSQL.sql.Producto;
import Graphics.RoundedBorder;
import Graphics.ImageLoad;
import Graphics.RenderCelda;
import Graphics.ThumbNailView;
import Graphics.TextBubbleBorder;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import com.seaglasslookandfeel.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.AbstractBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import rojerusan.RSNotifyFade;
import rojerusan.RSNotifyFade.PositionNotify;
import rojerusan.RSNotifyFade.TypeNotify;

public class JFrameSB extends javax.swing.JFrame {

    ModificacionBD BaseDeDatos;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    boolean rememberSelected = true;
    Stack<Cell> history = new Stack<>();
    Stack<Cell> reundo = new Stack<>();
    Object[] rowAux;
    TableCellListener tbclistener;
    Action action;
    String prevValue;
    int prevCol = 0;
    int LastRow = 0;
    File fileimg = null;
    RenderCelda TableCellRenderer = new RenderCelda();
    boolean modifyProduct = false;
    Object[] editCell = new Object[8];
    boolean uploadImgFlag = false;
    
    public JFrameSB() {

        BaseDeDatos = new ModificacionBD();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
        createMainPanel();
        createRunPanel();
        createInventoryPanel();
        decideFirstPanelToShow();
        fixFrame();
        fixComponents();
    }

    private void fixFrame() {   //Fix the position and bounds of the internal components of the frame

        setLocationRelativeTo(null);
    }

    private void createMainPanel() {    // Create the panels to the main CardLayout

        mainPanel.add(registerPanel, "registerPanel");
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(runPanel, "runPanel");

    }

    private void createInventoryPanel() {

        jPanel6.add(listedInventoryPanel, "listedInventoryPanel");
        jPanel6.add(cuadInventoryPanel, "cuadInventoryPanel");
        CardLayout cl = (CardLayout) (jPanel6.getLayout());
        cl.show(jPanel6, "listedInventoryPanel");
        refreshListInventory();

    }

    private void fixComponents() {

        if (!BaseDeDatos.UserHaveRemember()) {
            rememberSelected = false;
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png")));
        }
        jPasswordField1.setVisible(true);
        passwordLogin.setVisible(false);
        //fd.setFile("*.jpg;*.jpeg;*.png");
    }

    private void createRunPanel() {

        jPanelCard.add(homePanel, "homePanel");
        jPanelCard.add(inventoryPanel, "inventoryPanel");
        jPanelCard.add(addProduct, "addProduct");
    }

    private void decideFirstPanelToShow() { // Decide which window has to show first

        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        if (BaseDeDatos.UsersEmpty()) {
            cl.show(mainPanel, "registerPanel");
        } else {
            if (BaseDeDatos.UserHaveRemember()) {
                cl.show(mainPanel, "runPanel");
            } else {
                cl.show(mainPanel, "loginPanel");
            }
        }
    }

    private void showPanel(String panel) {

        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        if (panel.equals("runPanel")) {
            cl.show(mainPanel, "runPanel");
        }
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     *
     * WARNING: Do NOT modify this code. The content of this method is always
     *
     * regenerated by the Form Editor.
     *
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nombreField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        cedulaField = new javax.swing.JTextField();
        telefonoField = new javax.swing.JTextField();
        apellidoField = new javax.swing.JTextField();
        adviceLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        repeat_passwordField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        signupField = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        emailLogin = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();
        errorLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        runPanel = new javax.swing.JPanel();
        jPanelCard = new javax.swing.JPanel();
        panel_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(24, 24);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded panel with borders.
                graphics.setColor(getForeground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
                //BORDER
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
            }};
            jPanel11 = new javax.swing.JPanel();
            jPanel12 = new javax.swing.JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Dimension arcs = new Dimension(24, 24);
                    int width = getWidth();
                    int height = getHeight();
                    Graphics2D graphics = (Graphics2D) g;
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    //Draws the rounded panel with borders.
                    graphics.setColor(getForeground());
                    graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
                    //BORDER
                    graphics.setColor(getForeground());
                    graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
                }};
                jPanel13 = new javax.swing.JPanel(){
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Dimension arcs = new Dimension(24, 24);
                        int width = getWidth();
                        int height = getHeight();
                        Graphics2D graphics = (Graphics2D) g;
                        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        //Draws the rounded panel with borders.
                        graphics.setColor(getForeground());
                        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
                        //BORDER
                        graphics.setColor(getForeground());
                        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
                    }};
                    jLabel18 = new javax.swing.JLabel();
                    listedInventoryPanel = new javax.swing.JPanel();
                    jScrollPane2 = new javax.swing.JScrollPane();
                    jTable1 = new javax.swing.JTable();
                    inventoryPanel = new javax.swing.JPanel();
                    jPanel4 = new javax.swing.JPanel(){
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Dimension arcs = new Dimension(24, 24);
                            int width = getWidth();
                            int height = getHeight();
                            Graphics2D graphics = (Graphics2D) g;
                            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                            //Draws the rounded panel with borders.
                            graphics.setColor(getForeground());
                            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
                            //BORDER
                            graphics.setColor(getForeground());
                            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
                        }};
                        jLabel14 = new javax.swing.JLabel();
                        jButton3 = new javax.swing.JButton();
                        jComboBox1 = new javax.swing.JComboBox<>();
                        jPanel6 = new javax.swing.JPanel();
                        jTextField7 = new javax.swing.JTextField();
                        jLabel16 = new javax.swing.JLabel();
                        jLabel19 = new javax.swing.JLabel();
                        jLabel20 = new javax.swing.JLabel();
                        jLabel21 = new javax.swing.JLabel();
                        jLabel22 = new javax.swing.JLabel();
                        jLabel43 = new javax.swing.JLabel();
                        jLabel49 = new javax.swing.JLabel();
                        addProduct = new javax.swing.JPanel();
                        jPanel9 = new javax.swing.JPanel();
                        jTextField1 = new javax.swing.JTextField();
                        uploadImg = new javax.swing.JLabel();
                        jLabel55 = new javax.swing.JLabel();
                        jLabel56 = new javax.swing.JLabel();
                        jLabel45 = new javax.swing.JLabel();
                        jTextField2 = new javax.swing.JTextField();
                        jTextField3 = new javax.swing.JTextField();
                        jTextField4 = new javax.swing.JTextField();
                        jTextField5 = new javax.swing.JTextField();
                        jSpinner5 = new javax.swing.JSpinner();
                        jButton6 = new javax.swing.JButton();
                        jSpinner1 = new javax.swing.JSpinner();
                        jLabel17 = new javax.swing.JLabel();
                        jLabel42 = new javax.swing.JLabel();
                        jLabel44 = new javax.swing.JLabel();
                        jLabel46 = new javax.swing.JLabel();
                        jLabel48 = new javax.swing.JLabel();
                        jLabel52 = new javax.swing.JLabel();
                        jLabel54 = new javax.swing.JLabel();
                        jLabel23 = new javax.swing.JLabel();
                        jLabel57 = new javax.swing.JLabel();
                        jLabel58 = new javax.swing.JLabel();
                        jLabel59 = new javax.swing.JLabel();
                        jLabel47 = new javax.swing.JLabel();
                        jLabel61 = new javax.swing.JLabel();
                        jLabel60 = new javax.swing.JLabel();
                        jLabel50 = new javax.swing.JLabel();
                        jLabel62 = new javax.swing.JLabel();
                        jLabel63 = new javax.swing.JLabel();
                        jLabel64 = new javax.swing.JLabel();
                        jLabel65 = new javax.swing.JLabel();
                        jLabel66 = new javax.swing.JLabel();
                        jLabel67 = new javax.swing.JLabel();
                        jLabel68 = new javax.swing.JLabel();
                        jLabel69 = new javax.swing.JLabel();
                        jLabel70 = new javax.swing.JLabel();
                        cuadInventoryPanel = new javax.swing.JPanel();
                        mainPanel = new javax.swing.JPanel();

                        registerPanel.setBackground(new java.awt.Color(89, 186, 235));
                        registerPanel.setForeground(new java.awt.Color(89, 186, 235));
                        registerPanel.setToolTipText("");
                        registerPanel.setLayout(new java.awt.GridBagLayout());

                        jPanel8.setBackground(new java.awt.Color(89, 186, 235));
                        jPanel8.setForeground(new java.awt.Color(89, 186, 235));
                        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                        nombreField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        nombreField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        nombreField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        nombreField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nombreFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(nombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, -1));

                        passwordField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        passwordField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                passwordFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 358, -1));

                        emailField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        emailField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        emailField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                emailFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 360, -1));

                        cedulaField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        cedulaField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        cedulaField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        cedulaField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cedulaFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(cedulaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 360, -1));

                        telefonoField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        telefonoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        telefonoField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        telefonoField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                telefonoFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(telefonoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 360, -1));

                        apellidoField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        apellidoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        apellidoField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        apellidoField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                apellidoFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(apellidoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 150, -1));

                        adviceLabel.setForeground(new java.awt.Color(255, 0, 0));
                        adviceLabel.setText("                                                                                         ");
                        jPanel8.add(adviceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, -1, -1));

                        jButton1.setText("Ver usuarios");
                        jButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                            }
                        });
                        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

                        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textlg.png"))); // NOI18N
                        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 380, 60));

                        repeat_passwordField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                        repeat_passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        repeat_passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        repeat_passwordField.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                repeat_passwordFieldActionPerformed(evt);
                            }
                        });
                        jPanel8.add(repeat_passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 358, -1));

                        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dni.png"))); // NOI18N
                        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 250, -1));

                        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/first_name.png"))); // NOI18N
                        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 178, -1));

                        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/last_name.png"))); // NOI18N
                        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 178, -1));

                        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/phone.png"))); // NOI18N
                        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 230, -1));

                        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/email.png"))); // NOI18N
                        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 230, -1));

                        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password.png"))); // NOI18N
                        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 230, -1));

                        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/repeat_password.png"))); // NOI18N
                        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 230, -1));

                        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jLabel33.setText("Iniciar Sesión");
                        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel33MouseReleased(evt);
                            }
                        });
                        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 770, -1, -1));

                        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jLabel34.setText("¿Olvidaste tu contraseña?");
                        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 750, -1, 20));

                        jSeparator3.setBackground(new java.awt.Color(42, 128, 187));
                        jSeparator3.setForeground(new java.awt.Color(89, 186, 235));
                        jSeparator3.setEnabled(false);
                        jSeparator3.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jSeparator3.setOpaque(true);
                        jPanel8.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 740, 260, 2));

                        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/asd.png"))); // NOI18N
                        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

                        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 180, 60));

                        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 180, 60));

                        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textlg.png"))); // NOI18N
                        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 380, 60));

                        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textlg.png"))); // NOI18N
                        jPanel8.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 380, 60));

                        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textlg.png"))); // NOI18N
                        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 380, 60));

                        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textlg.png"))); // NOI18N
                        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 380, 60));

                        signupField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signupButton.png"))); // NOI18N
                        signupField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        signupField.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseEntered(java.awt.event.MouseEvent evt) {
                                signupFieldMouseEntered(evt);
                            }
                            public void mouseExited(java.awt.event.MouseEvent evt) {
                                signupFieldMouseExited(evt);
                            }
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                signupFieldMouseReleased(evt);
                            }
                        });
                        jPanel8.add(signupField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, -1, 50));

                        registerPanel.add(jPanel8, new java.awt.GridBagConstraints());

                        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Nombre", "Apellido", "Email", "Cédula", "Teléfono"
                            }
                        ) {
                            boolean[] canEdit = new boolean [] {
                                false, false, false, false, false
                            };

                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                            }
                        });
                        jScrollPane1.setViewportView(tablaUsuarios);
                        if (tablaUsuarios.getColumnModel().getColumnCount() > 0) {
                            tablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
                            tablaUsuarios.getColumnModel().getColumn(2).setResizable(false);
                            tablaUsuarios.getColumnModel().getColumn(3).setResizable(false);
                        }

                        jButton2.setText("Volver");
                        jButton2.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                            }
                        });

                        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
                        jDialog1.getContentPane().setLayout(jDialog1Layout);
                        jDialog1Layout.setHorizontalGroup(
                            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialog1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDialog1Layout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(jButton2)))
                                .addContainerGap(77, Short.MAX_VALUE))
                        );
                        jDialog1Layout.setVerticalGroup(
                            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addContainerGap(48, Short.MAX_VALUE))
                        );

                        loginPanel.setBackground(new java.awt.Color(89, 186, 235));
                        loginPanel.setForeground(new java.awt.Color(89, 186, 235));
                        loginPanel.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                loginPanelKeyPressed(evt);
                            }
                            public void keyReleased(java.awt.event.KeyEvent evt) {
                                loginPanelKeyReleased(evt);
                            }
                        });
                        loginPanel.setLayout(new java.awt.GridBagLayout());

                        jPanel3.setBackground(new java.awt.Color(89, 186, 235));
                        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyReleased(java.awt.event.KeyEvent evt) {
                                jPanel3KeyReleased(evt);
                            }
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                jPanel3KeyTyped(evt);
                            }
                        });
                        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        jPasswordField1.setBorder(null);
                        jPasswordField1.setNextFocusableComponent(jLabel8);
                        jPanel3.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 240, 30));

                        emailLogin.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
                        emailLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        emailLogin.setToolTipText(""); // NOI18N
                        emailLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        emailLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                        emailLogin.setDoubleBuffered(true);
                        emailLogin.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                emailLoginMouseReleased(evt);
                            }
                        });
                        jPanel3.add(emailLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, 30));

                        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/asd.png"))); // NOI18N
                        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 120));

                        errorLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
                        errorLogin.setForeground(new java.awt.Color(255, 0, 0));
                        errorLogin.setText("   ");
                        jPanel3.add(errorLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 180, 20));

                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loginButton.png"))); // NOI18N
                        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseEntered(java.awt.event.MouseEvent evt) {
                                jLabel3MouseEntered(evt);
                            }
                            public void mouseExited(java.awt.event.MouseEvent evt) {
                                jLabel3MouseExited(evt);
                            }
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel3MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 50));

                        passwordLogin.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
                        passwordLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        passwordLogin.setToolTipText("");
                        passwordLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                        passwordLogin.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                passwordLoginMouseReleased(evt);
                            }
                        });
                        passwordLogin.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                passwordLoginActionPerformed(evt);
                            }
                        });
                        jPanel3.add(passwordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 240, 30));

                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password.png"))); // NOI18N
                        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel4MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/email.png"))); // NOI18N
                        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel5MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

                        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/text.png"))); // NOI18N
                        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

                        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/text.png"))); // NOI18N
                        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 50));

                        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
                        jLabel8.setText("¿Mostrar Contraseña?");
                        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel8.setNextFocusableComponent(jLabel3);
                        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel8MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 130, 20));

                        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
                        jLabel1.setText("Recordar usuario");
                        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel1MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, 20));

                        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jLabel10.setText("¿Olvidaste tu contraseña?");
                        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 20));

                        jSeparator2.setBackground(new java.awt.Color(42, 128, 187));
                        jSeparator2.setForeground(new java.awt.Color(89, 186, 235));
                        jSeparator2.setEnabled(false);
                        jSeparator2.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jSeparator2.setOpaque(true);
                        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 260, -1));

                        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 1, 11)); // NOI18N
                        jLabel32.setText("Registrar usuario");
                        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel32MouseReleased(evt);
                            }
                        });
                        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

                        loginPanel.add(jPanel3, new java.awt.GridBagConstraints());

                        runPanel.setBackground(new java.awt.Color(255, 255, 255));
                        runPanel.setLayout(new java.awt.BorderLayout());

                        jPanelCard.setBackground(new java.awt.Color(255, 255, 255));
                        jPanelCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
                        jPanelCard.setLayout(new java.awt.CardLayout());
                        runPanel.add(jPanelCard, java.awt.BorderLayout.CENTER);

                        panel_menu.setPreferredSize(new java.awt.Dimension(180, 110));
                        panel_menu.setLayout(new java.awt.BorderLayout());

                        jPanel1.setBackground(new java.awt.Color(89, 186, 235));
                        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventario.png"))); // NOI18N
                        jLabel9.setText("  ");
                        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel9MouseReleased(evt);
                            }
                        });
                        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 160, 50));

                        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banner.png"))); // NOI18N
                        jLabel11.setText("  ");
                        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

                        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/separator.png"))); // NOI18N
                        jLabel12.setText("  ");
                        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, -1));

                        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inicio.png"))); // NOI18N
                        jLabel13.setText("  ");
                        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel13MouseReleased(evt);
                            }
                        });
                        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 160, 50));

                        panel_menu.add(jPanel1, java.awt.BorderLayout.WEST);

                        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/bajar.png"))); // NOI18N
                        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                        jLabel2.setFocusable(false);
                        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
                        jLabel2.setOpaque(true);
                        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseReleased(java.awt.event.MouseEvent evt) {
                                jLabel2MouseReleased(evt);
                            }
                        });
                        panel_menu.add(jLabel2, java.awt.BorderLayout.NORTH);

                        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                        jPanel2.setPreferredSize(new java.awt.Dimension(60, 95));
                        jPanel2.setLayout(new java.awt.BorderLayout());
                        panel_menu.add(jPanel2, java.awt.BorderLayout.CENTER);

                        runPanel.add(panel_menu, java.awt.BorderLayout.WEST);

                        homePanel.setBackground(new java.awt.Color(255, 255, 255));

                        jLabel15.setText("home");

                        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
                        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                        jPanel7.setForeground(new java.awt.Color(255, 51, 51));
                        AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,16,16,false);
                        jPanel7.setBorder(brdrLeft);

                        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                        jPanel7.setLayout(jPanel7Layout);
                        jPanel7Layout.setHorizontalGroup(
                            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
                        );
                        jPanel7Layout.setVerticalGroup(
                            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
                        );

                        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
                        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

                        jPanel12.setBackground(new java.awt.Color(102, 102, 255));
                        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
                        jPanel12.setForeground(new java.awt.Color(102, 102, 255));

                        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                        jPanel12.setLayout(jPanel12Layout);
                        jPanel12Layout.setHorizontalGroup(
                            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 308, Short.MAX_VALUE)
                        );
                        jPanel12Layout.setVerticalGroup(
                            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 125, Short.MAX_VALUE)
                        );

                        jPanel13.setBackground(new java.awt.Color(238, 116, 92));
                        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
                        jPanel13.setForeground(new java.awt.Color(238, 116, 92));

                        // Code of sub-components - not shown here

                        // Layout setup code - not shown here

                        // Code adding the component to the parent container - not shown here
                        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventorylist.png"))); // NOI18N

                        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
                        jPanel13.setLayout(jPanel13Layout);
                        jPanel13Layout.setHorizontalGroup(
                            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        jPanel13Layout.setVerticalGroup(
                            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );

                        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                        jPanel11.setLayout(jPanel11Layout);
                        jPanel11Layout.setHorizontalGroup(
                            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(299, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                    .addContainerGap(340, Short.MAX_VALUE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))
                        );
                        jPanel11Layout.setVerticalGroup(
                            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap()))
                        );

                        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
                        homePanel.setLayout(homePanelLayout);
                        homePanelLayout.setHorizontalGroup(
                            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addContainerGap(503, Short.MAX_VALUE))
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        );
                        homePanelLayout.setVerticalGroup(
                            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15)
                                .addGap(31, 31, 31)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(75, Short.MAX_VALUE))
                        );

                        listedInventoryPanel.setPreferredSize(new java.awt.Dimension(773, 361));
                        listedInventoryPanel.setLayout(new java.awt.BorderLayout());

                        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Nombre", "Descripción", "Código", "Cantidad", "Costo", "Precio Definitivo", "Imagen"
                            }
                        ) {
                            Class[] types = new Class [] {
                                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
                            };
                            boolean[] canEdit = new boolean [] {
                                true, true, true, true, true, true, false
                            };

                            public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                            }

                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                            }
                        });
                        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
                        jScrollPane2.setViewportView(jTable1);
                        /*jTable1.setAutoCreateRowSorter(true);
                        jTable1.putClientProperty("terminateEditOnFocusLost", true);
                        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                            public void valueChanged(ListSelectionEvent event) {
                                if(!event.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                                    cellSelectedEventHandler(event, "row");
                                }
                            }
                        });
                        jTable1.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                            public void valueChanged(ListSelectionEvent event) {
                                if(!event.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                                    cellSelectedEventHandler(event, "column");
                                }
                            }
                        });*/
                        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
                        //cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
                            public void valueChanged(ListSelectionEvent e) {
                                cellSelectedEvent(e);
                            }
                        });

                        jTable1.getModel().addTableModelListener(new TableModelListener()
                            {
                                public void tableChanged(TableModelEvent evt)
                                {
                                    tableChangedEventHandler(evt);
                                }
                            });

                            action = new AbstractAction()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    TableCellUpdated((TableCellListener)e.getSource());
                                }
                            };
                            tbclistener = new TableCellListener(jTable1, action);

                            listedInventoryPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

                            inventoryPanel.setBackground(new java.awt.Color(255, 255, 255));

                            jPanel4.setBackground(new java.awt.Color(234, 236, 244));
                            jPanel4.setForeground(new java.awt.Color(234, 236, 244));
                            jPanel4.setBackground(new java.awt.Color(255, 255, 255));

                            jLabel14.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
                            jLabel14.setText("SmartBusiness/Página de inventario");

                            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                            jPanel4.setLayout(jPanel4Layout);
                            jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
                            );

                            jButton3.setText("añadir producto");
                            jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jButton3MouseReleased(evt);
                                }
                            });
                            jButton3.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton3ActionPerformed(evt);
                                }
                            });

                            jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modo listado", "Modo cuadriculado" }));
                            jComboBox1.setBorder(new KamabokoBorder());
                            jComboBox1.setBackground(Color.white);
                            jComboBox1.addItemListener(new java.awt.event.ItemListener() {
                                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                    jComboBox1ItemStateChanged(evt);
                                }
                            });

                            jPanel6.setLayout(new java.awt.CardLayout());

                            jTextField7.setText("Buscar...");
                            jTextField7.addFocusListener(new FocusListener() {

                                @Override
                                public void focusGained(FocusEvent e) {
                                    jTextField7.setText("");
                                }

                                @Override
                                public void focusLost(FocusEvent e) {
                                    //jTextField7.setText("Buscar...");
                                }
                            });

                            jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
                            jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel16MouseReleased(evt);
                                }
                            });

                            jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/erase.png"))); // NOI18N
                            jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel19MouseReleased(evt);
                                }
                            });

                            jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
                            jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel20MouseReleased(evt);
                                }
                            });

                            jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redoe.png"))); // NOI18N
                            jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                            jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel21MouseReleased(evt);
                                }
                            });

                            jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reundode.png"))); // NOI18N
                            jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                            jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel22MouseReleased(evt);
                                }
                            });

                            jLabel43.setText("Actualizar tabla");
                            jLabel43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel43MouseReleased(evt);
                                }
                            });

                            jLabel49.setText("ver detalles");
                            jLabel49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel49.setEnabled(false);
                            jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel49MouseReleased(evt);
                                }
                            });

                            javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
                            inventoryPanel.setLayout(inventoryPanelLayout);
                            inventoryPanelLayout.setHorizontalGroup(
                                inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inventoryPanelLayout.createSequentialGroup()
                                    .addGap(331, 331, 331)
                                    .addComponent(jButton3)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(inventoryPanelLayout.createSequentialGroup()
                                    .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(inventoryPanelLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(inventoryPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(inventoryPanelLayout.createSequentialGroup()
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel22)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel21)
                                                    .addGap(89, 89, 89)
                                                    .addComponent(jLabel49)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(jLabel43)
                                                    .addGap(111, 111, 111)
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel20)))))
                                    .addContainerGap())
                            );
                            inventoryPanelLayout.setVerticalGroup(
                                inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inventoryPanelLayout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21))
                                        .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel49)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3))
                            );

                            addProduct.setBackground(new java.awt.Color(255, 255, 255));
                            addProduct.setLayout(new java.awt.GridBagLayout());

                            jPanel9.setBackground(new java.awt.Color(255, 255, 255));
                            jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                            jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                            jTextField1.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jTextField1ActionPerformed(evt);
                                }
                            });
                            jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 400, -1));

                            uploadImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                            jPanel9.add(uploadImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 320));
                            uploadImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noimage.png"))); // NOI18N

                            jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 150, 60));

                            jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 170, 60));

                            jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 180, 60));

                            jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            jTextField2.setText(" ");
                            jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                            jTextField2.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jTextField2ActionPerformed(evt);
                                }
                            });
                            jPanel9.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 400, -1));

                            jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                            jPanel9.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 380, 20));

                            jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                            jPanel9.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 400, -1));

                            jTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                            jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                            jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 400, -1));

                            jSpinner5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
                            jSpinner5.setBorder(null);
                            jPanel9.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 136, 410, 26));

                            jButton6.setText("generar codigo");
                            jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jButton6MouseReleased(evt);
                                }
                            });
                            jPanel9.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, -1, -1));

                            jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                            jSpinner1.setModel(new javax.swing.SpinnerNumberModel(3, 3, 9, 1));
                            jSpinner1.setBorder(null);
                            jPanel9.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 306, 30, 26));

                            jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload_img.png"))); // NOI18N
                            jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                            jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseEntered(java.awt.event.MouseEvent evt) {
                                    jLabel17MouseEntered(evt);
                                }
                                public void mouseExited(java.awt.event.MouseEvent evt) {
                                    jLabel17MouseExited(evt);
                                }
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel17MouseReleased(evt);
                                }
                            });
                            jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, 48));

                            jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cost.png"))); // NOI18N
                            jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 200, 20));

                            jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button.png"))); // NOI18N
                            jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                            jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseEntered(java.awt.event.MouseEvent evt) {
                                    jLabel44MouseEntered(evt);
                                }
                                public void mouseExited(java.awt.event.MouseEvent evt) {
                                    jLabel44MouseExited(evt);
                                }
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel44MouseReleased(evt);
                                }
                            });
                            jPanel9.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 180, 40));

                            jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/description.png"))); // NOI18N
                            jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 200, 20));

                            jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/price.png"))); // NOI18N
                            jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 200, 20));

                            jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quantity.png"))); // NOI18N
                            jPanel9.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 180, 20));

                            jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/name.png"))); // NOI18N
                            jPanel9.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 180, 20));

                            jLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
                            jLabel23.setText("Volver atrás");
                            jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                            jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseReleased(java.awt.event.MouseEvent evt) {
                                    jLabel23MouseReleased(evt);
                                }
                            });
                            jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, 110, 40));

                            jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 150, 60));

                            jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 170, 60));

                            jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 180, 60));

                            jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bs.png"))); // NOI18N
                            jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

                            jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, 60));

                            jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 170, 60));

                            jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 180, 60));

                            jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 150, 60));

                            jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 170, 60));

                            jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 180, 60));

                            jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 150, 60));

                            jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 170, 60));

                            jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 180, 60));

                            jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 150, 60));

                            jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 170, 60));

                            jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/textsm.png"))); // NOI18N
                            jPanel9.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 180, 60));

                            addProduct.add(jPanel9, new java.awt.GridBagConstraints());

                            javax.swing.GroupLayout cuadInventoryPanelLayout = new javax.swing.GroupLayout(cuadInventoryPanel);
                            cuadInventoryPanel.setLayout(cuadInventoryPanelLayout);
                            cuadInventoryPanelLayout.setHorizontalGroup(
                                cuadInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 100, Short.MAX_VALUE)
                            );
                            cuadInventoryPanelLayout.setVerticalGroup(
                                cuadInventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 100, Short.MAX_VALUE)
                            );

                            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                            setSize(new java.awt.Dimension(1022, 684));
                            addWindowListener(new java.awt.event.WindowAdapter() {
                                public void windowClosed(java.awt.event.WindowEvent evt) {
                                    formWindowClosed(evt);
                                }
                            });
                            getContentPane().setLayout(new java.awt.GridLayout(1, 0));

                            mainPanel.setPreferredSize(new java.awt.Dimension(566, 465));
                            mainPanel.setLayout(new java.awt.CardLayout());
                            getContentPane().add(mainPanel);

                            pack();
                        }// </editor-fold>//GEN-END:initComponents


    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_nombreFieldActionPerformed


    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_passwordFieldActionPerformed


    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_emailFieldActionPerformed


    private void cedulaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_cedulaFieldActionPerformed


    private void telefonoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_telefonoFieldActionPerformed



    private void apellidoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoFieldActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_apellidoFieldActionPerformed


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        BaseDeDatos.closeConnection();
        jDialog1.dispose();
    }//GEN-LAST:event_formWindowClosed



    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    }//GEN-LAST:event_jButton2ActionPerformed


    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased

        int posicion = panel_menu.getX();
        if (posicion == -160) { // It´s open, must be closed
            moveRight anim = new moveRight(panel_menu.getX(), 0, 2, 8, panel_menu);
            anim.start();
            moveRight anim1 = new moveRight(jPanelCard.getX(), 180, 2, 8, jPanelCard);
            anim1.start();
        } else { // It´s closed, must be opened
            moveLeft anim = new moveLeft(panel_menu.getX(), -154, 2, 8, panel_menu);
            anim.start();
            moveLeft anim1 = new moveLeft(jPanelCard.getX(), 95, 2, 8, jPanelCard);
            anim1.start();
        }
    }//GEN-LAST:event_jLabel2MouseReleased


    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased

        String email = emailLogin.getText();
        String password;
        if (passwordLogin.isVisible()) {
            password = passwordLogin.getText();
        } else {
            password = String.valueOf(jPasswordField1.getPassword());
        }
        String result = BaseDeDatos.loginUser(email, password);
        if (result.equals("exito")) {
            errorLogin.setText("   ");
            BaseDeDatos.putRemember(rememberSelected);
            showPanel("runPanel");
        } else {
            errorLogin.setText(result);
        }
    }//GEN-LAST:event_jLabel3MouseReleased


    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loginButtonPressed.png")));
    }//GEN-LAST:event_jLabel3MouseEntered


    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loginButton.png")));
    }//GEN-LAST:event_jLabel3MouseExited


    private void passwordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLoginActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_passwordLoginActionPerformed


    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased


    }//GEN-LAST:event_jLabel4MouseReleased


    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased


    }//GEN-LAST:event_jLabel5MouseReleased


    private void emailLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailLoginMouseReleased

        //jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\HOME\\Documents\\NetBeansProjects\\SmartBusiness\\text.png"));
        //jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\HOME\\Documents\\NetBeansProjects\\SmartBusiness\\textSelected.png"));

    }//GEN-LAST:event_emailLoginMouseReleased


    private void passwordLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordLoginMouseReleased

        //jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\HOME\\Documents\\NetBeansProjects\\SmartBusiness\\text.png"));
        //jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\HOME\\Documents\\NetBeansProjects\\SmartBusiness\\textSelected.png"));

    }//GEN-LAST:event_passwordLoginMouseReleased


    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased

        if (passwordLogin.isVisible()) {
            
            jPasswordField1.setText(passwordLogin.getText());
            passwordLogin.setVisible(false);
            jPasswordField1.setVisible(true);
            jPasswordField1.requestFocus();
        } else {
            
            passwordLogin.setText(String.valueOf(jPasswordField1.getPassword()));
            passwordLogin.setVisible(true);
            jPasswordField1.setVisible(false);
            passwordLogin.requestFocus();
        }
    }//GEN-LAST:event_jLabel8MouseReleased


    private void loginPanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginPanelKeyReleased

    }//GEN-LAST:event_loginPanelKeyReleased


    private void loginPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginPanelKeyPressed

    }//GEN-LAST:event_loginPanelKeyPressed


    private void jPanel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyReleased

    }//GEN-LAST:event_jPanel3KeyReleased


    private void jPanel3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyTyped

    }//GEN-LAST:event_jPanel3KeyTyped


    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased

        if (rememberSelected == true) {
            rememberSelected = false;
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png")));
        } else {
            rememberSelected = true;
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkboxSelected.png")));
        }

    }//GEN-LAST:event_jLabel1MouseReleased


    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        refreshAddProduct();
        CardLayout cl = (CardLayout) (jPanelCard.getLayout());
        cl.show(jPanelCard, "inventoryPanel");
    }//GEN-LAST:event_jLabel9MouseReleased


    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
        refreshAddProduct();
        CardLayout cl = (CardLayout) (jPanelCard.getLayout());
        cl.show(jPanelCard, "homePanel");
    }//GEN-LAST:event_jLabel13MouseReleased



    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed




    private void whatToDo(Cell aux) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        switch (aux.getFunction()) {
            case "ADD":
                model.insertRow(aux.getRow(), aux.getColumn());
                break;
            case "DELETE":
                model.removeRow(aux.getRow());
                break;
            case "UPDATE":
                model.insertRow(aux.getRow(), aux.getColumn());
                model.removeRow(aux.getRow() + 1);
                break;
            default:
                break;
        }
    }

    public void tableChangedEventHandler(TableModelEvent evt) {

        /*if(evt.getType() == 0) {

            System.out.println("Se agrega en fila "+evt.getLastRow()+" y columna "+evt.getColumn());

            //LastRow

            LastRow = evt.getLastRow();

        }*/
    }

    public void TableCellUpdated(TableCellListener tcl) {
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        double var1;
        double var2;
        //Se agarra la fila completa según el cambio....
        switch (tcl.getColumn()) {
            case 0:
                var1 = StringToDouble(tm.getValueAt(tcl.getRow(), 4).toString());
                var2 = StringToDouble(tm.getValueAt(tcl.getRow(), 5).toString());
                rowAux = new Object[]{tcl.getOldValue(), tm.getValueAt(tcl.getRow(), 1).toString(), tm.getValueAt(tcl.getRow(), 2).toString(), tm.getValueAt(tcl.getRow(), 3).toString(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            case 1:
                var1 = StringToDouble(tm.getValueAt(tcl.getRow(), 4).toString());
                var2 = StringToDouble(tm.getValueAt(tcl.getRow(), 5).toString());
                rowAux = new Object[]{tm.getValueAt(tcl.getRow(), 0).toString(), tcl.getOldValue(), tm.getValueAt(tcl.getRow(), 2).toString(), tm.getValueAt(tcl.getRow(), 3).toString(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            case 2:
                var1 = StringToDouble(tm.getValueAt(tcl.getRow(), 4).toString());
                var2 = StringToDouble(tm.getValueAt(tcl.getRow(), 5).toString());
                rowAux = new Object[]{tm.getValueAt(tcl.getRow(), 0).toString(), tm.getValueAt(tcl.getRow(), 1).toString(), tcl.getOldValue(), tm.getValueAt(tcl.getRow(), 3).toString(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            case 3:
                var1 = StringToDouble(tm.getValueAt(tcl.getRow(), 4).toString());
                var2 = StringToDouble(tm.getValueAt(tcl.getRow(), 5).toString());
                rowAux = new Object[]{tm.getValueAt(tcl.getRow(), 0).toString(), tm.getValueAt(tcl.getRow(), 1).toString(), tm.getValueAt(tcl.getRow(), 2).toString(), tcl.getOldValue(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            case 4:
                var1 = StringToDouble(tcl.getOldValue().toString());
                var2 = StringToDouble(tm.getValueAt(tcl.getRow(), 5).toString());
                rowAux = new Object[]{tm.getValueAt(tcl.getRow(), 0).toString(), tm.getValueAt(tcl.getRow(), 1).toString(), tm.getValueAt(tcl.getRow(), 2).toString(), tm.getValueAt(tcl.getRow(), 3).toString(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            case 5:
                var1 = StringToDouble(tm.getValueAt(tcl.getRow(), 4).toString());
                var2 = StringToDouble(tcl.getOldValue().toString());
                rowAux = new Object[]{tm.getValueAt(tcl.getRow(), 0).toString(), tm.getValueAt(tcl.getRow(), 1).toString(), tm.getValueAt(tcl.getRow(), 2).toString(), tm.getValueAt(tcl.getRow(), 3).toString(), var1, var2, tm.getValueAt(tcl.getRow(), 6).toString()};
                break;
            default:
                break;
        }/* System.out.println("Row   : " + tcl.getRow());
        System.out.println("Column: " + tcl.getColumn());
        System.out.println("Old   : " + tcl.getOldValue());
        System.out.println("New   : " + tcl.getNewValue());*/
        if (!history.empty() && !reundo.empty()) {
            reundo.clear();
            jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reundode.png")));
            jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        history.add(new Cell(rowAux, tcl.getRow(), "UPDATE"));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redo.png")));
        prevValue = tcl.getNewValue().toString();    //Valor previo
        prevCol = tcl.getColumn();      //Columna previa
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //Cuando es un UPDATE se agrega el valor anterior e el history...
        //Y el valor nuevo se guarda en un String temporal para ser reutilizado en el reundo...
    }

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased

        // BOTON GUARDAR TABLA
        double var1;
        double var2;
        int var3;
        boolean pass;
        boolean modified;
        int productsAdded = 0;
        int errors = 0;
        int productsModified = 0;
        ArrayList<String> nombreArrayList = new ArrayList<>();
        ArrayList<String> codigoArrayList = new ArrayList<>();
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        int cantidadProductos = BaseDeDatos.sizeProducts();
        List<Producto> productos = BaseDeDatos.getListaProductos();
        for (Producto producto : productos) {   // Revisa si alguno de los productos de la bd fueron modificados en la tabla
            modified = true;
            for (int i = 0; i < tm.getRowCount(); i++) {
                if (tm.getValueAt(i, 0).toString().equals(producto.getNombre())) {
                    modified = false;
                    break;
                } if (tm.getValueAt(i, 2).toString().equals(producto.getCodigo())) {
                    modified = false;
                    break;
                }
            } if (modified) {
                // ALMACENAR EL PRODUCTO MODIFICADO PARA LUEGO TOMAR LA RUTA DE LA IMAGEN
                
                BaseDeDatos.borrarProducto(producto.getId());
                productsModified++;
            }
        }
        if (tm.getRowCount() != 0) {
            for (int i = 0; i < tm.getRowCount(); i++) {
                pass = true;
                //System.out.println("Producto: "+tm.getValueAt(i, 0).toString()+" Código: "+tm.getValueAt(i, 2).toString());
                for (Producto producto : productos) {
                    String nombre = producto.getNombre();
                    String codigo = producto.getCodigo();
                    if (nombre.equals(tm.getValueAt(i, 0).toString()) && codigo.equals(tm.getValueAt(i, 2).toString())) {
                        //SUBRAYAR NOMBRE Y CÓDIGO
                        //colorCell(0, i, Color.RED);
                        pass = false;
                        break;
                        //COLOCAR NOTIFICACIÓN DE ERROR EN GUARDAR ALGUNOS PRODUCTOS
                    }
                    for(int u = 0; u < nombreArrayList.size(); u++) { // Comprueba si el nombre o codigo ya estaban introducidos en las celdas
                        String nombreAux = nombreArrayList.get(u);
                        String codigoAux = codigoArrayList.get(u);
                        if (nombreAux.equals(nombre) || codigoAux.equals(codigo)) {
                            pass = false;
                            break;
                        }
                    }
                } if (pass) {
                    productsAdded++;
                    var1 = StringToDouble(tm.getValueAt(i, 4).toString());
                    var2 = StringToDouble(tm.getValueAt(i, 5).toString());
                    var3 = asInt(tm.getValueAt(i, 3).toString());
                    codigoArrayList.add(tm.getValueAt(i, 2).toString());
                    nombreArrayList.add(tm.getValueAt(i, 0).toString());
                    BaseDeDatos.addToInventory(tm.getValueAt(i, 0).toString(), tm.getValueAt(i, 1).toString(), tm.getValueAt(i, 2).toString(), var3, var1, var2, tm.getValueAt(i, 6).toString());
                } else {
                    errors++;
                }
            }
        }//System.out.println("filas= "+tm.getRowCount()+" cantidad= "+cantidadProductos+" agregados= "+productsAdded+" modificados= "+productsModified);
        if (tm.getRowCount() == cantidadProductos && productsAdded == 0 && productsModified == 0) {
            createNotification("Notificación", "No hay productos nuevos que importar!.", 5, "BottomRight", "info");
        } else if(tm.getRowCount() > cantidadProductos && productsAdded > 0 && productsModified >= 0 && errors == 0){
            createNotification("Agregados", "Los productos fueron importados satisfactoriamente!.", 5, "BottomRight", "success");
        } else if(tm.getRowCount() > cantidadProductos && productsAdded == 0 && productsModified == 0){
            createNotification("Error", "No se ha importado ningún producto, por favor revise los productos que intentó importar.", 5, "BottomRight", "error");
        } else if(tm.getRowCount() <= cantidadProductos && productsAdded == 0 && productsModified > 0){
            createNotification("Modificados", "Los productos fueron modificados satisfactoriamente.", 5, "BottomRight", "success");
        } else if(tm.getRowCount() > cantidadProductos && productsAdded == 0 && productsModified > 0){
            createNotification("Advertencia", "Uno o más productos no han podido ser importados, por favor revise los productos que intentó importar.", 5, "BottomRight", "warning");
        } else if(errors > 0){
            createNotification("Advertencia", "Uno o más productos no han podido ser importados, por favor revise los productos que intentó importar.", 5, "BottomRight", "warning");
        } else {
            createNotification("Oops!", "Ocurrio un error inesperado, por favor intente nuevamente.", 5, "BottomRight", "error");
        }
    }//GEN-LAST:event_jLabel16MouseReleased

    private void colorCell(int row, int column, Color color) {

        TableColumn columna = jTable1.getColumnModel().getColumn(column);// selecciono la columna que me interesa de la tabla
        TableCellRenderer.setColumns(column); //se le da por parametro la columna que se quiere modificar
        TableCellRenderer.setRow(row);//se le da por parametro la fila que se quiere modificar
        columna.setCellRenderer(TableCellRenderer); // le aplico la edicion
    }

    private void cellSelectedEvent(ListSelectionEvent e) { // CONTROLA EL BOTÓN DE VER DETALLES
        
        int[] selectedRows = jTable1.getSelectedRows();
        if(selectedRows.length == 1) {   // GUARDA LOS VALORES DE LA CELDA SELECCIONADA
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                jLabel49.setEnabled(false);
            } else {
                editCell[7] = selectedRow;
                jLabel49.setEnabled(true);
            }
        } else {
            jLabel49.setEnabled(false);
        }
    }
    
    private void jLabel19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseReleased

        int[] rows = jTable1.getSelectedRows();
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        double var1;
        double var2;
        for (int i = rows.length - 1; i >= 0; i--) {
            var1 = StringToDouble(tm.getValueAt(rows[i], 4).toString());
            var2 = StringToDouble(tm.getValueAt(rows[i], 5).toString());
            Object[] obj = new Object[]{tm.getValueAt(rows[i], 0).toString(), tm.getValueAt(rows[i], 1).toString(), tm.getValueAt(rows[i], 2).toString(), tm.getValueAt(rows[i], 3).toString(), var1, var2, tm.getValueAt(rows[i], 6).toString()};
            
            history.add(new Cell(obj, rows[i], "ADD"));
            jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redo.png")));
            tm.removeRow(rows[i]);
            jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        //GUARDAR BORRADO EN HISTORIAL

    }//GEN-LAST:event_jLabel19MouseReleased


    private void jLabel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseReleased

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"", "", "", 0, 0, 0, "/Images/noimage.png"});
        history.add(new Cell(new Object[]{"", "", "", 0, 0, 0, "/Images/noimage.png"}, model.getRowCount() - 1, "DELETE"));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redo.png")));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel20MouseReleased


    private void jLabel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseReleased

        //Deshacer
        if (!history.empty()) {
            Cell aux = history.pop();
            Object[] rowAux1 = null;
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            if (aux.getRow() < tm.getRowCount()) {
                double var1 = StringToDouble(tm.getValueAt(aux.getRow(), 4).toString());
                double var2 = StringToDouble(tm.getValueAt(aux.getRow(), 5).toString());
                rowAux1 = new Object[]{tm.getValueAt(aux.getRow(), 0).toString(), tm.getValueAt(aux.getRow(), 1).toString(), tm.getValueAt(aux.getRow(), 2).toString(), tm.getValueAt(aux.getRow(), 3).toString(), var1, var2, tm.getValueAt(aux.getRow(), 6).toString()};
            }
            jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reundo.png")));
            jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            whatToDo(aux);
            switch (aux.getFunction()) {
                case "ADD":
                    aux.setFunction("DELETE");
                    break;
                case "DELETE":
                    aux.setFunction("ADD");
                    break;
                case "UPDATE":
                    aux.setColumn(rowAux1);
                    break;
                default:
                    break;
            }
            reundo.add(aux);
            if (history.empty()) {
                jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redoe.png")));
                jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        }
    }//GEN-LAST:event_jLabel21MouseReleased


    private void jLabel22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseReleased

        //Rehacer
        if (!reundo.empty()) {
            Cell aux = reundo.pop();
            Object[] rowAux1 = null;
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            if (aux.getRow() < tm.getRowCount()) {
                double var1 = StringToDouble(tm.getValueAt(aux.getRow(), 4).toString());
                double var2 = StringToDouble(tm.getValueAt(aux.getRow(), 5).toString());
                rowAux1 = new Object[]{tm.getValueAt(aux.getRow(), 0).toString(), tm.getValueAt(aux.getRow(), 1).toString(), tm.getValueAt(aux.getRow(), 2).toString(), tm.getValueAt(aux.getRow(), 3).toString(), var1, var2, tm.getValueAt(aux.getRow(), 6).toString()};
            }
            jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redo.png")));
            jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            whatToDo(aux);
            switch (aux.getFunction()) {
                case "ADD":
                    aux.setFunction("DELETE");
                    break;
                case "DELETE":
                    aux.setFunction("ADD");
                    break;
                case "UPDATE":
                    aux.setColumn(rowAux1);
                    break;
                default:
                    break;
            }
            history.add(aux);
            if (reundo.empty()) {
                jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reundode.png")));
                jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        }
    }//GEN-LAST:event_jLabel22MouseReleased


    private void jToggleButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseReleased

        
    }//GEN-LAST:event_jToggleButton1MouseReleased


    private void repeat_passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeat_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repeat_passwordFieldActionPerformed

    private void signupFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupFieldMouseEntered
        signupField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signupButtonPressed.png")));
    }//GEN-LAST:event_signupFieldMouseEntered

    private void signupFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupFieldMouseExited
        signupField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/signupButton.png")));
    }//GEN-LAST:event_signupFieldMouseExited

    private void signupFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupFieldMouseReleased
        
        String nombre = nombreField.getText();
        String email = emailField.getText();
        String apellido = apellidoField.getText();
        String cedula = cedulaField.getText();
        String telefono = telefonoField.getText();
        String contraseña = passwordField.getText();
        String result = BaseDeDatos.createUser(nombre, email, apellido, cedula, telefono, contraseña);
        if (result.equals("exito")) {

            //  REGISTER USER
            showPanel("runPanel");
        } else {

            adviceLabel.setText(result);
            adviceLabel.setForeground(new java.awt.Color(255, 0, 0));
        }
    }//GEN-LAST:event_signupFieldMouseReleased

    private void jLabel33MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseReleased
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "loginPanel");
    }//GEN-LAST:event_jLabel33MouseReleased

    private void jLabel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseReleased
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        adviceLabel.setText("");
        cl.show(mainPanel, "registerPanel");
    }//GEN-LAST:event_jLabel32MouseReleased

    private void jLabel17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseReleased
        uploadImgFlag = true;
        ThumbNailView thumbView = new ThumbNailView();
        String userDir = System.getProperty("user.home");
        JFileChooser file = new JFileChooser(userDir + "/Desktop");
        //thumbView.setComponent(file);
        //file.setFileView(thumbView);
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes .jpg .gif .png .jpeg .bmp", "jpg", "gif", "png", "jpeg", "bmp");
        file.addChoosableFileFilter(filter);
        file.setAcceptAllFileFilterUsed(false);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            uploadImg.setIcon(ResizeImage(path, uploadImg));
            fileimg = selectedFile;
        }
    }//GEN-LAST:event_jLabel17MouseReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void refreshAddProduct() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        uploadImgFlag = false;
        fileimg = null;
        String str = System.getProperty("user.dir");
        String rs = str.replace("\\","/");  
        //uploadImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noimage.png")));
        uploadImg.setIcon(ResizeImage(rs+"/src/Images/noimage.png", uploadImg));
    }
    
    private int isThereMoreThanOnce(String type, String data) {
        int cant = 0;
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        boolean isName = type.equals("nombre");
        for (int i = 0; i < tm.getRowCount(); i++) {
            if (tm.getValueAt(i, 0).toString().equals(data) && isName) {
                cant++;
            } else if (tm.getValueAt(i, 2).toString().equals(data) && !isName) {
                cant++;
            }
        }
        return cant;
    }
    
    private void jLabel44MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseReleased
        
        boolean pass;
        boolean next = false;
        CopyFileStream copyFileStream;
        String pathImage = "noimage.png";
        if (fileimg != null && uploadImgFlag){
            try {
                copyFileStream = new CopyFileStream(fileimg.getAbsolutePath(), System.getProperty("user.dir")+"/src/Images/uploads/"+fileimg.getName());
                pathImage = "/Images/uploads/"+copyFileStream.getFilename();
            } catch (IOException ex) {
                Logger.getLogger(JFrameSB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (modifyProduct && !uploadImgFlag) {
            pathImage = editCell[6].toString();
        }
        
        pass = isDouble(jTextField4.getText()); //precio
        if (pass) {
            pass = isDouble(jTextField5.getText()); //costo
            next = true;
        } else {
            createNotification("Error", "Introduzca un número válido en el campo de precio.", 5, "BottomRight", "error");
        }
        if (next) {
            if(pass) {
                boolean pass1 = true;
                String nombre = jTextField1.getText();
                String descripcion = jTextField2.getText();
                String codigo = jTextField3.getText();
                if (nombre.isEmpty()) {
                    pass1 = false;
                    createNotification("Error", "El campo de nombre no puede quedar vacío!.", 5, "BottomRight", "error");
                } else if (codigo.isEmpty()) {
                    pass1 = false;
                    createNotification("Error", "El campo de código no puede quedar vacío!", 5, "BottomRight", "error");
                } else if(nombre.length() >= 20){
                    pass1 = false;
                    createNotification("Error", "El campo de nombre no puede ser mayor a 20.", 5, "BottomRight", "error");
                }
                if (pass1) {
                    String aux = jTextField4.getText();
                    double precio = Double.parseDouble(aux);
                    aux = jTextField5.getText();
                    double costo = Double.parseDouble(aux);
                    Integer currentValue = (Integer) jSpinner5.getValue();
                    int cantidad = currentValue;
                    String result = "";
                    if(!modifyProduct) {
                        result = BaseDeDatos.addToInventory(nombre, descripcion, codigo, cantidad, precio, costo, pathImage);
                        
                    } else {
                        int cantNom = isThereMoreThanOnce("nombre", jTextField1.getText());
                        int cantCod = isThereMoreThanOnce("codigo", jTextField3.getText());
                        boolean canModify = true;
                        if (cantNom > 1 && canModify){
                            
                            createNotification("Error", "El nombre introducido ya existe.", 5, "BottomRight", "error");
                            canModify = false;
                            
                        } if (cantCod > 1 && canModify){
                            
                            createNotification("Error", "El código introducido ya existe.", 5, "BottomRight", "error");
                            canModify = false;
                            
                        }//VERIFICAR SI EL NOMBRE O CÓDIGO EXISTEN EN LA BD; SI ES ASÍ SE REEMPLAZAN, SI NO SE AGREGAN
                        if (canModify) {
                            String type = "";
                            boolean exists = BaseDeDatos.productCodeExists(jTextField3.getText());
                            if(!exists) { //VERIFICA SI SE DEBE REEMPLAZAR CON LA COLUMNA A EDITAR O NO
                                exists = BaseDeDatos.productNameExists(jTextField1.getText());
                                if(exists){
                                    type = "nombre";
                                }
                            } else {
                                type = "codigo";
                            }
                            result = "modified";
                            if(exists){
                                // SE REEMPLAZA
                                BaseDeDatos.replaceProduct(type, nombre, descripcion, codigo, cantidad, precio, costo, pathImage);
                            } else {
                                // NO SE REEMPLAZA
                                BaseDeDatos.addToInventory(nombre, descripcion, codigo, cantidad, precio, costo, pathImage);
                            }// AQUI SE REEMPLAZA LA FILA CON LO NUEVO SIEMPRE!
                            /*DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            Object[] column = new Object[]{editCell[0], editCell[1], editCell[2], (int) editCell[3], costo, precio, editCell[6]};
                            model.insertRow((int) editCell[7], column);
                            model.removeRow((int) editCell[7] + 1);*/
                        }
                    }
                    switch (result) {
                        case "accepted":
                            createNotification("Proceso completado!", "El producto ha sido agregado satisfactoriamente!.", 5, "BottomRight", "success");
                            refreshListInventory();
                            break;
                        case "modified":
                            createNotification("Proceso completado!", "El producto ha sido actualizado satisfactoriamente!.", 5, "BottomRight", "success");
                            refreshListInventory();
                            break;
                        case "nombre":
                            createNotification("Error", "El nombre introducido ya existe.", 5, "BottomRight", "error");
                            break;
                        case "codigo":
                            createNotification("Error", "El código introducido ya existe.", 5, "BottomRight", "error");
                            break;
                        default:
                            createNotification("Error", "Ocurrió un error inesperado, por favor intente nuevamente.", 5, "BottomRight", "error");
                            break;
                    }
                }
            } else {
                createNotification("Error", "Introduzca un número válido en el campo de costo.", 5, "BottomRight", "error");
            }
        }
    }//GEN-LAST:event_jLabel44MouseReleased

    private boolean isDouble(String myString) {
        final String Digits     = "(\\p{Digit}+)";
        final String HexDigits  = "(\\p{XDigit}+)";
        final String Exp        = "[eE][+-]?"+Digits;
        final String fpRegex    =
            ("[\\x00-\\x20]*"+ "[+-]?(" + "NaN|" + "Infinity|" + 
                "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+ 
                "(\\.("+Digits+")("+Exp+")?)|"+ "((" + "(0[xX]" + HexDigits + 
                "(\\.)?)|" + "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" + 
                ")[pP][+-]?" + Digits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");
        if (Pattern.matches(fpRegex, myString)){
            Double.valueOf(myString);
            return true;
        } else {
            return false;
        }
    }
    
    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_buttonpPressed.png")));
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jLabel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseExited
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_button.png")));
    }//GEN-LAST:event_jLabel44MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload_imgPressed.png")));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload_img.png")));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
        CardLayout cl = (CardLayout) (jPanelCard.getLayout());
        cl.show(jPanelCard, "inventoryPanel");
        //refreshAddProduct();
    }//GEN-LAST:event_jLabel23MouseReleased

    private void jLabel43MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseReleased
        refreshListInventory();
        createNotification("Notificación", "La tabla fue actualizada.", 5, "BottomRight", "info");
    }//GEN-LAST:event_jLabel43MouseReleased

    private void jLabel49MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseReleased
        // VER DETALLES
        if(jLabel49.isEnabled()) {
            modifyProduct = true;
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            int[] selectedRow = jTable1.getSelectedRows();
            if(selectedRow.length == 1) {   // GUARDA LOS VALORES DE LA CELDA SELECCIONADA
                int row = Integer.parseInt(editCell[7].toString());
                double var1 = StringToDouble(tm.getValueAt(row, 4).toString());
                double var2 = StringToDouble(tm.getValueAt(row, 5).toString());
                DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                String Precio = Double.toString(var2);
                String Costo = Double.toString(var1);
                int var3 = Integer.parseInt(tm.getValueAt(row, 3).toString());  
                editCell[0] = tm.getValueAt(row, 0).toString();
                editCell[1] = tm.getValueAt(row, 1).toString();
                editCell[2] = tm.getValueAt(row, 2).toString();
                editCell[3] = var3;
                try {
                    editCell[4] = nf.parse(Costo);
                    editCell[5] = nf.parse(Precio);
                } catch (ParseException ex) {
                    Logger.getLogger(JFrameSB.class.getName()).log(Level.SEVERE, null, ex);
                }
                editCell[6] = tm.getValueAt(row, 6).toString();
                jLabel49.setEnabled(true);
            }
            jTextField1.setText(editCell[0].toString());//NOMBRE
            jTextField2.setText(editCell[1].toString());//DESCRIPCION
            jTextField3.setText(editCell[2].toString());//CÓDIGO
            jTextField4.setText(editCell[5].toString());//PRECIO
            jTextField5.setText(editCell[4].toString());//COSTO
            jSpinner5.setValue(Integer.valueOf(editCell[3].toString()));//CANTIDAD
            fileimg = null;
            String str = System.getProperty("user.dir");
            String rs = str.replace("\\","/");
            uploadImg.setIcon(ResizeImage(rs+"/src"+editCell[6].toString(), uploadImg));
            //uploadImg.setIcon(new javax.swing.ImageIcon(getClass().getResource(editCell[6].toString())));
            CardLayout cl = (CardLayout) (jPanelCard.getLayout());
            cl.show(jPanelCard, "addProduct");
        }
    }//GEN-LAST:event_jLabel49MouseReleased

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased

        String code = "";
        Integer currentValue = (Integer) jSpinner1.getValue();
        for (int i = 0; i < 1;) {
            code = randomString(currentValue);
            if (!BaseDeDatos.productCodeExists(code)) {
                i++;
            }
        } if(code.equals("")){
            //LANZAR EXCEPCIÓN
        }
        jTextField3.setText(code);
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        modifyProduct = false;
        CardLayout cl = (CardLayout) (jPanelCard.getLayout());
        cl.show(jPanelCard, "addProduct");
    }//GEN-LAST:event_jButton3MouseReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        if (jComboBox1.getSelectedItem().toString().equals("Modo listado")) {
            CardLayout cl = (CardLayout) (jPanel6.getLayout());
            cl.show(jPanel6, "listedInventoryPanel");
            refreshListInventory();
        } else {
            CardLayout cl = (CardLayout) (jPanel6.getLayout());
            cl.show(jPanel6, "cuadInventoryPanel");
            refreshCuadInventory();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setExtendedState(ICONIFIED);
        this.setVisible(false);
        jDialog1.setVisible(true);
        EntityManager em = BaseDeDatos.getEntityManager();
        DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
        List<Usuario> listUsuario = BaseDeDatos.getListaUsuarios();
        for (int i = 0; i < listUsuario.size(); i++) {
            Usuario verUsuario = em.find(Usuario.class, i);
            if (verUsuario != null) {
                model.addRow(new Object[]{verUsuario.getNombres(), verUsuario.getApellidos(), verUsuario.getEmail(), verUsuario.getCedula(), verUsuario.getTelefono()});
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshListInventory() {

        List<Producto> productos = BaseDeDatos.getListaProductos();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        productos.forEach((producto) -> {
            double precio = producto.getPrecio();
            double costo = producto.getCosto();
            DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            String Precio = Double.toString(precio);
            String Costo = Double.toString(costo);
            try {
                model.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getCodigo(), producto.getCantidad(), nf.parse(Costo), nf.parse(Precio), producto.getRutaImagen()});
            } catch (ParseException ex) {
                Logger.getLogger(JFrameSB.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void refreshCuadInventory() {

    }

    public ImageIcon ResizeImage(String ImagePath, JComponent component) {

        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public double StringToDouble(String value) {

        String a = value;
        String s = a.replaceAll(",", "").trim();
        String f = s.replaceAll(" ", "");
        double result = Double.parseDouble(f);
        return result;
    }

    public int asInt(Object o) {

        int val = 0;
        if (o instanceof Number) {
            val = ((Number) o).intValue();
        }
        return val;
    }

    public String randomString(int size) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public void createNotification(String title, String body, int sec, String pos, String notify) {
        PositionNotify position = null;
        String aux = "SmartBusiness: ";
        switch (pos) {
            case "BottomLeft":
                position = PositionNotify.BottomLeft;
                break;
            case "BottomRight":
                position = PositionNotify.BottomRight;
                break;
            case "TopLeft":
                position = PositionNotify.TopLef;
                break;
            case "TopRight":
                position = PositionNotify.TopRight;
                break;
            default:
                break;
        }
        switch (notify) {
            case "warning":
                new rojerusan.RSNotifyFade(aux + title, body, sec, position, TypeNotify.WARNING).setVisible(true);
                break;
            case "error":
                new rojerusan.RSNotifyFade(aux + title, body, sec, position, TypeNotify.ERROR).setVisible(true);
                break;
            case "info":
                new rojerusan.RSNotifyFade(aux + title, body, sec, position, TypeNotify.INFORMATION).setVisible(true);
                break;
            case "success":
                new rojerusan.RSNotifyFade(aux + title, body, sec, position, TypeNotify.SUCCESS).setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public static void main(String args[]) {

        System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrameSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrameSB().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addProduct;
    private javax.swing.JLabel adviceLabel;
    private javax.swing.JTextField apellidoField;
    private javax.swing.JTextField cedulaField;
    private javax.swing.JPanel cuadInventoryPanel;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField emailLogin;
    private javax.swing.JLabel errorLogin;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel listedInventoryPanel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField passwordLogin;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTextField repeat_passwordField;
    private javax.swing.JPanel runPanel;
    private javax.swing.JLabel signupField;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel uploadImg;
    // End of variables declaration//GEN-END:variables

}
