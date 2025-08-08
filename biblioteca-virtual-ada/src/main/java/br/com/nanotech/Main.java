package br.com.nanotech;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.controller.CatalogoController;
import br.com.nanotech.controller.UsuarioController;
import br.com.nanotech.view.UsuarioView;


public class Main {
    public static void main(String[] args) {
        CatalogoController catalogoController = new CatalogoController();
        UsuarioController usuarioController = new UsuarioController(); // único e compartilhado
        BibliotecaController bibliotecaController = new BibliotecaController(catalogoController);

        UsuarioView usuarioView = new UsuarioView(catalogoController, usuarioController, bibliotecaController);
        usuarioView.exibirMenuCliente();
    }
}