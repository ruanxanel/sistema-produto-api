package com.ruan.sistema_produto_api.service;

import com.ruan.sistema_produto_api.dto.ProductRequest;
import com.ruan.sistema_produto_api.dto.ProductResponse;
import com.ruan.sistema_produto_api.dto.ProductUpdate;
import com.ruan.sistema_produto_api.exception.ProdutoJaCadastradoException;
import com.ruan.sistema_produto_api.exception.ProdutoNaoEncontradoException;
import com.ruan.sistema_produto_api.model.ProductEntity;
import com.ruan.sistema_produto_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    /*
    * cadastrarProduto()
    * listarProdutos()
    * buscarProdutoPorId()
    * atualizarProduto()
    * deletarProduto()*/

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse creatProduct(ProductRequest request) {

        if (productRepository.existsByCodigoBarras(request.getCodigoBarras())) {
            throw new ProdutoJaCadastradoException("Produto já cadastrado");
        }

        ProductEntity product = new ProductEntity();
        product.setNome(request.getNome());
        product.setDescricao(request.getDescricao());
        product.setMarca(request.getMarca());
        product.setCategoria(request.getCategoria());
        product.setPreco(request.getPreco());
        product.setEstoque(request.getEstoque());
        product.setUnidade(request.getUnidade());
        product.setPesoQtd(request.getPesoQtd());
        product.setCodigoBarras(request.getCodigoBarras());
        product.setValidade(request.getValidade());
        product.setAtivo(true);
        product.setDataCadastro(LocalDateTime.now());

        productRepository.save(product);

        return new ProductResponse(
                product.getId(),
                product.getNome(),
                product.getDescricao(),
                product.getMarca(),
                product.getCategoria(),
                product.getPreco(),
                product.getEstoque(),
                product.getUnidade(),
                product.getPesoQtd(),
                product.getCodigoBarras(),
                product.getValidade(),
                product.getAtivo(),
                product.getDataCadastro());
    }

    public List<ProductResponse> listProducts() {

        List<ProductEntity> products = productRepository.findAll();
        List<ProductResponse> responses = new ArrayList<>();

        for (ProductEntity product : products) {

            ProductResponse response = new ProductResponse(
                    product.getId(),
                    product.getNome(),
                    product.getDescricao(),
                    product.getMarca(),
                    product.getCategoria(),
                    product.getPreco(),
                    product.getEstoque(),
                    product.getUnidade(),
                    product.getPesoQtd(),
                    product.getCodigoBarras(),
                    product.getValidade(),
                    product.getAtivo(),
                    product.getDataCadastro()
            );
            responses.add(response);
        }
        return responses;
    }

    public ProductResponse searchById(Long id) {

        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }

        ProductEntity entity = product.get();

        return new ProductResponse(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getMarca(),
            entity.getCategoria(),
            entity.getPreco(),
            entity.getEstoque(),
            entity.getUnidade(),
            entity.getPesoQtd(),
            entity.getCodigoBarras(),
            entity.getValidade(),
            entity.getAtivo(),
            entity.getDataCadastro()
        );
    }

    public ProductResponse updateProduct(Long id, ProductUpdate request) {

        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }

        ProductEntity entity = product.get();
        entity.setNome(request.getNome());
        entity.setDescricao(request.getDescricao());
        entity.setMarca(request.getMarca());
        entity.setCategoria(request.getCategoria());
        entity.setPreco(request.getPreco());
        entity.setEstoque(request.getEstoque());
        entity.setUnidade(request.getUnidade());
        entity.setPesoQtd(request.getPesoQtd());
        entity.setValidade(request.getValidade());
        entity.setAtivo(request.getAtivo());

        productRepository.save(entity);

        return new ProductResponse(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getMarca(),
                entity.getCategoria(),
                entity.getPreco(),
                entity.getEstoque(),
                entity.getUnidade(),
                entity.getPesoQtd(),
                entity.getCodigoBarras(),
                entity.getValidade(),
                entity.getAtivo(),
                entity.getDataCadastro()
        );
    }
    public void deleteProduct(Long id) {

        Optional<ProductEntity> product = productRepository.findById(id);

        if(product.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }

        productRepository.deleteById(id);
    }
}
