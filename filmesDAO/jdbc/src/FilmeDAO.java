import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends BaseDAO{

    private final static String CRIAR_TABELA_FILME = """
            create table IF NOT EXISTS Filmes(
                                 id INTEGER PRIMARY KEY,
                                 titulo TEXT,
                                ano INTEGER,
                                diretor TEXT
                                  );
            """;

    public void criarTabelaFilmes(){
        try(var con = conexao();
            var stat = con.createStatement()){
            stat.execute(CRIAR_TABELA_FILME);
            System.out.println("Tabela criada!");
        }catch (SQLException e){
            System.out.println("Erro ao criar tabela.");
            e.printStackTrace();
        }
    }

    public void inserir(Filme f){
        String inserir = """
                    insert into Filmes values(?, ?, ?, ?);
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(inserir)){
            stat.setLong(1,f.getId());
            stat.setString(2,f.getTitulo());
            stat.setLong(3,f.getAno());
            stat.setString(4,f.getDiretor());
            stat.execute();
            System.out.println("Filme inserido!");
        }catch (SQLException e){
            System.out.println("Erro ao inserir filme.");
            e.printStackTrace();
        }
    }
    public void atualizar(Filme f){
        String sql = """
                    update Filmes set titulo = ? where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setString(1,f.getTitulo());
            stat.setLong(2,f.getId());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar filme.");
            e.printStackTrace();
        }
    }
    
    public void deletar(long id){
        String sql = """
                    delete from Filmes where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setLong(1,id);
            stat.execute();
            System.out.println("Filme deletado!");
        }catch (SQLException e){
            System.out.println("Erro ao deletar o filme.");
            e.printStackTrace();
        }
    }

    public List<Filme> obterPorDiretor(String diretor){
        List<Filme> lista = new ArrayList<>();
        String sql = """
                    select id, titulo, ano, diretor from Filmes where diretor LIKE ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setString(1,diretor);
            stat.execute();
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Filme filme = new Filme();
                filme.setId(rs.getLong("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getLong("ano"));
                filme.setDiretor(rs.getString("diretor"));
                lista.add(filme);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar filmes.");
            e.printStackTrace();
        }
        return lista;
    }
}
