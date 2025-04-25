package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Endpoint para enviar correo de cuenta nueva
    @GetMapping("/sendNewAccountEmail/{email}")
    public ResponseEntity<String> sendNewAccountEmail(@PathVariable String email) {
        try {
            emailService.newAccountEmail(email);
            return ResponseEntity.ok("🎉 ¡Correo de cuenta nueva enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo de cuenta nueva: " + e.getMessage());
        }
    }

    // Endpoint para enviar correo de contraseña olvidada
    @GetMapping("/sendForgotPassword/{email}")
    public ResponseEntity<String> sendForgotPassword(@PathVariable String email) {
        try {
            emailService.ForgotPassword(email);
            return ResponseEntity.ok("🎉 ¡Correo de recuperación de contraseña enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo de recuperación de contraseña: " + e.getMessage());
        }
    }

    // Endpoint para enviar correo con código de verificación
    @GetMapping("/sendCodeEmail/{email}")
    public ResponseEntity<String> sendCodeEmail(@PathVariable String email) {
        try {
            emailService.CodeEmail(email);
            return ResponseEntity.ok("🎉 ¡Correo con código de verificación enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo con código de verificación: " + e.getMessage());
        }
    }

    // Endpoint para enviar correo de cambio de contraseña
    @GetMapping("/sendChangedPassword/{email}")
    public ResponseEntity<String> sendChangedPassword(@PathVariable String email) {
        try {
            emailService.ChangedPassword(email);
            return ResponseEntity.ok("🎉 ¡Correo de cambio de contraseña enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo de cambio de contraseña: " + e.getMessage());
        }
    }

    // Endpoint para enviar correo de actualización de stock
    @GetMapping("/sendStockEmail/{email}")
    public ResponseEntity<String> sendStockEmail(@PathVariable String email) {
        try {
            emailService.stock(email);
            return ResponseEntity.ok("🎉 ¡Correo de actualización de stock enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo de actualización de stock: " + e.getMessage());
        }
    }

    // Endpoint para enviar correo de confirmación de compra
    @GetMapping("/sendShoppingEmail/{email}")
    public ResponseEntity<String> sendShoppingEmail(@PathVariable String email) {
        try {
            emailService.shopping(email);
            return ResponseEntity.ok("🎉 ¡Correo de confirmación de compra enviado con éxito!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("❌ Error al enviar el correo de confirmación de compra: " + e.getMessage());
        }
    }
}
