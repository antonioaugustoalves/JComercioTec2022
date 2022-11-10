
package br.com.jcomercio.entidades;

/**
 *
 * @author ANTONIO
 */
public class Fornecedor extends Pessoa{
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String webSite;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return this.id +" - "+this.razaoSocial;
    }

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocial, int id, String nome) {
        super(id, nome);
        this.razaoSocial = razaoSocial;
    }
    
    
    
    
}
