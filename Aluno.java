/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Aluno {

    private String matricula;
    private String nome;
    private String dataNascimento;  // formato: dd/MM/yyyy
    private String telefone;
    private String cpf;

    

    public Aluno(String matricula, String nome, String dataNascimento, String telefone, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String toCSV() {
        return matricula + ", " + nome + " ;" + ";" + dataNascimento + "; " + telefone + ";" + cpf;
    }

    
    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    // Calcula a idade a partir da data de nascimento
    public String getIdade() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate nascimento = LocalDate.parse(dataNascimento, formatter);
            LocalDate hoje = LocalDate.now();
            int idade = Period.between(nascimento, hoje).getYears();
            return String.valueOf(idade);
        } catch (DateTimeParseException e) {
            return "Inválido";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Aluno aluno = (Aluno) obj;
        return matricula != null && matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return matricula != null ? matricula.hashCode() : 0;
    }

    // toString para imprimir todos os dados do aluno
    @Override
    public String toString() {
        return "Matrícula: " + matricula
                + ", Nome: " + nome
                + ", Data de Nascimento: " + dataNascimento
                + ", Idade: " + getIdade()
                + ", Telefone: " + telefone
                + ", CPF: " + cpf;
    }

    

    
    
    
    
    
    
    
    
    
    /**SALVA EM UM DOCUMENTO .TXT      INVALIDOOOOOOOOOOOOO
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
    }*/
}
