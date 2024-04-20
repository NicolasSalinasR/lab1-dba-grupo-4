<template>
    <div class="container">
      <div class="column">
        <div class="card">
          <div class="card-header">
            {{ title1 }}
          </div>
          <div class="card-body">
            {{ description1 }}
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card">
          <div class="card-header">
            {{ title2 }}
          </div>
          <div class="card-body">
            {{ description2 }}
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      title1: {
        type: String,
        required: true
      },
      description1:{
        type: String,
        required:true
      },
      title2:{
        type: String,
        required:true
      },
      description2:{
        type: String,
        required:true
      }
    }
  };
  </script>
  
  <style>
  .container {
    display: flex;
    align-items: stretch; /* Asegura que todas las tarjetas tengan la misma altura y se extiendan según sea necesario */
  }
  
  .column {
    flex: 1;
    display: flex;
    justify-content: center;
    padding: 0 10px; /* Añade un poco de espacio entre las columnas */
  }
  
  .card {
    width: 100%;
    max-width: 400px;
    border: 1px solid #ccc;
    border-radius: 8px;
    overflow: hidden;
    margin-bottom: 20px;
    background-color: #fcfcfc;
  }
  
  .card-header {
    background-color: #347355;
    padding: 10px;
    font-weight: bold;
    color:#FFFFFF
  }
  
  .card-body {
    padding: 10px;
    background-color: #fcfcfc;
  }
  </style>
  