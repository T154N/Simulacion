package com.pedido_flex.wsPedidoFlex.Controller;

import com.pedido_flex.wsPedidoFlex.Exception.Response;
import com.pedido_flex.wsPedidoFlex.Model.Cliente;
import com.pedido_flex.wsPedidoFlex.Service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @GetMapping("/clientes/{id}")
    public Cliente  getClienteById(@PathVariable Long id) {

        return clienteService.findClienteById(id);
    }

    @GetMapping("/clientes")
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }


    @PutMapping("/clientes/baj/{id}/{u}")
    public Response bajaCliente(@PathVariable("id") Long id,@PathVariable("u") String usuarioEditor) {
        try {
            clienteService.setBajaClienteById(id,usuarioEditor);
            return Response.general(HttpStatus.OK, null);
        } catch (NullPointerException | IllegalArgumentException e) {
            return Response.custom(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return Response.custom(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }



//    @PutMapping("/clientes/{id}")
//    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, Cliente clienteDetalles) {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Cliente con el id: " + id + "no se encontro"));
//
//        cliente.setCliente_nombre(clienteDetalles.getCliente_nombre());
//        cliente.setCliente_email(clienteDetalles.getCliente_email());
//        cliente.setCliente_telefono(clienteDetalles.getCliente_telefono());
//        cliente.setCliente_estado_id(clienteDetalles.getCliente_estado_id());
//        cliente.setCliente_fecha_alta(clienteDetalles.getCliente_fecha_alta());
//        cliente.setCliente_fecha_modificacion(clienteDetalles.getCliente_fecha_modificacion());
//        cliente.setCliente_fecha_baja(clienteDetalles.getCliente_fecha_baja());
//        cliente.setCliente_usuario_alta(clienteDetalles.getCliente_usuario_alta());
//        cliente.setCliente_usuario_modificacion(clienteDetalles.getCliente_usuario_modificacion());
//        cliente.setCliente_usuario_baja(clienteDetalles.getCliente_usuario_baja());
//        cliente.setCliente_observaciones(clienteDetalles.getCliente_observaciones());
//
//        Cliente updatedCliente = clienteRepository.save(cliente);
//        return ResponseEntity.ok(updatedCliente);
//    }
//
//    @DeleteMapping("/clientes/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id) {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Cliente con el id: " + id + "no se encontro"));
//
//        clienteRepository.delete(cliente);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }

}
