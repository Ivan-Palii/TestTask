<script setup>
defineProps({
  item: {
    type: Object,
    required: true,
  },
})
</script>
<template>
  <div class="item" :id="item.key">
    {{ item }}
    <div class="item__text-content">
      <h3 class="item__title">{{ item.title }}</h3>
      <h4 class="item__subtitle">{{ item.subtitle }}</h4>
      <p class="item__text" v-html="item.text"></p>
      <NuxtLink :to="item.buttonLink" rel="" class="item__btn btn">{{
        item.buttonText
      }}</NuxtLink>
      <NuxtLink to="https://github.com/nuxt" no-rel>
        Nuxt GitHub
      </NuxtLink>
    </div>
    <div class="item__img-wrapper">
      <img :src="item.image" :alt="item.imageAltAtr" class="item__img" />
    </div>
  </div>
</template>
<style scoped lang="scss"></style>
