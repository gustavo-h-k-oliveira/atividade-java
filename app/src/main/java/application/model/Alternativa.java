package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alternativas")
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String texto;

    @Column(unique = true, nullable = false)
    private boolean isCorreta;

    @Column(unique = true, nullable = false)
    private Questao questao;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean getIsCorreta() {
        return isCorreta;
    }

    public void setIsCorreta(boolean isCorreta) {
        this.isCorreta = isCorreta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}