<template>
  <div>
    <!-----INÍCIO DA NAVBAR----->
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand order-md-last">Hepta - Front-end - Vue.js [William_Brito]</a>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link class="nav-link" to="/">Inicio</router-link>
           </li>
         </ul>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link class="nav-link" to="/criar-funcionario">
            Criar novo funcionario</router-link>
           </li>
         </ul>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
           <router-link class="nav-link" to="/listar-funcionarios">Listar funcionarios</router-link>
           </li>
         </ul>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link class="nav-link" to="/criar-setor">
            Criar novo setor</router-link>
           </li>
         </ul>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
           <router-link class="nav-link" to="/listar-setores">Listar setores</router-link>
           </li>
         </ul>
      </div>
    </nav>
     <!-----FIM DA NAVBAR----->
    <div class="container mt-5">
  <router-view/>
    </div>
  </div>
  </template>
