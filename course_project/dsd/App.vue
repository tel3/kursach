<template>
  <div id="app">
  	<header>
		<h1>We Know</h1>
		<h2>Encyclopedia of TES: Skyrim guides</h1>
	</header>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@font-face 
{
	font-family: DBfont;
	src: url(./assets/fonts/vineritc.ttf);
}

body {
	background-image: url("../backgrounds/another-rough-old-and-worn-parchment-paper.png");
	background-repeat: no-repeat;
	background-size: 100%, 100%;
	background-attachment: fixed;
	font-family: sans-serif;
	font-size: 12pt;
}

@media screen and (device-width: 1920px) {
	body {
		background-size: 1920px, 1080px;
		font-family: sans-serif;
	}
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
</style>
