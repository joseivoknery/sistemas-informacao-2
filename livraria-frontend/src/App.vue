<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Listar Livros</router-link> |
      <router-link to="/cadastro-livro">Cadastrar Livro</router-link> |
      <router-link to="/listar-editoras">Listar Editoras</router-link> |
      <router-link to="/cadastro-editora">Cadastrar Editora</router-link> |
      <router-link to="/sobre">Sobre</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  background-color: #5e7377;
  text-align: center;
  padding-right: 25px;
  margin-right: 90px;
  margin-left: 90px;
}

#nav {
  padding: 30px;
  font-size: large;
}

#nav a {
  font-weight: bold;
  color: #3a3e3d;
}

#nav a.router-link-exact-active {
  color: #ffffff;
}
</style>
