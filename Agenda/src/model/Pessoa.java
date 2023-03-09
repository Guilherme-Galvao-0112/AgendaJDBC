package model;

import java.util.Date;
import javax.naming.SizeLimitExceededException;

public class Pessoa {
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Float altura;
    private Float peso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) throws SizeLimitExceededException {
        
        if(peso>0)
            this.peso = peso;
        if(peso>200)
           throw new SizeLimitExceededException("muito peso");
        
    }
    public Pessoa(){
        peso=0f;
    }

    
    
       
}
