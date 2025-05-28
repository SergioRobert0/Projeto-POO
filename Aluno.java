/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoofinal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author sergi
 */
public class Aluno {
    private String matricula;
    private String nome;
    private String dataNascimento;  //formato:dd/MM/aaaa
    private String telefone;
    private String cpf;
    private String Idade;
    
    public Aluno(String matricula, String nome, String dataNascimento, String telefone, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    // Getters
    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getDataNascimento() { return dataNascimento; }
    public String getTelefone() { return telefone; }
    public String getCpf() { return cpf; }
    
    /**
     *
     * @return
     */
    public String getIdade(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/aaaa");
            LocalDate nascimento = LocalDate.parse(dataNascimento, formatter);
            LocalDate hoje = LocalDate.now();
            int idade = Period.between(nascimento, hoje).getYears();
            return String.valueOf(idade);
        }catch(Exception e){
            return "Invalido";
        }
    }
    
    //Calcula a idade a partir do ano
    public String getIdadeString(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate nascimento = LocalDate.parse(dataNascimento,formatter);
            
            LocalDate hoje = LocalDate.now();
            int idade = Period.between(nascimento,hoje).getYears();
            
            return String.valueOf(idade);
            
        }catch(DateTimeParseException e){
            return "Invalido";
        }
    }
    
    //SALVA EM UM DOCUMENTO .TXT 
    public String salvar(){
        
        try{
        
        FileWriter fw = new FileWriter("Aluno Cadastrado.txt");
        PrintWriter pw  = new PrintWriter(fw);
        pw.println("Matricula: "+this.matricula);
        pw.println("Nome: "+this.nome);
        pw.println("Data de Nascimento: "+this.dataNascimento);
        pw.println("Idade: "+getIdadeString());
        pw.println("Telefone: "+this.telefone);
        pw.println("Cpf: "+this.cpf);
        pw.flush();
        pw.close();
        fw.close();
        }catch(IOException ex){
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}

