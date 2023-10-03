<script setup></script>
<template>
  <footer class="footer">
    <div class="footer__container">
      <div class="footer__contacts-container">
        <span class="footer__contacts">contacts</span>
      </div>
      <div class="footer__links-container">
        <span class="footer__links">social Links</span>
      </div>
    </div>
  </footer>
</template>
<style scoped lang="scss">
.footer {
  font-family: 'Montserrat', sans-serif;
  background-color: #d9d9d9;
  text-align: center;
  // .footer__container
  &__container {
    height: 100px;
    display: grid;
    grid-template-columns: 20% 20% 20% 20% 20%;
  }

  // .footer__contacts-container
  &__contacts-container {
    grid-column-start: 1;
  }

  // .footer__links-container
  &__links-container {
    grid-column-start: 3;
  }

  // .footer__contacts-container
  // .footer__links-container
  &__contacts-container,
  &__links-container {
    display: flex;
    align-items: center;
    justify-content: center;
  }

  // .footer__contacts
  // .footer__links
  &__contacts,
  &__links {
    font-size: 20px;
    font-weight: 700;
    cursor: pointer;
    transition: color 0.3s;

    &:hover {
      color: #f00;
    }
  }
}
</style>
