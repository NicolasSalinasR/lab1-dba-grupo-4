<template>
    <footer class="footer">
      <div class="container">
        <div class="column">
          <div class="footer-section">
            <h3>Información de contacto</h3>
            <p>Dirección: Calle Principal 123, Ciudad</p>
            <p>Teléfono: 123-456-789</p>
            <p>Email: info@example.com</p>
          </div>
        </div>
        <div class="column">
          <div class="footer-section">
            <h3>Enlaces útiles</h3>
            <ul>
              <li><a href="#">Inicio</a></li>
              <li><a href="#">Servicios</a></li>
              <li><a href="#">Acerca de nosotros</a></li>
              <li><a href="#">Contacto</a></li>
            </ul>
          </div>
        </div>
        <div class="column">
          <div class="footer-section">
            <h3>Otra sección</h3>
            <p>Contenido de la tercera columna del footer.</p>
          </div>
        </div>
      </div>
    </footer>
  </template>
  
  <style scoped>
  .footer {
    background-color: #565555;
    color: #fff;
    padding: 2px 0;
    
  }
  
  .container {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    flex-wrap: wrap;
  }
  
  .column {
    flex-basis: 30%; /* Ajusta el ancho de las columnas según sea necesario */
  }
  
  .footer-section {
    margin-bottom: 1px;
  }
  
  .footer h3 {
    color: #fff;
  }
  
  .footer p {
    margin-bottom: 5px;
  }
  
  .footer ul {
    list-style: none;
    padding: 0;
  }
  
  .footer ul li {
    margin-bottom: 5px;
  }
  
  .footer ul li a {
    color: #fff;
    text-decoration: none;
  }
  
  .footer ul li a:hover {
    text-decoration: underline;
  }
  </style>
  