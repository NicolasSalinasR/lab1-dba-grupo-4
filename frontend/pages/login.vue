<template>
    <main>
        <div class="containerLogin">
            <h1>Login</h1>
            <form @submit.prevent="login" class="formLogin">
                <input type="text" v-model="email" placeholder="Email">
                <input type="password" v-model="password" placeholder="Password">
                <button type="submit">Login</button>
            </form>
        </div>
    </main>

</template>

<script>
</script>

<style>
body {
    background-color: green;
    margin: 0;
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
</style>