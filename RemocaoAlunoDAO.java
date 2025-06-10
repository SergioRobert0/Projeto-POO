/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.Iterator;
import java.util.List;

public class RemocaoAlunoDAO implements AlunoDAO {
    
 @Override
    public List removerAluno(List alunos, Aluno a) {
        Iterator it = alunos.iterator();
        while (it.hasNext()) {
            Aluno atual = (Aluno) it.next();
            if (atual.getMatricula().equals(a.getMatricula())) {
                it.remove();
                break;
            }
        }
        return alunos;
    }
    
}
