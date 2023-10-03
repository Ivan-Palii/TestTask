<script setup>
defineProps({
  item: {
    type: Object,
    required: true,
  },
});
</script>
<template>
  <div class="item" :id="item.key">
    <div class="item__text-content">
      <h3 class="item__title">{{ item.title }}</h3>
      <h4 class="item__subtitle">{{ item.subtitle }}</h4>
      <p class="item__text" v-html="item.text"></p>
      <NuxtLink :to="item.buttonLink" rel="" class="item__btn btn">{{
        item.buttonText
      }}</NuxtLink>
    </div>
    <div class="item__img-wrapper">
      <img :src="item.image" :alt="item.imageAltAtr" class="item__img" />
    </div>
  </div>
</template>
<style scoped lang="scss">
.item {
  display: flex;
  justify-content: space-between;
  &:not(:last-child) {
    margin-bottom: 100px;
  }
  &:nth-child(odd) {
    flex-direction: row-reverse;
  }
  // .item__text-content
  &__text-content {
    max-width: 455px;
  }

  // .item__title
  &__title {
    font-weight: 700;
    font-family: "Montserrat", sans-serif;
    text-transform: uppercase;
    margin-bottom: 20px;
  }

  // .item__subtitle
  &__subtitle {
    font-weight: 500;
    font-family: "Montserrat", sans-serif;
    margin-bottom: 20px;
  }

  // .item__text
  &__text {
    font-family: "Montserrat", sans-serif;
    line-height: 145%;
    margin-bottom: 40px;
  }

  // .item__btn
  &__btn {
  }

  // .item__img-wrapper
  &__img-wrapper {
    max-width: 475px;
  }

  // .item__img
  &__img {
    object-fit: fill;
  }
}
</style>
