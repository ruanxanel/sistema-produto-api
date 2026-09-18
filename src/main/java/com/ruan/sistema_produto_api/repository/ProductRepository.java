package com.ruan.sistema_produto_api.repository;

import com.ruan.sistema_produto_api.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByCodigoBarras(String codigoBarras);

    Optional<ProductEntity> findByCodigoBarras(String codigoBarras);

}
