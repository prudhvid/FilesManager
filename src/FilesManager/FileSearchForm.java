/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FilesManager;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Prudhvi
 */
public class FileSearchForm extends javax.swing.JFrame {
    FileNoComboSuggest fileComboHelp;
    SubjComboSuggest subSearchHelp;
    TableModel tableModel;
    boolean fileNotFound;
    final int FILE_SEARCH=1,SUB_SEARCH=2,DATE_SEARCH=3;
    int lastSearchMade;
    List<HardCopy> lastUsedList;
    int pagenumber;
    
    /**
     * Creates new form FileSearchForm
     */
    public FileSearchForm() {
        initComponents();
        fileNotFound=false;
        lastUsedList=null;
        pagenumber=0;
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        buttonGroup1.add(onlyPending);
        buttonGroup1.add(onlyDispatched);
        buttonGroup1.add(bothPndingNDisppatched);
        bothPndingNDisppatched.setSelected(true);
        List<HardCopy> listTemp=null;
        StoredPath sp=new StoredPath();
        if(sp.isPathPres()){
            System.out.println(sp.getPath());
            File f=new File(sp.getPath());
            if(f.exists()){
                listTemp=ExcelParser.readExcelData(sp.getPath());
                Search.fileList=listTemp;    
            }
            else{
                JOptionPane.showMessageDialog(this, "sorry previous file not found!");
                fileNotFound=true;
                openFileButtonActionPerformed(null);
                listTemp=Search.fileList;
            }
            
        }
        else{
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Excel files", "xls", "xlsx");
            chooser.setFileFilter(filter);
            int option = chooser.showOpenDialog(FileSearchForm.this);

            if(option==JFileChooser.APPROVE_OPTION){
                File f=chooser.getSelectedFile();
                System.out.println(f.getName());
                listTemp=ExcelParser.readExcelData(f.getAbsolutePath());
                Search.fileList=listTemp;
                sp.storePath(f.getAbsolutePath());
            }
            else if(option==JFileChooser.CANCEL_OPTION){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        }
       
        
        
        
        
        
        
        tableModel=resultsTable.getModel();
        resultsTable.setRowHeight(100);
        resultsTable.setDefaultRenderer(String.class, new MultiLineCellRenderer());
//        resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        resultsTable.getColumnModel().getColumn(0).setMaxWidth(40);
        resultsTable.getColumnModel().getColumn(1).setMaxWidth(200);
        resultsTable.getColumnModel().getColumn(2).setMaxWidth(250);
        resultsTable.getColumnModel().getColumn(3).setMaxWidth(750);
        resultsTable.getColumnModel().getColumn(4).setMaxWidth(200);
        resultsTable.getColumnModel().getColumn(5).setMaxWidth(200);
        updateGUI(listTemp,1);
        System.out.println(listTemp);
        lastSearchMade=SUB_SEARCH;
//        resizeColumnWidth(resultsTable);
//        resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        fileSearchBox.setEditable(true);
        fileComboHelp=new FileNoComboSuggest(fileSearchBox);
        fileSearchBox.setModel(fileComboHelp);
        fileSearchBox.addItemListener(fileComboHelp);
        
       
        
        
        
        JTextField editor = (JTextField) fileSearchBox.getEditor().getEditorComponent();
        
        subjBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt)
            {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    List<HardCopy> l=Search.getBySubject(subjBox.getText());
                    updateGUI(l,1);
                    lastSearchMade=SUB_SEARCH;
                }
                    
            }
        });
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt)
            {
                fileSearchBoxActionPerformed(null);
                
            }
            @Override
            public void keyPressed(KeyEvent evt)
            {
                fileSearchBoxActionPerformed(null);
                
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        fileSearchBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        outDateChoose = new com.toedter.calendar.JDateChooser();
        inDateChoose = new com.toedter.calendar.JDateChooser();
        searchByDateButton = new javax.swing.JButton();
        subjBox = new javax.swing.JTextField();
        openFileButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        resultsNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pendingNumber = new javax.swing.JTextField();
        onlyPending = new javax.swing.JRadioButton();
        onlyDispatched = new javax.swing.JRadioButton();
        bothPndingNDisppatched = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        pageNumberBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        fileSearchBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fileSearchBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fileSearchBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fileSearchBoxItemStateChanged(evt);
            }
        });
        fileSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSearchBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("File No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Subject");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Inward Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Outward Date");

        resultsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resultsTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "S.No", "Inward Date", "File No", "Subject", "Outward Date", "DispacthedTo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        resultsTable.setColumnSelectionAllowed(true);
        resultsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(resultsTable);
        resultsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        inDateChoose.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inDateChoosePropertyChange(evt);
            }
        });

        searchByDateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchByDateButton.setText("Search By Date");
        searchByDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByDateButtonActionPerformed(evt);
            }
        });

        subjBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subjBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjBoxActionPerformed(evt);
            }
        });

        openFileButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        openFileButton.setText("Upload new file");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Results found:");

        resultsNumber.setEditable(false);
        resultsNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resultsNumber.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Pending:");

        pendingNumber.setEditable(false);
        pendingNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pendingNumber.setFocusable(false);
        pendingNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingNumberActionPerformed(evt);
            }
        });

        onlyPending.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        onlyPending.setText("Show only pending");
        onlyPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyPendingActionPerformed(evt);
            }
        });

        onlyDispatched.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        onlyDispatched.setText("Show only dispatched");
        onlyDispatched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyDispatchedActionPerformed(evt);
            }
        });

        bothPndingNDisppatched.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bothPndingNDisppatched.setText("Show Both Pending and dispatched");
        bothPndingNDisppatched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bothPndingNDisppatchedActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FilesManager/21B5.gif"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Clear Dates");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prevButton.setText("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        pageNumberBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pageNumberBox.setText("1");
        pageNumberBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageNumberBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(openFileButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subjBox, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(resultsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(pendingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onlyPending)
                            .addComponent(bothPndingNDisppatched)
                            .addComponent(onlyDispatched))
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(inDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchByDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pageNumberBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(723, 723, 723))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(openFileButton)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fileSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(subjBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(pendingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(onlyPending)
                                .addGap(29, 29, 29)
                                .addComponent(bothPndingNDisppatched))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(onlyDispatched))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(inDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outDateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchByDateButton)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(prevButton)
                    .addComponent(pageNumberBox))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSearchBoxActionPerformed
       
        List<HardCopy> l=null;
        try {
            l=fileComboHelp.database;
            
        } catch (Exception e) {
            System.out.println("EXCEPTION");
            e.printStackTrace();;
        }
        
         updateGUI(l,1);
         lastSearchMade=FILE_SEARCH;
        
    }//GEN-LAST:event_fileSearchBoxActionPerformed

    private void inDateChoosePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inDateChoosePropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_inDateChoosePropertyChange

    private void searchByDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByDateButtonActionPerformed
        // TODO add your handling code here:
        try {
            Date d1=inDateChoose.getDate();
            Date d2=outDateChoose.getDate();
            List<HardCopy> l;
            System.out.println(d1);
            System.out.println(d2);
            if(d1==null&&d2!=null)
                l=Search.getByOutwardDate(d2);
            else if(d1!=null&&d2==null)
                l=Search.getByInwardDate(d1);
            else
                l=Search.getByDates(d1, d2);
            updateGUI(l,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lastSearchMade=DATE_SEARCH;
    }//GEN-LAST:event_searchByDateButtonActionPerformed

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Excel files", "xls", "xlsx");
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(FileSearchForm.this);
        
        if(option==JFileChooser.APPROVE_OPTION){
            File f=chooser.getSelectedFile();
            System.out.println(f.getName());
            List<HardCopy> list=ExcelParser.readExcelData(f.getAbsolutePath());
            Search.fileList=list;
            StoredPath sp=new StoredPath();
            sp.storePath(f.getAbsolutePath());
        }
        else if(option==JFileChooser.CANCEL_OPTION&&fileNotFound==true){
            this.dispose();
            System.exit(0);
        }
        
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void subjBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjBoxActionPerformed
        List<HardCopy> l=Search.getBySubject(subjBox.getText());
        updateGUI(l,1);
        lastSearchMade=SUB_SEARCH;
    }//GEN-LAST:event_subjBoxActionPerformed

    private void fileSearchBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fileSearchBoxItemStateChanged
      
    }//GEN-LAST:event_fileSearchBoxItemStateChanged

    private void pendingNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingNumberActionPerformed

    private void onlyPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyPendingActionPerformed
        if(lastSearchMade==SUB_SEARCH)
            subjBoxActionPerformed(null);
        else if(lastSearchMade==FILE_SEARCH)
            fileSearchBoxActionPerformed(null);
        else
            searchByDateButtonActionPerformed(null);
    }//GEN-LAST:event_onlyPendingActionPerformed

    private void onlyDispatchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyDispatchedActionPerformed
        if(lastSearchMade==SUB_SEARCH)
            subjBoxActionPerformed(null);
        else if(lastSearchMade==FILE_SEARCH)
            fileSearchBoxActionPerformed(null);
        else
            searchByDateButtonActionPerformed(null);
    }//GEN-LAST:event_onlyDispatchedActionPerformed

    private void bothPndingNDisppatchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bothPndingNDisppatchedActionPerformed
        if(lastSearchMade==SUB_SEARCH)
            subjBoxActionPerformed(null);
        else if(lastSearchMade==FILE_SEARCH)
            fileSearchBoxActionPerformed(null);
        else
            searchByDateButtonActionPerformed(null);
    }//GEN-LAST:event_bothPndingNDisppatchedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //clear both the dates
        inDateChoose.setCalendar(null);
        outDateChoose.setCalendar(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if(lastUsedList==null)
            return;
        if(lastUsedList.size()>100*(pagenumber+1)){
            updateGUI(lastUsedList,100*(pagenumber+1)+1);
            pagenumber++;
            pageNumberBox.setText(pagenumber+1+"");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        if(lastUsedList==null)
            return;
        if(pagenumber>0){
            updateGUI(lastUsedList,100*(pagenumber-1)+1);
            if(pagenumber!=0)
            pagenumber--;
            pageNumberBox.setText(pagenumber+1+"");
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void pageNumberBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageNumberBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pageNumberBoxActionPerformed

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
            java.util.logging.Logger.getLogger(FileSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileSearchForm().setVisible(true);
                
            }
        });
        
    }
    private void updateRowHeights()
    {
        try
        {
            
            for (int row = 0; row < resultsTable.getRowCount(); row++)
            {
                int rowHeight = resultsTable.getRowHeight(row);
                int column=3;
                int prev=rowHeight;
                Component comp = resultsTable.prepareRenderer(resultsTable.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height+20);
                
                resultsTable.setRowHeight(row, rowHeight);
                System.out.println("row height ="+resultsTable.getRowHeight(row)+"   prev ="+prev);
            }
        }
        catch(ClassCastException e) {
            e.printStackTrace();
        }
    }
    private void updateGUI(List<HardCopy> l,int initindex)
    {
        int index=0;
        if(initindex==1)
        {
            prevButton.setEnabled(false);
            pagenumber=0;
        }
        else
            prevButton.setEnabled(true);
        resultsNumber.setText(String.valueOf(l.size()));
        int count=0;
        for (HardCopy hardCopy : l) {
            if(hardCopy.outDate==null||hardCopy.dispatchedTo==null)
                count++;
        }
        pendingNumber.setText(count+"");
        
        
        DateFormat df=DateFormat.getDateInstance();
        
        lastUsedList=l;
        if(l.size()>0)
            l=l.subList(initindex-1, l.size());
        if(l!=null){
            
            for (HardCopy hardCopy : l) {
                if(index>=100)
                    break;
                if(onlyDispatched.isSelected()&&hardCopy.isPending())
                {
                    continue;
                }
                    
                if(onlyPending.isSelected()&&!hardCopy.isPending())
                {
                    continue;
                }
                tableModel.setValueAt(index+initindex, index, 0);
                tableModel.setValueAt(df.format(hardCopy.inDate), index, 1);
                tableModel.setValueAt(hardCopy.fileNo, index, 2);
                if(hardCopy.subject!=null)
                {
                    String s=hardCopy.subject;
                    StringBuilder sb = new StringBuilder(s);

                    int i = 0;
//                    while ((i = sb.indexOf(" ", i + 55)) != -1) {
//                        sb.replace(i, i + 1, "\n");
//                    }
                    tableModel.setValueAt(sb.toString(), index, 3);

                }
                else
                    tableModel.setValueAt("", index, 3);
                if(hardCopy.outDate!=null)
                    tableModel.setValueAt(df.format(hardCopy.outDate), index, 4);
                else
                    tableModel.setValueAt("", index, 4);
                if(hardCopy.dispatchedTo!=null)
                    tableModel.setValueAt(hardCopy.dispatchedTo, index, 5);
                else
                    tableModel.setValueAt("", index, 5);
                index++;
            }
        }
        if(index<100)
            nextButton.setEnabled(false);
        else
            nextButton.setEnabled(true);
        for (int j = index; j < 100; j++) {
            for (int k = 0; k < 6; k++) {
                    tableModel.setValueAt("", j, k);
            }
        }
        
//        updateRowHeights();
        
        
      
    }
    
  public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 50; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width, width);
        }
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bothPndingNDisppatched;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JComboBox fileSearchBox;
    private com.toedter.calendar.JDateChooser inDateChoose;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton onlyDispatched;
    private javax.swing.JRadioButton onlyPending;
    private javax.swing.JButton openFileButton;
    private com.toedter.calendar.JDateChooser outDateChoose;
    private javax.swing.JTextField pageNumberBox;
    private javax.swing.JTextField pendingNumber;
    private javax.swing.JButton prevButton;
    private javax.swing.JTextField resultsNumber;
    private javax.swing.JTable resultsTable;
    private javax.swing.JButton searchByDateButton;
    private javax.swing.JTextField subjBox;
    // End of variables declaration//GEN-END:variables
}
class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

  public MultiLineCellRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    if (hasFocus) {
      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      if (table.isCellEditable(row, column)) {
        setForeground(UIManager.getColor("Table.focusCellForeground"));
        setBackground(UIManager.getColor("Table.focusCellBackground"));
      }
    } else {
      setBorder(new EmptyBorder(1, 2, 1, 2));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
  
}


