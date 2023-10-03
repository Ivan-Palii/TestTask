<script setup>
import MainPage from "~/pages/MainPage.vue";
</script>
<template>
  <div class="wrapper">
    <TheHeader />
    <MainPage />
    <TheFooter />
  </div>
</template>
<style lang="scss">
.wrapper {
  min-height: 100%;
  display: flex;
  flex-direction: column;
  & > .main {
    flex: 1 1 auto;
  }
}
</style>
