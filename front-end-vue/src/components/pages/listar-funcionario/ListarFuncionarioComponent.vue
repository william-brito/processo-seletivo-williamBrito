<template>
  <div class="row justify-content-center">
    <h3 class="text-center">Listagem de Funcionarios</h3>
    <table class="table tavle-striped">
      <thead>
        <tr>
          <th class="text-center">Nome do Funcionario</th>
          <th class="text-center">Nome do Setor</th>
          <th class="text-center">Salario</th>
          <th class="text-center">Email</th>
          <th class="text-center">idade</th>
          <th class="text-center">Acoes</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="funcionario in funcionariosListagem" :key="funcionario.ID_FUNCIONARIO">
          <td>{{funcionario.NOME_FUNCIONARIO}}</td>
          <td>{{funcionario.NOME_SETOR}}</td>
          <td>{{funcionario.NU_SALARIO}}</td>
          <td>{{funcionario.DS_EMAIL}}</td>
          <td>
            <router-link to=
            "{ name: 'editarFuncionario', params: { id: funcionario.ID_FUNCIONARIO }}" class=
            "btn btn-success">
              <font-awesome-icon :icon="['fas', 'user-edit']" /> Editar
            </router-link>
          </td>
          <td>
            <button @click="excluirFuncionario(funcionario.ID_FUNCIONARIO)" class="btn btn-danger">
             <font-awesome-icon :icon="['fas', 'trash']" /> Deletar
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import FuncionarioService from '../../../services/FuncionarioService';

export default {
  name: 'ListarFuncionarioComponent',
  data() {
    return {
      funcionariosListagem: [],
    };
  },
  mounted() {
    this.listarTodosOsFuncionarios();
  },
  methods: {
    async listarTodosOsFuncionarios() {
      const response = await FuncionarioService.getFuncionarios();
      this.funcionariosListagem = response;
    },
    async excluirFuncionario(id) {
      await FuncionarioService.deletarFuncionarioId(id);
      this.$swal({
        title: 'Voce tem certeza que deseja exclui esse funcionario?',
        text: 'Atencao! Esse funcionario sera excluído do sistema!',
        icon: 'warning',
        showConfirmButton: true,
        allowOutsideClick: false,
        allowEnterKey: true,
        allowEscapeKey: false,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim! Delete, por favor!',
      }).then(async (result) => {
        if (result.value) {
          await FuncionarioService.deletarFuncionarioId(id);
          this.$swal('Excluido', 'Deletado com sucesso!', 'success');
          this.listarTodosOsFuncionarios();
        } else {
          this.$swal('Cancelado', 'Exclusao cancelada', 'info');
        }
      });
    },
  },
};
</script>
