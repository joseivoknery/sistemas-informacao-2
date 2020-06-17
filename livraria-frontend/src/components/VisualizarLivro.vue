<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div id="modalBody">
            <div class="col-md-5" v-if="book != null">
              <span><strong>Titulo</strong> : {{ book.titulo }}</span>
            </div>
            <div class="col-md-5 text-left">
              <span><strong>Editora</strong> : {{ book.editora }}</span>
            </div>
            <div class="col-md-5 text-left">
              <span
                ><strong>Núm. Páginas</strong> : {{ book.numeroPaginas }}</span
              >
            </div>
            <button class="modal-default-button" @click="$emit('close')">
              OK
            </button>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "modal",

  created() {
    this.$eventHub.$on("showBook", data => {
      this.book = {
        titulo: data.titulo,
        editora: data.editora,
        numeroPaginas: data.numeroPaginas
      };
    });
  },
  data() {
    return {
      book: {
        titulo: "",
        editora: "",
        numeroPaginas: ""
      }
    };
  }
};
</script>

<style scoped>
#modalBody {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
}
</style>
