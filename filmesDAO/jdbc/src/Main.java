import java.sql.*;

public class Main {
    public static void main(String[] args) {

        FilmeDAO filmeDAO = new FilmeDAO();

        filmeDAO.criarTabelaFilmes();

        Filme f1 = new Filme(0, "Um Dia de Cão", 1975, "Sidney Lumet");
        Filme f2 = new Filme(1, "Fogo contra Fogo", 1996, "Michael Mann");
        Filme f3 = new Filme(2, "Os Bons Companheiros", 1990, "Martin Scorcese");
        Filme f4 = new Filme(4, "Os Infiltrados", 2006, "Martin Scorcese");
        Filme f5 = new Filme(5, "O Irlandês", 2019, "Martin Scorcese");

        filmeDAO.inserir(f1);
        filmeDAO.inserir(f3);
        filmeDAO.inserir(f2);
        filmeDAO.inserir(f4);
        filmeDAO.inserir(f5);

        f3.setTitulo("Goodfellas");
        filmeDAO.atualizar(f3);

        filmeDAO.deletar(5);

        for (Filme f : filmeDAO.obterPorDiretor("Martin Scorcese")) {
          System.out.println(f);
            }
        }
    }