/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoofinal;
/**
 *
 * @author sergi
 */
import javax.swing.*;
import java.awt.*;

/**
 * Janela modal para entrada da matrícula do aluno.
 * Usa um callback para retornar o valor digitado.
 */
public class JanelaBuscaMatricula extends JDialog {
    private JTextField campoMatricula;
    private JButton botaoConfirmar;

    // Construtor da janela de busca
    
    public JanelaBuscaMatricula(Frame parent, java.util.function.Consumer<String> callback) {
        super(parent, "Buscar Aluno", true); // Janela modal (bloqueia a principal até fechar)
        setSize(300, 130); // Tamanho da janela
        setLocationRelativeTo(parent); // Centraliza na tela principal
        setLayout(null); // Usaremos posicionamento absoluto

        // Rótulo "Digite a matrícula"
        JLabel label = new JLabel("Digite a matrícula:");
        label.setBounds(10, 10, 150, 20);
        add(label);

        // Campo de texto para matrícula
        campoMatricula = new JTextField();
        campoMatricula.setBounds(10, 35, 260, 25);
        add(campoMatricula);

        // Botão de confirmar/buscar
        botaoConfirmar = new JButton("Buscar");
        botaoConfirmar.setBounds(170, 70, 100, 25);
        add(botaoConfirmar);

        // Ação do botão: executa o callback com a matrícula digitada
        botaoConfirmar.addActionListener(e -> {
            String matricula = campoMatricula.getText().trim(); // Remove espaços
            callback.accept(matricula); // Chama a função de retorno
            dispose(); // Fecha a janelinha
        });
    }
}

