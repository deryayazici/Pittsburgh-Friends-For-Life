<template>
  <section>
    <div class="donate-page">
      <div class="Donate Button">
        <form
          action="https://www.paypal.com/donate"
          method="post"
          target="_top"
        >
          <h2 class="paypal-title">Donate Money!</h2>
          <input type="hidden" name="business" value="HYFWDZJZGRKLA" />
          <input type="hidden" name="no_recurring" value="0" />
          <input type="hidden" name="currency_code" value="USD" />
          <input
            type="image"
            src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif"
            border="0"
            name="submit"
            title="PayPal - The safer, easier way to pay online!"
            alt="Donate with PayPal button"
          />
        </form>
        <div class="donate-stuff">
          <form class="form-donate-stuff">
            <h2 class="donate-title">Donate Stuff</h2>
            <input
              class="donate-control"
              type="text"
              placeholder="first name"
            />
            <input class="donate-control" type="text" placeholder="last name" />
            <textarea
              class="donate-control"
              placeholder="description of items to donate..."
              name="description"
              id=""
              cols="30"
              rows="10"
            >
            </textarea>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {};
</script>

<style>
/*--clr-1: #ff8ba7;
  --clr-2: #3cf157;
  --clr-3: #fbfbbb; */
.Donate {
  display: flex;
  justify-content: center;
  gap: 8rem;
}
.paypal-title,
.donate-title {
  color: #3cf157;
  margin-bottom: 1.5rem;
}
.donate-title {
  text-align: center;
  margin-bottom: 1rem;
  border-bottom: 2px solid #ff8ba7;
}
.donate-page {
  width: 90vw;
  margin: 0 auto;
  /* background-color: red; */
}
.form-donate-stuff {
  padding: 20px 30px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 2px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
  max-width: 400px;
  margin-bottom: 3rem;
}
.donate-control {
  display: block;
  margin: 0.5rem;
  padding: 5px;
  font-family: inherit;
  border-radius: 8px;
  border: 2px solid #ccc;
  width: 100%;
}
.donate-control:focus {
  outline: 0;
  border-color: #ff8ba7;
}
</style>
