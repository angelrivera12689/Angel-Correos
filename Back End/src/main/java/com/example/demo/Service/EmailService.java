package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
  @Autowired
    private JavaMailSender javaMailSender;

//cuenta nueva
    public void newAccountEmail(String addressMail) {
        String subject = "¡Bienvenido a nuestra plataforma!";
        String bodyMail = """
                <!DOCTYPE html>
              <html lang="es">
              <head>
                <meta charset="UTF-8">
                <style>
                  body {
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

                    background-size: cover;
                    margin: 0;
                    padding: 0;
                    color: #ffffff;
                  }
                  .email-container {
                    max-width: 700px;
                    margin: 50px auto;
                    background: rgba(0, 0, 0, 0.8);
                    border-radius: 15px;
                    overflow: hidden;
                    border: 2px solid #d4af37;
                    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.5);
                  }
                  .header {
                    background-color: #000000;
                    color: #d4af37;
                    padding: 40px;
                    text-align: center;
                    border-bottom: 2px solid #d4af37;
                  }
                  .header h1 {
                    margin: 0;
                    font-size: 28px;
                    text-transform: uppercase;
                    letter-spacing: 3px;
                  }
                  .content {
                    padding: 40px;
                    color: #f0e6d2;
                    text-align: center;
                    line-height: 1.8;
                  }
                  .button {
                    display: inline-block;
                    margin-top: 20px;
                    padding: 15px 30px;
                    background-color: #d4af37;
                    color: #000000;
                    text-decoration: none;
                    border-radius: 25px;
                    font-weight: bold;
                    font-size: 16px;
                    transition: background-color 0.3s ease, transform 0.2s ease;
                    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
                  }
                  .button:hover {
                    background-color: #b08b2e;
                    transform: scale(1.05);
                  }
                  .footer {
                    background-color: #1a1a1a;
                    padding: 25px;
                    text-align: center;
                    font-size: 14px;
                    color: #999999;
                    border-top: 2px solid #d4af37;
                  }
                  .footer a {
                    color: #d4af37;
                    text-decoration: none;
                  }
                  .footer a:hover {
                    text-decoration: underline;
                  }
                </style>
              </head>
              <body>
                <div class="email-container">
                  <div class="header">
                    <h1>¡Bienvenido a Angels Event!</h1>
                  </div>
                  <div class="content">
                    <h2>Hola</h2>
                    <p>¡Nos complace anunciar que eres nuevo integrante de esta familia! Prepárate para vivir una experiencia inolvidable llena de sorpresas y momentos únicos.</p>
                    <p>Reserva tu lugar y únete a nosotros en este evento especial.</p>
                    <a href="https://tusitioejemplo.com" class="button">Iniciar Sesion</a>
                  </div>
                  <div class="footer">
                    © 2025 Tu Empresa de Eventos. <a href="https://tusitioejemplo.com">Visita nuestro sitio web</a>.
                  </div>
                </div>
              </body>
              </html>
                """;
        try {
            emailSender(addressMail, subject, bodyMail);
        } catch (MessagingException e) {
            // Manejo de error
        }
        
    }

    public void ForgotPassword(String addressMail) {
        String subject = "Recupera tu contraseña";
        String bodyMail = """
                <!DOCTYPE html>
            <html lang="es">
            <head>
              <meta charset="UTF-8">
              <style>
                body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #000000, #434343);
      margin: 0;
      padding: 0;
      color: #ffffff;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: rgba(0, 0, 0, 0.9);
      border-radius: 10px;
      border: 2px solid #d4af37;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
      overflow: hidden;
    }
    .header {
      background-color: #000000;
      color: #d4af37;
      padding: 30px;
      text-align: center;
      border-bottom: 2px solid #d4af37;
    }
    .header h1 {
      margin: 0;
      font-size: 24px;
      text-transform: uppercase;
    }
    .content {
      padding: 30px;
      color: #f0e6d2;
      text-align: center;
      line-height: 1.6;
    }
    .button {
      display: inline-block;
      margin-top: 20px;
      padding: 12px 24px;
      background-color: #d4af37;
      color: #000000;
      text-decoration: none;
      border-radius: 5px;
      font-weight: bold;
      font-size: 16px;
      transition: background-color 0.3s ease, transform 0.2s ease;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    }
    .button:hover {
      background-color: #b08b2e;
      transform: scale(1.05);
    }
    .footer {
      background-color: #1a1a1a;
      padding: 20px;
      text-align: center;
      font-size: 12px;
      color: #999999;
      border-top: 2px solid #d4af37;
    }
    .footer a {
      color: #d4af37;
      text-decoration: none;
    }
    .footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>Recuperación de Contraseña</h1>
    </div>
    <div class="content">
      <h2>Hola </h2>
      <p>Hemos recibido una solicitud para restablecer tu contraseña.</p>
      <p>Haz clic en el siguiente enlace para restablecer tu contraseña:</p>
      <a href="https://tusitioejemplo.com/reset-password" class="button">Restablecer Contraseña</a>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. <a href="https://tusitioejemplo.com">Visita nuestro sitio web</a>.
    </div>
  </div>
</body>
</html>
            </html>
            """;
    try {
        emailSender(addressMail, subject, bodyMail);
    } catch (MessagingException e) {
        // Manejo de error
    }
}

    public void CodeEmail(String addressMail) {
        String subject = "Código de verificación";
        String bodyMail = """
               <!DOCTYPE html>
           <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #000000, #434343);
      margin: 0;
      padding: 0;
      color: #ffffff;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: rgba(0, 0, 0, 0.9);
      border-radius: 10px;
      border: 2px solid #d4af37;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
      overflow: hidden;
    }
    .header {
      background-color: #000000;
      color: #d4af37;
      padding: 30px;
      text-align: center;
      border-bottom: 2px solid #d4af37;
    }
    .header h1 {
      margin: 0;
      font-size: 24px;
      text-transform: uppercase;
    }
    .content {
      padding: 30px;
      color: #f0e6d2;
      text-align: center;
      line-height: 1.6;
    }
    .footer {
      background-color: #1a1a1a;
      padding: 20px;
      text-align: center;
      font-size: 12px;
      color: #999999;
      border-top: 2px solid #d4af37;
    }
    .footer a {
      color: #d4af37;
      text-decoration: none;
    }
    .footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>Código de Verificación</h1>
    </div>
    <div class="content">
      <h2>Hola </h2>
      <p>Por favor, ingresa el siguiente código para completar tu acción:</p>
      <h3>123456</h3>
      <p>Si no solicitaste este código, por favor ignora este mensaje.</p>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. Todos los derechos reservados.
    </div>
  </div>
</body>
</html>
            """;
    try {
        emailSender(addressMail, subject, bodyMail);
    } catch (MessagingException e) {
        // Manejo de error
    }
}

    public void ChangedPassword(String addressMail) {
        String subject = "Tu contraseña ha sido cambiada";
        String bodyMail = """
               <!DOCTYPE html>
           
<html lang="es">
<head>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #000000, #434343);
      margin: 0;
      padding: 0;
      color: #ffffff;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: rgba(0, 0, 0, 0.9);
      border-radius: 10px;
      border: 2px solid #d4af37;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
      overflow: hidden;
    }
    .header {
      background-color: #000000;
      color: #d4af37;
      padding: 30px;
      text-align: center;
      border-bottom: 2px solid #d4af37;
    }
    .header h1 {
      margin: 0;
      font-size: 24px;
      text-transform: uppercase;
    }
    .content {
      padding: 30px;
      color: #f0e6d2;
      text-align: center;
      line-height: 1.6;
    }
    .footer {
      background-color: #1a1a1a;
      padding: 20px;
      text-align: center;
      font-size: 12px;
      color: #999999;
      border-top: 2px solid #d4af37;
    }
    .footer a {
      color: #d4af37;
      text-decoration: none;
    }
    .footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>Código de Verificación</h1>
    </div>
    <div class="content">
      <h2>Hola </h2>
      <p>Por favor, ingresa el siguiente código para completar tu acción:</p>
      <h3>123456</h3>
      <p>Si no solicitaste este código, por favor ignora este mensaje.</p>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. Todos los derechos reservados.
    </div>
  </div>
</body>
</html>
            """;
    try {
        emailSender(addressMail, subject, bodyMail);
    } catch (MessagingException e) {
        // Manejo de error
    }
}
      public void stock(String addressMail) {
        String subject = "Actualización sobre la disponibilidad de productos";
        String bodyMail = """
             <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #000000, #434343);
      margin: 0;
      padding: 0;
      color: #ffffff;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: rgba(0, 0, 0, 0.9);
      border-radius: 10px;
      border: 2px solid #d4af37;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
      overflow: hidden;
    }
    .header {
      background-color: #000000;
      color: #d4af37;
      padding: 30px;
      text-align: center;
      border-bottom: 2px solid #d4af37;
    }
    .header h1 {
      margin: 0;
      font-size: 24px;
      text-transform: uppercase;
    }
    .content {
      padding: 30px;
      color: #f0e6d2;
      text-align: center;
      line-height: 1.6;
    }
    .button {
      display: inline-block;
      margin-top: 20px;
      padding: 12px 24px;
      background-color: #d4af37;
      color: #000000;
      text-decoration: none;
      border-radius: 5px;
      font-weight: bold;
      font-size: 16px;
      transition: background-color 0.3s ease, transform 0.2s ease;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    }
    .button:hover {
      background-color: #b08b2e;
      transform: scale(1.05);
    }
    .footer {
      background-color: #1a1a1a;
      padding: 20px;
      text-align: center;
      font-size: 12px;
      color: #999999;
      border-top: 2px solid #d4af37;
    }
    .footer a {
      color: #d4af37;
      text-decoration: none;
    }
    .footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>Actualización sobre el stock</h1>
    </div>
    <div class="content">
      <h2>¡Buenas noticias!</h2>
      <p>Uno de los productos que esperabas está disponible nuevamente en stock. No pierdas la oportunidad de comprarlo.</p>
      <a href="https://tusitioejemplo.com/producto" class="button">Ver producto</a>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. Todos los derechos reservados.
    </div>
  </div>
</body>
</html>
            """;
    try {
        emailSender(addressMail, subject, bodyMail);
    } catch (MessagingException e) {
        // Manejo de error
    }
}


public void shopping(String addressMail) {
    String subject = "¡Gracias por tu compra en nuestra plataforma!";
    String bodyMail = """
     <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #000000, #434343);
      margin: 0;
      padding: 0;
      color: #ffffff;
    }
    .email-container {
      max-width: 600px;
      margin: 40px auto;
      background: rgba(0, 0, 0, 0.9);
      border-radius: 10px;
      border: 2px solid #d4af37;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
      overflow: hidden;
    }
    .header {
      background-color: #000000;
      color: #d4af37;
      padding: 30px;
      text-align: center;
      border-bottom: 2px solid #d4af37;
    }
    .header h1 {
      margin: 0;
      font-size: 24px;
      text-transform: uppercase;
    }
    .content {
      padding: 30px;
      color: #f0e6d2;
      text-align: center;
      line-height: 1.6;
    }
    .product-list {
      margin-top: 20px;
      border-top: 2px solid #d4af37;
      padding-top: 20px;
    }
    .product-item {
      display: flex;
      align-items: center;
      justify-content: space-between;
      margin-bottom: 15px;
      padding: 10px;
      border: 1px solid #d4af37;
      border-radius: 5px;
      background-color: rgba(255, 215, 0, 0.1);
    }
    .product-item img {
      width: 50px;
      height: 50px;
      object-fit: cover;
      border-radius: 5px;
      margin-right: 15px; /* Adds space between image and text */
    }
    .product-item div {
      flex-grow: 1; /* Ensures the text section takes up remaining space */
      text-align: left; /* Aligns text to the left for better readability */
    }
    .product-item h3 {
      margin: 0 0 5px 0; /* Adds spacing below product name */
    }
    .product-item p {
      margin: 0;
    }
    .button {
      display: inline-block;
      margin-top: 20px;
      padding: 12px 24px;
      background-color: #d4af37;
      color: #000000;
      text-decoration: none;
      border-radius: 5px;
      font-weight: bold;
      font-size: 16px;
      transition: background-color 0.3s ease, transform 0.2s ease;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    }
    .button:hover {
      background-color: #b08b2e;
      transform: scale(1.05);
    }
    .footer {
      background-color: #1a1a1a;
      padding: 20px;
      text-align: center;
      font-size: 12px;
      color: #999999;
      border-top: 2px solid #d4af37;
    }
    .footer a {
      color: #d4af37;
      text-decoration: none;
    }
    .footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="email-container">
    <div class="header">
      <h1>¡Gracias por tu compra!</h1>
    </div>
    <div class="content">
      <h2>Hola 👋</h2>
      <p>¡Tu compra se ha realizado con éxito! A continuación, puedes ver los productos que adquiriste:</p>
      <div class="product-list">
        <div class="product-item">
          <img src="https://i.pinimg.com/236x/01/64/91/0164912efa45d6a18631881a56c2f8e8.jpg" alt="Producto A">
          <div>
            <h3>Producto A</h3>
            <p>Cantidad: 2</p>
          </div>
          <p>$15.00</p>
        </div>
        <div class="product-item">
          <img src="https://i.pinimg.com/236x/e9/bd/64/e9bd640aa7d6340cdcf85c60d874a9e0.jpg" alt="Producto B">
          <div>
            <h3>Producto B</h3>
            <p>Cantidad: 1</p>
          </div>
          <p>$30.00</p>
        </div>
        <div class="product-item">
          <img src="https://i.pinimg.com/236x/8d/70/a0/8d70a035cc878d5ebb79d463164673ea.jpg" alt="Producto C">
          <div>
            <h3>Producto C</h3>
            <p>Cantidad: 1</p>
          </div>
          <p>$22.50</p>
        </div>
      </div>
      <p><strong>Total: $67.50</strong></p>
      <p>Si tienes alguna pregunta o necesitas asistencia, no dudes en contactarnos.</p>
      <a href="https://tusitioejemplo.com/compras" class="button">Ver tus compras</a>
    </div>
    <div class="footer">
      © 2025 Tu Empresa. Todos los derechos reservados.
    </div>
  </div>
</body>
</html>
            """;
    try {
        emailSender(addressMail, subject, bodyMail);
    } catch (MessagingException e) {
        // Manejo de error
    }
}


    public boolean emailSender(String addressMail, String subject, String bodyMail) throws MessagingException {
        try {
            
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(addressMail);
            helper.setSubject(subject);
            helper.setText(bodyMail,true);

            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

