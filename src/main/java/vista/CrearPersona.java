/*
 * Created by JFormDesigner on Mon Nov 29 01:25:38 CLST 2021
 */

package vista;

import modelo.Trabajador;
import servicio.ServicioTrabajador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

/**
 * @author Billy Martinez
 */
public class CrearPersona extends JFrame {
    public static final String RUTA_GUARDADO = "src/main/resources/Data.csv";

    public CrearPersona() {
        initComponents();
        pack();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        trabajadorUWU();
    }
    private void trabajadorUWU(){
        Trabajador trabajadorNuevo = new Trabajador();
        if(notEmptyTextFields()){
            trabajadorNuevo = new Trabajador(textFieldName.getText(),textFieldLastName.getText(),textFieldRut.getText(),textFieldIsapre.getText(),textFieldAFP.getText());
        }
        ServicioTrabajador service= new ServicioTrabajador(RUTA_GUARDADO);
        if (service.verificarSiTrabajadorExiste(trabajadorNuevo)){
            service.crear();
            vaciarCampos();
        }else if(!service.verificarSiTrabajadorExiste(trabajadorNuevo)){
            service.actualizar(trabajadorNuevo.toString());
            vaciarCampos();
        }
    }

    private void vaciarCampos(){
        textFieldLastName.setText("");
        textFieldName.setText("");
        textFieldRut.setText("");
        textFieldIsapre.setText("");
        textFieldAFP.setText("");
    }


    private boolean notEmptyTextFields(){
        return !textFieldName.getText().equals("")&&!textFieldLastName.getText().equals("")&&!textFieldRut.getText().equals("")&&!textFieldIsapre.getText().equals("")&&!textFieldAFP.getText().equals("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        textFieldLastName = new JTextField();
        label3 = new JLabel();
        textFieldRut = new JTextField();
        label4 = new JLabel();
        textFieldName = new JTextField();
        textFieldIsapre = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        textFieldAFP = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle("Agregar Persona");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label2 ----
                label2.setText("Apellido");

                //---- label3 ----
                label3.setText("Rut");

                //---- label4 ----
                label4.setText("Nombre");

                //---- label5 ----
                label5.setText("Isapre");

                //---- label6 ----
                label6.setText("AFP");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(label5))
                                    .addGap(28, 28, 28))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldIsapre, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(textFieldRut, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(textFieldLastName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(textFieldName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addComponent(textFieldAFP, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(50, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldRut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldIsapre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textFieldAFP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(28, Short.MAX_VALUE))
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
                okButton.addActionListener(e -> okButtonActionPerformed(e));
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
    private JLabel label2;
    private JTextField textFieldLastName;
    private JLabel label3;
    private JTextField textFieldRut;
    private JLabel label4;
    private JTextField textFieldName;
    private JTextField textFieldIsapre;
    private JLabel label5;
    private JLabel label6;
    private JTextField textFieldAFP;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
