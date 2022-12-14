package com.api.rpgcharbuilder.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID gerado para identificação das Classes do RPG", required = true)
    private Long id;
    @ApiModelProperty(value = "Nome da Classe/Job do RPG como Guerreiro, Mago e Arqueiro", required = true)
    private String jobName;
    @ApiModelProperty(value = "Tipo de combate da Classe/Job, MELEE (Corpo a Corpo) ou RANGED (A Distancia), Influencia quais itens cada classe se sai melhor", required = true)
    @Enumerated(value = EnumType.STRING)
    private CombatType combatType;

    @ApiModelProperty(value = "Campo não preenchido por usuários, utilizado para que o mapemanto ManyToOne reconheça quais personagens são dessa classe")
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Char> char_id;

    public Job(){}

    public Job(Long id, String jobName, CombatType combatType) {
        this.id = id;
        this.jobName = jobName;
        this.combatType = combatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String classeName) {
        this.jobName = classeName;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public void setCombatType(CombatType combatType) {
        this.combatType = combatType;
    }

    public List<Char> getChar_id() {
        return char_id;
    }

    public void setChar_id(List<Char> char_id) {
        this.char_id = char_id;
    }
}
