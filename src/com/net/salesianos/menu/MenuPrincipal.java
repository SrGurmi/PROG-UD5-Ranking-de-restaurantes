package com.net.salesianos.menu;
import javax.swing.*;

import com.net.salesianos.menu.manager.RestauranteManager;
import com.net.salesianos.menu.restaurante.Restaurante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private RestauranteManager restauranteManager;

    public MenuPrincipal(RestauranteManager restauranteManager) {
        this.restauranteManager = restauranteManager;
    }

    public void mostrarMenu() {
        JFrame frame = new JFrame("Gestor de Restaurantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton agregarBtn = new JButton("Agregar Restaurante");
        JButton editarBtn = new JButton("Editar Restaurante");
        JButton mostrarBtn = new JButton("Mostrar Restaurantes");
        JButton eliminarBtn = new JButton("Eliminar Restaurante");
        JButton salirBtn = new JButton("Salir");

        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioAgregarRestaurante();
            }
        });

        editarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioEditarRestaurante();
            }
        });

        mostrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaRestaurantes();
            }
        });

        eliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioEliminarRestaurante();
            }
        });

        salirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(agregarBtn);
        panel.add(editarBtn);
        panel.add(mostrarBtn);
        panel.add(eliminarBtn);
        panel.add(salirBtn);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void mostrarFormularioAgregarRestaurante() {
        JTextField nombreField = new JTextField(20);
        JTextField localizacionField = new JTextField(20);
        JTextField horarioField = new JTextField(20);
        JTextField puntuacionField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Localización:"));
        myPanel.add(localizacionField);
        myPanel.add(new JLabel("Horario:"));
        myPanel.add(horarioField);
        myPanel.add(new JLabel("Puntuación:"));
        myPanel.add(puntuacionField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Ingrese los datos del restaurante", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nombre = nombreField.getText();
                String localizacion = localizacionField.getText();
                String horario = horarioField.getText();
                int puntuacion = Integer.parseInt(puntuacionField.getText());

                Restaurante restaurante = new Restaurante(nombre, localizacion, horario, puntuacion);
                restauranteManager.agregarRestaurante(restaurante);
                JOptionPane.showMessageDialog(null, "Restaurante agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: La puntuación debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarFormularioEditarRestaurante() {
        JComboBox<String> restaurantesCombo = new JComboBox<>();
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            restaurantesCombo.addItem(restaurante.getNombre());
        }

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Seleccione restaurante a editar:"));
        myPanel.add(restaurantesCombo);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Seleccione restaurante a editar", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = restaurantesCombo.getSelectedIndex();
            if (selectedIndex != -1) {
                Restaurante restaurante = restauranteManager.getRestaurantes().get(selectedIndex);

                JTextField nombreField = new JTextField(restaurante.getNombre(), 20);
                JTextField localizacionField = new JTextField(restaurante.getLocalizacion(), 20);
                JTextField horarioField = new JTextField(restaurante.getHorario(), 20);
                JTextField puntuacionField = new JTextField(String.valueOf(restaurante.getPuntuacion()), 5);

                JPanel editPanel = new JPanel();
                editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
                editPanel.add(new JLabel("Nombre:"));
                editPanel.add(nombreField);
                editPanel.add(new JLabel("Localización:"));
                editPanel.add(localizacionField);
                editPanel.add(new JLabel("Horario:"));
                editPanel.add(horarioField);
                editPanel.add(new JLabel("Puntuación:"));
                editPanel.add(puntuacionField);

                int editResult = JOptionPane.showConfirmDialog(null, editPanel,
                        "Editar restaurante", JOptionPane.OK_CANCEL_OPTION);

                if (editResult == JOptionPane.OK_OPTION) {
                    try {
                        String nombre = nombreField.getText();
                        String localizacion = localizacionField.getText();
                        String horario = horarioField.getText();
                        int puntuacion = Integer.parseInt(puntuacionField.getText());

                        restaurante.setNombre(nombre);
                        restaurante.setLocalizacion(localizacion);
                        restaurante.setHorario(horario);
                        restaurante.setPuntuacion(puntuacion);

                        JOptionPane.showMessageDialog(null, "Restaurante editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: La puntuación debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un restaurante para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarListaRestaurantes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Restaurantes:\n");
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            sb.append(restaurante.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Restaurantes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarFormularioEliminarRestaurante() {
        JComboBox<String> restaurantesCombo = new JComboBox<>();
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            restaurantesCombo.addItem(restaurante.getNombre());
        }

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Seleccione restaurante a eliminar:"));
        myPanel.add(restaurantesCombo);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Seleccione restaurante a eliminar", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = restaurantesCombo.getSelectedIndex();
            if (selectedIndex != -1) {
                restauranteManager.getRestaurantes().remove(selectedIndex);
                JOptionPane.showMessageDialog(null, "Restaurante eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un restaurante para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        RestauranteManager manager = new RestauranteManager();
        MenuPrincipal menu = new MenuPrincipal(manager);
        menu.mostrarMenu();
    }
}
