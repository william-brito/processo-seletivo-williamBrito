<template>
  <div class="container">
    <div class="card">
      <div card="card-header">
        <h3>Editar Funcionario</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="atualizarFuncionarioForm()">
          <!---- INICIO DO BLOCO: Nome do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome do Funcionario</label>
            <input
              type="text"
              id="NOME_FUNCIONARIO"
              name="nNome"
              placeholder="Digite o Nome do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_FUNCIONARIO"
            />
          </div>
          <!---- FIM DO BLOCO: Nome do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Setor do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Setor</label>
            <input
              type="text"
              id="NOME_SETOR"
              name="nSetor"
              placeholder="Digite o Setor do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_SETOR"
            />
          </div>
          <!---- FIM DO BLOCO: Setor do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Salário do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Salario</label>
            <input
              type="number"
              id="NU_SALARIO"
              name="nSalario"
              placeholder="Digite o Salario do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_SALARIO"
            />
          </div>
          <!---- FIM DO BLOCO: Salário do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Email do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Email</label>
            <input
              type="text"
              id="DS_EMAIL"
              name="nEmail"
              placeholder="Digite o Email do Funcionario"
              class="form-control"
              v-model="funcionarioForm.DS_EMAIL"
            />
          </div>
          <!---- FIM DO BLOCO: Email do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Idade</label>
            <input
              type="number"
              id="NU_IDADE"
              name="nIdade"
              placeholder="Digite a Idade do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_IDADE"
            />
          </div>
          <!---- FIM DO BLOCO: Idade do Funcionário ---->
         <div class="form-group">
            <button @click="atualizarFuncionario" class="btn btn-primary">
              <font-awesome-icon :icon="['fas', 'user-plus']" /> Atualizar</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import FuncionarioService from '../../../services/FuncionarioService';

export default {
  name: 'EditarFuncionarioComponent',
  data() {
    return {
      funcionarioForm: {},
    };
  },
  methods: {
    async funcionarioPeloId() {
      const { id } = this.$route.params;
      const response = await FuncionarioService.getFuncionarioId(id);
      this.funcionarioForm = { ...response };
    },
    async atualizarFuncionarioForm() {
      await FuncionarioService.atualizarFuncionarioId(this.funcionarioForm);
      this.$swal({
        title: 'Funcionario atualizado com sucesso!',
        icon: 'success',
        showConfirmButton: true,
        allowOutsideClick: false,
        allowEnterKey: true,
        allowEscapeKey: false,
      }).then((data) => {
        this.$router.push({
          name: 'listarFuncionarios',
        });
      });
    },
  },
};
</script>
