package com;
import javax.swing.*;
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
        // Implementa aquí la lógica para mostrar un formulario de agregar restaurante
        // Puedes usar JOptionPane u otro componente Swing para recolectar la información
    }

    private void mostrarFormularioEditarRestaurante() {
        // Implementa aquí la lógica para mostrar un formulario de editar restaurante
        // Puedes usar JOptionPane u otro componente Swing para recolectar la información
    }

    private void mostrarListaRestaurantes() {
        restauranteManager.mostrarRestaurantes();
    }

    private void mostrarFormularioEliminarRestaurante() {
        // Implementa aquí la lógica para mostrar un formulario de eliminar restaurante
        // Puedes usar JOptionPane u otro componente Swing para recolectar la información
    }

    public static void main(String[] args) {
        RestauranteManager manager = new RestauranteManager();
        MenuPrincipal menu = new MenuPrincipal(manager);
        menu.mostrarMenu();
    }
}


