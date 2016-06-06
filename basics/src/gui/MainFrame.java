package gui;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        cityPanel = new javax.swing.JPanel();
        txtCityName = new javax.swing.JTextField();
        btnSearchCity = new javax.swing.JButton();
        connectionPanel = new javax.swing.JPanel();
        txtStartPoint = new javax.swing.JTextField();
        txtEndPoint = new javax.swing.JTextField();
        btnSearchConnection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WOOT! A Title");
        setPreferredSize(new java.awt.Dimension(350, 150));
        setResizable(false);
        setSize(new java.awt.Dimension(350, 150));

        txtCityName.setText("Type City Name..");
        txtCityName.setToolTipText("Type City Name");
        txtCityName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnSearchCity.setText("Search");

        javax.swing.GroupLayout cityPanelLayout = new javax.swing.GroupLayout(cityPanel);
        cityPanel.setLayout(cityPanelLayout);
        cityPanelLayout.setHorizontalGroup(
            cityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchCity, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        cityPanelLayout.setVerticalGroup(
            cityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cityPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(cityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCity))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        tabs.addTab("City", cityPanel);

        txtStartPoint.setText("Enter starting point...");

        txtEndPoint.setText("Enter end point...");

        btnSearchConnection.setText("Search");

        javax.swing.GroupLayout connectionPanelLayout = new javax.swing.GroupLayout(connectionPanel);
        connectionPanel.setLayout(connectionPanelLayout);
        connectionPanelLayout.setHorizontalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEndPoint)
                    .addComponent(txtStartPoint))
                .addGap(18, 18, 18)
                .addComponent(btnSearchConnection)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        connectionPanelLayout.setVerticalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(connectionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtStartPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(connectionPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSearchConnection)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        tabs.addTab("Connection", connectionPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchCity;
    private javax.swing.JButton btnSearchConnection;
    private javax.swing.JPanel cityPanel;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtEndPoint;
    private javax.swing.JTextField txtStartPoint;
    // End of variables declaration//GEN-END:variables
}
