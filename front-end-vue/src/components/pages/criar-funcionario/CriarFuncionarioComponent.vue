<template>
<div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Criar novo funcionario</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="handleSubmitForm">
          <!---- INÍCIO DO BLOCO: Nome do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Nome</label>
            <input
              type="text"
              id="idNome"
              name="nNome"
              placeholder="Digite o Nome do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_FUNCIONARIO"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NOME_FUNCIONARIO.required"
            >O Campo "Nome do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Nome do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Setor do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Setor</label>
            <input
              type="text"
              id="idSetor"
              name="nSetor"
              placeholder="Digite o Setor do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NOME_SETOR"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NOME_SETOR.required"
            >O Campo "Setor do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Setor do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Salário do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Salario</label>
            <input
              type="number"
              id="idSalario"
              name="nSalario"
              placeholder="Digite o Salario do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_SALARIO"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NU_SALARIO.required"
            >O Campo "Salario do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Salário do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Email do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Email</label>
            <input
              type="text"
              id="idEmail"
              name="nEmail"
              placeholder="Digite o Email do Funcionario"
              class="form-control"
              v-model="funcionarioForm.DS_EMAIL"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.DS_EMAIL.required"
            >O Campo "Email do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Email do Funcionário ---->
          <!---- INÍCIO DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <label class="font-weight-bold">Idade</label>
            <input
              type="number"
              id="idIdade"
              name="nIdade"
              placeholder="Digite a Idade do Funcionario"
              class="form-control"
              v-model="funcionarioForm.NU_IDADE"
              :class="{'is-invalid': isSubmitted && $v.funcionarioForm.$error}"
            />
            <div
              v-if="isSubmitted && !$v.funcionarioForm.NU_IDADE.required"
            >O Campo "Idade do Funcionario" nao pode ficar em branco!</div>
          </div>
          <!---- FIM DO BLOCO: Idade do Funcionário ---->
          <div class="form-group">
            <button class="btn btn-primary">
              <font-awesome-icon :icon="['fas', 'user-plus']" /> Funcionario
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
  </template>
<script>
import { required } from 'vuelidate/lib/validators';

export default {
  data() {
    return {
      funcionarioForm: {
        NOME_FUNCIONARIO: '',
        NOME_SETOR: '',
        NU_SALARIO: '',
        DS_EMAIL: '',
        NU_IDADE: '',
      },
      isSubmitted: false,
    };
  },
  validations: {
    funcionarioForm: {
      NOME_FUNCIONARIO: {
        required,
      },
      NOME_SETOR: {
        required,
      },
      NU_SALARIO: {
        required,
      },
      DS_EMAIL: {
        required,
      },
      NU_IDADE: {
        required,
      },
    },
  },
  methods: {
    handleSubmitForm() {
      this.isSubmitted = true;
      this.$v.$touch();
      if (this.$v.invalid) {
        return;
      }
    },
  },
};
</script>
