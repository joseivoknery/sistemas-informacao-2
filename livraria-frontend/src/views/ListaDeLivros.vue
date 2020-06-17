<template>
  <div class="home">
    <ListarLivros />
    <br />
  </div>
</template>

<script>
import ListarLivros from "@/components/ListarLivros.vue";
//import ListarLivros from "../components/VisualizarLivro.vue";

export default {
  name: "ListaDeLivros",
  components: {
    ListarLivros
  }
};
</script>
