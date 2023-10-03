<script setup>
import { onMounted, ref } from "vue";

const data = ref(null);
const items = ref([]);
const slides = ref([]);

onMounted(async () => {
  data.value = await useFetch(
    "https://voicenter-test-api.voicenter-ltd.workers.dev/api/site-data"
  );

  data.value = JSON.parse(JSON.stringify(data.value.data.data.siteData));
  data.value = data.value[Object.keys(data.value)[0]];

  //items for second section
  items.value = JSON.parse(data.value.testTaskSecondDescriptiveBlockItems);

  //slides for slider
  slides.value = JSON.parse(data.value.testTaskSlidesBlockSlides);

  console.log(slides.value);
  // console.log(data.value);
});
</script>
<template>
  <main v-if="data === null" class="main" />
  <main v-else class="main">
    <section class="main__header-section header-section">
      <div class="header-section__container">
        <div class="header-section__text-content">
          <h1 class="header-section__title">
            {{ data["testTaskHeaderTitle"] }}
          </h1>
          <h2 class="header-section__subtitle">
            {{ data["testTaskHeaderSubtitle"] }}
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
          {{ data["testTaskSecondBlockTitle"] }}
        </h2>
        <div class="content-section__content">
          <div class="content-section__navigation-container">
            <nav class="content-section__navigation">
              <h3 class="content-section__navigation-title">
                {{ data["testTaskSecondBlockSideNavigationTitle"] }}
              </h3>
              <ul class="content-section__navigation-list">
                <li
                  class="content-section__navigation-item"
                  v-for="item in items"
                  :key="item['key']"
                  :class="{
                    'content-section__navigation-item_active':
                      useRoute().hash === '#' + item['key'],
                  }"
                >
                  <a :href="'#' + item['key']">{{ item["name"] }}</a>
                </li>
              </ul>
            </nav>
          </div>
          <div class="content-section__items-container">
            <ContentSectionItem
              v-for="item in items"
              :key="item.key"
              :item="item"
              class="content-section__item"
            />
          </div>
        </div>
      </div>
    </section>
    <section class="main__slider-section slider-section">
      <div class="slider-section__container">
        <h2 class="slider-section__title section-title">
          {{ data["testTaskSlidesBlockTitle"] }}
        </h2>
        <div class="slider-section__slider-container">
          <Swiper
            :modules="[SwiperPagination, SwiperNavigation]"
            :slides-per-view="1"
            :loop="false"
            :creative-effect="{
            prev: {
              shadow: false,
              translate: ['-20%', 0, -1],
            },
            next: {
              translate: ['100%', 0, 0],
            },
          }"
            :pagination="{
            clickable: true,
          }"
            :navigation="{
            enabled: true,
            prevEl: '.swiper-btn-prev',
            nextEl: '.swiper-btn-next',
            disabledClass: 'swiper-btn-disabled'
          }"
          >
            <SwiperSlide
              v-for="slide in slides"
              :key="slide['key']"
            >
              <div class="slide">
                <div class="slide__text-content">
                  <h2 class="slide__title section-title">{{ slide.title }}</h2>
                  <h3 class="slide__subtitle">{{ slide.subtitle }}</h3>
                  <p
                    class="slide__text"
                    v-html="slide.description"
                  ></p>
                  <NuxtLink
                    :to="slide.buttonLink"
                    rel=""
                    class="slide__btn btn"
                  >{{ slide.buttonText }}
                  </NuxtLink
                  >
                </div>
                <div class="slide__img-wrapper">
                  <img
                    :src="slide.image"
                    alt=""
                  />
                </div>
              </div>
            </SwiperSlide>

          </Swiper>
          <div class="swiper-btn-prev"></div>
          <div class="swiper-btn-next"></div>
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
  // .main__content-section
  &__content-section {
  }
  // .main__slider-section
  &__slider-section {
  }
}

.section-title {
  font-weight: 700;
  font-size: 20px;
  font-family: "Montserrat", sans-serif;
  text-align: center;
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
    font-family: "Montserrat", sans-serif;
  }

  // .header-section__subtitle
  &__subtitle {
    font-weight: 500;
    font-size: 20px;
    margin-bottom: 14px;
    max-width: 365px;
    font-family: "Inter", sans-serif;
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

.content-section {
  // .content-section__container
  &__container {
  }

  // .content-section__title
  &__title {
    margin: 30px auto 50px;
  }

  // .content-section__content
  &__content {
    display: flex;
  }

  // .content-section__navigation-container
  &__navigation-container {
    flex: 0 0 170px;
  }

  // .content-section__navigation
  &__navigation {
    position: sticky;
    top: 50px;
  }

  // .content-section__navigation-title
  &__navigation-title {
    font-family: "Montserrat", sans-serif;
    font-weight: 700;
    margin-bottom: 40px;
  }

  // .content-section__navigation-list
  &__navigation-list {
    display: flex;
    flex-direction: column;
    row-gap: 12px;
  }

  // .content-section__navigation-item
  &__navigation-item {
    transition: color 0.3s;
    &:hover,
    &_active {
      color: red;
    }
  }

  // .content-section__items-container
  &__items-container {
    flex: 1 1 auto;
  }

  // .content-section__item
  &__item {
  }
}

.slider-section {
  // .slider-section__container
  &__container {
  }

  // .slider-section__title
  &__title {
    margin-top: 80px;
    margin-bottom: 20px;
  }

  // .slider-section__slider-container
  &__slider-container{
    position: relative;
  }
}

.swiper {
  margin-bottom: 100px;
  max-width: 1120px;
}

.slide {
  display: flex;
  justify-content: space-between;

  margin: 0 auto;
  // .slide__text-content
  &__text-content {
    flex: 0 0 500px;
  }

  // .slide__title
  &__title {
    text-align: start;
    margin-top: 50px;
    margin-bottom: 24px;
  }

  // .slide__subtitle
  &__subtitle {
    font-size: 20px;
    line-height: 145%;
    font-family: "Montserrat", sans-serif;
    margin-bottom: 24px;
  }

  // .slide__text
  &__text {
    font-size: 20px;
    font-weight: 700;
    font-family: "Montserrat", sans-serif;
    margin-bottom: 24px;
  }

  // .slide__btn
  &__btn {
  }

  // .slide__img-wrapper
  &__img-wrapper {
    padding-left: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

.swiper-btn-prev,
.swiper-btn-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  z-index: 10;
  cursor: pointer;
  width: 24px;
  height: 20px;
  &:before,
  &:after{
    content: '';
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
  }

  &:before{
    width: 24px;
    height: 3px;
    background-color: #000;
  }

  &:after{
    border: #000 solid;
  }
}
.swiper-btn-prev {
  left: 10px;
  &:after{
    height: 18px;
    width: 18px;
    transform: translateY(-50%) rotate(-135deg);
    border-width: 3px 3px 0 0;
  }
}
.swiper-btn-next {
  right: 10px;
  &:after{
    right: 0;
    height: 18px;
    width: 18px;
    transform: translateY(-50%) rotate(45deg);
    border-width: 3px 3px 0 0;
  }
}

.swiper-btn-disabled{
  cursor: auto;
  &:before{
    background-color: #CCCCCC;
  }
  &:after{
    border-color: #CCCCCC;
  }
}
</style>
