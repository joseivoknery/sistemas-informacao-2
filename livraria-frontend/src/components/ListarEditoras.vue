<template>
  <div class="pesquisar">
    <div class="header">
      <div class="col-md-2">
        <button
          v-on:click="listarTodos()"
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

    <div class="box" v-for="(editora, index) in editoras" :key="index">
      <div class="back">
        <div class="col-mr-11">
          <h4 class="book">Editora: {{ editora.id }}</h4>
        </div>
        <div class="col-mr-1">
          <button
            v-on:click="remover_editora(editora.id)"
            type="button"
            class="btn btn-outline-secondary btn-sm"
            id="BUTTON_EXCLUIR"
          >
            Excluir
          </button>
        </div>
      </div>
      <div class="form-row text-left">
        <div class="col-md-5">
          <span>Nome : {{ editora.nomeEditora }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const axios = require("axios");

export default {
  name: "ListarEditoras",
  data() {
    return { editoras: [], mensagem: "" };
  },
  methods: {
    listarTodos() {
      if (this.editoras.length === 0) {
        axios.get("http://localhost:8080/editoras").then(response => {
          response.data.map(e => {
            this.editoras.push(e);
          });
        });
      }
    },

    remover_editora(id) {
      axios.delete("http://localhost:8080/editoras/" + id).then(response => {
        this.mensagem = response.data;
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

.book {
  margin-right: 1rem;
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
}
</style>
