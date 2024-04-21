<template>
  <div class="main-conteiner">
      <div class="background-container"> 
        <img src="../images/mundo.svg" alt="mundo">
        <NavbarVoluntario  @change-component="changeComponent" />
        <!-- Mostrar ListCard si mostrarListCard es verdadero -->
    <!-- <ListCard v-if="mostrarListCard" /> -->

<!-- Mostrar ListCard2 si mostrarListCard es falso -->

        <div id="app">
          <side-menu></side-menu>
          <router-view></router-view>
        </div>
        <!-- <ListCard title1="Tarea de emergencias inscritas"
            v-if="backendData"
            :title2="backendData.title2"
            :description1="backendData.description"
          >
            Contenido de la tarjeta.
          </ListCard> -->
        <!-- Mostrar ComponenteA si mostrarComponenteA es verdadero -->
        <!-- <ListCard v-if="mostrarComponenteA" /> -->

        <!-- Mostrar ComponenteB si mostrarComponenteA es falso -->
        <!-- <ListCard2 v-else /> -->
        <ListCard v-if="mostrarListCard"
        title1 = "Tareas de Emergencias inscritas"
        :description1="[
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'En proceso'},
            {text1:'Recoger escombros',text2:'Incendio en Valparaíso', buttonLabel:'En proceso'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Terminada'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Terminada'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Terminada'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'En pausa'}]"
        title2= "TAREAS"
        :description2="[
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Postular'},
            {text1:'Recoger escombros',text2:'Incendio en Valparaíso', buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'},
            {text1:'Primeros Auxilios',text2:'Incencio en Valparaíso' ,buttonLabel:'Aceptar'}]">
        </ListCard>
        <ListCard2 v-else />
        <main></main>

        
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
//import axios from "axios";

import SideMenu from '@/components/SideMenu.vue';
import ListCard from '@/components/ListCard.vue';
import ListCard2 from '@/components/ListCard2.vue';
import NavbarVoluntario from '@/components/NavbarVoluntario.vue';
import Footer  from '@/components/Footer.vue';

export default {

  components: {
    ListCard,
    ListCard2
  },
  data() {
    return {
      backendData: null,
      mostrarComponenteA: true ,// Mostrar ListCard por defecto// Mostrar ComponenteA por defecto
      mostrarListCard: true 
    };
  },
  methods:{
    toggleComponent() {
      // Cambia el estado para mostrar el componente contrario
      this.mostrarComponenteA = !this.mostrarComponenteA;
    },
    changeComponent(value) {
      this.mostrarListCard = value;
    }
  }
  /* mounted() {
    // Realiza la solicitud HTTP al backend para obtener los datos
    axios.get("URL_DEL_BACKEND")
      .then(response => {
        // Asigna los datos recibidos a la variable backendData
        this.backendData = response.data;
      })
      .catch(error => {
        console.error("Error al obtener los datos del backend:", error);
      });
  } */
};


</script>

<style>

.main-container {
  position: relative;
  overflow: hidden;
}

.background-container {
  position: relative;
  /* overflow: hidden; */
  
}
body {
  margin: 0;
  color: black;
  background-color: rgb(255, 255, 255);
  font-family: 'Roboto', sans-serif;
}



img {
  width: 100%;
  height: 100vh;
  position: absolute;
  z-index: -5;
  object-fit: cover;
  filter: brightness(0.25) invert(1);
  background-repeat: repeat-y;
}

.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
}
</style>