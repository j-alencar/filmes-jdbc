public class Filme {

    public Filme(){};

    private long id;
    private String titulo;
    private long ano;
    private String diretor;

    public Filme(long id, String titulo, long ano, String diretor){
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public long getAno() {
        return ano;
    }
    public void setAno(long ano) {
        this.ano = ano;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
                ", ano='" + ano + '\'' +
                ", diretor=" + diretor +
               '}';
    }
}
