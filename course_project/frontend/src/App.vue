<template>
  <div id="app">
    <header>
      <h1>We Know</h1>
      <h2>Encyclopedia of TES: Skyrim guides</h2>
    </header>
    <top-button-component
      v-bind:status="false"
      role="guest"
    ></top-button-component>
    <router-view/>
  </div>

</template>

<script>
import TopButtonComponent from './components/elements/TopButtonComponent'

export default {
  name: 'App',
  components: {
    'top-button-component': TopButtonComponent
  }
}
</script>

<style>
@font-face
{
  font-family: DBfont;
  src: url(./assets/fonts/vineritc.ttf);
}

body {
  background-image: url("./assets/bg/background-image.png");
  background-repeat: no-repeat;
  background-size: 2560px, 1440px;
  background-attachment: fixed;
  font-family: sans-serif;
  font-size: 12pt;
}

h1 {
  font-family: DBfont, arial;
  text-align: center;
  font-size: 70pt;
  font-weight: bold;
  margin-top: 30px;
  margin-bottom: -10px;
}

h2 {
  font-family: DBfont, arial;
  font-size: 26pt;
  text-align: center;
  margin-top: 0px;
}

@media screen and (max-width: 2559px) {
  body {
    background-repeat:no-repeat;
    background-size:cover;
    background-position:center;
    font-family: sans-serif;
  }
}

@media screen and (max-width: 1218px) {
  body {
    background-image: url(./assets/bg/background-mobile.jpg);
    background-repeat:no-repeat;
    background-size:cover;
    background-position:center;
  }
}
</style>
