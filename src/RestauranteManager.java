import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RestauranteManager {
    private List<Restaurante> restaurantes;

    public RestauranteManager() {
        this.restaurantes = new ArrayList<>();
    }

    public void agregarRestaurante(String nombre, String localizacion, String horario, int puntuacion) {
        Restaurante restaurante = new Restaurante(nombre, localizacion, horario, puntuacion);
        restaurantes.add(restaurante);
        JOptionPane.showMessageDialog(null, "Restaurante agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarRestaurantes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Restaurantes:\n");
        for (Restaurante restaurante : restaurantes) {
            sb.append(restaurante.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Restaurantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void editarRestaurante(int indice, String nombre, String localizacion, String horario, int puntuacion) {
        if (indice >= 0 && indice < restaurantes.size()) {
            Restaurante restaurante = restaurantes.get(indice);
            restaurante.setNombre(nombre);
            restaurante.setLocalizacion(localizacion);
            restaurante.setHorario(horario);
            restaurante.setPuntuacion(puntuacion);
            JOptionPane.showMessageDialog(null, "Restaurante editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Índice de restaurante inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRestaurante(int indice) {
        if (indice >= 0 && indice < restaurantes.size()) {
            restaurantes.remove(indice);
            JOptionPane.showMessageDialog(null, "Restaurante eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Índice de restaurante inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }
}
