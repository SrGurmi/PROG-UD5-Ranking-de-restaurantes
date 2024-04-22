package com.net.salesianos.menu;


import javax.swing.*;
import com.net.salesianos.menu.manager.RestauranteManager;
import com.net.salesianos.menu.restaurante.Restaurante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class for the restaurant management application
public class MenuPrincipal {
    // Manager for handling restaurant operations
    private RestauranteManager restauranteManager;

    // Constructor
    public MenuPrincipal(RestauranteManager restauranteManager) {
        this.restauranteManager = restauranteManager;
    }

    // Method to display the main menu
    public void mostrarMenu() {
        // Create a new frame
        JFrame frame = new JFrame("Gestor de Restaurantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel with a grid layout
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        // Create buttons for each operation
        JButton agregarBtn = new JButton("1. Agregar Restaurante");
        JButton editarBtn = new JButton("2. Editar Restaurante");
        JButton mostrarBtn = new JButton("3. Mostrar Restaurantes");
        JButton eliminarBtn = new JButton("4. Eliminar Restaurante");
        JButton salirBtn = new JButton("Q. Salir");

        // Add action listeners to each button
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

        // Add buttons to the panel
        panel.add(agregarBtn);
        panel.add(editarBtn);
        panel.add(mostrarBtn);
        panel.add(eliminarBtn);
        panel.add(salirBtn);

        // Add panel to the frame and make it visible
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // Method to display the form for adding a restaurant
    private void mostrarFormularioAgregarRestaurante() {
        // Create text fields for each attribute
        JTextField nombreField = new JTextField(20);
        JTextField localizacionField = new JTextField(20);
        JTextField horarioField = new JTextField(20);
        JTextField puntuacionField = new JTextField(5);

        // Create a panel and add the text fields to it
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

        // Show the panel in a dialog
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Ingrese los datos del restaurante", JOptionPane.OK_CANCEL_OPTION);

        // If the user clicked OK, create a new restaurant and add it to the manager
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

    // Method to display the form for editing a restaurant
    private void mostrarFormularioEditarRestaurante() {
        // Create a combo box and populate it with the names of the restaurants
        JComboBox<String> restaurantesCombo = new JComboBox<>();
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            restaurantesCombo.addItem(restaurante.getNombre());
        }

        // Create a panel and add the combo box to it
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Seleccione restaurante a editar:"));
        myPanel.add(restaurantesCombo);

        // Show the panel in a dialog
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Seleccione restaurante a editar", JOptionPane.OK_CANCEL_OPTION);

        // If the user clicked OK, get the selected restaurant and show a form for editing it
        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = restaurantesCombo.getSelectedIndex();
            if (selectedIndex != -1) {
                Restaurante restaurante = restauranteManager.getRestaurantes().get(selectedIndex);

                // Create text fields for each attribute, pre-filled with the current values
                JTextField nombreField = new JTextField(restaurante.getNombre(), 20);
                JTextField localizacionField = new JTextField(restaurante.getLocalizacion(), 20);
                JTextField horarioField = new JTextField(restaurante.getHorario(), 20);
                JTextField puntuacionField = new JTextField(String.valueOf(restaurante.getPuntuacion()), 5);

                // Create a panel and add the text fields to it
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

                // Show the panel in a dialog
                int editResult = JOptionPane.showConfirmDialog(null, editPanel,
                        "Editar restaurante", JOptionPane.OK_CANCEL_OPTION);

                // If the user clicked OK, update the restaurant's attributes
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

    // Method to display a list of all restaurants
    private void mostrarListaRestaurantes() {
        // Create a string builder and append each restaurant to it
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Restaurantes:\n");
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            sb.append(restaurante.toString()).append("\n");
        }
        // Show the list in a dialog
        JOptionPane.showMessageDialog(null, sb.toString(), "Restaurantes", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display the form for deleting a restaurant
    private void mostrarFormularioEliminarRestaurante() {
        // Create a combo box and populate it with the names of the restaurants
        JComboBox<String> restaurantesCombo = new JComboBox<>();
        for (Restaurante restaurante : restauranteManager.getRestaurantes()) {
            restaurantesCombo.addItem(restaurante.getNombre());
        }

        // Create a panel and add the combo box to it
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Seleccione restaurante a eliminar:"));
        myPanel.add(restaurantesCombo);

        // Show the panel in a dialog
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Seleccione restaurante a eliminar", JOptionPane.OK_CANCEL_OPTION);

        // If the user clicked OK, delete the selected restaurant
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

    // Main method
    public static void main(String[] args) {
        // Create a new manager and menu, and show the menu
        RestauranteManager manager = new RestauranteManager();
        MenuPrincipal menu = new MenuPrincipal(manager);
        menu.mostrarMenu();
    }
}

