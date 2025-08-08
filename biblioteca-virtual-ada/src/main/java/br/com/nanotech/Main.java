package br.com.nanotech;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.controller.CatalogoController;
import br.com.nanotech.controller.UsuarioController;
import br.com.nanotech.view.UsuarioView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        CatalogoController catalogoController = new CatalogoController();
        UsuarioView usuarioView = new UsuarioView(catalogoController, usuarioController);
        usuarioView.exibirMenuCliente();

    }
}