/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
    width:{
      '110':'28vw'
    },
    boxShadow:{
      'custom1':'0px 10px 10px #1b2336'
    }
    },
  },
  plugins: [],
}