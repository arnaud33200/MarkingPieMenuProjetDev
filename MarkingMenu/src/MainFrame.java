import java.awt.Color;
import java.util.ArrayList;
import javafx.util.Pair;


public class MainFrame extends javax.swing.JFrame {

    private MarkingPieMenuModel menuColorPanel;
    private MarkingPieMenuModel menuLabel;
    private MarkingPieMenuModel menuConsol;

    private ArrayList<Pair<String, String>> consolMsg;
    private String filter;

    public MainFrame() {
        initComponents();

        consolMsg = new ArrayList<Pair<String, String>>();
        filter = "";

        menuColorPanel = new MarkingPieMenuModel(jPanel1);
        menuColorPanel.addSection("Bleu", new Color(0x8bb5e4));
        menuColorPanel.addSection("Rouge", new Color(0xea6d6d));
        menuColorPanel.addSection("Jaune", new Color(0xf2f05f));
        menuColorPanel.addSection("Violet", new Color(0xc08dd8));
// menu avec bord transparent sans text 
        menuColorPanel.setMyPieView(new MarkingPieMenuViewTransparent(MarkingPieMenuModel.INNERCIRCLESIZE, MarkingPieMenuModel.OUTERCIRCLESIZE, menuColorPanel.getSections()));
        menuColorPanel.addMarkingPieMenuListener(new MarkingPieMenuListener() {
            @Override
            public void markingPieMenuHighDoCommand(MarkingPieMenuEvent e) {
                Section s = (Section) e.getSource();
                String msg = "ColorPanel [" + s.getNumber() + "] - " + s.getName() + "\n";
                consolMsg.add(new Pair<>("ColorPanel", msg));
                paintTerminal();
                switch (s.getNumber()) {
                    case 0: jPanel1.setBackground(new Color(0x8bb5e4)); break;
                    case 1: jPanel1.setBackground(new Color(0xea6d6d)); break;
                    case 2: jPanel1.setBackground(new Color(0xf2f05f)); break;
                    case 3: jPanel1.setBackground(new Color(0xc08dd8)); break;
                }
            }
        });

        menuLabel = new MarkingPieMenuModel(jLabel1);
        menuLabel.addSection("Vicent", new Color(0x36c936));
        menuLabel.addSection("Arnaud", new Color(0xa56934));
        menuLabel.addMarkingPieMenuListener(new MarkingPieMenuListener() {

            @Override
            public void markingPieMenuHighDoCommand(MarkingPieMenuEvent e) {
                Section s = (Section) e.getSource();
                String msg = "Label [" + s.getNumber() + "] - " + s.getName() + "\n";
                consolMsg.add(new Pair<>("Label", msg));
                paintTerminal();
                switch (s.getNumber()) {
                    case 0: jLabel1.setText("Vincent"); break;
                    case 1: jLabel1.setText("Arnaud"); break;
                }
            }
        });

        menuColorPanel = new MarkingPieMenuModel(jTextArea1);
        menuColorPanel.addSection("Color Panel", new Color(0x404040));
        menuColorPanel.addSection("Label", new Color(0x767676));
        menuColorPanel.addSection("ALL", new Color(0x5f5f5f));
        menuColorPanel.addMarkingPieMenuListener(new MarkingPieMenuListener() {

            @Override
            public void markingPieMenuHighDoCommand(MarkingPieMenuEvent e) {
                Section s = (Section) e.getSource();
                if (s.getName().contains("Color Panel")) {
                    filter = "ColorPanel";
                } else if (s.getName().contains("Label")) {
                    filter = "Label";
                } else {
                    filter = "";
                }
                paintTerminal();
            }
        });
    }

    private void paintTerminal() {
        String txt = "";
        jTextArea1.setText("");
        for (Pair p : consolMsg) {
            if (filter == "") {
                txt += "> " + p.getValue();
            } else if (filter.contains((CharSequence) p.getKey())) {
                txt += "> " + p.getValue();
            }

        }
        txt += "> ";
        jTextArea1.setText(txt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(209, 233, 192));
        jTextArea1.setRows(5);
        jTextArea1.setText("> ");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(179, 223, 179));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Text Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
