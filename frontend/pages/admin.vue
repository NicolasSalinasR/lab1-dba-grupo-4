<template>

    <img src="../images/mundo.svg" alt="mundo">
    <Navbar />
    <main></main>

</template>

<script>


</script>

<style>
body {
    margin: 0;
    color: black;
    background-color: black;
    font-family: 'Roboto', sans-serif;
}



img {
    width: 100%;
    height: 100vh;
    position: absolute;
    z-index: -5;
    object-fit: cover;
    filter: brightness(0.25) invert(1);
}
</style>