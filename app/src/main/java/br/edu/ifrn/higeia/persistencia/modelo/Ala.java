package br.edu.ifrn.higeia.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "alas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    @Column( name = "descricao", nullable = false, unique = true, length = 180)
    private String descricao;

    @Min(value = 1, message = "O número de leitos deve ser maior que zero")
    private int numeroLeitos;

}
