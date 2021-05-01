import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('../components/pages/home/homeComponent'),
  },
  {
    path: '/criar-funcionario',
    name: 'criarFuncionario',
    component: () => import('../components/pages/criar-funcionario/CriarFuncionarioComponent'),
  },
  {
    path: '/listar-funcionarios',
    name: 'listarFuncionarios',
    component: () => import('../components/pages/listar-funcionario/ListarFuncionarioComponent'),
  },
  {
    path: '/editar-funcionario/:id',
    name: 'editarFuncionario',
    component: () => import('../components/pages/editar-funcionario/EditarFuncionarioComponent'),
  },
  {
    path: '/criar-setor',
    name: 'criarSetor',
    component: () => import('../components/pages/criar-setor/CriarSetorComponent'),
  },
  {
    path: '/listar-setores',
    name: 'listarSetores',
    component: () => import('../components/pages/listar-setor/ListarSetorComponent'),
  },
  {
    path: '/editar-setor/:id',
    name: 'editarSetores',
    component: () => import('../components/pages/editar-setor/EditarSetorComponent'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
