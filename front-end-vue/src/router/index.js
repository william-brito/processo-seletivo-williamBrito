import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Criar Novo Funcionário',
    component: () => import('../components/pages/criar-funcionario/CriarFuncionarioComponent'),
  },
  {
    path: '/listar-funcionarios',
    name: 'Listar todos os funcionários',
    component: () => import('../components/pages/listar-funcionario/ListarFuncionarioComponent'),
  },
  {
    path: '/editar-funcionario/:id',
    name: 'Editar funcionário',
    component: () => import('../components/pages/editar-funcionario/EditarFuncionarioComponent'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
