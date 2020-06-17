<template>
  <div class="apresentacao">
    <div>
      <h1>Projeto Frontend de uma Livraria em Vue.Js</h1>
      <h2>Sistemas de Informação 2 - Professor Genilson</h2>
      <h2>José Ivo Koerich Nery - 182.308.00-07</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "Apresentacao",
  props: {
    msg: String
  }
};
</script>

<style scoped>
h1 {
  font-family: Penguin;
  color: whitesmoke;
}
</style>
