package br.com.nanotech.view;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.controller.CatalogoController;
import br.com.nanotech.controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {

    private static final Scanner in = new Scanner(System.in);
    private CatalogoController catalogoController = new CatalogoController();

    public UsuarioView(CatalogoController catalogoController) {
        this.catalogoController = catalogoController;
    }

    public void exibirMenuCliente() {
        
    }

    private void fazerLogin() {
    }

    private void cadastrarUsuario() {
    }
}
