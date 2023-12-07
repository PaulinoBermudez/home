package principal;

import controlador.ControladorVistaCliente;
import dao.ClienteDao;
import vista.VistaCliente;

public class Principal {

    public static void main(String[] args) {

        VistaCliente vistaC = new VistaCliente();
        ClienteDao clienteDao = new ClienteDao();
        ControladorVistaCliente controladorVC = new ControladorVistaCliente(vistaC, clienteDao);

        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
    }
}
