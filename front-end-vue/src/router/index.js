import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'criarFuncionario',
    component: () => import('../components/pages/criar-funcionario/CriarFuncionarioComponent'),
  },
  {
    path: '/listar-funcionarios',
    component: () => import('../components/pages/listar-funcionario/ListarFuncionarioComponent'),
  },
  {
    path: '/editar-funcionario/:id',
    name: 'editarFuncionario',
    component: () => import('../components/pages/editar-funcionario/EditarFuncionarioComponent'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
