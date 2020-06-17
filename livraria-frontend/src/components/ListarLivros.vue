<template>
  <div class="pesquisar">
    <div class="header">
      <div class="col-md-2">
        <button
          v-on:click.stop.prevent="listarTodos()"
          type="button"
          class="form-control btn btn-dark"
        >
          Pesquisar
        </button>
      </div>

      <div class="col-md-2" id="msg">
        <h4>{{ mensagem }}</h4>
      </div>
    </div>

    <div class="box" v-for="(livro, index) in livros" :key="index">
      <div class="back">
        <div class="col-mr-11">
          <h4 class="book">Livro: {{ livro.titulo }}</h4>
        </div>

        <div class="col-mr-1">
          <button
            v-on:click="remover_livro(livro.id)"
            type="button"
            class="btn btn-outline-secondary btn-sm"
            id="BUTTON_EXCLUIR"
          >
            Excluir
          </button>
        </div>
      </div>

      <div class="form-row text-left" id="book">
        <!-- <Modal v-if="viewer" v-on:close="viewer = false" /> -->
        <div class="col-md-5" v-if="book != null">
          <span><strong>Titulo</strong> : {{ livro.titulo }}</span>
        </div>
        <div class="col-md-5 text-left">
          <span><strong>Editora</strong> : {{ livro.editora }}</span>
        </div>
        <div class="col-md-5 text-left">
          <span><strong>Núm. Páginas</strong> : {{ livro.numeroPaginas }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import Modal from "../components/VisualizarLivro";

const axios = require("axios");

export default {
  components: {
    //Modal
  },
  updated() {
    this.$eventHub.$emit("showBook", this.book);
  },
  name: "ListarLivros",
  data() {
    return {
      livros: [],
      mensagem: "",
      viewer: false,
      book: {
        titulo: "",
        editora: "",
        numeroPaginas: ""
      }
    };
  },
  methods: {
    listarTodos() {
      if (this.livros.length === 0) {
        axios.get("http://localhost:8080/livros").then(response => {
          response.data.map(e => {
            this.livros.push(e);
          });
        });
      }
    },

    remover_livro(id) {
      axios.delete("http://localhost:8080/livros/" + id).then(response => {
        this.mensagem = response.data;
      });
    },

    exibir_livro(id) {
      axios.get("http://localhost:8080/livros/" + id).then(response => {
        this.viewer = true;
        this.book = response.data;
      });
    }
  }
};
</script>

<style scoped>
.futura {
  color: whitesmoke;
  font-size: 3rem;
  font-family: Penguin;
}

.header {
  align-items: baseline;
}

#msg {
  color: greenyellow;
}

.box {
  font-size: 0.9rem;
  border-bottom: 0.01rem solid gray;
  margin-top: 0.8rem;
}

#book {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  color: aliceblue;
}

#BUTTON_VISUALIZAR {
  color: black;
  background-color: orange;
}

#BUTTON_EXCLUIR {
  color: black;
  background-color: red;
}

.back {
  background: rgb(230, 230, 230);
  border: 0.4rem solid transparent;
  margin-right: -25px;
  display: flex;
  flex-direction: row;
  place-content: space-evenly;
}
</style>
