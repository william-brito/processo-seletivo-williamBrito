<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Editar setor</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="atualizarSetorForm()">
          <!---- INÍCIO DO BLOCO: Nome do Setor ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome do Setor</label>
            <input
              type="text"
              id="NOME_SETOR"
              name="idNomeSetor"
              placeholder="Digite o Nome do Setor"
              class="form-control"
              v-model="setorForm.NOME_SETOR"
            />
          </div>
          <!---- FIM DO BLOCO: Nome do Setor ---->
          <div class="form-group">
            <button type="button" @click="atualizarSetor" class="btn btn-primary">
              <font-awesome-icon :icon="['fas', 'user-plus']" />Setor
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import SetorService from '../../../services/SetorService';

export default {
  name: 'EditarSetorComponent',
  data() {
    return {
      setorForm: {},
    };
  },
  methods: {
    async setorPeloId() {
      const { id } = this.$route.params;
      const response = await SetorService.getSetorId(id);
      this.setorForm = { ...response };
    },
    async atualizarSetorForm() {
      await SetorService.getSetorId(this.setorForm);
      this.$swal({
        title: 'Setor atualizado com sucesso!',
        icon: 'success',
        showConfirmButton: true,
        allowOutsideClick: false,
        allowEnterKey: true,
        allowEscapeKey: false,
      }).then((data) => {
        this.$router.push({
          name: 'listarSetores',
        });
      });
    },
  },
};
</script>
