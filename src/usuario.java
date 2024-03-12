public class usuario {

    private String nome;
    private long id = 0;

    private static long proximoID = 1;

    public usuario(String nome) {
        this.nome = nome;
        this.id = proximoID;
        proximoID++; // Adiciona +1 sempre que um usuário ou afiliado novo for criado
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}