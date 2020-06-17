import Vue from "vue";
import VueRouter from "vue-router";
import About from "../views/About.vue";
import CadastroEditora from "../views/CadastroEditora.vue";
import CadastroLivro from "../views/CadastroLivro.vue";
import ListaDeEditoras from "../views/ListaDeEditoras.vue";
import ListaDeLivros from "../views/ListaDeLivros.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Lista De Livros",
    component: ListaDeLivros
  },
  {
    path: "/sobre",
    name: "Sobre",
    component: About
  },
  {
    path: "/cadastro-livro",
    name: "Cadastro Livro",
    component: CadastroLivro
  },
  {
    path: "/cadastro-editora",
    name: "Cadastro Editora",
    component: CadastroEditora
  },
  {
    path: "/listar-editoras",
    name: "Lista De Editoras",
    component: ListaDeEditoras
  }
];

const router = new VueRouter({
  routes
});

export default router;
