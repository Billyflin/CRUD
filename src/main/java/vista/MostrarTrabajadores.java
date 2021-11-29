/*
 * Created by JFormDesigner on Mon Nov 29 01:48:35 CLST 2021
 */

package vista;

import modelo.Trabajador;
import servicio.ServicioTrabajador;

import java.awt.*;
import java.beans.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author Billy Martinez
 */
public class MostrarTrabajadores extends JFrame {
    public MostrarTrabajadores() {
        initComponents();
        pack();
    }

    private void table1PropertyChange(PropertyChangeEvent e) {
        table1.createDefaultColumnsFromModel();
        ServicioTrabajador servicio = new ServicioTrabajador(CrearPersona.RUTA_GUARDADO);
        ArrayList<Trabajador> datos = null;
        try {
            datos = servicio.leerTrabajadores();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        assert datos != null;
        agregarDatos(datos);
    }
    private void agregarDatos(ArrayList<Trabajador> trabajadors){



        DefaultTableModel modelo = (DefaultTableModel)table1.getModel();



        String datos[] = new String[5];//ARRAY DE 4

//LE PASO AL ARRAY LOS DATOS DEL ARRAYLIST


        for (Trabajador trabajador : trabajadors) {


            datos[0] = trabajador.getNombre();
            datos[1] = trabajador.getApellido();
            datos[2] = trabajador.getRut();
            datos[3] = trabajador.getIsapre();
            datos[4] = trabajador.getAfp();
            modelo.addRow(datos);
        }
        TableColumn colum1 = null;
        colum1 = table1.getColumnModel().getColumn(0);
        colum1.setPreferredWidth(60);
        TableColumn colum2 = null;
        colum2 = table1.getColumnModel().getColumn(1);
        colum2.setPreferredWidth(5);
        TableColumn colum3 = null;
        colum3 = table1.getColumnModel().getColumn(2);
        colum3.setPreferredWidth(40);
        colum3.setPreferredWidth(10);
        TableColumn colum4 = null;
        colum4 = table1.getColumnModel().getColumn(3);
        colum4.setPreferredWidth(10);
        TableColumn colum5 = null;
        colum5 = table1.getColumnModel().getColumn(4);
        colum5.setPreferredWidth(10);


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                        },
                        new String[] {
                            null, null, null, null, null
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            String.class, Object.class, Object.class, Object.class, Object.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, true, true, true, true
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    table1.setAutoCreateRowSorter(true);
                    table1.addPropertyChangeListener(e -> table1PropertyChange(e));
                    scrollPane1.setViewportView(table1);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
