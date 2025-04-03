package com.gustavuhh1.POA.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public String criarPedido(String produto, int quantidadeProduto){
        return "Pedido criado: "+ quantidadeProduto + "x"+ produto;
    }

    public String cancelarPedido(Long pedidoId){
        return "Pedido cancelado: "+ pedidoId;
    }
}
