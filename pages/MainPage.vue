<script setup>
import { onMounted, ref } from 'vue'
import axios from 'axios'

const data = ref(null)
const items = ref([])

onMounted(async () => {
  data.value = await axios.get(
    'https://voicenter-test-api.voicenter-ltd.workers.dev/api/site-data'
  )

  data.value = JSON.parse(JSON.stringify(data.value.data.data.siteData))
  data.value = data.value[Object.keys(data.value)[0]]

  // console.log(JSON.parse())
  // console.log(data.value)
  console.log(data.value.testTaskSecondDescriptiveBlockItems)
  items.value = JSON.parse(data.value.testTaskSecondDescriptiveBlockItems)
})
</script>
<template>
  <main v-if="data === null" class="main" />
  <main v-else class="main">
    <section class="main__header-section header-section">
      <div class="header-section__container">
        <div class="header-section__text-content">
          <h1 class="header-section__title">
            {{ data['testTaskHeaderTitle'] }}
          </h1>
          <h2 class="header-section__subtitle">
            {{ data['testTaskHeaderSubtitle'] }}
          </h2>
          <p
            class="header-section__text"
            v-html="data['testTaskHeaderText']"
          ></p>
          <button class="header-section__btn btn">Read More</button>
        </div>
        <div class="header-section__image-wrapper">
          <img
            :src="data['testTaskHeaderImage']"
            :alt="data['testTaskHeaderImageAltText']"
            class="header-section__img"
          />
        </div>
      </div>
    </section>
    <section class="main__content-section content-section">
      <div class="content-section__container">
        <h2 class="content-section__title section-title">
          {{ data['testTaskSecondBlockTitle'] }}
        </h2>
        <div class="content-section__content">
          <div class="content-section__navigation"></div>
          <div
            class="content-section__items-container"
            v-for="item in items"
            :key="item.key"
          >
            <ContentSectionItem :item="item" class="content-section__item" />
          </div>
        </div>
      </div>
    </section>
  </main>
</template>
<style scoped lang="scss">
.main {
  // .main__header-section
  &__header-section {
  }
}

.header-section {
  background-color: #eeeeee;

  // .header-section__container
  &__container {
    display: flex;
    justify-content: space-between;
    padding-top: 44px;
    padding-bottom: 78px;
  }

  // .header-section__text-content
  &__text-content {
  }

  // .header-section__title
  &__title {
    font-weight: 500;
    font-size: 25px;
    margin: 24px 0 14px;
    font-family: 'Montserrat', sans-serif;
  }

  // .header-section__subtitle
  &__subtitle {
    font-weight: 500;
    font-size: 20px;
    margin-bottom: 14px;
    max-width: 365px;
    font-family: 'Inter', sans-serif;
  }

  // .header-section__text
  &__text {
    max-width: 570px;
    margin-bottom: 54px;
  }

  // .header-section__btn
  &__btn {
  }

  // .header-section__image-wrapper
  &__image-wrapper {
  }

  // .header-section__img
  &__img {
  }
}
</style>
