package com.ruan.sistema_produto_api.dto;

import com.ruan.sistema_produto_api.enums.Categoria;
import com.ruan.sistema_produto_api.enums.Unidade;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class ProductUpdate {

    @NotBlank(message = "O nome é obrigatorio")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    private String descricao;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    @NotNull(message = "O preço é obrigatorio")
    @Digits(
            integer = 10,
            fraction = 2,
            message = "O preço deve ter no maximo 2 casas decimais"
    )
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "A quantidade em estoque é obrigatoria")
    @PositiveOrZero(message = "O estoque não pode ser negativo")
    private Integer estoque;

    @NotNull(message = "A unidade é obrigatória")
    private Unidade unidade;

    @NotNull(message = "O peso/quantidade é obrigatório")
    @Positive(message = "O peso/quantidade deve ser maior que zero")
    private BigDecimal pesoQtd;

    @NotNull(message = "A validade é obrigatória")
    @FutureOrPresent(message = "A validade não pode estar no passado")
    private LocalDate validade;

    @NotNull(message = "O status ativo é obrigatorio")
    private Boolean ativo;
}
