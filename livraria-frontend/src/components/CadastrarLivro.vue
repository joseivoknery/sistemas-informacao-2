<template>
  <div class="form">
    <form action="submit">
      <div class="form-group"></div>
      <div class="form row">
        <div class="col-md-1">
          <span>Titulo do Livro:</span>
        </div>
        <div class="col-md-11">
          <input
            v-model="titulo"
            type="text"
            class="form-control"
            placeholder="Titulo do Livro"
          />
          <label v-if="tituloReq" id="required"
            >O Titulo do Livro é requerido!</label
          >
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-1">
          <span>Editora:</span>
        </div>

        <div>
          <b-form-select
            v-model="idEditora"
            :options="editoras"
          ></b-form-select>
        </div>

        <div class="col-md-1">
          <span>Número de Paginas:</span>
        </div>
        <div class="col-md-4">
          <input
            v-model="numeroPaginas"
            type="text"
            class="form-control"
            placeholder="Número de Páginas"
            id="num_pagina"
          />
          <label v-if="paginasReq" id="required"
            >O Número de Páginas é Requerido</label
          >
        </div>
      </div>
      <div class="form-row">
        <div class="col-md-2">
          <button
            v-on:click="cadastrar_livro()"
            type="button"
            class="form-control btn btn-dark"
            id="BUTTON_CADASTRAR"
          >
            Cadastrar
          </button>

          <div class="col-md-1">
            <h4>{{ mensagem }}</h4>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
const axios = require("axios");

export default {
  name: "Cadastrar",
  data() {
    axios.get("http://localhost:8080/editoras").then(response => {
      response.data.map(e => {
        this.editoras.push({
          value: e.id,
          text: e.nomeEditora
        });
      });
    });

    return {
      titulo: "",
      idEditora: 0,
      editoras: [],
      numeroPaginas: "",
      tituloReq: false,
      editoraReq: false,
      paginasReq: false,
      sucess: false,
      mensagem: ""
    };
  },
  methods: {
    cadastrar_livro() {
      if (this.titulo && this.idEditora && this.numeroPaginas) {
        let livro = {
          titulo: this.titulo,
          idEditora: this.idEditora,
          numeroPaginas: this.numeroPaginas
        };

        axios.post("http://localhost:8080/livros", livro).then(response => {
          if (response.status === 200) {
            this.mensagem = "Livro Cadastrado com Sucesso";
          } else {
            this.mensagem = "O livro não foi Cadastrado";
          }
        });

        this.titulo = "";
        this.idEditora = 0;
        this.numeroPaginas = "";
        this.titutoReq = false;
        this.editoraReq = false;
        this.paginasReq = false;
        this.sucess = true;
      } else {
        this.sucess = false;
        this.tituloReq = false;
        this.editoraReq = false;
        this.paginasReq = false;
        if (!this.titulo) {
          this.tituloReq = true;
        }
        if (!this.idEditora) {
          this.editoraReq = true;
        }
        if (!this.numeroPaginas) {
          this.paginasReq = true;
        }
      }
    }
  }
};
</script>

<style>
div {
  margin-top: 0.3rem;
}

#num_pagina {
  margin-top: 11px;
}

#BUTTON_CADASTRAR {
  background-color: lightseagreen;
  margin-left: 97px;
  margin-top: 11px;
}

#required {
  color: red;
}
</style>
