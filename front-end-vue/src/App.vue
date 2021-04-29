<template>
  <div>
    <!-----INÍCIO DA NAVBAR----->
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand order-md-last">Hepta - Front-end - Vue.js [William_Brito]</a>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link class="nav-link" to="/">Criar novo funcionario</router-link>
           </li>
         </ul>
         <ul class="navbar-nav mr-auto">
          <li class="nav-item">
           <router-link class="nav-link" to="/listar-funcionarios">Listar funcionarios</router-link>
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
