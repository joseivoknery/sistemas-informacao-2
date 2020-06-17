<template>
  <div class="form">
    <form action="submit">
      <div class="form-group"></div>
      <div class="form row">
        <div class="col-md-1">
          <span>Nome da Editora:</span>
        </div>
        <div class="col-md-11">
          <input
            v-model="nomeEditora"
            type="text"
            class="form-control"
            placeholder="Nome da Editora"
          />
          <label v-if="nomeEditoraReq" id="required"
            >O Nome da Editora é requerido!</label
          >
        </div>
      </div>

      <div class="form-row">
        <div class="col-md-2">
          <button
            v-on:click="cadastrar_editora()"
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
    return {
      nomeEditora: "",
      nomeEditoraReq: false,
      sucess: false,
      mensagem: ""
    };
  },
  methods: {
    cadastrar_editora() {
      if (this.nomeEditora) {
        let editora = {
          nomeEditora: this.nomeEditora
        };

        axios.post("http://localhost:8080/editoras", editora).then(response => {
          if (response.status === 200) {
            this.mensagem = "Editora Cadastrada com Sucesso";
          } else {
            this.mensagem = "A Editora não foi Cadastrada";
          }
        });

        this.nomeEditora = "";
        this.nomeEditoraReq = false;
        this.sucess = true;
      } else {
        this.sucess = false;
        this.nomeEditoraReq = false;
        if (!this.nomeEditora) {
          this.nomeEditoraReq = true;
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
