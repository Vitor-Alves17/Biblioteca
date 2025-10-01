public class Livro implements Imprestavel{
    private int codigo;
    private String titulo;
    private String autor;
    private boolean status;

    public Livro(int codigo, String titulo, String autor, boolean status) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    public Livro(String titulo, String autor, boolean status) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    @Override
    public void emprestar(){
        status = false;
    }
    public void devolver(){
        status = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
