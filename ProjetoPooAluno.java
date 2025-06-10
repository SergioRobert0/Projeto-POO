/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package trabalhopoo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class ProjetoPooAluno {
      public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();
        lista.add(new Aluno("001", "Luan", "10/03/2005", "99999-9999", "123.456.789-00"));
        lista.add(new Aluno("002", "Sergio", "05/07/2004", "88888-8888", "987.654.321-00"));

        System.out.println("Antes da remocao:");
for (Aluno a : lista) {
    System.out.println(
        "Nome: " + a.getNome() +
        ", Matricula: " + a.getMatricula() +
        ", Idade: " + a.getIdade() +
        ", CPF: " + a.getCpf() +
        ", Telefone: " + a.getTelefone()
    );
}
        Aluno alunoParaRemover = new Aluno("001", "", "", "", ""); // Só a matrícula importa
        AlunoDAO dao = new RemocaoAlunoDAO();
        dao.removerAluno(lista, alunoParaRemover);

       System.out.println("\nDepois da remocao:");
for (Aluno a : lista) {
    System.out.println(
        "Nome: " + a.getNome() +
        ", Matricula: " + a.getMatricula() +
        ", Idade: " + a.getIdade() +
        ", CPF: " + a.getCpf() +
        ", Telefone: " + a.getTelefone()
    );
}

    }
}
