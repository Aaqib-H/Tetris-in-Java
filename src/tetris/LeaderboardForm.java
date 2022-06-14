package tetris;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LeaderboardForm extends javax.swing.JFrame {

    private DefaultTableModel tm;
    private String leaderboardFile = "leaderboard";
    
    private TableRowSorter<TableModel> sorter;
    
    public LeaderboardForm() {
        
        initComponents();
        initTableData();
        initTableSorter();
    }
    
    private void initTableData(){
        
        Vector ci = new Vector();
        ci.add("Player");
        ci.add("Score");

        tm = (DefaultTableModel)leaderboard.getModel();
        
        try{
            
            FileInputStream fs = new FileInputStream(leaderboardFile);
            ObjectInputStream os = new ObjectInputStream(fs);

            tm.setDataVector( (Vector<Vector>)os.readObject(), ci);
            
            os.close();
            fs.close();
        }
        catch(Exception e){
            // Do nothing
        }
    }
    private void initTableSorter(){
        
        sorter = new TableRowSorter<>(tm);
        leaderboard.setRowSorter(sorter);
        
        ArrayList<SortKey> keys = new ArrayList<>();
        keys.add(new SortKey(1, SortOrder.DESCENDING));
        
        sorter.setSortKeys(keys);
    }
    
    private void saveLeaderboard(){
        
        try{
            FileOutputStream fs = new FileOutputStream(leaderboardFile);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(tm.getDataVector());

            os.close();
            fs.close();
        }
        catch(Exception e){
            // Do Nothing
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMainMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setPreferredSize(new java.awt.Dimension(500, 312));
        setResizable(false);

        btnMainMenu.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        btnMainMenu.setForeground(new java.awt.Color(0, 51, 102));
        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        leaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaderboard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        this.setVisible(false);
        Tetris.showStartUp();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    public void addPlayer(String playerName, int score){
        
        tm.addRow(new Object[] {playerName, score});
        sorter.sort();
        saveLeaderboard();
        
        this.setVisible(true);
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    // End of variables declaration//GEN-END:variables
}
