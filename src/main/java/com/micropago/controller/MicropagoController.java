package com.micropago.controller;

import com.micropago.model.Pago;
import com.micropago.model.Usuario;
import com.micropago.repository.PagoRepository;
import com.micropago.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MicropagoController {

    private final UsuarioRepository usuarioRepository;
    private final PagoRepository pagoRepository;

    public MicropagoController(UsuarioRepository usuarioRepository, PagoRepository pagoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pagoRepository = pagoRepository;
    }

    // ================== USUARIOS ==================
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // ================== PAGOS ==================
    @GetMapping("/pagos")
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @PostMapping("/pagos")
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }
}
