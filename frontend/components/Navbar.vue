<template>
    <nav>
        <div class="menu">
            <!-- menu desplegable -->
            <ul>
                <li><a href="#">Inicio</a></li>
                <li><a href="#">Servicios</a></li>
                <li><a href="#">Contacto</a></li>
            </ul>
        </div>
    </nav>
</template>

<script>
</script>

<style>
nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 5%;
    background-color: rgba(255, 255, 255, 0.7);
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.logo img {
    width: 100px;
}

.menu ul {
    display: flex;
    list-style: none;
}

.menu ul li {
    margin-right: 20px;
}

.menu ul li a {
    text-decoration: none;
    color: #333;
}
</style>