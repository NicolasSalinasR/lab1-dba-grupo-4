<!-- <template>
  <div>
    <div>
      <div class="more" @click="$router.push(/login);" >Ver más</div>
    </div>
    <ul>
      <li>
        <NuxtLink to="/componentep">Holaaa</NuxtLink>
      </li>
    </ul>
  </div>
</template> -->

<template>

<main>
        <div id="circle">
            <div class="circle"></div>
        </div>

        <img src="../images/mundo.svg" alt="mundo">
        <div class="containerLogin">
          <div class="rectangle">
            <p class="app-name">{{ appName }}</p>
          </div>
          <div class="rectangle2">
            <div class="content">
              <p>{{ texto }}</p>
            </div>
          </div>

          <div class="more"  @click="$router.push(`/login`);" 
            >Iniciar Sesión
          </div>

          <div class="more1"  @click="$router.push(`/register`);" 
            >Registrarse
          </div>
        </div>
    </main>
</template>

<script>
export default {
  data() {
    return {
      appName: "Nombre Fabuloso",
      texto: "¡Únete a la fuerza del voluntariado en emergencias! Nuestra plataforma te conecta con oportunidades para marcar la diferencia cuando más se necesita. Coordinar esfuerzos, asignar tareas y mantener el progreso bajo control: todo en un solo lugar. ¡Haz tu parte y ayuda a construir un mundo más resiliente hoy mismo!"
    };
  }
};
</script>

<style>
body {
    background-color: black;
    color: white;
    margin: 0;

}

img {
    width: 100%;
    height: 100vh;
    position: absolute;
    z-index: -10;
    filter: brightness(0.4);
    object-fit: cover;

}

.containerLogin {
    /* background-color: white; */
    width: 100%;
    height: 90vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    font-family: 'Roboto', sans-serif;
}

.formLogin {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 10px;
}

form input {
    width: 20vh;
    height: 10px;
    border: none;
    border-bottom: 1px solid white;
    background-color: black;
    color: white;
    border-radius: 0px;
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 5px;
}

form input:focus {
    outline: none;
    border-bottom: 1px solid #347355;
}

::placeholder {
    color: white;
}

form button {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 20vh;
    height: 30px;
    border: 1px solid #60BF81;
    border-radius: 5px;
    padding: 10px;
    background-color: black;
    cursor: pointer;
    font-family: 'Roboto', sans-serif;
    transition: all 0.3s;
    color: #60BF81;
    margin-top: 15px;
}

form button:hover {
    background-color: #005C53;
    border: 1px solid #005C53;
    color: white;
}

.circle {
    background-color: red;
    width: 10px;
    height: 10px;
    border-radius: 50%;
    position: absolute;
    top: -10%;
    left: -10%;
    transform: translate(-50%, -50%);
    z-index: -1;
    filter: blur(6px);
    transition: all 3s;
}

.register {
    color: #0281F6
}

.rectangle {
  background-color: #347355;
  padding: 20px;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
  width: 100%; /* Ancho del 100% de la página */
  /* box-sizing: border-box; */ /* Asegura que el padding se incluya en el ancho */
}

.rectangle2 {
  background-color: #FFFFFF;
  padding: 20px;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
  width: 80%; /* Ancho del 100% de la página */
  /* box-sizing: border-box; */ /* Asegura que el padding se incluya en el ancho */
  /* overflow: auto; */
}

.more {
  position: absolute;
  bottom: 600px; /* Puedes ajustar esta posición según sea necesario */
  background-color: #fff; /* Color de fondo de los botones */
  color: black;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  left: 300px; /* Alinea el botón a la izquierda */

}

.more1 {
  position: absolute;
  bottom: 600px; /* Puedes ajustar esta posición según sea necesario */
  background-color: #fff; /* Color de fondo de los botones */
  color: black;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  right: 300px; /* Alinea el botón a la derecha */
}
.app-name {
  font-size: 14px; /* Ajusta el tamaño de fuente según sea necesario */
  color: #ffffff; /* Color de texto */
  word-wrap: break-word; /* Permite que el texto se divida en líneas si es necesario */
}

.card {
  background-color: #347355;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin-top: 80px;
}

.content {
  padding: 20px;
  color:black;
}

p {
  margin: 0; /* Elimina el margen predeterminado del párrafo */
}

</style>