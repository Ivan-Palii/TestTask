<script setup></script>
<template>
  <header class="header">
    <div class="header__container">
      <span class="header__logo">Logo</span>

      <nav class="header__navigation navigation">
        <ul class="navigation__list">
          <li class="navigation__item navigation__item_active">
            <a href="#">nav1</a>
          </li>
          <li class="navigation__item">
            <a href="#">nav2</a>
          </li>
          <li class="navigation__item">
            <a href="#">nav3</a>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>
<style scoped lang="scss">
.header {
  background-color: #d9d9d9;
  font-family: 'Montserrat', sans-serif;
  text-transform: uppercase;

  // .header__container
  &__container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 100px;
  }

  // .header__logo
  &__logo {
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    font-size: 25px;
    font-weight: 500;
    display: inline-block;
    padding: 0 45px;
  }

  // .header__navigation
  &__navigation {
  }
}

.navigation {
  // .navigation__list
  &__list {
    display: flex;
  }

  // .navigation__item
  &__item {
    font-weight: 700;
    display: block;
    width: 120px;
    text-align: center;
    transition: color 0.3s;

    // .navigation__item_active
    // .navigation__item:hover
    &_active,
    &:hover {
      color: #f00;
    }
  }
}
</style>
