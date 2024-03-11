<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: #0d423d;
            color: #0d423d;;
            max-width: 800px;
            font-family: "Roboto", "Helvetica Neue", sans-serif;
            margin:0 auto;
        }

        .container {
            color: black;
            padding: 0 4rem;
        }

        .title-section{
            min-height: 200px;
            max-height: 200px;
            width: 100%;
            border-radius: 3rem 0 0 0;
            margin-bottom: 2rem;
            box-shadow: 10px 10px 31px -5px rgba(0,0,0,1);
            background-color: #FF0266 ;
            position: relative;
        }

        .title-section h1 {
            line-height: 4rem;
            letter-spacing: .1rem;
            font-size: 4rem;
            max-width: 100%;
            color: #fff7e2;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -25px;
            margin-left: -60px;
        }

        .title-section h2 {
            line-height: 4rem;
            letter-spacing: .1rem;
            font-size: 1.7rem;
            max-width: 100%;
            text-align: center;
            color: #0d423d;
            margin-bottom: -3rem;
        }

        .main-sections {
            max-width: 100%;
            border-radius: 3rem 0 0 0;
            margin-bottom: 2rem;
            box-shadow: 10px 10px 31px -5px rgba(0,0,0,1);
            background: linear-gradient(180deg, rgba(5,34,31,1) 30%, rgba(13,66,61,1) 100%);
            padding: 2rem;
        }

        .content-section {
            min-height: 350px;
            max-width: 100%;
            background-color: transparent;
            padding: 1rem 4rem;
            color: #fff7e2;
            text-align: center;
            font-size: 1.2rem;
        }

        .content-section h3 {
            padding-bottom: 5rem;
        }


        .image-section{
            min-height: 350px;
            max-width: 100%;
            background-color: transparent;
            padding: 2rem 1rem;
            border-radius: 0 0 3rem 0;
            border-top: solid #0d423d 1px;
            text-align: center;
            margin: 0 auto;
            position: relative;
        }


        .final-main-section {
            border-radius: 0 0 3rem 0;
            margin-bottom: 2rem;
        }

        .to-uppercase {
            text-transform: uppercase;

        }

        .btn-confirmation {
            max-width: 200px;
            background-color: #2f86d8 !important;
            color: white !important;
            padding: 1rem;
            border: none;
            border-radius: .5rem;
            box-shadow: 5px 5px 15px -5px rgba(0,0,0,1);
            text-decoration: none;
        }

        .btn-confirmation:hover {
            cursor: pointer;
        }

        .btn-confirmation:active {
            background-color: #3699f6 !important;
        }

        .logo {
            padding: 4rem 4rem;
            width: 33.3%;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -175px;
            margin-left: -175px;
        }

        .logo img {
            margin-top: 1rem;
            width: 150px;
        }

        #title {
            display: block;
            text-align: center;
            padding-top: 1rem;
            font-size: 2rem;
            color: #fff7e2;
        }

</style>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <div class="container">
            <section class="title-section">
                <h1>Olá, ${username}!</h1>
            </section>
    
            <div class="main-sections final-main-section">
                <section class="content-section">
                    <h3>Para ativar a sua conta, clique no botão abaixo:</h3>
                    <a class="to-uppercase btn-confirmation" href="http://localhost:4200/password-recovery" target="_blank">Confirmar email</a>
                </section>
        
                <section class="image-section">
                    <section class="logo">
                        <img src="cid:logo.png" alt="">
                        <span id="title" >P E R S O N A</span>
                    </section>
                </section>
            </div>
        </div>
    
    </main>

</body>
</html>
