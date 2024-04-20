<template>
  <div class="main-conteiner">
      <div class="background-container"> 
        <img src="../images/mundo.svg" alt="mundo">
        <Navbar />
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
        <ListCard title1="Tareas de Emergencias inscritas" description1="Lorem Ipsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de psum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lopsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lopsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lopsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lopsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lopsum es mente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galeríagresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de LoLorem Ipsum." title2="TAREAS" description2="aloooooooooooodnsnijnijb">
            Contenido de la primera tarjeta.
        </ListCard>
        <main></main>
        
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
//import axios from "axios";

import SideMenu from '@/components/SideMenu.vue';
import ListCard from '@/components/ListCard.vue';
import Footer  from '@/components/Footer.vue';

export default {
  components: {
    ListCard
  },
  data() {
    return {
      backendData: null
    };
  },
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