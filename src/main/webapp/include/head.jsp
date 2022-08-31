
<title>HitTastic</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
    @import url('https://fonts.googleapis.com/css2?family=Lato:wght@400;700&family=Open+Sans:wght@400;700&display=swap');

    * {
      box-sizing: border-box;
    }

    html {
      font-family: 'Open Sans', 'Lato', sans-serif;
    }

    body {
      margin: 0;
    }

    h1,
    h2,
    h3 {
      font-family: 'Lato', sans-serif;
      font-weight: bold;
    }

    nav a {
      margin-right: 15px;
    }

    #main-navigation {
      width: 100%;
      height: 5rem;
      display: flex;
      justify-content: right;
      align-items: center;
      padding: 0 10%;
      position: absolute;
      top: 0;
      left: 0;
    }

    #main-navigation a {
      text-decoration: none;
      color: white;
      font-weight: bold;
    }

    #main-navigation a:hover,
    #main-navigation a:active {
      color: #cf79f1;
    }

    #main-navigation h1 a:hover,
    #main-navigation h1 a:active {
      color: white;
    }

    #main-navigation img {
      width: 6rem;
      height: 6rem;
      object-fit: cover;
      object-position: top;
      border: 2px solid white;
      border-radius: 8px;
      background-color: #ffe1bf;
      transform: rotateZ(-5deg);
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.25);
      margin-top: 25px;
    }
    #welcome {
      background: linear-gradient(to right top, #6305dd, #390281);
      padding: 6rem 12%;
    }

    #welcome header {
      display: flex;
      align-items: flex-start;
      margin: 3rem auto;
    }

    #welcome h2 {
      font-size: 3.5rem;
      margin: 0 0 0 2rem;
      color: #e4e4e4;
      width: 10rem;
    }

    #welcome p {
      color: white;
      font-size: 1.5rem;
    }

    main {
      width: 90%;
      max-width: 90rem;
      margin: 3rem auto;
      background-color: white;
      padding: 1rem;
      border-radius: 12px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.25);
    }

    .main {
      background-color: #f7f7f7;
      padding: 1rem 6rem;
      -webkit-box-flex: 1;
      -ms-flex: 1;
      flex: 1;
      position: relative;
      margin-top: -5rem;
    }

</style>
