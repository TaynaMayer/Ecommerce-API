package br.com.serratec.dto;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.serratec.model.Endereco;
import io.swagger.annotations.ApiModelProperty;

public class EnderecoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco; 

    @ApiModelProperty(value = "Identificador de uma rua ")
    private String cep;
    
    @ApiModelProperty(value = "Identifica uma rua")
    private String logradouro;

    private String bairro;
    
    @ApiModelProperty(value = "Identifica a cidade")
    private String localidade;
    
    @ApiModelProperty(value = "Identifica o estado")
    private String uf;   

    public EnderecoDTO() {

    }

    public EnderecoDTO(Endereco endereco) {
        super();
        
        this.idEndereco = endereco.getIdEndereco();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        
        this.uf = endereco.getUf();
        

    }
    
    

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    

}
