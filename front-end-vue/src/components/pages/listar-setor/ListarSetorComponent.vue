<template>
  <div class="row justify-content-center">
    <h3 class="text-center">Listagem de Setores</h3>
    <table class="table tavle-striped">
      <thead>
        <tr>
          <th class="text-center">Nome do Setor</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="setor in setoresListagem" :key="setor.ID_SETOR">
          <td>{{setor.NOME_SETOR}}</td>
          <td>
            <router-link to=
            "{ name: 'editarSetor', params: { id: setor.ID_SETOR }}" class=
            "btn btn-success">
              <font-awesome-icon :icon="['fas', 'user-edit']" /> Editar
            </router-link>
          </td>
          <td>
            <button @click="excluirSetor(setor.ID_SETOR)" class="btn btn-danger">
             <font-awesome-icon :icon="['fas', 'trash']" /> Deletar
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import SetorService from '../../../services/SetorService';

export default {
  name: 'ListarSetorComponent',
  data() {
    return {
      setoresListagem: [],
    };
  },
  mounted() {
    this.listarTodosOsSetores();
  },
  methods: {
    async listarTodosOsSetores() {
      const response = await SetorService.getSetores();
      this.setoresListagem = response;
    },
    async excluirSetor(id) {
      await SetorService.deletarSetorId(id);
      this.$swal({
        title: 'Voce tem certeza que deseja exclui esse setor?',
        text: 'Atencao! Esse setor sera excluído do sistema! (Antes, veja se há algum funcionário relacionado a esse setor)',
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
          await SetorService.deletarSetorId(id);
          this.$swal('Excluido', 'Deletado com sucesso!', 'success');
          this.listarTodosOsSetores();
        } else {
          this.$swal('Cancelado', 'Exclusao cancelada', 'info');
        }
      });
    },
  },
};
</script>
