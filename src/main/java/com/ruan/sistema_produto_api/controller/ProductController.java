package com.ruan.sistema_produto_api.controller;

import com.ruan.sistema_produto_api.dto.ProductRequest;
import com.ruan.sistema_produto_api.dto.ProductResponse;
import com.ruan.sistema_produto_api.dto.ProductUpdate;
import com.ruan.sistema_produto_api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse criarProduto(@Valid @RequestBody ProductRequest request) {
        return productService.creatProduct(request);
    }

    @GetMapping
    public List<ProductResponse> listarProdutos() {
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse buscarProduto(@PathVariable Long id) {
        return productService.searchById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse atualizarProduto(@PathVariable Long id,
                                            @Valid @RequestBody ProductUpdate request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Produto deletado com sucesso";
    }
}
